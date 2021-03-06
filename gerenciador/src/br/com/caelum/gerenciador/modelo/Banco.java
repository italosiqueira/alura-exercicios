package br.com.caelum.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private static Integer chaveSequencial = 1;
	
	static {
		Banco.empresas.add(new Empresa(chaveSequencial++, "Alura"));
		Banco.empresas.add(new Empresa(chaveSequencial++, "Caelum"));
		
		Banco.usuarios.add(new Usuario("italo", "334529"));
		Banco.usuarios.add(new Usuario("fauzuda", "5247"));
	}
	
	public void adiciona(Empresa empresa) {
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return new ArrayList<>(Banco.empresas);
	}

	public void removeEmpresa(Integer id) {
		// Deve-se utilizar um iterador para praticar a exclus�o � medida que 
		// se itera sobre a cole��o
		Iterator<Empresa> it = empresas.iterator();
		while (it.hasNext()) {
			Empresa empresa = (Empresa) it.next();
			
			if (empresa.getId() == id) {
				it.remove();
				break;
			}
		}
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		
		for (Empresa empresa : empresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
	}
	
	public Usuario existeUsuario(String login, String senha) {
		
		for(Usuario usuario : usuarios) {
	        if(usuario.ehIgual(login, senha)) {
	            return usuario;
	        }
	    }
	    return null;
	}

}
