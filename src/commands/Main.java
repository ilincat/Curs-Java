package commands;

import com.sun.deploy.util.ArrayUtil;
import documents.Article;
import documents.Book;
import documents.Manual;
import exceptions.ExceptionEmptyGenerics;
import exceptions.ExceptionInvalidCommand;
import exceptions.ExceptionInvalidData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        /*Catalog catalog = new Catalog();
        try {
        catalog.add (new Book("The Art of Computer Programming", "c:\\Users\\Ilinca\\Desktop\\An 2 Sem 2\\PA (Java)\\ex1.java", 1986, "Donald E. Knuth"));
        }
        catch (ExceptionInvalidData e)
        {
          System.out.println(e.getMessage());
          e.printStackTrace();
        }
        try {
            catalog.add (new Article("Mastering the Game of Go without Human Knowledge", "c:\\Users\\Ilinca\\Desktop\\An 2 Sem 2\\PA (Java)\\ex1.java", 2017, "David Silver", "Julian Schrittwieser", "Karen Simonyan"));
        }
        catch (ExceptionInvalidData e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            catalog.add (new Manual("Cookbook","c:\\Users\\Ilinca\\Desktop\\An 2 Sem 2\\PA (Java)\\ex1.java")); }
        catch (ExceptionInvalidData e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            catalog.save("C:\\Users\\Ilinca\\Desktop\\An 2 Sem 2\\PA (Java)\\ex1.java");
        }
        catch (IOException e)
        {
            System.out.println("Unexpected error reading the file!");
            e.printStackTrace();
        }
        catch (ExceptionEmptyGenerics e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            catalog.load("C:\\Users\\Ilinca\\Desktop\\An 2 Sem 2\\PA (Java)\\ex1.java");
        }
        catch (IOException e) {
            System.out.println("File was not found or file is empty");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class was not found");
            e.printStackTrace();
        }
        catch (ExceptionEmptyGenerics e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            catalog.open("C:\\Users\\Ilinca\\Desktop\\An 2 Sem 2\\PA (Java)\\ex1.java");
        }
        catch (EOFException e) {
            System.out.println("The file is empty");
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch(IOException e)
        {
            System.out.println("Error at file");
        }
        catch (ExceptionInvalidData e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            catalog.list();
        }
        catch (ExceptionEmptyGenerics e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catalog.reportHtml();
        */
        String commandLine;
        BufferedReader console = new BufferedReader( new InputStreamReader(System.in));
        Catalog catalog = new Catalog();
        while(true) {
            System.out.println("Enter a command:");
            System.out.print("java>");
            commandLine = console.readLine();
            if(commandLine.equals("")) continue;
            String[] split = commandLine.split(("\""));
            List<String> list = new ArrayList<>();
            list.addAll(Arrays.asList(split));
            for (int i =0; i<list.size(); i++)
            {
                if(split[i].trim().length()<=0)
                    list.remove(i);
            }
            String[] command=list.get(0).split(" ");
            List<String> commands = new ArrayList<>();
            commands.addAll(Arrays.asList(command));
            try {
                if (command[0].equals("add")) {
                    commands.remove(0);
                    list.remove(0);
                    if (commands.size() > 0)
                        list.add(0, commands.get(0));
                    AddCommand add = new AddCommand();
                    try{
                        add.setArguments(catalog, list);
                    }
                    catch (ExceptionInvalidCommand e)
                    {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                } else if (command[0].equals("save")) {
                    commands.remove(0);
                    list.remove(0);
                    if (commands.size() > 0)
                        list.add(0, commands.get(0));
                    SaveCommand save = new SaveCommand();
                    try {
                        save.setArguments(catalog, list);
                    }
                    catch (ExceptionInvalidCommand e)
                    {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                } else if (command[0].equals("list")) {
                    commands.remove(0);
                    list.remove(0);
                    if (commands.size() > 0)
                        list.add(0, commands.get(0));
                    ListCommand l = new ListCommand();
                    try {
                        l.setArguments(catalog, list);
                    }
                    catch (ExceptionInvalidCommand e)
                    {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                } else if (command[0].equals("load")) {
                    commands.remove(0);
                    list.remove(0);
                    if (commands.size() > 0)
                        list.add(0, commands.get(0));
                    LoadCommand load = new LoadCommand();
                    try {
                        load.setArguments(catalog, list);
                    }
                    catch (ExceptionInvalidCommand e)
                    {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                } else if (command[0].equals("open")) {
                    OpenCommand open = new OpenCommand();
                    try {
                        setParameterList(commands, list);
                        open.setArguments(catalog, list);
                    } catch (ExceptionInvalidCommand e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                } else throw new ExceptionInvalidCommand("The command entered is not valid");
            }
            catch (ExceptionInvalidCommand e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }
    public static void setParameterList(List<String> commands,List<String> list){
        commands.remove(0);
        list.remove(0);
        if (commands.size() > 0)
            list.add(0, commands.get(0));
    }
}
