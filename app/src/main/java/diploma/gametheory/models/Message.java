package diploma.gametheory.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

	@SerializedName("firstName")
	@Expose
	private String firstName;
	@SerializedName("lastName")
	@Expose
	private String lastName;
	@SerializedName("userName")
	@Expose
	private String userName;

	@SerializedName("role")
	@Expose
	private String role;

	@SerializedName("authenticated")
	@Expose
	private Boolean authenticated;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

	@Override
	public String toString() {
		return "Message{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", userName='" + userName + '\'' +
				", authenticated=" + authenticated +
				'}';
	}
}