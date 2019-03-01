#######################
# Instalador Informes #
#######################

	#Incluir UI moderna
	!include "MUI2.nsh"

	#Alertamos al usuario cuando pulsa el botón cancelar y pedir confirmación
	!define mui_abortwarning

	#Definimos el valor de la variable VERSION
	!define VERSION "1.0"

	#Paginas instalador
	!insertmacro MUI_PAGE_WELCOME 
	!insertmacro MUI_PAGE_LICENSE "licencia.txt" 
	!insertmacro MUI_PAGE_DIRECTORY 
	!insertmacro MUI_PAGE_INSTFILES 
	!insertmacro MUI_PAGE_FINISH

	#Paginas desinstalador
	!insertmacro MUI_UNPAGE_WELCOME
	!insertmacro MUI_UNPAGE_CONFIRM
	!insertmacro MUI_UNPAGE_INSTFILES
	!insertmacro MUI_UNPAGE_FINISH

	#Idiomas
	!insertmacro MUI_LANGUAGE "Spanish"


#########################
# Configuración General #
#########################

	#Nombre del instalador
	OutFile install.exe

	Name "Informes de Carreras"
	Caption "Informes de Carreras ${VERSION} Setup"

	#Icon icono.ico

	#Comprobacion de integridad del fichero activada
	CRCCheck on

	#Pedimos permisos para acceder a $PROGRAMFILES
	RequestExecutionLevel admin

	#Directorio por defecto
	InstallDir $PROGRAMFILES

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
	UninstallText "Se va a desinstalar el software del equipo."


################################
# Configuración de instalación #
################################

	# Seccion del intalador
	Section

		# Establecemos el directorio de salida al directorio de instalacion
		SetOutPath $INSTDIR\AplicacionInformes
		  
		# Grabar los archivos necesarios
		File informes.jar
		File licencia.txt
		File /r lib
		File /r informes

		# Creamos el desinstalador
		WriteUninstaller "$INSTDIR\AplicacionInformes\uninstall.exe"
		  
		# Crear accesos directos
		CreateDirectory "$SMPROGRAMS\AplicacionInformes"
		CreateShortCut "$SMPROGRAMS\AplicacionInformes\DesinstalarInformes.lnk" "$INSTDIR\AplicacionInformes\uninstall.exe" 
		CreateShortCut "$SMPROGRAMS\AplicacionInformes\Informes.lnk" "$INSTDIR\AplicacionInformes\informes.jar" 
		CreateShortCut "$DESKTOP\Informes.lnk" "$INSTDIR\AplicacionInformes\informes.jar" 
		  
		#Añadimos información para que salga en el menú de desinstalar de Windows
		WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes" \
					   "DisplayName" "Informes"
		WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes" \
					   "Publisher" "Silvia - Desarrollo Interfaces"
		WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes" \
					   "UninstallString" "$\"$INSTDIR\AplicacionInformes\uninstall.exe$\""
	  
	# Fin de la seccion
	SectionEnd




###################################
# Configuración de desinstalación #
###################################

# Seccion del desintalador
Section "uninstall"
 
    # Borrar el desintalador primero
    Delete "$INSTDIR\uninstall.exe"
    Delete "$INSTDIR\install.exe"

    # Borrar los archivos 
    Delete "$INSTDIR\informes.jar"
	Delete "$INSTDIR\licencia.txt"
    RMDir /r "$INSTDIR\informes"
    RMDir /r "$INSTDIR\lib"

    # Borrar el directorio 
    RMDir "$INSTDIR\..\AplicacionInformes"

    # Borrar los accesos directos
	Delete "$DESKTOP\Informes.lnk"
    Delete "$SMPROGRAMS\AplicacionInformes\DesinstalarInformes.lnk"
    Delete "$SMPROGRAMS\AplicacionInformes\Informes.lnk"
	RMDir "$SMPROGRAMS\AplicacionInformes"
 
    #Borramos la entrada del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes"
 
# Fin de la seccion del desinstalador
SectionEnd