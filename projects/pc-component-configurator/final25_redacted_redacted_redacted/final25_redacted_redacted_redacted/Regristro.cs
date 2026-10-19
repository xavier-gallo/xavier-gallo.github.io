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
    public partial class Regristro : Form
    {
        public Regristro()
        {
            InitializeComponent();
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

      

        private void label1_Click(object sender, EventArgs e)
        {

        }

       

        private void btniniciar_Click(object sender, EventArgs e)
        {
            string connectionString = "server=(local)\\SQLEXPRESS;database=master; Integrated Security = SSPI";
            string usuario = txtusuario.Text;
            string contrasena = txtcontraseña.Text;
            try
            {
                using (SqlConnection conn = new SqlConnection(connectionString))
                {
                    string query = "SELECT Id, Rol FROM Usuarios WHERE NombreUsuario = @usuario AND Contrasena = @contrasena";
                    SqlCommand cmd = new SqlCommand(query, conn);
                    cmd.Parameters.AddWithValue("@usuario", usuario);
                    cmd.Parameters.AddWithValue("@contrasena", contrasena);

                    conn.Open();
                    SqlDataReader reader = cmd.ExecuteReader();

                    if (reader.Read())
                    {
                        string rol = reader["Rol"].ToString().Trim();
                        int idUsuario = Convert.ToInt32(reader["Id"]);

                        if (rol == "Cliente")
                        {
                            this.Hide();
                            Form1 formCliente = new Form1(idUsuario);
                            formCliente.Show();
                            formCliente.FormClosed += (s, args) => this.Close();
                        }
                        else if (rol == "Admin")
                        {
                            Formadmin formAdmin = new Formadmin();
                            formAdmin.Show();
                            formAdmin.FormClosed += (s, args) => this.Close();
                        }
                    }
                    else
                    {
                        MessageBox.Show("Credenciales incorrectas.");
                    }

                    reader.Close();
                }
            }
            catch (SqlException ex)
            {
                MessageBox.Show("Error de base de datos: " + ex.Message);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ocurrió un error: " + ex.Message);
            }
        }

        private void btnregistro_Click(object sender, EventArgs e)
        {
            string connectionString = "server=(local)\\SQLEXPRESS;database=master; Integrated Security = SSPI";
            string usuario = txtusuario.Text.Trim();
            string contrasena = txtcontraseña.Text.Trim();

            if (string.IsNullOrEmpty(usuario) || string.IsNullOrEmpty(contrasena))
            {
                MessageBox.Show("Por favor, complete todos los campos.");
                return;
            }

            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                conn.Open();

                
                string checkQuery = "SELECT COUNT(*) FROM Usuarios WHERE NombreUsuario = @usuario";
                SqlCommand checkCmd = new SqlCommand(checkQuery, conn);
                checkCmd.Parameters.AddWithValue("@usuario", usuario);
                int count = (int)checkCmd.ExecuteScalar();

                if (count > 0)
                {
                    MessageBox.Show("El nombre de usuario ya existe.");
                    return;
                }

                
                string getIdQuery = "SELECT ISNULL(MAX(Id), 0) + 1 FROM Usuarios";
                SqlCommand getIdCmd = new SqlCommand(getIdQuery, conn);
                int nuevoId = (int)getIdCmd.ExecuteScalar();

                
                string insertQuery = "INSERT INTO Usuarios (Id, NombreUsuario, Contrasena, Rol) VALUES (@id, @usuario, @contrasena, @rol)";
                SqlCommand insertCmd = new SqlCommand(insertQuery, conn);
                insertCmd.Parameters.AddWithValue("@id", nuevoId);
                insertCmd.Parameters.AddWithValue("@usuario", usuario);
                insertCmd.Parameters.AddWithValue("@contrasena", contrasena);
                insertCmd.Parameters.AddWithValue("@rol", "Cliente");

                int result = insertCmd.ExecuteNonQuery();

                if (result > 0)
                {
                    MessageBox.Show("Registro exitoso. Ahora puedes iniciar sesión.");
                    txtusuario.Text = "";
                    txtcontraseña.Text = "";
                }
                else
                {
                    MessageBox.Show("Error al registrar el usuario.");
                }
            }
        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void Regristro_Load(object sender, EventArgs e)
        {

        }
    }
}
