/*
 * Decompiled with CFR 0.152.
 */
package practice.solution.scopetest;


public class ClientMain {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.name = "Dog";
        ClientMain.instanceChanger(a);
        System.out.println(a);
        System.out.println(a.name);
    }

    public static Animal instanceChanger(Animal a) {
        a = new Tiger();
        a.name = "Tiger";
        return a;
    }
}
