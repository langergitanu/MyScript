package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public interface CloudIntegrationLogger {
    boolean allowColors();

    void flush();

    void log(String str);

    void logLine(String str);
}
