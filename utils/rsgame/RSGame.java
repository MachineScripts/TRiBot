package scripts.utils.rsgame;

import org.tribot.api2007.Game;

public class RSGame {
    private String selected;
    private String[] selectedArray, finalSplit;

    public String getSelectedItemName(){
        selected = Game.getUptext();
        if(selected != null){
            if(selected.contains("->")){
                if(!selected.contains("cancel")){
                    selectedArray = selected.split("->");
                    if(selectedArray.length > 0){
                        finalSplit = selectedArray[0].split(" ", 2);
                        if(finalSplit.length>1){
                            return finalSplit[1].replaceAll("\\s+$", "");
                        }
                    }
                }
            }
        }
        return null;
    }

    public String getSelectedItemOption() {
        selected = Game.getUptext();
        if (selected != null) {
            if (selected.contains("->")) {
                if (!selected.contains("cancel")) {
                    selectedArray = selected.split("->");
                    if (selectedArray.length > 0) {
                        finalSplit = selectedArray[0].split(" ", 2);
                        if (finalSplit.length > 0) {
                            return finalSplit[0].replaceAll("\\s+$", "");
                        }
                    }
                }
            }
        }
        return null;
    }



    public boolean isItemSelected(String itemName){
        return itemName.equals(this.getSelectedItemName());
    }

    public boolean noItemIsSelected(){
        selected = Game.getUptext();
        if(selected != null) {
            if (selected.contains("->")) {
                return false;
            }
        }
        return true;
    }

}
