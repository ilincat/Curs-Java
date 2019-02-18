package commands;

import java.util.ArrayList;
import java.util.List;
import exceptions.ExceptionEmptyGenerics;
import exceptions.ExceptionInvalidCommand;

import java.io.*;

public class LoadCommand extends GenericCommand {
    private Catalog catalog;
    private List<String> arguments=new ArrayList<>();
    public void setArguments(Catalog catalog,List<String> arguments) throws ExceptionInvalidCommand {
        List<String> trimmedStrings = new ArrayList<String>();
        if(arguments.size()>1) throw new ExceptionInvalidCommand("Too many arguments");
        if(arguments.size()==0) throw new ExceptionInvalidCommand("Too few arguments");
        for(String s : arguments) {
            trimmedStrings.add(s.trim());
        }
        arguments = trimmedStrings;
        this.arguments=arguments;
        this.catalog=catalog;
        try {
            catalog.load(arguments.get(0));
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
    }
}
