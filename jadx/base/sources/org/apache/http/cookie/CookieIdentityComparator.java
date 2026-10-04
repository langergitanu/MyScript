package org.apache.http.cookie;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public class CookieIdentityComparator implements Serializable, Comparator<Cookie> {
    private static final long serialVersionUID = 4466565437490631532L;

    @Override // java.util.Comparator
    public int compare(Cookie cookie, Cookie cookie2) {
        int iCompareTo = cookie.getName().compareTo(cookie2.getName());
        if (iCompareTo == 0) {
            String domain = cookie.getDomain();
            String str = "";
            if (domain == null) {
                domain = "";
            } else if (domain.indexOf(46) == -1) {
                domain = domain + ".local";
            }
            String domain2 = cookie2.getDomain();
            if (domain2 != null) {
                str = domain2.indexOf(46) == -1 ? domain2 + ".local" : domain2;
            }
            iCompareTo = domain.compareToIgnoreCase(str);
        }
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        String path = cookie.getPath();
        String str2 = DomExceptionUtils.SEPARATOR;
        if (path == null) {
            path = DomExceptionUtils.SEPARATOR;
        }
        String path2 = cookie2.getPath();
        if (path2 != null) {
            str2 = path2;
        }
        return path.compareTo(str2);
    }
}
