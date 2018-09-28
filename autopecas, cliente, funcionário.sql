CREATE DATABASE  IF NOT EXISTS `autopecas` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `autopecasclienteclientecliente`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: trabalho
-- ------------------------------------------------------
-- Server version	5.5.60-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `codCliente` int(5) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  `Rg` varchar(20) NOT NULL,
  `Cpf` varchar(11) NOT NULL,
  `Sexo` varchar(2) DEFAULT NULL,
  `Telefone` varchar(9) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Rua` varchar(50) DEFAULT NULL,
  `Numero` int(10) DEFAULT NULL,
  `Complemento` varchar(50) DEFAULT NULL,
  `Bairro` varchar(50) DEFAULT NULL,
  `Cidade` varchar(50) DEFAULT NULL,
  `Estado` varchar(2) DEFAULT NULL,
  `Cep` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `codFuncionario` int(5) NOT NULL AUTO_INCREMENT,
  `Função` varchar(50) NOT NULL,
  `Salario` double DEFAULT NULL,
  `Nome` varchar(50) NOT NULL,
  `Rg` varchar(20) NOT NULL,
  `Cpf` varchar(11) NOT NULL,
  `Sexo` varchar(2) DEFAULT NULL,
  `Telefone` varchar(9) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Rua` varchar(50) DEFAULT NULL,
  `Numero` int(10) DEFAULT NULL,
  `Complemento` varchar(50) DEFAULT NULL,
  `Bairro` varchar(50) DEFAULT NULL,
  `Cidade` varchar(50) DEFAULT NULL,
  `Estado` varchar(2) DEFAULT NULL,
  `Cep` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;