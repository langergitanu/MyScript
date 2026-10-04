package com.myscript.nebo.grid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J1\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/grid/SidePanelState;", "", "isSidePanelOpen", "", "showContentOverlay", "showMainNavigation", "isSideBySide", "<init>", "(ZZZZ)V", "()Z", "getShowContentOverlay", "getShowMainNavigation", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SidePanelState {
    public static final int $stable = 0;
    private final boolean isSideBySide;
    private final boolean isSidePanelOpen;
    private final boolean showContentOverlay;
    private final boolean showMainNavigation;

    public SidePanelState() {
        this(false, false, false, false, 15, null);
    }

    public static /* synthetic */ SidePanelState copy$default(SidePanelState sidePanelState, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sidePanelState.isSidePanelOpen;
        }
        if ((i & 2) != 0) {
            z2 = sidePanelState.showContentOverlay;
        }
        if ((i & 4) != 0) {
            z3 = sidePanelState.showMainNavigation;
        }
        if ((i & 8) != 0) {
            z4 = sidePanelState.isSideBySide;
        }
        return sidePanelState.copy(z, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsSidePanelOpen() {
        return this.isSidePanelOpen;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowContentOverlay() {
        return this.showContentOverlay;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowMainNavigation() {
        return this.showMainNavigation;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSideBySide() {
        return this.isSideBySide;
    }

    public final SidePanelState copy(boolean isSidePanelOpen, boolean showContentOverlay, boolean showMainNavigation, boolean isSideBySide) {
        return new SidePanelState(isSidePanelOpen, showContentOverlay, showMainNavigation, isSideBySide);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SidePanelState)) {
            return false;
        }
        SidePanelState sidePanelState = (SidePanelState) other;
        return this.isSidePanelOpen == sidePanelState.isSidePanelOpen && this.showContentOverlay == sidePanelState.showContentOverlay && this.showMainNavigation == sidePanelState.showMainNavigation && this.isSideBySide == sidePanelState.isSideBySide;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.isSidePanelOpen) * 31) + Boolean.hashCode(this.showContentOverlay)) * 31) + Boolean.hashCode(this.showMainNavigation)) * 31) + Boolean.hashCode(this.isSideBySide);
    }

    public String toString() {
        return "SidePanelState(isSidePanelOpen=" + this.isSidePanelOpen + ", showContentOverlay=" + this.showContentOverlay + ", showMainNavigation=" + this.showMainNavigation + ", isSideBySide=" + this.isSideBySide + ")";
    }

    public SidePanelState(boolean z, boolean z2, boolean z3, boolean z4) {
        this.isSidePanelOpen = z;
        this.showContentOverlay = z2;
        this.showMainNavigation = z3;
        this.isSideBySide = z4;
    }

    public /* synthetic */ SidePanelState(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4);
    }

    public final boolean isSidePanelOpen() {
        return this.isSidePanelOpen;
    }

    public final boolean getShowContentOverlay() {
        return this.showContentOverlay;
    }

    public final boolean getShowMainNavigation() {
        return this.showMainNavigation;
    }

    public final boolean isSideBySide() {
        return this.isSideBySide;
    }
}
