package sep2.dataBase.dbUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat dateFormat= new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    private static Date now= new Date();


    public static String getFormatDate(){
        String s= dateFormat.format(now);
        return s;
    }

    public static long getUtilTime(){
        return now.getTime();
    }

    public static java.sql.Date getSqlDate(){
        java.sql.Date sqlDate=
                new java.sql.Date
                        (now.getTime());
        return sqlDate;
    }

    public static Timestamp getTimestamp(){
        Timestamp timestamp= new Timestamp(now.getTime());
        return timestamp;
    }
}
