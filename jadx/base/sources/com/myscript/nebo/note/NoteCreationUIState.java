package com.myscript.nebo.note;

import com.myscript.nebo.LaunchActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoteCreationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003JO\u0010#\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\u0014\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006)"}, m1599d2 = {"Lcom/myscript/nebo/note/NoteCreationUIState;", "", "dialogTitle", "", "noteName", "", "noteNameHint", "notebookDetailsState", "Lcom/myscript/nebo/note/NotebookDetailsState;", "pageColorState", "Lcom/myscript/nebo/note/PageColorState;", "pagePatternState", "Lcom/myscript/nebo/note/PagePatternState;", LaunchActivity.LaunchRoute.Language, "<init>", "(ILjava/lang/String;ILcom/myscript/nebo/note/NotebookDetailsState;Lcom/myscript/nebo/note/PageColorState;Lcom/myscript/nebo/note/PagePatternState;Ljava/lang/String;)V", "getDialogTitle", "()I", "getNoteName", "()Ljava/lang/String;", "getNoteNameHint", "getNotebookDetailsState", "()Lcom/myscript/nebo/note/NotebookDetailsState;", "getPageColorState", "()Lcom/myscript/nebo/note/PageColorState;", "getPagePatternState", "()Lcom/myscript/nebo/note/PagePatternState;", "getLanguage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class NoteCreationUIState {
    public static final int $stable = 0;
    private final int dialogTitle;
    private final String language;
    private final String noteName;
    private final int noteNameHint;
    private final NotebookDetailsState notebookDetailsState;
    private final PageColorState pageColorState;
    private final PagePatternState pagePatternState;

    public NoteCreationUIState() {
        this(0, null, 0, null, null, null, null, 127, null);
    }

    public static /* synthetic */ NoteCreationUIState copy$default(NoteCreationUIState noteCreationUIState, int i, String str, int i2, NotebookDetailsState notebookDetailsState, PageColorState pageColorState, PagePatternState pagePatternState, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = noteCreationUIState.dialogTitle;
        }
        if ((i3 & 2) != 0) {
            str = noteCreationUIState.noteName;
        }
        if ((i3 & 4) != 0) {
            i2 = noteCreationUIState.noteNameHint;
        }
        if ((i3 & 8) != 0) {
            notebookDetailsState = noteCreationUIState.notebookDetailsState;
        }
        if ((i3 & 16) != 0) {
            pageColorState = noteCreationUIState.pageColorState;
        }
        if ((i3 & 32) != 0) {
            pagePatternState = noteCreationUIState.pagePatternState;
        }
        if ((i3 & 64) != 0) {
            str2 = noteCreationUIState.language;
        }
        PagePatternState pagePatternState2 = pagePatternState;
        String str3 = str2;
        PageColorState pageColorState2 = pageColorState;
        int i4 = i2;
        return noteCreationUIState.copy(i, str, i4, notebookDetailsState, pageColorState2, pagePatternState2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDialogTitle() {
        return this.dialogTitle;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNoteName() {
        return this.noteName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getNoteNameHint() {
        return this.noteNameHint;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final NotebookDetailsState getNotebookDetailsState() {
        return this.notebookDetailsState;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PageColorState getPageColorState() {
        return this.pageColorState;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PagePatternState getPagePatternState() {
        return this.pagePatternState;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    public final NoteCreationUIState copy(int dialogTitle, String noteName, int noteNameHint, NotebookDetailsState notebookDetailsState, PageColorState pageColorState, PagePatternState pagePatternState, String language) {
        Intrinsics.checkNotNullParameter(noteName, "noteName");
        Intrinsics.checkNotNullParameter(notebookDetailsState, "notebookDetailsState");
        Intrinsics.checkNotNullParameter(pageColorState, "pageColorState");
        Intrinsics.checkNotNullParameter(pagePatternState, "pagePatternState");
        Intrinsics.checkNotNullParameter(language, "language");
        return new NoteCreationUIState(dialogTitle, noteName, noteNameHint, notebookDetailsState, pageColorState, pagePatternState, language);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoteCreationUIState)) {
            return false;
        }
        NoteCreationUIState noteCreationUIState = (NoteCreationUIState) other;
        return this.dialogTitle == noteCreationUIState.dialogTitle && Intrinsics.areEqual(this.noteName, noteCreationUIState.noteName) && this.noteNameHint == noteCreationUIState.noteNameHint && Intrinsics.areEqual(this.notebookDetailsState, noteCreationUIState.notebookDetailsState) && Intrinsics.areEqual(this.pageColorState, noteCreationUIState.pageColorState) && Intrinsics.areEqual(this.pagePatternState, noteCreationUIState.pagePatternState) && Intrinsics.areEqual(this.language, noteCreationUIState.language);
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.dialogTitle) * 31) + this.noteName.hashCode()) * 31) + Integer.hashCode(this.noteNameHint)) * 31) + this.notebookDetailsState.hashCode()) * 31) + this.pageColorState.hashCode()) * 31) + this.pagePatternState.hashCode()) * 31) + this.language.hashCode();
    }

    public String toString() {
        return "NoteCreationUIState(dialogTitle=" + this.dialogTitle + ", noteName=" + this.noteName + ", noteNameHint=" + this.noteNameHint + ", notebookDetailsState=" + this.notebookDetailsState + ", pageColorState=" + this.pageColorState + ", pagePatternState=" + this.pagePatternState + ", language=" + this.language + ")";
    }

    public NoteCreationUIState(int i, String noteName, int i2, NotebookDetailsState notebookDetailsState, PageColorState pageColorState, PagePatternState pagePatternState, String language) {
        Intrinsics.checkNotNullParameter(noteName, "noteName");
        Intrinsics.checkNotNullParameter(notebookDetailsState, "notebookDetailsState");
        Intrinsics.checkNotNullParameter(pageColorState, "pageColorState");
        Intrinsics.checkNotNullParameter(pagePatternState, "pagePatternState");
        Intrinsics.checkNotNullParameter(language, "language");
        this.dialogTitle = i;
        this.noteName = noteName;
        this.noteNameHint = i2;
        this.notebookDetailsState = notebookDetailsState;
        this.pageColorState = pageColorState;
        this.pagePatternState = pagePatternState;
        this.language = language;
    }

    public /* synthetic */ NoteCreationUIState(int i, String str, int i2, NotebookDetailsState notebookDetailsState, PageColorState pageColorState, PagePatternState pagePatternState, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? new NotebookDetailsState(false, null, null, null, null, null, 0, 127, null) : notebookDetailsState, (i3 & 16) != 0 ? new PageColorState(false, null, 3, null) : pageColorState, (i3 & 32) != 0 ? new PagePatternState(false, null, 3, null) : pagePatternState, (i3 & 64) != 0 ? "" : str2);
    }

    public final int getDialogTitle() {
        return this.dialogTitle;
    }

    public final String getNoteName() {
        return this.noteName;
    }

    public final int getNoteNameHint() {
        return this.noteNameHint;
    }

    public final NotebookDetailsState getNotebookDetailsState() {
        return this.notebookDetailsState;
    }

    public final PageColorState getPageColorState() {
        return this.pageColorState;
    }

    public final PagePatternState getPagePatternState() {
        return this.pagePatternState;
    }

    public final String getLanguage() {
        return this.language;
    }
}
