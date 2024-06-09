public class ContaPoupanca extends Conta{
    static double taxa = 0.05;
    public ContaPoupanca(Cliente dono){
        super(dono);
    }

    public void transferir(double valor, Conta destino) {

    }

    public void atualizaSaldo(double percentual) {
        saldo += saldo * percentual / 100;
    }

    public void sacar(double valor, double saldo){
        if(saldo>=valor) {
            this.saldo = (saldo - valor) - taxa;
        }
    }

    public void depositar(double valor, double saldo){
        this.saldo = (saldo + valor) - taxa;
    }

}
