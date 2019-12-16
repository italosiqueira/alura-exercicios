package br.com.alura.timer;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;

@Singleton
public class AgendamentoEmailTimer {
	
	@Inject
	private AgendamentoEmailBusiness business;
	
	@Schedule(hour="*", minute="0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55")
	public void enviarEmailsAgendados() {
		
		List<AgendamentoEmail> emailNaoEnviados = this.business.listarAgendamentosEmailNaoEnviados();
		
		emailNaoEnviados
			.stream()
			.forEach(
					agendamentoEmail -> this.business.enviarEmail(agendamentoEmail));			
	}

}
