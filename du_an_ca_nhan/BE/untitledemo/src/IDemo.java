public interface IDemo {
    default void fly() {
        System.out.println("Bay");
    }

    static void run() {
        System.out.println("Di");
    }
}


