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
    private Color branchColor;
    private int r,g,b;
    public FractalTreeComponent(double degLeft, double degRight, double angle, double segLength, double scale, 
        Point2D.Double origin, Color branchColor)
    {
        this.degLeft = degLeft;
        this.degRight = degRight;
        this.angle = angle;
        this.segLength = segLength;
        this.scale = scale;
        this.origin = origin;
        this.branchColor = branchColor;
        this.r = branchColor.getRed();
        this.g = branchColor.getGreen();
        this.b = branchColor.getBlue();
    }
    
    public void paintComponent(Graphics2D g)
    {
        Point2D.Double end = new Point2D.Double(origin.getX() + segLength * Math.cos(angle),origin.getY() + segLength * Math.sin(angle));
        g.setColor(this.branchColor);
        g.drawLine((int) origin.getX(), (int) origin.getY(), (int) end.getX(), (int) end.getY());
        Color newColor = new Color(this.r + 10, this.g - 10, this.b - 10);
        
        FractalTreeComponent leftBranch = new FractalTreeComponent(degLeft, degRight, angle + degLeft, segLength/scale, scale, 
            end, newColor);
        FractalTreeComponent rightBranch = new FractalTreeComponent(degLeft, degRight, angle - 2 * degRight, segLength/scale, scale, 
            end, newColor);
        
        if(segLength > 1)
        {
            leftBranch.paintComponent(g);
            rightBranch.paintComponent(g);
        }
    }
}
