package com.lanre.hospital.exception;


import com.lanre.hospital.response.ApiResponse;
import com.lanre.hospital.util.AppCode;
import com.lanre.hospital.util.AppUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;






import java.util.ArrayList;
import java.util.List;




@ControllerAdvice
@Slf4j
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    private void logMessage(String message, String requestUrl) {
        log.warn("Record not found for {} access through {}", message, requestUrl);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        return new ResponseEntity<>(new ApiResponse<>(AppUtil.FAILED, AppCode.BAD_REQUEST,String.join(",", errors)), HttpStatus.BAD_REQUEST);

    }



    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleRecordNotFoundExceptions(RecordNotFoundException exception, WebRequest webRequest) {
        String requestUrl = webRequest.getContextPath();
        logMessage(exception.getLocalizedMessage(), requestUrl);
        return new ResponseEntity<>(new ApiResponse<>(AppUtil.FAILED, AppCode.NOT_FOUND, exception.getMessage()), HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(ServiceNotAvailableException.class)
    public ResponseEntity<ApiResponse<String>> handleSecurityViolationException(ServiceNotAvailableException exception, WebRequest webRequest) {
        String requestUrl = webRequest.getContextPath();
        logMessage(exception.getMessage(), requestUrl);
        return new ResponseEntity<>(new ApiResponse<>(AppUtil.FAILED,AppCode.UNAUTHORISED, exception.getMessage()), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleUserNotFoundException(UserNotFoundException exception, WebRequest webRequest) {
        String requestUrl = webRequest.getContextPath();
        logMessage(exception.getMessage(), requestUrl);
        return new ResponseEntity<>(new ApiResponse<>(AppUtil.FAILED, AppCode.NOT_FOUND, exception.getMessage()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(DuplicationRecordException.class)
    public ResponseEntity<ApiResponse<String>> handleDuplicateRecordExceptions(DuplicationRecordException exception, WebRequest webRequest) {
        String requestUrl = webRequest.getContextPath();
        logMessage(exception.getMessage(), requestUrl);
        return new ResponseEntity<>(new ApiResponse<>(AppUtil.FAILED, AppCode.DUPLICATE_ID, exception.getMessage()), HttpStatus.CONFLICT);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<String>> handleBadRequestExceptions(BadRequestException exception, WebRequest webRequest) {
        String requestUrl = webRequest.getContextPath();
        logMessage(exception.getMessage(), requestUrl);
        return new ResponseEntity<>(new ApiResponse<>(AppUtil.FAILED,AppCode.BAD_REQUEST, exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedRequestException.class)
    public ResponseEntity<ApiResponse<String>> handleUnauthorizedRequestExceptions(UnauthorizedRequestException exception, WebRequest webRequest) {
        String requestUrl = webRequest.getContextPath();
        logMessage(exception.getMessage(), requestUrl);
        return new ResponseEntity<>(new ApiResponse<>(AppUtil.FAILED,AppCode.UNAUTHORISED, exception.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> illegaException(IllegalArgumentException exception, WebRequest webRequest) {
        String requestUrl = webRequest.getContextPath();
        logMessage(exception.getMessage(), requestUrl);
        return new ResponseEntity<>(new ApiResponse<>(AppUtil.FAILED,AppCode.NOT_FOUND, exception.getMessage()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        String error =
                ex.getName() + " should be of type " + ex.getRequiredType().getName();
        return new ResponseEntity<>(new ApiResponse<>(AppUtil.FAILED,AppCode.BAD_REQUEST, error), HttpStatus.BAD_REQUEST);

    }

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<ApiResponse<String>> handlerGlobalError(Exception exception) {
//        log.warn("An error occur  {}", exception.fillInStackTrace().getMessage());
//        exception.printStackTrace();
//        return new ResponseEntity<>(new ApiResponse<>(AppUtil.FAILED,AppCode.INTERNAL_SERVER, exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//    }





//    @ExceptionHandler(ExpiredJwtException.class)
//    public ResponseEntity<ApiResponse<String>> handleMalformedJwtException(ExpiredJwtException exception, WebRequest webRequest) {
//        String requestUrl = webRequest.getContextPath();
//        logMessage(exception.getMessage(), requestUrl);
//        return new ResponseEntity<>(new ApiResponse<>(FAILED, AppCode.NOT_AUTHORIZED, UNAUTHORIZE), HttpStatus.UNAUTHORIZED);
//    }



}
