package br.com.alura.gerenciador.servlet.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
	
	private static List<Empresa> empresa = new ArrayList<Empresa>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(1);
		empresa1.setDataCadastro(LocalDate.of(2019, 05, 24));
		empresa1.setNome("Empresa 1");
		Banco.empresa.add(empresa1);
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(2);
		empresa2.setDataCadastro(LocalDate.of(2013, 10, 22));
		empresa2.setNome("Empresa 2");
		Banco.empresa.add(empresa2);
		
	}
	
	public void adicionaEmpresa(String nome) {
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setId(Banco.empresa.size() + 1);
		empresa.setDataCadastro(LocalDate.now());
		
		Banco.empresa.add(empresa);
	}
	
	public Empresa getEmpresa(Integer idEmpresa) {
		Optional<Empresa> empresa = Banco.empresa.stream().filter(item -> item.getId() == idEmpresa).findFirst();
		if(empresa.isPresent()) return empresa.get();
		return null;
	}
	
	public void removeEmpresa(Integer idEmpresa) {
		Empresa empresa = this.getEmpresa(idEmpresa);
		if(empresa != null) Banco.empresa.remove(empresa);
	}
	
	public void alteraEmpresa(Integer idEmpresa, String nomeEmpresa) {
		Empresa empresa = this.getEmpresa(idEmpresa);
		
		if(nomeEmpresa != null) {
			empresa.setNome(nomeEmpresa);
		}
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.empresa;
	}
}
