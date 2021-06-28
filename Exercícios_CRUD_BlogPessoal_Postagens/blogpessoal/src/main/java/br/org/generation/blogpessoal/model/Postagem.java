package br.org.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


		@Entity
		@Table (name = "tb_postagens") //nome da tabela = tb_postagens
		public class Postagem {
	
	
		@Id //PRIMARY KEY
		@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_Increment
		private long id; //big int
		
		@NotNull
		@Size(min = 5, max = 100)
		private String titulo; //varchar
		
		@NotNull
		@Size(min = 10, max = 600)
		private String texto; //varchar
		
		@Temporal(TemporalType.TIMESTAMP)
		private Date data = new java.sql.Date(System.currentTimeMillis());
	
		
		public long getId() {
			return id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getTexto() {
			return texto;
		}

		public void setTexto(String texto) {
			this.texto = texto;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}

		public void setId(long id) {
			this.id = id;
		}

		
		
		
		
}
