public class Bird implements IDemo{
    private String name ;

    public Bird(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("Chay");
    }

    public Bird() {
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        bird.run();
    }
}
