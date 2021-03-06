package br.com.zupedu.dojo.ot4dojo.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class ValidacaoErroHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public CorpoDeErro handler(MethodArgumentNotValidException exception) {

        List<CorpoDeErro.Object> erros = exception.getBindingResult().getFieldErrors().stream().map(fieldError ->
                new CorpoDeErro.Object(fieldError.getField(), fieldError.getDefaultMessage())
        ).collect(Collectors.toList());

        return new CorpoDeErro(erros);
    }
}
