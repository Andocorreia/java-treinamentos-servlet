package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/entrada")
public class Autenticacao implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String parametro = req.getParameter("parametro");
		boolean validaLogin = !(parametro.contains("Login") || parametro.contains("LoginForm")
				|| parametro.contains("Logout"));

		String usuario = (String) session.getAttribute("usuarioLogado");
		if (usuario != null || validaLogin == false) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

}
