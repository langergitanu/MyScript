package com.survicate.surveys.core.queue;

import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BackoffStrategy.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/core/queue/JitterBackoffStrategy;", "Lcom/survicate/surveys/core/queue/BackoffStrategy;", "maxAttempts", "", "<init>", "(I)V", "getDelayMillis", "", "attemptNumber", "calculateExponentialDelay", "Companion", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class JitterBackoffStrategy implements BackoffStrategy {
    private static final long BASE_DELAY_MS = 4000;
    private static final long MAX_DELAY_MS = 900000;
    private static final int MAX_JITTER_MS = 1000;
    private static final int MILLIS_IN_SECOND = 1000;
    private final int maxAttempts;

    public JitterBackoffStrategy(int i) {
        this.maxAttempts = i;
    }

    @Override // com.survicate.surveys.core.queue.BackoffStrategy
    public long getDelayMillis(int attemptNumber) {
        if (attemptNumber > this.maxAttempts) {
            return -1L;
        }
        int iRandom = RangesKt.random(new IntRange(1, 1000), Random.INSTANCE);
        return attemptNumber <= 0 ? ((long) iRandom) + BASE_DELAY_MS : calculateExponentialDelay(attemptNumber) + BASE_DELAY_MS + ((long) iRandom);
    }

    private final long calculateExponentialDelay(int attemptNumber) {
        return Math.min(896000L, (long) (Math.pow(2.0d, attemptNumber - 1) * ((double) 1000)));
    }
}
