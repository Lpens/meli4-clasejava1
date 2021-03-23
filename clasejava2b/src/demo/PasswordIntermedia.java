package demo;

public class PasswordIntermedia extends Password{
    public PasswordIntermedia()
    {
        super("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
    }
}
