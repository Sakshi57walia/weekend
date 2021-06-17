package weekend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author sakshi
 * 
 * this is a static class with the utility method to load properties from weekend.properties file
 *
 */
public final class WeekendProperties {
	
	final static Properties properties = new Properties();
	final static String propertyFilePath = "weekend.properties";

	/**
	 * read the properties filr
	 */
	public static void ConfigFileReader() {
		BufferedReader reader;
		try {
			System.out.println("path " + propertyFilePath);

			reader = new BufferedReader(new FileReader(propertyFilePath));
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public static String getDriverPath() {
		

		try {
			String driverPath = properties.getProperty("driverPath");
			if (driverPath != null)
				return driverPath;
			else
				throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
		} catch (Exception ex) {
			System.out.println("Error path" + ex);
		}
		return propertyFilePath;
	}

	public static long getImplicitlyWait() {

		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public static String getApplicationUrl() {

		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public static String getApplicationLocation() {

		String url = properties.getProperty("location");
		if (url != null)
			return url;
		else
			throw new RuntimeException("location is  not specified in the Configuration.properties file.");
	}
	public static String getApplicationLocation1() {

		String url = properties.getProperty("location1");
		if (url != null)
			return url;
		else
			throw new RuntimeException("location1 is  not specified in the Configuration.properties file.");
	}

	public static String getApplicationRadius() {

		String url = properties.getProperty("radius");

		if (url != null)
			return url;
		else
			throw new RuntimeException("radius is  not specified in the Configuration.properties file.");
	}

	public static String getApplicationStartingmonth() {

		String url = properties.getProperty("Startingmonth");

		if (url != null)
			return url;
		else
			throw new RuntimeException("Startingmonth is  not specified in the Configuration.properties file.");
	}

	public static String getApplicationStartingdate() {

		String url = properties.getProperty("Startingdate");

		if (url != null)
			return url;
		else
			throw new RuntimeException("Startingdate is  not specified in the Configuration.properties file.");
	}

	public static String getApplicationStartingdate1() {

		String url = properties.getProperty("Startingdate1");

		if (url != null)
			return url;
		else
			throw new RuntimeException("Startingdate1 is  not specified in the Configuration.properties file.");
	}

	public static String getApplicationEndingmonth() {

		String url = properties.getProperty("Endingmonth");

		if (url != null)
			return url;
		else
			throw new RuntimeException("Endingmonth is  not specified in the Configuration.properties file.");
	}

	public static String getAdult() {

		String url = properties.getProperty("Adult");

		if (url != null)
			return url;
		else
			throw new RuntimeException("adultmonth is  not specified in the Configuration.properties file.");
	}

	public static String getChildren() {

		String url = properties.getProperty("Children");

		if (url != null)
			return url;
		else
			throw new RuntimeException("children is  not specified in the Configuration.properties file.");
	}

	public static String getRooms() {

		String url = properties.getProperty("Rooms");

		if (url != null)
			return url;
		else
			throw new RuntimeException("Rooms is  not specified in the Configuration.properties file.");
	}

	public static String getApplicationEndingdate() {

		String url = properties.getProperty("Endingdate");

		if (url != null)
			return url;
		else
			throw new RuntimeException("Endingdate is  not specified in the Configuration.properties file.");
	}

	public static String getApplicationEndingdate1() {

		String url = properties.getProperty("Endingdate1");

		if (url != null)
			return url;
		else
			throw new RuntimeException("Endingdate1 is  not specified in the Configuration.properties file.");
	}
}
