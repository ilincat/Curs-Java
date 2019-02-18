package commands;
import exceptions.ExceptionInvalidCommand;

import java.util.*;

public abstract class GenericCommand {
    public abstract void setArguments(Catalog catalog,List<String> arguments) throws ExceptionInvalidCommand;
}
