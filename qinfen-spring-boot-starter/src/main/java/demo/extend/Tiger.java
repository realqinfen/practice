package demo.extend;

public class Tiger extends Animal{
    static{
        String str = "Tiger static string";
        System.out.println("Tiger staticStr is : "+str);
    }
    private String s;
    private int a = 1;
    public Tiger(String str){
        this.s=str;
        System.out.println("Tiger args constructor");
    }
    public Tiger(int b){
        System.out.println("before,a is : "+a);
        this.a=b;
        System.out.println("after,a is : "+b);
    }
    public Tiger(){
        System.out.println("Tiger no args constructor");
    };
}
