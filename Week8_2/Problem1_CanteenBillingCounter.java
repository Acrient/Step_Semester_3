import java.util.*;
public class Problem1_CanteenBillingCounter {
    interface Customer { double amount(double bill); String type(); }
    static class Student implements Customer {
        public double amount(double b){return b*.90;} public String type(){return "STUDENT";}
    }
    static class Staff implements Customer {
        public double amount(double b){return b*.95;} public String type(){return "STAFF";}
    }
    static class Guest implements Customer {
        public double amount(double b){return b+10;} public String type(){return "GUEST";}
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int n=Integer.parseInt(sc.nextLine().trim()); double total=0;
        for(int i=0;i<n;i++){
            String[] p=sc.nextLine().trim().split("\\s+");
            Customer c=p[0].equals("STUDENT")?new Student():p[0].equals("STAFF")?new Staff():new Guest();
            double v=c.amount(Double.parseDouble(p[1]));
            System.out.printf("%s: %.2f%n",c.type(),v); total+=v;
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
