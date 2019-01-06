package br.com.caelum.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	static {
		Banco.empresas.add(new Empresa(1, "Alura"));
		Banco.empresas.add(new Empresa(2, "Caelum"));
		
	}
	
	public void adiciona(Empresa empresa) {
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return new ArrayList<>(Banco.empresas);
	}

}
