package interfaces;

import java.io.*;

public class SerializableUser implements Serializable {
  private String name;
  private int age;
  private transient String password; // Security risk, don't serialize

  public SerializableUser(String name, int age, String password) {
    this.name = name;
    this.age = age;
    this.password = password;
  }

  @Override
  public String toString() {
    // @formatter:off
    return "Name = '"
        + this.name
        + "'\n"
        + "Age = '"
        + this.age
        + "'\n"
        + "Password = '"
        + this.password;
    // @formatter:on
  }
}

class SerializeUser {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // Write serialized object to file.
    File serializedFile = new File("serialized_user.bin");
    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(serializedFile));
    outputStream.writeObject(new SerializableUser("Hercules", 1000, "IAMAGODCOPIUM"));
    outputStream.close();

    // Deserialize object and print to console.
    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(serializedFile));
    System.out.println(inputStream.readObject());
    inputStream.close();
    serializedFile.delete();
  }
}
