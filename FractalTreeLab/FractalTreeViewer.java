import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.geom.Point2D;
/**
 * Write a description of class FractalTreeViewer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FractalTreeViewer extends JFrame
{
    FractalTreePanel canvas;
    
    public FractalTreeViewer()
    {
        this.setTitle("Fractal Tree Viewer");
        
        this.setLayout(new BorderLayout());
        this.setSize(1000,500);
        this.canvas = new FractalTreePanel();
        this.add(this.canvas, BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    public static void main( String[] args)
    {
        FractalTreeViewer tree = new FractalTreeViewer();
    }
}
