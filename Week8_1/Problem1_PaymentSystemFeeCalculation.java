import java.util.*;
public class Problem1_PaymentSystemFeeCalculation {
    interface Payment { double finalAmount(double amount); String type(); }
    static class Card implements Payment {
        public double finalAmount(double a) { return a * 1.02; }
        public String type() { return "CARD"; }
    }
    static class Wallet implements Payment {
        public double finalAmount(double a) { return a * 1.01; }
        public String type() { return "WALLET"; }
    }
    static class BankTransfer implements Payment {
        public double finalAmount(double a) { return a; }
        public String type() { return "BANKTRANSFER"; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Payment pay = p[0].equals("CARD") ? new Card() :
                          p[0].equals("WALLET") ? new Wallet() : new BankTransfer();
            double amount = pay.finalAmount(Double.parseDouble(p[1]));
            System.out.printf("%s: %.2f%n", pay.type(), amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
