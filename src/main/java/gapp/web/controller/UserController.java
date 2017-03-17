package gapp.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import gapp.model.User;
import gapp.model.UserType;
import gapp.model.dao.UserDao;
import gapp.model.dao.UserTypeDao;
import gapp.model.dao.jpa.UserTypeDaoImpl;
import gapp.web.validator.newUserValidator;
import gapp.web.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserTypeDao userTypeDao;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private newUserValidator newUserValidator;

	@RequestMapping("/users.html")
	public String users(ModelMap models) {
		models.put("users", userDao.getUsers());
		return "users";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(ModelMap models) {
		models.put("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String login(@ModelAttribute User user, HttpSession session, BindingResult result) {

		System.out.println(user.getEmail());
		System.out.println(user.getPassword());

		userValidator.validate(user, result);

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "login";
		}

		List<User> users = userDao.getUsers();
		int f = 0;
		User loginUser = null;
		String email = user.getEmail();
		String password = user.getPassword();

		for (User u : users) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
				loginUser = u;
				f = 1;
			}
		}
		if (f == 0)
			return "redirect:/login.html";
		else {
			session.setAttribute("username", loginUser.getFirstName());
			session.setAttribute("userId", loginUser.getUserId());
			if (loginUser.getUserType().getUserTypeId() == 1)
				return "redirect:/admin.html?userid=" + loginUser.getUserId();
			else if (loginUser.getUserType().getUserTypeId() == 2 || loginUser.getUserType().getUserTypeId() == 3
					|| loginUser.getUserType().getUserTypeId() == 4)
				return "redirect:/staff.html?userid=" + loginUser.getUserId();
			else
				return "redirect:/student.html?userid=" + loginUser.getUserId();
		}
	}

	@RequestMapping(value = "/Register.html", method = RequestMethod.GET)
	public String register(ModelMap models) {
		System.out.println("Register get");
		models.put("user", new User());
		return "Register";
	}

	@RequestMapping(value = "/Register.html", method = RequestMethod.POST)
	public String register(@ModelAttribute User user, BindingResult result, SessionStatus sessionStatus) {
		System.out.println("resister post");
		newUserValidator.validate(user, result);

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "Register";
		}

		UserType usertype = userTypeDao.getUserType(5);
		user.setUserType(usertype);
		user = userDao.saveUser(user);
		sessionStatus.setComplete();
		return "login";
	}

	@RequestMapping("/staff.html")
	public String staff(ModelMap models) {
		return "staff";
	}

	@RequestMapping("/logout.html")
	public String logout(HttpSession session,SessionStatus sessionStatus) {
		session.invalidate();
		sessionStatus.setComplete();
		return "redirect:/login.html";
	}

}
