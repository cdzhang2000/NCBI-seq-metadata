package edu.vt.vbi;

/**
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Virginia Bioinformatics Institute</p>
 * @author Chengdong Zhang
 * @version 1.0
 * Description: DatabaseSourceSingleton is initialized when Vbidas service
 * is called. DatabaseSourceSingleton holds the database information,
 * such as database url, user name, password and database name. These information
 * is configured in the dbconfig.cfg file.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Singleton pattern is adopted here
 */
public class DatabaseManager {

	private Connection conn = null;

	private static DatabaseManager instance = null;

	private static final String propertyFileName = "config.properties";

	private String logname = "";

	private String password = "";

	private String dbDriver = "";

	private String dbUrl = "";

	private DatabaseManager() {

		try {
			initialConnection();
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		instance = this;

		System.out.println("instance created");

	}

	public static DatabaseManager instance() {

		if (instance == null) {
			DatabaseManager.instance = new DatabaseManager();
		}

		return DatabaseManager.instance;
	}

	private void loadProperty() {

		// Read configuration from config.properties file.
		try {
			Properties properties = new Properties();

			properties.load(new FileInputStream(propertyFileName));

			logname = properties.getProperty("userid");

			password = properties.getProperty("password");

			dbDriver = properties.getProperty("driver");

			dbUrl = properties.getProperty("url");

			System.out.println("user id=" + logname);
			System.out.println("password=" + password);
			System.out.println("url=" + dbUrl);
			System.out.println("driver=" + dbDriver);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void initialConnection() {

		loadProperty();

		try {
			Class.forName(dbDriver);
			this.conn = DriverManager.getConnection(dbUrl, logname, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {

		if (conn == null) {
			initialConnection();
		}
		return conn;
	}

	public void freeOracleConnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*--- Formatted in Sun Java Convention Style on Thu, Oct 7, '04 ---*/

/*------ Formatted by Jindent 3.24 Gold 1.02 --- http://www.jindent.de ------*/
