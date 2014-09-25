import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class hiscores {
    
    public static void main (String [] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setTitle("Hiscores");
                frame.setSize(190,440);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                try {
                    frame.setContentPane(new hiscoresView(JOptionPane.showInputDialog(null, "Enter player name: ")));
                } catch (Exception e) {}
                frame.setVisible(true);
            }
        });
    }
}

