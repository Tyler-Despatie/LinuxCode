import javax.swing.JFrame;
import javax.swing.JPanel;

public class Project {
    
    public static void main (String [] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setTitle("Project 1 - Computer Graphics");
                frame.setSize(850,625);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.setContentPane(new ProjectView());
                frame.setVisible(true);
            }
        });
    }
}

