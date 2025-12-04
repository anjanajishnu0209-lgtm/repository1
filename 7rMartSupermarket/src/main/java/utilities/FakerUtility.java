package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	
    Faker fakerObj = new Faker();
	public String getusername() {
		String name= fakerObj.name().firstName();
		return name;
	}
	public String getpassword() {
		String password = fakerObj.internet().password();
		return password;
	}
	public String getEmail() {
		String email = fakerObj.internet().emailAddress();
		return email;
	}
	public String getImage() {
		String image = fakerObj.internet().image();
		return image;
	}
	public String getDomain() {
		String domain = fakerObj.internet().domainName();
		return domain;
	}
}
