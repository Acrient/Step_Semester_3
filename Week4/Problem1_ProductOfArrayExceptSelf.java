import java.util.Arrays;
import java.util.Scanner;

public class Problem1_ProductOfArrayExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int product = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = product;
            product *= nums[i];
        }

        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= product;
            product *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        sc.close();
    }
}
