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
        Arguments arguments = new Arguments(args);
        
        Operation operation = OperationFactory.create(arguments.getOperator(), arguments.getOperands());
        Double result = operation.execute();
        System.out.println(arguments.getOperator() + " = " + result);
            
    }
}

class Arguments {
    
    private String[] args;
    
    Arguments(String[] args) {
        this.args = args;
    }
    
    String getOperator() {
        return args[0];
    }
    
    List<Double> getOperands(){
        List<Double> operands = new ArrayList<>();
         for(int i = 1; i < args.length; i++) {
            operands.add(Double.parseDouble(args[i]));
        }
        
        return operands;
    }
}

class OperationFactory {
    static Operation create(String operator, List<Double> operands) {
        Operation operation = null;
        
        if(operator.equals("min")) {
            operation = new MinOperation(operands);
        } else if(operator.equals("max")) {
            operation = new MaxOperation(operands);
        } else if(operator.equals("sum")) {
            operation = new SumOperation(operands);
        }else if(operator.equals("avg")) {
            operation = new AverageOperation(operands);
        }
        
        return operation;
    }
}


abstract class Operation {
    abstract double execute();
}

class MaxOperation  extends Operation{
    
    private List<Double> operands;
    
    MaxOperation(List<Double> operands) {
        this.operands = operands;
    }
    
    double execute() {
        double result = operands.get(0);
        for(int i = 1; i < operands.size(); i++) {
            result = Math.max(result, operands.get(i));
        }
        return result;
    }
}


class MinOperation extends Operation{
        
    private List<Double> operands;
    
    MinOperation(List<Double> operands) {
        this.operands = operands;
    }
    
    double execute() {
        double result = operands.get(0);
        for(int i = 1; i < operands.size(); i++) {
            result = Math.min(result, operands.get(i));
        }
        return result;
    }
}


class SumOperation extends Operation{
        
    protected List<Double> operands;
    
    SumOperation(List<Double> operands) {
        this.operands = operands;
    }
    
    double execute() {
        double result = operands.get(0);
        for(int i = 1; i < operands.size(); i++) {
            result = result + operands.get(i);
        } 
        
        return result;
    }
}

class AverageOperation extends SumOperation {
    
    AverageOperation(List<Double> operands) {
        super(operands);
    }
    
    double execute() {
        double sum = super.execute();
        return sum/operands.size();
    }
}