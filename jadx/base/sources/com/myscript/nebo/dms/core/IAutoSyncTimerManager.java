package com.myscript.nebo.dms.core;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.snt.core.NotebookKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IAutoSyncTimerManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0013À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "", TtmlNode.START, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "pause", "resume", "enterPageEditingMode", "exitPageEditingMode", "onAppGoingToBackground", "onAppResumedFromBackground", "triggerSyncNow", "triggerRefreshNow", "triggerResumeSync", "cancelSync", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "Provider", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IAutoSyncTimerManager {

    /* JADX INFO: compiled from: IAutoSyncTimerManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager$Provider;", "", "provideAutoSyncTimerManager", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        IAutoSyncTimerManager provideAutoSyncTimerManager();
    }

    void cancelSync();

    void cancelSync(NotebookKey notebookKey);

    Object enterPageEditingMode(Continuation<? super Unit> continuation);

    Object exitPageEditingMode(Continuation<? super Unit> continuation);

    Object onAppGoingToBackground(Continuation<? super Unit> continuation);

    Object onAppResumedFromBackground(Continuation<? super Unit> continuation);

    Object pause(Continuation<? super Unit> continuation);

    Object resume(Continuation<? super Unit> continuation);

    Object start(Continuation<? super Unit> continuation);

    Object stop(Continuation<? super Unit> continuation);

    Object triggerRefreshNow(Continuation<? super Unit> continuation);

    Object triggerResumeSync(Continuation<? super Unit> continuation);

    Object triggerSyncNow(Continuation<? super Unit> continuation);
}
