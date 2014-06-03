package scripts.guis.events;

import scripts.enums.WoodCutterEnum;


public class ChooseWcer {
    private WoodCutterEnum.CutterInfo cutterInfo;

    public WoodCutterEnum.CutterInfo getChoice(String choice){

        switch(choice) {
            case "Oaks (Varrock West)":
                cutterInfo = WoodCutterEnum.CutterInfo.VARROCK_WEST_OAKS;
                System.out.println(cutterInfo);
                break;
            case "Oaks (Varrock East)":
                cutterInfo = WoodCutterEnum.CutterInfo.VARROCK_EAST_OAKS;
                break;
            case "Willows (Draynor)":
                cutterInfo = WoodCutterEnum.CutterInfo.DRAYNOR_WILLOWS;
                break;
            case "Yews (Catherby)":
                cutterInfo = WoodCutterEnum.CutterInfo.CATHERBY_YEWS_1;
                break;
            case "Yews (Seers)":
                cutterInfo = WoodCutterEnum.CutterInfo.SEERS_YEWS_1;
                System.out.println(cutterInfo);
                break;
            case "Yews (Edgeville)":
                cutterInfo = WoodCutterEnum.CutterInfo.EDGEVILLE_YEWS;
                break;
            case "Maples (Seers)":
                cutterInfo = WoodCutterEnum.CutterInfo.SEERS_MAPLES;
                break;
            case "Willows (Seers)":
                cutterInfo = WoodCutterEnum.CutterInfo.SEERS_WILLOWS;
                break;
            case "Magics (Seers)":
                cutterInfo = WoodCutterEnum.CutterInfo.SEERS_MAGICS;
                break;
            default:break;
        }
        return this.cutterInfo;
    }
}
