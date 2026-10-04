package com.myscript.nebo.editing;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.errorprone.annotations.Immutable;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.dms.core.model.SelectionState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ChildPagesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Immutable
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0003\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\n\u0010$\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003Jo\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0014\u00100\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00063"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPage;", "", "id", "", "isActive", "", "pageNumber", "", "width", "height", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "backgroundPattern", "Lcom/myscript/atk/core/BackgroundPattern;", "thumbnailFilepath", "isCorrupted", "selectionState", "Lcom/myscript/nebo/dms/core/model/SelectionState;", "<init>", "(Ljava/lang/String;ZIIIILcom/myscript/atk/core/BackgroundPattern;Ljava/lang/String;ZLcom/myscript/nebo/dms/core/model/SelectionState;)V", "getId", "()Ljava/lang/String;", "()Z", "getPageNumber", "()I", "getWidth", "getHeight", "getBackgroundColor", "getBackgroundPattern", "()Lcom/myscript/atk/core/BackgroundPattern;", "getThumbnailFilepath", "getSelectionState", "()Lcom/myscript/nebo/dms/core/model/SelectionState;", "aspectRatio", "", "getAspectRatio", "()F", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ChildPage {
    public static final int $stable = 0;
    private final float aspectRatio;
    private final int backgroundColor;
    private final BackgroundPattern backgroundPattern;
    private final int height;
    private final String id;
    private final boolean isActive;
    private final boolean isCorrupted;
    private final int pageNumber;
    private final SelectionState selectionState;
    private final String thumbnailFilepath;
    private final int width;

    public static /* synthetic */ ChildPage copy$default(ChildPage childPage, String str, boolean z, int i, int i2, int i3, int i4, BackgroundPattern backgroundPattern, String str2, boolean z2, SelectionState selectionState, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = childPage.id;
        }
        if ((i5 & 2) != 0) {
            z = childPage.isActive;
        }
        if ((i5 & 4) != 0) {
            i = childPage.pageNumber;
        }
        if ((i5 & 8) != 0) {
            i2 = childPage.width;
        }
        if ((i5 & 16) != 0) {
            i3 = childPage.height;
        }
        if ((i5 & 32) != 0) {
            i4 = childPage.backgroundColor;
        }
        if ((i5 & 64) != 0) {
            backgroundPattern = childPage.backgroundPattern;
        }
        if ((i5 & 128) != 0) {
            str2 = childPage.thumbnailFilepath;
        }
        if ((i5 & 256) != 0) {
            z2 = childPage.isCorrupted;
        }
        if ((i5 & 512) != 0) {
            selectionState = childPage.selectionState;
        }
        boolean z3 = z2;
        SelectionState selectionState2 = selectionState;
        BackgroundPattern backgroundPattern2 = backgroundPattern;
        String str3 = str2;
        int i6 = i3;
        int i7 = i4;
        return childPage.copy(str, z, i, i2, i6, i7, backgroundPattern2, str3, z3, selectionState2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final SelectionState getSelectionState() {
        return this.selectionState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPageNumber() {
        return this.pageNumber;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final BackgroundPattern getBackgroundPattern() {
        return this.backgroundPattern;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getThumbnailFilepath() {
        return this.thumbnailFilepath;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsCorrupted() {
        return this.isCorrupted;
    }

    public final ChildPage copy(String id, boolean isActive, int pageNumber, int width, int height, int backgroundColor, BackgroundPattern backgroundPattern, String thumbnailFilepath, boolean isCorrupted, SelectionState selectionState) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(backgroundPattern, "backgroundPattern");
        Intrinsics.checkNotNullParameter(selectionState, "selectionState");
        return new ChildPage(id, isActive, pageNumber, width, height, backgroundColor, backgroundPattern, thumbnailFilepath, isCorrupted, selectionState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChildPage)) {
            return false;
        }
        ChildPage childPage = (ChildPage) other;
        return Intrinsics.areEqual(this.id, childPage.id) && this.isActive == childPage.isActive && this.pageNumber == childPage.pageNumber && this.width == childPage.width && this.height == childPage.height && this.backgroundColor == childPage.backgroundColor && this.backgroundPattern == childPage.backgroundPattern && Intrinsics.areEqual(this.thumbnailFilepath, childPage.thumbnailFilepath) && this.isCorrupted == childPage.isCorrupted && this.selectionState == childPage.selectionState;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.id.hashCode() * 31) + Boolean.hashCode(this.isActive)) * 31) + Integer.hashCode(this.pageNumber)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.backgroundColor)) * 31) + this.backgroundPattern.hashCode()) * 31;
        String str = this.thumbnailFilepath;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isCorrupted)) * 31) + this.selectionState.hashCode();
    }

    public ChildPage(String id, boolean z, int i, int i2, int i3, int i4, BackgroundPattern backgroundPattern, String str, boolean z2, SelectionState selectionState) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(backgroundPattern, "backgroundPattern");
        Intrinsics.checkNotNullParameter(selectionState, "selectionState");
        this.id = id;
        this.isActive = z;
        this.pageNumber = i;
        this.width = i2;
        this.height = i3;
        this.backgroundColor = i4;
        this.backgroundPattern = backgroundPattern;
        this.thumbnailFilepath = str;
        this.isCorrupted = z2;
        this.selectionState = selectionState;
        this.aspectRatio = (i2 <= 0 || i3 <= 0) ? 1.0f : i2 / i3;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public /* synthetic */ ChildPage(String str, boolean z, int i, int i2, int i3, int i4, BackgroundPattern backgroundPattern, String str2, boolean z2, SelectionState selectionState, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, i, i2, i3, (i5 & 32) != 0 ? 16777215 : i4, (i5 & 64) != 0 ? BackgroundPattern.NONE : backgroundPattern, (i5 & 128) != 0 ? null : str2, (i5 & 256) != 0 ? false : z2, (i5 & 512) != 0 ? SelectionState.NOT_SELECTABLE : selectionState);
    }

    public final BackgroundPattern getBackgroundPattern() {
        return this.backgroundPattern;
    }

    public final String getThumbnailFilepath() {
        return this.thumbnailFilepath;
    }

    public final boolean isCorrupted() {
        return this.isCorrupted;
    }

    public final SelectionState getSelectionState() {
        return this.selectionState;
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public String toString() {
        String str = this.isActive ? "✓" : null;
        if (str == null) {
            str = "";
        }
        return StringsKt.padStart$default(String.valueOf(this.pageNumber), 4, (char) 0, 2, (Object) null) + " [" + (StringsKt.padStart$default(String.valueOf(this.width), 4, (char) 0, 2, (Object) null) + " x " + StringsKt.padStart$default(String.valueOf(this.height), 4, (char) 0, 2, (Object) null)) + "] (" + ("…" + StringsKt.takeLast(this.id, 15)) + ") " + str;
    }
}
