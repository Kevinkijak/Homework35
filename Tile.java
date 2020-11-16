
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JPanel;

public class Tile extends JPanel {

    private String shape;
    private String color;

    public Tile() {
        this.setSize(300, 300);
        this.setBackground(Color.MAGENTA);
        this.setOpaque(false);
        setRandomly();
    }

    public Tile(String shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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
    }

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

    public String toString() {
        return shape + " " + color;
    }
}
