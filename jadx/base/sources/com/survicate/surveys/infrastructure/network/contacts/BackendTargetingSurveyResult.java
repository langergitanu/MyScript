package com.survicate.surveys.infrastructure.network.contacts;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: BackendTargetingResult.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J'\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingSurveyResult;", "", "id", "", "canShow", "", "cacheUntilMs", "", "<init>", "(Ljava/lang/String;ZJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getCanShow$annotations", "getCanShow", "()Z", "getCacheUntilMs$annotations", "getCacheUntilMs", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class BackendTargetingSurveyResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long cacheUntilMs;
    private final boolean canShow;
    private final String id;

    public static /* synthetic */ BackendTargetingSurveyResult copy$default(BackendTargetingSurveyResult backendTargetingSurveyResult, String str, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = backendTargetingSurveyResult.id;
        }
        if ((i & 2) != 0) {
            z = backendTargetingSurveyResult.canShow;
        }
        if ((i & 4) != 0) {
            j = backendTargetingSurveyResult.cacheUntilMs;
        }
        return backendTargetingSurveyResult.copy(str, z, j);
    }

    @SerialName("cache_until")
    public static /* synthetic */ void getCacheUntilMs$annotations() {
    }

    @SerialName("can_show")
    public static /* synthetic */ void getCanShow$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanShow() {
        return this.canShow;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getCacheUntilMs() {
        return this.cacheUntilMs;
    }

    public final BackendTargetingSurveyResult copy(String id, boolean canShow, long cacheUntilMs) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new BackendTargetingSurveyResult(id, canShow, cacheUntilMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackendTargetingSurveyResult)) {
            return false;
        }
        BackendTargetingSurveyResult backendTargetingSurveyResult = (BackendTargetingSurveyResult) other;
        return Intrinsics.areEqual(this.id, backendTargetingSurveyResult.id) && this.canShow == backendTargetingSurveyResult.canShow && this.cacheUntilMs == backendTargetingSurveyResult.cacheUntilMs;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + Boolean.hashCode(this.canShow)) * 31) + Long.hashCode(this.cacheUntilMs);
    }

    public String toString() {
        return "BackendTargetingSurveyResult(id=" + this.id + ", canShow=" + this.canShow + ", cacheUntilMs=" + this.cacheUntilMs + ')';
    }

    /* JADX INFO: compiled from: BackendTargetingResult.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingSurveyResult$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingSurveyResult;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<BackendTargetingSurveyResult> serializer() {
            return BackendTargetingSurveyResult$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ BackendTargetingSurveyResult(int i, String str, boolean z, long j, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, BackendTargetingSurveyResult$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.canShow = z;
        this.cacheUntilMs = j;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(BackendTargetingSurveyResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeBooleanElement(serialDesc, 1, self.canShow);
        output.encodeLongElement(serialDesc, 2, self.cacheUntilMs);
    }

    public BackendTargetingSurveyResult(String id, boolean z, long j) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.canShow = z;
        this.cacheUntilMs = j;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public final long getCacheUntilMs() {
        return this.cacheUntilMs;
    }
}
