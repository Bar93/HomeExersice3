import java.util.Scanner;

public class Question1 {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        int num;
        System.out.println("Enter the size of array");
        int [] arr = new int[scanner.nextInt()];
        while (index< arr.length){
            System.out.println("Enter num");
            num = scanner.nextInt();
            if (num<0) {
                while (num < 0) {
                    System.out.println("Enter correct num");
                    num = scanner.nextInt();
                }
            }
            arr[index] = num;
            index++;
        }
        System.out.println("The biggest sum on switched num in array is in cell number " + checkSmallSum(arr));
    }

    public static boolean checkIfNumSwitch(int num) { //בודק שהמספר הוא מספר מתחלף
        int unity, dozens;
        boolean result = true;
        if (num > 0 && num < 10) {
            result = true;
            return result;
        }
        if (num > 9) {
            while (num > 9 && result == true) {
                unity = num % 10;
                dozens = num / 10;
                if ((dozens % 2 == 0 && unity % 2 != 0) || (dozens % 2 != 0 && unity % 2 == 0)) {
                    result = true;
                } else {
                    result = false;
                }
                num = num / 10;
            }
        }
        return result;
    }

    public static int checkSmallSum(int[] arr) { //בודק את הסכום הקטן ביותר של המספרים המתחלפים
        int index = 0, sum=0, smallestSum = 999, smallestIndex =-1;
        while (index < arr.length) {
            if (checkIfNumSwitch(arr[index]) == true) {
                sum = 0;
                while (arr[index] != 0) {
                    sum = sum + arr[index] % 10;
                    arr[index] = arr[index] / 10;
                }
                if (sum < smallestSum) {
                    smallestSum = sum;
                    smallestIndex = index;
                }
            }
            index++;
        }
        return smallestIndex;
    }
}
