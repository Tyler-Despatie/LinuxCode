import processing.core.PApplet;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.*;

public class ProjectView extends JPanel implements java.io.Serializable
{
    public int iLRotationFactor;
    public int iGRotationFactor;
    public double dScalingFactor;

    public ProjectView()
    {
        //Own Panel Initialization
        this.setLayout(new BorderLayout());
        //Panel Contains PApplet Panel Left, Information Panel Right
        JPanel containerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        //Applet Panel
        JPanel appletPanel = new JPanel(new BorderLayout());
        final ProcessingApplet sketch = new ProcessingApplet();
        appletPanel.add(sketch, BorderLayout.CENTER);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 2;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        containerPanel.add(appletPanel, gc);
        //Information Panel
        //Top Tree List
        JPanel informationPanel = new JPanel(new GridBagLayout());
        gc.fill = GridBagConstraints.BOTH;
        gc.weighty = 2;
        gc.gridx = 0;
        gc.gridy = 0;
        informationPanel.add(new ProjectTree(), gc);
        //Sliders
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));

        final JLabel lblLocalRotation = new JLabel("Local Rotation: 0");
        lblLocalRotation.setAlignmentX(Component.CENTER_ALIGNMENT);
        JSlider localRotationSlider = new JSlider();
        localRotationSlider.setValue(0);
        localRotationSlider.setPaintTicks(true);
        localRotationSlider.setMajorTickSpacing(10);
        localRotationSlider.setMinorTickSpacing(5);
        localRotationSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                iLRotationFactor = ((JSlider)e.getSource()).getValue(); 
                lblLocalRotation.setText("Local Rotation: " + iLRotationFactor); 
            }
        });
        
        final JLabel lblScalingSlider = new JLabel("Scaling Factor: 1.0");
        lblScalingSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        JSlider scalingSlider = new JSlider(0,50);
        scalingSlider.setValue(10);
        scalingSlider.setPaintTicks(true);
        scalingSlider.setMajorTickSpacing(10);
        scalingSlider.setMinorTickSpacing(5);
        scalingSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                dScalingFactor = (((JSlider)e.getSource()).getValue()/10.0); 
                lblScalingSlider.setText("Scaling Factor: " + dScalingFactor); 
            }
        });

        final JLabel lblGlobalRotation = new JLabel("Global Rotation: 0");
        lblGlobalRotation.setAlignmentX(Component.CENTER_ALIGNMENT);
        JSlider globalRotationSlider = new JSlider(0,360);
        globalRotationSlider.setValue(0);
        globalRotationSlider.setPaintTicks(true);
        globalRotationSlider.setMajorTickSpacing(45);
        globalRotationSlider.setMinorTickSpacing(15);
        globalRotationSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                iGRotationFactor = ((JSlider)e.getSource()).getValue(); 
                lblGlobalRotation.setText("Global Rotation: " + iGRotationFactor);
                sketch.setGlobalRotation(iGRotationFactor);
            }
        });

        sliderPanel.add(lblLocalRotation);
        sliderPanel.add(localRotationSlider);
        sliderPanel.add(lblScalingSlider);
        sliderPanel.add(scalingSlider);
        sliderPanel.add(lblGlobalRotation);
        sliderPanel.add(globalRotationSlider);

        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 1;
        informationPanel.add(sliderPanel, gc ); 
        gc.weightx = .25;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.gridy = 0;
        containerPanel.add(informationPanel, gc);
        this.add(containerPanel);

        sketch.init();
        setVisible(true);
    }
}

