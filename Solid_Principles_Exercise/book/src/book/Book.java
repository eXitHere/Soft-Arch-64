package book;

import java.util.List;
import java.util.ListIterator;

public abstract class Book {
    private String title;
    private List<String> pages;
    private ListIterator<String> iterator;
    private String currentPage = null;

    public Book(String title, List<String> pages) {
        this.title = title;
        this.pages = pages;
        iterator = pages.listIterator();

        if (iterator.hasNext()) {
            currentPage = iterator.next();
        } else {
            currentPage = null;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public boolean turnToNextPage() {
        // System.out.println(iterator.hasNext());
        if (iterator.hasNext()) {
            currentPage = iterator.next();
            return true;
        } else {
            return false;
        }
    }
}
