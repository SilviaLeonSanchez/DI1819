   M S B A M L   `   `   `  ����  Proyecto_Avituallamientos8    2Proyecto_Avituallamientos.interfaz.VentanaCarreras   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  Carreras��5   	   $	��480��6   $	��640��6'   .��5      � ��5   
   �� 5       �� EndPoint$ 0.5,1&�6"    �� 
StartPoint$ 0.5,0&�63   .��5      �  � Color$ Black��6    � Offset$ 0Q�6-   � 5	      $ White��6   $ 1Q�6-   � 5
      $ 	#FFABF0E6��6   5      .+�5   
   &   System.Windows.Controls.DataGrid  -   5          Name$ DataGridCarreras��5         AutoGenerateColumns .     CanUserAddRows .     
IsReadOnly . $��
78,72,78,0q�6�   $	��Top=�6�   $	��262��6�   
����������	#FFABF0E6��6-   �� 	 �� Path$	 ListaCarreras�
 J� Effect
 5      3  -System.Windows.Media.Effects.DropShadowEffect  5         Color$ 	#FF032725��6#      Opacity$
 0.25Q�65      Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Id��6%      CanUserResize .     Width5  /System.Windows.Controls.DataGridLengthConverter$ 80 6j   1  +System.Windows.Controls.DataGridBoundColumn   Binding 61   �� $	 	IdCarrera�6j     5      $ Nombre��6%    .  $	 260 6r    65   �� $	 NombreCarrera�6r     5      $ Avituallamientos��6%    .  $	 120 6�    6?   �� $	 Avituallamientos.Count�6�   5      �� 5   
   -   5         ��Name$ ButtonAniadirCarrera��5      $��Añadir��6/   $��147,357,386,0q�6@   $	��Top=�6W   $��14(�6o   $
��Bold"�6}   ���	#FF032725 J� RenderTransformOrigin$ 0.494,0.483&�6�   $��29��6�   
 5        5      $ 	#FF032725��6#   $
 0.25Q�65   ��5      �� 5      $ 0,0.5&�6&   $ 1, 0.5&�67   .��5      � $ Black��6#   $ 0Q�61   � 5      $ White��6#   $ 1Q�61   � 5      $ 	#FFDADEDE��6#   5       5"      �� 5#   
   -   5        $ ButtonEditarCarrera��5#      $��Editar��6.   $��266,357,267,0q�6?   $��14(�6V   $
��Bold"�6d   ���	#FF032725$ 0.494,0.483&�6�   $��29��6�   $	��Top=�6�   
 5$        5%      $ 	#FF032725��6#   $
 0.25Q�65   ��5'      �� 5(      $ 0,0.5&�6&   $ 1, 0.5&�67   .��5)      � $ Black��6#   $ 0Q�61   � 5*      $ White��6#   $ 1Q�61   � 5+      $ 	#FFDADEDE��6#   5,      5.      �� 5/   
   -   5        $ ButtonBorrarCarrera��5/      $��Borrar��6.   $��385,357,148,0q�6?   $��14(�6V   $
��Bold"�6d   ���	#FF032725$ 0.494,0.483&�6�   $��29��6�   $	��Top=�6�   
 50        51      $ 	#FF032725��6#   $
 0.25Q�65   ��53      �� 54      $ 0,0.5&�6&   $ 1, 0.5&�67   .��55      � $ Black��6#   $ 0Q�61   � 56      $ White��6#   $ 1Q�61   � 57      $ 	#FFDADEDE��6#   58      5:      �� 5;   
   -   5         ��Name$ LabelCarreras��5;      ���	#FF032725$��Carreras��6?   $��	10,26,8,0q�6R   $��18(�6e   $
��Bold"�6s   $��Center=�6�   $��31��6�   $	��Top=�6�   $��Center=�6�   
 5<        5=      $ 	#FF032725��6#   $
 0.25Q�65   5?      5A      5B      