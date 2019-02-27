
# Nombre del instalador
Name "Instalador de informes de carreras"

# Nombre del ejecutable 
OutFile "install.exe"

# La ruta de instalacion por defecto
InstallDir $PROGRAMFILES\Informes

# Pedimos permisos para Windows 7
RequestExecutionLevel admin

# Pantallas que hay que mostrar del instalador
Page directory
Page instfiles

# Cambiar el UI
!include "MUI2.nsh"

#Cambiar el idioma (necesita la linea de arriba)
!insertmacro MUI_LANGUAGE "Spanish"

#Seccion principal
Section

  # Establecemos el directorio de salida al directorio de instalacion
  SetOutPath $INSTDIR
  
  # Creamos el desinstalador
  writeUninstaller "$INSTDIR\uninstall.exe"

  # Crear accesos directos
  CreateDirectory "$SMPROGRAMS\Informes"
  createShortCut "$SMPROGRAMS\Informes\Desinstalar.lnk" "$INSTDIR\uninstall.exe" 
  createShortCut "$SMPROGRAMS\Informes\Informes.lnk" "$INSTDIR\informes.jar" 
  
  # Grabar los archivos necesarios
  File informes.jar
  File /r lib
  File /r informes

  #Añadimos información para que salga en el menú de desinstalar de Windows
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes" \
                 "DisplayName" "Informes"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes" \
                 "Publisher" "Silvia - Desarrollo Interfaces"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes" \
                 "UninstallString" "$\"$INSTDIR\uninstall.exe$\""
  
# Fin de la seccion
SectionEnd

# Seccion del desintalador
section "uninstall"
 
    # Borrar el desintalador primero
    delete "$INSTDIR\uninstall.exe"
    delete "$INSTDIR\install.exe"

    # Borrar los archivos 
    delete "$INSTDIR\informes.jar"
    RmDir /r "$INSTDIR\informes"
    RmDir /r "$INSTDIR\lib"

    # Borrar el directorio
    RmDir "$INSTDIR"

    # Borrar los accesos directos
    delete "$SMPROGRAMS\Desinstalar.lnk"
    delete "$SMPROGRAMS\Informes.lnk"
 
    #Borramos la entrada del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Informes"
 
# Fin de la seccion del desinstalador
sectionEnd
