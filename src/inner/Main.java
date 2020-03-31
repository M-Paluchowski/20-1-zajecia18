package inner;

public class Main {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.innerMethod();

        int staticValue = Outer.staticValue;
        Outer.StaticInner staticInner = new Outer.StaticInner();

        Calculator anonymousClass = new Calculator() {

            @Override
            public double add(double a, double b) {
                return a + b;
            }
        };

        double result = anonymousClass.add(0.1, 0.2);
        System.out.println(result);
    }
}
