package demo;

public class PasswordSimple extends Password{
    public PasswordSimple()
    {
        super("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }
}
