package demo.extend;

public class Animal {
    static {
        String staticStr = "Animal static string";
        System.out.println("animal staticStr is : " + staticStr);
    }

    private String s;

    public Animal(String str) {
        this.s = str;
        System.out.println("animal args constructor");
    }

    public Animal() {
        System.out.println("animal no args constructor");
    }

    ;

}
