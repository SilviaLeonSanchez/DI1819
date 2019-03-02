using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Avituallamientos.dto
{
    public class Material : ICloneable, INotifyPropertyChanged, IDataErrorInfo
    {

        public Material(string nombre, string tipo, double precio)
        {
            this.id = UltimoId + "";
            UltimoId++;
            this.nombre = nombre;
            this.tipo = tipo;
            this.precio = precio;
        }

        public Material()
        {
            this.id = UltimoId + "";
            UltimoId++;
        }

        private string id;
        public string Id 
        { 
            get
            {
                return id;
            }
        }

        private string nombre;
        public string Nombre 
        { 
            get
            {
                return nombre;
            }
            set
            {
                nombre = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Nombre"));
            } 
        }

        private string tipo;
        public string Tipo 
        { 
            get
            {
                return tipo;
            } 
            set
            {

                tipo = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Tipo"));
            } 
        }

        private double precio;
        public double Precio 
        { 
            get
            {
                return precio;
            } 
            set
            {
                precio = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Precio"));
            }
        }

        

        public object Clone()
        {
            return this.MemberwiseClone();
        }

        public event PropertyChangedEventHandler PropertyChanged;
        private static int UltimoId;


        public string Error
        {
            get { return ""; }
        }

        public string this[string columnName]
        {
            get 
            {
                if (columnName == "Id")
                {
                    if (string.IsNullOrEmpty(id))
                        return "El id del material no puede estar vacío";
                }
                else if (columnName == "Nombre")
                {
                    if (string.IsNullOrEmpty(nombre))
                        return "El nombre del material no puede estar vacío";
                }
                else if (columnName == "Tipo")
                {
                    if (string.IsNullOrEmpty(tipo))
                        return "El tipo de material no puede estar vacío";
                }
                else if (columnName == "Precio")
                {
                    if (precio < 0)
                         return "El precio debe ser un número positivo";
                }

                return "";
            }
        }
    }

}
