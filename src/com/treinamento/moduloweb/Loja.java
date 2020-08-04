package com.treinamento.moduloweb;

import java.util.Date;

public class Loja{

	private Integer codigo;
	private String nome;
	private String logomarca;
	private String cidade;
	private Date dtInauguracao;
	
	public Date getDtInauguracao() {
		return dtInauguracao;
	}
	public void setDtInauguracao(Date dtInauguracao) {
		this.dtInauguracao = dtInauguracao;
	}
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
	public String getLogomarca() {
		return logomarca;
	}
	public void setLogomarca(String logomarca) {
		this.logomarca = logomarca;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
}
