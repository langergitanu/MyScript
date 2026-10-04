package com.myscript.nebo.note;

import com.myscript.nebo.note.p030ui.PageBackgroundPattern;
import com.myscript.nebo.note.p030ui.PageBackgroundPatternKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.PersistentList;

/* JADX INFO: compiled from: NoteCreationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/note/PagePatternState;", "", "showPagePatternSection", "", "patterns", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/myscript/nebo/note/ui/PageBackgroundPattern;", "<init>", "(ZLkotlinx/collections/immutable/ImmutableList;)V", "getShowPagePatternSection", "()Z", "getPatterns", "()Lkotlinx/collections/immutable/ImmutableList;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class PagePatternState {
    public static final int $stable = 0;
    private final ImmutableList<PageBackgroundPattern> patterns;
    private final boolean showPagePatternSection;

    /* JADX WARN: Multi-variable type inference failed */
    public PagePatternState() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PagePatternState copy$default(PagePatternState pagePatternState, boolean z, ImmutableList immutableList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pagePatternState.showPagePatternSection;
        }
        if ((i & 2) != 0) {
            immutableList = pagePatternState.patterns;
        }
        return pagePatternState.copy(z, immutableList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowPagePatternSection() {
        return this.showPagePatternSection;
    }

    public final ImmutableList<PageBackgroundPattern> component2() {
        return this.patterns;
    }

    public final PagePatternState copy(boolean showPagePatternSection, ImmutableList<PageBackgroundPattern> patterns) {
        Intrinsics.checkNotNullParameter(patterns, "patterns");
        return new PagePatternState(showPagePatternSection, patterns);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagePatternState)) {
            return false;
        }
        PagePatternState pagePatternState = (PagePatternState) other;
        return this.showPagePatternSection == pagePatternState.showPagePatternSection && Intrinsics.areEqual(this.patterns, pagePatternState.patterns);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.showPagePatternSection) * 31) + this.patterns.hashCode();
    }

    public String toString() {
        return "PagePatternState(showPagePatternSection=" + this.showPagePatternSection + ", patterns=" + this.patterns + ")";
    }

    public PagePatternState(boolean z, ImmutableList<PageBackgroundPattern> patterns) {
        Intrinsics.checkNotNullParameter(patterns, "patterns");
        this.showPagePatternSection = z;
        this.patterns = patterns;
    }

    public final boolean getShowPagePatternSection() {
        return this.showPagePatternSection;
    }

    public /* synthetic */ PagePatternState(boolean z, PersistentList<PageBackgroundPattern> persistentList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? PageBackgroundPatternKt.getPageBackgroundPatterns() : persistentList);
    }

    public final ImmutableList<PageBackgroundPattern> getPatterns() {
        return this.patterns;
    }
}
