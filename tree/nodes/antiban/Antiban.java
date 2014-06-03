package scripts.tree.nodes.antiban;


import org.tribot.api.General;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSPlayer;
import org.tribot.script.Script;
import scripts.tree.nodes.Node;
import scripts.utils.tabs.Tabs;

import java.awt.*;

public class Antiban extends Node{
    private int chooseAntiBan, chooseTab;
    private GameTab.TABS[] tabsArray = {GameTab.TABS.STATS, GameTab.TABS.INVENTORY, GameTab.TABS.FRIENDS, GameTab.TABS.MUSIC, GameTab.TABS.EMOTES, GameTab.TABS.IGNORE};
    private RSPlayer[] players;
    private Tabs tabs;
    private RSPlayer player;
    private Point randomMousePoint;
    private int antiBanRange, antiBanHit;


    public Antiban(Script script, int antiBanRange, int antiBanHit) {
        super(script);
        tabs = new Tabs(this.script);
        this.antiBanHit = antiBanHit;
        this.antiBanRange = antiBanRange;
    }

    @Override
    public boolean activate() throws InterruptedException {
        return ((General.random(0,antiBanRange) == antiBanHit) && !Banking.isBankScreenOpen() && !Player.isMoving());
    }

    @Override
    public void execute() throws InterruptedException {
        chooseAntiBan = General.random(0,5);
        switch(chooseAntiBan){
            case 0:
                script.println("(Antiban) Opening up a random tab.");
                tabs.openRandomTab(tabsArray);
                break;
            case 1://added twice to increase frequency relative to other antiban (helps prevent logging out when idle for long periods of time)
                script.println("(Antiban) Opening up a random tab.");
                tabs.openRandomTab(tabsArray);
                break;
            case 2:
                script.println("(Antiban) Rotating camera.");
                Camera.setCameraAngle(General.random(60,100));
                Camera.setCameraRotation(Camera.getCameraRotation() + General.random(8,22));
                break;
            case 3:
                hoverOverPlayer();
                break;
            case 4:
                randomMousePoint = new Point(General.random(10, 750), General.random(10, 490));
                script.println("(Antiban) Moving mouse to random position. (x = "+randomMousePoint.getX()+") (y = "+randomMousePoint.getY()+")");
                Mouse.move(randomMousePoint);
            case 5:
                script.println("(Antiban) Moving mouse off of the screen.");
                Mouse.leaveGame(true);
            default:
                break;
        }
    }


    private void hoverOverPlayer(){
        players = Players.getAll();
        if(players.length > 1){
            players = Players.sortByDistance(Player.getPosition(), players);
            player = players[1];
            if(player != null){
                if(player.isOnScreen() && !player.getName().equals(Player.getRSPlayer().getName())){
                    script.println("(Antiban) Hovering over "+player.getName());
                    player.hover();
                }
            }
        }
    }
}
