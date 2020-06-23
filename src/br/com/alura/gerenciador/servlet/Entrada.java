package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.FormEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class Entrada extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("parametro");
		String acaoResult = null;
		if(parametro.contains("ListaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			acaoResult = acao.executa(request, response);
		}else if(parametro.contains("AlteraEmpresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			acaoResult = acao.executa(request, response);
		}else if(parametro.contains("FormEmpresa")) {
			FormEmpresa acao = new FormEmpresa();
			acaoResult = acao.executa(request, response);
		}else if(parametro.contains("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			acaoResult = acao.executa(request, response);
		}else if(parametro.contains("RemoveEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			acaoResult = acao.executa(request, response);
		}
		
		String[] tipoRedirecionamento = acaoResult.split(":");		
		if(tipoRedirecionamento[0].equals("rd")) {
			response.sendRedirect(tipoRedirecionamento[1]);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/" + tipoRedirecionamento[1]);
			rd.forward(request, response);
		}
	}
}
