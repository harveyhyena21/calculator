import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your calculation: ");
        System.out.println(calculate(sc.nextLine()));

    }

    public static double calculate(String s) {
        int index1 = 0;
        int index2 = 0;

        if (s.contains("(")) {
            index1 = s.indexOf("(");
            //starts from the end of the calculation to find the index of the end paranthesis
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.substring(i, i + 1).equals(")")) {
                    index2 = i;
                    break;
                }
            }
            s = s.substring(0, index1) + calculate(s.substring(index1 + 1, index2)) + s.substring(index2 + 1);
        }

        index1 = 0;
        index2 = s.length();


        if (s.contains("^")) {
            int carrotIndex = s.indexOf("^");
            for (int i = carrotIndex - 1; i >= 0; i--) {
                try {
                    Integer.parseInt(s.substring(i, i + 1));
                } catch (Exception e) {
                    if (s.substring(i, i + 1).equals("."));
                    else {
                        index1 = i + 1;
                        break;
                    }
                }
            }
            for (int i = carrotIndex + 1; i < s.length(); i++) {
                try {
                    Integer.parseInt(s.substring(i, i + 1));
                } catch (Exception e) {
                    if (s.substring(i, i + 1).equals("."));
                    else {
                        index2 = i;
                        break;
                    }
                }
            }

            double answer = Math.pow(Double.parseDouble(s.substring(index1, carrotIndex)), Double.parseDouble(s.substring(carrotIndex + 1, index2)));
            s = s.substring(0, index1) + answer + s.substring(index2);
        }

        index1 = 0;
        index2 = s.length();

        for (int j = 0; j < s.length() - 1; j++) {
            if (s.substring(j, j + 1).equals("*")) {
                int starIndex = s.indexOf("*");
                for (int i = starIndex - 1; i >= 0; i--) {
                    try {
                        Integer.parseInt(s.substring(i, i + 1));
                    } catch (Exception e) {
                        if (s.substring(i, i + 1).equals("."));
                        else {
                            index1 = i + 1;
                            break;
                        }
                    }
                }

                for (int i = starIndex + 1; i < s.length(); i++) {
                    try {
                        Integer.parseInt(s.substring(i, i + 1));
                    } catch (Exception e) {
                        if (s.substring(i, i + 1).equals("."));
                        else {
                            index2 = i;
                            break;
                        }
                    }
                }

                double answer = Double.parseDouble(s.substring(index1, starIndex)) * Double.parseDouble(s.substring(starIndex + 1, index2));
                s = s.substring(0, index1) + answer + s.substring(index2);
                j = index1;
            }

            index1 = 0;
            index2 = s.length();

            if (s.substring(j, j + 1).equals("/")) {
                int divideIndex = s.indexOf("/");
                for (int i = divideIndex - 1; i >= 0; i--) {
                    try {
                        Integer.parseInt(s.substring(i, i + 1));
                    } catch (Exception e) {
                        if (s.substring(i, i + 1).equals("."));
                        else {
                            index1 = i + 1;
                            break;
                        }
                    }
                }
                for (int i = divideIndex + 1; i < s.length(); i++) {
                    try {
                        Integer.parseInt(s.substring(i, i + 1));
                    } catch (Exception e) {
                        if (s.substring(i, i + 1).equals("."));
                        else {
                            index2 = i;
                            break;
                        }
                    }
                }

                double answer = Double.parseDouble(s.substring(index1, divideIndex)) / Double.parseDouble(s.substring(divideIndex + 1, index2));
                s = s.substring(0, index1) + answer + s.substring(index2);
                j = index1;
            }
        }




        index1 = 0;
        index2 = s.length();

        for (int j = 0; j < s.length() - 1; j++) {
            if (s.substring(j, j + 1).equals("+")) {
                int addIndex = s.indexOf("+");
                for (int i = addIndex - 1; i >= 0; i--) {
                    try {
                        Integer.parseInt(s.substring(i, i + 1));
                    } catch (Exception e) {
                        if (s.substring(i, i + 1).equals("."));
                        else {
                            index1 = i + 1;
                            break;
                        }
                    }
                }

                for (int i = addIndex + 1; i < s.length(); i++) {
                    try {
                        Integer.parseInt(s.substring(i, i + 1));
                    } catch (Exception e) {
                        if (s.substring(i, i + 1).equals("."));
                        else {
                            index2 = i;
                            break;
                        }
                    }
                }

                double answer = Double.parseDouble(s.substring(index1, addIndex)) + Double.parseDouble(s.substring(addIndex + 1, index2));
                s = s.substring(0, index1) + answer + s.substring(index2);
                j = index1;
            }

            index1 = 0;
            index2 = s.length();

            if (s.substring(j, j + 1).equals("-")) {
                int subIndex = s.indexOf("-");
                for (int i = subIndex - 1; i >= 0; i--) {
                    try {
                        Integer.parseInt(s.substring(i, i + 1));
                    } catch (Exception e) {
                        if (s.substring(i, i + 1).equals("."));
                        else {
                            index1 = i + 1;
                            break;
                        }
                    }
                }
                for (int i = subIndex + 1; i < s.length(); i++) {
                    try {
                        Integer.parseInt(s.substring(i, i + 1));
                    } catch (Exception e) {
                        if (s.substring(i, i + 1).equals("."));
                        else {
                            index2 = i;
                            break;
                        }
                    }
                }

                double answer = Double.parseDouble(s.substring(index1, subIndex)) - Double.parseDouble(s.substring(subIndex + 1, index2));
                s = s.substring(0, index1) + answer + s.substring(index2);
                j = index1;
            }
        }

        return Double.parseDouble(s);
    }

}