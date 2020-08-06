package com.treinamento.moduloweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_loja")
@NamedQueries({
	@NamedQuery(name = "buscarPorNome", query = "select loja from LojaEntity loja where loja.nome = :nome"),
	@NamedQuery(name = "buscarTodas", query = "select loja from LojaEntity loja")
			  }
)
public class LojaEntity {
	
	@Id
	@GeneratedValue
	private Integer codigo;
	
	@Column
	private String nome;
	
	@Column(name = "logomarca")
	private String bandeira;
	
	@Column
	private String cidade;
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}
