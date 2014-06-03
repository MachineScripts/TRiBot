package scripts.utils.bank;

import org.tribot.api.input.Mouse;
import org.tribot.api2007.*;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSObject;
import org.tribot.script.Script;
import scripts.utils.rsgame.RSGame;


public class Bank {
    private Script script;
    private RSObject[] bankBoothArray;
    private RSNPC[] npcBank;
    private RSGame rsGame = new RSGame();

    public Bank(Script script){
        this.script = script;
    }


    private RSObject getClosestBankbooth(){
        bankBoothArray = (Objects.find(20, Filters.Objects.actionsContains("Bank")));
        bankBoothArray = Objects.sortByDistance(Player.getPosition(), bankBoothArray);
        if(bankBoothArray.length > 0)
            return bankBoothArray[0];
        return null;
    }

    private RSNPC getClosestBankNPC(){
        npcBank = NPCs.find(Filters.NPCs.actionsContains("Bank"));
        npcBank = NPCs.sortByDistance(Player.getPosition(), npcBank);
        if(npcBank.length > 0)
            return npcBank[0];
        return null;
    }

    private boolean openBank(){
        if(!rsGame.noItemIsSelected()){
            System.out.println("Something is selected preventing us from banking. Deselecting item.");
            Mouse.clickBox(12, 350, 480, 460, 1);
        }
        getClosestBankbooth();
        getClosestBankNPC();
        if(!Banking.isBankScreenOpen() && !Player.isMoving()){
            if(bankBoothArray.length != 0){
                if(bankBoothArray[0].isOnScreen()){
                    bankBoothArray[0].click("Bank");
                    script.sleep(600,700);
                }
                else{
                    Walking.walkTo(bankBoothArray[0]);
                    Camera.turnToTile(bankBoothArray[0]);
                }
            }
            else if(npcBank.length != 0){
                if(npcBank[0].isOnScreen()){
                    npcBank[0].click("Bank");
                    script.sleep(600,700);
                }
                else{
                    Walking.walkTo(npcBank[0]);
                    Camera.turnToTile(npcBank[0]);
                }
            }
        }
        if(Banking.isBankScreenOpen()){
            return true;
        }
        return false;
    }

    public boolean depositAllExcept(String[] items){
        openBank();
        if(Banking.isBankScreenOpen()){
            if(Inventory.getAll().length != 0){
                Banking.depositAllExcept(items);
            }
            else{
                Banking.close();
            }
        }
        return(!Inventory.isFull());
    }

    public boolean depositAll(){
        openBank();
        if(Banking.isBankScreenOpen()){
            if(Inventory.getAll().length != 0){
                Banking.depositAll();
            }
            else{
                Banking.close();
            }
        }
        return(!Inventory.isFull());
    }


    public boolean contains(String itemName, Banking banking){
        if(banking.isBankScreenOpen()){
            RSItem[] items = banking.getAll();
            for(RSItem item : items){
                if(item.name.equals(itemName)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean withdrawX(String itemName, int amount){
        openBank();
        if(Banking.isBankScreenOpen()){
            if(this.contains(itemName, new Banking())){
                Banking.withdraw(amount, itemName);
            }
        }
        return false;
    }
}
