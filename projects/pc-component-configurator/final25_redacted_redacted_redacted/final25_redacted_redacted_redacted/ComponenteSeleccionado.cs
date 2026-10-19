using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PCComponentConfigurator
{
    //clase de apoyo para poder recuperar los objetos seleccionados
    public class ComponenteSeleccionado
    {
        public string Tipo { get; set; }      // Ej: "Disco Duro"
        public string Nombre { get; set; }    // Ej: "Samsung 1TB"
        public int Id { get; set; }           // ID real del componente
        public decimal Precio { get; set; }   // Precio
    }
}
