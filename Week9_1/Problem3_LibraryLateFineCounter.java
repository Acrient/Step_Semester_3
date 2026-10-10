import java.util.*;
abstract class LibraryItem {
    String title; int days; LibraryItem(String t,int d){title=t;days=d;}
    abstract double fine();
}
public class Problem3_LibraryLateFineCounter {
    static class Book extends LibraryItem { Book(String t,int d){super(t,d);} double fine(){return days*2.0;} }
    static class DVD extends LibraryItem { DVD(String t,int d){super(t,d);} double fine(){return Math.min(50,days*5.0);} }
    static class Magazine extends LibraryItem { Magazine(String t,int d){super(t,d);} double fine(){return days*1.0;} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int n=sc.nextInt(); double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next(),title=sc.next(); int days=sc.nextInt(); LibraryItem item;
            if(type.equals("BOOK"))item=new Book(title,days);
            else if(type.equals("DVD"))item=new DVD(title,days);
            else item=new Magazine(title,days);
            double f=item.fine();System.out.printf("%s: %.2f%n",title,f);total+=f;
        }
        System.out.printf("Total Fines: %.2f%n",total);
    }
}
