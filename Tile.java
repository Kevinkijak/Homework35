
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Hold the information of one tile 
 * and manages it's changes and display
 * @author 
 */
public class Tile extends JPanel {

    private String shape;
    private String color;

    /**
     * Constructor to initialize Tile variables
     */
    public Tile() {
        this.setSize(300, 300);
        this.setBackground(Color.MAGENTA);
        this.setOpaque(false);
        setRandomly();
    }

    /**
     * Constructor with initial parameters provided
     * @param shape
     * @param color
     */
    public Tile(String shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    /**
     * Return the shape of this tile
     * @return
     */
    public String getShape() {
        return shape;
    }

    /**
     * Set the shape of this tile
     * @param shape
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Return the color of this tile
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the color of this tile
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Randomly set the values of this tile
     */
    public void setRandomly() {
        Random rand = new Random();
        shape = "circle";
        if (rand.nextInt(10) > 5) {
            shape = "square";
        }
        color = "#ff0000";
        int r = rand.nextInt(100);
        if (r > 80) {
            color = "#ffff00";
        } else if (r > 60) {
            color = "#00ff00";
        } else if (r > 40) {
            color = "#ffa500";
        } else if (r > 20) {
            color = "#0000ff";
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.decode(getColor()));
        Shape shape = null;
        if (getShape().equalsIgnoreCase("square")) {
            shape = new Rectangle(0, 0, 100, 100);
        } else {
            shape = new Ellipse2D.Double(0, 0, 100, 100);
        }  
        g2.fill(shape);
    }

    @Override
    public String toString() {
        return shape + " " + color;
    }
}
