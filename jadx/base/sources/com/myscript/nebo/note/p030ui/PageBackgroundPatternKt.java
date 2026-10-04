package com.myscript.nebo.note.p030ui;

import com.myscript.atk.core.BackgroundPattern;
import kotlin.Metadata;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;

/* JADX INFO: compiled from: PageBackgroundPattern.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"pageBackgroundPatterns", "Lkotlinx/collections/immutable/PersistentList;", "Lcom/myscript/nebo/note/ui/PageBackgroundPattern;", "getPageBackgroundPatterns", "()Lkotlinx/collections/immutable/PersistentList;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PageBackgroundPatternKt {
    private static final PersistentList<PageBackgroundPattern> pageBackgroundPatterns = ExtensionsKt.persistentListOf(new PageBackgroundPattern(BackgroundPattern.NONE, false, 2, null), new PageBackgroundPattern(BackgroundPattern.DOTS, false, 2, null), new PageBackgroundPattern(BackgroundPattern.LINES, false, 2, null), new PageBackgroundPattern(BackgroundPattern.GRID, false, 2, null));

    public static final PersistentList<PageBackgroundPattern> getPageBackgroundPatterns() {
        return pageBackgroundPatterns;
    }
}
