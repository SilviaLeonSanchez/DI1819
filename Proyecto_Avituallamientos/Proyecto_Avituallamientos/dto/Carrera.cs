using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Avituallamientos.dto
{
    public class Carrera : ICloneable, INotifyPropertyChanged, IDataErrorInfo
    {
                
        public Carrera(string nombre)
        {
            this.idCarrera = UltimoId + "";
            UltimoId++;
            this.nombreCarrera = nombre;
            this.avituallamientos = new ObservableCollection<Avituallamiento>();
        }

        public Carrera()
        {
            this.avituallamientos = new ObservableCollection<Avituallamiento>();
            this.idCarrera = UltimoId + "";
            UltimoId++;
        }


        public object Clone()
        {
            return this.MemberwiseClone();
        }

        private string idCarrera;
        public string IdCarrera 
        {
            get
            {
                return idCarrera;
            }
            set
            {
                idCarrera = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("IdCarrera"));
            }
        }

        private string nombreCarrera;
        public string NombreCarrera 
        {
            get
            {
                return nombreCarrera;
            }
            set
            {
                nombreCarrera = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("NombreCarrera"));
            }
        }

        private ObservableCollection<Avituallamiento> avituallamientos;
        public ObservableCollection<Avituallamiento> Avituallamientos 
        {
            get
            {
                return avituallamientos;
            }
            set
            {
                avituallamientos = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Avituallamientos"));
            }
        }


        public event PropertyChangedEventHandler PropertyChanged;
        private static int UltimoId = 1;


        public string Error
        {
            get { return ""; }
        }

        public string this[string columnName]
        {
            get 
            {
                string resultado = "";
                if (columnName == "IdCarrera")
                {
                    if (string.IsNullOrEmpty(idCarrera))
                        resultado = "El id de la carrera no puede estar vacío";
                }
                else if (columnName == "NombreCarrera")
                {
                    if (string.IsNullOrEmpty(nombreCarrera))
                        resultado = "El nombre de la carrera no puede estar vacío";
                }
                return resultado;
            }
        }
    }
}
