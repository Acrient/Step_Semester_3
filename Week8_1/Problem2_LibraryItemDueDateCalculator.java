import java.time.LocalDate;
import java.util.*;
public class Problem2_LibraryItemDueDateCalculator {
    interface LibraryItem { int loanDays(); }
    static class Book implements LibraryItem { public int loanDays(){ return 14; } }
    static class DVD implements LibraryItem { public int loanDays(){ return 7; } }
    static class Magazine implements LibraryItem { public int loanDays(){ return 3; } }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate today = LocalDate.parse("2023-10-26");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));
            LibraryItem item = type.equals("BOOK") ? new Book() :
                               type.equals("DVD") ? new DVD() : new Magazine();
            System.out.println(title + ": " + today.plusDays(item.loanDays()));
        }
    }
}
