using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using System.Collections;
using System.IO;

namespace PCComponentConfigurator
{
    public partial class Form1 : Form
    {
        SqlConnection conexion = new SqlConnection("server=(local)\\SQLEXPRESS;database=master; Integrated Security = SSPI");
        SqlCommand comandosql = new SqlCommand();
        public List<ComponenteSeleccionado> listaTemporal = new List<ComponenteSeleccionado>();
        private int idUsuario;
        public Form1(int idUsuario)
        {
            InitializeComponent();
            this.idUsuario = idUsuario;
            conexion.Open();
            conexion.Close();

        }
        private void AñadirComponenteb_Click(object sender, EventArgs e)
        {
            if (lsv1.SelectedItems.Count > 0)
            {
                string tipoSeleccionado = comboBox1.SelectedItem.ToString();
                ListViewItem seleccionado = lsv1.SelectedItems[0];

                // Verificar si ya existe un componente del mismo tipo en la lista temporal
                for (int i = 0; i < listaTemporal.Count; i++)
                {
                    if (listaTemporal[i].Tipo == tipoSeleccionado)
                    {
                        MessageBox.Show("Ya se añadió un componente de ese tipo.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        return;
                    }
                }

                ComponenteSeleccionado comp = new ComponenteSeleccionado
                {
                    Tipo = comboBox1.SelectedItem.ToString(),
                    Id = int.Parse(seleccionado.SubItems[0].Text),
                    Nombre = seleccionado.SubItems[2].Text,  // Ajusta si "nombre" está en otra posición
                    Precio = decimal.Parse(seleccionado.SubItems[3].Text)
                };

                listaTemporal.Add(comp);
                MessageBox.Show("Componente añadido.");
            }
            else
            {
                MessageBox.Show("Seleccione un componente");
            }
        }

        private void MostarAñadidosb_Click(object sender, EventArgs e)
        {
            Componentes c = new Componentes(listaTemporal);
            c.Show();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            // guardamos la seleccion en una variable para usarlas en los ifs
            string seleccion = comboBox1.SelectedItem.ToString();

            if (seleccion == "Disco Duro")
            {
                // Limpiar ListView
                lsv1.Items.Clear();
                lsv1.Columns.Clear();
                // Agregar columnas individualmente
                lsv1.Columns.Add("Id");
                lsv1.Columns.Add("Gb");
                lsv1.Columns.Add("Nombre", 150);
                lsv1.Columns.Add("Precio");
                // Consultas
                conexion.Open();
                comandosql.Connection = conexion;
                comandosql.CommandText = "SELECT id, gb, nombre, precio FROM DiscoDuro";
                SqlDataReader reader = comandosql.ExecuteReader();
                while (reader.Read())
                {
                    ListViewItem item = new ListViewItem(reader["id"].ToString());
                    item.SubItems.Add(reader["gb"].ToString());
                    item.SubItems.Add(reader["nombre"].ToString());
                    item.SubItems.Add(reader["precio"].ToString());
                    lsv1.Items.Add(item);
                }
                reader.Close();
                conexion.Close();
            }
            if (seleccion == "Memoria RAM")
            {
                // Limpiar ListView
                lsv1.Items.Clear();
                lsv1.Columns.Clear();
                // Agregar columnas individualmente
                lsv1.Columns.Add("Id");
                lsv1.Columns.Add("Ddr");
                lsv1.Columns.Add("Nombre", 150);
                lsv1.Columns.Add("Precio");
                // Consultas
                conexion.Open();
                comandosql.Connection = conexion;
                comandosql.CommandText = "SELECT id, ddr, nombre, precio FROM MemoriaRam";
                SqlDataReader reader = comandosql.ExecuteReader();
                while (reader.Read())
                {
                    ListViewItem item = new ListViewItem(reader["id"].ToString());
                    item.SubItems.Add(reader["ddr"].ToString());
                    item.SubItems.Add(reader["nombre"].ToString());
                    item.SubItems.Add(reader["precio"].ToString());
                    lsv1.Items.Add(item);
                }
                reader.Close();
                conexion.Close();
            }
            if (seleccion == "Fuente de Alimentación")
            {
                // Limpiar ListView
                lsv1.Items.Clear();
                lsv1.Columns.Clear();
                // Agregar columnas individualmente
                lsv1.Columns.Add("Id");
                lsv1.Columns.Add("Vatios");
                lsv1.Columns.Add("Nombre", 150);
                lsv1.Columns.Add("Precio");
                // Consultas
                conexion.Open();
                comandosql.Connection = conexion;
                comandosql.CommandText = "SELECT id, vatios, nombre, precio FROM FuenteDeAlimentacion";
                SqlDataReader reader = comandosql.ExecuteReader();
                while (reader.Read())
                {
                    ListViewItem item = new ListViewItem(reader["id"].ToString());
                    item.SubItems.Add(reader["vatios"].ToString());
                    item.SubItems.Add(reader["nombre"].ToString());
                    item.SubItems.Add(reader["precio"].ToString());
                    lsv1.Items.Add(item);
                }
                reader.Close();
                conexion.Close();
            }
            if (seleccion == "Placa Base")
            {
                // Limpiar ListView
                lsv1.Items.Clear();
                lsv1.Columns.Clear();
                // Agregar columnas individualmente
                lsv1.Columns.Add("Id");
                lsv1.Columns.Add("Categoria");
                lsv1.Columns.Add("Nombre", 150);
                lsv1.Columns.Add("Precio");
                // Consultas
                conexion.Open();
                comandosql.Connection = conexion;
                comandosql.CommandText = "SELECT id, categoria, nombre, precio FROM PlacasBase";
                SqlDataReader reader = comandosql.ExecuteReader();
                while (reader.Read())
                {
                    ListViewItem item = new ListViewItem(reader["id"].ToString());
                    item.SubItems.Add(reader["categoria"].ToString());
                    item.SubItems.Add(reader["nombre"].ToString());
                    item.SubItems.Add(reader["precio"].ToString());
                    lsv1.Items.Add(item);
                }
                reader.Close();
                conexion.Close();
            }
            if (seleccion == "Procesador")
            {
                // Limpiar ListView
                lsv1.Items.Clear();
                lsv1.Columns.Clear();
                // Agregar columnas individualmente
                lsv1.Columns.Add("Id");
                lsv1.Columns.Add("Ghz");
                lsv1.Columns.Add("Nombre", 150);
                lsv1.Columns.Add("Precio");
                // Consultas
                conexion.Open();
                comandosql.Connection = conexion;
                comandosql.CommandText = "SELECT id, ghz, nombre, precio FROM Procesador";
                SqlDataReader reader = comandosql.ExecuteReader();
                while (reader.Read())
                {
                    ListViewItem item = new ListViewItem(reader["id"].ToString());
                    item.SubItems.Add(reader["ghz"].ToString());
                    item.SubItems.Add(reader["nombre"].ToString());
                    item.SubItems.Add(reader["precio"].ToString());
                    lsv1.Items.Add(item);
                }
                reader.Close();
                conexion.Close();
            }
            if (seleccion == "Tarjeta Gráfica")
            {
                // Limpiar ListView
                lsv1.Items.Clear();
                lsv1.Columns.Clear();
                // Agregar columnas individualmente
                lsv1.Columns.Add("Id");
                lsv1.Columns.Add("Gb");
                lsv1.Columns.Add("Nombre", 150);
                lsv1.Columns.Add("Precio");
                // Consultas
                conexion.Open();
                comandosql.Connection = conexion;
                comandosql.CommandText = "SELECT id, gb, nombre, precio FROM TarjetasGraficas";
                SqlDataReader reader = comandosql.ExecuteReader();
                while (reader.Read())
                {
                    ListViewItem item = new ListViewItem(reader["id"].ToString());
                    item.SubItems.Add(reader["gb"].ToString());
                    item.SubItems.Add(reader["nombre"].ToString());
                    item.SubItems.Add(reader["precio"].ToString());
                    lsv1.Items.Add(item);
                }
                reader.Close();
                conexion.Close();
            }
        }

        private void Salirb_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (sfd1.ShowDialog() == DialogResult.OK)
            {
                StreamWriter documento = File.CreateText(sfd1.FileName);
                try
                {
                    decimal total = 0;
                    conexion.Open();
                    comandosql.Connection = conexion;
                    //Generamos la consulta de todos los datos que queremos imprimir
                    String query =
                        @"SELECT o.id AS OrdenadorID,
                        o.fecha AS Fecha, o.comprador AS Comprador,
                        d.nombre AS Disco, d.precio AS PrecioDisco,
                        f.nombre AS Fuente, f.precio AS PrecioFuente,
                        r.nombre AS RAM, r.precio AS PrecioRAM,
                        p.nombre AS Placa, p.precio AS PrecioPlaca,
                        g.nombre AS Grafica, g.precio AS PrecioGrafica,
                        pr.nombre AS Procesador, pr.precio AS PrecioProcesador
                    FROM Ordenador o
                    JOIN DiscoDuro d ON o.id_disco = d.id
                    JOIN FuenteDeAlimentacion f ON o.id_fuente = f.id
                    JOIN MemoriaRam r ON o.id_ram = r.Id
                    JOIN PlacasBase p ON o.id_placa = p.Id
                    JOIN TarjetasGraficas g ON o.id_grafica = g.id
                    JOIN Procesador pr ON o.id_procesador = pr.Id";

                    SqlCommand comando = new SqlCommand(query, conexion);
                    SqlDataReader lector = comando.ExecuteReader();
                    while (lector.Read())
                    {
                        //Calculamos el precio total
                        total = Convert.ToInt32(lector["PrecioDisco"]) + Convert.ToInt32(lector["PrecioFuente"]) +
                            Convert.ToInt32(lector["PrecioRAM"]) + Convert.ToInt32(lector["PrecioPlaca"]) +
                            Convert.ToInt32(lector["PrecioProcesador"]) + Convert.ToInt32(lector["PrecioGrafica"]);
                        //Imprimimos los datos en el documento
                        documento.WriteLine($"===Ordenador (ID:{lector["OrdenadorID"]}) creado en {lector["Fecha"]}===");
                        documento.WriteLine($"Disco duro: {lector["Disco"]}");
                        documento.WriteLine($"Fuente de Alimentacion: {lector["Fuente"]}");
                        documento.WriteLine($"Memoria RAM: {lector["RAM"]}");
                        documento.WriteLine($"Placa base: {lector["Placa"]}");
                        documento.WriteLine($"Procesador: {lector["Procesador"]}");
                        documento.WriteLine($"Tarjeta gráfica: {lector["Grafica"]}");
                        documento.WriteLine($"Comprador: {lector["Comprador"]}");
                        documento.WriteLine($"Precio total: " + total);
                        documento.WriteLine("");
                    }
                    documento.Close();
                    lector.Close();
                    conexion.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("No se ha podido acceder a la base de datos");
                }
            }
            else
            {
                MessageBox.Show("No se puede guardar correctamente.");
            }
        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {
            string nombreSeleccionado = comboBox2.SelectedItem?.ToString();
            if (string.IsNullOrEmpty(nombreSeleccionado)) return;

            lsv1.Items.Clear();
            lsv1.Columns.Clear();

            lsv1.Columns.Add("Nombre", 150);
            lsv1.Columns.Add("Descripción", 400);

            string connectionString = "server=(local)\\SQLEXPRESS;database=master;Integrated Security=SSPI;";
            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                string query = "SELECT Nombre, Descripcion FROM ProductosPredefinidos WHERE Nombre = @nombre";
                SqlCommand cmd = new SqlCommand(query, conn);
                cmd.Parameters.AddWithValue("@nombre", nombreSeleccionado);

                conn.Open();
                SqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read())
                {
                    ListViewItem item = new ListViewItem(reader["Nombre"].ToString());
                    item.SubItems.Add(reader["Descripcion"].ToString());

                    lsv1.Items.Add(item);
                }

                reader.Close();
            }

        }


