interface Readable {
    public void readBook();

    public void setBookMark();
}

abstract class Book implements Readable {
    public void readBook() {
    }

}

//public class Ebook extends Book {
//    public void readBook() {
//    }
//
//    public void setBookMark() {
//    }
//
//}
abstract class Ebook extends Book {
    public void readBook() {
    }
    public static void main(String[] args) {
        Short s1 = 200;
        Integer s2 = 400;
        Long s3 = (long) s1 + s2;
        String s4 = (s3 * s2);
        System.out.println(s3);
    }
}
