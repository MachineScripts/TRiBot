//package scripts;
//
//import org.tribot.api.General;
//import org.tribot.api2007.Skills;
//import org.tribot.script.Script;
//import org.tribot.script.ScriptManifest;
//import org.tribot.script.interfaces.MessageListening07;
//import org.tribot.script.interfaces.Painting;
//import scripts.guis.MWCGui;
//import scripts.tree.Tree;
//import scripts.tree.nodes.Node;
//import scripts.tree.nodes.antiban.Antiban;
//import scripts.tree.nodes.woodcutter.Banking;
//import scripts.tree.nodes.woodcutter.ChopTree;
//import scripts.tree.nodes.woodcutter.WalkToBank;
//import scripts.tree.nodes.woodcutter.WalkToTrees;
//import scripts.utils.image.Getter;
//import scripts.utils.timer.RunTime;
//
//import javax.swing.*;
//import java.awt.*;
//
//
//@ScriptManifest(authors = {"The Machine"}, name = "MachineWoodCutter", category = "WoodCutting", version = 1.0)
//public class MachineWoodCutter extends Script implements Painting, MessageListening07 {
//    public static MWCGui gui;
//    public static boolean showGui, powerChop;
//    private Tree tree;
//    private boolean hidePaint, runScript = true;
//    private int startLevel, startExp, nestCollected, logsCut;
//    private Image backGround, minimize;
//    private Getter getter = new Getter();
//    private RunTime runTime;
//    //private static Rectangle hideRect = new Rectangle(55, 342, 30, 30);
//    public static WalkToTrees walkNode;
//    public static WalkToBank walkToBank;
//    private int antiBanRange, antiBanHit;
//
//    @Override
//    public void run() {
//        startExp = Skills.SKILLS.WOODCUTTING.getXP();
//        startLevel = Skills.SKILLS.WOODCUTTING.getCurrentLevel();
//        minimize = getter.getImageFromURL("http://i62.tinypic.com/33dlc1j.png");
//        backGround = getter.getImageFromURL("http://i59.tinypic.com/x1a907.png");
//        runTime = new RunTime(0);
//        tree = new Tree();
//
//        //set up and start the gui
//        gui = new MWCGui();
//        gui.buildGui();
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gui.setVisible(true);
//        showGui = true;
//
//        while(showGui){
//            sleep(100);
//        }
//
//        antiBanRange = General.random(120, 450);//generates a random int to be used for antiban, making antiban frequency unique to each script startup
//        antiBanHit = General.random(0, antiBanRange-1);//this is the number used to initiate the antiban, also random to each startup
//        System.out.println("Antiban range is up to: "+antiBanRange+". Antiban hit is on: "+antiBanHit+".");
//
//        if(powerChop){
//            //to be used later to add power chopping nodes
//        }
//        else{//else we are using a premade location
//            walkNode = new WalkToTrees(this,gui.getCutterInfo().getTreeArea());
//            walkToBank = new WalkToBank(this,gui.getCutterInfo().getBankArea());
//            tree.addTasks(new Node[] {new Banking(this, gui.getCutterInfo().getBankArea()), walkNode,
//                    walkToBank, new ChopTree(this, gui.getCutterInfo().getTreeName(), gui.getCutterInfo().getTreeArea()), new Antiban(this, antiBanRange, antiBanHit)});
//        }
//        while (runScript){//main loop
//            tree.executeTasks();
//            sleep(90,110);
//        }
//    }
//
//    @Override
//    public void onPaint(Graphics graphics) {
//        //graphics.drawImage(minimize, 55, 342, null);
//        if(!hidePaint){
//            graphics.drawImage(backGround, 1, 300, null);
//            //graphics.drawImage(minimize, 55, 342, null);
//            graphics.setColor(new Color(255, 255, 255));
//            graphics.setFont(new Font("Myriad Web Pro", Font.PLAIN, 12));
//            graphics.drawString("Elapsed Time: " + runTime.gethours() + " hour(s)  "
//                    + runTime.getminutes() + " minute(s)  " + runTime.getseconds()+ " second(s)  ", 50, 385);
//            graphics.drawString("Logs Cut: "+(logsCut), 50,459);
//            graphics.drawString("(Per hour): "+ runTime.getPerHour(logsCut), 150,459);
//            graphics.drawString("Exp gained: "+(Skills.SKILLS.WOODCUTTING.getXP()-startExp), 50,411);
//            graphics.drawString("(Per hour): "+ runTime.getPerHour(Skills.SKILLS.WOODCUTTING.getXP()-startExp), 333,411);
//            graphics.drawString("Levels Gained: "+(Skills.SKILLS.WOODCUTTING.getCurrentLevel()-startLevel), 50, 435);
//            graphics.drawString("(Current Level): "+ Skills.SKILLS.WOODCUTTING.getCurrentLevel(), 333, 435);
//            graphics.drawString("Nest Collected: "+ nestCollected, 333, 459);
//        }
//    }
//
//
//
//    @Override
//    public void duelRequestReceived(String s, String s2) {
//
//    }
//
//    @Override
//    public void personalMessageReceived(String s, String s2) {
//
//    }
//
//    @Override
//    public void serverMessageReceived(String s) {
//        if(s.contains("You get some")){
//            logsCut++;
//        }
//        if(s.contains("nest")){
//            nestCollected++;
//        }
//        if(s.contains("You do not have an axe")){
//            println("You do not have an axe to chop with. Stopping the script.");
//            this.runScript = false;
//        }
//
//    }
//
//    @Override
//    public void tradeRequestReceived(String s) {
//
//    }
//
//    @Override
//    public void clanMessageReceived(String s, String s2) {
//
//    }
//
//    @Override
//    public void playerMessageReceived(String s, String s2) {
//
//    }
//
//}
