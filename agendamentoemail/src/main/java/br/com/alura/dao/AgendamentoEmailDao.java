package br.com.alura.dao;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.alura.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<AgendamentoEmail> listarAgendamentosEmail() {
		return listarAgendamentosEmailJpa();
	}
	
	private List<AgendamentoEmail> listarAgendamentosEmailJpa() {
		return em.createQuery("SELECT a FROM AgendamentoEmail a", AgendamentoEmail.class).getResultList();
	}

	private List<AgendamentoEmail> listarAgendamentosEmailMock() {
		return Arrays.asList(criaAgendamentoEmail("italosiqueira@gmail.com"), criaAgendamentoEmail("arturpinholima@gmail.com"));
	}
	
	private AgendamentoEmail criaAgendamentoEmail(String string) {
		AgendamentoEmail agendamentoEmail = new AgendamentoEmail();
		agendamentoEmail.setEmail(string);
		agendamentoEmail.setEnviado(Boolean.FALSE);
		
		return agendamentoEmail;
	}

	public void salvarAgendamento(AgendamentoEmail agendamentoEmail) {
		em.persist(agendamentoEmail);
	}

}
