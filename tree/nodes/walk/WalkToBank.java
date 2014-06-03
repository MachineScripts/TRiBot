package scripts.tree.nodes.walk;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;
import org.tribot.script.Script;
import scripts.tree.nodes.Node;


public class WalkToBank extends Node{
    private RSArea bankArea;
    private String itemName;
    private RSTile randomTile;

    public WalkToBank(Script script, RSArea bankArea, String itemName) {
        super(script);
        this.itemName = itemName;
        this.bankArea = bankArea;
    }

    @Override
    public boolean activate() throws InterruptedException {
        return (!bankArea.contains(Player.getPosition()) && Inventory.getCount(itemName) == 0);
    }

    @Override
    public void execute() throws InterruptedException {
        randomTile = bankArea.getRandomTile();
        if(!Player.isMoving())
            WebWalking.walkTo(randomTile.getPosition());
    }
}
