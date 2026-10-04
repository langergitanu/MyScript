package com.myscript.nebo.log;

import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.editing.NoteProperties;
import com.myscript.nebo.editing.PageProperties;
import com.myscript.nebo.storage.StorageState;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.PageType;
import com.survicate.surveys.TextRecallingManager;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: TechnicalLoggerExt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0007\u001a\u0016\u0010\f\u001a\u00020\u0006*\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u001a\u0014\u0010\u0012\u001a\u00020\u0006*\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a.\u0010\u001b\u001a\u00020\u0006*\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u001a<\u0010\u001f\u001a\u00020\u0006*\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190!2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010!\u001a\u0014\u0010#\u001a\u00020\u0006*\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020%\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0015\u001a\u00020\u0001*\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u0015\u001a\u00020\u0001*\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001a¨\u0006&"}, m1599d2 = {"NULL_DISPLAY", "", "KEY_PAGE_TYPE", "KEY_PAGE_LOCALE_IDENTIFIER", "KEY_NOTEBOOK_KEY_IDENTIFIER", "logAction", "", "Lcom/myscript/nebo/log/TechnicalLogger;", "tag", "action", "logProducer", "Lkotlin/Function0;", "setNotebookKeyValues", "folderModel", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "setPageKeyValues", "pageProperties", "Lcom/myscript/nebo/editing/PageProperties;", "setNoteKeyValues", "noteProperties", "Lcom/myscript/nebo/editing/NoteProperties;", "logData", "Lcom/myscript/snt/dms/PageType;", "getLogData", "(Lcom/myscript/snt/dms/PageType;)Ljava/lang/String;", "Lcom/myscript/snt/core/PageKey;", "(Lcom/myscript/snt/core/PageKey;)Ljava/lang/String;", "logPageDetails", "pageKey", "pageModel", "Lcom/myscript/nebo/dms/core/model/PageModel;", "logPagesDetails", "pageKeys", "", "pageModels", "setStorageStateKeyValues", "storageState", "Lcom/myscript/nebo/storage/StorageState;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TechnicalLoggerExt {
    private static final String KEY_NOTEBOOK_KEY_IDENTIFIER = "notebook_key_identifier";
    private static final String KEY_PAGE_LOCALE_IDENTIFIER = "page_locale_identifier";
    private static final String KEY_PAGE_TYPE = "page_type";
    private static final String NULL_DISPLAY = "<null>";

    /* JADX INFO: compiled from: TechnicalLoggerExt.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PageType.values().length];
            try {
                iArr[PageType.PDF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageType.TextDocument.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PageType.RawContent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void logAction(TechnicalLogger technicalLogger, String tag, String action) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(action, "action");
        logAction$default(technicalLogger, tag, action, null, 4, null);
    }

    public static /* synthetic */ void logAction$default(TechnicalLogger technicalLogger, String str, String str2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Function0() { // from class: com.myscript.nebo.log.TechnicalLoggerExt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TechnicalLoggerExt.logAction$lambda$0();
                }
            };
        }
        logAction(technicalLogger, str, str2, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String logAction$lambda$0() {
        return "";
    }

    public static final void logAction(TechnicalLogger technicalLogger, String tag, String action, Function0<String> logProducer) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(logProducer, "logProducer");
        try {
            String strInvoke = logProducer.invoke();
            String str = strInvoke;
            if (str != null && str.length() != 0) {
                if (technicalLogger != null) {
                    technicalLogger.logTrace("[" + tag + "] " + action + ": " + strInvoke);
                    return;
                }
                return;
            }
            if (technicalLogger != null) {
                technicalLogger.logTrace("[" + tag + "] " + action);
            }
        } catch (Exception e) {
            if (technicalLogger != null) {
                technicalLogger.logError(new RuntimeException("Log action from lambda crashed " + e.getMessage()));
            }
        }
    }

    public static final void setNotebookKeyValues(TechnicalLogger technicalLogger, FolderModel folderModel) {
        String strUuid;
        NotebookKey notebookKey;
        if (folderModel == null || (notebookKey = folderModel.getNotebookKey()) == null || (strUuid = notebookKey.uuid()) == null) {
            strUuid = NULL_DISPLAY;
        }
        if (technicalLogger != null) {
            technicalLogger.setKeyValue(KEY_NOTEBOOK_KEY_IDENTIFIER, strUuid);
        }
    }

    public static final void setPageKeyValues(TechnicalLogger technicalLogger, PageProperties pageProperties) {
        PageType pageType;
        Intrinsics.checkNotNullParameter(technicalLogger, "<this>");
        technicalLogger.setKeyValue(KEY_PAGE_TYPE, (pageProperties == null || (pageType = pageProperties.getPageType()) == null) ? null : pageType.name());
    }

    public static final void setNoteKeyValues(TechnicalLogger technicalLogger, NoteProperties noteProperties) {
        Intrinsics.checkNotNullParameter(technicalLogger, "<this>");
        technicalLogger.setKeyValue(KEY_PAGE_LOCALE_IDENTIFIER, noteProperties != null ? noteProperties.getLang() : null);
    }

    private static final String getLogData(PageType pageType) {
        int i = pageType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[pageType.ordinal()];
        if (i == -1) {
            return NULL_DISPLAY;
        }
        if (i == 1) {
            return "PDF";
        }
        if (i == 2) {
            return "TD";
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "RC";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getLogData(PageKey pageKey) {
        String strUuid;
        return (pageKey == null || (strUuid = pageKey.uuid()) == null) ? NULL_DISPLAY : strUuid;
    }

    public static final void logPageDetails(TechnicalLogger technicalLogger, String tag, String action, final PageKey pageKey, final PageModel pageModel) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        logAction(technicalLogger, tag, action, new Function0() { // from class: com.myscript.nebo.log.TechnicalLoggerExt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TechnicalLoggerExt.logPageDetails$lambda$0(pageKey, pageModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String logPageDetails$lambda$0(PageKey pageKey, PageModel pageModel) {
        String logData = getLogData(pageKey);
        if (pageModel == null) {
            return "page not found " + logData;
        }
        if (pageModel.isCorrupted()) {
            return "corrupted page " + logData;
        }
        return logData + " pageType=" + getLogData(pageModel.getPageType()) + " corrupted=" + pageModel.isCorrupted();
    }

    public static final void logPagesDetails(TechnicalLogger technicalLogger, String tag, String action, final List<? extends PageKey> pageKeys, final List<PageModel> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(pageKeys, "pageKeys");
        logAction(technicalLogger, tag, action, new Function0() { // from class: com.myscript.nebo.log.TechnicalLoggerExt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TechnicalLoggerExt.logPagesDetails$lambda$0(list, pageKeys);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String logPagesDetails$lambda$0(List list, List list2) {
        if (list == null) {
            return "keys=" + CollectionsKt.joinToString$default(list2, TextRecallingManager.ANSWER_SEPARATOR, "[", "]", 0, null, new PropertyReference1Impl() { // from class: com.myscript.nebo.log.TechnicalLoggerExt$logPagesDetails$1$keys$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return TechnicalLoggerExt.getLogData((PageKey) obj);
                }
            }, 24, null);
        }
        List<PageModel> list3 = list;
        String strJoinToString$default = CollectionsKt.joinToString$default(list3, TextRecallingManager.ANSWER_SEPARATOR, "[", "]", 0, null, new Function1() { // from class: com.myscript.nebo.log.TechnicalLoggerExt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TechnicalLoggerExt.logPagesDetails$lambda$0$0((PageModel) obj);
            }
        }, 24, null);
        int i = 0;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            for (PageModel pageModel : list3) {
                if (pageModel != null && pageModel.isCorrupted() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return list.size() + " (" + i + " corrupted) types=" + strJoinToString$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence logPagesDetails$lambda$0$0(PageModel pageModel) {
        return getLogData(pageModel != null ? pageModel.getPageType() : null);
    }

    public static final void setStorageStateKeyValues(TechnicalLogger technicalLogger, StorageState storageState) {
        Intrinsics.checkNotNullParameter(storageState, "storageState");
        if (technicalLogger != null) {
            technicalLogger.setKeyValue("app_storage_available_space", CommonUtils.getHumanReadableByteCount(storageState.getAvailableSpace(), true));
        }
        if (technicalLogger != null) {
            technicalLogger.setKeyValue("app_storage_state", storageState.getClass().getSimpleName());
        }
    }
}
