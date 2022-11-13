-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-11-2022 a las 04:39:41
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `recuperau2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentes`
--

CREATE TABLE `docentes` (
  `id` bigint(20) NOT NULL,
  `nombreD` varchar(50) DEFAULT NULL,
  `apellidoPaternoD` varchar(50) DEFAULT NULL,
  `apellidoMaternoD` varchar(50) DEFAULT NULL,
  `fechaNacimientoD` varchar(50) DEFAULT NULL,
  `curpD` varchar(50) DEFAULT NULL,
  `numeroEmpleado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `docentes`
--

INSERT INTO `docentes` (`id`, `nombreD`, `apellidoPaternoD`, `apellidoMaternoD`, `fechaNacimientoD`, `curpD`, `numeroEmpleado`) VALUES
(1, 'Sebastian', 'Quintero', 'Martinez', '03/07/2002', 'QUMS', 1),
(4, 'Talon', 'Nekko', 'Ahri', '09', 'AHR', 2),
(6, 'Mike', 'Moreno', 'Miguel', '02/02/2002', 'MOMM020202HMSNRBA6', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellidoPaterno` varchar(40) NOT NULL,
  `apellidoMaterno` varchar(40) NOT NULL,
  `fechaNacimiento` varchar(40) NOT NULL,
  `curp` varchar(40) NOT NULL,
  `matricula` varchar(40) NOT NULL,
  `calificacionT` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`id`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `fechaNacimiento`, `curp`, `matricula`, `calificacionT`) VALUES
(1, 'Talon', 'Nekko', 'Gnar', '03-07-2002', 'QUMS', '20203TN049', 10),
(3, 'Pyke', 'Nautilus', 'Sejuani', '09/09/2009', 'QUMS020307HMSNRBA6', '20203TN050', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluacion`
--

CREATE TABLE `evaluacion` (
  `calificacion` double NOT NULL,
  `materia` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `evaluacion`
--

INSERT INTO `evaluacion` (`calificacion`, `materia`) VALUES
(9, 'Diseño web'),
(10, 'Programacion');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `docentes`
--
ALTER TABLE `docentes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `curpD` (`curpD`),
  ADD UNIQUE KEY `numeroEmpleado` (`numeroEmpleado`);

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `curp` (`curp`),
  ADD UNIQUE KEY `matricula` (`matricula`),
  ADD KEY `fk_estudiantes_evaluacion` (`calificacionT`);

--
-- Indices de la tabla `evaluacion`
--
ALTER TABLE `evaluacion`
  ADD PRIMARY KEY (`calificacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `docentes`
--
ALTER TABLE `docentes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD CONSTRAINT `fk_estudiantes_evaluacion` FOREIGN KEY (`calificacionT`) REFERENCES `evaluacion` (`calificacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
