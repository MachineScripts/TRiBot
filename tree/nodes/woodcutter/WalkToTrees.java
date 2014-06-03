//package scripts.tree.nodes.woodcutter;
//
//
//import org.tribot.api2007.Inventory;
//import org.tribot.api2007.Player;
//import org.tribot.api2007.types.RSArea;
//import org.tribot.api2007.types.RSTile;
//import org.tribot.script.Script;
//import scripts.MachineWoodCutter;
//import scripts.tree.nodes.Node;
//
//
//public class WalkToTrees extends Node {
//    private RSArea area;
//    private scripts.utils.walking.Walk walker;
//    private RSTile tile;
//
//    public WalkToTrees(Script script, RSArea area) {
//        super(script);
//        this.area = area;
//        walker = new scripts.utils.walking.Walk(this.script);
//    }
//
//    @Override
//    public boolean activate() throws InterruptedException {
//        return (!area.contains(Player.getPosition()) && !Inventory.isFull());
//    }
//
//    @Override
//    public void execute() throws InterruptedException {
//        if(!MachineWoodCutter.powerChop){
//            if(MachineWoodCutter.walkToBank.getTile() != null){
//                MachineWoodCutter.walkToBank.clearAreaTile();
//            }
//        }
//        if(tile == null){
//            tile = area.getRandomTile();
//        }
//        else{
//            walker.walkToTile(tile);
//        }
//    }
//    public void clearAreaTile(){
//        this.tile = null;
//    }
//
//    public RSTile getTile(){
//        return this.tile;
//    }
//}
