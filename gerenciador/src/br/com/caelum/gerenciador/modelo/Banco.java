package br.com.caelum.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
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

	public void removeEmpresa(Integer id) {
		// Deve-se utilizar um iterador para praticar a exclusão à medida que 
		// se itera sobre a coleção
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

}
