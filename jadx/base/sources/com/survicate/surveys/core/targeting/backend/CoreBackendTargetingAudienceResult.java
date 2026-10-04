package com.survicate.surveys.core.targeting.backend;

import com.survicate.surveys.core.targeting.backend.CacheableTargetingResult;
import kotlin.Metadata;

/* JADX INFO: compiled from: CacheableTargetingResult.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/backend/CoreBackendTargetingAudienceResult;", "Lcom/survicate/surveys/core/targeting/backend/CacheableTargetingResult;", "id", "", "isSuccess", "", "cacheUntilMs", "<init>", "(JZJ)V", "getId", "()J", "()Z", "getCacheUntilMs", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class CoreBackendTargetingAudienceResult implements CacheableTargetingResult {
    private final long cacheUntilMs;
    private final long id;
    private final boolean isSuccess;

    public static /* synthetic */ CoreBackendTargetingAudienceResult copy$default(CoreBackendTargetingAudienceResult coreBackendTargetingAudienceResult, long j, boolean z, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = coreBackendTargetingAudienceResult.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            z = coreBackendTargetingAudienceResult.isSuccess;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            j2 = coreBackendTargetingAudienceResult.cacheUntilMs;
        }
        return coreBackendTargetingAudienceResult.copy(j3, z2, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getCacheUntilMs() {
        return this.cacheUntilMs;
    }

    public final CoreBackendTargetingAudienceResult copy(long id, boolean isSuccess, long cacheUntilMs) {
        return new CoreBackendTargetingAudienceResult(id, isSuccess, cacheUntilMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoreBackendTargetingAudienceResult)) {
            return false;
        }
        CoreBackendTargetingAudienceResult coreBackendTargetingAudienceResult = (CoreBackendTargetingAudienceResult) other;
        return this.id == coreBackendTargetingAudienceResult.id && this.isSuccess == coreBackendTargetingAudienceResult.isSuccess && this.cacheUntilMs == coreBackendTargetingAudienceResult.cacheUntilMs;
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + Boolean.hashCode(this.isSuccess)) * 31) + Long.hashCode(this.cacheUntilMs);
    }

    public String toString() {
        return "CoreBackendTargetingAudienceResult(id=" + this.id + ", isSuccess=" + this.isSuccess + ", cacheUntilMs=" + this.cacheUntilMs + ')';
    }

    public CoreBackendTargetingAudienceResult(long j, boolean z, long j2) {
        this.id = j;
        this.isSuccess = z;
        this.cacheUntilMs = j2;
    }

    @Override // com.survicate.surveys.core.targeting.backend.CacheableTargetingResult
    public boolean isExpired(long j) {
        return CacheableTargetingResult.DefaultImpls.isExpired(this, j);
    }

    @Override // com.survicate.surveys.core.targeting.backend.CacheableTargetingResult
    public boolean shouldRefresh(long j, long j2) {
        return CacheableTargetingResult.DefaultImpls.shouldRefresh(this, j, j2);
    }

    public final long getId() {
        return this.id;
    }

    @Override // com.survicate.surveys.core.targeting.backend.CacheableTargetingResult
    public boolean isSuccess() {
        return this.isSuccess;
    }

    @Override // com.survicate.surveys.core.targeting.backend.CacheableTargetingResult
    public long getCacheUntilMs() {
        return this.cacheUntilMs;
    }
}
