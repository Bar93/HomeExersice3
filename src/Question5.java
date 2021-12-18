import java.util.Scanner;

public class Question5 {

    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a code");
        String code = scanner.nextLine();
        replaceMostCh(code);

    }
    public static char findMostCh (String code){ //בודק מה התו הכי פופולרי
        int counter = 0, maxCh = 0;
        int index1 = 0, index2=0;
        char ch = '*';
        while (index1< code.length()){
            while (index2< code.length()){
                if (code.charAt(index1) == code.charAt(index2)){
                    counter++;
                }
                index2++;
            }
            if (counter>maxCh){
                maxCh=counter;
                ch = code.charAt(index1);
            }
            counter = 0;
            index2=0;
            index1++;
        }
        return ch;
    }

    public static void replaceMostCh (String code){ // מחליף את התו הפופלרי ביותר בשני הכי פופלרי
        int counter = 0, maxCh = 0;
        int index1 = 0, index2=0;
        char ch = findMostCh(code);
        char replacedChar= '*' ;
        char [] codeArr = new char[code.length()];
        for (int i=0; i<codeArr.length; i++)
        {
            codeArr[i] = code.charAt(i);
        }
        while (index1< code.length()){
            while (index2< code.length()){
                if ((code.charAt(index1) == code.charAt(index2)) && code.charAt(index1)!=ch){
                    counter++;
                }
                index2++;
            }
            if (counter>maxCh){
                maxCh=counter;
                replacedChar = code.charAt(index1);
            }
            counter = 0;
            index1++;
            index2=0;
        }
        index1=0;
         while (index1< codeArr.length){
                if (code.charAt(index1) == ch)
                {
                    codeArr[index1] = replacedChar;
                }
                index1++;
            }
         System.out.println(codeArr);
    }
}
