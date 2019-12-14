package br.com.alura.interceptor;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolationException;

@Interceptor
@Priority(1)
@br.com.alura.interceptor.Logger
public class LoggerInterceptor {
	
	@AroundInvoke
	public Object treatException(InvocationContext context) throws Exception {
		
		Logger log = Logger.getLogger(context.getTarget().getClass().getName());
		
		try {
			return context.proceed();
		} catch (Exception e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				log.info(e.getMessage());
			} else {
				log.severe(e.getMessage());
			}
			
			// para o mapeamento de exceções continuar capturando as exceções 
			// e mostrar a mensagem na tela
			throw e;
		}
	}
	
}
