package br.com.enderecos.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;

@Slf4j
@ControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponse> tipoInvalido() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Tipo inferido incorreto"
        ));
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> usuarioNaoEncontrado() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(
                HttpStatus.NOT_FOUND.value(),
                "Usuário Não Encontrado"
        ));
    }

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<ErroResponse> parametrosInvalidos(InvalidParamException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> argumentosInvalidos(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(
                HttpStatus.BAD_REQUEST.value(),
                tratamentoDeMensagem(e)
        ));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErroResponse> chaveDuplicadaNoBanco(SQLIntegrityConstraintViolationException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Chave duplicada: " + tratarMsgSql(e.getMessage())
        ));
    }

    private String tratarMsgSql(String message) {
        return message.substring(17, 28);
    }

    private String tratamentoDeMensagem(MethodArgumentNotValidException e) {
        String[] textoSeparado = e.getMessage().split(";");
        long count = Arrays.stream(textoSeparado).count();
        String msg = Arrays.stream(textoSeparado).skip(count - 1).findFirst().get();
        String nMsg = msg.replace(" default message [", "").replace("]]", "");
        return nMsg;
    }
}