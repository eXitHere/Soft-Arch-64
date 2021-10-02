package book;

import java.util.List;

public class TestBookReader {

    public static void main(String[] args) {
         BookReader book = new BookReader("Tyland", List.of("I", "moved", "here", "recently", "too"));
         book.printToScreen();
    }

}
