package documents;

import exceptions.ExceptionInvalidData;

import java.io.Serializable;
import java.util.Arrays;

public class Article  extends Document  implements Serializable{
    private String journal;
    private String conference;
    public Article(String title, String path,  int year, String ... author) throws ExceptionInvalidData {
        this.title=title;
        this.path=path;
        this.year=year;
        this.author.addAll(Arrays.asList(author));
    }

    @Override
    public String toString() {
        return "Article= { " +
                "title='" + title + '\'' +
                        ", path=" + path +
                        ", author=" + author +
                        ", year=" + year + "}";
    }
    public void print()
    {
        System.out.println(conference);
    }
}
