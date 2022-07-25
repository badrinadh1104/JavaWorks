package DatabaseLog;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

import org.apache.log4j.Logger;
 //this class provide the logging to MYSQL database
public class Main {
 
    private static Logger logger = Logger.getLogger(Main.class);
 //logger info 
    public static void writeTolog(String msg) {
		logger.info(msg);
	}
    //logger Error
    public static void writeErrorLog(String m ,Exception e) {
    	logger.error(m,e);
    }
    //logger Warn
    public static void WriteWarnlog(String m) {
    	logger.warn(m);
    }

}




