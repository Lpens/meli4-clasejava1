package demo;

public class Main {

    public static void main(String[] args) {
        CuentaCorriente cuenta = new CuentaCorriente(867521,129000,"Luis Pens");
        CuentaCorriente nuevacuenta = new CuentaCorriente(cuenta);

        System.out.println(cuenta.getBeneficiario());
        System.out.println("el saldo actual es "+ cuenta.getSaldo());
        System.out.println("quitandole 1000");
        cuenta.egreso(1000);
        System.out.println("el nuevo saldo es "+ cuenta.getSaldo());
        System.out.println("ahora ingresamos el doble");
        cuenta.ingreso(1000*2);
        System.out.println("el nuevo saldo es " + cuenta.getSaldo());

        System.out.println("aca vemos que copiamos la cuenta en el constructor en la nueva cuenta");
        System.out.println("beneficiario nueva cuenta " + nuevacuenta.getBeneficiario());

    }
}
