package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository repo;
	
	
	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		
		return "login";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user, RedirectAttributes ra) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		
		return "redirect:/login";
	}
	
	@GetMapping("/menu")
	public String viewMenu() {
		
		return "menu";
	}
	
	@GetMapping("/calculator")
	public String viewCalculator() {
		
		return "calculator";
	}
	
	@GetMapping("/back_to_menu")
	public String backToMenu() {
		
		return "menu";
	}
	
	@Autowired private DespesasService service;
	
	@GetMapping("/fluxodecaixa")
	public String showDespesasList(Model model) {
		List<Despesas> listDespesas = service.listAll();
		model.addAttribute("listDespesas", listDespesas);
		
		return "fluxodecaixa";
	}
	
	@GetMapping("/irrf")
	public String impostoDeRenda() {
		
		return "irrf";
	}
	
	@GetMapping("/caddespesas")
	public String showNewForm(Model model) {
		model.addAttribute("despesa", new Despesas());
		return "despesas_form";
	}
	
	@PostMapping("/despesas/save")
	public String saveDespesa(Despesas despesa, RedirectAttributes ra) {
		service.save(despesa);
		ra.addFlashAttribute("message", "Sua despesa/gasto foi CADASTRADO(A) com sucesso");
		return "redirect:/fluxodecaixa";
	}
	
	@GetMapping("/despesas/edit/{id}")
	public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
		try {
			Despesas despesa = service.get(id);
			model.addAttribute("despesa", despesa);
			return "despesas_form";
		} catch (DespesaNotFoundException e) {
			ra.addFlashAttribute("message", "Sua despesa/gasto foi ALTERADO(A) com sucesso");
			return "redirect:/fluxodecaixa";
		}	
	}
	
	@GetMapping("/despesas/delete/{id}")
	public String deleteDespesa(@PathVariable("id") Integer id, RedirectAttributes ra) {
		try {
			service.delete(id);
		} catch (DespesaNotFoundException e) {
			ra.addFlashAttribute("message", "Sua despesa/gasto foi NÃO FOI EXCLUIDO(A) com sucesso");
		}
		ra.addFlashAttribute("message", "Sua despesa/gasto foi EXCLUIDO(A) com sucesso");
		return "redirect:/fluxodecaixa";
	}
	
	@GetMapping("/relatoriomensal")
	public String viewRelatorioMensal() {
		
		return "relatoriomensal";
	}

}