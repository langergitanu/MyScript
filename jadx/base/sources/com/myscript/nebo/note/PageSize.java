package com.myscript.nebo.note;

import com.myscript.nebo.C6079R;
import com.myscript.snt.core.PaperSize;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NoteCreationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/note/PageSize;", "", "labelRes", "", "paperSize", "Lcom/myscript/snt/core/PaperSize;", "<init>", "(Ljava/lang/String;IILcom/myscript/snt/core/PaperSize;)V", "getLabelRes", "()I", "getPaperSize", "()Lcom/myscript/snt/core/PaperSize;", "A4", "A5", "A7", "Letter", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageSize {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PageSize[] $VALUES;

    /* JADX INFO: renamed from: A4 */
    public static final PageSize f1373A4;

    /* JADX INFO: renamed from: A5 */
    public static final PageSize f1374A5;

    /* JADX INFO: renamed from: A7 */
    public static final PageSize f1375A7;
    public static final PageSize Letter;
    private final int labelRes;
    private final PaperSize paperSize;

    private static final /* synthetic */ PageSize[] $values() {
        return new PageSize[]{f1373A4, f1374A5, f1375A7, Letter};
    }

    public static EnumEntries<PageSize> getEntries() {
        return $ENTRIES;
    }

    public static PageSize valueOf(String str) {
        return (PageSize) Enum.valueOf(PageSize.class, str);
    }

    public static PageSize[] values() {
        return (PageSize[]) $VALUES.clone();
    }

    private PageSize(String str, int i, int i2, PaperSize paperSize) {
        this.labelRes = i2;
        this.paperSize = paperSize;
    }

    public final int getLabelRes() {
        return this.labelRes;
    }

    public final PaperSize getPaperSize() {
        return this.paperSize;
    }

    static {
        int i = C6079R.string.paper_size_a4;
        PaperSize a4 = PaperSize.getA4();
        Intrinsics.checkNotNullExpressionValue(a4, "getA4(...)");
        f1373A4 = new PageSize("A4", 0, i, a4);
        int i2 = C6079R.string.paper_size_a5;
        PaperSize a5 = PaperSize.getA5();
        Intrinsics.checkNotNullExpressionValue(a5, "getA5(...)");
        f1374A5 = new PageSize("A5", 1, i2, a5);
        int i3 = C6079R.string.paper_size_a7;
        PaperSize a7 = PaperSize.getA7();
        Intrinsics.checkNotNullExpressionValue(a7, "getA7(...)");
        f1375A7 = new PageSize("A7", 2, i3, a7);
        int i4 = C6079R.string.paper_size_letter;
        PaperSize uS_Letter = PaperSize.getUS_Letter();
        Intrinsics.checkNotNullExpressionValue(uS_Letter, "getUS_Letter(...)");
        Letter = new PageSize("Letter", 3, i4, uS_Letter);
        PageSize[] pageSizeArr$values = $values();
        $VALUES = pageSizeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pageSizeArr$values);
    }
}
