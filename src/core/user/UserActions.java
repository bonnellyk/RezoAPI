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

import core.socialmedia.ISocialMediaManager;
import core.socialmedia.TokenAPI;
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

	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(UserLogin user) {
		System.out.println("TEST");
		boolean firsttimeLogin = false;
		ISocialMediaManager socialMediaManager = null;

		int userId = getUserId(user.getEmail(), user.getLoginAPI().toString(), user.getProfileID());
		if (userId == -1) {

			firsttimeLogin = true;
			UserDAO.addNewUser(user);
			userId = getUserId(user.getEmail(), user.getLoginAPI().toString(), user.getProfileID());
		}

		socialMediaManager = instantiateSocialMediaManager(user.getLoginAPI().toString());

		if (socialMediaManager != null) {
			TokenAPI token = new TokenAPI(userId, user.getAccessToken(), user.getProfileID());
			socialMediaManager.addOrUpdateToken(token);
		}

		return Response.status(200).entity(firsttimeLogin).build();
	}

	private int getUserId(String email, String loginAPI, String profileId) {
		int userId = -1;
		if(email != null && email != ""){
			userId = UserDAO.getUserIdByEmail(email);
		}
		
		if(userId == -1) {
			userId = UserDAO.getUserIdByProfile(loginAPI, profileId);
		}
		return userId;
	}

	public static ISocialMediaManager instantiateSocialMediaManager(final String loginApi) {
		ISocialMediaManager smm = null;
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
