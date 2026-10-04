package com.myscript.nebo.note;

import com.myscript.nebo.note.p030ui.PageBackgroundColor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.PersistentList;

/* JADX INFO: compiled from: NoteCreationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/note/PageColorState;", "", "showPageColorSection", "", "colors", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/myscript/nebo/note/ui/PageBackgroundColor;", "<init>", "(ZLkotlinx/collections/immutable/ImmutableList;)V", "getShowPageColorSection", "()Z", "getColors", "()Lkotlinx/collections/immutable/ImmutableList;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class PageColorState {
    public static final int $stable = 0;
    private final ImmutableList<PageBackgroundColor> colors;
    private final boolean showPageColorSection;

    /* JADX WARN: Multi-variable type inference failed */
    public PageColorState() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageColorState copy$default(PageColorState pageColorState, boolean z, ImmutableList immutableList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pageColorState.showPageColorSection;
        }
        if ((i & 2) != 0) {
            immutableList = pageColorState.colors;
        }
        return pageColorState.copy(z, immutableList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowPageColorSection() {
        return this.showPageColorSection;
    }

    public final ImmutableList<PageBackgroundColor> component2() {
        return this.colors;
    }

    public final PageColorState copy(boolean showPageColorSection, ImmutableList<PageBackgroundColor> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new PageColorState(showPageColorSection, colors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageColorState)) {
            return false;
        }
        PageColorState pageColorState = (PageColorState) other;
        return this.showPageColorSection == pageColorState.showPageColorSection && Intrinsics.areEqual(this.colors, pageColorState.colors);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.showPageColorSection) * 31) + this.colors.hashCode();
    }

    public String toString() {
        return "PageColorState(showPageColorSection=" + this.showPageColorSection + ", colors=" + this.colors + ")";
    }

    public PageColorState(boolean z, ImmutableList<PageBackgroundColor> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.showPageColorSection = z;
        this.colors = colors;
    }

    public final boolean getShowPageColorSection() {
        return this.showPageColorSection;
    }

    public /* synthetic */ PageColorState(boolean z, PersistentList<PageBackgroundColor> persistentList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? NoteCreationViewModelKt.getPageBackgroundColors() : persistentList);
    }

    public final ImmutableList<PageBackgroundColor> getColors() {
        return this.colors;
    }
}
