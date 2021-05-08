package br.com.enderecos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;

@ControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<ErroResponse> invalidFile(InvalidParamException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new ErroResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> invalidArgument(MethodArgumentNotValidException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(
                HttpStatus.BAD_REQUEST.value(),
                tratamentoDeMensagem(e)
        ));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErroResponse> invalidArgument(SQLIntegrityConstraintViolationException e, HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        ));
    }

    private String tratamentoDeMensagem(MethodArgumentNotValidException e) {
        String[] textoSeparado = e.getMessage().split(";");
        long count = Arrays.stream(textoSeparado).count();
        String msg = Arrays.stream(textoSeparado).skip(count - 1).findFirst().get();
        String nMsg = msg.replace(" default message [", "").replace("]]", "");
        return nMsg;
    }
}



