package br.edu.unirv.rankers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unirv.rankers.entity.UserVoto;
import br.edu.unirv.rankers.service.UserVotoService;
@Controller
public class UserVotoController {

	@Autowired
	private UserVotoService userVotoService;
	
	@GetMapping("/uservoto")
	public String getAllUserVoto(Model model) {
		model.addAttribute("uservotos", userVotoService.findAll());
		return "uservotos";
	}

	@GetMapping("/uservoto")
	public String uservotoForm(Model model) {
		model.addAttribute("product", new UserVoto());
		return "uservoto_form";
	}
	
	@PostMapping("/uservoto")
	public String saveUserVotoForm(@ModelAttribute UserVoto newUserVoto) {
		userVotoService.save(newUserVoto);
		return "redirect:/index";
	}
}
