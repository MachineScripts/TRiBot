package scripts.enums;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;


public class WoodCutterEnum {
    public static enum CutterInfo{
        DRAYNOR_WILLOWS("Willow", new RSArea(new RSTile(3092,3246), new RSTile(3094,3242)), new RSArea(new RSTile(3081,3239), new RSTile(3092,3225))),
        VARROCK_EAST_OAKS("Oak", new RSArea(new RSTile(3251,3422), new RSTile(3254,3420)), new RSArea(new RSTile(3280,3345), new RSTile(3302,3334))),
        VARROCK_WEST_OAKS("Oak", new RSArea(new RSTile(3181,3439), new RSTile(3185,3435)), new RSArea(new RSTile(3160,3423), new RSTile(3170,3410))),
        SEERS_YEWS_1("Yew", new RSArea(new RSTile(2722,3493), new RSTile(2729,3491)), new RSArea(new RSTile(2704,3464), new RSTile(2716,3458))),
        CATHERBY_YEWS_1("Yew", new RSArea(new RSTile(2807,3441), new RSTile(2811,3439)), new RSArea(new RSTile(2753,3434), new RSTile(2768,3426))),
        SEERS_MAPLES("Maple tree", new RSArea(new RSTile(2722,3493), new RSTile(2729,3491)), new RSArea(new RSTile(2720,3503), new RSTile(2734,3498))),
        SEERS_WILLOWS("Willow", new RSArea(new RSTile(2722,3493), new RSTile(2729,3491)), new RSArea(new RSTile(2707,3514), new RSTile(2714,3507))),
        SEERS_MAGICS("Magic tree", new RSArea(new RSTile(2807,3441), new RSTile(2811,3439)), new RSArea(new RSTile(2700,3399), new RSTile(2704,3396))),
        EDGEVILLE_YEWS("Yew", new RSArea(new RSTile(3092,3492), new RSTile(3094,3489)), new RSArea(new RSTile(3085,3482), new RSTile(3088,3469)))
        ;

        private String treeName;
        private RSArea bankArea, treeArea;

        CutterInfo(String treeName, RSArea bankArea, RSArea treeArea){
            this.treeName = treeName;
            this.bankArea = bankArea;
            this.treeArea = treeArea;
        }


        public String getTreeName(){
            return this.treeName;
        }

        public RSArea getBankArea(){
            return this.bankArea;
        }

        public RSArea getTreeArea(){
            return this.treeArea;
        }

    }

}
