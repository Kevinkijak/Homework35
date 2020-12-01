
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;

/**
 * Reads a tile panel's information from a file 
 */
public class TileReader {

    /**
     * Method to take in a file name and read the panel information
     */
    public static TilePanel read(File file)
    {
        TilePanel app = null;
        try {
            ObjectInputStream str = new ObjectInputStream(new FileInputStream(file));
            app = (TilePanel) str.readObject();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "File doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return app;
    }
}
