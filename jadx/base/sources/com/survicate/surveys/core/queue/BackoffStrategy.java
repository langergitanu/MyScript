package com.survicate.surveys.core.queue;

import kotlin.Metadata;

/* JADX INFO: compiled from: BackoffStrategy.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/queue/BackoffStrategy;", "", "getDelayMillis", "", "attemptNumber", "", "Companion", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface BackoffStrategy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    long getDelayMillis(int attemptNumber);

    /* JADX INFO: compiled from: BackoffStrategy.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/core/queue/BackoffStrategy$Companion;", "", "<init>", "()V", "DEFAULT", "Lcom/survicate/surveys/core/queue/BackoffStrategy;", "getDEFAULT", "()Lcom/survicate/surveys/core/queue/BackoffStrategy;", "NO_RETRY", "getNO_RETRY", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final BackoffStrategy DEFAULT = new JitterBackoffStrategy(Integer.MAX_VALUE);
        private static final BackoffStrategy NO_RETRY = new NoRetryBackoffStrategy();

        private Companion() {
        }

        public final BackoffStrategy getDEFAULT() {
            return DEFAULT;
        }

        public final BackoffStrategy getNO_RETRY() {
            return NO_RETRY;
        }
    }
}
