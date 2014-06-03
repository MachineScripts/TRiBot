package scripts.tree.nodes.cooker;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSArea;
import org.tribot.script.Script;
import scripts.tree.nodes.Node;


public class WalkToRange extends Node{
    private String foodName;
    private RSArea rangeArea;

    public WalkToRange(Script script, RSArea rangeArea, String foodName) {
        super(script);
        this.rangeArea = rangeArea;
        this.foodName = foodName;
    }

    @Override
    public boolean activate() throws InterruptedException {
        return (!rangeArea.contains(Player.getPosition()) && Inventory.getCount(foodName) > 0);
    }

    @Override
    public void execute() throws InterruptedException {
        if(!Player.isMoving())
            WebWalking.walkTo(rangeArea.getRandomTile());
    }
}
