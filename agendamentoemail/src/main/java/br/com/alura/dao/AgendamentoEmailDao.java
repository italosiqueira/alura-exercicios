package br.com.alura.dao;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		return Arrays.asList(criaAgendamentoEmail("italosiqueira@gmail.com"),
				criaAgendamentoEmail("arturpinholima@gmail.com"));
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

	public List<AgendamentoEmail> listarAgendamentoEmailPorEmail(String email) {
		TypedQuery<AgendamentoEmail> query = em.createQuery(
				"SELECT a FROM AgendamentoEmail a WHERE a.email = :email AND a.enviado = FALSE",
				AgendamentoEmail.class);

		query.setParameter("email", email);

		return query.getResultList();
	}

	public List<AgendamentoEmail> listarAgendamentosEmailNaoEnviados() {
		return em.createQuery(
				"SELECT a FROM AgendamentoEmail a WHERE a.enviado = FALSE",
				AgendamentoEmail.class).getResultList();
	}
}
