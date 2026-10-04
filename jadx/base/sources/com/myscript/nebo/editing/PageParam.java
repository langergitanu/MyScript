package com.myscript.nebo.editing;

import com.myscript.snt.core.DisplayContext;
import com.myscript.snt.core.PageControllerSanitized;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.RecoContext;
import com.myscript.snt.core.SWIGOptionContext;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageLoader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageParam;", "", "<init>", "()V", "Standalone", "ByKey", "Lcom/myscript/nebo/editing/PageParam$ByKey;", "Lcom/myscript/nebo/editing/PageParam$Standalone;", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class PageParam {
    public /* synthetic */ PageParam(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: PageLoader.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageParam$Standalone;", "Lcom/myscript/nebo/editing/PageParam;", "workingDir", "Ljava/io/File;", "notebookFile", "pageIndex", "", "<init>", "(Ljava/io/File;Ljava/io/File;I)V", "getWorkingDir", "()Ljava/io/File;", "getNotebookFile", "getPageIndex", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Standalone extends PageParam {
        private final File notebookFile;
        private final int pageIndex;
        private final File workingDir;

        public static /* synthetic */ Standalone copy$default(Standalone standalone, File file, File file2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                file = standalone.workingDir;
            }
            if ((i2 & 2) != 0) {
                file2 = standalone.notebookFile;
            }
            if ((i2 & 4) != 0) {
                i = standalone.pageIndex;
            }
            return standalone.copy(file, file2, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getWorkingDir() {
            return this.workingDir;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final File getNotebookFile() {
            return this.notebookFile;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final Standalone copy(File workingDir, File notebookFile, int pageIndex) {
            Intrinsics.checkNotNullParameter(workingDir, "workingDir");
            Intrinsics.checkNotNullParameter(notebookFile, "notebookFile");
            return new Standalone(workingDir, notebookFile, pageIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Standalone)) {
                return false;
            }
            Standalone standalone = (Standalone) other;
            return Intrinsics.areEqual(this.workingDir, standalone.workingDir) && Intrinsics.areEqual(this.notebookFile, standalone.notebookFile) && this.pageIndex == standalone.pageIndex;
        }

        public int hashCode() {
            return (((this.workingDir.hashCode() * 31) + this.notebookFile.hashCode()) * 31) + Integer.hashCode(this.pageIndex);
        }

        public String toString() {
            return "Standalone(workingDir=" + this.workingDir + ", notebookFile=" + this.notebookFile + ", pageIndex=" + this.pageIndex + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Standalone(File workingDir, File notebookFile, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(workingDir, "workingDir");
            Intrinsics.checkNotNullParameter(notebookFile, "notebookFile");
            this.workingDir = workingDir;
            this.notebookFile = notebookFile;
            this.pageIndex = i;
        }

        public /* synthetic */ Standalone(File file, File file2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(file, file2, (i2 & 4) != 0 ? 0 : i);
        }

        public final File getWorkingDir() {
            return this.workingDir;
        }

        public final File getNotebookFile() {
            return this.notebookFile;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }
    }

    private PageParam() {
    }

    /* JADX INFO: compiled from: PageLoader.kt */
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012$\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003J;\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032&\b\u0002\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR/\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageParam$ByKey;", "Lcom/myscript/nebo/editing/PageParam;", "pageKey", "Lcom/myscript/snt/core/PageKey;", "pageControllerProvider", "Lkotlin/Function4;", "Lcom/myscript/snt/core/DisplayContext;", "Lcom/myscript/snt/core/RecoContext;", "Lcom/myscript/snt/core/SWIGOptionContext;", "Lcom/myscript/snt/core/PageControllerSanitized;", "<init>", "(Lcom/myscript/snt/core/PageKey;Lkotlin/jvm/functions/Function4;)V", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "getPageControllerProvider", "()Lkotlin/jvm/functions/Function4;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ByKey extends PageParam {
        private final Function4<PageKey, DisplayContext, RecoContext, SWIGOptionContext, PageControllerSanitized> pageControllerProvider;
        private final PageKey pageKey;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ByKey copy$default(ByKey byKey, PageKey pageKey, Function4 function4, int i, Object obj) {
            if ((i & 1) != 0) {
                pageKey = byKey.pageKey;
            }
            if ((i & 2) != 0) {
                function4 = byKey.pageControllerProvider;
            }
            return byKey.copy(pageKey, function4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PageKey getPageKey() {
            return this.pageKey;
        }

        public final Function4<PageKey, DisplayContext, RecoContext, SWIGOptionContext, PageControllerSanitized> component2() {
            return this.pageControllerProvider;
        }

        public final ByKey copy(PageKey pageKey, Function4<? super PageKey, ? super DisplayContext, ? super RecoContext, ? super SWIGOptionContext, ? extends PageControllerSanitized> pageControllerProvider) {
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            Intrinsics.checkNotNullParameter(pageControllerProvider, "pageControllerProvider");
            return new ByKey(pageKey, pageControllerProvider);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ByKey)) {
                return false;
            }
            ByKey byKey = (ByKey) other;
            return Intrinsics.areEqual(this.pageKey, byKey.pageKey) && Intrinsics.areEqual(this.pageControllerProvider, byKey.pageControllerProvider);
        }

        public int hashCode() {
            return (this.pageKey.hashCode() * 31) + this.pageControllerProvider.hashCode();
        }

        public String toString() {
            return "ByKey(pageKey=" + this.pageKey + ", pageControllerProvider=" + this.pageControllerProvider + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ByKey(PageKey pageKey, Function4<? super PageKey, ? super DisplayContext, ? super RecoContext, ? super SWIGOptionContext, ? extends PageControllerSanitized> pageControllerProvider) {
            super(null);
            Intrinsics.checkNotNullParameter(pageKey, "pageKey");
            Intrinsics.checkNotNullParameter(pageControllerProvider, "pageControllerProvider");
            this.pageKey = pageKey;
            this.pageControllerProvider = pageControllerProvider;
        }

        public final PageKey getPageKey() {
            return this.pageKey;
        }

        public final Function4<PageKey, DisplayContext, RecoContext, SWIGOptionContext, PageControllerSanitized> getPageControllerProvider() {
            return this.pageControllerProvider;
        }
    }
}
