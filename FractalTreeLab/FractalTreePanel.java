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
    private static final int WIDTH = 1400, HEIGHT = 1200;
    private int r,g,b = 0;
    
    public FractalTreePanel()
    {
        this.degLeft = Math.PI/6;
        this.degRight = Math.PI/6;
        this.x = WIDTH / 2;
        this.y = 13* HEIGHT / 20;
        this.size = 3 * HEIGHT / 13;
        this.numBranches = 24;
        this.setBackground(Color.black);
        this.r = 50;
        this.g = 220;
        this.b = 255;
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH, HEIGHT);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.MAGENTA);
        FractalTreeComponent component = new FractalTreeComponent(degLeft, degRight, -  Math.PI/2, size, (double) 3/2,
            new Point2D.Double(x,y), new Color(this.r,this.g,this.b));
        component.paintComponent(g2);
    }
}
