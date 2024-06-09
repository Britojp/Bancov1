import java.text.DecimalFormat;

public abstract class Conta {
    protected  int numero;
    protected Cliente dono;
    protected  double saldo;
    protected static int num = 1;
    protected static double taxa = 0.05;

    public Conta(Cliente dono) {
        this.numero = num++;
        this.dono = dono;
        this.saldo = 0;
    }
    public void sacar(double valor){
        saldo = saldo - (valor + taxa);
    }
    public void depositar(double valor){
        saldo = saldo + (valor - taxa);
    }
    public abstract void transferir(double valor, Conta destino);


    public double getSaldo(){
        return saldo;
    }
    public int getNumero(){
        return numero;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("#0.00");
        return "Número: " + numero + " \n" +
                "Cliente: " + dono.getNome() + "\n"
                + "Telefone: "+ dono.getTelefone() +
                "\nSaldo: " + df.format(saldo) + "\n";
    }

}

