package br.com.alura.resource;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;

@Path("/agendamentoemail")
public class AgendamentoEmailResource {
	
	private static Logger log = Logger.getLogger(AgendamentoEmailResource.class.getName());
	
	@Inject
	private AgendamentoEmailBusiness business;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarAgendamentosEmail() {
		
		List<AgendamentoEmail> emails = business.listarAgendamentosEmail();
		return Response.ok(emails).build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail ) {
		
		try {
			business.salvarAgendamentoEmail(agendamentoEmail);
		} catch (EJBException e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				log.info(e.getMessage());
			} else {
				log.severe(e.getMessage());
			}
			
			// para o mapeamento de exceções continuar capturando as exceções 
			// e mostrar a mensagem na tela
			throw e;
		}
		
		return Response.status(201).build();
	
	}

}
