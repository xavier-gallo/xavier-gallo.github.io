using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using Excel = Microsoft.Office.Interop.Excel; //agrego previamente la referencia a excel


namespace PCComponentConfigurator
{
    public partial class Componentes : Form
    {
        SqlConnection conexion = new SqlConnection("server=(local)\\SQLEXPRESS;database=master; Integrated Security = SSPI");
        SqlCommand comandosql = new SqlCommand();
        private List<ComponenteSeleccionado> componentes;
        public Componentes(List<ComponenteSeleccionado> lista)
        {
            InitializeComponent();
            componentes = lista;
        }

        private void Componentes_Load(object sender, EventArgs e)
        {
            listView1.Items.Clear();

            foreach (var comp in componentes)
            {
                ListViewItem item = new ListViewItem(comp.Tipo);
                item.SubItems.Add(comp.Nombre);
                item.SubItems.Add(comp.Precio.ToString("C")); // C es el formato de la moneda
                item.Tag = comp; // guardar el objeto  en .Tag, luego se puede borrarlo directamente.
                listView1.Items.Add(item);
            }
        }

        private void FinaliarCreacionb_Click(object sender, EventArgs e)
        {
            if (tb1.Text == "" || tb2.Text == "" || tb3.Text == "")
            {
                MessageBox.Show("Aun te faltan campos por rellenar");
                return;
            }
            int comprobacion = listView1.Items.Count;
            if (comprobacion == 6)
            {
                //guardo los ids primero en variables
                int id_disco = 0, id_ram = 0, id_fuente = 0, id_placa = 0, id_grafica = 0, id_procesador = 0;

                // compruebo que segun cada tipo se almacene el id del objeto de ese tipo
                foreach (var c in componentes)
                {
                    if (c.Tipo == "Disco Duro") id_disco = c.Id;
                    else if (c.Tipo == "Memoria RAM") id_ram = c.Id;
                    else if (c.Tipo == "Fuente de Alimentación") id_fuente = c.Id;
                    else if (c.Tipo == "Placa Base") id_placa = c.Id;
                    else if (c.Tipo == "Tarjeta Gráfica") id_grafica = c.Id;
                    else if (c.Tipo == "Procesador") id_procesador = c.Id;
                }

                try
                {
                    conexion.Open();
                    comandosql.Connection = conexion;

                    // creamos una consulta para saber que id asignarle a la pc
                    comandosql.CommandText = "SELECT ISNULL(MAX(id), 0) + 1 FROM Ordenador";
                    int nuevoId = (int)comandosql.ExecuteScalar();

                    // insertamos datos
                    comandosql.CommandText = "INSERT INTO Ordenador (id, id_disco, id_fuente, id_ram, id_placa, id_grafica, id_procesador, fecha, comprador) " +
                                                                   "VALUES (@id, @disco, @fuente, @ram, @placa, @grafica, @procesador, @fecha, @comprador)";

                    comandosql.Parameters.AddWithValue("@id", nuevoId); // para poder insertar variables
                    comandosql.Parameters.AddWithValue("@disco", id_disco);
                    comandosql.Parameters.AddWithValue("@fuente", id_fuente);
                    comandosql.Parameters.AddWithValue("@ram", id_ram);
                    comandosql.Parameters.AddWithValue("@placa", id_placa);
                    comandosql.Parameters.AddWithValue("@grafica", id_grafica);
                    comandosql.Parameters.AddWithValue("@procesador", id_procesador);
                    comandosql.Parameters.AddWithValue("@fecha", DateTime.Now);
                    comandosql.Parameters.AddWithValue("@comprador", tb3.Text);

                    comandosql.ExecuteNonQuery();

                    MessageBox.Show("Ordenador insertado correctamente.", "Éxito", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    this.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Ordenador insertado correctamente.", "Éxito", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                //creamos un excel
                Excel.Application excelApp = null;
                Excel.Workbook workbook = null;
                Excel.Worksheet worksheet = null;

                try
                {
                    excelApp = new Excel.Application();
                    excelApp.Visible = true;

                    workbook = excelApp.Workbooks.Add();
                    worksheet = (Excel.Worksheet)workbook.Sheets[1];
                    worksheet.Name = "Factura";

                    // encabezados de cada columna
                    worksheet.Cells[1, 1] = "Tipo";
                    worksheet.Cells[1, 2] = "Nombre";
                    worksheet.Cells[1, 3] = "Precio";
                    //indica la fila de inicio donde se empezaran a escribir los datos de los componentes en la hoja de Excel porque el 1 ya se uso para los encabezados
                    int fila = 2;
                    //es para acumular el precio total de los componentes
                    double total = 0;

                    foreach (var comp in componentes)
                    {
                        //lllenamos celdas
                        worksheet.Cells[fila, 1] = comp.Tipo;
                        worksheet.Cells[fila, 2] = comp.Nombre;
                        worksheet.Cells[fila, 3] = comp.Precio;
                        // Formato de la moneda con solo dos decimales
                        Excel.Range precioCelda = (Excel.Range)worksheet.Cells[fila, 3];
                        precioCelda.NumberFormat = "€#,##0.00";

                        total += (double)comp.Precio;
                        fila++;
                    }

                    // calculamos el total en la celda correspondiente
                    worksheet.Cells[fila, 2] = "Total:";
                    worksheet.Cells[fila, 3] = total;
                    Excel.Range totalCelda = (Excel.Range)worksheet.Cells[fila, 3];
                    totalCelda.NumberFormat = "$#,##0.00";
                    totalCelda.Font.Bold = true;
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error al crear factura Excel: " + ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }

                //vaciamos la lista
                componentes.Clear(); //borramos de la lista
                listView1.Items.Clear();//borrramos del listview

            }
            else
            {
                MessageBox.Show("Faltan componentes por seleccionar.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }


        private void Volverb_Click(object sender, EventArgs e)
        {
            Close();
        }


        private void Borrarb_Click_1(object sender, EventArgs e)
        {

            if (listView1.SelectedItems.Count > 0)
            {
                ListViewItem seleccionado = listView1.SelectedItems[0];

                if (seleccionado.Tag is ComponenteSeleccionado borrar)// borramos a tiempo real en la lista.
                {
                    componentes.Remove(borrar); //borramos de la lista
                    listView1.Items.Remove(seleccionado);//borrramos del listview
                    MessageBox.Show("Componente borrado.");
                }
            }
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
