USE [master]
GO
/****** Object:  Table [dbo].[Compras]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Compras](
	[Id] [int] NOT NULL,
	[IdUsuario] [int] NOT NULL,
	[IdOrdenador] [int] NOT NULL,
	[FechaCompra] [datetime] NOT NULL,
	[CorreoElectronico] [nchar](100) NOT NULL,
	[Direccion] [nchar](100) NOT NULL,
	[NombreComprador] [nchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DiscoDuro]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiscoDuro](
	[id] [int] NOT NULL,
	[gb] [int] NOT NULL,
	[nombre] [nchar](20) NOT NULL,
	[precio] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FuenteDeAlimentacion]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FuenteDeAlimentacion](
	[id] [int] NOT NULL,
	[vatios] [int] NOT NULL,
	[nombre] [nchar](20) NOT NULL,
	[precio] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MemoriaRam]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MemoriaRam](
	[Id] [int] NOT NULL,
	[nombre] [nvarchar](200) NOT NULL,
	[ddr] [int] NOT NULL,
	[precio] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ordenador]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ordenador](
	[id] [int] NOT NULL,
	[id_disco] [int] NOT NULL,
	[id_fuente] [int] NOT NULL,
	[id_ram] [int] NOT NULL,
	[id_placa] [int] NOT NULL,
	[id_grafica] [int] NOT NULL,
	[id_procesador] [int] NOT NULL,
	[fecha] [datetime] NOT NULL,
	[comprador] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PCPredefinidoComponentes]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PCPredefinidoComponentes](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[IdPCPredefinido] [int] NOT NULL,
	[TipoComponente] [nvarchar](50) NOT NULL,
	[IdComponente] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PlacasBase]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PlacasBase](
	[Id] [int] NOT NULL,
	[nombre] [nchar](20) NOT NULL,
	[categoria] [nchar](20) NOT NULL,
	[precio] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Procesador]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Procesador](
	[Id] [int] NOT NULL,
	[ghz] [float] NOT NULL,
	[nombre] [nchar](20) NOT NULL,
	[precio] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductosPredefinidos]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductosPredefinidos](
	[Id] [int] NOT NULL,
	[IdOrdenador] [int] NOT NULL,
	[Nombre] [nchar](50) NOT NULL,
	[Descripcion] [nchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Table]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Table](
	[Id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TarjetasGraficas]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TarjetasGraficas](
	[id] [int] NOT NULL,
	[nombre] [nchar](20) NOT NULL,
	[gb] [int] NOT NULL,
	[precio] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 20/05/2025 23:22:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuarios](
	[Id] [int] NOT NULL,
	[NombreUsuario] [nchar](50) NOT NULL,
	[Contrasena] [nchar](100) NOT NULL,
	[Rol] [nchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[DiscoDuro] ([id], [gb], [nombre], [precio]) VALUES (1, 257, N'Kingston SSD        ', 40)
INSERT [dbo].[DiscoDuro] ([id], [gb], [nombre], [precio]) VALUES (2, 512, N'Samsung EVO         ', 65)
INSERT [dbo].[DiscoDuro] ([id], [gb], [nombre], [precio]) VALUES (3, 1024, N'WD Blue             ', 90)
INSERT [dbo].[DiscoDuro] ([id], [gb], [nombre], [precio]) VALUES (4, 2048, N'Seagate BarraCuda   ', 120)
INSERT [dbo].[DiscoDuro] ([id], [gb], [nombre], [precio]) VALUES (5, 512, N'Crucial MX500       ', 70)
GO
INSERT [dbo].[FuenteDeAlimentacion] ([id], [vatios], [nombre], [precio]) VALUES (1, 451, N'EVGA 450W           ', 45)
INSERT [dbo].[FuenteDeAlimentacion] ([id], [vatios], [nombre], [precio]) VALUES (2, 550, N'Corsair CV550       ', 55)
INSERT [dbo].[FuenteDeAlimentacion] ([id], [vatios], [nombre], [precio]) VALUES (3, 650, N'Aerocool VX Plus    ', 50)
INSERT [dbo].[FuenteDeAlimentacion] ([id], [vatios], [nombre], [precio]) VALUES (4, 750, N'Thermaltake Smart   ', 80)
INSERT [dbo].[FuenteDeAlimentacion] ([id], [vatios], [nombre], [precio]) VALUES (5, 850, N'CoolerMaster MWE    ', 100)
GO
INSERT [dbo].[MemoriaRam] ([Id], [nombre], [ddr], [precio]) VALUES (1, N'HyperX Fury 8GB', 4, 35)
INSERT [dbo].[MemoriaRam] ([Id], [nombre], [ddr], [precio]) VALUES (2, N'Corsair Vengeance 16GB', 4, 65)
INSERT [dbo].[MemoriaRam] ([Id], [nombre], [ddr], [precio]) VALUES (3, N'G.Skill Ripjaws 32GB', 4, 120)
INSERT [dbo].[MemoriaRam] ([Id], [nombre], [ddr], [precio]) VALUES (4, N'Kingston Fury Beast 16GB', 5, 80)
INSERT [dbo].[MemoriaRam] ([Id], [nombre], [ddr], [precio]) VALUES (5, N'Patriot Viper Steel 32GB', 5, 130)
GO
INSERT [dbo].[Ordenador] ([id], [id_disco], [id_fuente], [id_ram], [id_placa], [id_grafica], [id_procesador], [fecha], [comprador]) VALUES (1, 1, 1, 1, 1, 1, 1, CAST(N'2025-05-20T15:41:29.233' AS DateTime), N'')
INSERT [dbo].[Ordenador] ([id], [id_disco], [id_fuente], [id_ram], [id_placa], [id_grafica], [id_procesador], [fecha], [comprador]) VALUES (2, 2, 2, 2, 2, 2, 2, CAST(N'2025-05-20T15:41:29.233' AS DateTime), N'')
INSERT [dbo].[Ordenador] ([id], [id_disco], [id_fuente], [id_ram], [id_placa], [id_grafica], [id_procesador], [fecha], [comprador]) VALUES (3, 3, 3, 3, 3, 3, 3, CAST(N'2025-05-20T15:41:29.233' AS DateTime), N'')
INSERT [dbo].[Ordenador] ([id], [id_disco], [id_fuente], [id_ram], [id_placa], [id_grafica], [id_procesador], [fecha], [comprador]) VALUES (4, 4, 4, 4, 4, 4, 4, CAST(N'2025-05-20T15:41:29.233' AS DateTime), N'')
INSERT [dbo].[Ordenador] ([id], [id_disco], [id_fuente], [id_ram], [id_placa], [id_grafica], [id_procesador], [fecha], [comprador]) VALUES (5, 5, 5, 5, 5, 5, 5, CAST(N'2025-05-20T15:41:29.233' AS DateTime), N'')
INSERT [dbo].[Ordenador] ([id], [id_disco], [id_fuente], [id_ram], [id_placa], [id_grafica], [id_procesador], [fecha], [comprador]) VALUES (6, 1, 1, 1, 4, 4, 2, CAST(N'2025-05-20T23:17:38.333' AS DateTime), N'xavier')
GO
SET IDENTITY_INSERT [dbo].[PCPredefinidoComponentes] ON 

INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (1, 1, N'DiscoDuro', 1)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (2, 1, N'FuenteDeAlimentacion', 1)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (3, 1, N'MemoriaRam', 1)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (4, 1, N'PlacasBase', 1)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (5, 1, N'Procesador', 1)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (6, 1, N'TarjetasGraficas', 1)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (7, 2, N'DiscoDuro', 2)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (8, 2, N'FuenteDeAlimentacion', 2)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (9, 2, N'MemoriaRam', 2)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (10, 2, N'PlacasBase', 2)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (11, 2, N'Procesador', 2)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (12, 2, N'TarjetasGraficas', 2)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (13, 3, N'DiscoDuro', 3)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (14, 3, N'FuenteDeAlimentacion', 3)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (15, 3, N'MemoriaRam', 3)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (16, 3, N'PlacasBase', 3)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (17, 3, N'Procesador', 3)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (18, 3, N'TarjetasGraficas', 3)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (19, 4, N'DiscoDuro', 4)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (20, 4, N'FuenteDeAlimentacion', 4)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (21, 4, N'MemoriaRam', 4)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (22, 4, N'PlacasBase', 4)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (23, 4, N'Procesador', 4)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (24, 4, N'TarjetasGraficas', 4)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (25, 5, N'DiscoDuro', 5)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (26, 5, N'FuenteDeAlimentacion', 5)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (27, 5, N'MemoriaRam', 5)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (28, 5, N'PlacasBase', 5)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (29, 5, N'Procesador', 5)
INSERT [dbo].[PCPredefinidoComponentes] ([Id], [IdPCPredefinido], [TipoComponente], [IdComponente]) VALUES (30, 5, N'TarjetasGraficas', 5)
SET IDENTITY_INSERT [dbo].[PCPredefinidoComponentes] OFF
GO
INSERT [dbo].[PlacasBase] ([Id], [nombre], [categoria], [precio]) VALUES (1, N'ASUS TUF B550M      ', N'mATX                ', 110)
INSERT [dbo].[PlacasBase] ([Id], [nombre], [categoria], [precio]) VALUES (2, N'MSI B450 Tomahawk   ', N'ATX                 ', 100)
INSERT [dbo].[PlacasBase] ([Id], [nombre], [categoria], [precio]) VALUES (3, N'Gigabyte B660M      ', N'mATX                ', 120)
INSERT [dbo].[PlacasBase] ([Id], [nombre], [categoria], [precio]) VALUES (4, N'ASRock X570 Phantom ', N'ATX                 ', 150)
INSERT [dbo].[PlacasBase] ([Id], [nombre], [categoria], [precio]) VALUES (5, N'Biostar B365        ', N'mATX                ', 85)
GO
INSERT [dbo].[Procesador] ([Id], [ghz], [nombre], [precio]) VALUES (1, 3.5, N'Intel Core i3-10100 ', 90)
INSERT [dbo].[Procesador] ([Id], [ghz], [nombre], [precio]) VALUES (2, 3.6, N'Intel Core i5-10400F', 130)
INSERT [dbo].[Procesador] ([Id], [ghz], [nombre], [precio]) VALUES (3, 4, N'AMD Ryzen 5 5600G   ', 150)
INSERT [dbo].[Procesador] ([Id], [ghz], [nombre], [precio]) VALUES (4, 4.2, N'Intel Core i7-10700K', 280)
INSERT [dbo].[Procesador] ([Id], [ghz], [nombre], [precio]) VALUES (5, 3.8, N'AMD Ryzen 7 5800X   ', 320)
GO
INSERT [dbo].[ProductosPredefinidos] ([Id], [IdOrdenador], [Nombre], [Descripcion]) VALUES (1, 1, N'PC Básico                                         ', N'Ideal para tareas de oficina y navegación web                                                       ')
INSERT [dbo].[ProductosPredefinidos] ([Id], [IdOrdenador], [Nombre], [Descripcion]) VALUES (2, 2, N'PC Gama Media                                     ', N'Perfecto para multitarea y uso doméstico                                                            ')
INSERT [dbo].[ProductosPredefinidos] ([Id], [IdOrdenador], [Nombre], [Descripcion]) VALUES (3, 3, N'PC Creativo                                       ', N'Recomendado para diseño gráfico y edición básica                                                    ')
INSERT [dbo].[ProductosPredefinidos] ([Id], [IdOrdenador], [Nombre], [Descripcion]) VALUES (4, 4, N'PC Gaming                                         ', N'Potente para juegos AAA en 1080p y 1440p                                                            ')
INSERT [dbo].[ProductosPredefinidos] ([Id], [IdOrdenador], [Nombre], [Descripcion]) VALUES (5, 5, N'PC Profesional Pro                                ', N'Alto rendimiento para producción, streaming y desarrollo                                            ')
GO
INSERT [dbo].[TarjetasGraficas] ([id], [nombre], [gb], [precio]) VALUES (1, N'NVIDIA GTX 1650     ', 4, 180)
INSERT [dbo].[TarjetasGraficas] ([id], [nombre], [gb], [precio]) VALUES (2, N'NVIDIA RTX 3060 Ti  ', 8, 400)
INSERT [dbo].[TarjetasGraficas] ([id], [nombre], [gb], [precio]) VALUES (3, N'AMD RX 580          ', 8, 190)
INSERT [dbo].[TarjetasGraficas] ([id], [nombre], [gb], [precio]) VALUES (4, N'NVIDIA RTX 3070     ', 8, 500)
INSERT [dbo].[TarjetasGraficas] ([id], [nombre], [gb], [precio]) VALUES (5, N'AMD RX 6700 XT      ', 12, 470)
GO
INSERT [dbo].[Usuarios] ([Id], [NombreUsuario], [Contrasena], [Rol]) VALUES (1, N'admin                                             ', N'admin123                                                                                            ', N'Admin               ')
INSERT [dbo].[Usuarios] ([Id], [NombreUsuario], [Contrasena], [Rol]) VALUES (2, N'juan                          juana               ', N'juan123                                                                                             ', N'Cliente             ')
INSERT [dbo].[Usuarios] ([Id], [NombreUsuario], [Contrasena], [Rol]) VALUES (3, N'maria                                             ', N'maria123                                                                                            ', N'Cliente             ')
INSERT [dbo].[Usuarios] ([Id], [NombreUsuario], [Contrasena], [Rol]) VALUES (6, N'melisa                                            ', N'melisa123                                                                                           ', N'Cliente             ')
INSERT [dbo].[Usuarios] ([Id], [NombreUsuario], [Contrasena], [Rol]) VALUES (7, N'juan                                              ', N'juan123                                                                                             ', N'Cliente             ')
INSERT [dbo].[Usuarios] ([Id], [NombreUsuario], [Contrasena], [Rol]) VALUES (11, N'X                                                 ', N'X                                                                                                   ', N'Cliente             ')
GO
ALTER TABLE [dbo].[Ordenador] ADD  DEFAULT (getdate()) FOR [fecha]
GO
ALTER TABLE [dbo].[Ordenador] ADD  DEFAULT ('') FOR [comprador]
GO
ALTER TABLE [dbo].[Compras]  WITH CHECK ADD  CONSTRAINT [FK_Compras_Ordenador] FOREIGN KEY([IdOrdenador])
REFERENCES [dbo].[Ordenador] ([id])
GO
ALTER TABLE [dbo].[Compras] CHECK CONSTRAINT [FK_Compras_Ordenador]
GO
ALTER TABLE [dbo].[Compras]  WITH CHECK ADD  CONSTRAINT [FK_Compras_Usuarios] FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[Usuarios] ([Id])
GO
ALTER TABLE [dbo].[Compras] CHECK CONSTRAINT [FK_Compras_Usuarios]
GO
ALTER TABLE [dbo].[Ordenador]  WITH CHECK ADD  CONSTRAINT [FK_Ordenador_Disco] FOREIGN KEY([id_disco])
REFERENCES [dbo].[DiscoDuro] ([id])
GO
ALTER TABLE [dbo].[Ordenador] CHECK CONSTRAINT [FK_Ordenador_Disco]
GO
ALTER TABLE [dbo].[Ordenador]  WITH CHECK ADD  CONSTRAINT [FK_Ordenador_Fuente] FOREIGN KEY([id_fuente])
REFERENCES [dbo].[FuenteDeAlimentacion] ([id])
GO
ALTER TABLE [dbo].[Ordenador] CHECK CONSTRAINT [FK_Ordenador_Fuente]
GO
ALTER TABLE [dbo].[Ordenador]  WITH CHECK ADD  CONSTRAINT [FK_Ordenador_Grafica] FOREIGN KEY([id_grafica])
REFERENCES [dbo].[TarjetasGraficas] ([id])
GO
ALTER TABLE [dbo].[Ordenador] CHECK CONSTRAINT [FK_Ordenador_Grafica]
GO
ALTER TABLE [dbo].[Ordenador]  WITH CHECK ADD  CONSTRAINT [FK_Ordenador_Placa] FOREIGN KEY([id_placa])
REFERENCES [dbo].[PlacasBase] ([Id])
GO
ALTER TABLE [dbo].[Ordenador] CHECK CONSTRAINT [FK_Ordenador_Placa]
GO
ALTER TABLE [dbo].[Ordenador]  WITH CHECK ADD  CONSTRAINT [FK_Ordenador_Procesador] FOREIGN KEY([id_procesador])
REFERENCES [dbo].[Procesador] ([Id])
GO
ALTER TABLE [dbo].[Ordenador] CHECK CONSTRAINT [FK_Ordenador_Procesador]
GO
ALTER TABLE [dbo].[PCPredefinidoComponentes]  WITH CHECK ADD  CONSTRAINT [FK_PCPredefinido] FOREIGN KEY([IdPCPredefinido])
REFERENCES [dbo].[ProductosPredefinidos] ([Id])
GO
ALTER TABLE [dbo].[PCPredefinidoComponentes] CHECK CONSTRAINT [FK_PCPredefinido]
GO
ALTER TABLE [dbo].[ProductosPredefinidos]  WITH CHECK ADD  CONSTRAINT [FK_ProdPredef_Ordenador] FOREIGN KEY([IdOrdenador])
REFERENCES [dbo].[Ordenador] ([id])
GO
ALTER TABLE [dbo].[ProductosPredefinidos] CHECK CONSTRAINT [FK_ProdPredef_Ordenador]
GO
