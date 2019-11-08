package test;

public class test1 {
    public static void main(String[] args) {
        StringBuffer a=new StringBuffer("A");
        StringBuffer b=new StringBuffer("B");
        option(a,b);
        System.out.println(a+"    "+b);
    }

    public static void option( StringBuffer a, StringBuffer b){
            a.append(b);
            b=a;
    }
}
