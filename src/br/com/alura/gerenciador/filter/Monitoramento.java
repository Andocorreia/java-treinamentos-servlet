package br.com.alura.gerenciador.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/entrada")
public class Monitoramento implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String parametro = req.getParameter("parametro");
		
		long antes = System.currentTimeMillis();
		chain.doFilter(request, response);
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execucao " + parametro + ": " + (depois - antes));
	}

	
}
