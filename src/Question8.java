import java.util.Scanner;

public class Question8 {

    public static void main(String[] args) {
        System.out.println("The most popular sub string is  " + getMostPopular());
    }

    public static String[] getArrayOfStrings() { //מחזיר מערך של מחרוזות
        Scanner scanner = new Scanner(System.in);
        int counter = 0, index1 = 0, index2 = 0;
        String word, sentence = "";
        System.out.println("Enter a string");
        word = scanner.nextLine();
        sentence = sentence + word + "*";
        while (word.length() > 4) {
            System.out.println("Enter a string");
            counter++;
            word = scanner.nextLine();
            sentence = sentence + word + "*";
        }
        String[] array = new String[counter + 1];
        String wordNew = "";
        while (index1 < sentence.length()) {
            if (sentence.charAt(index1) != '*') {
                while (sentence.charAt(index1) != '*') {
                    wordNew += sentence.charAt(index1);
                    index1++;
                }
            } else {
                index1++;
                array[index2] = wordNew;
                index2++;
                wordNew = "";
            }
        }
        return array;
    }

    public static String[] getSubString(String st) { //מחזיר את התת מחרוזות
        int counter = 0, index = 0;
        String subSt = "";
        int lengthArr = 0;
        int jump = 2;
        int[] optionArr = new int[st.length() - 1];
        for (int x = 1; x < st.length(); x++) {
            lengthArr += x; // כמות האפשרויות לתתי מחרוזות הינה סכום אורך המחרוזת ללא האורך עצמו.
            // לדוגמא: מחרוזת 4 ישנם 6 צירופים (3+2+1),
            // מחרוזת 7 ישנם 21 צירופים (1+2+3+4+5+6)
            optionArr[x - 1] = st.length() - x;
        }
        int index2 = 0, index3 = 0;
        String[] array = new String[lengthArr];
        int x = optionArr.length - 1;
        while (index < array.length) {
            while (index2 < st.length()) {
                for (int i = 0; i < jump; i++) {
                    subSt += st.charAt(index2);
                    index2++;
                }
                array[index] = subSt;
                subSt = "";
                index2 = index2 - optionArr[x];
                index++;
                counter++;
                if (counter == optionArr[index3]) {
                    index3++;
                    x--;
                    counter = 0;
                    break;
                }
            }
            index2 = 0;
            jump++;
        }

        return array;
    }

    public static String getMostPopular() { //מחזירה את התת מחרוזת הכי פופולרית
        int counter = 0, maxSt = 0;
        int index1 = 0, index2 = 0;
        String mostPopular = "";
        String[] stArray = unionSubSt();
        while (index1 < stArray.length) {
            while (index2 < stArray.length) {
                if (equalsSt(stArray[index1], stArray[index2]) == true) {
                    counter++;
                }
                index2++;
            }
            if (counter > maxSt) {
                maxSt = counter;
                mostPopular = stArray[index1];
            }
            index2 = 0;
            index1++;
            counter = 0;
        }
        return mostPopular;
    }

    public static String[] unionSubSt() { //מאחדת את כל המערכים למערך אחד
        int size = 0, index = 0, index2 = 0, index3 = 0;
        String[] array = getArrayOfStrings();
        while (index < array.length) {
            size = size + getSubString(array[index]).length;
            index++;
        }
        String[] subStArr = new String[size];
        index = 0;
        while (index < subStArr.length) {
            while (index2 < getSubString(array[index3]).length) {
                String[] tempArr = getSubString(array[index3]);
                subStArr[index] = tempArr[index2];
                index2++;
                index++;
            }
            index2 = 0;
            index3++;
        }
        return subStArr;
    }

    public static boolean equalsSt(String st1, String st2) { // פונקציה שיעודה הוא לבדוק השוואת מחרוזות בין מערכים כדי לוודא שכאשר המחרוזת זהה אך הכתובת שונה זה עדיין יחזיר חיובי
        boolean result = true;
        int index1 = 0;
        if (st1.length() == st2.length()) {
            while (index1 < st1.length() && result == true) {
                if (st1.charAt(index1) != st2.charAt(index1)) {
                    result = false;
                }
                index1++;
            }
        }
        else {
            result=false;
        }
        return result;
    }
}






