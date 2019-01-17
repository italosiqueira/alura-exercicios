package br.com.caelum.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	private static Integer chaveSequencial = 1;
	
	static {
		Banco.empresas.add(new Empresa(chaveSequencial++, "Alura"));
		Banco.empresas.add(new Empresa(chaveSequencial++, "Caelum"));
		
	}
	
	public void adiciona(Empresa empresa) {
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return new ArrayList<>(Banco.empresas);
	}

}
