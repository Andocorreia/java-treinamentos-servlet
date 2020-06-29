package br.com.alura.gerenciador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {

	private static List<Empresa> empresa = new ArrayList<Empresa>();
	private static List<Usuario> usuarios = new ArrayList<Usuario>();

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(1);
		empresa1.setDataCadastro(LocalDate.of(2019, 05, 24));
		empresa1.setNome("Empresa 1");
		empresa1.setStatus("ATIVO");
		Banco.empresa.add(empresa1);

		Empresa empresa2 = new Empresa();
		empresa2.setId(2);
		empresa2.setDataCadastro(LocalDate.of(2013, 10, 22));
		empresa2.setNome("Empresa 2");
		empresa2.setStatus("ATIVO");
		Banco.empresa.add(empresa2);

		Usuario usuario1 = new Usuario();
		usuario1.setUsuario("Andre");
		usuario1.setSenha("1234");

		Usuario usuario2 = new Usuario();
		usuario2.setUsuario("Matheus");
		usuario2.setSenha("1234");

		usuarios.add(usuario1);
		usuarios.add(usuario2);

	}

	public void adicionaEmpresa(String nome) {
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setId(Banco.empresa.size() + 1);
		empresa.setDataCadastro(LocalDate.now());
		empresa.setStatus("ATIVO");

		Banco.empresa.add(empresa);
	}

	public Empresa getEmpresa(Integer idEmpresa) {
		Optional<Empresa> empresa = Banco.empresa.stream().filter(item -> item.getId() == idEmpresa).findFirst();
		if (empresa.isPresent())
			return empresa.get();
		return null;
	}

	public void removeEmpresa(Integer idEmpresa) {
		Empresa empresa = this.getEmpresa(idEmpresa);
		if (empresa != null)
			empresa.setStatus("INATIVO");
	}

	public void alteraEmpresa(Integer idEmpresa, String nomeEmpresa) {
		Empresa empresa = this.getEmpresa(idEmpresa);

		if (nomeEmpresa != null) {
			empresa.setNome(nomeEmpresa);
			empresa.setStatus("ATIVO");
		}
	}

	public List<Empresa> getEmpresas() {
		return Banco.empresa;
	}

	public boolean login(String usr, String psw) {
		Usuario usuario = new Usuario();
		usuario.setUsuario(usr);
		usuario.setSenha(psw);

		if (Banco.usuarios.stream().filter(user -> user.equals(usuario)).count() > 0) {

			return true;
		}

		return false;

	}

	public Usuario getUsuario(String nome) {
		Optional<Usuario> optionalUsuario = Banco.usuarios.stream().filter(usuario -> nome.equals(usuario.getUsuario()))
				.findFirst();
		if (optionalUsuario.isPresent()) {
			return (Usuario) optionalUsuario.get();
		}
		return null;

	}
}
