package com.myscript.nebo.editing;

import com.myscript.snt.core.PageKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NoteEditorViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0016¨\u0006\""}, m1599d2 = {"Lcom/myscript/nebo/editing/NoteProperties;", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "noteName", "", "folderName", "lang", "fileExtension", "<init>", "(Lcom/myscript/snt/core/PageKey;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "getNoteName", "()Ljava/lang/String;", "getFolderName", "getLang", "getFileExtension", "displayedLang", "getDisplayedLang", "isEditable", "", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class NoteProperties {
    public static final int $stable = 8;
    private final String displayedLang;
    private final String fileExtension;
    private final String folderName;
    private final boolean isEditable;
    private final String lang;
    private final String noteName;
    private final PageKey pageKey;

    public NoteProperties() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ NoteProperties copy$default(NoteProperties noteProperties, PageKey pageKey, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            pageKey = noteProperties.pageKey;
        }
        if ((i & 2) != 0) {
            str = noteProperties.noteName;
        }
        if ((i & 4) != 0) {
            str2 = noteProperties.folderName;
        }
        if ((i & 8) != 0) {
            str3 = noteProperties.lang;
        }
        if ((i & 16) != 0) {
            str4 = noteProperties.fileExtension;
        }
        String str5 = str4;
        String str6 = str2;
        return noteProperties.copy(pageKey, str, str6, str3, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PageKey getPageKey() {
        return this.pageKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNoteName() {
        return this.noteName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFolderName() {
        return this.folderName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFileExtension() {
        return this.fileExtension;
    }

    public final NoteProperties copy(PageKey pageKey, String noteName, String folderName, String lang, String fileExtension) {
        Intrinsics.checkNotNullParameter(noteName, "noteName");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(fileExtension, "fileExtension");
        return new NoteProperties(pageKey, noteName, folderName, lang, fileExtension);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoteProperties)) {
            return false;
        }
        NoteProperties noteProperties = (NoteProperties) other;
        return Intrinsics.areEqual(this.pageKey, noteProperties.pageKey) && Intrinsics.areEqual(this.noteName, noteProperties.noteName) && Intrinsics.areEqual(this.folderName, noteProperties.folderName) && Intrinsics.areEqual(this.lang, noteProperties.lang) && Intrinsics.areEqual(this.fileExtension, noteProperties.fileExtension);
    }

    public int hashCode() {
        PageKey pageKey = this.pageKey;
        return ((((((((pageKey == null ? 0 : pageKey.hashCode()) * 31) + this.noteName.hashCode()) * 31) + this.folderName.hashCode()) * 31) + this.lang.hashCode()) * 31) + this.fileExtension.hashCode();
    }

    public String toString() {
        return "NoteProperties(pageKey=" + this.pageKey + ", noteName=" + this.noteName + ", folderName=" + this.folderName + ", lang=" + this.lang + ", fileExtension=" + this.fileExtension + ")";
    }

    public NoteProperties(PageKey pageKey, String noteName, String folderName, String lang, String fileExtension) {
        Intrinsics.checkNotNullParameter(noteName, "noteName");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(fileExtension, "fileExtension");
        this.pageKey = pageKey;
        this.noteName = noteName;
        this.folderName = folderName;
        this.lang = lang;
        this.fileExtension = fileExtension;
        this.displayedLang = StringsKt.replace$default(lang, "_", "-", false, 4, (Object) null);
        this.isEditable = pageKey != null && folderName.length() > 0 && lang.length() > 0;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ NoteProperties(com.myscript.snt.core.PageKey r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L5
            r2 = 0
        L5:
            r8 = r7 & 2
            java.lang.String r0 = ""
            if (r8 == 0) goto Lc
            r3 = r0
        Lc:
            r8 = r7 & 4
            if (r8 == 0) goto L11
            r4 = r0
        L11:
            r8 = r7 & 8
            if (r8 == 0) goto L16
            r5 = r0
        L16:
            r7 = r7 & 16
            if (r7 == 0) goto L21
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L27
        L21:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L27:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.myscript.nebo.editing.NoteProperties.<init>(com.myscript.snt.core.PageKey, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final PageKey getPageKey() {
        return this.pageKey;
    }

    public final String getNoteName() {
        return this.noteName;
    }

    public final String getFolderName() {
        return this.folderName;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getFileExtension() {
        return this.fileExtension;
    }

    public final String getDisplayedLang() {
        return this.displayedLang;
    }

    /* JADX INFO: renamed from: isEditable, reason: from getter */
    public final boolean getIsEditable() {
        return this.isEditable;
    }
}
