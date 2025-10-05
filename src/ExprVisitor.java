package src;

public interface ExprVisitor<R> {
    R visitPlus(PlusExpr e);
    R visitMinus(MinusExpr e);
    R visitTimes(TimesExpr e);
    R visitDiv(DivExpr e);
    R visitFloat(FloatExpr e);
}
