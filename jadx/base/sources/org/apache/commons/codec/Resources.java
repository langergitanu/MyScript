package org.apache.commons.codec;

import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class Resources {
    public static InputStream getInputStream(String str) {
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        throw new IllegalArgumentException("Unable to resolve required resource: " + str);
    }

    @Deprecated
    public Resources() {
    }
}
