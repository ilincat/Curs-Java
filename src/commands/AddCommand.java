package commands;

import java.util.ArrayList;
import java.util.List;
import documents.*;
import exceptions.ExceptionInvalidCommand;
import exceptions.ExceptionInvalidData;

public class AddCommand extends GenericCommand{
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
        if(arguments.size()<4) throw new ExceptionInvalidCommand("Too few arguments");
        if(arguments.get(0).equals("book")) {
            arguments.remove(0);
            int year;
            try {
                year = Integer.parseInt(arguments.get(2));
                catalog.add(new Book(arguments.get(0), arguments.get(1), year, arguments.get(3)));
            } catch (ExceptionInvalidData e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("The year inserted is not a number");
            }
        }
        else if(arguments.get(0).equals("article"))
        {
            arguments.remove(0);
            int year=Integer.parseInt(arguments.get(2));
            try{
                catalog.add(new Article(arguments.get(0), arguments.get(1), year, arguments.get(3)));}
            catch (ExceptionInvalidData e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        else if(arguments.get(0).equals("manual"))
        {
            arguments.remove(0);
            try{
                catalog.add(new Manual(arguments.get(0), arguments.get(1)));}
            catch (ExceptionInvalidData e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        else throw new ExceptionInvalidCommand("You have not entered a document type!");
    }
    public void print()
    {
        System.out.println(arguments.toString());
    }
}
