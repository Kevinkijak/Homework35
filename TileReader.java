
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class TileReader {
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
