//Author: Tyler
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class top100 {

    public static final String SimpleString = "torrent/.+>([\\w\\s\'\\-\\.]+)";
    public static final String LongString = "torrent/.+>(.+)</a>";
    public static final String LinkNumber = "href=\"(magnet:?.+)\" ";

    public static void main(String[] args) throws Exception {
        final URL tpb = new URL("http://www.thepiratebay.se/top/207");
        final BufferedReader in = new BufferedReader(new InputStreamReader(tpb.openStream()));

        String inputLine;
        Pattern pattern = Pattern.compile(SimpleString) ;

        try {
            switch(args[0]) {
                case "-l":
                    pattern = Pattern.compile(LongString); 
                    break;
                case "-m":
                    pattern = Pattern.compile(LinkNumber);
                default:
                    break;
            }
        } catch (Exception ex) { }
       
        int i = 1;
        while ((inputLine = in.readLine()) != null) {
            final Matcher matcher = pattern.matcher(inputLine);
            while (matcher.find()) {
                if (args.length == 0) 
                    System.out.println(i++ + ". " + matcher.group(1).trim().replaceAll("\\."," "));   
                else 
                    System.out.println(i++ + ". " + matcher.group(1).trim());
            }
        }
        in.close();
    }
}
