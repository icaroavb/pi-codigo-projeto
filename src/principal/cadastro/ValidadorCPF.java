package principal.cadastro;

public class ValidadorCPF implements Validador {

    @Override
    public boolean validar(String cpf) {
        return VerificarCPF.validarCPF(cpf);
    }
}
