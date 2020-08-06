package cn.test.controller;

public class Test {
    public static void main(String[] args) {
        method(null);
    }
    public static void method(String str){
        switch (str){
            case "str":
                System.out.println("str");
                break;
            case "null":
                System.out.println("null1");
                break;
            default:
                System.out.println("default");
        }
    }
}
