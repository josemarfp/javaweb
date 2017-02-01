package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OlaMundoController {
	@RequestMapping("/olaMundoSpring")
	public String execute(Model model) {
		System.out.println("Executando a logica com Spring MVC");
		model.addAttribute("teste", "Teste de atributo");
		System.out.println(model.toString());
		return "ok";
	}
	
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}