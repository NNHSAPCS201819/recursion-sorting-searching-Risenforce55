import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.lang.Math.*;

/**
 * Write a description of class FractalTreePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FractalTreePanel extends JPanel
{
    private double degLeft, degRight;
    private double x,y;
    private double size;
    private double numBranches;
    private static final int WIDTH = 1200, HEIGHT = 600;
    private Color branchColor;
    
    public FractalTreePanel()
    {
        this.degLeft = Math.PI/3;
        this.degRight = Math.PI/3;
        this.x = WIDTH * (2/3);
        this.y = HEIGHT * (2/3);
        this.size = HEIGHT * (1/2);
        this.numBranches = 24;
        this.setBackground(Color.black);
        this.branchColor = Color.orange.brighter();
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH, HEIGHT);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(branchColor);
        FractalTreeComponent component = new FractalTreeComponent(degLeft, degRight, Math.PI/2, size, numBranches,
            new Point2D.Double(x,y));
        component.paintComponent(g2);
    }
}
