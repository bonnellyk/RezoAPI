package core.socialmedia;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import core.user.UserActions;

@Path("/socialmedia")
public class SocialMediaActions {
	@Path("/getToken/{userId}/{login_api}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserFromId(@PathParam("userId") int userId, @PathParam("login_api") String loginAPI) {
		ISocialMediaManager smm = UserActions.instantiateSocialMediaManager(loginAPI);
		TokenAPI token = smm.getTokenFromUserId(userId);
		return Response.status(200).entity(token).build();
	}
	
	@Path("/updateToken/{login_api}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateToken(TokenAPI token, @PathParam("login_api") String loginAPI){
		ISocialMediaManager smm = UserActions.instantiateSocialMediaManager(loginAPI);
		smm.addOrUpdateToken(token);
	}
}
