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
    /// Lógica de interacción para Window1.xaml
    /// </summary>
    public partial class VentanaNuevoMaterial : Window
    {

        private int posicion = -1;
        public Material nuevoMaterial {get; set;}
        public ObservableCollection<String> TipoMaterial { get; set; }

        public VentanaNuevoMaterial()
        {
            InitializeComponent();
            this.TipoMaterial = MainWindow.Logica.TipoMaterial;
            this.nuevoMaterial = new Material();
            this.ComboBoxTipoMaterial.SelectedIndex = 0;
            this.DataContext = this;
        }
        public VentanaNuevoMaterial(Material material, int posicion)
        {
            InitializeComponent();
            this.nuevoMaterial = (Material) material.Clone();
            this.TipoMaterial = MainWindow.Logica.TipoMaterial;
            this.ComboBoxTipoMaterial.SelectedIndex = TipoMaterial.IndexOf(material.Tipo);
            this.posicion = posicion;
            this.DataContext = this;
        }

        private void ButtonVolver_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void ButtonNuevoMaterial_Click(object sender, RoutedEventArgs e)
        {
            if (posicion == -1)
                MainWindow.Logica.ListaMateriales.Add(nuevoMaterial);
            else
                MainWindow.Logica.modificarMaterial(posicion, this.nuevoMaterial);

           this.Close();
        }

        private int errores;
        private void Validation_Error(object sender, ValidationErrorEventArgs e)
        {
            if (e.Action == ValidationErrorEventAction.Added)
                errores++;
            else if (e.Action == ValidationErrorEventAction.Removed)
                errores--;

            this.ButtonGuardarMaterial.IsEnabled = (errores == 0);
        }
    }
}
