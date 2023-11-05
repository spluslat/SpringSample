package spluslat.utility;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
	@Autowired
	@Qualifier("messageMessageSource")
	private MessageSource messageMessageSource;

	/**
	 * メッセージを取得する
	 * @param id メッセージID
	 * @param args 埋め込み値
	 * @return 指定値を埋め込みしたメッセージ
	 */
	public String getMessage(String id, Object... args) {
		return this.getMessage(id, Locale.getDefault(), args);
	}
	
	/**
     * メッセージを取得する
     * @param id メッセージID
     * @param args 埋め込み値
     * @return 指定値を埋め込みしたメッセージ
     */
    public String getMessage(String id, Locale locale, Object... args) {
        return messageMessageSource.getMessage(id, args, locale);
    }
}
