package scripts.tree.nodes;

import org.tribot.script.Script;

public abstract class Node
{
    public Script script;

    public Node(Script script)
    {
        this.script = script;
    }

    public abstract boolean activate()
            throws InterruptedException;

    public abstract void execute()
            throws InterruptedException;
}