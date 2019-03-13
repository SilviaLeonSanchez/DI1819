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
    /// Lógica de interacción para Examen2Eval.xaml
    /// </summary>
    public partial class Examen2Eval : Window
    {

        public ObservableCollection<Material> ListaMateriales { get; set; }
        public ObservableCollection<String> TipoMaterial { get; set; }
        public String TipoElegido { get; set; }
        public int Cantidad { get; set; }

        
        public Examen2Eval()
        {
            InitializeComponent();
            this.ListaMateriales = MainWindow.Logica.ListaMateriales;
            this.TipoMaterial = MainWindow.Logica.TipoMaterial;
            this.Cantidad = this.ListaMateriales.Count;
            this.TipoElegido = "";
            this.DataContext = this;
        }

        private void ComboBoxTipoMaterial_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            ObservableCollection<Material> NuevaListaMateriales = new ObservableCollection<Material>();
            this.TipoElegido = (string) this.ComboBoxTipoMaterial.SelectedItem;
            foreach (var m in MainWindow.Logica.ListaMateriales)
	        {
		        if (this.TipoElegido.Equals(m.Tipo))
                {
                    NuevaListaMateriales.Add(m);
                }
	        }
            this.ListaMateriales = NuevaListaMateriales;
            this.Cantidad = this.ListaMateriales.Count;
            this.DataContext = this;
        }





    }
}
