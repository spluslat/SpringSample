package spluslat.aop;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * Controllerの共通例外処理
 */
@ControllerAdvice(annotations = Controller.class)
public class ErrorHandlerView {
	/**
	 * 例外発生時の処理
	 * @param e 例外
	 * @param commonData 共通情報
	 * @param model テンプレートに設定するモデル
	 * @return 例外発生時の画面
	 */
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		model.addAttribute("error", "サーバーエラー");
		model.addAttribute("message", "ErrorHandlerViewで例外キャッチ。" + e.getMessage());
		return "error/500";
	}
}