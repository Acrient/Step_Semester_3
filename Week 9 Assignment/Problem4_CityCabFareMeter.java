import java.util.*;
abstract class Cab {
    double km; Cab(double k){km=k;}
    abstract double rate();
    double fare(){return Math.max(100,km*rate());}
}
interface NightService { double nightFare(double fare); }
public class Problem4_CityCabFareMeter {
    static class Mini extends Cab { Mini(double k){super(k);} double rate(){return 10;} }
    static class Sedan extends Cab implements NightService { Sedan(double k){super(k);} double rate(){return 14;} public double nightFare(double f){return f*1.2;} }
    static class SUV extends Cab implements NightService { SUV(double k){super(k);} double rate(){return 18;} public double nightFare(double f){return f*1.2;} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next();double km=sc.nextDouble();String time=sc.next();
            Cab c=type.equals("MINI")?new Mini(km):type.equals("SEDAN")?new Sedan(km):new SUV(km);
            if(time.equals("NIGHT") && !(c instanceof NightService)){System.out.println(type+": night service not available");continue;}
            double f=c.fare();if(time.equals("NIGHT"))f=((NightService)c).nightFare(f);
            System.out.printf("%s: %.2f%n",type,f);total+=f;
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
