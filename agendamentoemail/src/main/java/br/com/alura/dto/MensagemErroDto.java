package br.com.alura.dto;

import java.util.Date;
import java.util.List;

/**
 * Esta classe serve para encapsular para transporte as mensagens de exce��o at� a <i>view</i> da 
 * aplica��o para exibi��o. Baseada no padr�o estrutural <i>Data Transfer Object</i>.
 */
public class MensagemErroDto {

	private List<String> mensagens;

	private Date dataErro;

	public List<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}

	public Date getDataErro() {
		return dataErro;
	}

	public void setDataErro(Date dataErro) {
		this.dataErro = dataErro;
	}

	public static MensagemErroDto build(List<String> mensagem) {
		MensagemErroDto dto = new MensagemErroDto();
		dto.setMensagens(mensagem);
		dto.setDataErro(new Date());
		return dto;
	}

}
