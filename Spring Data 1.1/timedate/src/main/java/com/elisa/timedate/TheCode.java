package com.elisa.timedate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCode {
	@RequestMapping("/c")
	public String index() {
		return "Code.jsp";
	}
	@RequestMapping(value="/c/form", method=RequestMethod.POST)
	public String form(@RequestParam(value="password") String password) {
		if(password.equals("bushido")) {
			return "bushidoCode.jsp";
		}else {
			return "redirect:/createError";	
		}
	}
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "Mucho que aprender todavía tienes");
        return "redirect:/c";
	}
}
