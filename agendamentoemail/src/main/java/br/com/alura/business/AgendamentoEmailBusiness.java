package br.com.alura.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class AgendamentoEmailBusiness {
	
	public List<String> listarAgendamentosEmail() {
		
		List<String> emails = new ArrayList<String>();
		
		emails.add("email1@test.com");
		emails.add("email2@test.com");
		
		return emails;
	}

}
