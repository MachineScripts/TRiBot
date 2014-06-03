package scripts;

import org.tribot.api.General;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.Player;
import org.tribot.api2007.Skills;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.MessageListening07;
import org.tribot.script.interfaces.Painting;
import scripts.guis.CookerGui;
import scripts.guis.events.ChooseCooker;
import scripts.tree.Tree;
import scripts.tree.nodes.Node;
import scripts.tree.nodes.antiban.Antiban;
import scripts.tree.nodes.bank.DepositAll;
import scripts.tree.nodes.bank.Withdraw;
import scripts.tree.nodes.cook.Cook;
import scripts.tree.nodes.cooker.WalkToRange;
import scripts.tree.nodes.widget.HandleWidget;
import scripts.utils.image.Getter;
import scripts.utils.player.MyPlayer;
import scripts.utils.rsgame.RSGame;
import scripts.utils.timer.RunTime;

import java.awt.*;

@ScriptManifest(authors = {"The Machine"}, name = "Machine Cooker", category = "Cooking", version = 1.0)
public class MachineCooker extends Script implements Painting, MessageListening07{
    private boolean runScript = true, showPaint = true;
    public static CookerGui gui;
    private Tree tree;
    private Getter getter = new Getter();
    private Image backGround;
    private RunTime runTime;
    private int thingsCooked, thingsBurned, startExp, startLevel;
    private ChooseCooker chooseCooker;
    private RSGame rsGame = new RSGame();
    private int antiBanRange, antiBanHit, amountToWithdraw;

    @Override
    public void run() {
        runTime = new RunTime(0);
        gui = new CookerGui();
        backGround = getter.getImageFromURL("http://i58.tinypic.com/2q2miwo.png");
        tree = new Tree();
        startLevel = Skills.SKILLS.COOKING.getActualLevel();
        startExp = Skills.SKILLS.COOKING.getXP();
        chooseCooker = new ChooseCooker();

        while(gui.isShowGui()){
            sleep(100);
        }
        gui.dispose();

        antiBanRange = General.random(120, 450);//generates a random int to be used for antiban, making antiban frequency unique to each script startup
        antiBanHit = General.random(0, antiBanRange-1);//this is the number used to initiate the antiban, also random to each startup
        amountToWithdraw = General.random(40, 2000);

        println("Antiban range is up to: "+antiBanRange+". Antiban will execute on: "+antiBanHit+". This is unique to each script startup.");
        println("We will withdraw "+amountToWithdraw+" "+gui.getFoodName()+". This is also a random amount on each script startup.");

        tree.addTasks(new Node[] {new Antiban(this, antiBanRange, antiBanHit),
                new scripts.tree.nodes.walk.WalkToBank(this, chooseCooker.getAreaChoice(gui.getLocationName()).getBankArea(), gui.getFoodName()),
                new WalkToRange(this, chooseCooker.getAreaChoice(gui.getLocationName()).getCookerArea(), gui.getFoodName()),
                new HandleWidget(this, 307, 2, "Cook All"),
                new Cook(this, gui.getFoodName(), chooseCooker.getAreaChoice(gui.getLocationName()).
                getCookerName(), chooseCooker.getAreaChoice(gui.getLocationName()).getCookerArea()),
                new DepositAll(this, gui.getFoodName(), chooseCooker.getAreaChoice(gui.getLocationName()).getBankArea()),
                new Withdraw(this, gui.getFoodName(), chooseCooker.getAreaChoice(gui.getLocationName()).getBankArea(), amountToWithdraw)});
        println("You have selected to cook "+gui.getFoodName());

        while(runScript){
            MyPlayer.checkAnimation();//update the time since last animation.
            if(thingsBurned+thingsCooked == gui.getAmountToCook()){//this is the check to stop the script when amountToCook is reached
                println("We have cooked "+gui.getAmountToCook()+" "+ gui.getFoodName()+". Stopping the script.");
                runScript = false;
            }
            if(!rsGame.noItemIsSelected()){//this statement will ensure that there are no errors where the wrong item is selected and the script tries to click something
                if(!rsGame.getSelectedItemName().equals(gui.getFoodName()) && Player.getAnimation() == -1){
                    println("The wrong item is selected, deselecting the item now.");
                    Mouse.clickBox(12, 350, 480, 460, 1);
                }
            }

            tree.executeTasks();
            sleep(100, 120);
        }

        println("Cooked "+thingsCooked+" "+gui.getFoodName() + ".");
        println("Burned "+thingsBurned+" "+gui.getFoodName() + ".");
        println("Gained "+(Skills.SKILLS.COOKING.getXP()-startExp)+ " exp.");
        println("Gained "+(Skills.SKILLS.COOKING.getCurrentLevel()-startLevel) +" levels.");
        println("Thanks for using Machine Cooker!");

    }

    @Override
    public void onPaint(Graphics graphics) {

        if(showPaint){
            graphics.drawImage(backGround, 1, 300, null);
            graphics.setColor(new Color(255, 255, 255));
            graphics.setFont(new Font("Myriad Web Pro", Font.PLAIN, 12));
            graphics.drawString("Elapsed Time: " + runTime.gethours() + " hour (s)  "
                    + runTime.getminutes() + " minute (s)  " + runTime.getseconds()+ " second (s)  ", 50, 385);
            graphics.drawString("Things cooked: "+(thingsCooked), 50,459);
            graphics.drawString("(Per hour): "+ runTime.getPerHour(thingsCooked), 169, 459);
            graphics.drawString("Things burned: "+(thingsBurned), 265,459);
            graphics.drawString("(Per hour): "+ runTime.getPerHour(thingsBurned), 386, 459);
            graphics.drawString("Exp gained: "+(Skills.SKILLS.COOKING.getXP()-startExp), 50,411);
            graphics.drawString("(Per hour): "+ runTime.getPerHour(Skills.SKILLS.COOKING.getXP()-startExp), 333,411);
            graphics.drawString("Levels Gained: "+(Skills.SKILLS.COOKING.getCurrentLevel()-startLevel), 50, 435);
            graphics.drawString("(Current Level): "+ Skills.SKILLS.COOKING.getCurrentLevel(), 333, 435);
        }
    }

    @Override
    public void clanMessageReceived(String s, String s2) {

    }

    @Override
    public void personalMessageReceived(String s, String s2) {

    }

    @Override
    public void duelRequestReceived(String s, String s2) {

    }

    @Override
    public void tradeRequestReceived(String s) {

    }

    @Override
    public void serverMessageReceived(String s) {
        if(s.contains("burn"))
            thingsBurned++;
        else if(s.contains("You roast") || (s.contains("You") && s.contains("cook")))
            thingsCooked++;
    }

    @Override
    public void playerMessageReceived(String s, String s2) {

    }
}
