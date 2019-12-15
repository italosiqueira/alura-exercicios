package br.com.alura.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.alura.dao.AgendamentoEmailDao;
import br.com.alura.entity.AgendamentoEmail;
import br.com.alura.exception.BusinessException;
import br.com.alura.interceptor.Logger;

@Stateless
@Logger
public class AgendamentoEmailBusiness {
	
	@Inject
	private AgendamentoEmailDao agendamentoEmailDao;
	
	public List<AgendamentoEmail> listarAgendamentosEmail() {
		return agendamentoEmailDao.listarAgendamentosEmail();
	}
	
	public List<AgendamentoEmail> listarAgendamentosEmailNaoEnviados() {
		return agendamentoEmailDao.listarAgendamentosEmailNaoEnviados();
	}
	
	public void salvarAgendamentoEmail(@Valid AgendamentoEmail agendamentoEmail) throws BusinessException {
		
		if (agendamentoEmailDao.listarAgendamentoEmailPorEmail(agendamentoEmail.getEmail()).isEmpty()) {			
			agendamentoEmail.setEnviado(false);
			agendamentoEmailDao.salvarAgendamento(agendamentoEmail);
		} else {
			throw new BusinessException("E-Mail ainda possui agendamento pendente para envio!");
		}
	}

}
