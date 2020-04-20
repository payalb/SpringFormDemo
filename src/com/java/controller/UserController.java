package com.java.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dto.User;

@Controller
public class UserController {
	
	@PostMapping("/user")
	public String saveUser(@Valid @ModelAttribute User user, BindingResult result, Model m, RedirectAttributes rd, HttpSession session) throws IllegalStateException, IOException {
		if(result.hasErrors()) {
			m.addAttribute("errors",result.getAllErrors());
			System.out.println(result.getAllErrors());
		}
		MultipartFile productImage = user.getPhoto(); 
		String rootDirectory = 
			     session.getServletContext().getRealPath("/"); 
		System.out.println(session.getServletContext().getContextPath());
		//save image on server
		File f= new File(rootDirectory+"images/"+productImage.getName()+".jpg");
		System.out.println(f.getAbsolutePath());
			       productImage.transferTo(f);

		rd.addFlashAttribute("user", user);
		System.out.println(user);
		return "redirect:/display";
	}
	
	@GetMapping("/")
	public String enterDetails(Model model) {
		model.addAttribute("user", new User());
		return "userdetails";
	}
}
