import java.util.Scanner;

public class Question4 {

    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 0, num = -1;
        System.out.println("Enter the size of array");
        int[] arr = new int [scanner.nextInt()];
      while (index < arr.length)
        {
            System.out.println("Enter num");
            num = scanner.nextInt();
            if (num<0) {
             while (num < 0) {
             System.out.println("Enter positive num");
             num = scanner.nextInt();
               }
            }
               arr[index] = num;
               index++;
        }
        System.out.println(isFullyArrey(arr));
    }
      public static boolean checkIfFullArray (int [] arr){ //בודק אם המערך הוא מלא ע"פ עיקרון שאם כמות המספרים שיש במערך שווה להפרש בין המספר הגדול ביותר לקטן ביותר אז המערך מלא
        int index1 = 0,index2=0, minNum = arr[0] ,maxNum=arr[0];
        int counterDuplicateNum = 0;
        boolean ifFully = false;
        while (index1<arr.length) {
            while (index2 < arr.length) {
                if (arr[index2] < minNum) {
                    minNum = arr[index2];
                }
                if (arr[index2] > maxNum) {
                    maxNum = arr[index2];
                }
                if (arr[index2]==arr[index1] && index2!=index1){
                    counterDuplicateNum++;
                }
                index2++;
            }
            index1++;
            index2=0;
        }
        if ((maxNum - minNum) == arr.length-1){
            if (counterDuplicateNum==0){
                ifFully = true;
            }
        }
        return ifFully;
    }

public static boolean isFullyArrey (int [] arr){ //מקבל מערך ובודקת האם המערך הוא מלא
        return checkIfFullArray(arr);
}

}
