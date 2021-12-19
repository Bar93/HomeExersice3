import java.util.Scanner;

public class Question6 {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("enter a exersice");
         String exersice= scanner.nextLine();
         if (isCorrectCh(exersice)==false || isCorrectOrder(exersice)==false) {
            while ((isCorrectCh(exersice) == false || isCorrectOrder(exersice) == false)) {
           System.out.println("enter correct exersice");
          exersice = scanner.nextLine();
        }
        }
        System.out.println(calculation(exersice));
    }

    public static boolean isCorrectCh(String st) { // בודק שיש שימוש בתווים נכונים בלבד
        boolean result = true;
        int index = 0;
        while (index < st.length()) {
            if ((st.charAt(index) < 40 || st.charAt(index) == 44 || st.charAt(index) == 46 || st.charAt(index) > 57) && st.charAt(index) != 94) {
                result = false;
                break;
            }
            index++;
        }
        return result;
    }

    public static boolean isCorrectOrder(String st) {  //בודק שיש סדר נכון במחרוזת
        boolean result = true;
        int index = 0;
        while (index < st.length() - 1) {
            if ((st.charAt(0) < 48 || st.charAt(0) > 57) && (st.charAt(0) != 40)) {
                result = false;
                break;
            }
            if ((st.charAt(st.length() - 1) < 48 || st.charAt(st.length() - 1) > 57) && (st.charAt(st.length() - 1) != 41)) {
                result = false;
                break;
            }
            if (st.charAt(index) == st.charAt(index + 1)) {
                result = false;
                break;
            }
            if (st.charAt(index) == 40 && index != 0) {
                if (st.charAt(index - 1) != 42 && st.charAt(index - 1) != 43 && st.charAt(index - 1) != 45 && st.charAt(index - 1) != 47 && st.charAt(index - 1) != 94) {
                    result = false;
                    break;
                }
            }
            if (st.charAt(index) == 41 && index != st.length() - 1) {
                if (st.charAt(index + 1) != 42 && st.charAt(index + 1) == 43 && st.charAt(index + 1) == 45 && st.charAt(index + 1) == 47 && st.charAt(index + 1) != 94) {
                    result = false;
                    break;
                }
            }
            index++;
            if (st.charAt(index)==40)
            if (checkBrackets(st) == false) {
                result = false;
            }
        }
        return result;
    }

    public static boolean checkBrackets(String st) { // בודק שהסוגריים תקינים
        int indexCh1 = 0, indexCh2 = -1;
        boolean result = true;
        int index = 0;
        while (st.charAt(index) != 40 && st.length() > index) {
            index++;
            indexCh1 = index;


        }
        index = 0;
        while (st.charAt(index) != 41 && st.length() > index) {
            indexCh2 = index;
            index++;
        }
        if (indexCh2 < indexCh1) {
            result = false;
        }
        if ((indexCh2 == -1 && indexCh1 > -1) || (indexCh1 == -1 && indexCh2 > -1)) {
            result = false;
        }
        return result;
    }

    public static int[] translate(String st) { //מתרגם את הביטוי ומכניס למערך מסוט אינט
        int index = 0;
        int num;
        int[] translateSt = new int[st.length()];
        while (index < st.length()) {
            if (st.charAt(index) > 47 && st.charAt(index) < 58) {
                num = st.charAt(index) - 48;
                translateSt[index] = num;
            } else {
                translateSt[index] = st.charAt(index);
            }
            index++;
        }
        return translateSt;
    }

    public static int sum(int num1, int num2, int sigh) { //מבצע סכום של שתי מספרים
        int sum = 0;
        if (sigh == 45) {
            sum = (num1) - (num2);
        }
        if (sigh == 43) {
            sum = (num1) + (num2);
        }
        return sum;
    }

    public static int duplicateDivision(int num1, int num2, int sigh) { //מבצע כפל של שני מספרים
        int sum = 0;
        if (sigh == 47) {
            sum = (num1) / (num2);
        }
        if (sigh == 42) {
            sum = (num1) * (num2);
        }
        return sum;
    }

    public static int pow(int num, int pow) { //מבצע חזקה של שני מספרים
        int sum = 1;
        for (int i = 0; i < pow; i++) {
            sum = sum * (num);
        }
        return sum;
    }

    public static int openBrackets(int num1, int num2, int sigh) { //פותח סוגריים ומחזיר את הערך שלהם
        int brackets = 0;
        if (sigh == 43 || sigh == 45) {
            brackets = sum(num1, num2, sigh);
        }
        if (sigh == 42 || sigh == 47) {
            brackets = duplicateDivision(num1, num2, sigh);
        }
        if (sigh == 94) {
            brackets = pow(num1, num2);
        }
        return brackets;
    }

    public static int calculation(String st) { //מחשב את הביטוי החשבוני - סדר המערכים הוא ע"פ סדר פעולות חשבון
        int expressions[] = translate(st);
        int[] arrWithoutBrackets = new int[expressions.length];
        int pow, dup, plus, brackets = 0;
        int index1 = 0, index2 = 0;
        int sigh;
        int sum = 0;
        while (index1 < expressions.length) {
            if (expressions[index1] == 40) {
                sigh = expressions[index1 + 2];
                brackets = openBrackets(expressions[index1 + 1], expressions[index1 + 3], expressions[index1 + 2]);
                arrWithoutBrackets[index2] = brackets;
                index1 = index1 + 4;
                index2++;
                if (index1 >= expressions.length) {
                    break;
                }
            } else {
                arrWithoutBrackets[index2] = expressions[index1];
                index2++;
            }
            index1++;
        }
        index1 = 0;
        int[] arrWithoutPow = new int[arrWithoutBrackets.length];
        index2 = 0;
        while (index1 < arrWithoutBrackets.length) {
            if (arrWithoutBrackets[index1] == 94) {
                sigh = arrWithoutBrackets[index1];
                pow = pow(arrWithoutBrackets[index1-1], arrWithoutBrackets[index1+1]);
                arrWithoutPow[index2-1] = pow;
                index1 = index1 + 1;
                if (index1 >= arrWithoutBrackets.length) {
                    break;
                }
            } else {
                arrWithoutPow[index2] = arrWithoutBrackets[index1];
                index2++;
            }
            index1++;
        }
        index1 = 0;
        int[] arrWithoutDup = new int[arrWithoutPow.length];
        index2 = 0;
        while (index1 < arrWithoutPow.length) {
            if (arrWithoutPow[index1] == 42 || arrWithoutPow[index1] == 47) {
                sigh = arrWithoutPow[index1];
                dup = duplicateDivision(arrWithoutPow[index1-1], arrWithoutPow[index1+1], arrWithoutPow[index1]);
                arrWithoutDup[index2-1] = dup;
                index1=index1+1;
                if (index1 >= arrWithoutPow.length) {
                    break;
                }
            } else {
                arrWithoutDup[index2] = arrWithoutPow[index1];
                index2++;
            }
            index1++;
        }
        index1 = 0;
        int[] arrWithoutPlus = new int[arrWithoutDup.length];
        index2 = 0;
        while (index1 < arrWithoutDup.length) {
            if (arrWithoutDup[index1] == 43 || arrWithoutDup[index1] == 45) {
                sigh = arrWithoutPow[index1];
                plus = sum(arrWithoutDup[index1-1], arrWithoutDup[index1 +1], arrWithoutDup[index1]);
                arrWithoutPlus[index2-1] = plus;
                index1 = index1 + 2;
                if (index1 >= arrWithoutDup.length) {
                    break;
                }
            } else {
                arrWithoutPlus[index2] = arrWithoutDup[index1];
                index2++;
            }
            index1++;
        }
        index1=0;
        while (index1<arrWithoutPlus.length){
            if (arrWithoutPlus[index1]!=43 && arrWithoutPlus[index1]!=45) {
                sum = sum + arrWithoutPlus[index1];
            }
            index1++;
        }
        return sum;
    }
}

