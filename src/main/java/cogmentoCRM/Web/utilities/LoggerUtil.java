package cogmentoCRM.Web.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
	private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

	public void info(String message) {
		logger.info(message);
	}

	public void error(String message) {
		logger.info(message);
	}

	public void warn(String message) {
		logger.info(message);
	}

	public void debug(String message) {
		logger.info(message);
	}

	public void fatal(String message) {
		logger.info(message);
	}
}
