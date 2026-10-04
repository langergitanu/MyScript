package androidx.media3.common.util;

import androidx.media3.common.C2181C;

/* JADX INFO: loaded from: classes3.dex */
public interface TimestampIterator {
    TimestampIterator copyOf();

    default long getLastTimestampUs() {
        return C2181C.TIME_UNSET;
    }

    boolean hasNext();

    long next();
}
