package scripts.utils.inven;


import org.tribot.api.Clicking;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSObject;
import scripts.utils.rsgame.RSGame;

public class Inven extends Inventory{
    private RSItem[] items;
    private RSGame rsGame = new RSGame();



    public boolean useItemOn(final String itemName, final String option, final RSObject rsObject) {
        if (rsObject == null || find(itemName).length == 0) {
            return false;
        }
        String selected = rsGame.getSelectedItemName();

        if(selected == null && find(itemName) != null){
            Clicking.click("Use", find(itemName));
        }
        selected = rsGame.getSelectedItemName();
        return selected != null && selected.equalsIgnoreCase(itemName) && Clicking.click(option, rsObject);
    }

    public boolean contains(String item){
        return Inventory.getCount(item) > 0;
    }

    public boolean contains(int item){
        return Inventory.getCount(item) > 0;
    }

    public boolean isEmpty(){
        return Inventory.getAll().length == 0;
    }

    public RSItem[] getItems(){
        items = Inventory.getAll();
        return this.items;
    }


}
