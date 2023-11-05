package spluslat.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import spluslat.data.CommonData;

public class LoggerWrapper {
    private Logger logger;
    private static final String FATAL_MESSAGE_PREFIX = "[FATAL]";

    /**
     * コンストラクタ
     * @param clazz 
     */
    public LoggerWrapper(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    /**
     * パラメーターとして渡されたクラスに対応する名前のロガーを返します。
     * @param clazz クラス
     * @return LoggerWrapperインスタンス
     */
    public static LoggerWrapper getLogger(Class<?> clazz) {
        return new LoggerWrapper(clazz);
    }

    /**
    * 共通情報をMDCで出力する
    * @param commonData 共通情報
    */
    private void putMdc(CommonData commonData) {
        if (commonData == null) {
            return;
        }
        MDC.put("uuid", String.valueOf(commonData.getUuid()));
        MDC.put("custom1", String.valueOf(commonData.getCustom1()));
        MDC.put("custom2", String.valueOf(commonData.getCustom2()));
        MDC.put("custom3", String.valueOf(commonData.isCustom3()));
        MDC.put("custom4", String.valueOf(commonData.getCustom4()));
        MDC.put("custom5", String.valueOf(commonData.getCustom5()));
    }

    private void clearMdc() {
        MDC.clear();
    }

    /**
     * debug レベルのログ出力
     *
     * @param data 共通データ
     * @param msg  ログ出力するメッセージ
     */
    public void debug(CommonData data, String msg) {
        try {
//            this.putMdc(data);
            if (data != null) {
                MDC.put("uuid", String.valueOf(data.getUuid()));
                MDC.put("custom1", String.valueOf(data.getCustom1()));
                MDC.put("custom2", String.valueOf(data.getCustom2()));
                MDC.put("custom3", String.valueOf(data.isCustom3()));
                MDC.put("custom4", String.valueOf(data.getCustom4()));
                MDC.put("custom5", String.valueOf(data.getCustom5()));
            }
            this.logger.debug(msg);
        } finally {
            MDC.clear();
                        this.clearMdc();
        }
    }

    /**
     * debug レベルのログ出力(フォーマット指定)
     * 
     * @param format フォーマット文字列
     * @param arg    フォーマット文字列の引数
     */
    public void debug(CommonData data, String format, Object arg) {
        try {
            this.putMdc(data);
            this.logger.debug(format, arg);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * debug レベルのログ出力(フォーマット指定)
     * 
     * @param format フォーマット文字列
     * @param arg1   フォーマット文字列の1番目の引数
     * @param arg2   フォーマット文字列の2番目の引数
     */
    public void debug(CommonData data, String format, Object arg1, Object arg2) {
        try {
            this.putMdc(data);
            this.logger.debug(format, arg1, arg2);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * debug レベルのログ出力(フォーマット指定)
     * 
     * @param format    フォーマット文字列
     * @param arguments 3 つ以上の引数のリスト
     */
    public void debug(CommonData data, String format, Object... arguments) {
        try {
            this.putMdc(data);
            this.logger.debug(format, arguments);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * debug レベルの例外メッセージのログ出力
     * @param msg 例外メッセージ
     * @param t   ログに記録する例外
     */
    public void debug(CommonData data, String msg, Throwable t) {
        try {
            this.putMdc(data);
            this.logger.debug(msg, t);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * info レベルのログ出力
     *
     * @param data 共通データ
     * @param msg  ログ出力するメッセージ
     */
    public void info(CommonData data, String msg) {
        try {
            this.putMdc(data);
            this.logger.info(msg);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * info レベルのログ出力(フォーマット指定)
     * 
     * @param format フォーマット文字列
     * @param arg    フォーマット文字列の引数
     */
    public void info(CommonData data, String format, Object arg) {
        try {
            this.putMdc(data);
            this.logger.info(format, arg);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * info レベルのログ出力(フォーマット指定)
     * 
     * @param format フォーマット文字列
     * @param arg1   フォーマット文字列の1番目の引数
     * @param arg2   フォーマット文字列の2番目の引数
     */
    public void info(CommonData data, String format, Object arg1, Object arg2) {
        try {
            this.putMdc(data);
            this.logger.info(format, arg1, arg2);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * info レベルのログ出力(フォーマット指定)
     * 
     * @param format    フォーマット文字列
     * @param arguments 3 つ以上の引数のリスト
     */
    public void info(CommonData data, String format, Object... arguments) {
        try {
            this.putMdc(data);
            this.logger.info(format, arguments);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * info レベルの例外メッセージのログ出力
     * @param msg 例外メッセージ
     * @param t   ログに記録する例外
     */
    public void info(CommonData data, String msg, Throwable t) {
        try {
            this.putMdc(data);
            this.logger.info(msg, t);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * warn レベルのログ出力
     *
     * @param data 共通データ
     * @param msg  ログ出力するメッセージ
     */
    public void warn(CommonData data, String msg) {
        try {
            this.putMdc(data);
            this.logger.warn(msg);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * warn レベルのログ出力(フォーマット指定)
     * 
     * @param format フォーマット文字列
     * @param arg    フォーマット文字列の引数
     */
    public void warn(CommonData data, String format, Object arg) {
        try {
            this.putMdc(data);
            this.logger.warn(format, arg);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * warn レベルのログ出力(フォーマット指定)
     * 
     * @param format フォーマット文字列
     * @param arg1   フォーマット文字列の1番目の引数
     * @param arg2   フォーマット文字列の2番目の引数
     */
    public void warn(CommonData data, String format, Object arg1, Object arg2) {
        try {
            this.putMdc(data);
            this.logger.warn(format, arg1, arg2);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * warn レベルのログ出力(フォーマット指定)
     * 
     * @param format    フォーマット文字列
     * @param arguments 3 つ以上の引数のリスト
     */
    public void warn(CommonData data, String format, Object... arguments) {
        try {
            this.putMdc(data);
            this.logger.warn(format, arguments);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * warn レベルの例外メッセージのログ出力
     * @param msg 例外メッセージ
     * @param t   ログに記録する例外
     */
    public void warn(CommonData data, String msg, Throwable t) {
        try {
            this.putMdc(data);
            this.logger.warn(msg, t);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * error レベルのログ出力
     *
     * @param data 共通データ
     * @param msg  ログ出力するメッセージ
     */
    public void error(CommonData data, String msg) {
        try {
            this.putMdc(data);
            this.logger.error(msg);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * error レベルのログ出力(フォーマット指定)
     * 
     * @param format フォーマット文字列
     * @param arg    フォーマット文字列の引数
     */
    public void error(CommonData data, String format, Object arg) {
        try {
            this.putMdc(data);
            this.logger.error(format, arg);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * error レベルのログ出力(フォーマット指定)
     * 
     * @param format フォーマット文字列
     * @param arg1   フォーマット文字列の1番目の引数
     * @param arg2   フォーマット文字列の2番目の引数
     */
    public void error(CommonData data, String format, Object arg1, Object arg2) {
        try {
            this.putMdc(data);
            this.logger.error(format, arg1, arg2);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * error レベルのログ出力(フォーマット指定)
     * 
     * @param format    フォーマット文字列
     * @param arguments 3 つ以上の引数のリスト
     */
    public void error(CommonData data, String format, Object... arguments) {
        try {
            this.putMdc(data);
            this.logger.error(format, arguments);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * error レベルの例外メッセージのログ出力
     * @param msg 例外メッセージ
     * @param t   ログに記録する例外
     */
    public void error(CommonData data, String msg, Throwable t) {
        try {
            this.putMdc(data);
            this.logger.error(msg, t);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * fatal レベルのログ出力
     *
     * @param data 共通データ
     * @param msg  ログ出力するメッセージ
     */
    public void fatal(CommonData data, String msg) {
        try {
            this.putMdc(data);
            this.logger.error(CommonUtiliry.ensurePrefix(msg, FATAL_MESSAGE_PREFIX));
        } finally {
            this.clearMdc();
        }
    }

    /**
     * fatal レベルのログ出力(フォーマット指定)
     * 
     * @param format フォーマット文字列
     * @param arg    フォーマット文字列の引数
     */
    public void fatal(CommonData data, String format, Object arg) {
        try {
            this.putMdc(data);
            this.logger.error(CommonUtiliry.ensurePrefix(format, FATAL_MESSAGE_PREFIX), arg);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * fatal レベルのログ出力(フォーマット指定)
     * 
     * @param format フォーマット文字列
     * @param arg1   フォーマット文字列の1番目の引数
     * @param arg2   フォーマット文字列の2番目の引数
     */
    public void fatal(CommonData data, String format, Object arg1, Object arg2) {
        try {
            this.putMdc(data);
            this.logger.error(CommonUtiliry.ensurePrefix(format, FATAL_MESSAGE_PREFIX), arg1, arg2);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * fatal レベルのログ出力(フォーマット指定)
     * 
     * @param format    フォーマット文字列
     * @param arguments 3 つ以上の引数のリスト
     */
    public void fatal(CommonData data, String format, Object... arguments) {
        try {
            this.putMdc(data);
            this.logger.error(CommonUtiliry.ensurePrefix(format, FATAL_MESSAGE_PREFIX), arguments);
        } finally {
            this.clearMdc();
        }
    }

    /**
     * fatal レベルの例外メッセージのログ出力
     * @param msg 例外メッセージ
     * @param t   ログに記録する例外
     */
    public void fatal(CommonData data, String msg, Throwable t) {
        try {
            this.putMdc(data);
            this.logger.error(CommonUtiliry.ensurePrefix(msg, FATAL_MESSAGE_PREFIX), t);
        } finally {
            this.clearMdc();
        }
    }
}
