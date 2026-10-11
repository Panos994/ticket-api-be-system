package event.ticket.ticket.api.exception;

import event.ticket.ticket.api.dto.ApiErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<ApiErrorDTO> handleNotFounfException(NotFoundException ex, HttpServletRequest request){
            ApiErrorDTO apiErrorDTO = ApiErrorDTO.builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .error("NOT_FOUND")
                    .timestamp(LocalDateTime.now())
                    .message(ex.getMessage())
                    .path(request.getRequestURI())
                    .build();
            return ResponseEntity.status(404).body(apiErrorDTO);
        }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<ApiErrorDTO> handleUnAuthoirzedException(UnAuthorizedException ex, HttpServletRequest status){
        ApiErrorDTO apiError = ApiErrorDTO.builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .error("UNAUTHORIZED")
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .path(status.getRequestURI())
                .build();
        return ResponseEntity.status(401).body(apiError);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ApiErrorDTO> handleForbiddenException(ForbiddenException ex, HttpServletRequest status){
        ApiErrorDTO apiERror = ApiErrorDTO.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .error("FORBIDDEN")
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .path(status.getRequestURI())
                .build();
        return ResponseEntity.status(403).body(apiERror);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorDTO> handleBadRequestException(BadRequestException ex, HttpServletRequest status){
        ApiErrorDTO apiError = ApiErrorDTO.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error("BAD_REQUEST")
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .path(status.getRequestURI())
                .build();
        return ResponseEntity.status(400).body(apiError);
    }

}
