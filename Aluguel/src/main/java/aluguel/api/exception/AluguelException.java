package aluguel.api.exception;

public class AluguelException extends RuntimeException{
    public AluguelException(String mensagem){
        super(mensagem);
    }
}
