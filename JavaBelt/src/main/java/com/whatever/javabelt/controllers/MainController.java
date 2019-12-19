package com.whatever.javabelt.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.whatever.javabelt.models.Show;
import com.whatever.javabelt.models.ShowUser;
import com.whatever.javabelt.models.User;
import com.whatever.javabelt.repositories.ShowRepository;
import com.whatever.javabelt.repositories.ShowUserRepository;
import com.whatever.javabelt.services.ShowService;
import com.whatever.javabelt.services.ShowUserService;
import com.whatever.javabelt.services.UserService;
import com.whatever.javabelt.validations.UserValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * MainController
 */
@Controller
public class MainController {

    private final UserService userService;
	private final UserValidator userValidator;
	private final ShowService showService;
	private final ShowRepository showRepository;
	private final ShowUserService showUserService;
	private final ShowUserRepository showUserRepository;


    public MainController(
        UserService userService,
		UserValidator userValidator, 
		ShowService showService, 
		ShowRepository showRepository,
		ShowUserRepository showUserRepository,
		ShowUserService showUserService
    ) {
        this.userService = userService;
		this.userValidator = userValidator;
		this.showService = showService;
		this.showRepository = showRepository;
		this.showUserService = showUserService;
		this.showUserRepository = showUserRepository;
    }

    @GetMapping("/")
	public String regAndLogin(Model model) {
		model.addAttribute("user_r", new User());
		return "logReg.jsp";
	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("user_r") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "logReg.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email_l") String email, @RequestParam("password_l") String password, Model model, HttpSession session) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/dashboard";
		} else {
			model.addAttribute("error", "Invalid Credentials. Please try again");
			return "logReg.jsp";
		}
    }
    
    @GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		User user = userService.findUserById((Long) session.getAttribute("userId"));
		List<Show> shows = showRepository.findAll();
//		List<Object> mylist = new ArrayList<Object>();
//		for(int i = 0; i < ms.size(); i++) {
//			mylist.add(ms.get(i));
//		}for(int i = 0; i < as.size(); i++) {
//			mylist.add(as.get(i));
//		}
//		model.addAttribute("mylist", mylist);
		model.addAttribute("user", user);
		model.addAttribute("shows", shows);
		return "dashboard.jsp";
	}

	@GetMapping("/shows/new")
	public String newShow(@ModelAttribute("show") Show show){
		return "newShow.jsp";
	}

	@PostMapping("/createshow")
	public String createShow(@Valid @ModelAttribute("show") Show show, BindingResult result){
		if(result.hasErrors()){
			return "newShow.jsp";
		} else {
			showService.createShow(show);
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/shows/{id}")
	public String showDisplay(@PathVariable("id") Long id, Model model, @ModelAttribute("rating") ShowUser rating, HttpSession session){
		Show show = showService.findShow(id);
		User user = userService.findUserById((Long) session.getAttribute("userId"));
		List<User> raters = show.getRaters();
		
		List<ShowUser> allRatings = showUserRepository.allOrderedByRating();
		ArrayList<ShowUser> finalList = new ArrayList<ShowUser>();
		for(ShowUser thing : allRatings){
			if(thing.getShow() == show){
				finalList.add(thing);
			}
		}
		model.addAttribute("show", show);
		model.addAttribute("raters", raters);
		model.addAttribute("user", user);
		model.addAttribute("finalList", finalList);
		return "showDisplay.jsp";
	}

	@PostMapping("createrating/{id}")
	public String createRating(@PathVariable("id") Long show_id, @Valid @ModelAttribute("rating") ShowUser rating, BindingResult result, HttpSession session, Model model){
		if(result.hasErrors()){
			return "showDisplay.jsp";
		} else {
			Show show = showService.findShow(show_id);
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			ShowUser newRating = showUserService.createShowUser(rating);
			newRating.setShow(show);
			newRating.setUser(user);
			showUserService.createShowUser(newRating);

			return "redirect:/shows/" + show_id;
		}
		
	}
}