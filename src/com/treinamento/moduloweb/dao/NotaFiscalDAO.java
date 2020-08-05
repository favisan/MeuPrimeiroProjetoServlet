package com.treinamento.moduloweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.treinamento.moduloweb.vo.TbNf;

public class NotaFiscalDAO {

	Connection conn;
	
	public NotaFiscalDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<TbNf> buscarTodas() throws Exception{
		
		Statement stmt = conn.createStatement();
		ResultSet rsTbNf = stmt.executeQuery("select * from TB_NF");
		
		List<TbNf> lista = new ArrayList<TbNf>();
		while(rsTbNf.next()) {
			
			TbNf nf = new TbNf();
			nf.setIdNf(rsTbNf.getInt("ID_NF"));
			nf.setDtEmissao(rsTbNf.getDate("DT_EMISSAO"));
			
			lista.add(nf);
		}
		
		rsTbNf.close();
		stmt.close();
		
		return lista;
	}
	
	public List<TbNf> buscarNfFilial() throws Exception{
		
		Statement stmt = conn.createStatement();
		ResultSet rsTbNf = stmt.executeQuery("select nf.ID_NF, nf.DT_EMISSAO, nf.NR_NF NOTA_FISCAL, nf.CD_FILIAL, f.NM_FILIAL, 1 CD_TIPO_NF \n" + 
				"from TB_NF nf\n" + 
				"inner join TB_FILIAL f on\n" + 
				"nf.CD_FILIAL = f.CD_FILIAL");
		
		List<TbNf> lista = new ArrayList<TbNf>();
		while(rsTbNf.next()) {
			
			TbNf nf = new TbNf();
			
			nf.setIdNf(rsTbNf.getInt("ID_NF"));
			nf.setDtEmissao(rsTbNf.getDate("DT_EMISSAO"));
			nf.setNrNf(rsTbNf.getInt("NOTA_FISCAL"));
			nf.setCdFilial(rsTbNf.getInt("CD_FILIAL"));
			nf.setNomeFilial(rsTbNf.getString("NM_FILIAL"));
			nf.setCdTipoNf(rsTbNf.getInt("CD_TIPO_NF"));
			
			lista.add(nf);
		}
		
		rsTbNf.close();
		stmt.close();
		
		return lista;
	}
	
	public void inserir(TbNf tbNf) throws SQLException {
		
		String query = "insert into TB_NF (DT_EMISSAO, CD_FORNECEDOR, ID_CLIENTE, " + 
		"CD_FILIAL, NR_NF, CD_TIPO_NF) values(?,?,?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setDate(1, new java.sql.Date(tbNf.getDtEmissao().getTime()));
		pstmt.setInt(2, tbNf.getCdFornecedor());
		pstmt.setInt(3, tbNf.getIdCliente());
		pstmt.setInt(4, tbNf.getCdFilial());
		pstmt.setInt(5, tbNf.getNrNf());
		pstmt.setInt(6, tbNf.getCdTipoNf());
		
		pstmt.executeUpdate();
	
		pstmt.close();
	}
	
	public void atualizar(TbNf tbNf) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("update TB_NF set NR_NF = ?, cd_filial = ? where ID_NF = ?");
		stmt.setInt(1, tbNf.getNrNf());
		stmt.setInt(2, tbNf.getCdFilial());
		stmt.setInt(3, tbNf.getIdNf());
		
		stmt.executeUpdate();
		
		stmt.close();
	}
	
	public void excluir(Integer idNf) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("delete from TB_NF where ID_NF = ?");
		stmt.setInt(1, idNf);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	
	public static void main(String args[]) throws Exception {
		ConexaoMySqlDAO conexaoMySql = new ConexaoMySqlDAO();
		
		NotaFiscalDAO dao = new NotaFiscalDAO(conexaoMySql.obterConexao());
		dao.testeInsertBD();
	}
	
	public void testeInsertBD() throws SQLException {
		TbNf nf = new TbNf();
		nf.setCdFilial(2);
		nf.setCdFornecedor(1);
		nf.setCdTipoNf(1);
		nf.setDtEmissao(new java.util.Date());
		nf.setNrNf(2);
		nf.setIdCliente(1);
		nf.setIdNf(1);
		
		
		this.inserir(nf);
		
	}
	
	public void testeAtualiza() throws SQLException {
		TbNf nf = new TbNf();
		nf.setCdFilial(2);
		nf.setNrNf(2);
		nf.setIdCliente(1);
		nf.setIdNf(1);
		
	
		this.atualizar(nf);
		
	}
	
	public void testeExcluir() throws SQLException {
		this.excluir(1);
		
	}
}
