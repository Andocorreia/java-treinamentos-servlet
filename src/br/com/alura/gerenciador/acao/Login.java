package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banco banco = new Banco();
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if(usuario != null && senha != null) {
			if(banco.login(usuario, senha) == true) {
				return "rd:entrada?parametro=ListaEmpresas";
			}
		}
		
		return "fw:login.jsp";
	}
}
