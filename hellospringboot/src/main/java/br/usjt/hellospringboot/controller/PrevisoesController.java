package br.usjt.hellospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.hellospringboot.model.Previsao;
import br.usjt.hellospringboot.service.PrevisoesService;

@Controller
public class PrevisoesController {
	@Autowired
	 PrevisoesService previsoesService;
	 	
	//private PrevisoesRepository previsoesRepo;	
	//@Autowired
	//public PrevisoesController(PrevisoesRepository previsoesRepo) {
		//this.previsoesRepo = previsoesRepo;
	//}
	
	@GetMapping("/previsoes")
	public ModelAndView listarAlunos() {
		ModelAndView mv = new ModelAndView("lista_previsoes");
		List<Previsao> previsoes = previsoesService.listarTodos();
		mv.addObject(new Previsao());
		mv.addObject("previsoes", previsoes);
		return mv;
	}

	@PostMapping("/previsoes")
	public String salvar(Previsao previsao) {
		previsoesService.salvar(previsao);
		return "redirect:/previsoes";
	}
}
