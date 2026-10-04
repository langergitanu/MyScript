package com.myscript.nebo.screennavigation;

import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.dms.core.ContentInitializer;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.PaperSize;
import com.myscript.snt.dms.CoverColorUtilsExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InitialContent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001aH\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m1599d2 = {"createInitialNotebook", "Lcom/myscript/snt/core/PageKey;", "Lcom/myscript/nebo/dms/core/ContentInitializer;", "collectionName", "", "folderName", "folderColor", "", "notebookName", "notebookColor", "languageKey", "(Lcom/myscript/nebo/dms/core/ContentInitializer;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InitialContentKt {
    public static final Object createInitialNotebook(ContentInitializer contentInitializer, String str, String str2, int i, String str3, int i2, String str4, Continuation<? super PageKey> continuation) {
        NotebookKey notebookKeyCreateFolder;
        CollectionKey collectionKeyFindCollectionByName = contentInitializer.findCollectionByName(str);
        if ((collectionKeyFindCollectionByName == null && (collectionKeyFindCollectionByName = contentInitializer.createCollection(str)) == null) || (notebookKeyCreateFolder = contentInitializer.createFolder(collectionKeyFindCollectionByName, str2, i)) == null) {
            return null;
        }
        contentInitializer.setLastOpenedFolderKey(notebookKeyCreateFolder);
        List<Integer> listListOf = CollectionsKt.listOf((Object[]) new Integer[]{Boxing.boxInt(i2), Boxing.boxInt(CoverColorUtilsExt.computeGradientEndColor(i2))});
        PaperSize a4 = PaperSize.getA4();
        Intrinsics.checkNotNullExpressionValue(a4, "getA4(...)");
        PageKey pageKeyAddPaginatedContainer = contentInitializer.addPaginatedContainer(notebookKeyCreateFolder, str3, str4, listListOf, a4, ((Number) CollectionsKt.first((List) PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS())).intValue(), BackgroundPattern.NONE);
        if (pageKeyAddPaginatedContainer == null) {
            return null;
        }
        contentInitializer.setLastChosenLanguage(str4);
        return pageKeyAddPaginatedContainer;
    }
}
