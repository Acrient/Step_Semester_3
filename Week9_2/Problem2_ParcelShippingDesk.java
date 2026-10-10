import java.util.*;
abstract class Parcel {
    double weight,value; Parcel(double w,double v){weight=w;value=v;}
    abstract double charge();
    double insurance(){return this instanceof Insurable?((Insurable)this).insuranceAmount():0;}
    double total(){return charge()+insurance();}
    abstract String type();
}
interface Insurable { double insuranceAmount(); }
public class Problem2_ParcelShippingDesk {
    static class Standard extends Parcel { Standard(double w,double v){super(w,v);} double charge(){return 40+10*weight;} String type(){return "STANDARD";} }
    static class Express extends Parcel implements Insurable { Express(double w,double v){super(w,v);} double charge(){return 80+15*weight;} public double insuranceAmount(){return value*.02;} String type(){return "EXPRESS";} }
    static class Fragile extends Parcel implements Insurable { Fragile(double w,double v){super(w,v);} double charge(){return 40+10*weight+50;} public double insuranceAmount(){return value*.02;} String type(){return "FRAGILE";} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);int n=sc.nextInt();double grand=0;
        for(int i=0;i<n;i++){
            String type=sc.next();double w=sc.nextDouble(),v=sc.nextDouble();
            Parcel p=type.equals("STANDARD")?new Standard(w,v):type.equals("EXPRESS")?new Express(w,v):new Fragile(w,v);
            double c=p.charge(),ins=p.insurance(),t=c+ins;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",type,c,ins,t);grand+=t;
        }
        System.out.printf("Grand Total: %.2f%n",grand);
    }
}
