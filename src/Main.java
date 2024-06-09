import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        String name;
        ArrayList<Conta> Contas = new ArrayList<>();

        // Adiciona contas iniciais
        Cliente c1 = new Cliente("joão", "85563952251");
        Cliente c2 = new Cliente("marcus", "855566394");
        Cliente c3 = new Cliente("paulo", "855566394");
        Cliente c4 = new Cliente("jorge", "786668536");
        Contas.add(new ContaCorrente(c1)); // Conta corrente
        Contas.add(new ContaPoupanca(c2)); // Conta Poupança
        Contas.add(new ContaCorrente(c3)); // Conta Corrente
        Contas.add(new ContaSalario(c4)); // Conta Salário

        String[] optionsMenu = {"Login", "Cadastrar"};
        String[] optionsConta = {"Consultar saldo","Depositar", "Sacar", "Transferir"};

        JRadioButton radioButton1 = new JRadioButton("Conta Corrente");
        JRadioButton radioButton2 = new JRadioButton("Conta Poupança");
        JRadioButton radioButton3 = new JRadioButton("Conta Salário");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        JPanel panel = new JPanel();
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);

        int input = 0;
        while (input ==0) {
            input = JOptionPane.showOptionDialog(null, "Bem vindo ao Banco UFG", "Escolha a opção abaixo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionsMenu, optionsMenu[0]);

            if (input == JOptionPane.CLOSED_OPTION) {
                break;
            }

            if (input == 0) { // Login
                name = JOptionPane.showInputDialog(null, "Digite seu nome aqui");
                if (name == null) continue;
                boolean contaEncontrada = false;
                for (Conta conta : Contas) {
                    if (Objects.equals(conta.dono.getNome(), name)) {
                        JOptionPane.showMessageDialog(null, "Conta encontrada");
                        contaEncontrada = true;
                        //Logado
                        int operacao = 0;
                        while(operacao!= JOptionPane.CANCEL_OPTION){
                             operacao = JOptionPane.showOptionDialog(null, "Bem vindo " + conta.dono.getNome().toUpperCase()+ "\n" + conta,"Escolha uma operação", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionsConta, optionsConta[0]);
                             switch (operacao) {
                                 case 0:
                                     JOptionPane.showMessageDialog(null, "Seu saldo atual é de R$" + conta.getSaldo());
                                    break;
                                 case 1:
                                     double valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Qual valor deseja depositar?"));
                                         conta.depositar(valor);
                                         JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso!\nSaldo atual: R$" + conta.getSaldo());
                                         break;
                                 case 2:
                                     valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Qual valor deseja sacar?"));
                                     if(conta.getSaldo()>=valor) {
                                         conta.sacar(valor);
                                         JOptionPane.showMessageDialog(null, "Valor sacado com sucesso!\nSaldo atual: R$" + conta.getSaldo());
                                         break;
                                     }else {
                                         JOptionPane.showMessageDialog(null, "O valor solicitado é maior que o disponível na conta, a operação foi cancelada");
                                         break;
                                     }
                                 case 3:
                                     int contaDestino = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta do receptor da transferência"));
                                     valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor que deseja transferir"));

                                     for (Conta conta1 : Contas){
                                            if(contaDestino == conta1.getNumero() && conta1.getSaldo()>valor){
                                                JOptionPane.showConfirmDialog(null,"Você deseja transferir R$" + valor + " para " + conta1.dono.getNome());
                                                conta1.depositar(valor);
                                                JOptionPane.showMessageDialog(null,"Transferência realizada com sucesso\nSeu atual saldo é de R$ " + conta1.getSaldo());
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Conta não encontrada, a operação não foi realizada");
                                            }
                                         break;
                                     }
                             }



                             }
                            }
                        }
                if (!contaEncontrada) {
                    JOptionPane.showMessageDialog(null, "Conta não encontrada!");
                }
            } else if (input == 1) { // Cadastrar
                name = JOptionPane.showInputDialog(null, "Bem vindo a sessão de cadastro\nPara iniciar, digite seu nome completo");
                String telefone = JOptionPane.showInputDialog(null, "Digite seu telefone");
                Cliente cliente = new Cliente(name, telefone);

                int flagTipoConta = JOptionPane.showConfirmDialog(null, panel, "Escolha o tipo de conta", JOptionPane.OK_CANCEL_OPTION);
                if (flagTipoConta == JOptionPane.OK_OPTION) {
                    if (radioButton1.isSelected()) {
                        Contas.add(new ContaCorrente(cliente));
                    } else if (radioButton2.isSelected()) {
                        Contas.add(new ContaPoupanca(cliente));
                    } else if (radioButton3.isSelected()) {
                        Contas.add(new ContaSalario(cliente));
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhuma opção de conta selecionada.");
                        continue;
                    }
                    JOptionPane.showMessageDialog(null, "Registrado com sucesso!");
                }
                input = 0;
            }
        }
        JOptionPane.showMessageDialog(null, "Obrigado por usar o app!");
    }
}

