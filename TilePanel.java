
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
    
    public TilePanel(){
//        this.setBackground(Color.CYAN);
//        this.setOpaque(true);
        this.setLayout(null);
        tiles = new Tile[4];
        this.setSize(700, 320);
        Box panel = Box.createHorizontalBox();
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
//            panel.add(new JLabel("Yoh"));
            //panel.add(Box.createRigidArea(new Dimension(10,10)));
        }
        //this.add(panel);
//        this.repaint();
        JPanel p = new JPanel();
        p.setBackground(Color.red);
        p.setOpaque(true);
        p.setSize(200,200);
        //this.add(p);
    }
    
    public Tile[] getTiles(){
        return tiles;
    }
    
    public void setTiles(Tile[] tiles){
        this.tiles = tiles;
        this.repaint();
        for(Tile t: tiles) t.repaint();
        
    }
}
