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
        
        double result = operands.get(0);
        if(operator.equals("min")) {
            MinOperation operation = new MinOperation();
            operation.execute(operands);
        } else if(operator.equals("max")) {
            MaxOperation operation = new MaxOperation();
            operation.execute(operands);
        } else if(operator.equals("sum")) {
            SumOperation operation = new SumOperation();
            result = operation.execute(operands);
        }
        
        System.out.println(operator + " = " + result);
            
    }
}
class MaxOperation {
    
    double execute(List<Double> operands) {
        double result = operands.get(0);
        for(int i = 1; i < operands.size(); i++) {
            result = Math.max(result, operands.get(i));
        }
        return result;
    }
}

class MinOperation {
    
    double execute(List<Double> operands) {
        double result = operands.get(0);
        for(int i = 1; i < operands.size(); i++) {
            result = Math.min(result, operands.get(i));
        }
        return result;
    }
}


class SumOperation {
    
    double execute(List<Double> operands) {
        double result = operands.get(0);
        for(int i = 1; i < operands.size(); i++) {
            result = result + operands.get(i);
        } 
        
        return result;
    }
}