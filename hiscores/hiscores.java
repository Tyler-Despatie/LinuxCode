import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class hiscores {
    
    public static final String url = "http://services.runescape.com/m=hiscore_oldschool/hiscorepersonal.ws?user1=";
    public static final String skill = "(.*)skill_icon_(\\w+)1.gif(.*)";
    public static final String level = "right\">(\\d\\d|\\d)</td>";

    public static void main(String[] args) throws Exception {
        final URL his = new URL(url+args[0]);
        final BufferedReader in = new BufferedReader(new InputStreamReader(his.openStream()));

        String inputLine;
        int iTotalLevel  = 0;
        Pattern pattern  = Pattern.compile(level);
        Pattern pattern2 = Pattern.compile(skill);

        while ((inputLine = in.readLine()) != null) {
            final Matcher matcher  = pattern.matcher(inputLine);
            final Matcher matcher2 = pattern2.matcher(inputLine);

            while (matcher2.find())
                System.out.print("\n" + matcher2.group(2).trim() + ": ");
            while (matcher.find()) {
                if (matcher.group(1).trim().compareTo("0") != 0)
                    System.out.print(matcher.group(1).trim());
                iTotalLevel += Integer.parseInt(matcher.group(1).trim());
            }
        }
        in.close();
        System.out.print("\n\nPlayer Name: " + args[0]);
        System.out.println("\nTotal Level: " + iTotalLevel);
    }
}
