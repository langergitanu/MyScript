package com.revenuecat.purchases.common.remoteconfig;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GenerationGuardedCache.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\bJ\u001b\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0017"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/GenerationGuardedCache;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "cached", "getCached", "()Ljava/lang/Object;", "lastGeneration", "", "lock", "value", "Ljava/lang/Object;", "invalidate", "", "generation", "isAtOrAbove", "", "isCurrent", "isWarm", "isWarmAtOrAbove", "store", "newValue", "(ILjava/lang/Object;)V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class GenerationGuardedCache<T> {
    private volatile T value;
    private final Object lock = new Object();
    private int lastGeneration = -1;

    public final T getCached() {
        return this.value;
    }

    public final boolean isWarm() {
        return this.value != null;
    }

    public final boolean isAtOrAbove(int generation) {
        boolean z;
        synchronized (this.lock) {
            z = this.lastGeneration >= generation;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isWarmAtOrAbove(int generation) {
        boolean z;
        synchronized (this.lock) {
            if (this.lastGeneration >= generation) {
                z = this.value != null;
            }
        }
        return z;
    }

    public final boolean isCurrent(int generation) {
        boolean z;
        synchronized (this.lock) {
            z = generation >= this.lastGeneration;
        }
        return z;
    }

    public final void store(int generation, T newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        synchronized (this.lock) {
            if (generation >= this.lastGeneration) {
                this.lastGeneration = generation;
                this.value = newValue;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void invalidate(int generation) {
        synchronized (this.lock) {
            if (generation >= this.lastGeneration) {
                this.lastGeneration = generation;
                this.value = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
