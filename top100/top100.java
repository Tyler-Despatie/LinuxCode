import java.net.URL;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class top100 {

    public static final String SimpleString = "torrent/.+>([\\w\\s\'\\-\\.]+)";
    public static final String LongString = "torrent/.+>(.+)</a>";
    public static final String LinkNumber = "href=\"(magnet:?.+)\" ";

    public static void main(String[] args) throws Exception {
        final File file = new File("last100.txt");
        final URL tpb = new URL("http://www.thepiratebay.se/top/207");
        final BufferedReader streamIn = new BufferedReader(new InputStreamReader(tpb.openStream()));

        int i = 1;
        String inputLine;
        String compareLine;
        boolean bCompare = false;
        boolean bUpdate  = false;
        boolean bReplace = true;
        Pattern pattern = Pattern.compile(SimpleString) ;

        try {
            switch(args[0]) {
                case "-c":
                    bCompare = true;
                    break;
                case "-cl":
                    bCompare = true;
                case "-l":
                    pattern = Pattern.compile(LongString); 
                    break;
                case "-m":
                    pattern = Pattern.compile(LinkNumber);
                    break;
                case "-ul":
                    pattern = Pattern.compile(LongString); 
                case "-u":
                    bUpdate = true;
                    bCompare = true;
                    if (file.exists()) 
                        file.delete();
                    file.createNewFile();
                default:
                    break;
            }

            if (args[0].contains("l") || args[0].contains("m")) 
                bReplace = false;

        } catch (Exception ex) { }

        final BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));
        final BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
       
        while ((inputLine = streamIn.readLine()) != null) {
            final Matcher matcher = pattern.matcher(inputLine);
            while (matcher.find()) {
                if (bReplace) 
                    inputLine = (i++ + ". " + matcher.group(1).trim().replaceAll("\\."," "));  
                else 
                    inputLine = (i++ + ". " + matcher.group(1).trim());

                if (bCompare) {
                    if (bUpdate) 
                       out.write(inputLine + '\n');
                    try {
                        if (inputLine.compareTo(in.readLine()) != 0)
                            System.out.println(inputLine);
                    } catch (Exception ex) { }
                } else 
                    System.out.println(inputLine);
            }
        }
        in.close();
        out.close();
        streamIn.close();
    }
}
