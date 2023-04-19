CREATE DATABASE mercado;

USE mercado;

CREATE TABLE Caixa (
  idCaixa INT PRIMARY KEY AUTO_INCREMENT,
  caixa DECIMAL(10,2)
);s

CREATE TABLE CarrinhoCompras (
  idCarrinho INT PRIMARY KEY AUTO_INCREMENT,
  quantidadeProdutos JSON,
  listaProdutos VARCHAR(255)
);

CREATE TABLE Cliente (
  idCliente INT PRIMARY KEY AUTO_INCREMENT,
  nomeCliente VARCHAR(100),
  enderecoCliente VARCHAR(200),
  telefoneCliente VARCHAR(20)
);

CREATE TABLE estoque (
    idEstoque INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (idEstoque)
);


CREATE TABLE fornecedor (
  idFornecedor INT PRIMARY KEY AUTO_INCREMENT,
  nomeFornecedor VARCHAR(255),
  enderecoFornecedor VARCHAR(255),
  telefoneFornecedor VARCHAR(20)
);

CREATE TABLE funcionario (
    idFunc INT PRIMARY KEY AUTO_INCREMENT,
    nomeFunc VARCHAR(255),
    enderecoFunc VARCHAR(255),
    telefoneFunc VARCHAR(20),
    cargoFunc VARCHAR(255)
);

CREATE TABLE pedido (
  idPedido INT NOT NULL AUTO_INCREMENT,
  valorTotal DOUBLE NOT NULL,
  formaPagamento VARCHAR(100) NOT NULL,
  PRIMARY KEY (idPedido)
);

CREATE TABLE produto (
  idProduto INT NOT NULL AUTO_INCREMENT,
  nomeProduto VARCHAR(100) NOT NULL,
  precoProduto DECIMAL(10,2) NOT NULL,
  estoque INT NOT NULL,
  PRIMARY KEY (idProduto)
);

CREATE TABLE pedido_produto (
  idPedido INT NOT NULL,
  idProduto INT NOT NULL,
  quantidade INT NOT NULL,
  FOREIGN KEY (idPedido) REFERENCES pedido(idPedido),
  FOREIGN KEY (idProduto) REFERENCES produto(idProduto),
  PRIMARY KEY (idPedido, idProduto)
);

CREATE TABLE produto_estoque (
    idEstoque INT NOT NULL,
    idProduto INT NOT NULL,
    quantidade INT NOT NULL,
    dataValidade DATE NOT NULL,
    PRIMARY KEY (idEstoque, idProduto),
    FOREIGN KEY (idEstoque) REFERENCES estoque(idEstoque),
    FOREIGN KEY (idProduto) REFERENCES produto(idProduto)
);

CREATE TABLE Venda (
    idVenda INT PRIMARY KEY AUTO_INCREMENT,
    valorTotal DOUBLE NOT NULL,
    formaPagamento VARCHAR(255) NOT NULL,
    Data DATE NOT NULL
);
 
CREATE TABLE RelatorioVendas (
    idRelatorioVendas INT PRIMARY KEY AUTO_INCREMENT,
    dataInicio DATE NOT NULL,
    dataFim DATE NOT NULL,
    valorTotalVendas DOUBLE NOT NULL
);

CREATE TABLE Produto_Venda (
    idProduto INT NOT NULL,
    idVenda INT NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (idProduto, idVenda),
    FOREIGN KEY (idProduto) REFERENCES Produto(idProduto),
    FOREIGN KEY (idVenda) REFERENCES Venda(idVenda)
);
