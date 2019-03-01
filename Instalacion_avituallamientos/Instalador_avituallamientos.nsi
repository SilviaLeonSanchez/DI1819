###############################
# Instalador Avituallamientos #
###############################

	#Incluir UI moderna
	!include "MUI2.nsh"

	#Alertamos al usuario cuando pulsa el botón cancelar y pedir confirmación
	!define mui_abortwarning

	#Definimos el valor de la variable VERSION
	!define VERSION "1.0"

	#Paginas instalador
	!insertmacro MUI_PAGE_WELCOME 
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

	Name "Avituallamientos de Avituallamientos"
	Caption "Avituallamientos de Avituallamientos ${VERSION} Setup"

	#Icon icono.ico

	#Comprobacion de integridad del fichero activada
	CRCCheck on

	#Pedimos permisos para acceder a $PROGRAMFILES
	RequestExecutionLevel admin

	#Directorio por defecto
	InstallDir $DESKTOP

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
		SetOutPath $INSTDIR\AplicacionAvituallamientos
		  
		# Grabar los archivos necesarios
		File Proyecto_Avituallamientos.exe

		# Creamos el desinstalador
		WriteUninstaller "$INSTDIR\AplicacionAvituallamientos\uninstall.exe"
		  
		# Crear accesos directos
		CreateDirectory "$SMPROGRAMS\AplicacionAvituallamientos"
		CreateShortCut "$SMPROGRAMS\AplicacionAvituallamientos\DesinstalarAvituallamientos.lnk" "$INSTDIR\AplicacionAvituallamientos\uninstall.exe" 
		CreateShortCut "$SMPROGRAMS\AplicacionAvituallamientos\Avituallamientos.lnk" "$INSTDIR\AplicacionAvituallamientos\Proyecto_Avituallamientos.exe" 
		CreateShortCut "$DESKTOP\Avituallamientos.lnk" "$INSTDIR\AplicacionAvituallamientos\Proyecto_Avituallamientos.exe" 
		  
		#Añadimos información para que salga en el menú de desinstalar de Windows
		WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Avituallamientos" \
					   "DisplayName" "Avituallamientos"
		WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Avituallamientos" \
					   "Publisher" "Silvia - Desarrollo Interfaces"
		WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Avituallamientos" \
					   "UninstallString" "$\"$INSTDIR\AplicacionAvituallamientos\uninstall.exe$\""
	  
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
    Delete "$INSTDIR\Proyecto_Avituallamientos.exe"

    # Borrar el directorio 
    RMDir "$INSTDIR\..\AplicacionAvituallamientos"

    # Borrar los accesos directos
	Delete "$DESKTOP\Avituallamientos.lnk"
    Delete "$SMPROGRAMS\AplicacionAvituallamientos\DesinstalarAvituallamientos.lnk"
    Delete "$SMPROGRAMS\AplicacionAvituallamientos\Avituallamientos.lnk"
	RMDir "$SMPROGRAMS\AplicacionAvituallamientos"
 
    #Borramos la entrada del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Avituallamientos"
 
# Fin de la seccion del desinstalador
SectionEnd