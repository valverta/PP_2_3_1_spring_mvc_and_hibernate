package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		model.addAttribute("allUser", userService.getAllUsers());
		return "index";
	}

	@GetMapping(value = "/post-page")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "post-page";
	}

	@RequestMapping(value = "/save-user")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveOrUpdateUser(user);
		return "redirect:/";
	}
}