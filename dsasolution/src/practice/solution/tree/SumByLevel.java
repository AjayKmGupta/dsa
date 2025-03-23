/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.tree;

import java.util.ArrayList;

public class SumByLevel {
    public static void main(String[] args) {
        Tree node = SumByLevel.createTree();
        int sum = SumByLevel.getSumByLevel(node, 3, 2, 0);
        System.out.println("Sum by level is: " + sum);
    }

    private static int getSumByLevel(Tree node, int level, int currentLevel, int sum) {
        if (node.getTree() == null && currentLevel == level) {
            return sum += node.getData();
        }
        if (node.getTree() == null) {
            return 0;
        }
        if (level == currentLevel) {
            return sum += node.getData();
        }
        for (Tree node1 : node.getTree()) {
            sum = SumByLevel.getSumByLevel(node1, level, currentLevel + 1, sum);
        }
        return sum;
    }

    private static Tree createTree() {
        Tree node = new Tree(1);
        ArrayList<Tree> nodes = new ArrayList<Tree>();
        nodes.add(new Tree(2));
        nodes.add(new Tree(3));
        nodes.add(new Tree(4));
        node.setTree(nodes);
        ArrayList<Tree> nodes1 = new ArrayList<Tree>();
        nodes1.add(new Tree(5));
        ((Tree)nodes.get(0)).setTree(nodes1);
        ArrayList<Tree> nodes2 = new ArrayList<Tree>();
        nodes2.add(new Tree(6));
        nodes2.add(new Tree(7));
        ((Tree)nodes.get(1)).setTree(nodes2);
        ArrayList<Tree> nodes3 = new ArrayList<Tree>();
        nodes3.add(new Tree(8));
        nodes3.add(new Tree(9));
        nodes3.add(new Tree(10));
        ((Tree)nodes.get(2)).setTree(nodes3);
        return node;
    }
}
