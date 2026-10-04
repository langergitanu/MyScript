package com.survicate.surveys.entities.survey;

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

/* JADX INFO: compiled from: Integration.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0014¨\u0006)"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/Integration;", "", "provider", "", "enabled", "", "sendInputFields", "<init>", "(Ljava/lang/String;ZZ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProvider$annotations", "()V", "getProvider", "()Ljava/lang/String;", "getEnabled$annotations", "getEnabled", "()Z", "getSendInputFields$annotations", "getSendInputFields", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class Integration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean enabled;
    private final String provider;
    private final boolean sendInputFields;

    public static /* synthetic */ Integration copy$default(Integration integration, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = integration.provider;
        }
        if ((i & 2) != 0) {
            z = integration.enabled;
        }
        if ((i & 4) != 0) {
            z2 = integration.sendInputFields;
        }
        return integration.copy(str, z, z2);
    }

    @SerialName("enabled")
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @SerialName("provider")
    public static /* synthetic */ void getProvider$annotations() {
    }

    @SerialName("send_input_fields")
    public static /* synthetic */ void getSendInputFields$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSendInputFields() {
        return this.sendInputFields;
    }

    public final Integration copy(String provider, boolean enabled, boolean sendInputFields) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        return new Integration(provider, enabled, sendInputFields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Integration)) {
            return false;
        }
        Integration integration = (Integration) other;
        return Intrinsics.areEqual(this.provider, integration.provider) && this.enabled == integration.enabled && this.sendInputFields == integration.sendInputFields;
    }

    public int hashCode() {
        return (((this.provider.hashCode() * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.sendInputFields);
    }

    public String toString() {
        return "Integration(provider=" + this.provider + ", enabled=" + this.enabled + ", sendInputFields=" + this.sendInputFields + ')';
    }

    /* JADX INFO: compiled from: Integration.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/Integration$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/Integration;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Integration> serializer() {
            return Integration$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Integration(int i, String str, boolean z, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, Integration$$serializer.INSTANCE.getDescriptor());
        }
        this.provider = str;
        this.enabled = z;
        if ((i & 4) == 0) {
            this.sendInputFields = true;
        } else {
            this.sendInputFields = z2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(Integration self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.provider);
        output.encodeBooleanElement(serialDesc, 1, self.enabled);
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.sendInputFields) {
            return;
        }
        output.encodeBooleanElement(serialDesc, 2, self.sendInputFields);
    }

    public Integration(String provider, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.provider = provider;
        this.enabled = z;
        this.sendInputFields = z2;
    }

    public /* synthetic */ Integration(String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? true : z2);
    }

    public final String getProvider() {
        return this.provider;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getSendInputFields() {
        return this.sendInputFields;
    }
}
