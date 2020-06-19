package br.com.alura.timer;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;

@Singleton
public class AgendamentoEmailTimer {

	@Inject
	private AgendamentoEmailBusiness business;

	@Inject
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
	private JMSContext context;

	@Resource(mappedName = "java:/jms/queue/EmailQueue")
	private Queue queue;

	@Schedule(hour = "*", minute = "0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55")
	public void enviarEmailsAgendados() {

		List<AgendamentoEmail> emailNaoEnviados = this.business.listarAgendamentosEmailNaoEnviados();

		emailNaoEnviados.stream().forEach(agendamentoEmail -> {
			this.context.createProducer().send(queue, agendamentoEmail);
			this.business.marcarEnviada(agendamentoEmail);
		});
	}

}
