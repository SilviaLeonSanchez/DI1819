   M S B A M L   `   `   `  ����  Proyecto_Avituallamientos4    .Proyecto_Avituallamientos.interfaz.Examen2Eval   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  Examen2Eval��5   	   $	��480��6   $	��640��6*    � 
ResizeMode$ NoResize=�66    � WindowStartupLocation$ CenterOwner=�5   	   .��5      � ��5   
   �� 5       �� EndPoint$ 0.5,1&�6"    �� 
StartPoint$ 0.5,0&�63   .��5	      �  � Color$ Black��6    � Offset$ 0Q�6-   � 5
      $ White��6   $ 1Q�6-   � 5      $ 	#FFABF0E6��6   5      .+�5   
   �� $��Examen 2 Eval��6   $��195,20,195,0q�6(   $	��Top=�6>   $��58��6V   $��36(�6b    J� Effect 5      3  -System.Windows.Media.Effects.DropShadowEffect  5         Color$ 	#FF032725��6#   	   Opacity$
	 0.25Q�65   5      &   System.Windows.Controls.DataGrid  5   
   -   5        
  Name$
 DataGridMateriales��5         AutoGenerateColumns .  $��37,135,35,87q�6K      CanUserAddRows .     
IsReadOnly . 
���������6a   ��  �� Path$ .� 5        5      $ 	#FF032725��6#   $	 0.255Q�65      Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Id��6%      CanUserResize .     Width5  /System.Windows.Controls.DataGridLengthConverter$ 60 6c   1  +System.Windows.Controls.DataGridBoundColumn   Binding 61   �� $ Id�6c     5      $ Nombre��6%    .  $	 180 6k    65   �� $ Nombre�6k     5      $
 Tipo��6%    .  $	 180 6g    63   �� $
 Tipo�6g     5      $ Precio��6%    .  $	 120 6k    65   �� $ Precio�6k   5      �� 5   
   -   5         ��Name$ LabelTipoMaterial��5      ���	#FF032725$
��Tipo��6C   $��
0,99,261,0q�6R   $��16(�6f   $��Right=�6t   $��31��6�   $	��Top=�6�   $��Right=�6�   $	��104��6�   �� 5   
   -   5         ��Name$ ComboBoxTipoMaterial��5      $��	0,99,35,0q�6�   $	��Top=�6�    J� RenderTransformOrigin$ -0.233,-0.5&�6�   $��31��6�   $��Right=�6�   $	��221��6�    �� SelectedItem 61   �� $ TipoElegido���6[   �� $ TipoMaterial�6  �� 5    
   -   5        $ LabelCantidad��5       ���	#FF032725$�� ��6?   $��0,387,193,0q�6J   $��16(�6_   $��31��6m   $	��Top=�6y   $��Right=�6�   $��63��6�   $ 
0.51,0.433&�6�   �� 5!   
   -   5        $ LabelTituloCantidad��5!      ���	#FF032725$��Numero de productos:��6E   $��0,387,261,0q�6d   $��16(�6y   $
��Left=�6�   $��31��6�   $	��Top=�6�   $��Right=�6�   $	��186��6�   5#      5$      