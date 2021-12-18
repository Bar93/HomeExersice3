import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number");
        int num = scanner.nextInt();
        while (num<0){
            System.out.println("enter correct number");
            num = scanner.nextInt();
        }
        if (checkIfPrime(num)==true){
            System.out.println(num + "," + 1);
        }
        else {
            int index = 0;
            while (index < factorization(num).length) {
                System.out.print(factorization(num)[index] + " * ");

                index++;
            }
        }
    }

    public static int[] factorization(int num) { //מפרק לגורמים
        int primeNum = 2;
        int counterAtoms = 0;
        int tempNum = num;
        int index=0;
        while (primeNum<num) {
            if (checkIfPrime(primeNum) == true) {
                while (tempNum % primeNum == 0) {
                    counterAtoms++;
                    tempNum = tempNum / primeNum;
                }
            }
            primeNum++;
        }
        primeNum = 2;
        int[] arr = new int[counterAtoms];
        while (index < arr.length) {
            if (checkIfPrime(primeNum) == true) {
                while (num % primeNum == 0) {
                    arr[index] = primeNum;
                    num = num / primeNum;
                    index++;
                }
            }
            primeNum++;
        }
        return arr;
    }
    public static boolean checkIfPrime (int prime){ //בודק אם המספר ראשוני
        int counterIfPrime = 0;
        boolean ifPrime;
        int dividerPrime = 1;
        while (dividerPrime <= prime) {
            if (prime % dividerPrime == 0) {
                counterIfPrime++;
            }
            dividerPrime++;
        }
        if (counterIfPrime == 2) {
            ifPrime = true;
        }
        else {
            ifPrime = false;
        }
        return ifPrime;
    }
}

