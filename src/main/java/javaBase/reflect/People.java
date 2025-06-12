package javaBase.reflect;

public class People {
    private String name;

    public void sayHello(String helloSentence){
        System.out.println( helloSentence + " " + name );
    }

    private String  getHello(String tag){
       return "Hello " + tag;
    }
}
