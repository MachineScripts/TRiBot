package scripts.tree.nodes.bank;

import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.script.Script;
import scripts.tree.nodes.Node;
import scripts.utils.bank.Bank;

public class DepositAll extends Node{
    private Bank bank;
    private String itemName;
    private RSArea bankArea;

    public DepositAll(Script script, String itemName, RSArea bankArea) {
        super(script);
        bank = new Bank(this.script);
        this.itemName = itemName;
        this.bankArea = bankArea;
    }

    @Override
    public boolean activate() throws InterruptedException {
        return (Inventory.getAll().length > 0 && Inventory.getCount(itemName) == 0 && bankArea.contains(Player.getPosition()));
    }

    @Override
    public void execute() throws InterruptedException {
        bank.depositAll();
    }
}
