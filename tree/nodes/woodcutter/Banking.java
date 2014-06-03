package scripts.tree.nodes.woodcutter;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;
import org.tribot.script.Script;
import scripts.tree.nodes.Node;
import scripts.utils.bank.Bank;


public class Banking extends Node{
    private RSArea bankArea;
    private RSTile playerPosition;
    private Bank bank = new Bank(script);
    private String[] axes = {"Bronze axe", "Iron axe", "Steel axe", "Black axe", "Mithril axe", "Adamant axe", "Rune axe", "Dragon axe"};
    public Banking(Script script, RSArea bankArea) {
        super(script);
        this.bankArea = bankArea;
    }

    @Override
    public boolean activate() throws InterruptedException {
        return (bankArea.contains(Player.getPosition()) && Inventory.isFull());
    }

    @Override
    public void execute() throws InterruptedException {
        playerPosition = Player.getPosition();
        if(bankArea.contains(playerPosition)){
            bank.depositAllExcept(axes);
        }
    }
}