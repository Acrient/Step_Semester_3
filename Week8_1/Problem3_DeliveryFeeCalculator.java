import java.util.*;
public class Problem3_DeliveryFeeCalculator {
    interface Delivery { double fee(double weight, double distance, double customs); String type(); }
    static class Standard implements Delivery {
        public double fee(double w,double d,double c){ return 5 + .50*w + .10*d; }
        public String type(){ return "STANDARD"; }
    }
    static class Express implements Delivery {
        public double fee(double w,double d,double c){ return 15 + w + .20*d; }
        public String type(){ return "EXPRESS"; }
    }
    static class International implements Delivery {
        public double fee(double w,double d,double c){ return 25 + 2*w + .50*d + c; }
        public String type(){ return "INTERNATIONAL"; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i=0;i<n;i++) {
            String[] p=sc.nextLine().trim().split("\\s+");
            double w=Double.parseDouble(p[1]), d=Double.parseDouble(p[2]);
            double c=p.length>3?Double.parseDouble(p[3]):0;
            Delivery x=p[0].equals("STANDARD")?new Standard():
                        p[0].equals("EXPRESS")?new Express():new International();
            double f=x.fee(w,d,c);
            System.out.printf("%s: %.2f%n",x.type(),f);
            total+=f;
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
