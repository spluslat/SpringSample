package spluslat.aop;

import java.util.Locale;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import spluslat.constants.MessageKeyConstants;
import spluslat.utility.JoinPointUtility;
import spluslat.utility.LoggerWrapper;

/**
 * メソッド実行前後にログ出力するAOP
 */
@Aspect
@Component
public class CommonLoggingAspect {
	private LoggerWrapper logger = LoggerWrapper.getLogger(CommonLoggingAspect.class);
	// messageServiceを使用すると無限ループになるため、messagesMessageSourceを直接使用してメッセージを取得する
	@Autowired
	@Qualifier("messageMessageSource")
	private MessageSource messageMessageSource;

	// execution(戻り値 パッケージ名.クラス名.メソッド名(引数))
	@Before("(execution(* splusat..*(..)) || execution(public static * splusat.*.*(..)) ) && !within(splusat.config..*)")
	public void commonLogBefore(JoinPoint joinPoint) {
		Object[] msgArgs = new Object[] { JoinPointUtility.getMethodName(joinPoint),
				JoinPointUtility.getClassName(joinPoint), JoinPointUtility.getArgsToString(joinPoint) };
		String msg = messageMessageSource.getMessage(MessageKeyConstants.COMMON_LOG_START, msgArgs,
				Locale.getDefault());
		logger.info(JoinPointUtility.getCommonDataFromArgs(joinPoint), msg);
	}

	@AfterReturning(pointcut = "execution(* splusat..*(..)) && !within(splusat.config..*)", returning = "result")
	public void commonLogAfterReturning(JoinPoint joinPoint, Object result) {
		Object[] msgArgs = new Object[] { JoinPointUtility.getMethodName(joinPoint),
				JoinPointUtility.getClassName(joinPoint), String.valueOf(result) };
		String msg = messageMessageSource.getMessage(MessageKeyConstants.COMMON_LOG_END, msgArgs,
				Locale.getDefault());
		logger.info(JoinPointUtility.getCommonDataFromArgs(joinPoint), msg);
	}

	@AfterThrowing(pointcut = "execution(* splusat..*(..)) && !within(splusat.config..*)", throwing = "e")
	public void commonLogAfterThrowing(JoinPoint joinPoint, Exception e) {
		Object[] msgArgs = new Object[] { JoinPointUtility.getMethodName(joinPoint),
				JoinPointUtility.getClassName(joinPoint), e.getMessage() };
		String msg = messageMessageSource.getMessage(MessageKeyConstants.COMMON_LOG_EXCEPTION_END, msgArgs,
				Locale.getDefault());
		logger.info(JoinPointUtility.getCommonDataFromArgs(joinPoint), msg);
	}
}
