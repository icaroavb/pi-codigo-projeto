package principal.action.compra;

import principal.cadastro.RepositorioUsuarios;
import principal.cadastro.Validador;
import principal.cadastro.ValidadorCPF;

import java.util.Scanner;

public class CompraTicket extends CompraTicketTemplate {

    @Override
    protected String solicitarCpf(Scanner sc) {
        System.out.print("Digite seu CPF: ");
        return sc.nextLine();
    }

    @Override
    protected boolean validarCpf(String cpf) {
        Validador validador = new ValidadorCPF();
        if (!validador.validar(cpf)) {
            System.out.println("CPF inválido.");
            return false;
        }
        return true;
    }

    @Override
    protected boolean verificarCadastro(String cpf) {
        if (!RepositorioUsuarios.getInstancia().cpfJaExiste(cpf)) {
            System.out.println("CPF não cadastrado.");
            return false;
        }
        return true;
    }

    @Override
    protected void mostrarPoltronas(String[] poltronas) {
        System.out.println("\n=== Poltronas Livres ===");
        for (int i = 0; i < poltronas.length; i++) {
            if (poltronas[i] == null) System.out.printf("%-4d", i + 1);
            else System.out.print("❌   ");

            if ((i + 1) % 10 == 0) System.out.println();
        }
    }

    @Override
    protected int escolherPoltrona(Scanner sc) {
        System.out.print("\nEscolha o número da poltrona (1 a 30): ");
        try {
            int num = Integer.parseInt(sc.nextLine());
            int indice = num - 1;
            if (indice < 0 || indice >= 30) throw new IllegalArgumentException();
            if (Poltrona.poltronas[indice] != null) {
                System.out.println("Poltrona já ocupada.");
                return -1;
            }
            return indice;
        } catch (Exception e) {
            System.out.println("Entrada inválida.");
            return -1;
        }
    }

    @Override
    protected void registrarCompra(String cpf, int indice, String[] poltronas) {
        poltronas[indice] = cpf;
    }

    @Override
    protected void exibirComprovante(String cpf, int num) {
        System.out.println("\n✅ Ticket comprado com sucesso!");
        System.out.println("🎟️ CPF: " + cpf);
        System.out.println("🪑 Poltrona: " + (num + 1));
    }
}