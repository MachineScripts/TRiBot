package scripts.guis.events;

import scripts.enums.cooker.CookingAreas;
import scripts.enums.cooker.Foods;


public class ChooseCooker {
    private CookingAreas.CookingArea areaEnum;

    public CookingAreas.CookingArea getAreaChoice(String locationName){
        switch (locationName){
            case "Catherby (Range)":
                areaEnum = CookingAreas.CookingArea.CATHERBY;
                break;
            case "Rogues Den":
                areaEnum = CookingAreas.CookingArea.ROGUES_DEN;
                break;
            default:
                break;

        }
        return areaEnum;
    }

    public Foods.FoodInfo getFoodChoice(){

        return null;
    }

}
