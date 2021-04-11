package registrationForm;

public class InfoAndPass {
	
	private String firstName;
	private String lastName;
	private String email;
	private static String username;
	private String textPass;
	private String imagePass;
	private String rgbPass;
	private byte[] profilePic;//////
	
	

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTextPass() {
		return textPass;
	}
	public void setTextPass(String textPass) {
		this.textPass = textPass;
	}
	public String getImagePass() {
		return imagePass;
	}
	public void setImagePass(String imagePass) {
		this.imagePass = imagePass;
	}
	public String getRgbPass() {
		return rgbPass;
	}
	public void setRgbPass(String rgbPass) {
		this.rgbPass = rgbPass;
	}

	public byte[] getProfilePic(){/////
		return profilePic;
	}

	public void setProfilePic(byte[] profilePic){/////
		this.profilePic = profilePic;
	}

	
}
