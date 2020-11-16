
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
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SlotMachineFrame extends JFrame{
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
        JMenuItem restart = new JMenuItem("Restart");
        JMenuItem exit = new JMenuItem("Exit");
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
