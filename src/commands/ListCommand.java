package commands;

import java.util.ArrayList;
import java.util.List;
import exceptions.ExceptionEmptyGenerics;
import exceptions.ExceptionInvalidCommand;

public class ListCommand extends GenericCommand {
    private Catalog catalog;
    private List<String> arguments=new ArrayList<>();
    public void setArguments(Catalog catalog,List<String> arguments) throws ExceptionInvalidCommand {
        List<String> trimmedStrings = new ArrayList<String>();
        for(String s : arguments) {
            trimmedStrings.add(s.trim());
        }
        arguments = trimmedStrings;
        this.arguments=arguments;
        this.catalog=catalog;
        if(arguments.size()>0) throw new ExceptionInvalidCommand("Too many arguments");
        try {
            catalog.list();
        }
        catch (ExceptionEmptyGenerics e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
