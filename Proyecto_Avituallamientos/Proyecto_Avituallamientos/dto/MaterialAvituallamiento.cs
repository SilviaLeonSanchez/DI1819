using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Avituallamientos.dto
{
    public class MaterialAvituallamiento : ICloneable, INotifyPropertyChanged, IDataErrorInfo
    {
        public event PropertyChangedEventHandler PropertyChanged;

        public MaterialAvituallamiento(Material material, int cantidad)
        {
            this.material = material;
            this.cantidad = cantidad;
        }

        public MaterialAvituallamiento()
        {
            this.material = null;
            this.cantidad = 1;
        }

        private Material material;
        public Material Material
        {
            get
            {
                return material;
            }
            set
            {
                material = value;
            }
        }

        private int cantidad;
        public int Cantidad
        {
            get
            {
                return cantidad;
            }
            set
            {
                cantidad = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Cantidad"));
            }
        }

        public void aniadirMas(int cantidad)
        {
            this.cantidad += cantidad;
            this.PropertyChanged(this, new PropertyChangedEventArgs("Cantidad"));
        }


        public object Clone()
        {
            return this.MemberwiseClone();
        }

        public string Error
        {
            get { return ""; }
        }

        public string this[string columnName]
        {
            get
            {
                if (columnName == "Material")
                {
                    if (material == null)
                        return "El material no puede estar vacío";
                }
                else if (columnName == "Cantidad")
                {
                    if (this.cantidad == null)
                        return "La cantidad no puede estar vacío";
                    else if (this.cantidad < 0)
                        return "La cantidad debe ser un número positivo";
                }

                return "";
            }
        }

    }
}
