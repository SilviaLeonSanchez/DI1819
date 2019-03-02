using Proyecto_Avituallamientos.dto;
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
    /// Lógica de interacción para Window4.xaml
    /// </summary>
    public partial class VentanaNuevoAvituallamiento : Window
    {
        public Carrera carrera { get; set; }
        public Avituallamiento avituallamiento { get; set; }
        public int posicion;

        public VentanaNuevoAvituallamiento(Carrera carrera)
        {
            InitializeComponent();
            this.carrera = carrera;
            this.avituallamiento = new Avituallamiento(this.carrera);
            this.posicion = -1;
            this.TextBoxNombreCarrera.IsEnabled = false;
            this.DataContext = this.avituallamiento;
        }

        public VentanaNuevoAvituallamiento(Carrera carrera, Avituallamiento avituallamiento, int posicion)
        {
            InitializeComponent();
            this.carrera = carrera;
            this.avituallamiento = (Avituallamiento) avituallamiento.Clone();
            this.posicion = posicion;
            this.TextBoxNombreCarrera.IsEnabled = false;
            this.DataContext = this.avituallamiento;
        }

        private void ButtonGuardarAvituallamiento_Click(object sender, RoutedEventArgs e)
        {
            if (this.posicion != -1)
            {
                this.carrera.Avituallamientos[posicion] = this.avituallamiento;
            }
            else
            {
                this.carrera.Avituallamientos.Add(this.avituallamiento);
            }
            this.Close();
        }
        
        private void ButtonAñadirMaterial_Click(object sender, RoutedEventArgs e)
        {
            VentanaMateriales ventana = new VentanaMateriales(this.avituallamiento);
            ventana.ShowDialog();
        }

        private void ButtonBorrarMaterial_Click(object sender, RoutedEventArgs e)
        {

            MaterialAvituallamiento m = (MaterialAvituallamiento) this.DataGridMaterial.SelectedItem;
            if (m != null)
            {
                this.avituallamiento.borrarMaterial(m.Material.Id);
            }
        }

        private int errores;
        private void Validation_Error(object sender, ValidationErrorEventArgs e)
        {
            if (e.Action == ValidationErrorEventAction.Added)
                errores++;
            else if (e.Action == ValidationErrorEventAction.Removed)
                errores--;

            this.ButtonGuardarAvituallamiento.IsEnabled = (errores == 0);
        }

    }
}
