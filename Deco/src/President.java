class President {
    // private static President instance; // private variable

    private President() {// constructor

    }

    public static President getInstance() { // if it is a non-static method then it is a object variable(you can call
                                            // this method only when object is created)
        // if (instance == null) { // nonstatic method can access static
        // instance = new President();

        // }
        // return instance;

        return new President();// possible because within the classs private constructor can be called
    }

    public void test() { // non-static method
        System.out.println("dfbsdv");
    }

    class SriLanka {
        public static void main(String[] args) {
            // President president1 = new President();
            President president = President.getInstance(); // can call only when method is static
            president.test();// non-static method can be called with the object

            President president1 = President.getInstance(); // this way can make 2 presidents
            president1.test();

        }
    }
}
