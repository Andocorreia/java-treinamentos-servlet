package br.com.alura.gerenciador.model;

public class Usuario {
	
	private String usuario;
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + senha.hashCode();
		result = prime * result + usuario.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if(usuario.equals(other.getUsuario())) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + "]";
	}
	
	
	

}
