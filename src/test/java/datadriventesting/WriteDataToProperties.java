package datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataToProperties {

	public static void main(String[] args) throws IOException {
		// Step 1: Convert physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");

		// Step 2: Create an instance for Properties class
		Properties property = new Properties();

		// Step 3: Load all key-value pairs to properties object from fis
		property.load(fis);
		
		// Step 4: Write data into properties
		property.put("username2", "trainee");
		property.put("password2", "trainee");
		
		// Step 5: Save properties
		FileOutputStream fos = new FileOutputStream("./src/test/resources/data.properties");
		property.store(fos, "Updated File Successfully");
		
	}

}
