package cloud.erickdevops;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.erickdevops.exceptions.metodoNaoSuportadoException;

@RestController
public class calculadoraController {
	
	private final AtomicLong counter = new AtomicLong();
	
	
	@RequestMapping(value = "/soma/{numero1}/{numero2}", method=RequestMethod.GET)
	public Double soma(
			@PathVariable (value = "numero1") String numero1,
			@PathVariable (value = "numero2") String numero2)
			throws Exception{
		
		if(!eNumero(numero1) || !eNumero(numero2)) {
			throw new metodoNaoSuportadoException("Escolha um valor númerico!");
		}
		return converterParaDouble(numero1) + converterParaDouble(numero2);
	}


	private Double converterParaDouble(String numero) {
		
		String numb = numero.replaceAll(",", ".");
		if (numero == null) {
			return 0D;
		}
		
		else if (eNumero(numero)) {
			return Double.parseDouble(numb);
		}
			
	 return 0D;
	
	}


	private boolean eNumero(String numero) {
		String numb = numero.replaceAll(",", ".");
		if (numero == null) {
			return false;
		}
		return numb.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

	@RequestMapping(value = "/subtracao/{num1}/{num2}", method=RequestMethod.GET)
	public Double subtra(
			@PathVariable (value = "num1") String num1,
			@PathVariable (value = "num2") String num2)
			throws Exception{
		if (!eNumero(num1) || !eNumero (num2)) {
			throw new metodoNaoSuportadoException("Escolha um valor númerico!");		
	}
		return converterParaDouble(num1) - converterParaDouble(num2);
		
		
	
}
	
	@RequestMapping(value = "/div/{num1}/{num2}", method=RequestMethod.GET)
	public Double div(
			@PathVariable (value = "num1") String num1,
			@PathVariable (value = "num2") String num2)
			throws Exception {
		if (!eNumero(num1) || !eNumero(num2)) {
			throw new metodoNaoSuportadoException("Escolha um valor númerico!");
		}
		
		return converterParaDouble(num1) / converterParaDouble(num2);
	}
	
	@RequestMapping(value = "/sub/{num1}/{num2}", method=RequestMethod.GET)
	public Double sub(
			@PathVariable (value = "num1") String num1,
			@PathVariable (value = "num2") String num2)
			throws Exception{
		if (!eNumero(num1) || !eNumero (num2)) {
			throw new metodoNaoSuportadoException("Escolha um valor númerico!");		
	}
		return converterParaDouble(num1) - converterParaDouble(num2);
		
		
	
}
	
	@RequestMapping(value = "/x/{num1}/{num2}", method=RequestMethod.GET)
	public Double vezes(
			@PathVariable (value = "num1") String num1,
			@PathVariable (value = "num2") String num2)
			throws Exception {
		if (!eNumero(num1) || !eNumero(num2)) {
			throw new metodoNaoSuportadoException("Escolha um valor númerico!");
		}
		
		return converterParaDouble(num1) * converterParaDouble(num2);
	}
	
	
	@RequestMapping(value = "/potencia/{num1}/{num2}", method=RequestMethod.GET)
	public Double exponeciacao(
			@PathVariable (value = "num1") String num1,
			@PathVariable (value = "num2") String num2)
			throws Exception {
		if (!eNumero(num1) || !eNumero(num2)) {
			throw new metodoNaoSuportadoException("Escolha um valor númerico!");
		}
		
		return Math.pow(converterParaDouble(num1), converterParaDouble(num2));
		}
 

	@RequestMapping(value = "/raiz/{num1}", method=RequestMethod.GET)
	public Double raiz(

			@PathVariable (value = "num1") String num1)
			throws Exception {
		if (!eNumero(num1)) {
			throw new metodoNaoSuportadoException("Escolha um valor númerico!");
		}
		
		return Math.sqrt(converterParaDouble(num1));
		}
 

	@RequestMapping(value = "/media/{num1}/{num2}", method=RequestMethod.GET)
	public Double media(
			@PathVariable (value = "num1") String num1,
			@PathVariable (value = "num2") String num2)
			throws Exception {
		if (!eNumero(num1) || !eNumero(num2)) {
			throw new metodoNaoSuportadoException("Escolha um valor númerico!");
		}
		
		return (converterParaDouble(num1) + converterParaDouble(num2)) / 2;
		}
}





