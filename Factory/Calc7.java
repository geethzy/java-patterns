import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyClass {
    public static void main(String args[]) {

        UI ui = UIFactory.create(args);
        ui.show();
            
    }
}

class UIFactory {
    static UI create(String[] args) {
        UI ui = null;
        if(args.length == 0) {
            ui = new GUI();
        } else {
            ui = new CommandLineUI(args);
        }
        
        return ui;
    }
}

interface UI {
    void show();
}

class GUI implements UI {

    public void show() {
        System.out.println("GUI IS LOADING....");
        JFrame frame = new JFrame("Calculator");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
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