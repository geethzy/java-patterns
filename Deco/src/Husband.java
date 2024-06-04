class Husband {
    private static Husband instance; // private variable

    private Husband() {// constructor

    }

    public static Husband getInstance() {
        if (instance == null) { // nonstatic method can access static
            instance = new Husband();

        }
        return instance;

    }

    public void test() { // non-static method
        System.out.println("dfbsdv");
    }

    class SriLanka {
        public static void main(String[] args) {
            // Husband husband1 = new Husband();
            Husband husband = Husband.getInstance(); // can call only when method is static
            husband.test();// non-static method can be called with the object

            Husband husband1 = Husband.getInstance(); // this way can make 2 husbands
            husband1.test();

        }
    }
}
