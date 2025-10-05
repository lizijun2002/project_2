package src;

public abstract class Expr {
    // Part 1: direct evaluation
    public abstract float eval();

    // Part 2: visitor pattern
    public abstract <R> R accept(ExprVisitor<R> v);
}

abstract class BinaryExpr extends Expr {
    protected final Expr left;
    protected final Expr right;

    public BinaryExpr(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    public Expr getLeft() { return left; }
    public Expr getRight() { return right; }
}

class PlusExpr extends BinaryExpr {
    public PlusExpr(Expr left, Expr right) { super(left, right); }

    @Override
    public float eval() { return left.eval() + right.eval(); }

    @Override
    public <R> R accept(ExprVisitor<R> v) { return v.visitPlus(this); }
}

class MinusExpr extends BinaryExpr {
    public MinusExpr(Expr left, Expr right) { super(left, right); }

    @Override
    public float eval() { return left.eval() - right.eval(); }

    @Override
    public <R> R accept(ExprVisitor<R> v) { return v.visitMinus(this); }
}

class TimesExpr extends BinaryExpr {
    public TimesExpr(Expr left, Expr right) { super(left, right); }

    @Override
    public float eval() { return left.eval() * right.eval(); }

    @Override
    public <R> R accept(ExprVisitor<R> v) { return v.visitTimes(this); }
}

class DivExpr extends BinaryExpr {
    public DivExpr(Expr left, Expr right) { super(left, right); }

    @Override
    public float eval() { return left.eval() / right.eval(); }

    @Override
    public <R> R accept(ExprVisitor<R> v) { return v.visitDiv(this); }
}

class FloatExpr extends Expr {
    private final float value;

    public FloatExpr(float value) { this.value = value; }

    public float getValue() { return value; }

    @Override
    public float eval() { return value; }

    @Override
    public <R> R accept(ExprVisitor<R> v) { return v.visitFloat(this); }
}
