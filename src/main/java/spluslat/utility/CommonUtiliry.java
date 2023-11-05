package spluslat.utility;

public class CommonUtiliry {
    public static String ensurePrefix(String str, String prefix) {
        if (str == null) {
            return prefix;
        }
        if (!str.startsWith(prefix)) {
            str = prefix + str;
        }
        return str;
    }
}
