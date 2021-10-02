package book;

import java.util.List;

public class TestBookPublisher {

    public static void main(String[] args) {
         BookPublisher book = new BookPublisher("Tyland", List.of("I", "moved", "here", "recently", "too"));
         book.printToFile();
    }

}
