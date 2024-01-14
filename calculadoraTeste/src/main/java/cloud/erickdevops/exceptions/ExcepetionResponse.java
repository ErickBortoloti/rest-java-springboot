package cloud.erickdevops.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExcepetionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Date horaErro;
	private String mensagem;
	private String detalhes;
	
	public ExcepetionResponse(Date horaErro, String mensagem, String detalhes) {
		this.horaErro = horaErro;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}

	public Date getHoraErro() {
		return horaErro;
	}

	public void setHoraErro(Date horaErro) {
		this.horaErro = horaErro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	
}
