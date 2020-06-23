package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

public class RemoveEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idEmpresa = Integer.valueOf(request.getParameter("id"));
		Banco banco = new Banco();
		banco.removeEmpresa(idEmpresa);
		
		return "rd:entrada?parametro=ListaEmpresas";
	}

}
