import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Grid extends JFrame 
{
    JPanel contentPane;
    JLabel imageLabel = new JLabel();
     

    public Grid() 
    {
        try 
        {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            setSize(new Dimension(1440, 900));
            setTitle("Helicopter");

            // add the image label
            ImageIcon ii = new ImageIcon(this.getClass().getResource(
                    "blackhawk.gif"));
            imageLabel.setIcon(ii);
            contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
            // show it
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        } 
        catch (Exception exception) 
        {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) 
    {
        new Grid();
    }
}
