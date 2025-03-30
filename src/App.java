import principal.action.compra.CompraTicket;
import principal.action.compra.CompraTicketTemplate;
import principal.cadastro.CadastroController;
import principal.cadastro.RepositorioUsuarios;
import principal.cadastro.Usuario;

import java.io.IOException;
import java.util.Scanner;

import static principal.action.compra.Poltrona.poltronas;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        CadastroController controller = new CadastroController();
        RepositorioUsuarios repo = RepositorioUsuarios.getInstancia();
        while (true) {
            System.out.println("=================================");
            System.out.println("🎭      TEATRO ABC - CLI         ");
            System.out.println("=================================");
            System.out.println("[1] Cadastrar usuário");
            System.out.println("[2] Listar usuários cadastrados");
            System.out.println("[3] Comprar ticket");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    Usuario u = new Usuario();
                    System.out.print("Nome: ");
                    u.setNome(sc.nextLine());

                    System.out.print("CPF: ");
                    u.setCpf(sc.nextLine());

                    System.out.print("Endereço: ");
                    u.setEndereco(sc.nextLine());

                    System.out.print("Data de nascimento (dd/mm/aaaa): ");
                    u.setDataNascimento(sc.nextLine());

                    System.out.print("Telefone: ");
                    u.setTelefone(sc.nextLine());

                    System.out.print("É membro do clube? (s/n): ");
                    String resposta = sc.nextLine();
                    u.setMembro(resposta.equalsIgnoreCase("s"));

                    try {
                        String resultado = controller.cadastrar(u);
                        System.out.println("Resultado: " + resultado);
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar usuário: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.println("=== Usuários Cadastrados ===");
                    repo.listarUsuarios().forEach(System.out::println);
                    break;
                case "3":
                    CompraTicketTemplate compra = new CompraTicket();
                    compra.executar(sc, poltronas);
                    break;
                case "0":
                    System.out.println("Encerrando...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println("\nPressione ENTER para continuar...");
            sc.nextLine();
        }
    }
}
