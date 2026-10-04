package com.myscript.nebo.analytics.firebase;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NeboFirebaseEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/analytics/firebase/PremiumModalOrigin;", "", "origin", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOrigin", "()Ljava/lang/String;", "None", "Settings", "CreateDocumentBoard", "ImportPDF", "Banner", "Convert", "Scratch", "AICanvas", "AIStudy", "Shape", "Math", "AddPDFPage", "DuplicateNote", "Sync", "LongPageBanner", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PremiumModalOrigin {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PremiumModalOrigin[] $VALUES;
    private final String origin;
    public static final PremiumModalOrigin None = new PremiumModalOrigin("None", 0, "");
    public static final PremiumModalOrigin Settings = new PremiumModalOrigin("Settings", 1, "panel_settings_cta");
    public static final PremiumModalOrigin CreateDocumentBoard = new PremiumModalOrigin("CreateDocumentBoard", 2, "create_doc_board_gridview");
    public static final PremiumModalOrigin ImportPDF = new PremiumModalOrigin("ImportPDF", 3, "create_PDF_gridview");
    public static final PremiumModalOrigin Banner = new PremiumModalOrigin("Banner", 4, "gridview_banner");
    public static final PremiumModalOrigin Convert = new PremiumModalOrigin("Convert", 5, "convert");
    public static final PremiumModalOrigin Scratch = new PremiumModalOrigin("Scratch", 6, "scratch");
    public static final PremiumModalOrigin AICanvas = new PremiumModalOrigin("AICanvas", 7, "ai_canvas");
    public static final PremiumModalOrigin AIStudy = new PremiumModalOrigin("AIStudy", 8, "ai_study_set");
    public static final PremiumModalOrigin Shape = new PremiumModalOrigin("Shape", 9, "shape");
    public static final PremiumModalOrigin Math = new PremiumModalOrigin("Math", 10, "math");
    public static final PremiumModalOrigin AddPDFPage = new PremiumModalOrigin("AddPDFPage", 11, "add_page_to_pdf");
    public static final PremiumModalOrigin DuplicateNote = new PremiumModalOrigin("DuplicateNote", 12, "duplicate_note");
    public static final PremiumModalOrigin Sync = new PremiumModalOrigin("Sync", 13, "sync");
    public static final PremiumModalOrigin LongPageBanner = new PremiumModalOrigin("LongPageBanner", 14, "long_page_banner");

    private static final /* synthetic */ PremiumModalOrigin[] $values() {
        return new PremiumModalOrigin[]{None, Settings, CreateDocumentBoard, ImportPDF, Banner, Convert, Scratch, AICanvas, AIStudy, Shape, Math, AddPDFPage, DuplicateNote, Sync, LongPageBanner};
    }

    public static EnumEntries<PremiumModalOrigin> getEntries() {
        return $ENTRIES;
    }

    public static PremiumModalOrigin valueOf(String str) {
        return (PremiumModalOrigin) Enum.valueOf(PremiumModalOrigin.class, str);
    }

    public static PremiumModalOrigin[] values() {
        return (PremiumModalOrigin[]) $VALUES.clone();
    }

    private PremiumModalOrigin(String str, int i, String str2) {
        this.origin = str2;
    }

    public final String getOrigin() {
        return this.origin;
    }

    static {
        PremiumModalOrigin[] premiumModalOriginArr$values = $values();
        $VALUES = premiumModalOriginArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(premiumModalOriginArr$values);
    }
}
