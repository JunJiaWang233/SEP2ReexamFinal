package sep2.client.clientUtil;

import java.io.Closeable;
import java.io.IOException;

public class IoUtil {
    public static void close(Closeable... closeables){
        for (Closeable closeable: closeables){
            if (closeable != null){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
