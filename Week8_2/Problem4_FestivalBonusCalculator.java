import java.util.*;
public class Problem4_FestivalBonusCalculator {
    interface Employee { double bonus(double salary); String name(); }
    static class FullTime implements Employee {
        String n; FullTime(String n){this.n=n;} public String name(){return n;} public double bonus(double s){return s*.10;}
    }
    static class PartTime implements Employee {
        String n; PartTime(String n){this.n=n;} public String name(){return n;} public double bonus(double s){return s*.05;}
    }
    static class Intern implements Employee {
        String n; Intern(String n){this.n=n;} public String name(){return n;} public double bonus(double s){return 2000;}
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int n=Integer.parseInt(sc.nextLine().trim()); double total=0;
        for(int i=0;i<n;i++){
            String[] p=sc.nextLine().trim().split("\\s+");
            Employee e=p[0].equals("FULLTIME")?new FullTime(p[1]):p[0].equals("PARTTIME")?new PartTime(p[1]):new Intern(p[1]);
            double b=e.bonus(Double.parseDouble(p[2])); System.out.printf("%s: %.2f%n",e.name(),b); total+=b;
        }
        System.out.printf("Total Bonus: %.2f%n",total);
    }
}
