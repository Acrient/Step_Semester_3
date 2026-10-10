import java.util.*;
abstract class Ticket {
    static final double CONVENIENCE_FEE=20.0;
    int count; Ticket(int c){count=c;}
    abstract double price();
    double amount(){return count*(price()+CONVENIENCE_FEE);}
    abstract String seat();
}
public class Problem1_MovieTicketCounter {
    static class Regular extends Ticket { Regular(int c){super(c);} double price(){return 150;} String seat(){return "REGULAR";} }
    static class Premium extends Ticket { Premium(int c){super(c);} double price(){return 250;} String seat(){return "PREMIUM";} }
    static class Recliner extends Ticket { Recliner(int c){super(c);} double price(){return 400;} String seat(){return "RECLINER";} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;
        for(int i=0;i<n;i++){
            String s=sc.next();int c=sc.nextInt();Ticket t=s.equals("REGULAR")?new Regular(c):s.equals("PREMIUM")?new Premium(c):new Recliner(c);
            double a=t.amount();System.out.printf("%s: %.2f%n",t.seat(),a);total+=a;
        }
        System.out.printf("Total: %.2f%n",total);
    }
}
