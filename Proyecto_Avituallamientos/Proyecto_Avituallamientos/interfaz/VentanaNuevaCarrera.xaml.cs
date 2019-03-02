using Proyecto_Avituallamientos.dto;
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
using System.Windows.Shapes;

namespace Proyecto_Avituallamientos.interfaz
{
    /// <summary>
    /// Lógica de interacción para NuevaCarrera.xaml
    /// </summary>
    public partial class VentanaNuevaCarrera : Window
    {

        public Carrera carrera { get; set; }
        public int posicion { get; set; }

        public VentanaNuevaCarrera()
        {
            InitializeComponent();
            this.carrera = new Carrera();
            this.posicion = -1;
            this.DataContext = this.carrera;
            
        }

        public VentanaNuevaCarrera(Carrera carrera, int posicion)
        {
            InitializeComponent();
            this.carrera = (Carrera) carrera.Clone();
            this.posicion = posicion;
            this.DataContext = this.carrera;
        }

        private void ButtonGuardar_Click(object sender, RoutedEventArgs e)
        {
            if (posicion == -1)
            {
                MainWindow.Logica.ListaCarreras.Add(this.carrera);
            }
            else 
            {
                MainWindow.Logica.ListaCarreras[this.posicion] = this.carrera;
            }
            this.Close();
        }

        private void EditarAvituallamientos_Click(object sender, RoutedEventArgs e)
        {
            Avituallamiento av_seleccionado =  (Avituallamiento) this.DataGridAvituallamientos.SelectedItem;
            if (av_seleccionado != null)
            {
                VentanaNuevoAvituallamiento ventana = new VentanaNuevoAvituallamiento(this.carrera, av_seleccionado, this.carrera.Avituallamientos.IndexOf(av_seleccionado));
                ventana.ShowDialog();
                this.DataContext = this.carrera;
            }
        }

        private void AniadirAvituallamientos_Click(object sender, RoutedEventArgs e)
        {
            VentanaNuevoAvituallamiento ventana = new VentanaNuevoAvituallamiento(this.carrera);
            ventana.ShowDialog();
        }

        private void ButtonBorrarAvituallamiento_Click(object sender, RoutedEventArgs e)
        {
            Avituallamiento av_seleccionado = (Avituallamiento)this.DataGridAvituallamientos.SelectedItem;
            if (av_seleccionado != null)
            {
                this.carrera.Avituallamientos.Remove(av_seleccionado);
            }
        }

        private int errores;
        private void Validation_Error(object sender, ValidationErrorEventArgs e)
        {
            if (e.Action == ValidationErrorEventAction.Added)
                errores++;
            else if (e.Action == ValidationErrorEventAction.Removed)
                errores--;

            this.ButtonGuardarCarrera.IsEnabled = (errores == 0);
        }

    }
}
