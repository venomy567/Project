import java.util.Scanner;



public class Main {
    private static String sign = "";
    private static String[] rimNumber = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
    private static boolean RimOrArab=false;
    private static int rimOnArab1;
    private static int rimOnArab2;
    private static boolean checkSign=false;

    public static void main(String[] args) throws ThrowExeption {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        checkSign(input); // нашли знак

        checkRim(input); //проверили на арабские
        exceptionTrows();//проверка на исключения
        String result = calc(input);

        System.out.println(result);

    }

    public static void checkSign(String input) {
        String[] action = {"+", "/", "-", "*"};
        String[] resetAction = {"\\+", "/", "-", "\\*"};
        int actionIndex=-1;

        for (int i = 0; i < action.length; i++)
            if (input.contains(action[i])) {
                actionIndex = i;
            }

        sign=resetAction[actionIndex];
    }

    public static String calc(String input) throws ThrowExeption {
        RimConvert rimConvert = new RimConvert();
        String[] splitString = input.split(sign);
        String result;
        int a;
        int b;
        int c;
        if (RimOrArab) {
            a = rimOnArab1;
            b = rimOnArab2;

        } else {
            splitString[0] = splitString[0].replaceAll("\\s+", "");
            splitString[1] = splitString[1].replaceAll("\\s+", "");

                a = Integer.parseInt(splitString[0]);
                b = Integer.parseInt(splitString[1]);
                if (a<1||a>10||b<1||b>10) throw new ThrowExeption();

        }

            switch (sign) {
                case "\\+":
                    c=a+b;
                    if (RimOrArab){
                        result = (rimConvert.converToRim(c));
                        return (result);
                    }else {
                        result = String.valueOf(c);
                        return (result);
                    }
                case "\\*":
                    c=a*b;
                    if (RimOrArab){
                        result = (rimConvert.converToRim(c));
                        return (result);
                    }else {
                        result = String.valueOf(c);
                        return (result);
                    }
                case "-":
                    c=a-b;
                    if (RimOrArab){
                        result = (rimConvert.converToRim(c));
                        return (result);
                    }else {
                        result = String.valueOf(c);
                        return (result);
                    }
                case "/":
                    c=a/b;
                    if (RimOrArab){
                        result = (rimConvert.converToRim(c));
                        return (result);
                    }else {
                        result = String.valueOf(c);
                        return (result);
                    }
                default: return "";
            }
        }
    public static void checkRim(String input) {
        String[] splitString = input.split(sign);
        if (splitString.length>2) checkSign=true; //Проверка на кол-во одинаковых знаков, если больше 2-х строк, то и знаков больше
        boolean firstNumArab=false;
        boolean secNumArab=false;

        splitString[0] = splitString[0].replaceAll("\\s+","");
        splitString[1] = splitString[1].replaceAll("\\s+","");

        for (int i=0;i<splitString.length;i++) {
            for (int j = 0; j < 10; j++) {
                if (splitString[i].equals(rimNumber[j])) {
                    if (i == 0){
                        firstNumArab = true;
                        rimOnArab1 =j+1;
                    }
                    else {
                        secNumArab = true;
                        rimOnArab2 =j+1;
                    }
                }
            }
        }
        if ((firstNumArab)&&(secNumArab)) RimOrArab=true;
    }

    public static void exceptionTrows () throws ThrowExeption {

        if (checkSign) throw new ThrowExeption();
        if (RimOrArab&&rimOnArab1/rimOnArab2<1) throw new ThrowExeption();
        if (RimOrArab&&rimOnArab1-rimOnArab2<1) throw new ThrowExeption();

    }
}


