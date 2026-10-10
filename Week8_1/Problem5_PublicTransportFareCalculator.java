import java.util.*;
public class Problem5_PublicTransportFareCalculator {
    interface Transport { double fare(double distance,double factor); String type(); }
    static class Bus implements Transport {
        public double fare(double d,double f){ return Math.min(10,2+.10*d); }
        public String type(){return "BUS";}
    }
    static class Train implements Transport {
        public double fare(double d,double f){ return 3+.15*d; }
        public String type(){return "TRAIN";}
    }
    static class Metro implements Transport {
        public double fare(double d,double f){ return (1.50+.20*d)*f; }
        public String type(){return "METRO";}
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); int n=Integer.parseInt(sc.nextLine().trim()); double total=0;
        for(int i=0;i<n;i++) {
            String[] p=sc.nextLine().trim().split("\\s+");
            double d=Double.parseDouble(p[1]), factor=p.length>2?Double.parseDouble(p[2]):1;
            Transport t=p[0].equals("BUS")?new Bus():p[0].equals("TRAIN")?new Train():new Metro();
            double f=t.fare(d,factor); System.out.printf("%s: %.2f%n",t.type(),f); total+=f;
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
