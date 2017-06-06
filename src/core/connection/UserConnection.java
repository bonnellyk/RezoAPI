package core.connection;

import java.sql.Timestamp;

public class UserConnection {

	private int firstUserId;
	private int secondUserId;
	private Timestamp requestDate;
	private Timestamp acceptDate;
	private double latitude;
	private double longitude;
	private boolean accepted;
	
	public UserConnection(){
		
	}
	
	public UserConnection(int firstUserId, int secondUserId, Timestamp requestDate, Timestamp acceptDate,
			double latitude, double longitude, boolean accepted) {
		super();
		this.firstUserId = firstUserId;
		this.secondUserId = secondUserId;
		this.requestDate = requestDate;
		this.acceptDate = acceptDate;
		this.latitude = latitude;
		this.longitude = longitude;
		this.accepted = accepted;
	}

	public int getFirstUserId() {
		return firstUserId;
	}


	public void setFirstUserId(int firstUserId) {
		this.firstUserId = firstUserId;
	}


	public int getSecondUserId() {
		return secondUserId;
	}


	public void setSecondUserId(int secondUserId) {
		this.secondUserId = secondUserId;
	}


	public Timestamp getRequestDate() {
		return requestDate;
	}


	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}


	public Timestamp getAcceptDate() {
		return acceptDate;
	}


	public void setAcceptDate(Timestamp acceptDate) {
		this.acceptDate = acceptDate;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public boolean isAccepted() {
		return accepted;
	}


	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	
	
}
