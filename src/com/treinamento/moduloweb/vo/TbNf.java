package com.treinamento.moduloweb.vo;

import java.util.Date;

public class TbNf {

	private Integer idNf;
	private Date dtEmissao;
	private Integer cdFornecedor;
	private Integer idCliente;
	private Integer cdFilial;
	private Integer nrNf;
	private Integer cdTipoNf;

	private String nomeFilial;
	
	public String getNomeFilial() {
		return nomeFilial;
	}
	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}
	public Integer getIdNf() {
		return idNf;
	}
	public void setIdNf(Integer idNf) {
		this.idNf = idNf;
	}
	public Date getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public Integer getCdFornecedor() {
		return cdFornecedor;
	}
	public void setCdFornecedor(Integer cdFornecedor) {
		this.cdFornecedor = cdFornecedor;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getCdFilial() {
		return cdFilial;
	}
	public void setCdFilial(Integer cdFilial) {
		this.cdFilial = cdFilial;
	}
	public Integer getNrNf() {
		return nrNf;
	}
	public void setNrNf(Integer nrNf) {
		this.nrNf = nrNf;
	}
	public Integer getCdTipoNf() {
		return cdTipoNf;
	}
	public void setCdTipoNf(Integer cdTipoNf) {
		this.cdTipoNf = cdTipoNf;
	}

	
}
