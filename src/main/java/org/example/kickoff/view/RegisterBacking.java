package org.example.kickoff.view;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Size;

import org.example.kickoff.business.UserService;
import org.example.kickoff.business.ValidationException;
import org.example.kickoff.model.User;
import org.omnifaces.util.Messages;

@ManagedBean
@ViewScoped
public class RegisterBacking {

	@EJB
	private UserService userService;

	private User user = new User();

	@Size(min = 8)
	private String password;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void register() {
		try {
			userService.registerUser(user, password);
		}
		catch (ValidationException e) {
			Messages.addGlobalError(e.getMessage());
		}
	}

}