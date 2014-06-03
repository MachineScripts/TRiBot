package scripts.tree.nodes.woodcutter;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.script.Script;
import scripts.tree.nodes.Node;
import scripts.utils.chop.Chop;


public class ChopTree extends Node{
    private String treeName;
    private RSArea treeArea;
    private Chop chop;

    public ChopTree(Script script, String treeName, RSArea treeArea) {
        super(script);
        this.script = script;
        this.treeName = treeName;
        this.treeArea = treeArea;
        chop = new Chop(script, treeName, treeArea);
    }

    @Override
    public boolean activate() throws InterruptedException {
        return (!Inventory.isFull() && treeArea.contains(Player.getPosition()));
    }

    @Override
    public void execute() throws InterruptedException {
        chop.avoidEnt();
        chop.pickUpNest();
        chop.chopTree();
    }
}