        private void btnañadirpredeterminado_Click_1(object sender, EventArgs e)
        {
            string seleccion = comboBox2.SelectedItem?.ToString();


            Dictionary<string, int> pcTipos = new Dictionary<string, int>
            {
                { "PC Básico", 1 },
                { "PC Gama media", 2 },
                { "PC Creativo", 3 },
                { "PC Gaming", 4 },
                { "PC Profesional Pro", 5 }
            };

            if (seleccion != null && pcTipos.ContainsKey(seleccion))
            {
                listaTemporal.Clear();
                var componentes = new List<(string Tipo, int IdComponente)>();
                int idPcPredefinido = pcTipos[seleccion];

                using (SqlConnection conn = new SqlConnection("server=(local)\\SQLEXPRESS;database=master;Integrated Security=SSPI;"))
                {
                    conn.Open();


                    string query = "SELECT idComponente, TipoComponente FROM PcPredefinidoComponentes WHERE idPCPredefinido = @idPc";
                    using (SqlCommand cmd = new SqlCommand(query, conn))
                    {
                        cmd.Parameters.AddWithValue("@idPc", idPcPredefinido);
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                string tipo = reader["TipoComponente"].ToString();
                                int idComponente = Convert.ToInt32(reader["idComponente"]);
                                componentes.Add((tipo, idComponente));
                            }
                        }
                    }

                   

                    foreach (var comp in componentes)
                    {
                        string subQuery = $"SELECT nombre, precio FROM {comp.Tipo} WHERE id = @id";
                        using (SqlCommand subCmd = new SqlCommand(subQuery, conn))
                        {
                            subCmd.Parameters.AddWithValue("@id", comp.IdComponente);
                            using (SqlDataReader subReader = subCmd.ExecuteReader())
                            {
                                if (subReader.Read())
                                {
                                    string nombre = subReader["nombre"].ToString();
                                    decimal precio = Convert.ToDecimal(subReader["precio"]);

                                    listaTemporal.Add(new ComponenteSeleccionado
                                    {
                                        Tipo = comp.Tipo,
                                        Id = comp.IdComponente,
                                        Nombre = nombre,
                                        Precio = precio
                                    });
                                }
                            }
                        }
                    }
                }


                Componentes c = new Componentes(listaTemporal);
                c.Show();
            }
            else
            {
                MessageBox.Show("Por favor selecciona un tipo de PC válido.");
            }



        }
    }
}
