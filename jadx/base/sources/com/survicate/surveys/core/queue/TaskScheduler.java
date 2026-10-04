package com.survicate.surveys.core.queue;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TaskScheduler.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\nH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, m1599d2 = {"Lcom/survicate/surveys/core/queue/TaskScheduler;", "", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "onLogMessage", "Lkotlin/Function1;", "", "", "getOnLogMessage", "()Lkotlin/jvm/functions/Function1;", "setOnLogMessage", "(Lkotlin/jvm/functions/Function1;)V", "schedule", "tasks", "", "Lcom/survicate/surveys/core/queue/QueueTask;", "task", "clear", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface TaskScheduler {
    void clear();

    Function1<String, Unit> getOnLogMessage();

    boolean isEnabled();

    void schedule(QueueTask task);

    void schedule(List<? extends QueueTask> tasks);

    void setEnabled(boolean z);

    void setOnLogMessage(Function1<? super String, Unit> function1);

    /* JADX INFO: compiled from: TaskScheduler.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        public static void schedule(TaskScheduler taskScheduler, QueueTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            taskScheduler.schedule(CollectionsKt.listOf(task));
        }
    }
}
