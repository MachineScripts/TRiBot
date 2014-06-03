package scripts.utils.widget;

import org.tribot.api2007.Interfaces;
import org.tribot.api2007.types.RSInterfaceChild;
import org.tribot.api2007.types.RSInterfaceMaster;


public class Widgets{
    private RSInterfaceMaster widget;
    private RSInterfaceChild child;

    public RSInterfaceMaster getWidgetParent(int parentId){
        widget = Interfaces.get(parentId);
        return widget;
    }

    public RSInterfaceChild getWidgetChild(int parentId, int childId){
        widget = Interfaces.get(parentId);
        if(widget != null){
            child = widget.getChild(childId);
            if(child != null){
                return child;
            }
        }
        return null;
    }

    public boolean interactWithChild(int parentId, int childId, String actionName){
        RSInterfaceChild tempChild = this.getWidgetChild(parentId, childId);
        if(tempChild != null){
            return tempChild.click(actionName);
        }
        return false;
    }

}
