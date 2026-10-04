package com.samsung.android.spen.libwrapper.utils;

/* JADX INFO: loaded from: classes8.dex */
public class PlatformException extends Exception {
    public static final String SDL = "SDL";

    /* JADX INFO: renamed from: SE */
    public static final String f2253SE = "SE";
    private Throwable cause;

    public PlatformException() {
        super(String.format("Samsung platform API is not supported on the current platform.", new Object[0]));
    }

    public PlatformException(Throwable th) {
        super(String.format("Samsung platform API is not supported on the current platform.", new Object[0]));
        this.cause = th.getCause();
    }

    public PlatformException(String str) {
        super(String.format("%s API is not supported on the current platform.", str));
    }

    public PlatformException(String str, Throwable th) {
        super(String.format("%s API is not supported on the current platform.", str));
        this.cause = th.getCause();
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
