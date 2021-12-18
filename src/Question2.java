import java.util.Scanner;

public class Question2 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        int index1 = 0, index2 = 0;
        int num;
        System.out.println("Enter the size of array one");
        int[] arr1 = new int[scanner.nextInt()];
        while (index1 < arr1.length) {
            System.out.println("Enter num");
            num = scanner.nextInt();
            arr1[index1] = num;
            index1++;
        }
        System.out.println("Enter the size of array two");
        int[] arr2 = new int[scanner.nextInt()];
        while (index2 < arr2.length) {
            System.out.println("Enter num");
            num = scanner.nextInt();
            arr2[index2] = num;
            index2++;
        }
        if (checkProximityLevel(arr1,arr2) == 0){
            System.out.println("no have proximity number");
        }
        else {
            System.out.println("The num with the biggest proximity is in cell number " + checkProximityLevel(arr1,arr2));
        }
    }
    public static int checkProximityLevel (int [] array1, int [] array2){ //בודק רמת קרבה
        int index1 = 0, index2=0;
        int sumArr1 = 0;
        int sumArr2 = 0;
        int counter=0;
        int index3;
        int proximityLevel = 0;
        int resultIndex=0;
        while (index2 < array2.length) {
            int[] tempArr2 = new int[array2.length];
            index3 = 0;
            while (index3<tempArr2.length){
                tempArr2[index3] = array2[index3];
                index3++;
            }
            while (tempArr2[index2] > 0) {
                sumArr2 = sumArr2 + tempArr2[index2] % 10;
                tempArr2[index2] = tempArr2[index2] / 10;
            }
            while (index1 < array1.length){
                int[] tempArr1 = new int[array1.length];
                index3 = 0;
                while (index3<tempArr1.length) {
                    tempArr1[index3] = array1[index3];
                    index3++;
                }
                while (tempArr1[index1] > 0) {
                    sumArr1 = sumArr1 + tempArr1[index1] % 10;
                    tempArr1[index1] = tempArr1[index1] / 10;
                }
            if (sumArr1 == sumArr2) {
                counter++;
            }
            index1++;
            sumArr1 = 0;
        }
            if (counter>proximityLevel) {
                proximityLevel = counter;
                resultIndex = index2;
            }
            index2++;
            sumArr2 = 0;
            counter=0;
            index1 = 0;
        }
        resultIndex++;
        if (proximityLevel == 0){
            resultIndex = 0;
        }
        return resultIndex;
    }
}
