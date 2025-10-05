package src;

public abstract class Expr {
    // Part 1: direct evaluation
    abstract float eval();

    // Part 2: visitor pattern
    abstract <R> R accept(ExprVisitor<R> v);
}

abstract class BinaryExpr extends Expr {
    protected final Expr e1;
    protected final Expr e2;

    public BinaryExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Expr getE1() { return e1; }
    public Expr getE2() { return e2; }
}

class PlusExpr extends BinaryExpr {
    public PlusExpr(Expr e1, Expr e2) { super(e1, e2); }

    @Override
    float eval() { return e1.eval() + e2.eval(); }

    @Override
    <R> R accept(ExprVisitor<R> v) { return v.visitPlus(this); }
}

class MinusExpr extends BinaryExpr {
    public MinusExpr(Expr e1, Expr e2) { super(e1, e2); }

    @Override
    float eval() { return e1.eval() - e2.eval(); }

    @Override
    <R> R accept(ExprVisitor<R> v) { return v.visitMinus(this); }
}

class TimesExpr extends BinaryExpr {
    public TimesExpr(Expr e1, Expr e2) { super(e1, e2); }

    @Override
    float eval() { return e1.eval() * e2.eval(); }

    @Override
    <R> R accept(ExprVisitor<R> v) { return v.visitTimes(this); }
}

class DivExpr extends BinaryExpr {
    public DivExpr(Expr e1, Expr e2) { super(e1, e2); }

    @Override
    float eval() { return e1.eval() / e2.eval(); }

    @Override
    <R> R accept(ExprVisitor<R> v) { return v.visitDiv(this); }
}

class FloatExpr extends Expr {
    protected final float literal;

    public FloatExpr(float f) { this.literal = f; }

    public float getLiteral() { return literal; }

    @Override
    float eval() { return literal; }

    @Override
    <R> R accept(ExprVisitor<R> v) { return v.visitFloat(this); }
}
