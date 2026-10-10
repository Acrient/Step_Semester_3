import java.util.*;
public class Problem3_HostelElectricityBill {
    interface Room { double bill(int units); String type(); }
    static class Single implements Room { public double bill(int u){return u*8.0;} public String type(){return "SINGLE";} }
    static class Shared implements Room {
        int occupants; Shared(int o){occupants=o;}
        public double bill(int u){return u*6.0/occupants;} public String type(){return "SHARED";}
    }
    static class AC implements Room { public double bill(int u){return u*10.0+200;} public String type(){return "AC";} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int n=Integer.parseInt(sc.nextLine().trim()); double total=0;
        for(int i=0;i<n;i++){
            String[] p=sc.nextLine().trim().split("\\s+"); int units=Integer.parseInt(p[1]);
            Room r=p[0].equals("SINGLE")?new Single():p[0].equals("SHARED")?new Shared(Integer.parseInt(p[2])):new AC();
            double b=r.bill(units); System.out.printf("%s: %.2f%n",r.type(),b); total+=b;
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
