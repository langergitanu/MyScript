package com.survicate.surveys;

import com.survicate.surveys.infrastructure.serialization.IntegrationPayloadSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: IntegrationListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\t¢\u0006\u0004\b\u0003\u0010\nJ\u0013\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, m1599d2 = {"Lcom/survicate/surveys/IntegrationPayload;", "", "value", "<init>", "(Ljava/lang/Object;)V", "", "(Ljava/lang/String;)V", "", "(Z)V", "", "(Ljava/lang/Number;)V", "getValue", "()Ljava/lang/Object;", "equals", "other", "hashCode", "", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable(with = IntegrationPayloadSerializer.class)
public final class IntegrationPayload {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Object value;

    /* JADX INFO: compiled from: IntegrationListener.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/IntegrationPayload$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/IntegrationPayload;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<IntegrationPayload> serializer() {
            return IntegrationPayloadSerializer.INSTANCE;
        }
    }

    private IntegrationPayload(Object obj) {
        this.value = obj;
    }

    public final Object getValue() {
        return this.value;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IntegrationPayload(String value) {
        this((Object) value);
        Intrinsics.checkNotNullParameter(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IntegrationPayload(boolean z) {
        this(Boolean.valueOf(z));
        Intrinsics.checkNotNull(Boolean.valueOf(z), "null cannot be cast to non-null type kotlin.Any");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IntegrationPayload(Number value) {
        this((Object) value);
        Intrinsics.checkNotNullParameter(value, "value");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.survicate.surveys.IntegrationPayload");
        return Intrinsics.areEqual(this.value, ((IntegrationPayload) other).value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }
}
