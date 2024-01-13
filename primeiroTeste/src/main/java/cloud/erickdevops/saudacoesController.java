package cloud.erickdevops;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class saudacoesController {
	
	private static final String Template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	
	@RequestMapping("/teste")
	public testando teste(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new testando(counter.incrementAndGet(), String.format(Template, name));
	}

}
