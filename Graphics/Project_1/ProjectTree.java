import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.awt.BorderLayout;

public class ProjectTree extends JPanel 
{
    private JTree tree;
    private DefaultMutableTreeNode[] arrPlatoons = new DefaultMutableTreeNode[4]; 
    private DefaultMutableTreeNode[] arrSoldiers = new DefaultMutableTreeNode[4];

    public ProjectTree()
    {
        this.setLayout(new BorderLayout());
        //create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Platoons");
        //create the child nodes
        for (int i=0; i<4;i++) {
            arrPlatoons[i] = new DefaultMutableTreeNode("Platoon" + i); 
            for (int i2=0; i2<4;i2++) {
                arrSoldiers[i2] = new DefaultMutableTreeNode("Soldier " + i2);
                arrPlatoons[i].add(arrSoldiers[i2]);
            }
            root.add(arrPlatoons[i]);
        }
         
        //create the tree by passing in the root node
        tree = new JTree(root);
        add(tree);

    tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
    	@Override
    	public void valueChanged(TreeSelectionEvent e) {
        	DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        	System.out.println(selectedNode.getUserObject().toString());
    	}
    });
    }

}
