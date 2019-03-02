using Proyecto_Avituallamientos.logica;
using System;
using System.Collections.Generic;
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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Proyecto_Avituallamientos.interfaz
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public static LogicaNegocio Logica { get; set; }

        public MainWindow()
        {
            InitializeComponent();
            Logica = new LogicaNegocio();
        }

        private void ButtonVerMaterial_Click(object sender, RoutedEventArgs e)
        {
            VentanaMateriales ventana = new VentanaMateriales();
            ventana.ShowDialog();
            

        }

        private void ButtonVerCarreras_Click(object sender, RoutedEventArgs e)
        {
            VentanaCarreras ventana = new VentanaCarreras();
            ventana.ShowDialog();
        }


    }
}
