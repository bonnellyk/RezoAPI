package core.user;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import core.socialmedia.SocialMediaManager;
import core.socialmedia.facebook.FacebookManager;
import core.socialmedia.google.GooglePlusManager;

@Path("/user")
public class UserActions {

	@Path("{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserFromId(@PathParam("userId") int userId) {
		User user = new User();
		return Response.status(200).entity(user).build();
	}

	@Path("/getAllUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		ArrayList<User> allUsers = UserDAO.getAllUsers();
		return Response.status(200).entity(allUsers).build();
	}

	@Path("/login/{login_api}/{token}/{profile_id}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(User user, @PathParam("login_api") String loginAPI, @PathParam("token") String token, @PathParam("profile_id") String profileId) {
		System.out.println("TEST");
		boolean firsttimeLogin = false;
		SocialMediaManager socialMediaManager = null;

		// If user doesn't exist, the system will create a new user profile
		int userId = getUserId(user.getEmail());
		System.out.println("USER ID = "+userId);
		if (userId == -1) {
			firsttimeLogin = true;
			UserDAO.addNewUser(user);
			userId = getUserId(user.getEmail());
		}
		System.out.println("LOGIN API: "+loginAPI);
		socialMediaManager = instantiateSocialMediaManager(loginAPI);

		if (socialMediaManager != null) {
			socialMediaManager.addOrUpdateToken(userId, token, profileId);
		}

		return Response.status(200).entity(firsttimeLogin).build();
	}

	private int getUserId(String email) {
		return UserDAO.getUserId(email);
	}

	private SocialMediaManager instantiateSocialMediaManager(final String loginApi) {
		SocialMediaManager smm = null;
		switch (loginApi) {
		case "FACEBOOK":
			smm = new FacebookManager();	
			break;
		case "GOOGLE":
			smm = new GooglePlusManager();
			break;
		}
		return smm;
	}
}
