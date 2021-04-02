package monprojet.controller;

import monprojet.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(path = "/admin")
public class AdminController {
	@GetMapping(path = "pageAdmin")
	public String montreLaPageAdmin(@AuthenticationPrincipal User user,  // Les infos de l'utilisateur connecté
                    Model model) {
                log.info("L'administrateur id: {}, email: {} accède à sa page", user.getId(), user.getEmail());
		return "pageAdmin"; // On affiche la vue 'pageAdmin.html'
	}    
}
