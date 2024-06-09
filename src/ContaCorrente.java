public class ContaCorrente extends Conta{
    static double taxa = 0.05;

    public ContaCorrente(Cliente dono) {
        super(dono);
    }

    public void transferir(double valor, Conta destino) {
        if (valor <= saldo + taxa) {
            this.saldo -= valor + taxa;
            destino.depositar(valor);
        }
    }

    public void sacar(double valor, double saldo){
        if(saldo>=valor) {
            this.saldo = (saldo - valor) - taxa;
        }
    }

    public void depositar(double valor, double saldo){
        this.saldo = (saldo + valor) - 0.05f;
    }

}

