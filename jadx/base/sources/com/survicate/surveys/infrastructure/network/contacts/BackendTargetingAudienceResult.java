package com.survicate.surveys.infrastructure.network.contacts;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: BackendTargetingResult.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0004\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006)"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingAudienceResult;", "", "id", "", "isSatisfied", "", "cacheUntilMs", "<init>", "(JZJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "isSatisfied$annotations", "()Z", "getCacheUntilMs$annotations", "getCacheUntilMs", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class BackendTargetingAudienceResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long cacheUntilMs;
    private final long id;
    private final boolean isSatisfied;

    public static /* synthetic */ BackendTargetingAudienceResult copy$default(BackendTargetingAudienceResult backendTargetingAudienceResult, long j, boolean z, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = backendTargetingAudienceResult.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            z = backendTargetingAudienceResult.isSatisfied;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            j2 = backendTargetingAudienceResult.cacheUntilMs;
        }
        return backendTargetingAudienceResult.copy(j3, z2, j2);
    }

    @SerialName("cache_until")
    public static /* synthetic */ void getCacheUntilMs$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("is_satisfied")
    public static /* synthetic */ void isSatisfied$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSatisfied() {
        return this.isSatisfied;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getCacheUntilMs() {
        return this.cacheUntilMs;
    }

    public final BackendTargetingAudienceResult copy(long id, boolean isSatisfied, long cacheUntilMs) {
        return new BackendTargetingAudienceResult(id, isSatisfied, cacheUntilMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackendTargetingAudienceResult)) {
            return false;
        }
        BackendTargetingAudienceResult backendTargetingAudienceResult = (BackendTargetingAudienceResult) other;
        return this.id == backendTargetingAudienceResult.id && this.isSatisfied == backendTargetingAudienceResult.isSatisfied && this.cacheUntilMs == backendTargetingAudienceResult.cacheUntilMs;
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + Boolean.hashCode(this.isSatisfied)) * 31) + Long.hashCode(this.cacheUntilMs);
    }

    public String toString() {
        return "BackendTargetingAudienceResult(id=" + this.id + ", isSatisfied=" + this.isSatisfied + ", cacheUntilMs=" + this.cacheUntilMs + ')';
    }

    /* JADX INFO: compiled from: BackendTargetingResult.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingAudienceResult$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingAudienceResult;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<BackendTargetingAudienceResult> serializer() {
            return BackendTargetingAudienceResult$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ BackendTargetingAudienceResult(int i, long j, boolean z, long j2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, BackendTargetingAudienceResult$$serializer.INSTANCE.getDescriptor());
        }
        this.id = j;
        this.isSatisfied = z;
        this.cacheUntilMs = j2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(BackendTargetingAudienceResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.id);
        output.encodeBooleanElement(serialDesc, 1, self.isSatisfied);
        output.encodeLongElement(serialDesc, 2, self.cacheUntilMs);
    }

    public BackendTargetingAudienceResult(long j, boolean z, long j2) {
        this.id = j;
        this.isSatisfied = z;
        this.cacheUntilMs = j2;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean isSatisfied() {
        return this.isSatisfied;
    }

    public final long getCacheUntilMs() {
        return this.cacheUntilMs;
    }
}
