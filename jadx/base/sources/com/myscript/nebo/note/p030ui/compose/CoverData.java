package com.myscript.nebo.note.p030ui.compose;

import androidx.compose.p004ui.graphics.Color;
import com.myscript.nebo.note.Orientation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

/* JADX INFO: compiled from: cover.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/note/ui/compose/CoverData;", "", "colors", "Lkotlinx/collections/immutable/ImmutableList;", "Landroidx/compose/ui/graphics/Color;", "orientation", "Lcom/myscript/nebo/note/Orientation;", "<init>", "(Lkotlinx/collections/immutable/ImmutableList;Lcom/myscript/nebo/note/Orientation;)V", "getColors", "()Lkotlinx/collections/immutable/ImmutableList;", "getOrientation", "()Lcom/myscript/nebo/note/Orientation;", "pillColor", "getPillColor-0d7_KjU", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class CoverData {
    public static final int $stable = 0;
    private final ImmutableList<Color> colors;
    private final Orientation orientation;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CoverData copy$default(CoverData coverData, ImmutableList immutableList, Orientation orientation, int i, Object obj) {
        if ((i & 1) != 0) {
            immutableList = coverData.colors;
        }
        if ((i & 2) != 0) {
            orientation = coverData.orientation;
        }
        return coverData.copy(immutableList, orientation);
    }

    public final ImmutableList<Color> component1() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final CoverData copy(ImmutableList<Color> colors, Orientation orientation) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return new CoverData(colors, orientation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoverData)) {
            return false;
        }
        CoverData coverData = (CoverData) other;
        return Intrinsics.areEqual(this.colors, coverData.colors) && this.orientation == coverData.orientation;
    }

    public int hashCode() {
        return (this.colors.hashCode() * 31) + this.orientation.hashCode();
    }

    public String toString() {
        return "CoverData(colors=" + this.colors + ", orientation=" + this.orientation + ")";
    }

    public CoverData(ImmutableList<Color> colors, Orientation orientation) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.colors = colors;
        this.orientation = orientation;
    }

    public final ImmutableList<Color> getColors() {
        return this.colors;
    }

    public /* synthetic */ CoverData(ImmutableList immutableList, Orientation orientation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(immutableList, (i & 2) != 0 ? Orientation.Portrait : orientation);
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* JADX INFO: renamed from: getPillColor-0d7_KjU, reason: not valid java name */
    public final long m13291getPillColor0d7_KjU() {
        Color color = (Color) CollectionsKt.firstOrNull((List) this.colors);
        return color != null ? color.m8158unboximpl() : Color.INSTANCE.m8181getMagenta0d7_KjU();
    }
}
