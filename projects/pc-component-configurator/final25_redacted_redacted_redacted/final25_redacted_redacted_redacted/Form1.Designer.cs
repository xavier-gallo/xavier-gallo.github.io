namespace PCComponentConfigurator
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.AñadirComponenteb = new System.Windows.Forms.Button();
            this.lsv1 = new System.Windows.Forms.ListView();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.MostarAñadidosb = new System.Windows.Forms.Button();
            this.Salirb = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.sfd1 = new System.Windows.Forms.SaveFileDialog();
            this.btnañadirpredeterminado = new System.Windows.Forms.Button();
            this.comboBox2 = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // AñadirComponenteb
            // 
            this.AñadirComponenteb.Cursor = System.Windows.Forms.Cursors.Hand;
            this.AñadirComponenteb.Font = new System.Drawing.Font("Palatino Linotype", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.AñadirComponenteb.Location = new System.Drawing.Point(576, 165);
            this.AñadirComponenteb.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.AñadirComponenteb.Name = "AñadirComponenteb";
            this.AñadirComponenteb.Size = new System.Drawing.Size(209, 49);
            this.AñadirComponenteb.TabIndex = 2;
            this.AñadirComponenteb.Text = "Añadir Componente";
            this.AñadirComponenteb.UseVisualStyleBackColor = true;
            this.AñadirComponenteb.Click += new System.EventHandler(this.AñadirComponenteb_Click);
            // 
            // lsv1
            // 
            this.lsv1.FullRowSelect = true;
            this.lsv1.HideSelection = false;
            this.lsv1.Location = new System.Drawing.Point(36, 110);
            this.lsv1.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.lsv1.Name = "lsv1";
            this.lsv1.Size = new System.Drawing.Size(523, 218);
            this.lsv1.TabIndex = 3;
            this.lsv1.UseCompatibleStateImageBehavior = false;
            this.lsv1.View = System.Windows.Forms.View.Details;
            // 
            // comboBox1
            // 
            this.comboBox1.Cursor = System.Windows.Forms.Cursors.Help;
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Items.AddRange(new object[] {
            "Disco Duro",
            "Fuente de Alimentación",
            "Memoria RAM",
            "Placa Base",
            "Procesador",
            "Tarjeta Gráfica"});
            this.comboBox1.Location = new System.Drawing.Point(577, 123);
            this.comboBox1.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(144, 24);
            this.comboBox1.TabIndex = 4;
            this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Font = new System.Drawing.Font("ROG Fonts STRIX SCAR", 22.2F, System.Drawing.FontStyle.Bold);
            this.label1.ForeColor = System.Drawing.Color.Silver;
            this.label1.Location = new System.Drawing.Point(12, 42);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(716, 45);
            this.label1.TabIndex = 6;
            this.label1.Text = "Componentes Disponibles";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.Color.Transparent;
            this.label2.Font = new System.Drawing.Font("Palatino Linotype", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.Silver;
            this.label2.Location = new System.Drawing.Point(574, 100);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(161, 21);
            this.label2.TabIndex = 7;
            this.label2.Text = "Seleccionar categoria:";
            // 
            // MostarAñadidosb
            // 
            this.MostarAñadidosb.Cursor = System.Windows.Forms.Cursors.Hand;
            this.MostarAñadidosb.Font = new System.Drawing.Font("Palatino Linotype", 8.25F);
            this.MostarAñadidosb.Location = new System.Drawing.Point(576, 219);
            this.MostarAñadidosb.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.MostarAñadidosb.Name = "MostarAñadidosb";
            this.MostarAñadidosb.Size = new System.Drawing.Size(209, 49);
            this.MostarAñadidosb.TabIndex = 8;
            this.MostarAñadidosb.Text = "Mostrar lista de Componentes añadidos";
            this.MostarAñadidosb.UseVisualStyleBackColor = true;
            this.MostarAñadidosb.Click += new System.EventHandler(this.MostarAñadidosb_Click);
            // 
            // Salirb
            // 
            this.Salirb.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Salirb.Font = new System.Drawing.Font("Palatino Linotype", 8.25F);
            this.Salirb.Location = new System.Drawing.Point(576, 335);
            this.Salirb.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Salirb.Name = "Salirb";
            this.Salirb.Size = new System.Drawing.Size(209, 49);
            this.Salirb.TabIndex = 9;
            this.Salirb.Text = "Salir del programa";
            this.Salirb.UseVisualStyleBackColor = true;
            this.Salirb.Click += new System.EventHandler(this.Salirb_Click);
            // 
            // button1
            // 
            this.button1.Font = new System.Drawing.Font("Palatino Linotype", 8.25F);
            this.button1.Location = new System.Drawing.Point(577, 274);
            this.button1.Margin = new System.Windows.Forms.Padding(4);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(208, 54);
            this.button1.TabIndex = 10;
            this.button1.Text = "Guardar historial de compras";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // sfd1
            // 
            this.sfd1.Filter = "Documento de texto|*.txt";
            // 
            // btnañadirpredeterminado
            // 
            this.btnañadirpredeterminado.Font = new System.Drawing.Font("Times New Roman", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnañadirpredeterminado.Location = new System.Drawing.Point(237, 385);
            this.btnañadirpredeterminado.Name = "btnañadirpredeterminado";
            this.btnañadirpredeterminado.Size = new System.Drawing.Size(207, 50);
            this.btnañadirpredeterminado.TabIndex = 12;
            this.btnañadirpredeterminado.Text = "Añadir componentes del pc predeterminado";
            this.btnañadirpredeterminado.UseVisualStyleBackColor = true;
            this.btnañadirpredeterminado.Click += new System.EventHandler(this.btnañadirpredeterminado_Click_1);
            // 
            // comboBox2
            // 
            this.comboBox2.FormattingEnabled = true;
            this.comboBox2.Items.AddRange(new object[] {
            "PC Básico",
            "PC Gama media",
            "PC Creativo",
            "PC Gaming",
            "PC Profesional Pro"});
            this.comboBox2.Location = new System.Drawing.Point(36, 385);
            this.comboBox2.Name = "comboBox2";
            this.comboBox2.Size = new System.Drawing.Size(166, 24);
            this.comboBox2.TabIndex = 11;
            this.comboBox2.SelectedIndexChanged += new System.EventHandler(this.comboBox2_SelectedIndexChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.BackColor = System.Drawing.Color.Transparent;
            this.label3.Font = new System.Drawing.Font("Palatino Linotype", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.Silver;
            this.label3.Location = new System.Drawing.Point(30, 351);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(224, 23);
            this.label3.TabIndex = 13;
            this.label3.Text = "Ordenadores Prefabricados:";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(800, 466);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.btnañadirpredeterminado);
            this.Controls.Add(this.comboBox2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.Salirb);
            this.Controls.Add(this.MostarAñadidosb);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.comboBox1);
            this.Controls.Add(this.lsv1);
            this.Controls.Add(this.AñadirComponenteb);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button AñadirComponenteb;
        private System.Windows.Forms.ListView lsv1;
        private System.Windows.Forms.ComboBox comboBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button MostarAñadidosb;
        private System.Windows.Forms.Button Salirb;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.SaveFileDialog sfd1;
        private System.Windows.Forms.Button btnañadirpredeterminado;
        private System.Windows.Forms.ComboBox comboBox2;
        private System.Windows.Forms.Label label3;
    }
}

