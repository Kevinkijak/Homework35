
import javax.swing.JFrame;

/**
 * Driver class that starts the game
 */
public class SlotMachineApp{
    public static void main(String[] args) {
        SlotMachineFrame machine = new SlotMachineFrame();
        
        machine.setVisible(true);
        
        machine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
