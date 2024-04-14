package MenuLOTOFACIL;

import java.awt.*;
import java.util.Random;
import java.io.IOException;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuLOTOFACIL extends JFrame {

    private static void menu() {

        JFrame frame = new JFrame("Menu Loto Fácil");
        frame.setSize(800, 300);
        frame.setLayout(new GridBagLayout());
        frame.setVisible(true);

        JPanel painel1 = new JPanel();
        JLabel label1 = new JLabel("Opção 1: Apostar de 1 à 100 ");
        painel1.add(label1);

        JPanel painel2 = new JPanel();
        JLabel label2 = new JLabel("Opção 2: Apostar de A à Z ");
        painel2.add(label2);

        JPanel painel3 = new JPanel();
        JLabel label3 = new JLabel("Opção 3: Apostar Ímpar ou Par ");
        painel3.add(label3);

        JPanel painel4 = new JPanel();
        JLabel label4 = new JLabel("Opção 0: Sair ");
        painel4.add(label4);

        frame.add(painel1);
        frame.add(painel2);
        frame.add(painel3);
        frame.add(painel4);

        Object escolha = JOptionPane.showInputDialog(null, "Digite a opção desejada:", JOptionPane.INFORMATION_MESSAGE);
        int escolhaInt = Integer.parseInt(escolha.toString());

        do {
            switch (escolhaInt) {
                case 1:
                    apostaNumeros();
                    break;
                case 2:
                    apostaLetra();
                    break;
                case 3:
                    apostaImparPar();
                    break;
                case 0:
                    frame.setVisible(false);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    System.exit(0);
                    break;
            }
        } while (escolhaInt != 0);
    }

    public static void main(String[] args) throws IOException {
       menu();
    }
    private static void apostaNumeros() {
        Random rdm = new Random();
        Object numero = JOptionPane.showInputDialog(null, "Digite o número desejado:", JOptionPane.INFORMATION_MESSAGE);

        int numeroInt = Integer.parseInt(numero.toString());
        int numeroAleatorio = rdm.nextInt(101);

        if(numeroInt > 100 || numeroInt < 0){
            JOptionPane.showMessageDialog(null, "Aposta inválida");
        } else if (numeroInt == numeroAleatorio){
            JOptionPane.showMessageDialog(null,
                    "Você ganhou R$ 1.000,00 reais!",
                    "Aposta 1",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Que pena! O número sorteado foi: " + numeroAleatorio,
                    "Aposta 1",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    private static void apostaLetra() {
        Object letra = JOptionPane.showInputDialog(null, "Digite a letra desejado:", JOptionPane.INFORMATION_MESSAGE);

        String letraS = letra.toString().toUpperCase();
        char letraC = letraS.charAt(0);

        char letraPremiada = 'D';

        if (!Character.isLetter(letraC)) {
            JOptionPane.showMessageDialog(null, "Aposta inválida","Aposta 2", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else if (letraC == letraPremiada){
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais!", "Aposta 2", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null,"Que pena! A letra sorteada foi: " + letraPremiada,"Aposta 2", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    private static void apostaImparPar() {
        Object numero = JOptionPane.showInputDialog(null, "Digite o número desejado:", JOptionPane.INFORMATION_MESSAGE);
        int numeroInt = Integer.parseInt(numero.toString());

        if (numeroInt % 2 == 0) {
            JOptionPane.showMessageDialog(null,
                    "Você ganhou R$ 100,00 reais!",
                    "Aposta 1",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Que pena! O número digitado é ímpar e a premiação foi para números pares",
                    "Aposta 1",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}