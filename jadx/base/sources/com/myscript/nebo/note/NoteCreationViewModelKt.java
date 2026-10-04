package com.myscript.nebo.note;

import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.note.p030ui.PageBackgroundColor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;

/* JADX INFO: compiled from: NoteCreationViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004¨\u0006\u000b"}, m1599d2 = {"pageBackgroundColors", "Lkotlinx/collections/immutable/PersistentList;", "Lcom/myscript/nebo/note/ui/PageBackgroundColor;", "getPageBackgroundColors", "()Lkotlinx/collections/immutable/PersistentList;", "pageSizes", "Lcom/myscript/nebo/note/PageSize;", "getPageSizes", "orientations", "Lcom/myscript/nebo/note/Orientation;", "getOrientations", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoteCreationViewModelKt {
    private static final PersistentList<Orientation> orientations;
    private static final PersistentList<PageBackgroundColor> pageBackgroundColors;
    private static final PersistentList<PageSize> pageSizes;

    static {
        List<Integer> light_background_colors = PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS();
        List<Integer> dark_background_colors = PageBackgroundUtilsKt.getDARK_BACKGROUND_COLORS();
        Iterator<T> it = light_background_colors.iterator();
        Iterator<T> it2 = dark_background_colors.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(light_background_colors, 10), CollectionsKt.collectionSizeOrDefault(dark_background_colors, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(new PageBackgroundColor(((Number) it.next()).intValue(), ((Number) it2.next()).intValue(), false, 4, null));
        }
        pageBackgroundColors = ExtensionsKt.toPersistentList(arrayList);
        pageSizes = ExtensionsKt.persistentListOf(PageSize.f1373A4, PageSize.f1374A5, PageSize.f1375A7, PageSize.Letter);
        orientations = ExtensionsKt.persistentListOf(Orientation.Portrait, Orientation.Landscape);
    }

    public static final PersistentList<PageBackgroundColor> getPageBackgroundColors() {
        return pageBackgroundColors;
    }

    public static final PersistentList<PageSize> getPageSizes() {
        return pageSizes;
    }

    public static final PersistentList<Orientation> getOrientations() {
        return orientations;
    }
}
