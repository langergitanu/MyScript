package com.myscript.nebo.editing;

import com.myscript.atk.core.BackgroundPattern;
import com.myscript.snt.core.PaperSize;
import com.myscript.snt.dms.PageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JG\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0014\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\tHÖ\u0081\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011¨\u0006%"}, m1599d2 = {"Lcom/myscript/nebo/editing/PageProperties;", "", "pageType", "Lcom/myscript/snt/dms/PageType;", "isSamplePage", "", "paperSize", "Lcom/myscript/snt/core/PaperSize;", "pageBackgroundColor", "", "pageBackgroundPattern", "Lcom/myscript/atk/core/BackgroundPattern;", "isCorrupted", "<init>", "(Lcom/myscript/snt/dms/PageType;ZLcom/myscript/snt/core/PaperSize;ILcom/myscript/atk/core/BackgroundPattern;Z)V", "getPageType", "()Lcom/myscript/snt/dms/PageType;", "()Z", "getPaperSize", "()Lcom/myscript/snt/core/PaperSize;", "getPageBackgroundColor", "()I", "getPageBackgroundPattern", "()Lcom/myscript/atk/core/BackgroundPattern;", "isFixedPageSize", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class PageProperties {
    public static final int $stable = 8;
    private final boolean isCorrupted;
    private final boolean isSamplePage;
    private final int pageBackgroundColor;
    private final BackgroundPattern pageBackgroundPattern;
    private final PageType pageType;
    private final PaperSize paperSize;

    public PageProperties() {
        this(null, false, null, 0, null, false, 63, null);
    }

    public static /* synthetic */ PageProperties copy$default(PageProperties pageProperties, PageType pageType, boolean z, PaperSize paperSize, int i, BackgroundPattern backgroundPattern, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            pageType = pageProperties.pageType;
        }
        if ((i2 & 2) != 0) {
            z = pageProperties.isSamplePage;
        }
        if ((i2 & 4) != 0) {
            paperSize = pageProperties.paperSize;
        }
        if ((i2 & 8) != 0) {
            i = pageProperties.pageBackgroundColor;
        }
        if ((i2 & 16) != 0) {
            backgroundPattern = pageProperties.pageBackgroundPattern;
        }
        if ((i2 & 32) != 0) {
            z2 = pageProperties.isCorrupted;
        }
        BackgroundPattern backgroundPattern2 = backgroundPattern;
        boolean z3 = z2;
        return pageProperties.copy(pageType, z, paperSize, i, backgroundPattern2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PageType getPageType() {
        return this.pageType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSamplePage() {
        return this.isSamplePage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PaperSize getPaperSize() {
        return this.paperSize;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPageBackgroundColor() {
        return this.pageBackgroundColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final BackgroundPattern getPageBackgroundPattern() {
        return this.pageBackgroundPattern;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsCorrupted() {
        return this.isCorrupted;
    }

    public final PageProperties copy(PageType pageType, boolean isSamplePage, PaperSize paperSize, int pageBackgroundColor, BackgroundPattern pageBackgroundPattern, boolean isCorrupted) {
        Intrinsics.checkNotNullParameter(paperSize, "paperSize");
        Intrinsics.checkNotNullParameter(pageBackgroundPattern, "pageBackgroundPattern");
        return new PageProperties(pageType, isSamplePage, paperSize, pageBackgroundColor, pageBackgroundPattern, isCorrupted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageProperties)) {
            return false;
        }
        PageProperties pageProperties = (PageProperties) other;
        return this.pageType == pageProperties.pageType && this.isSamplePage == pageProperties.isSamplePage && Intrinsics.areEqual(this.paperSize, pageProperties.paperSize) && this.pageBackgroundColor == pageProperties.pageBackgroundColor && this.pageBackgroundPattern == pageProperties.pageBackgroundPattern && this.isCorrupted == pageProperties.isCorrupted;
    }

    public int hashCode() {
        PageType pageType = this.pageType;
        return ((((((((((pageType == null ? 0 : pageType.hashCode()) * 31) + Boolean.hashCode(this.isSamplePage)) * 31) + this.paperSize.hashCode()) * 31) + Integer.hashCode(this.pageBackgroundColor)) * 31) + this.pageBackgroundPattern.hashCode()) * 31) + Boolean.hashCode(this.isCorrupted);
    }

    public String toString() {
        return "PageProperties(pageType=" + this.pageType + ", isSamplePage=" + this.isSamplePage + ", paperSize=" + this.paperSize + ", pageBackgroundColor=" + this.pageBackgroundColor + ", pageBackgroundPattern=" + this.pageBackgroundPattern + ", isCorrupted=" + this.isCorrupted + ")";
    }

    public PageProperties(PageType pageType, boolean z, PaperSize paperSize, int i, BackgroundPattern pageBackgroundPattern, boolean z2) {
        Intrinsics.checkNotNullParameter(paperSize, "paperSize");
        Intrinsics.checkNotNullParameter(pageBackgroundPattern, "pageBackgroundPattern");
        this.pageType = pageType;
        this.isSamplePage = z;
        this.paperSize = paperSize;
        this.pageBackgroundColor = i;
        this.pageBackgroundPattern = pageBackgroundPattern;
        this.isCorrupted = z2;
    }

    public final PageType getPageType() {
        return this.pageType;
    }

    public final boolean isSamplePage() {
        return this.isSamplePage;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ PageProperties(com.myscript.snt.dms.PageType r2, boolean r3, com.myscript.snt.core.PaperSize r4, int r5, com.myscript.atk.core.BackgroundPattern r6, boolean r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
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
            if (r9 == 0) goto L18
            com.myscript.snt.core.PaperSize r4 = com.myscript.snt.core.PaperSize.getUnlimited()
            java.lang.String r9 = "getUnlimited(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
        L18:
            r9 = r8 & 8
            if (r9 == 0) goto L1d
            r5 = r0
        L1d:
            r9 = r8 & 16
            if (r9 == 0) goto L23
            com.myscript.atk.core.BackgroundPattern r6 = com.myscript.atk.core.BackgroundPattern.GRID
        L23:
            r8 = r8 & 32
            if (r8 == 0) goto L2f
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L36
        L2f:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L36:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.myscript.nebo.editing.PageProperties.<init>(com.myscript.snt.dms.PageType, boolean, com.myscript.snt.core.PaperSize, int, com.myscript.atk.core.BackgroundPattern, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final PaperSize getPaperSize() {
        return this.paperSize;
    }

    public final int getPageBackgroundColor() {
        return this.pageBackgroundColor;
    }

    public final BackgroundPattern getPageBackgroundPattern() {
        return this.pageBackgroundPattern;
    }

    public final boolean isCorrupted() {
        return this.isCorrupted;
    }

    public final boolean isFixedPageSize() {
        return this.pageType == PageType.RawContent && !this.paperSize.isUnlimited();
    }
}
