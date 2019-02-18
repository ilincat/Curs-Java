package documents;
import exceptions.ExceptionInvalidData;

import java.io.Serializable;

public class Manual extends  Document implements Serializable {
    public Manual(String title, String path) throws ExceptionInvalidData {
        this.title = title;
        this.path=path;
    }

    @Override
    public String toString() {
        return "Manual= { " +
                "title='" + title + '\'' +
                ", path=" + path +
                ", author=" + author +
                ", year=" + year + "}";
    }
    public void print()
    {
        System.out.println("No new property defined");
    }
}
