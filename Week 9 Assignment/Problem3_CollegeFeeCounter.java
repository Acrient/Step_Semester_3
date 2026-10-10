import java.util.*;
abstract class Student {
    String name; Student(String n){name=n;}
    abstract double tuition();
    double transportFee(){return this instanceof BusUser?12000:0;}
    double totalFee(){return tuition()+transportFee();}
}
interface BusUser {}
public class Problem3_CollegeFeeCounter {
    static class DayScholar extends Student implements BusUser { DayScholar(String n){super(n);} double tuition(){return 40000;} }
    static class Hosteller extends Student { Hosteller(String n){super(n);} double tuition(){return 100000;} }
    static class Scholar extends Student implements BusUser { Scholar(String n){super(n);} double tuition(){return 20000;} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next(),name=sc.next();Student s=type.equals("DAY_SCHOLAR")?new DayScholar(name):type.equals("HOSTELLER")?new Hosteller(name):new Scholar(name);
            double fee=s.totalFee();System.out.printf("%s: %.2f%n",name,fee);total+=fee;
        }
        System.out.printf("Total Collected: %.2f%n",total);
    }
}
