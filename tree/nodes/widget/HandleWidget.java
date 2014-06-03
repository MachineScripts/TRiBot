package scripts.tree.nodes.widget;

import org.tribot.script.Script;
import scripts.tree.nodes.Node;
import scripts.utils.widget.Widgets;


public class HandleWidget extends Node {
    private Widgets widget = new Widgets();
    private int parentId, childId;
    private String actionName;

    public HandleWidget(Script script, int parentId, int childId, String actionName) {
        super(script);
        this.parentId = parentId;
        this.childId = childId;
        this.actionName = actionName;
    }

    @Override
    public boolean activate() throws InterruptedException {
        return widget.getWidgetChild(parentId, childId) != null;
    }

    @Override
    public void execute() throws InterruptedException {
        widget.interactWithChild(parentId, childId, actionName);
        script.sleep(900,1200);
    }
}
