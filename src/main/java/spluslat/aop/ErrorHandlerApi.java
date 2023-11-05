package spluslat.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import spluslat.constants.MessageKeyConstants;
import spluslat.data.response.ErrorResponse;
import spluslat.utility.MessageService;

/**
 * RestControllerの共通例外処理
 */
@ControllerAdvice(annotations = RestController.class)
public class ErrorHandlerApi {
    @Autowired
    private MessageService messageService;

    /**
     * 例外発生時の処理
     * @param e 例外
     * @param commonData 共通データ
     * @return 共通例外発生時のレスポンス
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        String message = messageService.getMessage(MessageKeyConstants.API_ERROR_MESSAGE);
        var res = new ErrorResponse();
        res.setMessage(message);
        return ResponseEntity.badRequest().body(res);
    }
}