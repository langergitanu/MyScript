package com.survicate.surveys.core.queue;

import kotlin.Metadata;

/* JADX INFO: compiled from: BackoffStrategy.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/core/queue/NoRetryBackoffStrategy;", "Lcom/survicate/surveys/core/queue/BackoffStrategy;", "<init>", "()V", "getDelayMillis", "", "attemptNumber", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NoRetryBackoffStrategy implements BackoffStrategy {
    @Override // com.survicate.surveys.core.queue.BackoffStrategy
    public long getDelayMillis(int attemptNumber) {
        return -1L;
    }
}
