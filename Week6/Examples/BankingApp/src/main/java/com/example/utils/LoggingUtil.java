package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtil {
	
	/* Logging: The logging of records that occur during the execution of your program
	 * - This allows for developer to access information about the application without having direct access
	 * - With logging developers wouldn't know where to look for issues when their application crashed for the client
	 * 
	 * For logging we will be using Logback
	 * - Successor of the older Log4j
	 * - It is an implementation of the slf4j intergace, so you will also have to include that package
	 * 
	 * Logback allows us to configure and use several different logging levels, and also allows us to set thresholds
	 * which allow certain levels of logging to be saved
	 * 
	 * Logging Levels:
	 * 1. ALL => all levels
	 * 2. DEBUG => fine grained information about events that are useful for debugging
	 * 3. INFO => informational messages about things that occur in the application
	 * 4. WARN => something wrong may have happened
	 * 5. ERROR => some exception, or some other recoverable issue has occured
	 * 6. FATAL => severe error, something very bad happened, the app probably crashed
	 * 7. OFF => ignore all logging
	 * 
	 * We configure how our logger will act and what the threshold is in a file called logback.xml in the java/resources
	 * folder
	 * 
	 * 
	 */
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingUtil.class);
	
	public static Logger getLogger() {
		return logger;
	}

}
