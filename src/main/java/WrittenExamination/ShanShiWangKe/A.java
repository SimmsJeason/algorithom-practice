package WrittenExamination.ShanShiWangKe;

public class A {
    public Integer num = 1;

    public A(){
        System.out.println("a");
    }

    public A (int x){
        this();
        System.out.println(x);
    }



    public static void main(String[] args) {

        B b = new B(3.14);
        System.out.println(b.num);
    }

}

class  B extends A{

    public B (double y ){
        System.out.println(y);
    }
}