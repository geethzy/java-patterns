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
        Arguments arguments = new Arguments();
        
        Operation operation = OperationFactory.create(arguments.getOperator());
        Double result = operation.execute(arguments.getOperands());
        System.out.println(arguments.getOperator() + " = " + result);
            
    }
}

class Arguments {
    String getOperator(String[] args) {
        return args[0];
    }
    
    List<Double> getOperands(String[] args){
        List<Double> operands = new ArrayList<>();
         for(int i = 1; i < args.length; i++) {
            operands.add(Double.parseDouble(args[i]));
        }
    }
}

class OperationFactory {
    static Operation create(String operator) {
        Operation operation = null;
        
        if(operator.equals("min")) {
            operation = new MinOperation();
        } else if(operator.equals("max")) {
            operation = new MaxOperation();
        } else if(operator.equals("sum")) {
            operation = new SumOperation();
        }else if(operator.equals("avg")) {
            operation = new AverageOperation();
        }
        
        return operation;
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

class AverageOperation extends SumOperation {
    
    double execute(List<Double> operands) {
        double sum = super.execute(operands);
        return sum/operands.size();
    }
}