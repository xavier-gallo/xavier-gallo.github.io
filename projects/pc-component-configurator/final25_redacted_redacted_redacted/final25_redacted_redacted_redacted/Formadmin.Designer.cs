namespace PCComponentConfigurator
{
    partial class Formadmin
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Formadmin));
            this.dataGridView2 = new System.Windows.Forms.DataGridView();
            this.btnlimpiar = new System.Windows.Forms.Button();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.Modificar = new System.Windows.Forms.Button();
            this.btnsalir = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.Borrarb = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView2
            // 
            this.dataGridView2.BackgroundColor = System.Drawing.SystemColors.ControlLightLight;
            this.dataGridView2.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView2.Location = new System.Drawing.Point(21, 85);
            this.dataGridView2.Name = "dataGridView2";
            this.dataGridView2.RowHeadersWidth = 51;
            this.dataGridView2.RowTemplate.Height = 24;
            this.dataGridView2.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridView2.Size = new System.Drawing.Size(536, 267);
            this.dataGridView2.TabIndex = 0;
            // 
            // btnlimpiar
            // 
            this.btnlimpiar.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.btnlimpiar.Font = new System.Drawing.Font("ROG Fonts STRIX SCAR", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnlimpiar.Location = new System.Drawing.Point(586, 111);
            this.btnlimpiar.Name = "btnlimpiar";
            this.btnlimpiar.Size = new System.Drawing.Size(182, 65);
            this.btnlimpiar.TabIndex = 4;
            this.btnlimpiar.Text = "Limpiar";
            this.btnlimpiar.UseVisualStyleBackColor = false;
            this.btnlimpiar.Click += new System.EventHandler(this.btnlimpiar_Click);
            // 
            // comboBox1
            // 
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Items.AddRange(new object[] {
            "Compras",
            "DiscoDuro",
            "FuenteDeAlimentacion",
            "MemoriaRam",
            "Ordenador",
            "PlacasBase",
            "Procesador",
            "ProductosPredefinidos",
            "TarjetasGraficas",
            "Usuarios"});
            this.comboBox1.Location = new System.Drawing.Point(22, 397);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(212, 24);
            this.comboBox1.TabIndex = 5;
            this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
            // 
            // Modificar
            // 
            this.Modificar.Font = new System.Drawing.Font("ROG Fonts STRIX SCAR", 10.2F);
            this.Modificar.Location = new System.Drawing.Point(266, 395);
            this.Modificar.Name = "Modificar";
            this.Modificar.Size = new System.Drawing.Size(156, 41);
            this.Modificar.TabIndex = 2;
            this.Modificar.Text = "Modificar";
            this.Modificar.UseVisualStyleBackColor = true;
            this.Modificar.Click += new System.EventHandler(this.Modificar_Click);
            // 
            // btnsalir
            // 
            this.btnsalir.Font = new System.Drawing.Font("ROG Fonts STRIX SCAR", 10.2F);
            this.btnsalir.Location = new System.Drawing.Point(586, 282);
            this.btnsalir.Name = "btnsalir";
            this.btnsalir.Size = new System.Drawing.Size(182, 60);
            this.btnsalir.TabIndex = 6;
            this.btnsalir.Text = "Salir";
            this.btnsalir.UseVisualStyleBackColor = true;
            this.btnsalir.Click += new System.EventHandler(this.btnsalir_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(379, 34);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(0, 36);
            this.label1.TabIndex = 7;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.Color.Transparent;
            this.label2.Font = new System.Drawing.Font("ROG Fonts STRIX SCAR", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.Silver;
            this.label2.Location = new System.Drawing.Point(19, 365);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(386, 16);
            this.label2.TabIndex = 8;
            this.label2.Text = "Seleccione la tabla que desea modificar:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.BackColor = System.Drawing.Color.Transparent;
            this.label3.Font = new System.Drawing.Font("ROG Fonts STRIX SCAR", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.Silver;
            this.label3.Location = new System.Drawing.Point(15, 24);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(585, 35);
            this.label3.TabIndex = 9;
            this.label3.Text = "GESTION DE ADMINISTRADOR";
            // 
            // Borrarb
            // 
            this.Borrarb.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.Borrarb.Font = new System.Drawing.Font("ROG Fonts STRIX SCAR", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Borrarb.Location = new System.Drawing.Point(586, 194);
            this.Borrarb.Name = "Borrarb";
            this.Borrarb.Size = new System.Drawing.Size(182, 65);
            this.Borrarb.TabIndex = 10;
            this.Borrarb.Text = "Borrar fila";
            this.Borrarb.UseVisualStyleBackColor = false;
            this.Borrarb.Click += new System.EventHandler(this.Borrarb_Click);
            // 
            // Formadmin
            // 
            this.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.Borrarb);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnsalir);
            this.Controls.Add(this.comboBox1);
            this.Controls.Add(this.btnlimpiar);
            this.Controls.Add(this.Modificar);
            this.Controls.Add(this.dataGridView2);
            this.Name = "Formadmin";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        
        
        
        
       
        
        
        private System.Windows.Forms.DataGridView dataGridView2;
        private System.Windows.Forms.Button btnlimpiar;
        private System.Windows.Forms.ComboBox comboBox1;
        private System.Windows.Forms.Button Modificar;
        private System.Windows.Forms.Button btnsalir;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button Borrarb;
    }
}