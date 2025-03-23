/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.interview;


public class Solve2 {
    public static CDLL createList(int num) {
        CDLL head;
        CDLL temp = head = new CDLL(1);
        CDLL tail = null;
        int count = 1;
        int i = 2;
        while (count < num) {
            CDLL newNode;
            temp.next = newNode = new CDLL(i);
            newNode.prev = temp;
            tail = newNode;
            temp = temp.next;
            ++count;
            ++i;
        }
        head.prev = tail;
        tail.next = head;
        return head;
    }

    public static int solution(String str, int players) {
        if (players < 2) {
            System.out.println("not sufficient players ");
            return 0;
        }
        if (str.length() < 2) {
            System.out.println("string length is less than 2 ");
            return 0;
        }
        int size = players;
        CDLL head = Solve2.createList(players);
        CDLL tail = head.prev;
        CDLL MovePointer = head;
        int i = 0;
        boolean directionFlag = true;
        while (size != 1) {
            CDLL tempnext;
            if (str.charAt(i) == 'b' && directionFlag) {
                tempnext = MovePointer.next;
                MovePointer.prev.next = MovePointer.next;
                MovePointer.next.prev = MovePointer.prev;
                System.out.println("deleting node: " + MovePointer.data + " now starting moving in anti-clockwise direction");
                MovePointer = tempnext;
                directionFlag = false;
                --size;
                i = (i + 1) % str.length();
                continue;
            }
            if (str.charAt(i) == 'b' && !directionFlag) {
                tempnext = MovePointer.prev;
                MovePointer.prev.next = MovePointer.next;
                MovePointer.next.prev = MovePointer.prev;
                System.out.println("deleting node: " + MovePointer.data + " now starting moving in clockwise direction ");
                MovePointer = tempnext;
                directionFlag = true;
                --size;
                i = (i + 1) % str.length();
                continue;
            }
            if (str.charAt(i) == 'a' && directionFlag) {
                MovePointer = MovePointer.next;
                i = (i + 1) % str.length();
                continue;
            }
            if (str.charAt(i) != 'a' || directionFlag) continue;
            MovePointer = MovePointer.prev;
            i = (i + 1) % str.length();
        }
        return MovePointer.data;
    }

    public static void main(String[] args) {
        System.out.println("********** TEST 1 *******");
        String str = "aba";
        int players = 5;
        int alivePosition = Solve2.solution(str, players);
        System.out.println("alivePlayer " + alivePosition);
        System.out.println("********** TEST 2 *******");
        str = "ababa";
        players = 5;
        alivePosition = Solve2.solution(str, players);
        System.out.println("alivePlayer " + alivePosition);
    }
}
