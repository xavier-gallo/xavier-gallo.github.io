namespace PCComponentConfigurator
{
    partial class Componentes
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Componentes));
            this.label1 = new System.Windows.Forms.Label();
            this.listView1 = new System.Windows.Forms.ListView();
            this.Tipo = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Nombre = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Precio = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Volverb = new System.Windows.Forms.Button();
            this.FinaliarCreacionb = new System.Windows.Forms.Button();
            this.Borrarb = new System.Windows.Forms.Button();
            this.tb3 = new System.Windows.Forms.TextBox();
            this.tb2 = new System.Windows.Forms.TextBox();
            this.tb1 = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Font = new System.Drawing.Font("ROG Fonts STRIX SCAR", 22.2F, System.Drawing.FontStyle.Bold);
            this.label1.ForeColor = System.Drawing.Color.Silver;
            this.label1.Location = new System.Drawing.Point(12, 22);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(631, 45);
            this.label1.TabIndex = 7;
            this.label1.Text = "Componentes Añadidos";
            // 
            // listView1
            // 
            this.listView1.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.Tipo,
            this.Nombre,
            this.Precio});
            this.listView1.FullRowSelect = true;
            this.listView1.HideSelection = false;
            this.listView1.Location = new System.Drawing.Point(21, 75);
            this.listView1.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.listView1.Name = "listView1";
            this.listView1.Size = new System.Drawing.Size(505, 249);
            this.listView1.TabIndex = 8;
            this.listView1.UseCompatibleStateImageBehavior = false;
            this.listView1.View = System.Windows.Forms.View.Details;
            this.listView1.SelectedIndexChanged += new System.EventHandler(this.listView1_SelectedIndexChanged);
            // 
            // Tipo
            // 
            this.Tipo.Text = "Tipo";
            this.Tipo.Width = 127;
            // 
            // Nombre
            // 
            this.Nombre.Text = "Nombre";
            this.Nombre.Width = 170;
            // 
            // Precio
            // 
            this.Precio.Text = "Precio";
            this.Precio.Width = 65;
            // 
            // Volverb
            // 
            this.Volverb.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Volverb.Font = new System.Drawing.Font("Palatino Linotype", 8.25F);
            this.Volverb.Location = new System.Drawing.Point(43, 368);
            this.Volverb.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Volverb.Name = "Volverb";
            this.Volverb.Size = new System.Drawing.Size(212, 58);
            this.Volverb.TabIndex = 9;
            this.Volverb.Text = "Volver";
            this.Volverb.UseVisualStyleBackColor = true;
            this.Volverb.Click += new System.EventHandler(this.Volverb_Click);
            // 
            // FinaliarCreacionb
            // 
            this.FinaliarCreacionb.Cursor = System.Windows.Forms.Cursors.Hand;
            this.FinaliarCreacionb.Font = new System.Drawing.Font("Palatino Linotype", 8.25F);
            this.FinaliarCreacionb.Location = new System.Drawing.Point(541, 370);
            this.FinaliarCreacionb.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.FinaliarCreacionb.Name = "FinaliarCreacionb";
            this.FinaliarCreacionb.Size = new System.Drawing.Size(209, 55);
            this.FinaliarCreacionb.TabIndex = 10;
            this.FinaliarCreacionb.Text = "Finalizar Creación";
            this.FinaliarCreacionb.UseVisualStyleBackColor = true;
            this.FinaliarCreacionb.Click += new System.EventHandler(this.FinaliarCreacionb_Click);
            // 
            // Borrarb
            // 
            this.Borrarb.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Borrarb.Font = new System.Drawing.Font("Palatino Linotype", 8.25F);
            this.Borrarb.Location = new System.Drawing.Point(291, 370);
            this.Borrarb.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Borrarb.Name = "Borrarb";
            this.Borrarb.Size = new System.Drawing.Size(209, 55);
            this.Borrarb.TabIndex = 11;
            this.Borrarb.Text = "Borrar Seleccionado";
            this.Borrarb.UseVisualStyleBackColor = true;
            this.Borrarb.Click += new System.EventHandler(this.Borrarb_Click_1);
            // 
            // tb3
            // 
            this.tb3.Location = new System.Drawing.Point(545, 300);
            this.tb3.Margin = new System.Windows.Forms.Padding(4);
            this.tb3.Name = "tb3";
            this.tb3.Size = new System.Drawing.Size(208, 22);
            this.tb3.TabIndex = 12;
            // 
            // tb2
            // 
            this.tb2.Location = new System.Drawing.Point(545, 245);
            this.tb2.Margin = new System.Windows.Forms.Padding(4);
            this.tb2.Name = "tb2";
            this.tb2.Size = new System.Drawing.Size(204, 22);
            this.tb2.TabIndex = 15;
            // 
            // tb1
            // 
            this.tb1.Location = new System.Drawing.Point(545, 191);
            this.tb1.Margin = new System.Windows.Forms.Padding(4);
            this.tb1.Name = "tb1";
            this.tb1.Size = new System.Drawing.Size(204, 22);
            this.tb1.TabIndex = 16;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.BackColor = System.Drawing.Color.Transparent;
            this.label5.Font = new System.Drawing.Font("Palatino Linotype", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.ForeColor = System.Drawing.Color.Silver;
            this.label5.Location = new System.Drawing.Point(540, 166);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(140, 21);
            this.label5.TabIndex = 18;
            this.label5.Text = "Correo Electrónico";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.BackColor = System.Drawing.Color.Transparent;
            this.label4.Font = new System.Drawing.Font("Palatino Linotype", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.ForeColor = System.Drawing.Color.Silver;
            this.label4.Location = new System.Drawing.Point(544, 220);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(78, 21);
            this.label4.TabIndex = 19;
            this.label4.Text = "Dirección";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.Color.Transparent;
            this.label2.Font = new System.Drawing.Font("Palatino Linotype", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.Silver;
            this.label2.Location = new System.Drawing.Point(544, 275);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(179, 21);
            this.label2.TabIndex = 20;
            this.label2.Text = "Nombre Del Comprador";
            // 
            // Componentes
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.tb1);
            this.Controls.Add(this.tb2);
            this.Controls.Add(this.tb3);
            this.Controls.Add(this.Borrarb);
            this.Controls.Add(this.FinaliarCreacionb);
            this.Controls.Add(this.Volverb);
            this.Controls.Add(this.listView1);
            this.Controls.Add(this.label1);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "Componentes";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = " ";
            this.Load += new System.EventHandler(this.Componentes_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ListView listView1;
        private System.Windows.Forms.Button Volverb;
        private System.Windows.Forms.Button FinaliarCreacionb;
        private System.Windows.Forms.Button Borrarb;
        private System.Windows.Forms.ColumnHeader Tipo;
        private System.Windows.Forms.ColumnHeader Nombre;
        private System.Windows.Forms.ColumnHeader Precio;
        private System.Windows.Forms.TextBox tb3;
        private System.Windows.Forms.TextBox tb2;
        private System.Windows.Forms.TextBox tb1;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label2;
    }
}