package com.myscript.nebo.note;

import com.myscript.nebo.note.p030ui.compose.CoverData;
import com.myscript.nebo.note.p030ui.compose.CoverKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.PersistentList;

/* JADX INFO: compiled from: NoteEditingViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/note/NoteEditingUIState;", "", "noteTitle", "", "canEditCover", "", "availableNoteCovers", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/myscript/nebo/note/ui/compose/CoverData;", "noteCover", "<init>", "(Ljava/lang/String;ZLkotlinx/collections/immutable/ImmutableList;Lcom/myscript/nebo/note/ui/compose/CoverData;)V", "getNoteTitle", "()Ljava/lang/String;", "getCanEditCover", "()Z", "getAvailableNoteCovers", "()Lkotlinx/collections/immutable/ImmutableList;", "getNoteCover", "()Lcom/myscript/nebo/note/ui/compose/CoverData;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class NoteEditingUIState {
    public static final int $stable = 0;
    private final ImmutableList<CoverData> availableNoteCovers;
    private final boolean canEditCover;
    private final CoverData noteCover;
    private final String noteTitle;

    public NoteEditingUIState() {
        this(null, false, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NoteEditingUIState copy$default(NoteEditingUIState noteEditingUIState, String str, boolean z, ImmutableList immutableList, CoverData coverData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = noteEditingUIState.noteTitle;
        }
        if ((i & 2) != 0) {
            z = noteEditingUIState.canEditCover;
        }
        if ((i & 4) != 0) {
            immutableList = noteEditingUIState.availableNoteCovers;
        }
        if ((i & 8) != 0) {
            coverData = noteEditingUIState.noteCover;
        }
        return noteEditingUIState.copy(str, z, immutableList, coverData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNoteTitle() {
        return this.noteTitle;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanEditCover() {
        return this.canEditCover;
    }

    public final ImmutableList<CoverData> component3() {
        return this.availableNoteCovers;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CoverData getNoteCover() {
        return this.noteCover;
    }

    public final NoteEditingUIState copy(String noteTitle, boolean canEditCover, ImmutableList<CoverData> availableNoteCovers, CoverData noteCover) {
        Intrinsics.checkNotNullParameter(noteTitle, "noteTitle");
        Intrinsics.checkNotNullParameter(availableNoteCovers, "availableNoteCovers");
        Intrinsics.checkNotNullParameter(noteCover, "noteCover");
        return new NoteEditingUIState(noteTitle, canEditCover, availableNoteCovers, noteCover);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoteEditingUIState)) {
            return false;
        }
        NoteEditingUIState noteEditingUIState = (NoteEditingUIState) other;
        return Intrinsics.areEqual(this.noteTitle, noteEditingUIState.noteTitle) && this.canEditCover == noteEditingUIState.canEditCover && Intrinsics.areEqual(this.availableNoteCovers, noteEditingUIState.availableNoteCovers) && Intrinsics.areEqual(this.noteCover, noteEditingUIState.noteCover);
    }

    public int hashCode() {
        return (((((this.noteTitle.hashCode() * 31) + Boolean.hashCode(this.canEditCover)) * 31) + this.availableNoteCovers.hashCode()) * 31) + this.noteCover.hashCode();
    }

    public String toString() {
        return "NoteEditingUIState(noteTitle=" + this.noteTitle + ", canEditCover=" + this.canEditCover + ", availableNoteCovers=" + this.availableNoteCovers + ", noteCover=" + this.noteCover + ")";
    }

    public NoteEditingUIState(String noteTitle, boolean z, ImmutableList<CoverData> availableNoteCovers, CoverData noteCover) {
        Intrinsics.checkNotNullParameter(noteTitle, "noteTitle");
        Intrinsics.checkNotNullParameter(availableNoteCovers, "availableNoteCovers");
        Intrinsics.checkNotNullParameter(noteCover, "noteCover");
        this.noteTitle = noteTitle;
        this.canEditCover = z;
        this.availableNoteCovers = availableNoteCovers;
        this.noteCover = noteCover;
    }

    public /* synthetic */ NoteEditingUIState(String str, boolean z, PersistentList<CoverData> persistentList, CoverData coverData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? CoverKt.getCoverColorsList() : persistentList, (i & 8) != 0 ? new CoverData(ExtensionsKt.persistentListOf(), null, 2, null) : coverData);
    }

    public final String getNoteTitle() {
        return this.noteTitle;
    }

    public final boolean getCanEditCover() {
        return this.canEditCover;
    }

    public final ImmutableList<CoverData> getAvailableNoteCovers() {
        return this.availableNoteCovers;
    }

    public final CoverData getNoteCover() {
        return this.noteCover;
    }
}
