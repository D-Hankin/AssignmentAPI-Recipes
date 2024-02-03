-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 03, 2024 at 12:13 PM
-- Server version: 5.7.24
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recipes`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` binary(16) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(128) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`, `email`) VALUES
(0x6058e5316d5b43a1a8755800ea7b00f3, 'JanneY2K', '$2a$10$JrZL3y1wR2cg2Wl4dNmno.xHYDNzFVnhYmO//thNc0ryhlt.x1hgW', 'Janne', 'Kemi', 'janne@kemi.com');

-- --------------------------------------------------------

--
-- Table structure for table `user_liked_recipes`
--

CREATE TABLE `user_liked_recipes` (
  `id` int(11) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `recipe_number` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_liked_recipes`
--

INSERT INTO `user_liked_recipes` (`id`, `user_id`, `recipe_number`) VALUES
(1, '6058e531-6d5b-43a1-a875-5800ea7b00f3', '53030'),
(2, '6058e531-6d5b-43a1-a875-5800ea7b00f3', '52903'),
(3, '6058e531-6d5b-43a1-a875-5800ea7b00f3', '52978'),
(4, '6058e531-6d5b-43a1-a875-5800ea7b00f3', '52928');

-- --------------------------------------------------------

--
-- Table structure for table `user_recipe`
--

CREATE TABLE `user_recipe` (
  `user_recipe_id` int(11) NOT NULL,
  `recipe_method` varchar(255) DEFAULT NULL,
  `recipe_name` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_recipe`
--

INSERT INTO `user_recipe` (`user_recipe_id`, `recipe_method`, `recipe_name`, `user_id`) VALUES
(1, 'One on top of the other and cook!', 'Pizza', '6058e531-6d5b-43a1-a875-5800ea7b00f3');

-- --------------------------------------------------------

--
-- Table structure for table `user_recipe_ingredients`
--

CREATE TABLE `user_recipe_ingredients` (
  `user_recipe_user_recipe_id` int(11) NOT NULL,
  `ingredients` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_recipe_ingredients`
--

INSERT INTO `user_recipe_ingredients` (`user_recipe_user_recipe_id`, `ingredients`) VALUES
(1, '500g Flour'),
(1, '25g Yeast'),
(1, '10 Tomatos'),
(1, '200g Cheese'),
(1, 'Salami'),
(1, 'Onion');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `FOREIGN` (`username`);

--
-- Indexes for table `user_liked_recipes`
--
ALTER TABLE `user_liked_recipes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_recipe`
--
ALTER TABLE `user_recipe`
  ADD PRIMARY KEY (`user_recipe_id`);

--
-- Indexes for table `user_recipe_ingredients`
--
ALTER TABLE `user_recipe_ingredients`
  ADD KEY `FK7vvcm8rt4ylosgi5o8ts81v8h` (`user_recipe_user_recipe_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_liked_recipes`
--
ALTER TABLE `user_liked_recipes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_recipe`
--
ALTER TABLE `user_recipe`
  MODIFY `user_recipe_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_recipe_ingredients`
--
ALTER TABLE `user_recipe_ingredients`
  ADD CONSTRAINT `FK7vvcm8rt4ylosgi5o8ts81v8h` FOREIGN KEY (`user_recipe_user_recipe_id`) REFERENCES `user_recipe` (`user_recipe_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
