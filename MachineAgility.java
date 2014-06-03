//package scripts;
//
//import org.tribot.script.Script;
//import org.tribot.script.ScriptManifest;
//import org.tribot.script.interfaces.Painting;
//import scripts.guis.AgilityGui;
//
//import javax.swing.*;
//import java.awt.*;
//
//@ScriptManifest(authors = {"The Machine"}, name = "MachineAgility", category = "Agility", version = 1.0)
//public class MachineAgility extends Script implements Painting{
//    private AgilityGui gui;
//    private boolean showGui;
//
//    @Override
//    public void run() {
//        gui = new AgilityGui();
//        gui.buildGui();
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gui.setVisible(true);
//        showGui = true;
//
//        while(showGui){
//            sleep(100);
//        }
//
//        while(true){
//
//        }
//    }
//
//    @Override
//    public void onPaint(Graphics graphics) {
//
//    }
//
//}
