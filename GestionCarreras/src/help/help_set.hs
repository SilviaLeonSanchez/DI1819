<helpset version="1.0">
   <title>Gestión Carreras</title>
   <maps>
      <!-- Pagina por defecto al mostrar la ayuda -->
      <homeID>aplicacion</homeID>
      <!-- Que mapa deseamos -->
      <mapref location="map_file.jhm"/>
   </maps>

   <!-- Las Vistas que deseamos mostrar en la ayuda -->
   <!-- La tabla de contenidos -->
   <view>
      <name>Tabla Contenidos</name>
      <label>Tabla de contenidos</label>
      <type>javax.help.TOCView</type>
      <data>toc.xml</data>
   </view>

   <!-- La pestana de busqueda -->
   <view>
      <name>Buscar</name>
      <label>Buscar</label>
      <type>javax.help.SearchView</type>
      <data engine="com.sun.java.help.search.DefaultSearchEngine">
         JavaHelpSearch
      </data>
   </view>

</helpset>
