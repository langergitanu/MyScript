package com.dropbox.core.p012v1;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.dropbox.core.util.StringUtil;

/* JADX INFO: loaded from: classes4.dex */
public class DbxPathV1 {
    public static boolean isValid(String str) {
        return findError(str) == null;
    }

    public static String findError(String str) {
        if (!str.startsWith(DomExceptionUtils.SEPARATOR)) {
            return "must start with \"/\"";
        }
        if (str.length() != 1 && str.endsWith(DomExceptionUtils.SEPARATOR)) {
            return "must not end with \"/\"";
        }
        return null;
    }

    public static void checkArg(String str, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException("'" + str + "' should not be null");
        }
        String strFindError = findError(str2);
        if (strFindError != null) {
            throw new IllegalArgumentException("'" + str + "': bad path: " + strFindError + ": " + StringUtil.m531jq(str2));
        }
    }

    public static void checkArgNonRoot(String str, String str2) {
        if (DomExceptionUtils.SEPARATOR.equals(str2)) {
            throw new IllegalArgumentException("'" + str + "' should not be the root path (\"/\")");
        }
        checkArg(str, str2);
    }

    public static String getName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'path' can't be null");
        }
        if (!str.startsWith(DomExceptionUtils.SEPARATOR)) {
            throw new IllegalArgumentException("Not a valid path.  Doesn't start with a \"/\": \"" + str + "\"");
        }
        if (str.length() > 1 && str.endsWith(DomExceptionUtils.SEPARATOR)) {
            throw new IllegalArgumentException("Not a valid path.  Ends with a \"/\": \"" + str + "\"");
        }
        int length = str.length() - 1;
        while (str.charAt(length) != '/') {
            length--;
        }
        return str.substring(length + 1);
    }

    public static String[] split(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'path' can't be null");
        }
        if (!str.startsWith(DomExceptionUtils.SEPARATOR)) {
            throw new IllegalArgumentException("Not a valid path.  Doesn't start with a \"/\": \"" + str + "\"");
        }
        if (str.length() <= 1 || !str.endsWith(DomExceptionUtils.SEPARATOR)) {
            return str.length() == 1 ? new String[0] : str.substring(1).split(DomExceptionUtils.SEPARATOR);
        }
        throw new IllegalArgumentException("Not a valid path.  Ends with a \"/\": \"" + str + "\"");
    }

    public static String getParent(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'path' can't be null");
        }
        if (!str.startsWith(DomExceptionUtils.SEPARATOR)) {
            throw new IllegalArgumentException("Not a valid path.  Doesn't start with a \"/\": \"" + str + "\"");
        }
        if (str.length() > 1 && str.endsWith(DomExceptionUtils.SEPARATOR)) {
            throw new IllegalArgumentException("Not a valid path.  Ends with a \"/\": \"" + str + "\"");
        }
        int iLastIndexOf = str.lastIndexOf(DomExceptionUtils.SEPARATOR);
        if (str.length() == 1) {
            return null;
        }
        if (iLastIndexOf == 0) {
            return DomExceptionUtils.SEPARATOR;
        }
        return str.substring(0, iLastIndexOf);
    }
}
