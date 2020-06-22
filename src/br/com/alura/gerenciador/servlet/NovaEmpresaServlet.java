package br.com.alura.gerenciador.servlet;

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

import br.com.alura.gerenciador.servlet.model.Banco;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Banco banco = new Banco();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Integer idEmpresa = 0;
		if(request.getParameter("id") !=null) {
			idEmpresa = Integer.valueOf(request.getParameter("id"));
		}
		
		String nomeEmpresa = request.getParameter("nome");
		
		if(idEmpresa == 0) {
			
			banco.adicionaEmpresa(nomeEmpresa);
			response.sendRedirect("formNovaEmpresa.jsp");
		} else {
			banco.alteraEmpresa(idEmpresa, nomeEmpresa);	
			response.sendRedirect("listaEmpresas.jsp");
		}
	}
}
