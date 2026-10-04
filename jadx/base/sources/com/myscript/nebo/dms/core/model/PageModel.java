package com.myscript.nebo.dms.core.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.BackgroundPatternExt;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.PaperSize;
import com.myscript.snt.dms.Page;
import com.myscript.snt.dms.PageType;
import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PageModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\b\u0087\b\u0018\u0000 e2\u00020\u0001:\u0001eB÷\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0003\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\u000e\b\u0003\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\b\b\u0003\u0010\u001b\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b%\u0010&J\n\u0010H\u001a\u00020\u0013H\u0096\u0080\u0004J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\u0007HÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\fHÆ\u0003J\t\u0010P\u001a\u00020\u000eHÆ\u0003J\t\u0010Q\u001a\u00020\fHÆ\u0003J\t\u0010R\u001a\u00020\fHÆ\u0003J\t\u0010S\u001a\u00020\fHÆ\u0003J\t\u0010T\u001a\u00020\u0013HÆ\u0003J\t\u0010U\u001a\u00020\u0013HÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003J\t\u0010W\u001a\u00020\u0017HÆ\u0003J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019HÆ\u0003J\t\u0010Y\u001a\u00020\u000eHÆ\u0003J\t\u0010Z\u001a\u00020\u000eHÆ\u0003J\t\u0010[\u001a\u00020\u001dHÆ\u0003J\t\u0010\\\u001a\u00020\u000eHÆ\u0003J\t\u0010]\u001a\u00020\u0007HÆ\u0003J\t\u0010^\u001a\u00020\u0007HÆ\u0003J\t\u0010_\u001a\u00020\"HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010$HÆ\u0003J\u0081\u0002\u0010a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u000e\b\u0003\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0003\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001J\u0014\u0010b\u001a\u00020\u00072\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010d\u001a\u00020\u000eHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010+R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010+R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010+R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010+R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b2\u0010-R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010+R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u001a\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010/R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010/R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u001e\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010/R\u0011\u0010\u001f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0011\u0010 \u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010+R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u0013\u0010E\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\bF\u00104R\u0011\u0010G\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bG\u0010+¨\u0006f"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/model/PageModel;", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "pageType", "Lcom/myscript/snt/dms/PageType;", "isContainer", "", "isEmpty", "isCorrupted", "isSupported", "dateToDisplay", "", "dateDetailsRes", "", "creationDate", "lastModificationDate", "thumbnailGenerationDate", "title", "", "languageTag", "isLanguageMissing", "paperSize", "Lcom/myscript/snt/core/PaperSize;", "coverColors", "", "childPageCount", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "backgroundPattern", "Lcom/myscript/atk/core/BackgroundPattern;", "hitCount", "matchedTitle", "isTrashed", "selectionState", "Lcom/myscript/nebo/dms/core/model/SelectionState;", "thumbnailFile", "Ljava/io/File;", "<init>", "(Lcom/myscript/snt/core/PageKey;Lcom/myscript/snt/dms/PageType;ZZZZJIJJJLjava/lang/String;Ljava/lang/String;ZLcom/myscript/snt/core/PaperSize;Ljava/util/List;IILcom/myscript/atk/core/BackgroundPattern;IZZLcom/myscript/nebo/dms/core/model/SelectionState;Ljava/io/File;)V", "getPageKey", "()Lcom/myscript/snt/core/PageKey;", "getPageType", "()Lcom/myscript/snt/dms/PageType;", "()Z", "getDateToDisplay", "()J", "getDateDetailsRes", "()I", "getCreationDate", "getLastModificationDate", "getThumbnailGenerationDate", "getTitle", "()Ljava/lang/String;", "getLanguageTag", "getPaperSize", "()Lcom/myscript/snt/core/PaperSize;", "getCoverColors", "()Ljava/util/List;", "getChildPageCount", "getBackgroundColor", "getBackgroundPattern", "()Lcom/myscript/atk/core/BackgroundPattern;", "getHitCount", "getMatchedTitle", "getSelectionState", "()Lcom/myscript/nebo/dms/core/model/SelectionState;", "getThumbnailFile", "()Ljava/io/File;", "isExportable", "fileExtension", "getFileExtension", "isSelected", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "other", "hashCode", "Companion", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class PageModel {
    public static final int $stable = 0;
    private static final String PDF_FILE_EXTENSION = ".pdf";
    private final int backgroundColor;
    private final BackgroundPattern backgroundPattern;
    private final int childPageCount;
    private final List<Integer> coverColors;
    private final long creationDate;
    private final int dateDetailsRes;
    private final long dateToDisplay;
    private final String fileExtension;
    private final int hitCount;
    private final boolean isContainer;
    private final boolean isCorrupted;
    private final boolean isEmpty;
    private final boolean isExportable;
    private final boolean isLanguageMissing;
    private final boolean isSelected;
    private final boolean isSupported;
    private final boolean isTrashed;
    private final String languageTag;
    private final long lastModificationDate;
    private final boolean matchedTitle;
    private final PageKey pageKey;
    private final PageType pageType;
    private final PaperSize paperSize;
    private final SelectionState selectionState;
    private final File thumbnailFile;
    private final long thumbnailGenerationDate;
    private final String title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Comparator<PageModel> alphabeticalComparator = new Comparator() { // from class: com.myscript.nebo.dms.core.model.PageModel$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return PageModel.alphabeticalComparator$lambda$0((PageModel) obj, (PageModel) obj2);
        }
    };
    private static final Comparator<PageModel> creationDateComparator = new Comparator() { // from class: com.myscript.nebo.dms.core.model.PageModel$$ExternalSyntheticLambda1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return PageModel.creationDateComparator$lambda$0((PageModel) obj, (PageModel) obj2);
        }
    };
    private static final Comparator<PageModel> modificationDateComparator = new Comparator() { // from class: com.myscript.nebo.dms.core.model.PageModel$$ExternalSyntheticLambda2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return PageModel.modificationDateComparator$lambda$0((PageModel) obj, (PageModel) obj2);
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageModel copy$default(PageModel pageModel, PageKey pageKey, PageType pageType, boolean z, boolean z2, boolean z3, boolean z4, long j, int i, long j2, long j3, long j4, String str, String str2, boolean z5, PaperSize paperSize, List list, int i2, int i3, BackgroundPattern backgroundPattern, int i4, boolean z6, boolean z7, SelectionState selectionState, File file, int i5, Object obj) {
        File file2;
        SelectionState selectionState2;
        PageKey pageKey2 = (i5 & 1) != 0 ? pageModel.pageKey : pageKey;
        PageType pageType2 = (i5 & 2) != 0 ? pageModel.pageType : pageType;
        boolean z8 = (i5 & 4) != 0 ? pageModel.isContainer : z;
        boolean z9 = (i5 & 8) != 0 ? pageModel.isEmpty : z2;
        boolean z10 = (i5 & 16) != 0 ? pageModel.isCorrupted : z3;
        boolean z11 = (i5 & 32) != 0 ? pageModel.isSupported : z4;
        long j5 = (i5 & 64) != 0 ? pageModel.dateToDisplay : j;
        int i6 = (i5 & 128) != 0 ? pageModel.dateDetailsRes : i;
        long j6 = (i5 & 256) != 0 ? pageModel.creationDate : j2;
        long j7 = (i5 & 512) != 0 ? pageModel.lastModificationDate : j3;
        PageKey pageKey3 = pageKey2;
        PageType pageType3 = pageType2;
        long j8 = (i5 & 1024) != 0 ? pageModel.thumbnailGenerationDate : j4;
        String str3 = (i5 & 2048) != 0 ? pageModel.title : str;
        long j9 = j8;
        String str4 = (i5 & 4096) != 0 ? pageModel.languageTag : str2;
        boolean z12 = (i5 & 8192) != 0 ? pageModel.isLanguageMissing : z5;
        String str5 = str4;
        PaperSize paperSize2 = (i5 & 16384) != 0 ? pageModel.paperSize : paperSize;
        List list2 = (i5 & 32768) != 0 ? pageModel.coverColors : list;
        int i7 = (i5 & 65536) != 0 ? pageModel.childPageCount : i2;
        int i8 = (i5 & 131072) != 0 ? pageModel.backgroundColor : i3;
        BackgroundPattern backgroundPattern2 = (i5 & 262144) != 0 ? pageModel.backgroundPattern : backgroundPattern;
        int i9 = (i5 & 524288) != 0 ? pageModel.hitCount : i4;
        boolean z13 = (i5 & 1048576) != 0 ? pageModel.matchedTitle : z6;
        boolean z14 = (i5 & 2097152) != 0 ? pageModel.isTrashed : z7;
        SelectionState selectionState3 = (i5 & 4194304) != 0 ? pageModel.selectionState : selectionState;
        if ((i5 & 8388608) != 0) {
            selectionState2 = selectionState3;
            file2 = pageModel.thumbnailFile;
        } else {
            file2 = file;
            selectionState2 = selectionState3;
        }
        return pageModel.copy(pageKey3, pageType3, z8, z9, z10, z11, j5, i6, j6, j7, j9, str3, str5, z12, paperSize2, list2, i7, i8, backgroundPattern2, i9, z13, z14, selectionState2, file2);
    }

    @JvmStatic
    public static final PageModel fromPage(Page page) {
        return INSTANCE.fromPage(page);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PageKey getPageKey() {
        return this.pageKey;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getLastModificationDate() {
        return this.lastModificationDate;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getThumbnailGenerationDate() {
        return this.thumbnailGenerationDate;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getLanguageTag() {
        return this.languageTag;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getIsLanguageMissing() {
        return this.isLanguageMissing;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final PaperSize getPaperSize() {
        return this.paperSize;
    }

    public final List<Integer> component16() {
        return this.coverColors;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getChildPageCount() {
        return this.childPageCount;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final BackgroundPattern getBackgroundPattern() {
        return this.backgroundPattern;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PageType getPageType() {
        return this.pageType;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final int getHitCount() {
        return this.hitCount;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getMatchedTitle() {
        return this.matchedTitle;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getIsTrashed() {
        return this.isTrashed;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final SelectionState getSelectionState() {
        return this.selectionState;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final File getThumbnailFile() {
        return this.thumbnailFile;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsContainer() {
        return this.isContainer;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsCorrupted() {
        return this.isCorrupted;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsSupported() {
        return this.isSupported;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getDateToDisplay() {
        return this.dateToDisplay;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getDateDetailsRes() {
        return this.dateDetailsRes;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getCreationDate() {
        return this.creationDate;
    }

    public final PageModel copy(PageKey pageKey, PageType pageType, boolean isContainer, boolean isEmpty, boolean isCorrupted, boolean isSupported, long dateToDisplay, int dateDetailsRes, long creationDate, long lastModificationDate, long thumbnailGenerationDate, String title, String languageTag, boolean isLanguageMissing, PaperSize paperSize, List<Integer> coverColors, int childPageCount, int backgroundColor, BackgroundPattern backgroundPattern, int hitCount, boolean matchedTitle, boolean isTrashed, SelectionState selectionState, File thumbnailFile) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(languageTag, "languageTag");
        Intrinsics.checkNotNullParameter(paperSize, "paperSize");
        Intrinsics.checkNotNullParameter(coverColors, "coverColors");
        Intrinsics.checkNotNullParameter(backgroundPattern, "backgroundPattern");
        Intrinsics.checkNotNullParameter(selectionState, "selectionState");
        return new PageModel(pageKey, pageType, isContainer, isEmpty, isCorrupted, isSupported, dateToDisplay, dateDetailsRes, creationDate, lastModificationDate, thumbnailGenerationDate, title, languageTag, isLanguageMissing, paperSize, coverColors, childPageCount, backgroundColor, backgroundPattern, hitCount, matchedTitle, isTrashed, selectionState, thumbnailFile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageModel)) {
            return false;
        }
        PageModel pageModel = (PageModel) other;
        return Intrinsics.areEqual(this.pageKey, pageModel.pageKey) && this.pageType == pageModel.pageType && this.isContainer == pageModel.isContainer && this.isEmpty == pageModel.isEmpty && this.isCorrupted == pageModel.isCorrupted && this.isSupported == pageModel.isSupported && this.dateToDisplay == pageModel.dateToDisplay && this.dateDetailsRes == pageModel.dateDetailsRes && this.creationDate == pageModel.creationDate && this.lastModificationDate == pageModel.lastModificationDate && this.thumbnailGenerationDate == pageModel.thumbnailGenerationDate && Intrinsics.areEqual(this.title, pageModel.title) && Intrinsics.areEqual(this.languageTag, pageModel.languageTag) && this.isLanguageMissing == pageModel.isLanguageMissing && Intrinsics.areEqual(this.paperSize, pageModel.paperSize) && Intrinsics.areEqual(this.coverColors, pageModel.coverColors) && this.childPageCount == pageModel.childPageCount && this.backgroundColor == pageModel.backgroundColor && this.backgroundPattern == pageModel.backgroundPattern && this.hitCount == pageModel.hitCount && this.matchedTitle == pageModel.matchedTitle && this.isTrashed == pageModel.isTrashed && this.selectionState == pageModel.selectionState && Intrinsics.areEqual(this.thumbnailFile, pageModel.thumbnailFile);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((this.pageKey.hashCode() * 31) + this.pageType.hashCode()) * 31) + Boolean.hashCode(this.isContainer)) * 31) + Boolean.hashCode(this.isEmpty)) * 31) + Boolean.hashCode(this.isCorrupted)) * 31) + Boolean.hashCode(this.isSupported)) * 31) + Long.hashCode(this.dateToDisplay)) * 31) + Integer.hashCode(this.dateDetailsRes)) * 31) + Long.hashCode(this.creationDate)) * 31) + Long.hashCode(this.lastModificationDate)) * 31) + Long.hashCode(this.thumbnailGenerationDate)) * 31) + this.title.hashCode()) * 31) + this.languageTag.hashCode()) * 31) + Boolean.hashCode(this.isLanguageMissing)) * 31) + this.paperSize.hashCode()) * 31) + this.coverColors.hashCode()) * 31) + Integer.hashCode(this.childPageCount)) * 31) + Integer.hashCode(this.backgroundColor)) * 31) + this.backgroundPattern.hashCode()) * 31) + Integer.hashCode(this.hitCount)) * 31) + Boolean.hashCode(this.matchedTitle)) * 31) + Boolean.hashCode(this.isTrashed)) * 31) + this.selectionState.hashCode()) * 31;
        File file = this.thumbnailFile;
        return iHashCode + (file == null ? 0 : file.hashCode());
    }

    public PageModel(PageKey pageKey, PageType pageType, boolean z, boolean z2, boolean z3, boolean z4, long j, int i, long j2, long j3, long j4, String title, String languageTag, boolean z5, PaperSize paperSize, List<Integer> coverColors, int i2, int i3, BackgroundPattern backgroundPattern, int i4, boolean z6, boolean z7, SelectionState selectionState, File file) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(languageTag, "languageTag");
        Intrinsics.checkNotNullParameter(paperSize, "paperSize");
        Intrinsics.checkNotNullParameter(coverColors, "coverColors");
        Intrinsics.checkNotNullParameter(backgroundPattern, "backgroundPattern");
        Intrinsics.checkNotNullParameter(selectionState, "selectionState");
        this.pageKey = pageKey;
        this.pageType = pageType;
        this.isContainer = z;
        this.isEmpty = z2;
        this.isCorrupted = z3;
        this.isSupported = z4;
        this.dateToDisplay = j;
        this.dateDetailsRes = i;
        this.creationDate = j2;
        this.lastModificationDate = j3;
        this.thumbnailGenerationDate = j4;
        this.title = title;
        this.languageTag = languageTag;
        this.isLanguageMissing = z5;
        this.paperSize = paperSize;
        this.coverColors = coverColors;
        this.childPageCount = i2;
        this.backgroundColor = i3;
        this.backgroundPattern = backgroundPattern;
        this.hitCount = i4;
        this.matchedTitle = z6;
        this.isTrashed = z7;
        this.selectionState = selectionState;
        this.thumbnailFile = file;
        this.isExportable = (z2 || z3) ? false : true;
        this.fileExtension = pageType == PageType.PDF ? PDF_FILE_EXTENSION : null;
        this.isSelected = selectionState == SelectionState.SELECTED;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PageModel(PageKey pageKey, PageType pageType, boolean z, boolean z2, boolean z3, boolean z4, long j, int i, long j2, long j3, long j4, String str, String str2, boolean z5, PaperSize paperSize, List list, int i2, int i3, BackgroundPattern backgroundPattern, int i4, boolean z6, boolean z7, SelectionState selectionState, File file, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        PaperSize paperSize2;
        boolean z8 = (i5 & 8) != 0 ? true : z2;
        boolean z9 = (i5 & 16) != 0 ? false : z3;
        boolean z10 = (i5 & 32) != 0 ? true : z4;
        long j5 = (i5 & 64) != 0 ? 0L : j;
        int i6 = (i5 & 128) != 0 ? 0 : i;
        long j6 = (i5 & 256) != 0 ? 0L : j2;
        long j7 = (i5 & 512) != 0 ? 0L : j3;
        long j8 = (i5 & 1024) != 0 ? 0L : j4;
        String str3 = (i5 & 2048) != 0 ? "" : str;
        String str4 = (i5 & 4096) != 0 ? "" : str2;
        boolean z11 = (i5 & 8192) != 0 ? false : z5;
        if ((i5 & 16384) != 0) {
            PaperSize unlimited = PaperSize.getUnlimited();
            Intrinsics.checkNotNullExpressionValue(unlimited, "getUnlimited(...)");
            paperSize2 = unlimited;
        } else {
            paperSize2 = paperSize;
        }
        this(pageKey, pageType, z, z8, z9, z10, j5, i6, j6, j7, j8, str3, str4, z11, paperSize2, (32768 & i5) != 0 ? CollectionsKt.emptyList() : list, (65536 & i5) != 0 ? 0 : i2, (131072 & i5) != 0 ? -1 : i3, (262144 & i5) != 0 ? BackgroundPattern.GRID : backgroundPattern, (524288 & i5) != 0 ? 0 : i4, (1048576 & i5) != 0 ? false : z6, z7, (4194304 & i5) != 0 ? SelectionState.NOT_SELECTABLE : selectionState, (i5 & 8388608) != 0 ? null : file);
    }

    public final PageKey getPageKey() {
        return this.pageKey;
    }

    public final PageType getPageType() {
        return this.pageType;
    }

    public final boolean isContainer() {
        return this.isContainer;
    }

    public final boolean isEmpty() {
        return this.isEmpty;
    }

    public final boolean isCorrupted() {
        return this.isCorrupted;
    }

    public final boolean isSupported() {
        return this.isSupported;
    }

    public final long getDateToDisplay() {
        return this.dateToDisplay;
    }

    public final int getDateDetailsRes() {
        return this.dateDetailsRes;
    }

    public final long getCreationDate() {
        return this.creationDate;
    }

    public final long getLastModificationDate() {
        return this.lastModificationDate;
    }

    public final long getThumbnailGenerationDate() {
        return this.thumbnailGenerationDate;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getLanguageTag() {
        return this.languageTag;
    }

    public final boolean isLanguageMissing() {
        return this.isLanguageMissing;
    }

    public final PaperSize getPaperSize() {
        return this.paperSize;
    }

    public final List<Integer> getCoverColors() {
        return this.coverColors;
    }

    public final int getChildPageCount() {
        return this.childPageCount;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final BackgroundPattern getBackgroundPattern() {
        return this.backgroundPattern;
    }

    public final int getHitCount() {
        return this.hitCount;
    }

    public final boolean getMatchedTitle() {
        return this.matchedTitle;
    }

    public final boolean isTrashed() {
        return this.isTrashed;
    }

    public final SelectionState getSelectionState() {
        return this.selectionState;
    }

    public final File getThumbnailFile() {
        return this.thumbnailFile;
    }

    /* JADX INFO: renamed from: isExportable, reason: from getter */
    public final boolean getIsExportable() {
        return this.isExportable;
    }

    public final String getFileExtension() {
        return this.fileExtension;
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public String toString() {
        return "[id : " + this.pageKey.uuid() + "]";
    }

    /* JADX INFO: compiled from: PageModel.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R1\u0010\n\u001a\"\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u00070\u000bj\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u0007`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR1\u0010\u0010\u001a\"\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u00070\u000bj\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u0007`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR1\u0010\u0012\u001a\"\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u00070\u000bj\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u0007`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/model/PageModel$Companion;", "", "<init>", "()V", "PDF_FILE_EXTENSION", "", "fromPage", "Lcom/myscript/nebo/dms/core/model/PageModel;", "page", "Lcom/myscript/snt/dms/Page;", "alphabeticalComparator", "Ljava/util/Comparator;", "kotlin.jvm.PlatformType", "Lkotlin/Comparator;", "getAlphabeticalComparator", "()Ljava/util/Comparator;", "creationDateComparator", "getCreationDateComparator", "modificationDateComparator", "getModificationDateComparator", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: PageModel.kt */
        @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PageType.values().length];
                try {
                    iArr[PageType.RawContent.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PageModel fromPage(Page page) {
            BackgroundPattern backgroundPatternFromString;
            Intrinsics.checkNotNullParameter(page, "page");
            String backgroundPattern = page.getBackgroundPattern();
            PageType type = page.getType();
            String str = backgroundPattern;
            if (str == null || StringsKt.isBlank(str)) {
                if ((type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) == 1) {
                    backgroundPatternFromString = BackgroundPattern.GRID;
                } else {
                    backgroundPatternFromString = BackgroundPattern.NONE;
                }
            } else {
                backgroundPatternFromString = BackgroundPatternExt.fromString(backgroundPattern);
            }
            BackgroundPattern backgroundPattern2 = backgroundPatternFromString;
            PageKey key = page.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "getKey(...)");
            PageType type2 = page.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            boolean zIsContainer = page.isContainer();
            boolean z = !page.hasContent();
            boolean zIsCorrupted = page.isCorrupted();
            boolean zIsSupported = page.isSupported();
            long lastModificationDate = page.getLastModificationDate();
            long jCreationDate = page.creationDate();
            long lastModificationDate2 = page.getLastModificationDate();
            long jThumbnailGenerationDate = page.thumbnailGenerationDate();
            String title = page.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
            String strLanguage = page.language();
            Intrinsics.checkNotNullExpressionValue(strLanguage, "language(...)");
            PaperSize paperSize = new PaperSize(page.width(), page.height());
            List<Integer> coverColors = page.getCoverColors();
            Intrinsics.checkNotNullExpressionValue(coverColors, "getCoverColors(...)");
            List<Integer> list = coverColors;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((Integer) it.next());
            }
            int iChildPages = page.childPages();
            int backgroundColor = page.getBackgroundColor();
            Intrinsics.checkNotNull(backgroundPattern2);
            return new PageModel(key, type2, zIsContainer, z, zIsCorrupted, zIsSupported, lastModificationDate, 0, jCreationDate, lastModificationDate2, jThumbnailGenerationDate, title, strLanguage, false, paperSize, arrayList, iChildPages, backgroundColor, backgroundPattern2, 0, false, page.isTrashed(), SelectionState.NOT_SELECTABLE, null, 1056768, null);
        }

        public final Comparator<PageModel> getAlphabeticalComparator() {
            return PageModel.alphabeticalComparator;
        }

        public final Comparator<PageModel> getCreationDateComparator() {
            return PageModel.creationDateComparator;
        }

        public final Comparator<PageModel> getModificationDateComparator() {
            return PageModel.modificationDateComparator;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int alphabeticalComparator$lambda$0(PageModel page1, PageModel page2) {
        Intrinsics.checkNotNullParameter(page1, "page1");
        Intrinsics.checkNotNullParameter(page2, "page2");
        if (StringsKt.isBlank(page1.title) && StringsKt.isBlank(page2.title)) {
            return modificationDateComparator.compare(page1, page2);
        }
        if (StringsKt.isBlank(page1.title)) {
            return 1;
        }
        if (StringsKt.isBlank(page2.title)) {
            return -1;
        }
        return Collator.getInstance().compare(page1.title, page2.title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int creationDateComparator$lambda$0(PageModel page1, PageModel page2) {
        Intrinsics.checkNotNullParameter(page1, "page1");
        Intrinsics.checkNotNullParameter(page2, "page2");
        return Intrinsics.compare(page1.creationDate, page2.creationDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int modificationDateComparator$lambda$0(PageModel page1, PageModel page2) {
        Intrinsics.checkNotNullParameter(page1, "page1");
        Intrinsics.checkNotNullParameter(page2, "page2");
        return Intrinsics.compare(page1.lastModificationDate, page2.lastModificationDate);
    }
}
