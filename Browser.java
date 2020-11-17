import java.awt.Desktop;
import java.awt.desktop.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static void main(String[] args) {

        String ICON_url = "https://icon.uiowa.edu";
        String outlook_url = "https://outlook.live.com/owa/";
        String first_reddit_url = "https://www.reddit.com/r/Jaguars/";
        String second_reddit_url = "https://www.reddit.com/r/uiowa/";
        String third_reddit_url = "https://www.reddit.com/r/javahelp/";
        String weather_url = "https://www.accuweather.com/en/us/minooka/60447/weather-forecast/2241505";
        String scitechdaily_url = "https://scitechdaily.com";

        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(ICON_url));
                TimeUnit.SECONDS.sleep(2);
                desktop.browse(new URI(outlook_url));
                TimeUnit.SECONDS.sleep(2);
                desktop.browse(new URI(first_reddit_url));
                TimeUnit.SECONDS.sleep(2);
                desktop.browse(new URI(second_reddit_url));
                TimeUnit.SECONDS.sleep(2);
                desktop.browse(new URI(third_reddit_url));
                TimeUnit.SECONDS.sleep(2);
                desktop.browse(new URI(weather_url));
                TimeUnit.SECONDS.sleep(2);
                desktop.browse(new URI(scitechdaily_url));
                TimeUnit.SECONDS.sleep(2);
                
            } catch (IOException | InterruptedException | URISyntaxException e) {
                e.printStackTrace();
            } 
        }
    }
}