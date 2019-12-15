package br.com.alura.timer;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;

@Singleton
public class AgendamentoEmailTimer {
	
	private Logger logger = Logger.getLogger(AgendamentoEmailTimer.class.getName());
	
	@Inject
	private AgendamentoEmailBusiness business;
	
	@Schedule(hour="*", minute="0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55")
	public void enviarEmailsAgendados() {
		
		List<AgendamentoEmail> emailNaoEnviados = this.business.listarAgendamentosEmailNaoEnviados();
		emailNaoEnviados
			.stream()
			.forEach(
					agendamentoEmail -> this.logger.info("Enviou para " + agendamentoEmail.getEmail()));			
	}

}
