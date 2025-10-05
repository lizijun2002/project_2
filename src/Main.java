package src;

public class Main {
    public static void main(String[] args) {
        System.out.println("Output of part 1");
        System.out.println("================");
        Expr expr1 = mkExpr1();
        System.out.println("Result of expr1: " + expr1.eval());

        Expr expr2 = mkExpr2();
        System.out.println("Result of expr2: " + expr2.eval());

        Expr expr3 = mkExpr3();
        System.out.println("Result of expr3: " + expr3.eval());

        System.out.println("Output of part 2");
        System.out.println("================");
        ExprVisitor<Float> ev = new ExprEvaluator();
        System.out.println("Result of expr1: " + expr1.accept(ev));
        System.out.println("Result of expr2: " + expr2.accept(ev));
        System.out.println("Result of expr3: " + expr3.accept(ev));
    }

    // 3 + 2*5 = 13.0
    public static Expr mkExpr1() {
        return new PlusExpr(new FloatExpr(3f),
                            new TimesExpr(new FloatExpr(2f), new FloatExpr(5f)));
    }

    // 1/2 + 3/8 = 0.875
    public static Expr mkExpr2() {
        return new PlusExpr(new DivExpr(new FloatExpr(1f), new FloatExpr(2f)),
                            new DivExpr(new FloatExpr(3f), new FloatExpr(8f)));
    }

    // 1/2 - 4/5 = -0.3
    public static Expr mkExpr3() {
        return new MinusExpr(new DivExpr(new FloatExpr(1f), new FloatExpr(2f)),
                             new DivExpr(new FloatExpr(4f), new FloatExpr(5f)));
    }
}
