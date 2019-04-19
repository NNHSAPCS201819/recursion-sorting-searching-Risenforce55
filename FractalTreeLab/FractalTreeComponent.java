import java.util.ArrayList;
import javax.swing.JComponent;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.lang.Math.*;

/**
 * Write a description of class FractalTreeComponent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FractalTreeComponent extends JComponent
{
    private double degLeft, degRight;
    private double angle;
    private double segLength;
    private double scale;
    private Point2D.Double origin;
    
    public FractalTreeComponent(double degLeft, double degRight, double angle, double segLength, double scale, Point2D.Double origin)
    {
        this.degLeft = degLeft;
        this.degRight = degRight;
        this.angle = angle;
        this.segLength = segLength;
        this.scale = scale;
        this.origin = origin;
    }
    
    public void paintComponent(Graphics2D g)
    {
        Point2D.Double end = new Point2D.Double(origin.getX() + segLength * Math.cos(angle),origin.getY() + segLength * Math.sin(angle));
        FractalTreeComponent leftBranch = new FractalTreeComponent(degLeft, degRight, angle + degLeft, segLength/scale, scale, end);
        FractalTreeComponent rightBranch = new FractalTreeComponent(degLeft, degRight, angle - degRight, segLength/scale, scale, end);
        
        if(segLength > 1)
        {
            leftBranch.paintComponent(g);
            rightBranch.paintComponent(g);
        }
        
        g.drawLine((int) this.origin.getX(), (int) this.origin.getY(), (int) end.getX(), (int) end.getY());
    }
}
