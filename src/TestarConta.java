public class TestarConta {
    public static void main(String[] args){
        Cliente c1 = new Cliente("joão", "85563952251");
        Cliente c2 = new Cliente("marcus", "855566394");
        Cliente c3 = new Cliente("paulo", "855566394");
        Cliente c4 = new Cliente("jorge", "786668536");


        ContaCorrente cc1 = new ContaCorrente(c1);
        ContaPoupanca cp1 = new ContaPoupanca(c2);
        ContaCorrente cc3 = new ContaCorrente(c3);
        ContaCorrente cs4 = new ContaSalario(c4);

        cc1.depositar(500, cc1.getSaldo());
        System.out.println(cc1);

        cc1.sacar(100, cc1.getSaldo());
        System.out.println(cc1);

        cc1.transferir(100,cc3);
        System.out.println(cc3);

        cc1.transferir(150, cp1);
        System.out.println(cp1);

        cp1.atualizaSaldo(50);
        System.out.println(cp1);

        cs4.depositar(1200, cs4.getSaldo());
        System.out.println(cs4);

        cs4.transferir(500,cp1);
        System.out.println(cs4);
        System.out.println(cp1);









    }
}