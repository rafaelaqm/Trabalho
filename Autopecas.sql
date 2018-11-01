create database if not exists trabalho;

use trabalho;

CREATE TABLE `cliente` IF NOT EXISTS(
  `codCliente` int(5) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  `Rg` varchar(20) DEFAULT NULL,
  `Cpf` varchar(14) DEFAULT NULL,
  `Sexo` varchar(2) DEFAULT NULL,
  `Telefone` varchar(13) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Rua` varchar(50) DEFAULT NULL,
  `Numero` varchar(10) DEFAULT NULL,
  `Complemento` varchar(10) DEFAULT NULL,
  `Bairro` varchar(50) DEFAULT NULL,
  `Cidade` varchar(50) DEFAULT NULL,
  `Estado` varchar(2) DEFAULT NULL,
  `Cep` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codCliente`)
)

CREATE TABLE IF NOT EXISTS `funcionario` (
  `codFuncionario` int(5) NOT NULL AUTO_INCREMENT,
  `Funcao` varchar(50) NOT NULL,
  `Salario`double NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Rg` varchar(20) DEFAULT NULL,
  `Cpf` varchar(14) DEFAULT NULL,
  `Sexo` varchar(2) DEFAULT NULL,
  `Telefone` varchar(13) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Rua` varchar(50) DEFAULT NULL,
  `Numero` varchar(10) DEFAULT NULL,
  `Complemento` varchar(10) DEFAULT NULL,
  `Bairro` varchar(50) DEFAULT NULL,
  `Cidade` varchar(50) DEFAULT NULL,
  `Estado` varchar(2) DEFAULT NULL,
  `Cep` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codFuncionario`)
)

CREATE TABLE `produto` (
  `codProduto` int(5) NOT NULL AUTO_INCREMENT,
  `TextoBreve` varchar(50) NOT NULL,
  `DescritivoCompleto`varchar(200) NOT NULL,
  `PrecoAquisicao`double NOT NULL,
  `PrecoVenda`double NOT NULL,
  `Saldo`float DEFAULT 0,
  PRIMARY KEY (`codProduto`)
)