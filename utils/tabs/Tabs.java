package scripts.utils.tabs;

import org.tribot.api.General;
import org.tribot.api2007.GameTab;
import org.tribot.script.Script;


public class Tabs {
    private Script script;
    private int chooseTab;

    public Tabs(Script script){
        this.script = script;
    }

    public boolean openTab(GameTab.TABS tab){
        if(!tab.isOpen()){
            tab.open();
            script.sleep(400,500);
        }
        if(tab.isOpen()){
            return true;
        }
        return false;
    }

    public boolean openRandomTab(GameTab.TABS[] tabsArray){
        chooseTab = General.random(0, (tabsArray.length - 1));
        return(openTab(tabsArray[chooseTab]));
    }
}
