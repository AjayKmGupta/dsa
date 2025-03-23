/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.tree;

import java.util.List;

public class Tree {
    private int data;
    private List<Tree> node;

    public Tree() {
    }

    public Tree(int data) {
        this.data = data;
    }

    public Tree(int data, List<Tree> node) {
        this(data);
        this.node = node;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<Tree> getTree() {
        return this.node;
    }

    public void setTree(List<Tree> node) {
        this.node = node;
    }
}
