package com.survicate.surveys.core.targeting.backend;

import kotlin.Metadata;

/* JADX INFO: compiled from: CacheableTargetingResult.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/backend/CacheableTargetingResult;", "", "isSuccess", "", "()Z", "cacheUntilMs", "", "getCacheUntilMs", "()J", "isExpired", "currentTimeMs", "shouldRefresh", "thresholdMs", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface CacheableTargetingResult {
    long getCacheUntilMs();

    boolean isExpired(long currentTimeMs);

    boolean isSuccess();

    boolean shouldRefresh(long currentTimeMs, long thresholdMs);

    /* JADX INFO: compiled from: CacheableTargetingResult.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        public static boolean isExpired(CacheableTargetingResult cacheableTargetingResult, long j) {
            return j > cacheableTargetingResult.getCacheUntilMs();
        }

        public static boolean shouldRefresh(CacheableTargetingResult cacheableTargetingResult, long j, long j2) {
            return j + j2 >= cacheableTargetingResult.getCacheUntilMs();
        }
    }
}
