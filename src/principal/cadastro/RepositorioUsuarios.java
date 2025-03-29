package principal.cadastro;

import java.io.*;
import java.util.*;

public class RepositorioUsuarios {
    private static RepositorioUsuarios instancia;
    private final String caminho = "usuarios.txt";

    private RepositorioUsuarios() {}

    public static RepositorioUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioUsuarios();
        }
        return instancia;
    }

    public void salvar(Usuario u) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(caminho, true))) {
            pw.printf("%s;%s;%s;%s;%s;%s%n",
                    u.getNome(), u.getCpf(), u.getEndereco(),
                    u.getDataNascimento(), u.getTelefone(),
                    u.isMembro() ? "sim" : "nao"
            );
        }
    }

    public boolean cpfJaExiste(String cpf) {
        try (Scanner sc = new Scanner(new File(caminho))) {
            while (sc.hasNextLine()) {
                String[] campos = sc.nextLine().split(";");
                if (campos.length > 1 && campos[1].equals(cpf)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<String> listarUsuarios() {
        List<String> lista = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(caminho))) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                lista.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
