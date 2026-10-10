import java.util.*;
public class Problem2_CampusParkingChargeCalculator {
    interface Vehicle { double charge(int hours); String type(); }
    static class Bike implements Vehicle { public double charge(int h){return 10*h;} public String type(){return "BIKE";} }
    static class Car implements Vehicle { public double charge(int h){return 30+20*(h-1);} public String type(){return "CAR";} }
    static class Truck implements Vehicle { public double charge(int h){return Math.max(100,50*h);} public String type(){return "TRUCK";} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int n=Integer.parseInt(sc.nextLine().trim()); double total=0;
        for(int i=0;i<n;i++){
            String[] p=sc.nextLine().trim().split("\\s+"); Vehicle v=p[0].equals("BIKE")?new Bike():p[0].equals("CAR")?new Car():new Truck();
            double c=v.charge(Integer.parseInt(p[1])); System.out.printf("%s: %.2f%n",v.type(),c); total+=c;
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
