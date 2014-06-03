package scripts.utils.chop;

import org.tribot.api.General;
import org.tribot.api2007.*;
import org.tribot.api2007.types.*;
import org.tribot.script.Script;


public class Chop {
    private Script script;
    private RSObject[] treeArray;
    private String treeName;
    private RSNPC[] closeNpcs;
    private RSArea treeArea;
    private RSGroundItem[] birdNest;
    private RSGroundItem nest;
    private RSObject closestTree;
    private RSPlayer player;
    private RSTile playerTile;
    private RSCharacter ent;

    public Chop(Script script, String treeName, RSArea treeArea){
        this.script = script;
        this.treeName = treeName;
        this.treeArea = treeArea;
    }

    private RSObject getClosestTree(){
        treeArray = Objects.findNearest(10,treeName);
        if(treeArray.length > 0)
            return treeArray[0];
        return null;
    }

    public void avoidEnt(){
        closeNpcs = NPCs.findNearest(treeName);
        player = Player.getRSPlayer();
        if(player != null){
            if(closeNpcs.length > 0){
                for(RSNPC npc : closeNpcs){
                    if(npc.getName().equalsIgnoreCase(treeName)){
                        ent = player.getInteractingCharacter();
                        if(ent != null){
                            if(ent.getName().equals(treeName)){
                                if(player.getAnimation() != -1 && !Player.isMoving()){
                                    playerTile = Player.getPosition();
                                    script.println("ENT detected, avoiding the ENT!");
                                    Walking.clickTileMM((new RSTile(playerTile.getX()+ General.random(2, 3), playerTile.getY() + General.random(2,3))), 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void pickUpNest(){
        birdNest = GroundItems.find("Bird nest");
        if(birdNest.length > 0){
            nest = birdNest[0];
            if(nest != null && !Player.isMoving()){
                if(nest.isOnScreen()){
                    script.println("Bird nest detected, picking it up!");
                    nest.click("Take");
                    script.sleep(500,600);
                }
                else{
                    WebWalking.walkTo(nest.getPosition());
                    script.sleep(400,500);
                }
            }
        }
    }

    public void chopTree(){
        player = Player.getRSPlayer();
        if(player != null && treeArea != null){
            if(treeArea.contains(player.getPosition())){
                closestTree = getClosestTree();
                if(closestTree != null){
                    if(!Player.isMoving() && Player.getAnimation() == -1){
                        if(closestTree.isOnScreen()){
                            closestTree.click("Chop down");
                            script.sleep(200,300);
                        }
                        else{
                            Walking.walkTo(closestTree.getPosition());
                            script.sleep(700,800);
                            Camera.turnToTile(closestTree.getPosition());
                        }
                    }
                }
            }
        }
    }

}
