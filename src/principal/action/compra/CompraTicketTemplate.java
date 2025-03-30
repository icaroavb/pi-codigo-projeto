package principal.action.compra;

import java.util.Scanner;

public abstract class CompraTicketTemplate {

    public final void executar(Scanner sc, String[] poltronas) {
        String cpf = solicitarCpf(sc);
        if (!validarCpf(cpf)) return;

        if (!verificarCadastro(cpf)) return;

        mostrarPoltronas(poltronas);

        int poltrona = escolherPoltrona(sc);
        if (poltrona == -1) return;

        registrarCompra(cpf, poltrona, poltronas);
        exibirComprovante(cpf, poltrona);
    }

     abstract String solicitarCpf(Scanner sc);
     abstract boolean validarCpf(String cpf);
     abstract boolean verificarCadastro(String cpf);
     abstract void mostrarPoltronas(String[] poltronas);
     abstract int escolherPoltrona(Scanner sc);
     abstract void registrarCompra(String cpf, int poltrona, String[] poltronas);
     abstract void exibirComprovante(String cpf, int poltrona);
}
