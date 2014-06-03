package scripts.utils.cooking;


import org.tribot.api.General;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSObject;
import org.tribot.script.Script;
import scripts.utils.inven.Inven;
import scripts.utils.player.MyPlayer;


public class Cooking {
    private RSObject[] cookerArray;
    private RSObject cooker;
    private Inven inven = new Inven();
    private Script script;

    public Cooking(Script script){
        this.script = script;
    }

    public void cookFood(String cookerName, String foodName){
        cookerArray = Objects.findNearest(5 , cookerName);

        if(cookerArray.length > 0){
            cooker = cookerArray[0];
        }

        if(Interfaces.get(307) == null){
            if(GameTab.TABS.INVENTORY.isOpen()){
                if(cooker != null && !Player.isMoving()){
                    if(Camera.getCameraAngle() < 60){
                        Camera.setCameraAngle(General.random(60, 100));
                    }
                    else if(MyPlayer.getTimeSinceLastAnimation() > 2500){//only execute this if your player hasnt animated for over 2.5 seconds
                        //this prevents from using food on a range/fire between cooking animations
                        inven.useItemOn(foodName, "Use " + foodName + " -> "+ cookerName, cooker);
                        script.sleep(300,400);
                    }
                }
            }
            else{
                Inventory.open();
            }
        }
    }

}
