class Dog {
//    --------------------------- THAM CHIẾU -------------------------------------------
//     khi chúng ta truyền vào hàm một đối tượng, thì tham chiếu đến đối tượng đó được truyền vào,
//    cho phép chúng ta thay đổi trạng thái của đối tượng.
    String name;
    Dog(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        Dog myDog = new Dog("Ki");
        System.out.println("Trước khi gọi hàm: " + myDog.name);
        modifyReference(myDog);
        System.out.println("Sau khi gọi hàm: " + myDog.name);
    }

    public static void modifyReference(Dog dog) {
        dog.name = "Mít Ki";
        System.out.println("Trong hàm: " + dog.name);
    }
}


