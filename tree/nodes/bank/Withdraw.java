package scripts.tree.nodes.bank;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.script.Script;
import scripts.tree.nodes.Node;
import scripts.utils.bank.Bank;

public class Withdraw extends Node{
    private RSArea bankArea;
    private String itemName;
    private Bank bank;
    private int amount;

    public Withdraw(Script script, String itemName, RSArea bankArea, int amount) {
        super(script);
        bank = new Bank(this.script);
        this.bankArea = bankArea;
        this.itemName = itemName;
        this.amount = amount;
    }

    @Override
    public boolean activate() throws InterruptedException {
        return (bankArea.contains(Player.getPosition()) && Inventory.getAll().length == 0 && Inventory.getCount(itemName) == 0);
    }

    @Override
    public void execute() throws InterruptedException {
        bank.withdrawX(itemName, amount);
        script.sleep(120,160);
    }
}
