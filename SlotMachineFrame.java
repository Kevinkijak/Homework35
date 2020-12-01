
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Contains the GUI and display of all the game components put together
 */
public class SlotMachineFrame extends JFrame{
    
    private double balance = 5.00;
    private double wager = 0.0;
    
    /**
     * Constructor to initialize and set all game components
     */
    public SlotMachineFrame(){
        this.setLayout(null); 
        TilePanel panel = new TilePanel();
        this.setSize(500, 400);
        Box buttons = Box.createHorizontalBox();
        JButton max = new JButton("Max");
        JButton mid = new JButton("Mid");
        JButton min = new JButton("Min");
        JLabel label = new JLabel("$");
        JTextField money = new JTextField();
        money.setText("5.0");
        money.setEditable(false);
        max.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                wager = Double.parseDouble(money.getText());
                TileRandomizer.randomize(panel);
                if(TileChecker.check(panel) == 2){
                    wager*=100;
                    money.setText(wager+"");
                }else if(TileChecker.check(panel) == 1){
                    wager*=25;
                    money.setText(wager+"");
                }else{
                    money.setText("0.0");
                    min.setEnabled(false);
                    max.setEnabled(false);
                    mid.setEnabled(false);
                }
                
            }
            
        });
        
        mid.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                balance = Double.parseDouble(money.getText());
                wager = balance/2;
                balance-=wager;
                TileRandomizer.randomize(panel);
                if(TileChecker.check(panel) == 2){
                    wager*=50;
                    balance+=wager;
                    balance = Math.round(balance*100)/(double)100;
                    money.setText(balance+"");
                }else if(TileChecker.check(panel) == 1){
                    wager*=10;
                    balance+=wager;
                    balance = Math.round(balance*100)/(double)100;
                    money.setText(balance+"");
                }else{
                    balance = Math.round(balance*100)/(double)100;
                    if(balance == 0){
                        min.setEnabled(false);
                        max.setEnabled(false);
                        mid.setEnabled(false);
                    }
                    money.setText(balance+"");
                }
                
            }
            
        });
        
        min.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                balance = Double.parseDouble(money.getText());
                wager = balance/10;
                balance-=wager;
                TileRandomizer.randomize(panel);
                if(TileChecker.check(panel) == 2){
                    wager*=10;
                    balance+=wager;
                    balance = Math.round(balance*100)/(double)100;
                    money.setText(balance+"");
                }else if(TileChecker.check(panel) == 1){
                    wager*=5;
                    balance+=wager;
                    balance = Math.round(balance*100)/(double)100;
                    money.setText(balance+"");
                }else{
                    balance = Math.round(balance*100)/(double)100;
                    if(balance == 0){
                        min.setEnabled(false);
                        max.setEnabled(false);
                        mid.setEnabled(false);
                    }
                    money.setText(balance+"");
                }
            }
            
        });
        
        buttons.add(max);
        buttons.add(Box.createRigidArea(new Dimension(7,7)));
        buttons.add(mid);
        buttons.add(Box.createRigidArea(new Dimension(7,7)));
        buttons.add(min);
        buttons.add(Box.createRigidArea(new Dimension(7,7)));
        buttons.add(label);
        buttons.add(money);
        
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Load Tiles");
        load.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int selected = chooser.showOpenDialog(null);
                if(selected == JFileChooser.APPROVE_OPTION){
                    TilePanel newPanel = TileReader.read(chooser.getSelectedFile());
                    panel.setTiles(newPanel.getTiles());
                }
                
            }
        
        });
        JMenuItem save = new JMenuItem("Save Tiles");
        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                TileWriter.write(panel); 
            }
        });
        JMenuItem print = new JMenuItem("Print");
        print.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Tile t: panel.getTiles())
                    System.out.println(t.toString());
            }
        
        });
        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                max.setEnabled(true);
                mid.setEnabled(true);
                min.setEnabled(true);
                balance = 5.00;
                money.setText(balance+"");
            }            
        });
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(load);
        file.add(save);
        file.add(print);
        file.add(restart);
        file.add(exit);
        menubar.add(file);
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Kevin Kijak, https://github.com/Kevinkijak/Kijak_Kevin_cpsc24500");
            }
        });
        help.add(about);
        menubar.add(help);
        
        this.setJMenuBar(menubar);
        panel.setBounds(10, 10, 470, 470);
        this.add(panel);
        buttons.setBounds(10, 200, 470, 30);
        this.add(buttons);
        buttons.repaint();
        this.setVisible(false);
        this.setVisible(true);
        this.revalidate();
        this.setSize(500, 300);
        repaint();
    }

}
