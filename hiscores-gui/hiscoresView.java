import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;

public class hiscoresView extends JPanel implements java.io.Serializable{
   
    public static final long serialVersionUID = 42L;
    public ArrayList<String> arrSkill = new ArrayList<String>();
    public ArrayList<String> arrLevel = new ArrayList<String>();

    public static void main(String[] args) {}

    public hiscoresView(String name) throws Exception {
        final String url         = "http://services.runescape.com/m=hiscore_oldschool/hiscorepersonal.ws?user1=" + name;
        final String skill       = "(.*)skill_icon_(\\w+)1.gif(.*)";
        final String level       = "right\">(\\d\\d|\\d)</td>";
        final URL his            = new URL(url);
        final BufferedReader in  = new BufferedReader(new InputStreamReader(his.openStream()));
         
        String inputLine;
        int iTotalLevel  = 0;
        Pattern pattern  = Pattern.compile(level);
        Pattern pattern2 = Pattern.compile(skill);

        while ((inputLine = in.readLine()) != null) {
            final Matcher matcher  = pattern.matcher(inputLine);
            final Matcher matcher2 = pattern2.matcher(inputLine);

            while (matcher2.find())
                arrSkill.add(matcher2.group(2).trim());

            while (matcher.find()) 
                if (matcher.group(1).trim().compareTo("0") != 0) {
                    arrLevel.add(matcher.group(1).trim());
                    iTotalLevel += Integer.parseInt(matcher.group(1).trim());
                }
        }
        in.close();

        int i = 0;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("Player Name: " + name));
        for (String str : arrSkill) { 
            arrSkill.set(i, Character.toUpperCase(str.charAt(0)) + str.substring(1));
            this.add(new JLabel(arrSkill.get(i) + " " + arrLevel.get(i++)));
        }
        this.add(new JLabel("Total Level: " + iTotalLevel)); 
        setVisible(true);
    }
}
