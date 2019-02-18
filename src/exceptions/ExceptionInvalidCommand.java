package exceptions;

public class ExceptionInvalidCommand extends Exception {
    public ExceptionInvalidCommand() {}
    public ExceptionInvalidCommand(String message)
    {
        super(message);
    }
}
