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
        UI ui = new CommandLineUI(args);
        ui.show();
            
    }
}

interface UI {
    void show();
}

class CommandLineUI implements UI {
    
    private String[] args;
    
    CommandLineUI(String[] args){
        this.args = args;
    }
    
    public void show() {
        Arguments arguments = new CommandLineArguments(args);
        Operation operation = OperationFactory.create(arguments.getOperator(), arguments.getOperands());
        Double result = operation.execute();
        System.out.println(arguments.getOperator() + " = " + result);
    }
}

interface Arguments {
    String getOperator();
    List<Double> getOperands();
}

class CommandLineArguments implements Arguments {
    
    private String[] args;
    
    CommandLineArguments(String[] args) {
        this.args = args;
    }
    
    public String getOperator() {
        return args[0];
    }
    
    public List<Double> getOperands(){
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


interface Operation {
    double execute();
}

class MaxOperation implements Operation{
    
    private List<Double> operands;
    
    MaxOperation(List<Double> operands) {
        this.operands = operands;
    }
    
    public double execute() {
        double result = operands.get(0);
        for(int i = 1; i < operands.size(); i++) {
            result = Math.max(result, operands.get(i));
        }
        return result;
    }
}


class MinOperation implements Operation{
        
    private List<Double> operands;
    
    MinOperation(List<Double> operands) {
        this.operands = operands;
    }
    
    public double execute() {
        double result = operands.get(0);
        for(int i = 1; i < operands.size(); i++) {
            result = Math.min(result, operands.get(i));
        }
        return result;
    }
}


class SumOperation implements Operation{
        
    protected List<Double> operands;
    
    SumOperation(List<Double> operands) {
        this.operands = operands;
    }
    
    public double execute() {
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
    
    public double execute() {
        double sum = super.execute();
        return sum/operands.size();
    }
}