package principal.cadastro;

import java.io.IOException;

public class CadastroController {
    private final Validador validadorCpf = new ValidadorCPF();
    private final RepositorioUsuarios repo = RepositorioUsuarios.getInstancia();

    public String cadastrar(Usuario usuario) throws IOException {
        if (!validadorCpf.validar(usuario.getCpf())) {
            return "CPF inválido.";
        }
        if (repo.cpfJaExiste(usuario.getCpf())) {
            return "CPF já cadastrado.";
        }

        repo.salvar(usuario);
        return "Cadastro realizado com sucesso!";
    }
}
