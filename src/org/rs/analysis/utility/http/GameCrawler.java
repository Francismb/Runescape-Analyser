package org.rs.analysis.utility.http;

import org.rs.analysis.utility.Utility;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project rsclient
 * Created by Francis on 26/08/2015.
 */
public class GameCrawler {

    private final String url;

    public String archive;
    public String initialClass;
    public final Map<String, String> parameters = new HashMap<String, String>();

    private static final Pattern CLASS_PATTERN = Pattern.compile("code=([^\\s]*)");
    private static final Pattern ARCHIVE_PATTERN = Pattern.compile("archive=([^\\s]*)");
    private static final Pattern PARAMETER_PATTERN = Pattern.compile("<param name=\"([^\\s]+)\"\\s+value=\"([^>]*)\">");

    public GameCrawler(final String url) {
        this.url = url;
    }

    public void crawl() {
        /* Downloads the web pages source code */
        final String source = Utility.getWebPageSource(url);
        if (source == null) {
            throw new RuntimeException("Unable to download source for url - " + url);
        }

        /* Search the source code for parameters with regex */
        Matcher matcher = PARAMETER_PATTERN.matcher(source);
        while (matcher.find()) {
            parameters.put(matcher.group(1), matcher.group(2));
        }

        /* Search the source code for the archives url */
        matcher = ARCHIVE_PATTERN.matcher(source);
        if (matcher.find()) {
            archive = matcher.group(1);
        }

        /* Search the source code for the initial class to launch the game from */
        matcher = CLASS_PATTERN.matcher(source);
        if (matcher.find()) {
            initialClass = matcher.group(1).replace(".class", "");
        }
    }
}
