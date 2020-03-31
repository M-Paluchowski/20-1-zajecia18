package inner;

class Outer {

    private int value = 5;
    public static int staticValue = 5;

    public void localClass() {
        class LocalHuman {
            private int age;

            public LocalHuman(int age) {
                this.age = age;
            }

            public int getAge() {
                return age;
            }
        }

        LocalHuman localHuman = new LocalHuman(3);
        System.out.println(localHuman);
    }

    class Inner {

//        private int innerValue = 6;
        private int value = 6;

        public void innerMethod() {
            System.out.println("inner.Outer class:" + Outer.this.value);
//            System.out.println("Inner class:" + innerValue);
            System.out.println("Inner class:" + value);
        }
    }

    static class StaticInner {

        public void innerStaticMethod() {
            System.out.println(staticValue);
        }

    }
}
