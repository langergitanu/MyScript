package com.myscript.nebo.grid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/grid/OEMOfferDialogState;", "", "show", "", "illustration", "", "title", "message", "<init>", "(ZIII)V", "getShow", "()Z", "getIllustration", "()I", "getTitle", "getMessage", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class OEMOfferDialogState {
    public static final int $stable = 0;
    private final int illustration;
    private final int message;
    private final boolean show;
    private final int title;

    public OEMOfferDialogState() {
        this(false, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ OEMOfferDialogState copy$default(OEMOfferDialogState oEMOfferDialogState, boolean z, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = oEMOfferDialogState.show;
        }
        if ((i4 & 2) != 0) {
            i = oEMOfferDialogState.illustration;
        }
        if ((i4 & 4) != 0) {
            i2 = oEMOfferDialogState.title;
        }
        if ((i4 & 8) != 0) {
            i3 = oEMOfferDialogState.message;
        }
        return oEMOfferDialogState.copy(z, i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIllustration() {
        return this.illustration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMessage() {
        return this.message;
    }

    public final OEMOfferDialogState copy(boolean show, int illustration, int title, int message) {
        return new OEMOfferDialogState(show, illustration, title, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OEMOfferDialogState)) {
            return false;
        }
        OEMOfferDialogState oEMOfferDialogState = (OEMOfferDialogState) other;
        return this.show == oEMOfferDialogState.show && this.illustration == oEMOfferDialogState.illustration && this.title == oEMOfferDialogState.title && this.message == oEMOfferDialogState.message;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.show) * 31) + Integer.hashCode(this.illustration)) * 31) + Integer.hashCode(this.title)) * 31) + Integer.hashCode(this.message);
    }

    public String toString() {
        return "OEMOfferDialogState(show=" + this.show + ", illustration=" + this.illustration + ", title=" + this.title + ", message=" + this.message + ")";
    }

    public OEMOfferDialogState(boolean z, int i, int i2, int i3) {
        this.show = z;
        this.illustration = i;
        this.title = i2;
        this.message = i3;
    }

    public /* synthetic */ OEMOfferDialogState(boolean z, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    public final boolean getShow() {
        return this.show;
    }

    public final int getIllustration() {
        return this.illustration;
    }

    public final int getTitle() {
        return this.title;
    }

    public final int getMessage() {
        return this.message;
    }
}
