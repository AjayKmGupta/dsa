/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.interview;


public class Example5 {
    private int game(int number, String input) {
        Node start;
        Node extra;
        int j = 0;
        Node node = extra = new Node(0);
        int i = 0;
        while (i < number) {
            node = node.next = new Node(i + 1);
            ++i;
        }
        node.next = start = extra.next;
        while (node.next != node) {
            if (j == input.length()) {
                j = 0;
            }
            if (input.charAt(j) == 'a') {
                node = node.next;
            } else if (input.charAt(j) == 'b') {
                node.next = node.next.next;
            }
            ++j;
        }
        return node.num;
    }

    public static void main(String[] arg) {
        Example5 example5 = new Example5();
        System.out.println(example5.game(5, "ababa"));
    }
}
