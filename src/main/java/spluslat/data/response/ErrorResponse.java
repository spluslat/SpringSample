package spluslat.data.response;

import java.util.Map;

import lombok.Data;

@Data
public class ErrorResponse {
	private String[] message;
	private Map<String, String> details;

	/**
	 * メッセージをセットする
	 * @param args メッセージ
	 */
	public void setMessage(String... args) {
		this.message = args;
	}

	/**
	 * 文字列の配列の最後尾に値を追加する
	 * @param original 配列
	 * @param element 追加する値
	 * @return 文字列の配列の最後尾に値を追加した配列
	 */
	private static String[] addElement(String[] originalArray, String value) {
		String[] newArray = new String[originalArray.length + 1];
		System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
		newArray[originalArray.length] = value;
		return newArray;
	}

	/**
	 * メッセージを追加する
	 * @param message
	 */
	public void addMessage(String message) {
		this.message = addElement(this.message, message);
	}
}
