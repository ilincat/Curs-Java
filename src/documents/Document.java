package documents;

import exceptions.ExceptionInvalidData;

import java.io.Serializable;
import  java.util.*;
import java.io.*;

public class Document implements Serializable {
    protected String title;
    protected String path;
    protected List<String> author = new ArrayList<>();
    protected  int year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
