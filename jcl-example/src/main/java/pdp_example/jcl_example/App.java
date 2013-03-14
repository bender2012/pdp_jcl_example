package pdp_example.jcl_example;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {

	private static final Logger logger = Logger.getLogger(App.class.getName());

	private static final String TEST_LOG_MESSAGE = "Hello World!!!";
	private static final String TEST_LOG_MESSAGE_TO_FILE = "Hello World to File!!!";

	public static void main(String[] args) {
		logger.info(TEST_LOG_MESSAGE);
		try {
			FileHandler fhandler = new FileHandler("Logfile.txt");
			SimpleFormatter sformatter = new SimpleFormatter();
			fhandler.setFormatter(sformatter);
			logger.addHandler(fhandler);

		} catch (IOException ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		} catch (SecurityException ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}
		logger.info(TEST_LOG_MESSAGE_TO_FILE);
	}
}
