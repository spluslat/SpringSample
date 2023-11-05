package spluslat.utility;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

import spluslat.data.CommonData;

public class JoinPointUtility {
    /**
     * インスタンス化防止
     */
    private JoinPointUtility() {
        // NOP
    }

    /**
     * JoinPointからクラス名を取得する
     * @param joinPoint JoinPoint
     * @return クラス名
     */
    public static String getClassName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringTypeName();
    }

    /**
     * JoinPointからメソッド名を取得する
     * @param joinPoint JoinPoint
     * @return クラス名
     */
    public static String getMethodName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getName();
    }

    /**
     * JoinPointから引数を取得する
     * @param joinPoint JoinPoint
     * @return 引数
     */
    public static Object[] getArgs(JoinPoint joinPoint) {
        return joinPoint.getArgs();
    }

    /**
     * JoinPointから引数を取得する
     * @param joinPoint JoinPoint
     * @return 引数
     */
    public static String getArgsToString(JoinPoint joinPoint) {
        return Arrays.toString(JoinPointUtility.getArgs(joinPoint));
    }

    /**
     * JoinPointから引数内のCommonData型の変数を取得する
     * @param joinPoint JoinPoint
     * @return CommonData(存在しない場合は、null)
     */
    public static CommonData getCommonDataFromArgs(JoinPoint joinPoint) {
        CommonData commonData = null;
        for (Object arg : JoinPointUtility.getArgs(joinPoint)) {
            if (arg instanceof CommonData) {
                commonData = (CommonData) arg;
                break;
            }
        }
        return commonData;
    }
}
