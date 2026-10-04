package com.myscript.nebo.dms.core;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.MimeType;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.snt.core.IThumbnailerNotificationListener;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.PaperSize;
import com.myscript.snt.dms.DMSFilter;
import java.io.File;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PageManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\nH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H&J\"\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0006H&J4\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J,\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0019\u001a\u00020\u001aH&JL\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u000e\b\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0006\u0010 \u001a\u00020!2\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001aH&J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H&J\u001e\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0016\u0010'\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H&J\u0018\u0010(\u001a\u00020%2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0014H&J\u0010\u0010*\u001a\u00020+2\u0006\u0010\f\u001a\u00020\nH&J\u0018\u0010,\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001aH&J\u0012\u0010-\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nH&J\u0016\u0010.\u001a\u00020+2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H&J\u0018\u0010/\u001a\u00020+2\u0006\u0010\f\u001a\u00020\n2\u0006\u00100\u001a\u000201H&J\u0010\u00102\u001a\u00020%2\u0006\u0010\f\u001a\u00020\nH&J\b\u00103\u001a\u00020%H&J\u0012\u00104\u001a\u0004\u0018\u00010\n2\u0006\u00105\u001a\u00020\nH&J\u0010\u00106\u001a\u00020%2\u0006\u0010\f\u001a\u00020\nH&J\u0010\u00107\u001a\u00020%2\u0006\u00105\u001a\u00020\nH&J\u0018\u00108\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u00109\u001a\u00020:H&J\u0018\u0010;\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u00109\u001a\u00020:H&J\u0018\u0010<\u001a\u00020%2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010=\u001a\u00020>H&J\u0018\u0010?\u001a\u00020%2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010=\u001a\u00020>H&J\u0010\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020BH&J\u0010\u0010C\u001a\u00020%2\u0006\u0010A\u001a\u00020BH&J\u0010\u0010D\u001a\u00020+2\u0006\u0010\f\u001a\u00020\nH&J\u0010\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020GH&J\u0010\u0010H\u001a\u00020%2\u0006\u0010F\u001a\u00020GH&J\u0018\u0010I\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\n2\u0006\u0010J\u001a\u00020KH&J\u0010\u0010L\u001a\u00020%2\u0006\u0010\f\u001a\u00020\nH&¨\u0006MÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/PageManager;", "", "getPages", "", "Lcom/myscript/nebo/dms/core/model/PageModel;", "parentNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "filter", "Lcom/myscript/snt/dms/DMSFilter;", "parentPageKey", "Lcom/myscript/snt/core/PageKey;", "getPage", "pageKey", "getFolder", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "notebookKey", "importAsPdf", "attachment", "Ljava/io/File;", "lang", "", "importNeboFile", "neboFile", "addBoard", "name", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "", "backgroundPattern", "Lcom/myscript/atk/core/BackgroundPattern;", "addDocument", "addPaginatedContainer", "coverColors", "paperSize", "Lcom/myscript/snt/core/PaperSize;", "movePage", "newPosition", "movePages", "", "pageKeys", "movePagesToTrash", "updateNoteName", "newName", "isSamplePage", "", "duplicatePage", "createSiblingPage", "canExport", "supportsExportMimeType", "mimeType", "Lcom/myscript/atk/core/MimeType;", "saveOpenedNote", "clearOpenedNote", "lastOpenedPage", "containerKey", "saveOpenedPage", "clearOpenedPage", "addFolderListener", "folderListener", "Lcom/myscript/nebo/dms/core/LibraryRepository$FolderListener;", "removeFolderListener", "addPageListener", "pageListener", "Lcom/myscript/nebo/dms/core/LibraryRepository$PageListener;", "removePageListener", "addTrashListener", "trashListener", "Lcom/myscript/nebo/dms/core/LibraryRepository$TrashListener;", "removeTrashListener", "isLanguageAvailable", "addThumbnailListener", "thumbnailListener", "Lcom/myscript/snt/core/IThumbnailerNotificationListener;", "removeThumbnailListener", "getThumbnailPath", "lastModificationDate", "", "createThumbnail", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface PageManager {
    PageKey addBoard(NotebookKey notebookKey, String name, String lang, int backgroundColor, BackgroundPattern backgroundPattern);

    PageKey addDocument(NotebookKey notebookKey, String name, String lang, int backgroundColor);

    void addFolderListener(NotebookKey notebookKey, LibraryRepository.FolderListener folderListener);

    void addPageListener(PageKey pageKey, LibraryRepository.PageListener pageListener);

    PageKey addPaginatedContainer(NotebookKey notebookKey, String name, String lang, List<Integer> coverColors, PaperSize paperSize, int backgroundColor, BackgroundPattern backgroundPattern);

    void addThumbnailListener(IThumbnailerNotificationListener thumbnailListener);

    void addTrashListener(LibraryRepository.TrashListener trashListener);

    boolean canExport(List<? extends PageKey> pageKeys);

    void clearOpenedNote();

    void clearOpenedPage(PageKey containerKey);

    PageKey createSiblingPage(PageKey pageKey);

    void createThumbnail(PageKey pageKey);

    PageKey duplicatePage(PageKey pageKey, int newPosition);

    FolderModel getFolder(NotebookKey notebookKey);

    PageModel getPage(PageKey pageKey);

    List<PageModel> getPages(NotebookKey parentNotebookKey, DMSFilter filter);

    List<PageModel> getPages(PageKey parentPageKey, DMSFilter filter);

    String getThumbnailPath(PageKey pageKey, long lastModificationDate);

    PageKey importAsPdf(NotebookKey notebookKey, File attachment, String lang);

    List<PageKey> importNeboFile(File neboFile, NotebookKey notebookKey);

    boolean isLanguageAvailable(PageKey pageKey);

    boolean isSamplePage(PageKey pageKey);

    PageKey lastOpenedPage(PageKey containerKey);

    PageKey movePage(PageKey pageKey, int newPosition);

    PageKey movePage(PageKey pageKey, NotebookKey notebookKey);

    void movePages(List<? extends PageKey> pageKeys, NotebookKey notebookKey);

    void movePagesToTrash(List<? extends PageKey> pageKeys);

    void removeFolderListener(NotebookKey notebookKey, LibraryRepository.FolderListener folderListener);

    void removePageListener(PageKey pageKey, LibraryRepository.PageListener pageListener);

    void removeThumbnailListener(IThumbnailerNotificationListener thumbnailListener);

    void removeTrashListener(LibraryRepository.TrashListener trashListener);

    void saveOpenedNote(PageKey pageKey);

    void saveOpenedPage(PageKey pageKey);

    boolean supportsExportMimeType(PageKey pageKey, MimeType mimeType);

    void updateNoteName(PageKey pageKey, String newName);
}
