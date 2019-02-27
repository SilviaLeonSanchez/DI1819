
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
  createShortCut "$SMPROGRAMS\Desinstalar.lnk" "$INSTDIR\uninstall.exe" 
  createShortCut "$SMPROGRAMS\Instalar.lnk" "$INSTDIR\install.exe" 
  
  # Grabar los archivos necesarios
  File informes.jar
  File /r lib
  File /r informes

  
# Fin de la seccion
SectionEnd

# Seccion del desintalador
section "uninstall"
 
    # Borrar el desintalador primero
    delete "$INSTDIR\uninstall.exe"
    delete "$INSTDIR\install.exe"

    # Borrar los archivos 
    delete "$INSTDIR\informes.jar"
    delete /r "$INSTDIR\informes"
    RmDir "$INSTDIR\informes"
    delete /r "$INSTDIR\lib"
    RmDir "$INSTDIR\lib"

    # Borrar el directorio
    RmDir "$INSTDIR"

    # Borrar los accesos directos
    delete "$SMPROGRAMS\Desinstalar.lnk"
    delete "$SMPROGRAMS\Instalar.lnk"
 
# Fin de la seccion del desinstalador
sectionEnd
