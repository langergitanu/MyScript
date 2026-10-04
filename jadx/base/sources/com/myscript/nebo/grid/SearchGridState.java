package com.myscript.nebo.grid;

import com.myscript.snt.core.NotebookKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/grid/SearchGridState;", "", "<init>", "()V", "SearchInterrupted", "SearchGridStartedDocument", "SearchGridEndedDocument", "Lcom/myscript/nebo/grid/SearchGridState$SearchGridEndedDocument;", "Lcom/myscript/nebo/grid/SearchGridState$SearchGridStartedDocument;", "Lcom/myscript/nebo/grid/SearchGridState$SearchInterrupted;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class SearchGridState {
    public static final int $stable = 0;

    public /* synthetic */ SearchGridState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/myscript/nebo/grid/SearchGridState$SearchInterrupted;", "Lcom/myscript/nebo/grid/SearchGridState;", "<init>", "()V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class SearchInterrupted extends SearchGridState {
        public static final int $stable = 0;
        public static final SearchInterrupted INSTANCE = new SearchInterrupted();

        private SearchInterrupted() {
            super(null);
        }
    }

    private SearchGridState() {
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/myscript/nebo/grid/SearchGridState$SearchGridStartedDocument;", "Lcom/myscript/nebo/grid/SearchGridState;", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "<init>", "(Lcom/myscript/snt/core/NotebookKey;)V", "getNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SearchGridStartedDocument extends SearchGridState {
        public static final int $stable = 8;
        private final NotebookKey notebookKey;

        public static /* synthetic */ SearchGridStartedDocument copy$default(SearchGridStartedDocument searchGridStartedDocument, NotebookKey notebookKey, int i, Object obj) {
            if ((i & 1) != 0) {
                notebookKey = searchGridStartedDocument.notebookKey;
            }
            return searchGridStartedDocument.copy(notebookKey);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final NotebookKey getNotebookKey() {
            return this.notebookKey;
        }

        public final SearchGridStartedDocument copy(NotebookKey notebookKey) {
            Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
            return new SearchGridStartedDocument(notebookKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SearchGridStartedDocument) && Intrinsics.areEqual(this.notebookKey, ((SearchGridStartedDocument) other).notebookKey);
        }

        public int hashCode() {
            return this.notebookKey.hashCode();
        }

        public String toString() {
            return "SearchGridStartedDocument(notebookKey=" + this.notebookKey + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchGridStartedDocument(NotebookKey notebookKey) {
            super(null);
            Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
            this.notebookKey = notebookKey;
        }

        public final NotebookKey getNotebookKey() {
            return this.notebookKey;
        }
    }

    /* JADX INFO: compiled from: GridViewModel.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/grid/SearchGridState$SearchGridEndedDocument;", "Lcom/myscript/nebo/grid/SearchGridState;", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "hitCount", "", "<init>", "(Lcom/myscript/snt/core/NotebookKey;I)V", "getNotebookKey", "()Lcom/myscript/snt/core/NotebookKey;", "getHitCount", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SearchGridEndedDocument extends SearchGridState {
        public static final int $stable = 8;
        private final int hitCount;
        private final NotebookKey notebookKey;

        public static /* synthetic */ SearchGridEndedDocument copy$default(SearchGridEndedDocument searchGridEndedDocument, NotebookKey notebookKey, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                notebookKey = searchGridEndedDocument.notebookKey;
            }
            if ((i2 & 2) != 0) {
                i = searchGridEndedDocument.hitCount;
            }
            return searchGridEndedDocument.copy(notebookKey, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final NotebookKey getNotebookKey() {
            return this.notebookKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getHitCount() {
            return this.hitCount;
        }

        public final SearchGridEndedDocument copy(NotebookKey notebookKey, int hitCount) {
            Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
            return new SearchGridEndedDocument(notebookKey, hitCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchGridEndedDocument)) {
                return false;
            }
            SearchGridEndedDocument searchGridEndedDocument = (SearchGridEndedDocument) other;
            return Intrinsics.areEqual(this.notebookKey, searchGridEndedDocument.notebookKey) && this.hitCount == searchGridEndedDocument.hitCount;
        }

        public int hashCode() {
            return (this.notebookKey.hashCode() * 31) + Integer.hashCode(this.hitCount);
        }

        public String toString() {
            return "SearchGridEndedDocument(notebookKey=" + this.notebookKey + ", hitCount=" + this.hitCount + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchGridEndedDocument(NotebookKey notebookKey, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(notebookKey, "notebookKey");
            this.notebookKey = notebookKey;
            this.hitCount = i;
        }

        public final int getHitCount() {
            return this.hitCount;
        }

        public final NotebookKey getNotebookKey() {
            return this.notebookKey;
        }
    }
}
