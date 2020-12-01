
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TilePanel extends JPanel implements Serializable{
    private Tile tiles[];
    
    /**
     * Constructor to initialize Tile panel variables
     */
    public TilePanel(){
        this.setLayout(null);
        tiles = new Tile[4];
        this.setSize(700, 320);
        int x = 10,y = 20;
        for(int i = 0; i < 4; i++){
            Tile tile = new Tile();
            tile.setBounds(x, y, 100, 100);
            x+=110;
            tiles[i] = tile;
            tiles[i].addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    tile.setRandomly();
                    tile.repaint();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
            this.add(tiles[i]);
            tiles[i].repaint();
        }
        JPanel p = new JPanel();
        p.setBackground(Color.red);
        p.setOpaque(true);
        p.setSize(200,200);
    }
    
    /**
     * Return the Tile array of this panel
     */
    public Tile[] getTiles(){
        return tiles;
    }
    
    /**
     * Set the tiles of this panel to the provided set
     */
    public void setTiles(Tile[] tiles){
        for(int i = 0; i < tiles.length; i++){
            this.tiles[i].setShape(tiles[i].getShape());
            this.tiles[i].setColor(tiles[i].getColor());
        }
        this.repaint();
        for(Tile t: tiles) t.repaint();
        
    }
    
    /**
     * Randomly reset all the tile variables
     */
    public void randomize(){
        for(Tile t: tiles)
            t.setRandomly();
    }
}
