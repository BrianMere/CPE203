package calculator;

public class BinaryExpression implements Expression {

    private final Expression lft;
    private final Expression rht;
    private final String operation;

    public BinaryExpression(final Expression lft, final Expression rht, final String operation){
        this.lft = lft;
        this.rht = rht;
        this.operation = operation;
    }

    public String toString()
   {
      return "(" + lft + operation + rht + ")";
   }

    public double evaluate(Bindings bindings) {
        switch (this.operation) {
            case "+":
                return lft.evaluate(bindings) + rht.evaluate(bindings);
        
            case "-":
                return lft.evaluate(bindings) - rht.evaluate(bindings);
            default:
                return -1; //TODO: remove this
        }
    }
    
}
