package wilby.argh.util;

import org.apache.logging.log4j.Logger;

public class ArghLogger 
{
	
	static Logger log;
	
	public ArghLogger(Logger logger)
	{
		log = logger;
	}
	
	public static void setLogger(Logger logger)
	{
		log = logger;
	}
	
	public static void log(String message)
	{
		log.info(message);
	}

	public static void debug(String message) 
	{
		log.debug(message);
	}
	
}
