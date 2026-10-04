package com.myscript.atk.core.p020ui;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeStroker<T> implements IStroker<T> {
    protected static final int ACTION_CLOSE = 3;
    protected static final int ACTION_LINE_TO = 1;
    protected static final int ACTION_MOVE_TO = 0;
    protected static final int ACTION_QUAD_TO = 2;

    public static native int getStroking(String str);

    public static native boolean isFill(int i);

    protected static native float[] strokeBufferedFromInkStroke(long j, long j2, float f, boolean z, int i, float f2);

    protected static native float[] strokeBufferedFromPath(long j, float f, boolean z, int i, float f2);

    NativeStroker() {
    }
}
