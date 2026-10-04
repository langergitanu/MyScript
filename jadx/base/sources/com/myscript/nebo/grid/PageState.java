package com.myscript.nebo.grid;

import com.myscript.snt.core.PageKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/grid/PageState;", "", "<init>", "()V", "canOpenPage", "", "matches", "pageKey", "Lcom/myscript/snt/core/PageKey;", "Idle", "Opening", "Opened", "Lcom/myscript/nebo/grid/PageState$Idle;", "Lcom/myscript/nebo/grid/PageState$Opened;", "Lcom/myscript/nebo/grid/PageState$Opening;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class PageState {
    public static final int $stable = 0;

    public /* synthetic */ PageState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public boolean canOpenPage() {
        return false;
    }

    public abstract boolean matches(PageKey pageKey);

    private PageState() {
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0083\u0004J\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/grid/PageState$Idle;", "Lcom/myscript/nebo/grid/PageState;", "<init>", "()V", "canOpenPage", "", "matches", "pageKey", "Lcom/myscript/snt/core/PageKey;", "equals", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Idle extends PageState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        @Override // com.myscript.nebo.grid.PageState
        public boolean canOpenPage() {
            return true;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Idle)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 768615848;
        }

        @Override // com.myscript.nebo.grid.PageState
        public boolean matches(PageKey pageKey) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            return false;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/grid/PageState$Opening;", "Lcom/myscript/nebo/grid/PageState;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "<init>", "(Lcom/myscript/snt/core/PageKey;)V", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "matches", "", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Opening extends PageState {
        public static final int $stable = 8;
        private final PageKey pageKey;

        public static /* synthetic */ Opening copy$default(Opening opening, PageKey pageKey, int i, Object obj) {
            if ((i & 1) != 0) {
                pageKey = opening.pageKey;
            }
            return opening.copy(pageKey);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PageKey getPageKey() {
            return this.pageKey;
        }

        public final Opening copy(PageKey pageKey) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            return new Opening(pageKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Opening) && Intrinsics.areEqual(this.pageKey, ((Opening) other).pageKey);
        }

        public int hashCode() {
            return this.pageKey.hashCode();
        }

        public String toString() {
            return "Opening(pageKey=" + this.pageKey + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Opening(PageKey pageKey) {
            super(null);
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            this.pageKey = pageKey;
        }

        public final PageKey getPageKey() {
            return this.pageKey;
        }

        @Override // com.myscript.nebo.grid.PageState
        public boolean matches(PageKey pageKey) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            return Intrinsics.areEqual(this.pageKey, pageKey);
        }
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/grid/PageState$Opened;", "Lcom/myscript/nebo/grid/PageState;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "<init>", "(Lcom/myscript/snt/core/PageKey;)V", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "matches", "", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Opened extends PageState {
        public static final int $stable = 8;
        private final PageKey pageKey;

        public static /* synthetic */ Opened copy$default(Opened opened, PageKey pageKey, int i, Object obj) {
            if ((i & 1) != 0) {
                pageKey = opened.pageKey;
            }
            return opened.copy(pageKey);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PageKey getPageKey() {
            return this.pageKey;
        }

        public final Opened copy(PageKey pageKey) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            return new Opened(pageKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Opened) && Intrinsics.areEqual(this.pageKey, ((Opened) other).pageKey);
        }

        public int hashCode() {
            return this.pageKey.hashCode();
        }

        public String toString() {
            return "Opened(pageKey=" + this.pageKey + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Opened(PageKey pageKey) {
            super(null);
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            this.pageKey = pageKey;
        }

        public final PageKey getPageKey() {
            return this.pageKey;
        }

        @Override // com.myscript.nebo.grid.PageState
        public boolean matches(PageKey pageKey) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            return Intrinsics.areEqual(this.pageKey, pageKey);
        }
    }
}
