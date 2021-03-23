package demo;

public class Main {

    public static void main(String[] args) {
	    Password pF = new PasswordFuerte();
	    Password pI = new PasswordIntermedia();
	    Password pS = new PasswordSimple();
	    pI.setValue("LaPrueba1");
	    pS.setValue("LaPrueba2");
	    pF.setValue("LaPrueba3!");

        System.out.println(pF.getValue());
        System.out.println(pI.getValue());
        System.out.println(pS.getValue());
    }
}
