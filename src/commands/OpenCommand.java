package commands;

import java.util.ArrayList;
import java.util.List;

import exceptions.ExceptionInvalidCommand;
import exceptions.ExceptionInvalidData;
import java.io.*;

public class OpenCommand extends GenericCommand {
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
            catalog.open(arguments.get(0));
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
    }
}
