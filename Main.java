import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your calculation: ");
        System.out.println(calculate(sc.nextLine()));

    }

    public static double calculate(String s) {
        int size = s.length();
        int index1 = 0;
        int index2 = 0;

        if (s.contains("(")) {
            index1 = s.indexOf("(");
            //starts from the end of the calculation to find the index of the end paranthesis
            for (int i = size - 1; i >= 0; i--) {
                if (s.substring(i, i + 1).equals(")")) {
                    index2 = i;
                    break;
                }
            }
            s = s.substring(0, index1) + calculate(s.substring(index1 + 1, index2)) + s.substring(index2 + 1);
        }

        index1 = 0;
        index2 = size;


        if (s.contains("^")) {
            int carrotIndex = s.indexOf("^");
            for (int i = carrotIndex - 1; i >= 0; i--) {
                try {
                    Integer.parseInt(s.substring(i, i + 1));
                } catch (Exception e) {
                    index1 = i + 1;
                    break;
                }
            }
            for (int i = carrotIndex + 1; i < size; i++) {
                try {
                    Integer.parseInt(s.substring(i, i + 1));
                } catch (Exception e) {
                    index2 = i;
                    break;
                }
            }

            double answer = Math.pow(Integer.parseInt(s.substring(index1, carrotIndex)), Integer.parseInt(s.substring(carrotIndex + 1, index2)));
            s = s.substring(0, index1) + answer + s.substring(index2);
        }

        for (int i = 0; i < size; i++) {
            if (s.substring(i, i + 1).equals("*")) {
                int carrotIndex = s.indexOf("^");
            for (int i = carrotIndex - 1; i >= 0; i--) {
                try {
                    Integer.parseInt(s.substring(i, i + 1));
                } catch (Exception e) {
                    index1 = i + 1;
                    break;
                }
            }
            for (int i = carrotIndex + 1; i < size; i++) {
                try {
                    Integer.parseInt(s.substring(i, i + 1));
                } catch (Exception e) {
                    index2 = i;
                    break;
                }
            }

            double answer = Math.pow(Integer.parseInt(s.substring(index1, carrotIndex)), Integer.parseInt(s.substring(carrotIndex + 1, index2)));
            s = s.substring(0, index1) + answer + s.substring(index2);
            }
        }



        return Double.parseDouble(s);
    }

}