package com.myscript.nebo.editing;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.editing.ChildPageAction;
import com.myscript.snt.core.ChildPageThumbnailGenerator;
import com.myscript.snt.core.IChildPageThumbnailGenerator;
import com.myscript.snt.dms.IPaginatedContainer;
import com.myscript.snt.dms.NotebookManager;
import com.myscript.snt.dms.PDFManager;
import com.myscript.snt.dms.PageAction;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChildPagesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0004H\u0082\b¢\u0006\u0002\u0010\u0005\u001a0\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00062\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00010\u0004H\u0082\b¢\u0006\u0002\u0010\b\u001a(\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002\u001a\u0014\u0010\u0012\u001a\u00020\u0013*\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u001a\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0011*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000fH\u0002\u001a\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\b\u0012\u0004\u0012\u00020\u00190\u0017H\u0002¨\u0006\u001a"}, m1599d2 = {"safeUse", "R", "Lcom/myscript/snt/dms/IPaginatedContainer;", "block", "Lkotlin/Function1;", "(Lcom/myscript/snt/dms/IPaginatedContainer;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/myscript/snt/core/IChildPageThumbnailGenerator;", "Lcom/myscript/snt/core/ChildPageThumbnailGenerator;", "(Lcom/myscript/snt/core/IChildPageThumbnailGenerator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toChildPage", "Lcom/myscript/nebo/editing/ChildPage;", "Lcom/myscript/snt/dms/PageProperties;", FirebaseAnalytics.Param.INDEX, "", "selectedPageId", "", "thumbnailFile", "Ljava/io/File;", "isValidChildPageId", "", "childPageId", "getThumbnailFile", "buildChildPageActionItems", "", "Lcom/myscript/nebo/editing/ChildPageAction;", "Lcom/myscript/snt/dms/PageAction;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ChildPagesViewModelKt {

    /* JADX INFO: compiled from: ChildPagesViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PageAction.values().length];
            try {
                iArr[PageAction.CREATE_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageAction.MOVE_PAGE_UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PageAction.MOVE_PAGE_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PageAction.DUPLICATE_PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PageAction.CONFIGURE_BACKGROUND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PageAction.MANAGE_PAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PageAction.DELETE_PAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final <R> R safeUse(IPaginatedContainer iPaginatedContainer, Function1<? super IPaginatedContainer, ? extends R> function1) {
        AutoCloseable autoCloseableNewRef;
        if (iPaginatedContainer instanceof NotebookManager) {
            autoCloseableNewRef = NotebookManager.newRef((NotebookManager) iPaginatedContainer);
        } else {
            if (!(iPaginatedContainer instanceof PDFManager)) {
                throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
            }
            autoCloseableNewRef = PDFManager.newRef((PDFManager) iPaginatedContainer);
        }
        if (autoCloseableNewRef == null) {
            return null;
        }
        AutoCloseable autoCloseable = autoCloseableNewRef;
        try {
            R rInvoke = function1.invoke(autoCloseable);
            AutoCloseableKt.closeFinally(autoCloseable, null);
            return rInvoke;
        } finally {
        }
    }

    private static final <R> R safeUse(IChildPageThumbnailGenerator iChildPageThumbnailGenerator, Function1<? super ChildPageThumbnailGenerator, ? extends R> function1) {
        if (!(iChildPageThumbnailGenerator instanceof ChildPageThumbnailGenerator)) {
            throw new IllegalStateException("Unsupported IChildPageThumbnailGenerator type".toString());
        }
        ChildPageThumbnailGenerator childPageThumbnailGeneratorNewRef = ChildPageThumbnailGenerator.newRef((ChildPageThumbnailGenerator) iChildPageThumbnailGenerator);
        if (childPageThumbnailGeneratorNewRef == null) {
            return null;
        }
        ChildPageThumbnailGenerator childPageThumbnailGenerator = childPageThumbnailGeneratorNewRef;
        try {
            R rInvoke = function1.invoke(childPageThumbnailGenerator);
            AutoCloseableKt.closeFinally(childPageThumbnailGenerator, null);
            return rInvoke;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChildPage toChildPage(com.myscript.snt.dms.PageProperties pageProperties, int i, String str, File file) {
        String pageId = pageProperties.getPageId();
        Intrinsics.checkNotNullExpressionValue(pageId, "getPageId(...)");
        boolean zAreEqual = Intrinsics.areEqual(str, pageProperties.getPageId());
        int i2 = i + 1;
        int width = (int) pageProperties.getWidth();
        int height = (int) pageProperties.getHeight();
        int backgroundColor = pageProperties.getBackgroundColor();
        BackgroundPattern backgroundPattern = pageProperties.getBackgroundPattern();
        Intrinsics.checkNotNullExpressionValue(backgroundPattern, "getBackgroundPattern(...)");
        return new ChildPage(pageId, zAreEqual, i2, width, height, backgroundColor, backgroundPattern, file != null ? file.getAbsolutePath() : null, pageProperties.getIsCorrupted(), null, 512, null);
    }

    public static final boolean isValidChildPageId(IPaginatedContainer iPaginatedContainer, String str) {
        Intrinsics.checkNotNullParameter(iPaginatedContainer, "<this>");
        return str != null && iPaginatedContainer.isValidPageId(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File getThumbnailFile(IChildPageThumbnailGenerator iChildPageThumbnailGenerator, String str) {
        File file;
        try {
            file = new File(iChildPageThumbnailGenerator.getThumbnailPath(str));
        } catch (IllegalArgumentException unused) {
        }
        if (file.isFile()) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<ChildPageAction> buildChildPageActionItems(List<? extends PageAction> list) {
        ChildPageAction childPageAction;
        List listListOf = CollectionsKt.listOf((Object[]) new PageAction[]{PageAction.CREATE_PAGE, PageAction.MOVE_PAGE_UP, PageAction.MOVE_PAGE_DOWN, PageAction.DUPLICATE_PAGE, PageAction.CHANGE_PAGE_SIZE, PageAction.CONFIGURE_BACKGROUND, PageAction.MANAGE_PAGE, PageAction.DELETE_PAGE});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (list.contains((PageAction) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            switch (WhenMappings.$EnumSwitchMapping$0[((PageAction) it.next()).ordinal()]) {
                case 1:
                    childPageAction = ChildPageAction.Insert.INSTANCE;
                    break;
                case 2:
                    childPageAction = ChildPageAction.MoveUp.INSTANCE;
                    break;
                case 3:
                    childPageAction = ChildPageAction.MoveDown.INSTANCE;
                    break;
                case 4:
                    childPageAction = ChildPageAction.Duplicate.INSTANCE;
                    break;
                case 5:
                    childPageAction = ChildPageAction.UpdateBackground.INSTANCE;
                    break;
                case 6:
                    childPageAction = ChildPageAction.ManagePages.INSTANCE;
                    break;
                case 7:
                    childPageAction = ChildPageAction.Remove.INSTANCE;
                    break;
                default:
                    childPageAction = null;
                    break;
            }
            if (childPageAction != null) {
                arrayList2.add(childPageAction);
            }
        }
        return arrayList2;
    }
}
