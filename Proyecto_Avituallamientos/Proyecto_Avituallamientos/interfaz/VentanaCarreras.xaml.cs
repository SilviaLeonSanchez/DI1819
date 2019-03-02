using Proyecto_Avituallamientos.dto;
using Proyecto_Avituallamientos.logica;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Proyecto_Avituallamientos.interfaz
{
    /// <summary>
    /// Lógica de interacción para Window5.xaml
    /// </summary>
    public partial class VentanaCarreras : Window
    {

        public VentanaCarreras()
        {
            InitializeComponent();
            this.DataContext = MainWindow.Logica;
        }

        private void ButtonAniadirCarrera_Click(object sender, RoutedEventArgs e)
        {
            VentanaNuevaCarrera ventana = new VentanaNuevaCarrera();
            ventana.ShowDialog();
        }

        private void ButtonBorrarCarrera_Click(object sender, RoutedEventArgs e)
        {
            Carrera carrera_seleccionada = (Carrera) this.DataGridCarreras.SelectedItem;
            if (carrera_seleccionada != null)
            {
                MessageBoxResult resultado = MessageBox.Show(this, "¿Seguro que quieres borrar la carrera seleccionada?");
                if (resultado == MessageBoxResult.OK || resultado == MessageBoxResult.Yes)
                {
                    MainWindow.Logica.ListaCarreras.Remove(carrera_seleccionada);
                }
                else
                {
                    MessageBox.Show(this, "No se ha borrdo ninguna carrera");
                }
            }
        }

        private void DataGridCarreras_DoubleClick(object sender, MouseButtonEventArgs e)
        {
            VentanaNuevaCarrera ventana = new VentanaNuevaCarrera(MainWindow.Logica.ListaCarreras[this.DataGridCarreras.SelectedIndex], this.DataGridCarreras.SelectedIndex);
            ventana.ShowDialog();
            this.DataContext = MainWindow.Logica;
        }

        private void ButtonEditarCarrera_Click(object sender, RoutedEventArgs e)
        {
            Carrera carrera_seleccionada = (Carrera)this.DataGridCarreras.SelectedItem;
            if (carrera_seleccionada != null)
            {
                int indice = MainWindow.Logica.ListaCarreras.IndexOf(carrera_seleccionada);
                VentanaNuevaCarrera ventana = new VentanaNuevaCarrera(carrera_seleccionada, indice);
                ventana.ShowDialog();
            }
        }
    }
}
