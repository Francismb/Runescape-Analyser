package org.pixie.rs.client.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Project rsclient
 * Created by Francis on 26/08/2015.
 */
public class Utility {

    /**
     * @param URL the url of which to download from.
     * @return the source of the web page.
     */
    public static String getWebPageSource(String URL) {
        try {
            final HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 ( ; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
            final BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            final StringBuffer sb = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            return sb.toString();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

}
