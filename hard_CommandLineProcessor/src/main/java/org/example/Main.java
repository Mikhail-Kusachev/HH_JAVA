package org.example;

public class Main {
    public static void main(String[] args) {
        var clpA = new CommandLineProcessor();
        System.out.printf(clpA.processInput("add_user Alice 4"));
        System.out.printf(clpA.processInput("add_user Bob 3"));
        System.out.printf(clpA.processInput("add_user Charlie 2"));
        System.out.println(clpA.processInput("get_users"));
        System.out.println("===");

        var clpB = new CommandLineProcessor();
        System.out.printf(clpB.processInput("add_user Alice 1"));
        System.out.printf(clpB.processInput("add_user Bob 3"));
        System.out.printf(clpB.processInput("add_user Charlie 3"));
        System.out.printf(clpB.processInput("promote Alice"));
        System.out.printf(clpB.processInput("promote Alice"));
        System.out.printf(clpB.processInput("demote Alice"));
        System.out.println(clpB.processInput("get_users"));
        System.out.println("===");

        var clpC = new CommandLineProcessor();
        System.out.printf(clpC.processInput("add_user Bob 3"));
        System.out.printf(clpC.processInput("add_user Charlie 2"));
        System.out.printf(clpC.processInput("remove_user Bob"));
        System.out.printf(clpC.processInput("remove_user Charlie"));
        System.out.println(clpC.processInput("get_users"));
        System.out.println("===");
    }
}
