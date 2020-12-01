
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class TileWriter {

    /**
     * Static machine to write the TilePanel to a file
     */
    public static void write(TilePanel app){
        try {
            File file = new File("slotMachine.bin");
            ObjectOutputStream str = new ObjectOutputStream(new FileOutputStream(file, false));
            str.writeObject(app);
            str.close();
            JOptionPane.showMessageDialog(null, "Tile Panels Saved!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error writing to file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
