package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

public class NovaEmpresa {
	private Banco banco = new Banco();

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idEmpresa = 0;
		if (request.getParameter("id") != null) {
			idEmpresa = Integer.valueOf(request.getParameter("id"));
		}

		String nomeEmpresa = request.getParameter("nome");

		if (idEmpresa == 0) {

			banco.adicionaEmpresa(nomeEmpresa);
			return "rd:entrada?parametro=FormEmpresa";
		} else {
			banco.alteraEmpresa(idEmpresa, nomeEmpresa);
			return "rd:entrada?parametro=ListaEmpresas";
		}
	}
}
