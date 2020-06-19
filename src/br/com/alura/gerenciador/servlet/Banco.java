package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresa = new ArrayList<Empresa>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(1);
		empresa1.setNome("Empresa 1");
		Banco.empresa.add(empresa1);
		Empresa empresa2 = new Empresa();
		empresa2.setId(2);
		empresa2.setNome("Empresa 2");
		Banco.empresa.add(empresa2);
		
	}
	
	public void adicionaEmpresa(String nome) {
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setId(Banco.empresa.size() + 1);
		Banco.empresa.add(empresa);
	}
	
	public List<Empresa> getEmpresa() {
		return Banco.empresa;
	}
}
