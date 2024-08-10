public class Test {
    public static void main(String[] args) {
        //switchMethod();
        //forMethod();

        // B b = new B("Hello");

        int i = 0;
        int j = 10;
        int k = 0;
        try {
            k = j/i;
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("in finally");
        }


        System.out.println(k);

    }
    public static void forMethod() {

        for(int i = 0; i < 10; i++) {
            if (i == 5) continue;
            System.out.println("for loop = " + i);
        }
        /*
        int[] someNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int total = 0;
        for (var i : someNumbers) {
            total += i;
        }*?
        System.out.println("Total = " + total);
        /*
        for (int i=0; i < 10; i++) {
            System.out.println("For loop = " + i);
        } */
    }
    public static void switchMethod() {
        int a = 1;

        switch (a) {
            case 1:
                System.out.println("case 1");
                break;
            case 2:
                System.out.println("case 2");
                break;
            case 3:
                System.out.println("case 3");
            case 4:
                System.out.println("case 4");
            case 5:
                System.out.println("case 5");
                break;
            case 6:
                System.out.println("case 6");
            case 7:
                System.out.println("case 7");
            case 8:
                System.out.println("case 8");
            case 9:
                System.out.println("case 9");
            case 10:
                System.out.println("case 10");
        }
    }
}

class A {
    public A() {
        System.out.println("constructor A");
    }

    public A(String a) {
        System.out.println("constructor A with param a");
    }
}

class B extends A {
    public B() {
        System.out.println("constructor B");
    }

    public B(String a) {
        super(a);
        System.out.println("constructor B with param b");
    }
}