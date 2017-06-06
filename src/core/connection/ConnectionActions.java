package core.connection;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/connect")
public class ConnectionActions {
	
	@Path("/request/{first_user_id}/{second_user_id}/{position_lat}/{position_lon}")
	@POST
	public void addNewConnection(@PathParam("first_userId") int firstUserId,@PathParam("second_userId") int secondUserId,
			@PathParam("position_lat") double positionLat,@PathParam("position_lon") double positionLon) {
		
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		
		UserConnection userConn = new UserConnection();
		userConn.setFirstUserId(firstUserId);
		userConn.setSecondUserId(secondUserId);
		userConn.setLatitude(positionLat);
		userConn.setLongitude(positionLon);
		userConn.setRequestDate(timestamp);
		
		ConnectionDAO.insertNewConnectionRequest(userConn);
		
	}
	
	@Path("/accept/{first_user_id}/{second_user_id}")
	@PUT
	public void acceptConnection(@PathParam("first_userId") int firstUserId,@PathParam("second_userId") int secondUserId) {
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		
		ConnectionDAO.acceptConnectionRequest(firstUserId, secondUserId, timestamp);
	}
	
}
