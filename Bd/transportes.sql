-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-12-2016 a las 08:43:26
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `transportes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chofer`
--

CREATE TABLE IF NOT EXISTS `chofer` (
  `cedula` int(11) NOT NULL,
  `nombres` varchar(200) NOT NULL,
  `apellidos` varchar(200) NOT NULL,
  `edad` int(11) NOT NULL,
  `telefono` int(11) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `chofer`
--

INSERT INTO `chofer` (`cedula`, `nombres`, `apellidos`, `edad`, `telefono`, `direccion`) VALUES
(55, 'ff', 'fdf', 4, -5, 'dvd'),
(25311294, 'geraldo andres', 'jimenez', 18, 426265592, 'ffff');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dinero`
--

CREATE TABLE IF NOT EXISTS `dinero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idservicio` varchar(11) NOT NULL,
  `Seguro` varchar(60) NOT NULL,
  `cosservicio` varchar(11) NOT NULL,
  `gananciaempresa` varchar(15) NOT NULL,
  `idchofer` varchar(11) NOT NULL,
  `gananciachofer` varchar(15) NOT NULL,
  `porcentajeganchofer` varchar(11) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `fecha2` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `dinero`
--

INSERT INTO `dinero` (`id`, `idservicio`, `Seguro`, `cosservicio`, `gananciaempresa`, `idchofer`, `gananciachofer`, `porcentajeganchofer`, `fecha`, `fecha2`) VALUES
(1, '90', '--Seguros--', '3000', '2670.0', '25311294', '330.0', '11', '    25-08-2016', '25082016'),
(2, '100', 'dd', '345', '307.05', '25311294', '37.95', '11', '    25-08-2016', '25082016'),
(3, 'ñ', 'df', 'fddf', 'df', 'df', 'df', 'df', 'dfd', '24082016'),
(4, 'xf', 'cxv', 'cxv', 'cxv', 'xvc', 'xcv', 'cxv', 'xv', '23082016'),
(5, '110', 'dd', '4499', '4004.11', '25311294', '494.89', '11', '    27-08-2016', '27082016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fecha`
--

CREATE TABLE IF NOT EXISTS `fecha` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fechaw` varchar(20) NOT NULL,
  `fecha` varchar(29) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Volcado de datos para la tabla `fecha`
--

INSERT INTO `fecha` (`id`, `fechaw`, `fecha`) VALUES
(10, '09082016', ''),
(11, '08082016', ''),
(12, '07082016', ''),
(13, '06082016', ''),
(14, '05082016', ''),
(19, '09082016', ''),
(20, '17082016', ''),
(21, '16082016', '16-08-2016'),
(22, '18082016', '18-08-2016'),
(23, '19082016', '19-08-2016'),
(24, '20082016', '20-08-2016'),
(25, '21082016', '21-08-2016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `porcent`
--

CREATE TABLE IF NOT EXISTS `porcent` (
  `idp` int(11) NOT NULL AUTO_INCREMENT,
  `porD` double NOT NULL,
  `porI` int(11) NOT NULL,
  PRIMARY KEY (`idp`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `porcent`
--

INSERT INTO `porcent` (`idp`, `porD`, `porI`) VALUES
(1, 0.11, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE IF NOT EXISTS `servicio` (
  `id` int(11) NOT NULL,
  `seguro` varchar(70) NOT NULL,
  `marca` varchar(60) NOT NULL,
  `modelo` varchar(70) NOT NULL,
  `color` varchar(40) NOT NULL,
  `año` int(11) NOT NULL,
  `placa` varchar(30) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` int(60) NOT NULL,
  `Laccidente` varchar(300) NOT NULL,
  `Ldestino` varchar(300) NOT NULL,
  `Fallas` varchar(200) NOT NULL,
  `codigo` varchar(100) NOT NULL,
  `chofer` varchar(100) NOT NULL,
  `costo` int(11) NOT NULL,
  `fecha` varchar(15) NOT NULL,
  `fecha2` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`id`, `seguro`, `marca`, `modelo`, `color`, `año`, `placa`, `nombre`, `telefono`, `Laccidente`, `Ldestino`, `Fallas`, `codigo`, `chofer`, `costo`, `fecha`, `fecha2`) VALUES
(-10, '--Seguros--', '--Marca--', '--Modelo--', '--Color--', 1, 'f', 'fd', 33, 'vc b', 'fcvb', 'cvb', '4', '--Chofer--', 3, '    24-08-2016', '24082016'),
(0, '--Seguros--', '--Marca--', '--Modelo--', '--Color--', 2, 'ñ', 'ñ', 9, 'mkl', 'l.,m', 'l.,', 'l,', '55', 9, '    25-08-2016', '25082016'),
(10, '--Seguros--', '--Marca--', '--Modelo--', '--Color--', 1, 'ff', 'dfd', 44, 'fvxc', 'cvb', 'vb', '44', '55', 3000, '    25-08-2016', '25082016'),
(20, '--Seguros--', '--Marca--', '--Modelo--', '--Color--', 2, '45', 'er', 45, 'cvb', 'cvb', 'cbv', '5', '25311294', 3000, '    25-08-2016', '25082016'),
(30, '--Seguros--', '--Marca--', '--Modelo--', '--Color--', 2, 'fv', 'cv', 4, 'cvb', 'cv', 'bv', '55', '25311294', 400, '    25-08-2016', '25082016'),
(40, '--Seguros--', '--Marca--', '--Modelo--', '--Color--', 2, '34xf', 'xv', 43, 'cv', 'cv', 'cv', '4', '55', 4444, '    25-08-2016', '25082016'),
(50, '--Seguros--', '--Marca--', '--Modelo--', '--Color--', 1, 'f', 'xc', 4, 'c', 'v', 'vc', 'cv', '25311294', 3000, '    25-08-2016', '25082016'),
(60, '--Seguros--', '--Marca--', '--Modelo--', '--Color--', 0, '234', 'erf', 44, 'cvb', 'v', 'cvb', '4', '25311294', 4000, '    25-08-2016', '25082016'),
(70, '--Seguros--', '--Marca--', '--Modelo--', '--Color--', 2, 'fvcx', 'v ', 4, 'cvb', 'vcb', 'cvb', '44', '25311294', 4000, '    25-08-2016', '25082016'),
(80, '--Seguros--', '--Marca--', '--Modelo--', '--Color--', 1, '4', 'fcv', 44, 'cv', 'cv', 'cv', 'cvb', '25311294', 2000, '    25-08-2016', '25082016'),
(90, '--Seguros--', '--Marca--', '--Modelo--', '--Color--', 2, 'df', 'c', 3, 'cv ', 'cv', 'cv', '34', '25311294', 3000, '    25-08-2016', '25082016'),
(100, 'dd', '--Marca--', '--Modelo--', '--Color--', 4, 'GG', 'dff', 2323, 'vsdv', 'svd', 'vc', 'xvc', '25311294', 345, '    25-08-2016', '25082016'),
(110, 'dd', '--Marca--', '--Modelo--', '--Color--', 1, '454', 'fg', 43, 'cb', 'cb', 'cb', 'cvb', '25311294', 44, '    27-08-2016', '27082016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `totaldinero`
--

CREATE TABLE IF NOT EXISTS `totaldinero` (
  `idt` int(11) NOT NULL AUTO_INCREMENT,
  `Num.servicios` int(11) NOT NULL,
  `cost.sevicios` int(11) NOT NULL,
  `ganancia.chofer` int(11) NOT NULL,
  `ganancia.empresa` int(11) NOT NULL,
  `fecha` varchar(100) NOT NULL,
  PRIMARY KEY (`idt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
