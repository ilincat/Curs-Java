package commands;

import documents.Article;
import documents.Book;
import documents.Document;
import documents.Manual;
import exceptions.ExceptionEmptyGenerics;
import exceptions.ExceptionInvalidData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Catalog {
    private List<Document> list = new ArrayList<>();
    private List<Document> readList = new ArrayList<>();
    private List<Document> documentList = new ArrayList<>();

    public void add(Document d) {
        list.add(d);
    }

    public void save(String path) throws IOException, ExceptionEmptyGenerics {
            if(list.isEmpty()) throw new ExceptionEmptyGenerics("No objects to be serialized");
            else {
                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(list);
                oos.close();
            }
    }

    public void load (String path) throws ClassNotFoundException, ExceptionEmptyGenerics, IOException {
        FileInputStream fin = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fin);
        readList = (List<Document>) ois.readObject();
        if (readList.isEmpty()) throw new ExceptionEmptyGenerics("No objects to be deserialized");
        else {
            for (Document d : readList) {
                if (d instanceof Article) {
                    Article article = (Article) d;
                    documentList.add(article);
                } else if (d instanceof Book) {
                    Book book = (Book) d;
                    documentList.add(book);
                } else if (d instanceof Manual) {
                    Manual manual = (Manual) d;
                    documentList.add(manual);
                }
            }
        }
        fin.close();
    }
    public void list() throws  ExceptionEmptyGenerics {
        for (Document l:list) {
            System.out.println(l.toString());
        }
    }

    public void list(String type){
            switch(type){
                case "book":
                    for(Document d:list){
                        if (d instanceof Book) {
                            System.out.println(d.toString());
                        }
                    }
                    break;
                case "article":
                    for(Document d:list){
                        if (d instanceof Article) {
                            System.out.println(d.toString());
                        }
                    }
                    break;
                case "manual":
                    for(Document d:list){
                        if (d instanceof Manual) {
                            System.out.println(d.toString());
                        }
                    }
                    break;
                default:
                    System.out.println("Undefined type");
            }

    }

    public void open(String path) throws  IOException, ExceptionInvalidData {
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        File f = new File(path);
        if(f.isDirectory()) throw new ExceptionInvalidData("The path given is a directory and not a file");
        else if (!f.exists())  throw new ExceptionInvalidData("The file does not exist");
        else if  (f.length() ==0 ) throw new EOFException("The file is empty");
        else desktop.open(f);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "list=" + list +
                '}';
    }
}