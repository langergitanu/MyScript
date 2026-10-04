package com.myscript.nebo.freemium;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FreemiumLimitationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007\u0012\b\b\u0003\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/freemium/FreemiumLimitationDialogState;", "", "trigger", "Lcom/myscript/nebo/freemium/FreemiumLimitationTrigger;", "isDialogVisible", "", "drawableResId", "", "titleResId", "textResId", "<init>", "(Lcom/myscript/nebo/freemium/FreemiumLimitationTrigger;ZIII)V", "getTrigger", "()Lcom/myscript/nebo/freemium/FreemiumLimitationTrigger;", "()Z", "getDrawableResId", "()I", "getTitleResId", "getTextResId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class FreemiumLimitationDialogState {
    public static final int $stable = 0;
    private final int drawableResId;
    private final boolean isDialogVisible;
    private final int textResId;
    private final int titleResId;
    private final FreemiumLimitationTrigger trigger;

    public FreemiumLimitationDialogState() {
        this(null, false, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ FreemiumLimitationDialogState copy$default(FreemiumLimitationDialogState freemiumLimitationDialogState, FreemiumLimitationTrigger freemiumLimitationTrigger, boolean z, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            freemiumLimitationTrigger = freemiumLimitationDialogState.trigger;
        }
        if ((i4 & 2) != 0) {
            z = freemiumLimitationDialogState.isDialogVisible;
        }
        if ((i4 & 4) != 0) {
            i = freemiumLimitationDialogState.drawableResId;
        }
        if ((i4 & 8) != 0) {
            i2 = freemiumLimitationDialogState.titleResId;
        }
        if ((i4 & 16) != 0) {
            i3 = freemiumLimitationDialogState.textResId;
        }
        int i5 = i3;
        int i6 = i;
        return freemiumLimitationDialogState.copy(freemiumLimitationTrigger, z, i6, i2, i5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FreemiumLimitationTrigger getTrigger() {
        return this.trigger;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsDialogVisible() {
        return this.isDialogVisible;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDrawableResId() {
        return this.drawableResId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTitleResId() {
        return this.titleResId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTextResId() {
        return this.textResId;
    }

    public final FreemiumLimitationDialogState copy(FreemiumLimitationTrigger trigger, boolean isDialogVisible, int drawableResId, int titleResId, int textResId) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        return new FreemiumLimitationDialogState(trigger, isDialogVisible, drawableResId, titleResId, textResId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FreemiumLimitationDialogState)) {
            return false;
        }
        FreemiumLimitationDialogState freemiumLimitationDialogState = (FreemiumLimitationDialogState) other;
        return this.trigger == freemiumLimitationDialogState.trigger && this.isDialogVisible == freemiumLimitationDialogState.isDialogVisible && this.drawableResId == freemiumLimitationDialogState.drawableResId && this.titleResId == freemiumLimitationDialogState.titleResId && this.textResId == freemiumLimitationDialogState.textResId;
    }

    public int hashCode() {
        return (((((((this.trigger.hashCode() * 31) + Boolean.hashCode(this.isDialogVisible)) * 31) + Integer.hashCode(this.drawableResId)) * 31) + Integer.hashCode(this.titleResId)) * 31) + Integer.hashCode(this.textResId);
    }

    public String toString() {
        return "FreemiumLimitationDialogState(trigger=" + this.trigger + ", isDialogVisible=" + this.isDialogVisible + ", drawableResId=" + this.drawableResId + ", titleResId=" + this.titleResId + ", textResId=" + this.textResId + ")";
    }

    public FreemiumLimitationDialogState(FreemiumLimitationTrigger trigger, boolean z, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        this.trigger = trigger;
        this.isDialogVisible = z;
        this.drawableResId = i;
        this.titleResId = i2;
        this.textResId = i3;
    }

    public /* synthetic */ FreemiumLimitationDialogState(FreemiumLimitationTrigger freemiumLimitationTrigger, boolean z, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? FreemiumLimitationTrigger.TRIGGER_NONE : freemiumLimitationTrigger, (i4 & 2) != 0 ? false : z, (i4 & 4) != 0 ? C6471R.drawable.freemium_limitation_sync : i, (i4 & 8) != 0 ? C6471R.string.freemium_limitation_dialog_convert_title : i2, (i4 & 16) != 0 ? C6471R.string.freemium_limitation_dialog_convert_text : i3);
    }

    public final FreemiumLimitationTrigger getTrigger() {
        return this.trigger;
    }

    public final boolean isDialogVisible() {
        return this.isDialogVisible;
    }

    public final int getDrawableResId() {
        return this.drawableResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final int getTextResId() {
        return this.textResId;
    }
}
