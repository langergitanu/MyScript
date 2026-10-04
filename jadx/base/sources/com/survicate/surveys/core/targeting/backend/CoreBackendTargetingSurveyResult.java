package com.survicate.surveys.core.targeting.backend;

import com.survicate.surveys.core.targeting.backend.CacheableTargetingResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CacheableTargetingResult.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/backend/CoreBackendTargetingSurveyResult;", "Lcom/survicate/surveys/core/targeting/backend/CacheableTargetingResult;", "id", "", "isSuccess", "", "cacheUntilMs", "", "<init>", "(Ljava/lang/String;ZJ)V", "getId", "()Ljava/lang/String;", "()Z", "getCacheUntilMs", "()J", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class CoreBackendTargetingSurveyResult implements CacheableTargetingResult {
    private final long cacheUntilMs;
    private final String id;
    private final boolean isSuccess;

    public static /* synthetic */ CoreBackendTargetingSurveyResult copy$default(CoreBackendTargetingSurveyResult coreBackendTargetingSurveyResult, String str, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = coreBackendTargetingSurveyResult.id;
        }
        if ((i & 2) != 0) {
            z = coreBackendTargetingSurveyResult.isSuccess;
        }
        if ((i & 4) != 0) {
            j = coreBackendTargetingSurveyResult.cacheUntilMs;
        }
        return coreBackendTargetingSurveyResult.copy(str, z, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
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

    public final CoreBackendTargetingSurveyResult copy(String id, boolean isSuccess, long cacheUntilMs) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new CoreBackendTargetingSurveyResult(id, isSuccess, cacheUntilMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoreBackendTargetingSurveyResult)) {
            return false;
        }
        CoreBackendTargetingSurveyResult coreBackendTargetingSurveyResult = (CoreBackendTargetingSurveyResult) other;
        return Intrinsics.areEqual(this.id, coreBackendTargetingSurveyResult.id) && this.isSuccess == coreBackendTargetingSurveyResult.isSuccess && this.cacheUntilMs == coreBackendTargetingSurveyResult.cacheUntilMs;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + Boolean.hashCode(this.isSuccess)) * 31) + Long.hashCode(this.cacheUntilMs);
    }

    public String toString() {
        return "CoreBackendTargetingSurveyResult(id=" + this.id + ", isSuccess=" + this.isSuccess + ", cacheUntilMs=" + this.cacheUntilMs + ')';
    }

    public CoreBackendTargetingSurveyResult(String id, boolean z, long j) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.isSuccess = z;
        this.cacheUntilMs = j;
    }

    @Override // com.survicate.surveys.core.targeting.backend.CacheableTargetingResult
    public boolean isExpired(long j) {
        return CacheableTargetingResult.DefaultImpls.isExpired(this, j);
    }

    @Override // com.survicate.surveys.core.targeting.backend.CacheableTargetingResult
    public boolean shouldRefresh(long j, long j2) {
        return CacheableTargetingResult.DefaultImpls.shouldRefresh(this, j, j2);
    }

    public final String getId() {
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
