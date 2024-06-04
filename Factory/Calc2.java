import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        // read all the args
        // separate operator and operands
        // convert operands to double
        // if min:
        //  calculate min
        // else if max
        //  calculate max
        // else if sum
        //  calculate sum
        // print result
        
        String operator;
        List<Double> operands = new ArrayList<>();
        
        operator = args[0];
        for(int i = 1; i < args.length; i++) {
            operands.add(Double.parseDouble(args[i]));
        }
        
        Operation operation = null;
        double result = operands.get(0);
        
        if(operator.equals("min")) {
            operation = new MinOperation();
        } else if(operator.equals("max")) {
            operation = new MaxOperation();
        } else if(operator.equals("sum")) {
            operation = new SumOperation();
        }
        
        result = operation.execute(operands);
        System.out.println(operator + " = " + result);
            
    }
}


abstract class Operation {
    abstract double execute(List<Double> operands);
}

class MaxOperation  extends Operation{
    
    double execute(List<Double> operands) {
        double result = operands.get(0);
        for(int i = 1; i < operands.size(); i++) {
            result = Math.max(result, operands.get(i));
        }
        return result;
    }
}


class MinOperation extends Operation{
    
    double execute(List<Double> operands) {
        double result = operands.get(0);
        for(int i = 1; i < operands.size(); i++) {
            result = Math.min(result, operands.get(i));
        }
        return result;
    }
}


class SumOperation extends Operation{
    
    double execute(List<Double> operands) {
        double result = operands.get(0);
        for(int i = 1; i < operands.size(); i++) {
            result = result + operands.get(i);
        } 
        
        return result;
    }
}