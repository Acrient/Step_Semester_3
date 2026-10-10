import java.util.*;
abstract class Connection { int units; Connection(int u){units=u;} abstract double bill(); }
public class Problem4_ElectricityConnectionBilling {
    static class Home extends Connection { Home(int u){super(u);} double bill(){return Math.min(units,100)*5.0+Math.max(0,units-100)*7.0;} }
    static class Shop extends Connection { Shop(int u){super(u);} double bill(){return units*8.0+100;} }
    static class Factory extends Connection { Factory(int u){super(u);} double bill(){return Math.max(1000,units*6.0);} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next();int u=sc.nextInt();Connection c=type.equals("HOME")?new Home(u):type.equals("SHOP")?new Shop(u):new Factory(u);
            double b=c.bill();System.out.printf("%s: %.2f%n",type,b);total+=b;
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
