package com.dropbox.core.p013v2;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DbxPathV2 {
    public static boolean isValid(String str) {
        return findError(str) == null;
    }

    public static String findError(String str) {
        if (str.length() == 0) {
            return null;
        }
        if (!str.startsWith(DomExceptionUtils.SEPARATOR)) {
            return "expecting first character to be \"/\"";
        }
        if (str.endsWith(DomExceptionUtils.SEPARATOR)) {
            return "must not end with \"/\"";
        }
        return null;
    }

    public static String getName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'path' can't be null");
        }
        if (str.length() == 0) {
            return null;
        }
        if (!str.startsWith(DomExceptionUtils.SEPARATOR)) {
            throw new IllegalArgumentException("Not a valid path.  Doesn't start with a \"/\": \"" + str + "\"");
        }
        if (str.endsWith(DomExceptionUtils.SEPARATOR)) {
            throw new IllegalArgumentException("Not a valid path.  Ends with a \"/\": \"" + str + "\"");
        }
        int length = str.length();
        do {
            length--;
        } while (str.charAt(length) != '/');
        return str.substring(length + 1);
    }

    public static String[] split(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'path' can't be null");
        }
        if (str.length() == 0) {
            return new String[0];
        }
        if (!str.startsWith(DomExceptionUtils.SEPARATOR)) {
            throw new IllegalArgumentException("Not a valid path.  Doesn't start with a \"/\": \"" + str + "\"");
        }
        if (!str.endsWith(DomExceptionUtils.SEPARATOR)) {
            return str.substring(1).split(DomExceptionUtils.SEPARATOR);
        }
        throw new IllegalArgumentException("Not a valid path.  Ends with a \"/\": \"" + str + "\"");
    }

    public static String getParent(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'path' can't be null");
        }
        if (str.length() == 0) {
            return null;
        }
        if (!str.startsWith(DomExceptionUtils.SEPARATOR)) {
            throw new IllegalArgumentException("Not a valid path.  Doesn't start with a \"/\": \"" + str + "\"");
        }
        if (str.endsWith(DomExceptionUtils.SEPARATOR)) {
            throw new IllegalArgumentException("Not a valid path.  Ends with a \"/\": \"" + str + "\"");
        }
        return str.substring(0, str.lastIndexOf(DomExceptionUtils.SEPARATOR));
    }
}
