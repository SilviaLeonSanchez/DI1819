   M S B A M L   `   `   `  ����  Proyecto_Avituallamientos=    7Proyecto_Avituallamientos.interfaz.VentanaNuevoMaterial   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  Nuevo Material��5   	   $��339.701��6    $��432.537��61    � 
ResizeMode$ NoResize=�6A   .��5      � $��0,0,0,0q�6   ��5   
   �� 5       �� EndPoint$ 0.5,1&�6"    �� 
StartPoint$ 0.5,0&�63   .��5      �  � Color$ Black��6    � Offset$ 0Q�6-   � 5	      $ White��6   $ 1Q�6-   � 5
      $ 	#FFABF0E6��6   5      .+�5   
   �� -   5         ��Name$ ButtonGuardarMaterial��5      ���	#FF032725$��Guardar��6I   $��143,231,145,0q�6[   $	��Top=�6r   $��14(�6�   $
��Bold"�6�    J� RenderTransformOrigin$ 0.494,0.483&�6�   $��29��6�   ��5      �� 5      $ 0,0.5&�6&   $ 1, 0.5&�67   .��5      � $ Black��6#   $ 0Q�61   � 5      $ White��6#   $ 1Q�61   � 5      $ 	#FFDADEDE��6#   5      5      � 5   
   $��	11,58,0,0q�6   $	��168��6"   $	��Top=�6/   $
��Left=�6G   $	��372��6b    � ColumnDefinitions 5      �� 5      .+�5      �� -   5        	 ��Name$	 LabelNombreMaterial��5      ���	#FF032725$��Nombre��6I   $��
0,15,236,0q�6Z   $��16(�6n   $��Right=�6|   $��31��6�   $	��Top=�6�   $��Right=�6�   $	��126��6�   �� 5      -   5        
 ��Name$
 TextBoxNombreMaterial��5      $��	0,14,10,0q�65    �� TextWrapping$
 Wrap=�6H   $��16(�6�   $��Center=�6�   $��31��6  $	��Top=�6!  $��Right=�69  $	��221��6U  ��6\   ��  �� Path$ nuevoMaterial.Nombre� �� NotifyOnValidationError .  �� ValidatesOnDataErrors . 6U  �� 5      -   5        $	 LabelTipoMaterial��5      ���	#FF032725$
��Tipo��6G   $��
0,64,236,0q�6V   $��16(�6j   $��Right=�6x   $��31��6�   $	��Top=�6�   $��Right=�6�   $	��126��6�   �� 5      -   5        $
 TextBoxPrecio��5      $��
0,112,10,0q�6-   $
 Wrap=�6A   $��16(�6�   $��Center=�6�   $��31��6  $	��Top=�6  $��Right=�62  $	��221��6N  ��6U   �� $ nuevoMaterial.Precio� .  . 6N  �� 5      -   5        $	 LabelPrecio��5      ���	#FF032725$��Precio��6A   $��0,112,236,0q�6R   $��16(�6g   $��Right=�6u   $��31��6�   $	��Top=�6�   $��Right=�6�   $	��126��6�   �� 5      -   5         ��Name$ ComboBoxTipoMaterial��5      $��	0,64,10,0q�6�   $	��Top=�6  $ -0.233,-0.5&�6  $��31��6=  $��Right=�6I  $	��221��6e   �� SelectedItem 65   �� $ nuevoMaterial.Tipo���6f   �� $ TipoMaterial� .  . 6e  5       �� 5!   
   -   5        $	 LabelTituloNuevoMaterial��5!      ���	#FF032725$��Material��6J   $��9,22,0,0q�6]   $��18(�6o   $
��Bold"�6}   $��Center=�6�   $��31��6�   $	��Top=�6�   $��Center=�6�   $
��Left=�6�   $	��393��6  5#      5$      