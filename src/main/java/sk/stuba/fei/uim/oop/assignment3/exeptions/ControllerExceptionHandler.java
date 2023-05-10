package sk.stuba.fei.uim.oop.assignment3.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductOrCartNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(ProductOrCartNotFoundException ex) {
        String errorMessage = "Product or cart not found: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalProductOrCartOperationException.class)
    public ResponseEntity<String> handleIllegalOperationException(IllegalProductOrCartOperationException ex) {
        String errorMessage = "Illegal operation with product or cart: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
