import java.util.*;
abstract class Appliance {
    double hours; Appliance(double h){hours=h;}
    abstract double power();
    double units(){return power()*hours/1000.0;}
}
interface SaverMode { }
public class Problem5_HomeApplianceEnergyReport {
    static class Fridge extends Appliance { Fridge(double h){super(h);} double power(){return 150;} }
    static class AC extends Appliance implements SaverMode { AC(double h){super(h);} double power(){return 1500;} }
    static class TV extends Appliance { TV(double h){super(h);} double power(){return 100;} }
    static class Washer extends Appliance implements SaverMode { Washer(double h){super(h);} double power(){return 500;} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);int n=Integer.parseInt(sc.nextLine().trim());double total=0;
        for(int i=0;i<n;i++){
            String[] p=sc.nextLine().trim().split("\\s+");
            String type=p[0];double h=Double.parseDouble(p[1]);boolean saver=p.length>2&&p[2].equals("SAVER");
            Appliance a=type.equals("FRIDGE")?new Fridge(h):type.equals("AC")?new AC(h):type.equals("TV")?new TV(h):new Washer(h);
            if(saver && !(a instanceof SaverMode)){System.out.println(type+": saver mode not supported");continue;}
            double u=a.units()*(saver?.75:1),cost=u*8;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n",type,u,cost);total+=cost;
        }
        System.out.printf("Total Cost: %.2f%n",total);
    }
}
