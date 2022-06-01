package entity;

public class EmployeeDetails {
	private int id;
	private String name;
	private TrackDetail track;
	private int phoneNumber;
	private String role;
	public EmployeeDetails(int id, String name, TrackDetail track, int phoneNumber, String role) {
		super();
		this.id = id;
		this.name = name;
		this.track = track;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}
	
	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TrackDetail getTrack() {
		return track;
	}
	public void setTrack(TrackDetail track) {
		this.track = track;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "EmployeeDetails1 [id=" + id + ", name=" + name + ", track=" + track + ", phoneNumber=" + phoneNumber
				+ ", role=" + role + "]";
	}

}
