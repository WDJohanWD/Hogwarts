SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `hogwarts` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `hogwarts`;

CREATE TABLE `Alumno` (
  `id` int NOT NULL,
  `mago_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Alumno` (`id`, `mago_id`) VALUES
(7, 1),
(8, 2),
(9, 3),
(10, 5),
(11, 6),
(12, 7);

CREATE TABLE `Casa` (
  `id` int NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Casa` (`id`, `nombre`) VALUES
(1, 'GRYFFINDOR'),
(2, 'HUFFLEPUFF'),
(3, 'RAVENCLAW'),
(4, 'SLYTHERIN');

CREATE TABLE `Mago` (
  `id` int NOT NULL,
  `persona_id` int DEFAULT NULL,
  `tipo_escoba` varchar(100) DEFAULT NULL,
  `casa_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Mago` (`id`, `persona_id`, `tipo_escoba`, `casa_id`) VALUES
(1, 4, 'Firebolt', 1),
(2, 5, 'Nimbus 2000', 2),
(3, 6, 'Cleansweep Eleven', 3),
(4, 7, 'Comet 260', 4),
(5, 1, 'Firebolt', 1),
(6, 2, 'Nimbus 2000', 3),
(7, 3, 'Cleansweep Eleven', 1),
(8, 8, NULL, 4),
(9, 9, NULL, 4),
(10, 10, NULL, 4);

CREATE TABLE `Muggle` (
  `id` int NOT NULL,
  `persona_id` int DEFAULT NULL,
  `cree_en_magia` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Muggle` (`id`, `persona_id`, `cree_en_magia`) VALUES
(7, 1, 1),
(8, 2, 0),
(9, 3, 1);

CREATE TABLE `Persona` (
  `id` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fecha_nacimiento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Persona` (`id`, `nombre`, `fecha_nacimiento`) VALUES
(1, 'Harry Potter', '1980-07-31'),
(2, 'Hermione Granger', '1979-09-19'),
(3, 'Ron Weasley', '1980-03-01'),
(4, 'Albus Dumbledore', '1881-07-07'),
(5, 'Cedric Diggory', '1977-09-01'),
(6, 'Luna Lovegood', '1981-02-13'),
(7, 'Draco Malfoy', '1980-06-05'),
(8, 'Minerva McGonagall', '1935-10-04'),
(9, 'Severus Snape', '1960-01-09'),
(10, 'Alastor Moody', '1950-08-07');

CREATE TABLE `Profesor` (
  `id` int NOT NULL,
  `mago_id` int DEFAULT NULL,
  `frases_iconicas` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Profesor` (`id`, `mago_id`, `frases_iconicas`) VALUES
(5, 4, 'Non é bo deixarse arrastrar polos soños e esquecer vivir'),
(6, 8, 'Son nuestras elecciones las que muestran quienes somos realmente, mucho más que nuestras habilidades'),
(7, 9, 'Por el bien común'),
(8, 10, 'La felicidad se puede encontrar incluso en los momentos más oscuros, si uno se acuerda de encender la luz');


ALTER TABLE `Alumno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `mago_id` (`mago_id`);

ALTER TABLE `Casa`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `Mago`
  ADD PRIMARY KEY (`id`),
  ADD KEY `persona_id` (`persona_id`),
  ADD KEY `casa_id` (`casa_id`);

ALTER TABLE `Muggle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `persona_id` (`persona_id`);

ALTER TABLE `Persona`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `Profesor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `mago_id` (`mago_id`);


ALTER TABLE `Alumno`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

ALTER TABLE `Casa`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `Mago`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

ALTER TABLE `Muggle`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE `Persona`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

ALTER TABLE `Profesor`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;


ALTER TABLE `Alumno`
  ADD CONSTRAINT `Alumno_ibfk_1` FOREIGN KEY (`mago_id`) REFERENCES `Mago` (`id`);

ALTER TABLE `Mago`
  ADD CONSTRAINT `Mago_ibfk_1` FOREIGN KEY (`persona_id`) REFERENCES `Persona` (`id`),
  ADD CONSTRAINT `Mago_ibfk_2` FOREIGN KEY (`casa_id`) REFERENCES `Casa` (`id`);

ALTER TABLE `Muggle`
  ADD CONSTRAINT `Muggle_ibfk_1` FOREIGN KEY (`persona_id`) REFERENCES `Persona` (`id`);

ALTER TABLE `Profesor`
  ADD CONSTRAINT `Profesor_ibfk_1` FOREIGN KEY (`mago_id`) REFERENCES `Mago` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
