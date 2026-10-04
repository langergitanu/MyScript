package com.myscript.nebo.note;

import com.myscript.nebo.note.p030ui.compose.CoverData;
import com.myscript.nebo.note.p030ui.compose.CoverKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.PersistentList;

/* JADX INFO: compiled from: NoteCreationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u000eHÆ\u0003Ja\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0014\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010'\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, m1599d2 = {"Lcom/myscript/nebo/note/NotebookDetailsState;", "", "showNotebookDetailsSection", "", "availablePageSizes", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/myscript/nebo/note/PageSize;", "pageSize", "availableOrientations", "Lcom/myscript/nebo/note/Orientation;", "availableCoverColors", "Lcom/myscript/nebo/note/ui/compose/CoverData;", "coverData", "coverColorIndex", "", "<init>", "(ZLkotlinx/collections/immutable/ImmutableList;Lcom/myscript/nebo/note/PageSize;Lkotlinx/collections/immutable/ImmutableList;Lkotlinx/collections/immutable/ImmutableList;Lcom/myscript/nebo/note/ui/compose/CoverData;I)V", "getShowNotebookDetailsSection", "()Z", "getAvailablePageSizes", "()Lkotlinx/collections/immutable/ImmutableList;", "getPageSize", "()Lcom/myscript/nebo/note/PageSize;", "getAvailableOrientations", "getAvailableCoverColors", "getCoverData", "()Lcom/myscript/nebo/note/ui/compose/CoverData;", "getCoverColorIndex", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class NotebookDetailsState {
    public static final int $stable = 0;
    private final ImmutableList<CoverData> availableCoverColors;
    private final ImmutableList<Orientation> availableOrientations;
    private final ImmutableList<PageSize> availablePageSizes;
    private final int coverColorIndex;
    private final CoverData coverData;
    private final PageSize pageSize;
    private final boolean showNotebookDetailsSection;

    public NotebookDetailsState() {
        this(false, null, null, null, null, null, 0, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotebookDetailsState copy$default(NotebookDetailsState notebookDetailsState, boolean z, ImmutableList immutableList, PageSize pageSize, ImmutableList immutableList2, ImmutableList immutableList3, CoverData coverData, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = notebookDetailsState.showNotebookDetailsSection;
        }
        if ((i2 & 2) != 0) {
            immutableList = notebookDetailsState.availablePageSizes;
        }
        if ((i2 & 4) != 0) {
            pageSize = notebookDetailsState.pageSize;
        }
        if ((i2 & 8) != 0) {
            immutableList2 = notebookDetailsState.availableOrientations;
        }
        if ((i2 & 16) != 0) {
            immutableList3 = notebookDetailsState.availableCoverColors;
        }
        if ((i2 & 32) != 0) {
            coverData = notebookDetailsState.coverData;
        }
        if ((i2 & 64) != 0) {
            i = notebookDetailsState.coverColorIndex;
        }
        CoverData coverData2 = coverData;
        int i3 = i;
        ImmutableList immutableList4 = immutableList3;
        PageSize pageSize2 = pageSize;
        return notebookDetailsState.copy(z, immutableList, pageSize2, immutableList2, immutableList4, coverData2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowNotebookDetailsSection() {
        return this.showNotebookDetailsSection;
    }

    public final ImmutableList<PageSize> component2() {
        return this.availablePageSizes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PageSize getPageSize() {
        return this.pageSize;
    }

    public final ImmutableList<Orientation> component4() {
        return this.availableOrientations;
    }

    public final ImmutableList<CoverData> component5() {
        return this.availableCoverColors;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CoverData getCoverData() {
        return this.coverData;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getCoverColorIndex() {
        return this.coverColorIndex;
    }

    public final NotebookDetailsState copy(boolean showNotebookDetailsSection, ImmutableList<? extends PageSize> availablePageSizes, PageSize pageSize, ImmutableList<? extends Orientation> availableOrientations, ImmutableList<CoverData> availableCoverColors, CoverData coverData, int coverColorIndex) {
        Intrinsics.checkNotNullParameter(availablePageSizes, "availablePageSizes");
        Intrinsics.checkNotNullParameter(pageSize, "pageSize");
        Intrinsics.checkNotNullParameter(availableOrientations, "availableOrientations");
        Intrinsics.checkNotNullParameter(availableCoverColors, "availableCoverColors");
        Intrinsics.checkNotNullParameter(coverData, "coverData");
        return new NotebookDetailsState(showNotebookDetailsSection, availablePageSizes, pageSize, availableOrientations, availableCoverColors, coverData, coverColorIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotebookDetailsState)) {
            return false;
        }
        NotebookDetailsState notebookDetailsState = (NotebookDetailsState) other;
        return this.showNotebookDetailsSection == notebookDetailsState.showNotebookDetailsSection && Intrinsics.areEqual(this.availablePageSizes, notebookDetailsState.availablePageSizes) && this.pageSize == notebookDetailsState.pageSize && Intrinsics.areEqual(this.availableOrientations, notebookDetailsState.availableOrientations) && Intrinsics.areEqual(this.availableCoverColors, notebookDetailsState.availableCoverColors) && Intrinsics.areEqual(this.coverData, notebookDetailsState.coverData) && this.coverColorIndex == notebookDetailsState.coverColorIndex;
    }

    public int hashCode() {
        return (((((((((((Boolean.hashCode(this.showNotebookDetailsSection) * 31) + this.availablePageSizes.hashCode()) * 31) + this.pageSize.hashCode()) * 31) + this.availableOrientations.hashCode()) * 31) + this.availableCoverColors.hashCode()) * 31) + this.coverData.hashCode()) * 31) + Integer.hashCode(this.coverColorIndex);
    }

    public String toString() {
        return "NotebookDetailsState(showNotebookDetailsSection=" + this.showNotebookDetailsSection + ", availablePageSizes=" + this.availablePageSizes + ", pageSize=" + this.pageSize + ", availableOrientations=" + this.availableOrientations + ", availableCoverColors=" + this.availableCoverColors + ", coverData=" + this.coverData + ", coverColorIndex=" + this.coverColorIndex + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NotebookDetailsState(boolean z, ImmutableList<? extends PageSize> availablePageSizes, PageSize pageSize, ImmutableList<? extends Orientation> availableOrientations, ImmutableList<CoverData> availableCoverColors, CoverData coverData, int i) {
        Intrinsics.checkNotNullParameter(availablePageSizes, "availablePageSizes");
        Intrinsics.checkNotNullParameter(pageSize, "pageSize");
        Intrinsics.checkNotNullParameter(availableOrientations, "availableOrientations");
        Intrinsics.checkNotNullParameter(availableCoverColors, "availableCoverColors");
        Intrinsics.checkNotNullParameter(coverData, "coverData");
        this.showNotebookDetailsSection = z;
        this.availablePageSizes = availablePageSizes;
        this.pageSize = pageSize;
        this.availableOrientations = availableOrientations;
        this.availableCoverColors = availableCoverColors;
        this.coverData = coverData;
        this.coverColorIndex = i;
    }

    public final boolean getShowNotebookDetailsSection() {
        return this.showNotebookDetailsSection;
    }

    public /* synthetic */ NotebookDetailsState(boolean z, PersistentList<PageSize> persistentList, PageSize pageSize, PersistentList<Orientation> persistentList2, PersistentList<CoverData> persistentList3, CoverData coverData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? NoteCreationViewModelKt.getPageSizes() : persistentList, (i2 & 4) != 0 ? PageSize.f1373A4 : pageSize, (i2 & 8) != 0 ? NoteCreationViewModelKt.getOrientations() : persistentList2, (i2 & 16) != 0 ? CoverKt.getCoverColorsList() : persistentList3, (i2 & 32) != 0 ? (CoverData) CollectionsKt.first((List) CoverKt.getCoverColorsList()) : coverData, (i2 & 64) != 0 ? 0 : i);
    }

    public final ImmutableList<PageSize> getAvailablePageSizes() {
        return this.availablePageSizes;
    }

    public final PageSize getPageSize() {
        return this.pageSize;
    }

    public final ImmutableList<Orientation> getAvailableOrientations() {
        return this.availableOrientations;
    }

    public final ImmutableList<CoverData> getAvailableCoverColors() {
        return this.availableCoverColors;
    }

    public final CoverData getCoverData() {
        return this.coverData;
    }

    public final int getCoverColorIndex() {
        return this.coverColorIndex;
    }
}
