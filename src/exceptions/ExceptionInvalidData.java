package exceptions;

public class ExceptionInvalidData extends Exception {
    public ExceptionInvalidData() {}
    public ExceptionInvalidData(String message)
    {
        super(message);
    }
}
