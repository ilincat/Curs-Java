package documents;

import exceptions.ExceptionInvalidData;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Book extends  Document implements Serializable {
    private  String publisher;

    public Book(String title, String path,  int year, String ... author) throws ExceptionInvalidData {
        this.title=title;
        this.path=path;
        this.year=year;
        this.author.addAll(Arrays.asList(author));
    }

    @Override
    public String toString() {
        return "Book= { " +
                "title='" + title + '\'' +
                ", path=" + path +
                ", author=" + author +
                ", year=" + year + "}";
    }

    public void print() {
        System.out.println(publisher);
    }
}
