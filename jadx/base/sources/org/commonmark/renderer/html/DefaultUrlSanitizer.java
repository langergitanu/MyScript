package org.commonmark.renderer.html;

import androidx.webkit.ProxyConfig;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultUrlSanitizer implements UrlSanitizer {
    private Set<String> protocols;

    private boolean isHtmlSpace(int i) {
        return i == 9 || i == 10 || i == 12 || i == 13 || i == 32;
    }

    public DefaultUrlSanitizer() {
        this(Arrays.asList("http", ProxyConfig.MATCH_HTTPS, "mailto"));
    }

    public DefaultUrlSanitizer(Collection<String> collection) {
        this.protocols = new HashSet(collection);
    }

    @Override // org.commonmark.renderer.html.UrlSanitizer
    public String sanitizeLinkUrl(String str) {
        String strStripHtmlSpaces = stripHtmlSpaces(str);
        int length = strStripHtmlSpaces.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = strStripHtmlSpaces.charAt(i);
            if (cCharAt == '#' || cCharAt == '/') {
                return strStripHtmlSpaces;
            }
            if (cCharAt == ':') {
                return !this.protocols.contains(strStripHtmlSpaces.substring(0, i).toLowerCase()) ? "" : strStripHtmlSpaces;
            }
            if (cCharAt == '?') {
                return strStripHtmlSpaces;
            }
        }
        return strStripHtmlSpaces;
    }

    @Override // org.commonmark.renderer.html.UrlSanitizer
    public String sanitizeImageUrl(String str) {
        return sanitizeLinkUrl(str);
    }

    private String stripHtmlSpaces(String str) {
        int length = str.length();
        while (length > 0 && isHtmlSpace(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        while (i < length && isHtmlSpace(str.charAt(i))) {
            i++;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }
}
