package src;

public class ExprEvaluator implements ExprVisitor<Float> {
    @Override
    public Float visitPlus(PlusExpr e) { return e.getE1().accept(this) + e.getE2().accept(this); }

    @Override
    public Float visitMinus(MinusExpr e) { return e.getE1().accept(this) - e.getE2().accept(this); }

    @Override
    public Float visitTimes(TimesExpr e) { return e.getE1().accept(this) * e.getE2().accept(this); }

    @Override
    public Float visitDiv(DivExpr e) { return e.getE1().accept(this) / e.getE2().accept(this); }

    @Override
    public Float visitFloat(FloatExpr e) { return e.getLiteral(); }
}
