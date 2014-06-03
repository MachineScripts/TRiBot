package scripts.tree.nodes.cook;

import org.tribot.api2007.Banking;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.script.Script;
import scripts.tree.nodes.Node;
import scripts.utils.cooking.Cooking;


public class Cook extends Node{
    private Cooking cooking;
    private String foodName, cookerName;
    private RSArea cookerArea;

    public Cook(Script script, String foodName, String cookerName, RSArea cookerArea) {
        super(script);
        cooking = new Cooking(this.script);
        this.foodName = foodName;
        this.cookerName = cookerName;
        this.cookerArea = cookerArea;
    }

    @Override
    public boolean activate() throws InterruptedException {
        return (Interfaces.get(307) == null && cookerArea.contains(Player.getPosition()) && Player.getAnimation() == -1 && !Player.isMoving() && Inventory.getCount(foodName) > 0);
    }

    @Override
    public void execute() throws InterruptedException {
        if(Banking.isBankScreenOpen()){
            Banking.close();
        }
        else{
            cooking.cookFood(this.cookerName, this.foodName);
        }
        script.sleep(300,350);
    }
}
