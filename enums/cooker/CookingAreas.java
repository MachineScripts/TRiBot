package scripts.enums.cooker;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;


public class CookingAreas {

    public static enum CookingArea {
        CATHERBY("Range", new RSArea(new RSTile(2807, 3441), new RSTile(2811, 3438)), new RSArea(new RSTile(2816, 3443), new RSTile(2818, 3442))),
        ROGUES_DEN("Fire", new RSArea(new RSTile(3039, 4981, 1), new RSTile(3056, 4961, 1)), new RSArea(new RSTile(3039, 4981, 1), new RSTile(3056, 4961, 1)))
        ;

        private String cookerName;
        private RSArea bankArea, cookerArea;

        CookingArea(String cookerName, RSArea bankArea, RSArea cookerArea) {
            this.cookerName = cookerName;
            this.bankArea = bankArea;
            this.cookerArea = cookerArea;
        }


        public RSArea getBankArea() {
            return this.bankArea;
        }

        public RSArea getCookerArea(){
            return this.cookerArea;
        }

        public String getCookerName(){
            return this.cookerName;
        }


    }
}