


public class TileChecker {

    /**
     * Check the given tiles if the player has won any
     */
    public static int check(TilePanel panel){
        int ret = 0;
        Tile[] tiles = panel.getTiles();
        if(tiles[0].getShape().equalsIgnoreCase(tiles[1].getShape()) && tiles[1].getShape().equalsIgnoreCase(tiles[2].getShape()) && tiles[3].getShape().equalsIgnoreCase(tiles[2].getShape()))
            ret+=1;
        if(tiles[0].getColor().equalsIgnoreCase(tiles[1].getColor()) && tiles[1].getColor().equalsIgnoreCase(tiles[2].getColor()) && tiles[3].getColor().equalsIgnoreCase(tiles[2].getColor()))
            ret+=1;
        
        return ret;
    }
}
