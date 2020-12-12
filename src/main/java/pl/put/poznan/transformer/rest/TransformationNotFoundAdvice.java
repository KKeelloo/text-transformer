package pl.put.poznan.transformer.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.put.poznan.transformer.logic.TransformationNotFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TransformationNotFoundAdvice {

    @ExceptionHandler(value = TransformationNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    ResponseEntity<String> transformationNotFoundHandler(TransformationNotFoundException ex, HttpServletRequest rq) throws JsonProcessingException {
        ErrorInfo errorInfo = new ErrorInfo(ex.getMessage(), rq.getRequestURL().toString());
        ObjectMapper mapper = new ObjectMapper();
        return new ResponseEntity<String>(mapper.writeValueAsString(errorInfo), HttpStatus.NOT_FOUND);
    }
}
