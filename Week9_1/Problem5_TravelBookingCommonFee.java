import java.util.*;
abstract class TravelBooking {
    static final double BOOKING_FEE=50.0;
    double distance; TravelBooking(double d){distance=d;}
    abstract double baseFare();
    double total(){return baseFare()+BOOKING_FEE;}
}
public class Problem5_TravelBookingCommonFee {
    static class Bus extends TravelBooking { Bus(double d){super(d);} double baseFare(){return distance*2;} }
    static class Train extends TravelBooking { Train(double d){super(d);} double baseFare(){return distance*1.5;} }
    static class Flight extends TravelBooking { Flight(double d){super(d);} double baseFare(){return 2500+distance*4;} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String mode=sc.next();double d=sc.nextDouble();
            TravelBooking b=mode.equals("BUS")?new Bus(d):mode.equals("TRAIN")?new Train(d):new Flight(d);
            System.out.printf("%s: %.2f%n",mode,b.total());
        }
    }
}
