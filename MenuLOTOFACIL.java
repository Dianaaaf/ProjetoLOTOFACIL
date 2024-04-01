import java.util.Scanner;
import java.util.Random;
import java.io.IOException;

public class MenuLOTOFACIL {
    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() {
        int opcao = -1;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("** Menu da Loto Fácil **");
            System.out.println("Opção 1: Apostar de 0 a 100");
            System.out.println("Opção 2: Apostar de A à Z");
            System.out.println("Opção 3: Apostar em Par ou Ímpar");
            System.out.println("Opção 0: Sair");
            System.out.println("**************************");
            System.out.print("Digite a opção desejada: ");
            opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Opção 1 escolhida");
                    apostaNumeros();
                    break;
                case 2:
                    System.out.println("Opção 2 escolhida");
                    apostaLetra();
                    break;
                case 3:
                    System.out.println("Opção 3 escolhida");
                    apostaImparPar();
                    break;
                case 0:
                    System.out.println("Opção 0 escolhida");
                    break;
                default:
                    System.out.println("O número escolhido é inválido");
            }
        } while (opcao != 0);
    }

    private static void apostaNumeros() {
        int numero = 0;
        Scanner scn = new Scanner(System.in);
        Random rdm = new Random();

        System.out.println("Digite o número desejado: " + scn);
        numero = scn.nextInt();

        if(numero > 100 || numero < 0){
            System.out.println("Aposta inválida");
        }


        int numeroAleatorio = rdm.nextInt(101);

        if (numero == numeroAleatorio){
            System.out.println("Você ganhou R$ 1.000,00 reais!");
        } else {
            System.out.println("Que pena! O número sorteado foi: " + numeroAleatorio);
        }
    }

    private static void apostaLetra() {

        System.out.println("Digite a letra desejado: ");
        int letra = System.in.read();
        char ch = (char) letra;
        Character.toUpperCase(ch);

        if (!Character.isLetter(ch)) {
            System.out.println("Aposta inválida.");
        }

        char letraPremiada = 'D';
        if (ch == letraPremiada){
            System.out.println("Você ganhou R$ 500,00 reais!");
        } else {
            System.out.println("Que pena! A letra sorteada foi: " + letraPremiada);
        }
    }

    private static void apostaImparPar() {
        int numero = -1;
        Scanner scn = new Scanner(System.in);

        System.out.println("Digite o número desejado: " + scn);
        numero = scn.nextInt();

        if (numero % 2 == 0) {
            System.out.println("Você ganhou R$ 100,00 reais!");
        } else {
            System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares");
        }
    }
}