package scripts.utils.walking;

import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;
import org.tribot.script.Script;


public class Walk {
    private RSTile randomTile;
    private float distanceToTile;
    private Script script;

    public Walk(Script script){
        this.script = script;
    }

    public void walkToArea(RSArea area){
        WebWalking.walkTo(area.getRandomTile());
        script.sleep(1200,1400);
    }

    public boolean walkToTile(RSTile tile){
        if(!WebWalking.walkTo(tile));{
            return false;
        }
    }

    public float getDistanceToTile(RSTile tile){
        distanceToTile = (float) Math.sqrt(Math.pow((tile.getX() - Player.getPosition().getX()), 2) + Math.pow((tile.getY() - Player.getPosition().getY()), 2));
        return distanceToTile;
    }



}
