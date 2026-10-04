package com.myscript.nebo.dms.core;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.PaperSize;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContentInitializer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\rH&JL\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u000e\b\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010)\u001a\u00020*H&R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010$\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/ContentInitializer;", "", "findCollectionByName", "Lcom/myscript/snt/core/CollectionKey;", "collectionName", "", "createCollection", "newCollectionName", "createFolder", "Lcom/myscript/snt/core/NotebookKey;", "collectionKey", "folderName", "color", "", "addPaginatedContainer", "Lcom/myscript/snt/core/PageKey;", "notebookKey", "name", "lang", "coverColors", "", "paperSize", "Lcom/myscript/snt/core/PaperSize;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "backgroundPattern", "Lcom/myscript/atk/core/BackgroundPattern;", "lastOpenedFolderKey", "getLastOpenedFolderKey", "()Lcom/myscript/snt/core/NotebookKey;", "setLastOpenedFolderKey", "(Lcom/myscript/snt/core/NotebookKey;)V", "lastOpenedNoteKey", "getLastOpenedNoteKey", "()Lcom/myscript/snt/core/PageKey;", "setLastOpenedNoteKey", "(Lcom/myscript/snt/core/PageKey;)V", "lastChosenLanguage", "getLastChosenLanguage", "()Ljava/lang/String;", "setLastChosenLanguage", "(Ljava/lang/String;)V", "clearAllContent", "", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ContentInitializer {
    PageKey addPaginatedContainer(NotebookKey notebookKey, String name, String lang, List<Integer> coverColors, PaperSize paperSize, int backgroundColor, BackgroundPattern backgroundPattern);

    void clearAllContent();

    CollectionKey createCollection(String newCollectionName);

    NotebookKey createFolder(CollectionKey collectionKey, String folderName, int color);

    CollectionKey findCollectionByName(String collectionName);

    String getLastChosenLanguage();

    NotebookKey getLastOpenedFolderKey();

    PageKey getLastOpenedNoteKey();

    void setLastChosenLanguage(String str);

    void setLastOpenedFolderKey(NotebookKey notebookKey);

    void setLastOpenedNoteKey(PageKey pageKey);
}
