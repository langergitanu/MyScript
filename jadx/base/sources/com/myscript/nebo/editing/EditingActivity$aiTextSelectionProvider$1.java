package com.myscript.nebo.editing;

import android.util.DisplayMetrics;
import com.myscript.atk.core.ChildPageSpec;
import com.myscript.atk.core.ContentTypes;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.core.p020ui.TypesetListener;
import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import com.myscript.nebo.p022ai.AIAnalyticsOrigin;
import com.myscript.nebo.p022ai.presentation.compose.AiTextSelection;
import com.myscript.nebo.p022ai.presentation.compose.TextSelectionProvider;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.TextSelectionWithContext;
import com.myscript.snt.dms.IPaginatedContainer;
import com.myscript.snt.dms.NotebookManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EditingActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016¨\u0006\r"}, m1599d2 = {"com/myscript/nebo/editing/EditingActivity$aiTextSelectionProvider$1", "Lcom/myscript/nebo/ai/presentation/compose/TextSelectionProvider;", "hasSelection", "", "getPageTextSelection", "Lcom/myscript/nebo/ai/presentation/compose/AiTextSelection;", "getAllPagesText", "childPageIds", "", "", "textSelectionWithContext", "availableTextInCurrentPage", "isPdfContext", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EditingActivity$aiTextSelectionProvider$1 implements TextSelectionProvider {
    final /* synthetic */ EditingActivity this$0;

    EditingActivity$aiTextSelectionProvider$1(EditingActivity editingActivity) {
        this.this$0 = editingActivity;
    }

    @Override // com.myscript.nebo.p022ai.presentation.compose.TextSelectionProvider
    public boolean hasSelection() {
        boolean zHasSelection;
        PageController pageController;
        PageController pageController2 = this.this$0.getPageController();
        PageController.InlineSelectionTextType inlineSelectionTextTypeCurrentInlineSelectionTextType = null;
        if (pageController2 != null) {
            PageController pageController3 = pageController2;
            try {
                zHasSelection = pageController3.hasSelection();
                AutoCloseableKt.closeFinally(pageController3, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(pageController3, th);
                    throw th2;
                }
            }
        } else {
            zHasSelection = false;
        }
        if (zHasSelection) {
            return true;
        }
        PageFragment pageFragment = this.this$0.getPageFragment();
        if (pageFragment != null && (pageController = pageFragment.getPageController()) != null) {
            inlineSelectionTextTypeCurrentInlineSelectionTextType = pageController.currentInlineSelectionTextType();
        }
        return inlineSelectionTextTypeCurrentInlineSelectionTextType == PageController.InlineSelectionTextType.PDF_CONTENT;
    }

    @Override // com.myscript.nebo.p022ai.presentation.compose.TextSelectionProvider
    public AiTextSelection getPageTextSelection() {
        String aIAnalyticsSelectionType;
        String strExportCurrentSelectionToText;
        PageController pageController = this.this$0.getPageController();
        AIAnalyticsOrigin aIAnalyticsOrigin = null;
        if (pageController != null) {
            PageController pageController2 = pageController;
            EditingActivity editingActivity = this.this$0;
            try {
                PageController pageController3 = pageController2;
                strExportCurrentSelectionToText = pageController3.exportCurrentSelectionToText();
                Intrinsics.checkNotNullExpressionValue(strExportCurrentSelectionToText, "exportCurrentSelectionToText(...)");
                AIAnalyticsOrigin aIAnalyticsOrigin2 = editingActivity.getAIAnalyticsOrigin(pageController3);
                aIAnalyticsSelectionType = editingActivity.getAIAnalyticsSelectionType(pageController3);
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(pageController2, null);
                aIAnalyticsOrigin = aIAnalyticsOrigin2;
            } finally {
            }
        } else {
            aIAnalyticsSelectionType = "";
            strExportCurrentSelectionToText = aIAnalyticsSelectionType;
        }
        return new AiTextSelection(strExportCurrentSelectionToText, "", aIAnalyticsSelectionType, aIAnalyticsOrigin);
    }

    @Override // com.myscript.nebo.p022ai.presentation.compose.TextSelectionProvider
    public AiTextSelection getAllPagesText(List<String> childPageIds) {
        AIAnalyticsOrigin aIAnalyticsOrigin;
        ArrayList arrayList;
        String strJoinToString$default;
        ArrayList childPageList;
        PageController pageController = this.this$0.getPageController();
        String str = null;
        if (pageController != null) {
            PageController pageController2 = pageController;
            EditingActivity editingActivity = this.this$0;
            try {
                final PageController pageController3 = pageController2;
                AIAnalyticsOrigin aIAnalyticsOrigin2 = editingActivity.getAIAnalyticsOrigin(pageController3);
                if (!isPdfContext()) {
                    IPaginatedContainer paginatedContainer = editingActivity.getChildPagesViewModel().getPaginatedContainer();
                    NotebookManager notebookManager = paginatedContainer instanceof NotebookManager ? (NotebookManager) paginatedContainer : null;
                    if (notebookManager == null) {
                        strJoinToString$default = "";
                    } else {
                        if (childPageIds != null) {
                            List<String> list = childPageIds;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(PageKey.createKeyFromUuid((String) it.next()));
                            }
                            arrayList = arrayList2;
                        } else {
                            List<com.myscript.snt.dms.PageProperties> listPages = notebookManager.pages();
                            Intrinsics.checkNotNullExpressionValue(listPages, "pages(...)");
                            List<com.myscript.snt.dms.PageProperties> list2 = listPages;
                            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                            Iterator<T> it2 = list2.iterator();
                            while (it2.hasNext()) {
                                arrayList3.add(PageKey.createKeyFromUuid(((com.myscript.snt.dms.PageProperties) it2.next()).getPageId()));
                            }
                            arrayList = arrayList3;
                        }
                        ArrayList arrayList4 = arrayList;
                        DisplayMetrics fixedDisplayMetrics = com.myscript.nebo.common.utils.DisplayMetricsExtKt.getFixedDisplayMetrics(editingActivity);
                        List<String> listExportAllToText = editingActivity.getLibraryRepository().createExportController(arrayList4, new BlockRenderer(fixedDisplayMetrics, editingActivity.getApplication().getCacheDir()), new TypesetListener(fixedDisplayMetrics), new ViewTransform(fixedDisplayMetrics.xdpi, fixedDisplayMetrics.ydpi), CollectionsKt.emptyList()).exportAllToText(null);
                        Intrinsics.checkNotNullExpressionValue(listExportAllToText, "exportAllToText(...)");
                        strJoinToString$default = CollectionsKt.joinToString$default(listExportAllToText, "\n\n", null, null, 0, null, null, 62, null);
                    }
                } else {
                    if (childPageIds != null) {
                        List<ChildPageSpec> childPageList2 = pageController3.getChildPageList();
                        Intrinsics.checkNotNullExpressionValue(childPageList2, "getChildPageList(...)");
                        ArrayList arrayList5 = new ArrayList();
                        for (Object obj : childPageList2) {
                            if (childPageIds.contains(((ChildPageSpec) obj).getId())) {
                                arrayList5.add(obj);
                            }
                        }
                        childPageList = arrayList5;
                    } else {
                        childPageList = pageController3.getChildPageList();
                    }
                    Intrinsics.checkNotNull(childPageList);
                    strJoinToString$default = CollectionsKt.joinToString$default(childPageList, "\n\n", null, null, 0, null, new Function1() { // from class: com.myscript.nebo.editing.EditingActivity$aiTextSelectionProvider$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return EditingActivity$aiTextSelectionProvider$1.getAllPagesText$lambda$2$1(pageController3, (ChildPageSpec) obj2);
                        }
                    }, 30, null);
                }
                AutoCloseableKt.closeFinally(pageController2, null);
                str = strJoinToString$default;
                aIAnalyticsOrigin = aIAnalyticsOrigin2;
            } finally {
            }
        } else {
            aIAnalyticsOrigin = null;
        }
        return new AiTextSelection(str == null ? "" : str, null, "whole_pages", aIAnalyticsOrigin, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getAllPagesText$lambda$2$1(PageController pageController, ChildPageSpec childPageSpec) {
        String childPageText = pageController.getChildPageText(childPageSpec.getId(), false);
        Intrinsics.checkNotNullExpressionValue(childPageText, "getChildPageText(...)");
        return childPageText;
    }

    @Override // com.myscript.nebo.p022ai.presentation.compose.TextSelectionProvider
    public AiTextSelection textSelectionWithContext() {
        String aIAnalyticsSelectionType;
        String str;
        PageController pageController = this.this$0.getPageController();
        if (pageController == null) {
            return null;
        }
        PageController pageController2 = pageController;
        EditingActivity editingActivity = this.this$0;
        try {
            PageController pageController3 = pageController2;
            AIAnalyticsOrigin aIAnalyticsOrigin = editingActivity.getAIAnalyticsOrigin(pageController3);
            String strExportRawText = "";
            if (hasSelection()) {
                TextSelectionWithContext textSelectionWithContext = pageController3.textSelectionWithContext();
                String selectedText = textSelectionWithContext != null ? textSelectionWithContext.getSelectedText() : null;
                if (selectedText == null) {
                    selectedText = "";
                }
                String context = textSelectionWithContext != null ? textSelectionWithContext.getContext() : null;
                if (context != null) {
                    strExportRawText = context;
                }
                aIAnalyticsSelectionType = editingActivity.getAIAnalyticsSelectionType(pageController3);
                str = strExportRawText;
                strExportRawText = selectedText;
            } else {
                boolean zAreEqual = Intrinsics.areEqual(pageController3.pageType(), ContentTypes.PDF);
                aIAnalyticsSelectionType = AIQuizConstants.WHOLE_PAGE;
                if (zAreEqual) {
                    strExportRawText = pageController3.getChildPageText(pageController3.getChildPageIdDisplayed(), false);
                    Intrinsics.checkNotNull(strExportRawText);
                } else if (pageController3.hasContent()) {
                    strExportRawText = pageController3.exportRawText(null);
                    Intrinsics.checkNotNull(strExportRawText);
                } else {
                    str = "";
                    aIAnalyticsSelectionType = str;
                }
                str = strExportRawText;
            }
            AiTextSelection aiTextSelection = new AiTextSelection(strExportRawText, str, aIAnalyticsSelectionType, aIAnalyticsOrigin);
            AutoCloseableKt.closeFinally(pageController2, null);
            return aiTextSelection;
        } finally {
        }
    }

    @Override // com.myscript.nebo.p022ai.presentation.compose.TextSelectionProvider
    public AiTextSelection availableTextInCurrentPage() {
        AIAnalyticsOrigin aIAnalyticsOrigin;
        PageController pageController = this.this$0.getPageController();
        String strExportRawText = "";
        if (pageController != null) {
            PageController pageController2 = pageController;
            EditingActivity editingActivity = this.this$0;
            try {
                PageController pageController3 = pageController2;
                if (hasSelection()) {
                    strExportRawText = pageController3.exportCurrentSelectionToText();
                    Intrinsics.checkNotNullExpressionValue(strExportRawText, "exportCurrentSelectionToText(...)");
                } else if (Intrinsics.areEqual(pageController3.pageType(), ContentTypes.PDF)) {
                    strExportRawText = pageController3.getChildPageText(pageController3.getChildPageIdDisplayed(), false);
                    Intrinsics.checkNotNullExpressionValue(strExportRawText, "getChildPageText(...)");
                } else if (pageController3.hasContent()) {
                    strExportRawText = pageController3.exportRawText(null);
                    Intrinsics.checkNotNullExpressionValue(strExportRawText, "exportRawText(...)");
                }
                AIAnalyticsOrigin aIAnalyticsOrigin2 = editingActivity.getAIAnalyticsOrigin(pageController3);
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(pageController2, null);
                aIAnalyticsOrigin = aIAnalyticsOrigin2;
            } finally {
            }
        } else {
            aIAnalyticsOrigin = null;
        }
        return new AiTextSelection(strExportRawText, null, AIQuizConstants.WHOLE_PAGE, aIAnalyticsOrigin, 2, null);
    }

    @Override // com.myscript.nebo.p022ai.presentation.compose.TextSelectionProvider
    public boolean isPdfContext() {
        PageController pageController = this.this$0.getPageController();
        if (pageController == null) {
            return false;
        }
        PageController pageController2 = pageController;
        try {
            boolean zAreEqual = Intrinsics.areEqual(pageController2.pageType(), ContentTypes.PDF);
            AutoCloseableKt.closeFinally(pageController2, null);
            return zAreEqual;
        } finally {
        }
    }
}
