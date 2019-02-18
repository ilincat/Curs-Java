package exceptions;

public class ExceptionEmptyGenerics extends Exception {
    public ExceptionEmptyGenerics() {}
    public ExceptionEmptyGenerics(String message)
    {
        super(message);
    }
}
