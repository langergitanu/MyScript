package com.myscript.android.utils;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: StableIdKeyProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/myscript/android/utils/StableIdKeyProvider;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "ids", "", "", "currentId", "getItemId", "item", "(Ljava/lang/Object;)J", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StableIdKeyProvider<T> {
    public static final int $stable = 8;
    private final Map<T, Long> ids = new LinkedHashMap();
    private long currentId = -1;

    public final long getItemId(T item) {
        Long l = this.ids.get(item);
        if (l != null) {
            return l.longValue();
        }
        long j = this.currentId + 1;
        this.currentId = j;
        this.ids.put(item, Long.valueOf(j));
        return j;
    }
}
