#################################
# Ejemplo de instalador NSIS
#################################

#--------------------------------
#Include Modern UI

  !include "MUI.nsh"

#--------------------------------
#Con esta opción alertamos al usuario cuando pulsa el botón cancelar y le pedimos confirmación para abortar
#la instalación
#Esta macro debe colocarse en esta posición del script sino no funcionara
  !define mui_abortwarning

#Definimos el valor de la variable VERSION, en caso de no definirse en el script
#podria ser definida en el compilador
!define VERSION "1.0"

#--------------------------------
#Pages

  #Mostramos la página de bienvenida 
  !insertmacro MUI_PAGE_WELCOME 
  #Página donde mostramos el contrato de licencia 
  !insertmacro MUI_PAGE_LICENSE "licencia.txt" 
  #página donde se muestran las distintas secciones definidas 
  !insertmacro MUI_PAGE_COMPONENTS 
  #página donde se selecciona el directorio donde instalar nuestra aplicacion 
  !insertmacro MUI_PAGE_DIRECTORY 
  #página de instalación de ficheros 
  !insertmacro MUI_PAGE_INSTFILES 
  #página final
  !insertmacro MUI_PAGE_FINISH

#páginas referentes al desinstalador
!insertmacro MUI_UNPAGE_WELCOME
!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES
!insertmacro MUI_UNPAGE_FINISH

#--------------------------------
#Languages

!insertmacro MUI_LANGUAGE "Spanish"

# Para generar instaladores en diferentes idiomas podemos escribir lo siguiente:
#  !insertmacro MUI_LANGUAGE ${LANGUAGE}
# De esta forma pasando la variable LANGUAGE al compilador podremos generar
#paquetes en distintos idiomas sin cambiar el script

#########################
# Configuración General #
#########################
#Nuestro instalador se llamara si la versión fuera la 1.0: Ejemplo-1.0-win32.exe
OutFile Ejemplo-${VERSION}.exe

#Aquí comprobamos que en la versión Inglesa se muestra correctamente el mensaje:
#Welcome to the $Name Setup Wizard
#Al tener reservado un espacio fijo para este mensaje, y al ser
#la frase en español mas larga:
# Bienvenido al Asistente de Instalación de Aplicación $Name
# no se ve el contenido de la variable $Name si el tamaño es muy grande
Name "Adictos"
Caption "Adictos ${VERSION} para Win32 Setup"

#Icon icono.ico

#Comprobacion de integridad del fichero activada
CRCCheck on
#Estilos visuales del XP activados
XPStyle on

/*
        Declaracion de variables a usar

*/
# también comprobamos los distintos
# tipos de comentarios que nos permite este lenguaje de script

Var PATH
Var PATH_ACCESO_DIRECTO
#Indicamos cual será el directorio por defecto donde instalaremos nuestra
#aplicación, el usuario puede cambiar este valor en tiempo de ejecución.
InstallDir "$PROGRAMFILES\MiAplicacion"

# check if the program has already been installed, if so, take this dir
# as install dir
InstallDirRegKey HKLM SOFTWARE\ADICTOS "Install_Dir"
#Mensaje que mostraremos para indicarle al usuario que seleccione un directorio
DirText "Elija un directorio donde instalar la aplicación:"
#Indicamos que cuando la instalación se complete no se cierre el instalador automáticamente
AutoCloseWindow false
#Mostramos todos los detalles del la instalación al usuario.
ShowInstDetails show
#En caso de encontrarse los ficheros se sobreescriben
SetOverwrite on
#Optimizamos nuestro paquete en tiempo de compilación, es altamente recomendable habilitar siempre esta opción
SetDatablockOptimize on
#Habilitamos la compresión de nuestro instalador
SetCompress auto
#Personalizamos el mensaje de desinstalación
UninstallText "Este es el desinstalador del Ejemplo."


#######################################################################
# Install settings                                                    #
# En esta sección añadimos los ficheros que forman nuestra aplicación #
#######################################################################

Section "Programa"
StrCpy $PATH "ADICTOS"
StrCpy $PATH_ACCESO_DIRECTO "_ADICTOS_"
SetOutPath $INSTDIR\$PATH

#Incluimos todos los ficheros que componen nuestra aplicación
File   ejemplo.exe
File   licencia.html
File   config.ini
File   *.txt

#Hacemos que la instalación se realice para todos los usuarios del sistema
SetShellVarContext all
#Creamos los directorios, acesos directos y claves del registro que queramos...
	CreateDirectory "$SMPROGRAMS\$PATH_ACCESO_DIRECTO"
        CreateShortCut "$SMPROGRAMS\$PATH_ACCESO_DIRECTO\Ejemplo.lnk" \
                       "$INSTDIR\ejemplo.exe" "--parametros parametro1"
        CreateShortCut "$SMPROGRAMS\$PATH_ACCESO_DIRECTO\Licencia.lnk" \
                       "$INSTDIR\licencia.html"

#Creamos también el aceso directo al instalador
        CreateShortCut "$SMPROGRAMS\$PATH_ACCESO_DIRECTO\Desinstalar.lnk" \
                       "$INSTDIR\uninstall.exe"

        WriteRegStr HKLM \
            SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\$PATH \
            "DisplayName" "Aplicación para Adictos al Trabajo ${VERSION}"
        WriteRegStr HKLM \
            SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\$PATH \
            "UninstallString" '"$INSTDIR\uninstall.exe"'
        WriteUninstaller "uninstall.exe"

        WriteRegStr HKLM SOFTWARE\$PATH "InstallDir" $INSTDIR
       
        WriteRegStr HKLM SOFTWARE\$PATH "Version" "${VERSION}"
        #Mostramos el
directorio donde se crearon los acesos directos
	Exec "explorer $SMPROGRAMS\$PATH_ACCESO_DIRECTO\"
SectionEnd


Section "Ayuda"
        SetOutPath $INSTDIR\$PATH
        StrCpy $PATH "ADICTOS"
        StrCpy $PATH_ACCESO_DIRECTO "_ADICTOS_"
#Estos directorios han de contener algún fichero, sino el compilador
#dara el error: File: "ayuda" -> no files found.
#En caso de querer que nuestra aplicación se creen directorios vacios una opción
#es crear un fichero dummy.txt
        File /r ayuda
SectionEnd

Section "Skins"
        SetOutPath $INSTDIR\$PATH
        StrCpy $PATH "ADICTOS"
        StrCpy $PATH_ACCESO_DIRECTO "_ADICTOS_"
        File  /r skins
SectionEnd

Section "Plugins"
        SetOutPath $INSTDIR\$PATH
        StrCpy $PATH "ADICTOS"
        StrCpy $PATH_ACCESO_DIRECTO "_ADICTOS_"
        File   /r plugins
SectionEnd

######################
# Uninstall settings #
######################

Section "Uninstall"
        StrCpy $PATH "ADICTOS"
        StrCpy $PATH_ACCESO_DIRECTO "_ADICTOS_"
        SetShellVarContext all
        RMDir /r $SMPROGRAMS\$PATH_ACCESO_DIRECTO
        RMDir /r $INSTDIR\$PATH
        RMDir /r $INSTDIR
        DeleteRegKey HKLM SOFTWARE\$PATH
        DeleteRegKey HKLM \
            Software\Microsoft\Windows\CurrentVersion\Uninstall\$PATH
SectionEnd