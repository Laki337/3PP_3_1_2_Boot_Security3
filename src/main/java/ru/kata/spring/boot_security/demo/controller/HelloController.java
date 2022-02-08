package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

@Controller
@RequestMapping("/")
public class HelloController {
	
	private final UserServiceImpl userServiceImpl;
	private final RoleServiceImpl roleServiceImpl;

	public HelloController(UserServiceImpl userServiceImpl, RoleServiceImpl roleServiceImpl) {
		this.userServiceImpl = userServiceImpl;
		this.roleServiceImpl = roleServiceImpl;
	}
	
	@GetMapping(value = "")
	public String redirect() {
		return "redirect:/login";
	}
	
	@GetMapping(value = "login")
	public String login() {
		return "loginPage";
	}
	
	@GetMapping(value = "index")
	public String userInfo(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("roles", user.getRoles());
		return "index";
	}
	
	@GetMapping(value = "admin")
	public String listUsers(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("allUsers", userServiceImpl.getAllUsers());
		model.addAttribute("allRoles", roleServiceImpl.getRoles());
		return "adminPage";
	}
}


