import java.util.*;

public class Calc {
    public static void main(String args[]) {
        // read all the args
        // separate operator and operands
        // convert operands to double
        // if min:
        // calculate min
        // else if max
        // calculate max
        // else if sum
        // calculate sum
        // print result

        String operator;
        List<Double> operands = new ArrayList<>();

        System.out.println("geeth");
        operator = args[0];
        for (int i = 1; i < args.length; i++) {
            operands.add(Double.parseDouble(args[i]));
        }

        // double result = operator[0];
        // if (operator == "min") {
        // for (int i = 1; i < operator.length; i++) {
        // result = Math.min(result, operator[i]);
        // }
        // } else if (operator == "max") {
        // for (int i = 1; i < operator.length; i++) {
        // result = Math.max(result, operator[i]);
        // }
        // } else if (operator = "sum") {
        // for (int i = 1; i < operator.length; i++) {
        // result = result + operator[i];
        // }
        // }

        // System.out.println(result);

    }
}