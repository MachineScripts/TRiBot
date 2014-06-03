//package scripts.tree.nodes.woodcutter;
//
//import org.tribot.api2007.Inventory;
//import org.tribot.api2007.Player;
//import org.tribot.api2007.types.RSArea;
//import org.tribot.api2007.types.RSTile;
//import org.tribot.script.Script;
//import scripts.MachineWoodCutter;
//import scripts.tree.nodes.Node;
//import scripts.utils.walking.Walk;
//
//public class WalkToBank extends Node {
//    private RSArea area;
//    private scripts.utils.walking.Walk walker;
//    private RSTile tile;
//
//    public WalkToBank(Script script, RSArea area) {
//        super(script);
//        this.area = area;
//        walker = new Walk(this.script);
//    }
//
//    @Override
//    public boolean activate() throws InterruptedException {
//        return (!area.contains(Player.getPosition()) && Inventory.isFull());
//    }
//
//    @Override
//    public void execute() throws InterruptedException {
//        if(MachineWoodCutter.walkNode.getTile() != null){
//            MachineWoodCutter.walkNode.clearAreaTile();
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
