package demo;
import java.util.regex.*;

public class Password {
    private  String regex;
    private String value;
    public Password(String r) {
        regex = r;
    }

    public void setValue(String pwd)
    {
        boolean passes = false;
        try {
            passes = Pattern.matches(regex, pwd);
            if (passes)
            {
                value = pwd;
            }
            else {
                throw new Exception("Password Do not match the standard");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(!passes)
            {
                value = "no pwd";
            }
        }
    }
    public  String getValue()
    {
        return value;
    }
}
