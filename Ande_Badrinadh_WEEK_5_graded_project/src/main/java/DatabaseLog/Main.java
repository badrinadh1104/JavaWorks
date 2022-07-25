package DatabaseLog;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

import org.apache.log4j.Logger;
 
public class Main {
 
    private static Logger logger = Logger.getLogger(Main.class);
 
    public static void writeTolog(String msg) {
		logger.info(msg);
	}
    public static void writeErrorLog(String m ,Exception e) {
    	logger.error(m,e);
    }
    public static void WriteWarnlog(String m) {
    	logger.warn(m);
    }

}




