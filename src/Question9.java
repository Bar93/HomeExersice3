import java.util.Random;
import java.util.Scanner;

public class Question9 {

    public static void main (String [] args){
       play();
    }
    public static String  getRndCode() { //מקבל קוד סודי ע"פ הגדרה
        Random r1 = new Random();
        String code = "";
        int num = r1.nextInt(6) +1;
        while (code.length()<4){
            if (isContain(code,num)==true){
                code = code+num;
            }
            num = r1.nextInt(6) +1;
        }
        System.out.println(code);
        return code;
        }
        public static boolean isContain (String st, int num){ //בודק שהקוד הסודי לא מכיל מספר פעמיים
        boolean result =true;
        for (int i=0; i<st.length(); i++){
            int num1=st.charAt(i)-48;
            if(num1==num){
                result = false;
                break;
            }
        }
        return result;
        }
        public static String getGussFromUser (){ //מקבל ניחוש מהיוזר ובודק תקינות
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a guss");
            String guss = scanner.nextLine();
            boolean checkGuss =true;
            for (int i = 0; i < guss.length(); i++) {
                if (guss.charAt(i) < '1' || guss.charAt(i) > '6') {
                    checkGuss = false;
                }
            }
            if (guss.length()!=4 ||checkGuss==false)
                while (guss.length()!=4 || checkGuss==false ) {
                    for (int i = 0; i < guss.length(); i++) {
                    if (guss.charAt(i) < '1' || guss.charAt(i) > '6') {
                        checkGuss = false;
                    }
                    else {
                        checkGuss = true;
                    }
                }
                    System.out.println("Enter a guss with four numbers between 1-6");
                    guss = scanner.nextLine();
                }
                 return guss;
    }

                public static int getDifficultFromUser () { //מקבל את רמת הקושי הרצויה מהיוזר
                    Scanner scanner = new Scanner(System.in);
                    int numGuss;
                    System.out.println("enter the difficult you want:");
                    System.out.println("1. easy: 20 Guess");
                    System.out.println("2. medium: 15 Guess");
                    System.out.println("3. hard: 10 Guess");
                    System.out.println("4. surprise: 5-25 Guess");
                    numGuss = scanner.nextInt();
                    if (numGuss < 1 || numGuss > 4) {
                        while ((numGuss < 1 || numGuss > 4)) {
                            System.out.println("Enter a correct option between 1-4");
                            numGuss = scanner.nextInt();
                        }
                    }
                    return numGuss;
                }
                public static int numOfGuss (int numGuss){ //מחזיר את כמות הניחושים לפי המספר שהיוזר בחר
                    Random r1 = new Random();
                    int random = r1.nextInt(21) + 5;
                    if (numGuss==1) {
                        numGuss = 20;
                    }
                    if (numGuss==2) {
                        numGuss = 15;
                    }
                    if (numGuss==3) {
                        numGuss = 10;
                    }
                    if (numGuss==4) {
                        numGuss = random;
                    }
                    return numGuss;
                }

                public static int checkGuss (String code, String guss){ //בודק שהניחוש נכון, כמה פגיעה חלקית ופגיעה מלאה יש
                int countHalfHit = 0,countFullHit =0;
                int index1=0, index2=0;
                while (index1<code.length()){
                    while (index2<guss.length()){
                        if ((code.charAt(index1)==guss.charAt(index2) && (index1==index2))){
                            countFullHit++;
                        }
                        if ((code.charAt(index1)==guss.charAt(index2)) && (index1!=index2)){
                            countHalfHit++;
                        }
                        index2++;
                    }
                    index1++;
                    index2=0;
                }
                System.out.println("you have " +countHalfHit + " half hit");
                System.out.println("you have " +countFullHit + " full hit");
                return countFullHit;
                }

                public static void play () { //פונקציה שמנהלת את המשחק ובודקת האם יש ניצחון או לא
                    String code = getRndCode();
                    int userChoice = getDifficultFromUser();
                    int numOfGuss = numOfGuss(userChoice);
                    int countGuss = 0;
                    String guss = getGussFromUser();
                    int countFullHit;
                    while (numOfGuss > 1) {
                        countFullHit = checkGuss(code, guss);
                        countGuss++;
                        if (countFullHit < 4) {
                            if (userChoice != 4) {
                                System.out.println("Try again, you use " + countGuss + " guss from " + numOfGuss + " of your guss");
                                guss = getGussFromUser();
                            } else {
                                guss = getGussFromUser();
                            }
                        }
                        if (countFullHit == 4) {
                            System.out.println("Congratulations you win with " + countGuss + " guess");
                            break;
                        }
                        if (checkDupleNum(guss) == false) {
                            numOfGuss = numOfGuss - 2;
                        } else {
                            numOfGuss--;
                        }
                    }

                        System.out.println("Nice try");

                }

            public static boolean checkDupleNum (String guss) // פונקציה שבודקת האם בניחוש של המשתמש יש בחירה כפולה
            {
                int index1=0, index2=0;
                boolean answer = true;
                while (index1<guss.length()){
                    while (index2<guss.length()){
                    if  ((guss.charAt(index1)==guss.charAt(index2))){
                        if (index1!=index2) {
                            answer = false;
                            break;
                        }
                    }
                    index2++;
                    }
                    if (answer ==false){
                        break;
                    }
                    index1++;
                    index2 = 0;
                }
                return answer;
            }
}









