create database if not exists trabalho;

use trabalho;

CREATE TABLE IF NOT EXISTS cliente(
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

CREATE TABLE IF NOT EXISTS funcionario(
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

CREATE TABLE IF NOT EXISTS `produto` (
  `codProduto` int(5) NOT NULL AUTO_INCREMENT,
  `TextoBreve` varchar(50) NOT NULL,
  `DescritivoCompleto`varchar(200) NOT NULL,
  `PrecoAquisicao`double NOT NULL,
  `PrecoVenda`double NOT NULL,
  `Saldo`float DEFAULT 0,
  PRIMARY KEY (`codProduto`)
)

CREATE TABLE venda(
  codVenda   int(5) auto_increment, 
  codCliente int(5),
  codVendedor int(5),
  totalVenda float(7,2),
PRIMARY KEY (codVenda),
FOREIGN KEY (codCliente) REFERENCES cliente(codCliente),
FOREIGN KEY (codVendedor) REFERENCES funcionario(codFuncionario));

CREATE TABLE itemvenda(
	codItem int(5) auto_increment,
    codVenda int(5),
    codProduto int(5),
    qtd float(5,0),
    precoItem float(7,2),
    totalItem float(7,2),
PRIMARY KEY (codItem),
FOREIGN KEY (codVenda) REFERENCES venda(codVenda),
FOREIGN KEY (codProduto) REFERENCES produto(codProduto));

ALTER TABLE `trabalho`.`funcionario` 
ADD COLUMN `Senha` VARCHAR(8) NOT NULL AFTER `Cep`;
