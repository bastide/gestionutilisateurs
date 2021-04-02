package monprojet.controller;

import monprojet.entity.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(path = "/user")
@Secured("ROLE_USER") // Réservé aux utilisateurs qui ont le rôle 'ROLE_USER'
public class UserController {
	@GetMapping(path = "pageUser")
	public String montrePageUtilisateur(
		@AuthenticationPrincipal User user,  // Les infos de l'utilisateur connecté
		Model model) {
		log.info("L'utilisateur id: {}, email: {} accède à sa page", user.getId(), user.getEmail());
		return "pageUser"; // On affiche la vue 'pageUser.html'
	}    
}
