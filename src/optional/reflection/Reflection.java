package optional.reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;

class InputUser {
	public String name;
	private String email;
	private int phoneNumber;
	
	public InputUser(String name, String email, int phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public InputUser(String name) {
		this(name, null, -1);
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	@Override
	public String toString() {
		return "InputUser{" + "name='" + name + '\'' + ", email='" + email + '\'' + ", phoneNumber=" + phoneNumber + '}';
	}
}

public class Reflection {
	public static void main(String[] args) {
		String className = args[0];
		String name = args[1];
		String email = args[2];
		int phoneNumber = Integer.parseInt(args[3]);
		
		try {
			Class userClass = Class.forName(className);
			Class[] constructorClasses = new Class[]{String.class, String.class, int.class};
			Object[] constructorValues = new Object[]{name, email, phoneNumber};
			Constructor constructor = userClass.getConstructor(constructorClasses);
			InputUser object = (InputUser) constructor.newInstance(constructorValues);
			System.out.println("Created object from user input: " + object);
			System.out.println("Methods: " + Arrays.toString(userClass.getMethods()));
			System.out.println("All properties: " + Arrays.toString(userClass.getDeclaredFields()));
			System.out.println("Public properties: " + Arrays.toString(userClass.getFields()));
			System.out.println("Invoking method from class: " + userClass.getMethod("toString").invoke(object));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
