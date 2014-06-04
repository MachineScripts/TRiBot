package scripts.tree;


import scripts.tree.nodes.Node;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tree
{
    private LinkedList<Node> list;
    private Lock threadLock;
    private Condition lockCondition;
    private Thread thread;
    private Thread secondThread;
    private Thread thirdThread;

    public Tree()
    {
        this.list = new LinkedList();
        this.threadLock = new ReentrantLock();
        this.lockCondition = this.threadLock.newCondition();
    }

    public void addTask(Node node) {
        try {
            if (this.list != null)
                this.list.add(node);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bounds Exception");
        }
        catch (NoSuchElementException e) {
            System.out.println("Input Mismatch");
        }
    }

    public void addTasks(Node[] nodes) {
        try {
            if ((this.list != null) && (this.list.isEmpty()))
                Collections.addAll(this.list, nodes);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Out of Bounds Exception");
        }
        catch (NoSuchElementException e) {
            System.out.println("Input Mismatch");
        }
    }

    public Node removeTask(Node node) {
        try {
            if ((!this.list.isEmpty()) && (this.list != null)) {
                this.list.remove(node);
            }
            return node;
        }
        catch (Exception e)
        {
            e = e;
            e.printStackTrace();
            return node; }
    }

    public void removeAllTasks()
    {
        try {
            if ((!this.list.isEmpty()) && (this.list != null))
                for (int i = 0; i < this.list.size(); i++)
                    this.list.remove(i);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void executeTasks() {
        try {
            for (Node aList : this.list)
                if (aList.activate())
                    aList.execute();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Out of Bounds Exception");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }

    public String toString()
    {
        String string = "";
        try {
            if (this.list.isEmpty()) {
                string = string + "Empty List";
            }
            else
            {
                Node aList;
                for (Iterator i$ = this.list.iterator(); i$.hasNext(); string = string + aList.getClass().toString() + "\n") aList = (Node)i$.next();
            }
        }
        catch (Exception e) { e.printStackTrace(); }

        return string;
    }

}