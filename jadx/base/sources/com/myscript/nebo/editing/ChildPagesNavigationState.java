package com.myscript.nebo.editing;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChildPagesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0014\u001a\u00020\u0003H\u0096\u0080\u0004J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPagesNavigationState;", "", "selectedPageId", "", "selectedPageNumber", "", "isUserAction", "", "pageCount", "isNavigationWidgetVisible", "closeSearch", "<init>", "(Ljava/lang/String;IZIZZ)V", "getSelectedPageId", "()Ljava/lang/String;", "getSelectedPageNumber", "()I", "()Z", "getPageCount", "getCloseSearch", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ChildPagesNavigationState {
    public static final int $stable = 0;
    private final boolean closeSearch;
    private final boolean isNavigationWidgetVisible;
    private final boolean isUserAction;
    private final int pageCount;
    private final String selectedPageId;
    private final int selectedPageNumber;

    public ChildPagesNavigationState() {
        this(null, 0, false, 0, false, false, 63, null);
    }

    public static /* synthetic */ ChildPagesNavigationState copy$default(ChildPagesNavigationState childPagesNavigationState, String str, int i, boolean z, int i2, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = childPagesNavigationState.selectedPageId;
        }
        if ((i3 & 2) != 0) {
            i = childPagesNavigationState.selectedPageNumber;
        }
        if ((i3 & 4) != 0) {
            z = childPagesNavigationState.isUserAction;
        }
        if ((i3 & 8) != 0) {
            i2 = childPagesNavigationState.pageCount;
        }
        if ((i3 & 16) != 0) {
            z2 = childPagesNavigationState.isNavigationWidgetVisible;
        }
        if ((i3 & 32) != 0) {
            z3 = childPagesNavigationState.closeSearch;
        }
        boolean z4 = z2;
        boolean z5 = z3;
        return childPagesNavigationState.copy(str, i, z, i2, z4, z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSelectedPageId() {
        return this.selectedPageId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSelectedPageNumber() {
        return this.selectedPageNumber;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsUserAction() {
        return this.isUserAction;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPageCount() {
        return this.pageCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsNavigationWidgetVisible() {
        return this.isNavigationWidgetVisible;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCloseSearch() {
        return this.closeSearch;
    }

    public final ChildPagesNavigationState copy(String selectedPageId, int selectedPageNumber, boolean isUserAction, int pageCount, boolean isNavigationWidgetVisible, boolean closeSearch) {
        return new ChildPagesNavigationState(selectedPageId, selectedPageNumber, isUserAction, pageCount, isNavigationWidgetVisible, closeSearch);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChildPagesNavigationState)) {
            return false;
        }
        ChildPagesNavigationState childPagesNavigationState = (ChildPagesNavigationState) other;
        return Intrinsics.areEqual(this.selectedPageId, childPagesNavigationState.selectedPageId) && this.selectedPageNumber == childPagesNavigationState.selectedPageNumber && this.isUserAction == childPagesNavigationState.isUserAction && this.pageCount == childPagesNavigationState.pageCount && this.isNavigationWidgetVisible == childPagesNavigationState.isNavigationWidgetVisible && this.closeSearch == childPagesNavigationState.closeSearch;
    }

    public int hashCode() {
        String str = this.selectedPageId;
        return ((((((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.selectedPageNumber)) * 31) + Boolean.hashCode(this.isUserAction)) * 31) + Integer.hashCode(this.pageCount)) * 31) + Boolean.hashCode(this.isNavigationWidgetVisible)) * 31) + Boolean.hashCode(this.closeSearch);
    }

    public ChildPagesNavigationState(String str, int i, boolean z, int i2, boolean z2, boolean z3) {
        this.selectedPageId = str;
        this.selectedPageNumber = i;
        this.isUserAction = z;
        this.pageCount = i2;
        this.isNavigationWidgetVisible = z2;
        this.closeSearch = z3;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ ChildPagesNavigationState(java.lang.String r2, int r3, boolean r4, int r5, boolean r6, boolean r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L5
            r2 = 0
        L5:
            r9 = r8 & 2
            r0 = 0
            if (r9 == 0) goto Lb
            r3 = r0
        Lb:
            r9 = r8 & 4
            if (r9 == 0) goto L10
            r4 = r0
        L10:
            r9 = r8 & 8
            if (r9 == 0) goto L15
            r5 = r0
        L15:
            r9 = r8 & 16
            if (r9 == 0) goto L1a
            r6 = r0
        L1a:
            r8 = r8 & 32
            if (r8 == 0) goto L26
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2d
        L26:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2d:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.myscript.nebo.editing.ChildPagesNavigationState.<init>(java.lang.String, int, boolean, int, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getSelectedPageId() {
        return this.selectedPageId;
    }

    public final int getSelectedPageNumber() {
        return this.selectedPageNumber;
    }

    public final boolean isUserAction() {
        return this.isUserAction;
    }

    public final int getPageCount() {
        return this.pageCount;
    }

    public final boolean isNavigationWidgetVisible() {
        return this.isNavigationWidgetVisible;
    }

    public final boolean getCloseSearch() {
        return this.closeSearch;
    }

    public String toString() {
        return this.selectedPageNumber + DomExceptionUtils.SEPARATOR + this.pageCount + " " + (this.isNavigationWidgetVisible ? "️" : "(hidden)");
    }
}
