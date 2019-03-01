
# Nombre del instalador
Name "Instalador de informes de carreras"

# Nombre del ejecutable 
OutFile "install.exe"

# La ruta de instalacion por defecto
InstallDir $PROGRAMFILES\AplicacionInformes

# Pedimos permisos para acceder a $PROGRAMFILES
RequestExecutionLevel admin

# Pantallas que hay que mostrar del instalador
!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_LICENSE “licencia.txt”
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_PAGE_FINISH

# Cambiar el UI
!include "MUI2.nsh"

#Cambiar el idioma (necesita la linea de arriba)
!insertmacro MUI_LANGUAGE "Spanish"

#Seccion principal
Section

  # Establecemos el directorio de salida al directorio de instalacion
  SetOutPath $INSTDIR\AplicacionInformes
  
  # Grabar los archivos necesarios
  File informes.jar
  File licencia.txt
  File /r lib
  File /r informes

  # Creamos el desinstalador
  writeUninstaller "$INSTDIR\AplicacionInformes\uninstall.exe"
  
  # Crear accesos directos
  CreateDirectory "$SMPROGRAMS\AplicacionInformes"
  createShortCut "$SMPROGRAMS\AplicacionInformes\DesinstalarInformes.lnk" "$INSTDIR\AplicacionInformes\uninstall.exe" 
  createShortCut "$SMPROGRAMS\AplicacionInformes\Informes.lnk" "$INSTDIR\AplicacionInformes\informes.jar" 
  createShortCut "$DESKTOP\Informes.lnk" "$INSTDIR\AplicacionInformes\informes.jar" 
  

  #Añadimos información para que salga en el menú de desinstalar de Windows
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes" \
                 "DisplayName" "Informes"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes" \
                 "Publisher" "Silvia - Desarrollo Interfaces"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes" \
                 "UninstallString" "$\"$INSTDIR\AplicacionInformes\uninstall.exe$\""
  
# Fin de la seccion
SectionEnd

# Seccion del desintalador
section "uninstall"
 
    # Borrar el desintalador primero
    delete "$INSTDIR\AplicacionInformes\uninstall.exe"
    delete "$INSTDIR\AplicacionInformes\install.exe"

    # Borrar los archivos 
    delete "$INSTDIR\AplicacionInformes\informes.jar"
	delete "$INSTDIR\AplicacionInformes\licencia.txt"
    RmDir /r "$INSTDIR\AplicacionInformes\informes"
    RmDir /r "$INSTDIR\AplicacionInformes\lib"

    # Borrar el directorio 
    RmDir "$INSTDIR\AplicacionInformes"

    # Borrar los accesos directos
	delete "$DESKTOP\Informes.lnk"
    delete "$SMPROGRAMS\AplicacionInformes\DesinstalarInformes.lnk"
    delete "$SMPROGRAMS\AplicacionInformes\Informes.lnk"
	RmDir "$SMPROGRAMS\AplicacionInformes"
 
    #Borramos la entrada del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes"
 
# Fin de la seccion del desinstalador
sectionEnd
