package br.com.formacaodev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/minhaservlet")
public class MinhaPrimeiraServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response){
	
		PrintWriter out = null;
		try {
			out = response.getWriter();
			
			List<String> listaFuncionarios = new ArrayList<>();
			listaFuncionarios.add("João Claudio");
			listaFuncionarios.add("Maria");
			listaFuncionarios.add("Ricardo's");
			listaFuncionarios.add("Orlando");
			listaFuncionarios.add("Henrique");
			listaFuncionarios.add("Paulo");
			listaFuncionarios.add("Luciano");
			listaFuncionarios.add("Pedro");
			
			request.setAttribute("titulo", "Lista de funcionarios");
			request.setAttribute("funcionarios", listaFuncionarios);
			
			RequestDispatcher rd = request.getRequestDispatcher("/funcionarios.jsp");
		    try {
				rd.forward(request,response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
//			response.sendRedirect("/funcionarios.jsp");
			
		}catch(IOException e) {
			System.out.println("Erro ao executar servlet: MinhaPrimeiraServlet");
		}
	}
	
}
