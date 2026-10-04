package com.chuckerteam.chucker.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ExportFormat.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1599d2 = {"Lcom/chuckerteam/chucker/api/ExportFormat;", "", "extension", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getExtension", "()Ljava/lang/String;", "LOG", "HAR", "com.github.ChuckerTeam.Chucker.library"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ExportFormat {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ExportFormat[] $VALUES;
    private final String extension;
    public static final ExportFormat LOG = new ExportFormat("LOG", 0, "txt");
    public static final ExportFormat HAR = new ExportFormat("HAR", 1, "har");

    private static final /* synthetic */ ExportFormat[] $values() {
        return new ExportFormat[]{LOG, HAR};
    }

    public static EnumEntries<ExportFormat> getEntries() {
        return $ENTRIES;
    }

    public static ExportFormat valueOf(String str) {
        return (ExportFormat) Enum.valueOf(ExportFormat.class, str);
    }

    public static ExportFormat[] values() {
        return (ExportFormat[]) $VALUES.clone();
    }

    private ExportFormat(String str, int i, String str2) {
        this.extension = str2;
    }

    public final String getExtension() {
        return this.extension;
    }

    static {
        ExportFormat[] exportFormatArr$values = $values();
        $VALUES = exportFormatArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(exportFormatArr$values);
    }
}
