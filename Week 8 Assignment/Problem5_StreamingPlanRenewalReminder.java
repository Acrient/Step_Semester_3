import java.time.LocalDate;
import java.util.*;
public class Problem5_StreamingPlanRenewalReminder {
    interface Plan { int days(); }
    static class Basic implements Plan { public int days(){return 30;} }
    static class Standard implements Plan { public int days(){return 90;} }
    static class Premium implements Plan { public int days(){return 365;} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int n=Integer.parseInt(sc.nextLine().trim());
        for(int i=0;i<n;i++){
            String[] p=sc.nextLine().trim().split("\\s+");
            Plan plan=p[0].equals("BASIC")?new Basic():p[0].equals("STANDARD")?new Standard():new Premium();
            System.out.println(p[1]+": "+LocalDate.parse(p[2]).plusDays(plan.days()));
        }
    }
}
