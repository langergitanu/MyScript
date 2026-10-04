package com.myscript.nebo.editing;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, m1599d2 = {"Lcom/myscript/nebo/editing/ZoomState;", "", "locked", "", "notifyLocked", "factor", "", "intermediate", "ready", "<init>", "(ZZFZZ)V", "getLocked", "()Z", "getNotifyLocked", "getFactor", "()F", "getIntermediate", "getReady", "zoomLevel", "", "getZoomLevel", "()I", "toString", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ZoomState {
    public static final int $stable = 0;
    private final float factor;
    private final boolean intermediate;
    private final boolean locked;
    private final boolean notifyLocked;
    private final boolean ready;

    public ZoomState() {
        this(false, false, 0.0f, false, false, 31, null);
    }

    public static /* synthetic */ ZoomState copy$default(ZoomState zoomState, boolean z, boolean z2, float f, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = zoomState.locked;
        }
        if ((i & 2) != 0) {
            z2 = zoomState.notifyLocked;
        }
        if ((i & 4) != 0) {
            f = zoomState.factor;
        }
        if ((i & 8) != 0) {
            z3 = zoomState.intermediate;
        }
        if ((i & 16) != 0) {
            z4 = zoomState.ready;
        }
        boolean z5 = z4;
        float f2 = f;
        return zoomState.copy(z, z2, f2, z3, z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLocked() {
        return this.locked;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getNotifyLocked() {
        return this.notifyLocked;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getFactor() {
        return this.factor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIntermediate() {
        return this.intermediate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getReady() {
        return this.ready;
    }

    public final ZoomState copy(boolean locked, boolean notifyLocked, float factor, boolean intermediate, boolean ready) {
        return new ZoomState(locked, notifyLocked, factor, intermediate, ready);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZoomState)) {
            return false;
        }
        ZoomState zoomState = (ZoomState) other;
        return this.locked == zoomState.locked && this.notifyLocked == zoomState.notifyLocked && Float.compare(this.factor, zoomState.factor) == 0 && this.intermediate == zoomState.intermediate && this.ready == zoomState.ready;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.locked) * 31) + Boolean.hashCode(this.notifyLocked)) * 31) + Float.hashCode(this.factor)) * 31) + Boolean.hashCode(this.intermediate)) * 31) + Boolean.hashCode(this.ready);
    }

    public ZoomState(boolean z, boolean z2, float f, boolean z3, boolean z4) {
        this.locked = z;
        this.notifyLocked = z2;
        this.factor = f;
        this.intermediate = z3;
        this.ready = z4;
    }

    public /* synthetic */ ZoomState(boolean z, boolean z2, float f, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? 1.0f : f, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
    }

    public final boolean getLocked() {
        return this.locked;
    }

    public final boolean getNotifyLocked() {
        return this.notifyLocked;
    }

    public final float getFactor() {
        return this.factor;
    }

    public final boolean getIntermediate() {
        return this.intermediate;
    }

    public final boolean getReady() {
        return this.ready;
    }

    public final int getZoomLevel() {
        return (int) Math.floor(((double) (this.factor * 100)) + 0.5d);
    }

    public String toString() {
        String str = String.format("%.02f%%", Arrays.copyOf(new Object[]{Float.valueOf(this.factor * 100.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return StringsKt.trimEnd((CharSequence) (str + " " + (this.intermediate ? "🤏" : "") + " " + (this.locked ? "🔒" : "") + " " + (this.ready ? "" : "⌛"))).toString();
    }
}
