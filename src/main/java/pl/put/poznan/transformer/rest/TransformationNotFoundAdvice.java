package pl.put.poznan.transformer.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TransformationNotFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Klasa obsługująca łapanie wyjątków ziwązanych z RESTem
 */

@ControllerAdvice
public class TransformationNotFoundAdvice {

    /**
     * Przechwytywanie TransformationNotFoundException
     *
     * @param ex złapany wyjątek
     * @param rq wykorzystene aby dostać się do url
     * @return json z widomością błedu i adresem url
     * @throws JsonProcessingException Teoretycznie rzuca JsonProcessingException, nie bardzo wiem jak to zrobić bez tego, w praktyce się nie zdarzyło (z tego co mi widomo).
     */

    @ExceptionHandler(value = TransformationNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    ResponseEntity<String> transformationNotFoundHandler(TransformationNotFoundException ex, HttpServletRequest rq) throws JsonProcessingException {
        ErrorInfo errorInfo = new ErrorInfo(ex.getMessage(), new StringBuilder(rq.getRequestURL().toString()).append('?').append(rq.getQueryString()).toString());
        ObjectMapper mapper = new ObjectMapper();
        return new ResponseEntity<String>(mapper.writeValueAsString(errorInfo), HttpStatus.NOT_FOUND);
    }
}
