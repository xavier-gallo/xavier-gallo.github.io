using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PCComponentConfigurator
{
    public partial class Formadmin : Form
    {
        
        private string connectionString = "server=(local)\\SQLEXPRESS;database=master;Integrated Security=SSPI";

        public Formadmin()
        {
            InitializeComponent();
            
        }

       

 

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string nombreTabla = comboBox1.SelectedItem?.ToString();
            if (string.IsNullOrEmpty(nombreTabla)) return;

            dataGridView2.DataSource = null;
            dataGridView2.Rows.Clear();
            dataGridView2.Columns.Clear();

            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                string query = $"SELECT * FROM [{nombreTabla}]";
                SqlDataAdapter adapter = new SqlDataAdapter(query, conn);
                DataTable datos = new DataTable();
                adapter.Fill(datos);

                dataGridView2.DataSource = datos;
                
                
            }
        }

        private void btnlimpiar_Click(object sender, EventArgs e)
        {
            dataGridView2.Columns.Clear();
        }

        private void btnsalir_Click(object sender, EventArgs e)
        {                             
            this.Close();
        }

        private void Modificar_Click(object sender, EventArgs e)
        {
            string connectionString = "server=(local)\\SQLEXPRESS;database=master; Integrated Security = SSPI";
            string tablaSeleccionada = comboBox1.SelectedItem?.ToString();

            using (SqlConnection conexion = new SqlConnection(connectionString))
            {
                conexion.Open();
                dataGridView2.EndEdit();

                foreach (DataGridViewRow row in dataGridView2.Rows)
                {
                    if (row.IsNewRow) continue;

                    if (tablaSeleccionada == "Usuarios")
                    {
                        int id = Convert.ToInt32(row.Cells["Id"].Value);
                        string nombreUsuario = row.Cells["NombreUsuario"].Value.ToString();
                        string contrasena = row.Cells["Contrasena"].Value.ToString();
                        string rol = row.Cells["Rol"].Value.ToString();

                        string query = "UPDATE Usuarios SET NombreUsuario = @nombreUsuario, Contrasena = @contrasena, Rol = @rol WHERE Id = @id";
                        using (SqlCommand cmd = new SqlCommand(query, conexion))
                        {
                            cmd.Parameters.AddWithValue("@id", id);
                            cmd.Parameters.AddWithValue("@nombreUsuario", nombreUsuario);
                            cmd.Parameters.AddWithValue("@contrasena", contrasena);
                            cmd.Parameters.AddWithValue("@rol", rol);
                            cmd.ExecuteNonQuery();
                        }
                    }
                    else if (tablaSeleccionada == "DiscoDuro")
                    {
                        int id = Convert.ToInt32(row.Cells["id"].Value);
                        int gb = Convert.ToInt32(row.Cells["gb"].Value);
                        string nombre = row.Cells["nombre"].Value.ToString();
                        int precio = Convert.ToInt32(row.Cells["precio"].Value);

                        string query = "UPDATE DiscoDuro SET gb = @gb, nombre = @nombre, precio = @precio WHERE id = @id";
                        using (SqlCommand cmd = new SqlCommand(query, conexion))
                        {
                            cmd.Parameters.AddWithValue("@id", id);
                            cmd.Parameters.AddWithValue("@gb", gb);
                            cmd.Parameters.AddWithValue("@nombre", nombre);
                            cmd.Parameters.AddWithValue("@precio", precio);
                            cmd.ExecuteNonQuery();
                        }
                    }
                    else if (tablaSeleccionada == "FuenteDeAlimentacion")
                    {
                        int id = Convert.ToInt32(row.Cells["id"].Value);
                        int vatios = Convert.ToInt32(row.Cells["vatios"].Value);
                        string nombre = row.Cells["nombre"].Value.ToString();
                        int precio = Convert.ToInt32(row.Cells["precio"].Value);

                        string query = "UPDATE FuenteDeAlimentacion SET vatios = @vatios, nombre = @nombre, precio = @precio WHERE id = @id";
                        using (SqlCommand cmd = new SqlCommand(query, conexion))
                        {
                            cmd.Parameters.AddWithValue("@id", id);
                            cmd.Parameters.AddWithValue("@vatios", vatios);
                            cmd.Parameters.AddWithValue("@nombre", nombre);
                            cmd.Parameters.AddWithValue("@precio", precio);
                            cmd.ExecuteNonQuery();
                        }
                    }
                    else if (tablaSeleccionada == "MemoriaRam")
                    {
                        int id = Convert.ToInt32(row.Cells["Id"].Value);
                        string nombre = row.Cells["nombre"].Value.ToString();
                        int ddr = Convert.ToInt32(row.Cells["ddr"].Value);
                        int precio = Convert.ToInt32(row.Cells["precio"].Value);

                        string query = "UPDATE MemoriaRam SET nombre = @nombre, ddr = @ddr, precio = @precio WHERE Id = @id";
                        using (SqlCommand cmd = new SqlCommand(query, conexion))
                        {
                            cmd.Parameters.AddWithValue("@id", id);
                            cmd.Parameters.AddWithValue("@nombre", nombre);
                            cmd.Parameters.AddWithValue("@ddr", ddr);
                            cmd.Parameters.AddWithValue("@precio", precio);
                            cmd.ExecuteNonQuery();
                        }
                    }
                    else if (tablaSeleccionada == "Ordenador")
                    {
                        int id = Convert.ToInt32(row.Cells["id"].Value);
                        int id_disco = Convert.ToInt32(row.Cells["id_disco"].Value);
                        int id_fuente = Convert.ToInt32(row.Cells["id_fuente"].Value);
                        int id_ram = Convert.ToInt32(row.Cells["id_ram"].Value);
                        int id_placa = Convert.ToInt32(row.Cells["id_placa"].Value);
                        int id_grafica = Convert.ToInt32(row.Cells["id_grafica"].Value);
                        int id_procesador = Convert.ToInt32(row.Cells["id_procesador"].Value);

                        string query = @"UPDATE Ordenador SET id_disco = @id_disco, id_fuente = @id_fuente, 
                     id_ram = @id_ram, id_placa = @id_placa, id_grafica = @id_grafica, 
                     id_procesador = @id_procesador WHERE id = @id";

                        using (SqlCommand cmd = new SqlCommand(query, conexion))
                        {
                            cmd.Parameters.AddWithValue("@id", id);
                            cmd.Parameters.AddWithValue("@id_disco", id_disco);
                            cmd.Parameters.AddWithValue("@id_fuente", id_fuente);
                            cmd.Parameters.AddWithValue("@id_ram", id_ram);
                            cmd.Parameters.AddWithValue("@id_placa", id_placa);
                            cmd.Parameters.AddWithValue("@id_grafica", id_grafica);
                            cmd.Parameters.AddWithValue("@id_procesador", id_procesador);
                            cmd.ExecuteNonQuery();
                        }
                    }
                    else if (tablaSeleccionada == "PlacasBase")
                    {
                        int id = Convert.ToInt32(row.Cells["Id"].Value);
                        string nombre = row.Cells["nombre"].Value.ToString();
                        string categoria = row.Cells["categoria"].Value.ToString();
                        int precio = Convert.ToInt32(row.Cells["precio"].Value);

                        string query = "UPDATE PlacasBase SET nombre = @nombre, categoria = @categoria, precio = @precio WHERE Id = @id";
                        using (SqlCommand cmd = new SqlCommand(query, conexion))
                        {
                            cmd.Parameters.AddWithValue("@id", id);
                            cmd.Parameters.AddWithValue("@nombre", nombre);
                            cmd.Parameters.AddWithValue("@categoria", categoria);
                            cmd.Parameters.AddWithValue("@precio", precio);
                            cmd.ExecuteNonQuery();
                        }
                    }
                    else if (tablaSeleccionada == "Procesador")
                    {
                        int id = Convert.ToInt32(row.Cells["Id"].Value);
                        double ghz = Convert.ToDouble(row.Cells["ghz"].Value);
                        string nombre = row.Cells["nombre"].Value.ToString();
                        int precio = Convert.ToInt32(row.Cells["precio"].Value);

                        string query = "UPDATE Procesador SET ghz = @ghz, nombre = @nombre, precio = @precio WHERE Id = @id";
                        using (SqlCommand cmd = new SqlCommand(query, conexion))
                        {
                            cmd.Parameters.AddWithValue("@id", id);
                            cmd.Parameters.AddWithValue("@ghz", ghz);
                            cmd.Parameters.AddWithValue("@nombre", nombre);
                            cmd.Parameters.AddWithValue("@precio", precio);
                            cmd.ExecuteNonQuery();
                        }
                    }
                    else if (tablaSeleccionada == "TarjetasGraficas")
                    {
                        int id = Convert.ToInt32(row.Cells["id"].Value);
                        string nombre = row.Cells["nombre"].Value.ToString();
                        int gb = Convert.ToInt32(row.Cells["gb"].Value);
                        int precio = Convert.ToInt32(row.Cells["precio"].Value);

                        string query = "UPDATE TarjetasGraficas SET nombre = @nombre, gb = @gb, precio = @precio WHERE id = @id";
                        using (SqlCommand cmd = new SqlCommand(query, conexion))
                        {
                            cmd.Parameters.AddWithValue("@id", id);
                            cmd.Parameters.AddWithValue("@nombre", nombre);
                            cmd.Parameters.AddWithValue("@gb", gb);
                            cmd.Parameters.AddWithValue("@precio", precio);
                            cmd.ExecuteNonQuery();
                        }
                    }
                    // Puedes agregar más tablas aquí si lo necesitas
                }

                conexion.Close();
                MessageBox.Show("Cambios guardados correctamente en la tabla " + tablaSeleccionada);
            }
        }

        private void Borrarb_Click(object sender, EventArgs e)
        {
            if (dataGridView2.SelectedRows.Count == 0)
            {
                MessageBox.Show("Por favor, selecciona una fila para eliminar.");
                return;
            }

            string tablaSeleccionada = comboBox1.SelectedItem?.ToString();
            if (string.IsNullOrEmpty(tablaSeleccionada))
            {
                MessageBox.Show("Por favor selecciona una tabla primero.");
                return;
            }

            var filaSeleccionada = dataGridView2.SelectedRows[0];
            if (filaSeleccionada.Cells["id"].Value == DBNull.Value)
            {
                MessageBox.Show("Fila inválida.");
                return;
            }

            int id = Convert.ToInt32(filaSeleccionada.Cells["id"].Value);

            // Confirmación
            DialogResult result = MessageBox.Show($"¿Estás seguro que deseas eliminar el registro con ID = {id} de la tabla '{tablaSeleccionada}'?", "Confirmar eliminación", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
            if (result != DialogResult.Yes)
            {
                return;
            }

            // Eliminar de la base de datos
            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                try
                {
                    conn.Open();
                    string query = $"DELETE FROM {tablaSeleccionada} WHERE id = @id";
                    using (SqlCommand cmd = new SqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@id", id);
                        int filasAfectadas = cmd.ExecuteNonQuery();

                        if (filasAfectadas > 0)
                        {
                            dataGridView2.Rows.Remove(filaSeleccionada); // Eliminar de la vista
                            MessageBox.Show("Registro eliminado correctamente.");
                        }
                        else
                        {
                            MessageBox.Show("No se pudo eliminar el registro.");
                        }
                    }
                }
                catch (SqlException ex)
                {
                    MessageBox.Show($"Error al eliminar: {ex.Message}");
                }
            }
        }
    }
}
