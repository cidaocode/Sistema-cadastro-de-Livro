import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        ArrayList<Livro> ListaLivro = new ArrayList<>();
        System.out.println("Seja bem vindo ao sistema SEBO");
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println(" EScolha uma opcao : 1 - cadastrar livro / 2 - listar Livro / 0 - Sair ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();


                    System.out.println("Cadatre o Titulo do Livro");
                    novoLivro.titulo = scanner.next();
                    System.out.println("Nome do Autor");
                    novoAutor.nome = scanner.next();
                    System.out.println("Local de nascimento do Autor");
                    novoAutor.localNascimento = scanner.next();
                    System.out.println("Digite o preco do Livro");
                    novoLivro.preco = scanner.nextFloat();
                    System.out.println("Data de lancamento do Livro (dd/MM/yyyy)");

                    LocalDate date = LocalDate.parse((scanner.next()), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period period = Period.between(date, LocalDate.now());

                    novoLivro.dateLancamento = date;

                    if (period.getYears() >= 5) {
                        System.out.println("Cadastro OK");
                        novoLivro.autor = novoAutor;
                        ListaLivro.add(novoLivro);
                        break;

                    } else {
                        System.out.println("O Livro tem menos de 5 anos");
                        break;



                          }
                case 2:

                    if (ListaLivro.size() > 0 ){
                        for (Livro cadaLivro: ListaLivro){
                            System.out.println("titulo: "+ cadaLivro.titulo);

                            System.out.println("Autor" + cadaLivro.autor.nome);

                            System.out.println("LocalNascimento"+ cadaLivro.autor.localNascimento);

                            System.out.println("Peco"+ cadaLivro.preco);

                            System.out.println("DataLancamento"+ cadaLivro.dateLancamento);



                        }


                    }else {
                        System.out.println("Lista vazia");
                    }
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o sistema SEBO!!");
                    break;
                default:
                    System.out.println("Opcao invalida favor digitar uma opcao valida!!!");
            }


        } while (opcao != 0);
    }
}