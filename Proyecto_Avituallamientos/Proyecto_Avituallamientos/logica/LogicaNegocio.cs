using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Proyecto_Avituallamientos.dto;

namespace Proyecto_Avituallamientos.logica
{
    public class LogicaNegocio
    {
        // ATRIBUTOS
        public ObservableCollection<Carrera> ListaCarreras { get; set; }
        public ObservableCollection<Material> ListaMateriales {get; set;}
        public ObservableCollection<String> TipoMaterial { get; set; }

        // METODOS 
        public LogicaNegocio()
        {
            ListaMateriales = new ObservableCollection<Material>();
            ListaCarreras = new ObservableCollection<Carrera>();
            TipoMaterial = new ObservableCollection<String>();

            // TIPO DE MATERIAL
            TipoMaterial.Add("Bebida"); 
            TipoMaterial.Add("Comida");
            TipoMaterial.Add("Material sanitario");
            TipoMaterial.Add("Equipacion");

            // LISTA DE MATERIALES
            ListaMateriales.Add(new Material("Redbull",TipoMaterial[0], 2.00));
            ListaMateriales.Add(new Material("Agua", TipoMaterial[0], 1.50));
            ListaMateriales.Add(new Material("Zumo 1L", TipoMaterial[0], 2.50));
            ListaMateriales.Add(new Material("Patatas fritas", TipoMaterial[1], 2.00));
            ListaMateriales.Add(new Material("Hamburguesa", TipoMaterial[1], 3.50));
            ListaMateriales.Add(new Material("Panchitos", TipoMaterial[1], 1.20));
            ListaMateriales.Add(new Material("Tiritas", TipoMaterial[2], 0.50));
            ListaMateriales.Add(new Material("Vendas", TipoMaterial[2], 4.50));
            ListaMateriales.Add(new Material("Parche calor", TipoMaterial[2], 2.90));
            ListaMateriales.Add(new Material("Calcetines", TipoMaterial[3], 3.40));
            ListaMateriales.Add(new Material("Braga cuello", TipoMaterial[3], 2.30));
            ListaMateriales.Add(new Material("Gorra", TipoMaterial[3], 1.50));

            // CARRERAS
            Carrera carrera = new Carrera("Carrera de prueba");
            Avituallamiento av = new Avituallamiento(carrera, 10, "Soraya Saez", "652451254");
            carrera.Avituallamientos.Add(av);
            ListaCarreras.Add(carrera);
        }

        public Boolean borrarMaterial(string id)
        {
            foreach (Carrera c in ListaCarreras)
            {
                foreach (Avituallamiento avi in c.Avituallamientos)
                {
                    foreach (MaterialAvituallamiento m in avi.Materiales)
                    {
                        if (m.Material.Id.Equals(id,StringComparison.CurrentCultureIgnoreCase))
                        {
                            return false;
                        }

                    }
                }
            }
            foreach (Material m in this.ListaMateriales)
            {
                if (m.Id.Equals(id, StringComparison.CurrentCultureIgnoreCase))
                {
                   return this.ListaMateriales.Remove(m);
                }
            }
            return false;
        }

        public void modificarMaterial(int posicion, Material material)
        {
            this.ListaMateriales[posicion] = material;
            foreach (Carrera c in this.ListaCarreras)
            {
                foreach (Avituallamiento avi in c.Avituallamientos)
                {
                    foreach (MaterialAvituallamiento matAvi in avi.Materiales)
                    {
                        if (matAvi.Material.Id.Equals(material.Id))
                        {
                            matAvi.Material = material;
                        }
                    }
                }
            }
        }

    }
      
}
