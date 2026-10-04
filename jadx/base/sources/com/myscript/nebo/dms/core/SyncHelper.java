package com.myscript.nebo.dms.core;

import com.myscript.snt.core.NotebookKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: LibraryRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/SyncHelper;", "", "triggerRefresh", "", "triggerSync", "userAction", "", "hasLocalSyncUpdate", "hasMultiEditor", "delayMicroseconds", "", "isAutoSyncEnabled", "cancelSync", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "resumeSync", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SyncHelper {
    void cancelSync();

    void cancelSync(NotebookKey notebookKey);

    boolean hasLocalSyncUpdate();

    boolean hasMultiEditor(long delayMicroseconds);

    boolean isAutoSyncEnabled();

    void resumeSync();

    void triggerRefresh();

    void triggerSync(boolean userAction);
}
