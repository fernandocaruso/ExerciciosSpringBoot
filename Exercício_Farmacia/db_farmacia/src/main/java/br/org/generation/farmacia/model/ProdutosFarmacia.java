package br.org.generation.farmacia.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name = "tb_produtos") //nome da tabela = tb_produtos
public class ProdutosFarmacia {


	@Id //PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_Increment
	private long id; //big int

	@NotNull
	@Size(min = 1, max = 50)
	private String titulo; //nome do medicamento

	@NotNull
	@Size(min = 1, max = 100)
	private String qtdEstoque; //quantos medicamentos tem em estoque
	
	@NotNull
	private BigDecimal preco;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private CategoriaFarmacia categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(String qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
	
		}
