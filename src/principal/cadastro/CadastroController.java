package principal.cadastro;

import java.io.IOException;

public class CadastroController {
    private final Validador validadorCpf = new ValidadorCPF();
    private final RepositorioUsuarios repo = RepositorioUsuarios.getInstancia();

    public String cadastrar(Usuario usuario) throws IOException {
        if (!validadorCpf.validar(usuario.getCpf())) {
            return "CPF inválido."; // <- VALIDA O CPF
        }
        if (repo.cpfJaExiste(usuario.getCpf())) {
            return "CPF já cadastrado."; // <- VALIDA O VERIFICA SE O CPF JA CONSTA NO BANCO.
        }

        repo.salvar(usuario); // <- FAZ O CADASTRO DO NOVO USUARIO.
        return "Cadastro realizado com sucesso!";
    }
}
