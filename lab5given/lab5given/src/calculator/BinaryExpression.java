
public abstract class BinaryExpression implements Expression {

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
      return "(" + lft + " " + operation+ " " + rht + ")";
   }

    public double evaluate(Bindings bindings) {
        return _applyOperator(lft.evaluate(bindings), rht.evaluate(bindings));
    }

    protected abstract double _applyOperator(double left, double right);
    
}
