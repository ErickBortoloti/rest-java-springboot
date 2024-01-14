package cloud.erickdevops.manipulador;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import cloud.erickdevops.exceptions.ExcepetionResponse;


@ControllerAdvice
@RestController
public class customizadorResponseEntityExceptionHadler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExcepetionResponse> todasExcecoes(
			Exception ex, WebRequest request) {
		
		ExcepetionResponse excepetionResponse = new ExcepetionResponse(
				new Date(), 
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(excepetionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UnsupportedOperationException.class)
	public final ResponseEntity<ExcepetionResponse> metodoNaoSuportadoExcecoes(
			Exception ex, WebRequest request) {
		
		ExcepetionResponse excepetionResponse = new ExcepetionResponse(
				new Date(), 
				ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity<>(excepetionResponse, HttpStatus.BAD_REQUEST);
		
	}


}
