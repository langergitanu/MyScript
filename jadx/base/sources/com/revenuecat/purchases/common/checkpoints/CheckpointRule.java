package com.revenuecat.purchases.common.checkpoints;

import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: CheckpointResponse.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0002$%B;\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB!\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006&"}, m1599d2 = {"Lcom/revenuecat/purchases/common/checkpoints/CheckpointRule;", "", "seen1", "", "id", "", "audienceId", "workflowId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudienceId$annotations", "()V", "getAudienceId", "()Ljava/lang/String;", "getId", "getWorkflowId$annotations", "getWorkflowId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public final /* data */ class CheckpointRule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String audienceId;
    private final String id;
    private final String workflowId;

    public static /* synthetic */ CheckpointRule copy$default(CheckpointRule checkpointRule, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkpointRule.id;
        }
        if ((i & 2) != 0) {
            str2 = checkpointRule.audienceId;
        }
        if ((i & 4) != 0) {
            str3 = checkpointRule.workflowId;
        }
        return checkpointRule.copy(str, str2, str3);
    }

    @SerialName("audience_id")
    public static /* synthetic */ void getAudienceId$annotations() {
    }

    @SerialName(Keys.WORKFLOW_ID)
    public static /* synthetic */ void getWorkflowId$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAudienceId() {
        return this.audienceId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getWorkflowId() {
        return this.workflowId;
    }

    public final CheckpointRule copy(String id, String audienceId, String workflowId) {
        Intrinsics.checkNotNullParameter(audienceId, "audienceId");
        Intrinsics.checkNotNullParameter(workflowId, "workflowId");
        return new CheckpointRule(id, audienceId, workflowId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckpointRule)) {
            return false;
        }
        CheckpointRule checkpointRule = (CheckpointRule) other;
        return Intrinsics.areEqual(this.id, checkpointRule.id) && Intrinsics.areEqual(this.audienceId, checkpointRule.audienceId) && Intrinsics.areEqual(this.workflowId, checkpointRule.workflowId);
    }

    public int hashCode() {
        String str = this.id;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.audienceId.hashCode()) * 31) + this.workflowId.hashCode();
    }

    public String toString() {
        return "CheckpointRule(id=" + this.id + ", audienceId=" + this.audienceId + ", workflowId=" + this.workflowId + ')';
    }

    /* JADX INFO: compiled from: CheckpointResponse.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/checkpoints/CheckpointRule$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/checkpoints/CheckpointRule;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CheckpointRule> serializer() {
            return CheckpointRule$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CheckpointRule(int i, String str, @SerialName("audience_id") String str2, @SerialName(Keys.WORKFLOW_ID) String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (6 != (i & 6)) {
            PluginExceptionsKt.throwMissingFieldException(i, 6, CheckpointRule$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.id = null;
        } else {
            this.id = str;
        }
        this.audienceId = str2;
        this.workflowId = str3;
    }

    public CheckpointRule(String str, String audienceId, String workflowId) {
        Intrinsics.checkNotNullParameter(audienceId, "audienceId");
        Intrinsics.checkNotNullParameter(workflowId, "workflowId");
        this.id = str;
        this.audienceId = audienceId;
        this.workflowId = workflowId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(CheckpointRule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
        }
        output.encodeStringElement(serialDesc, 1, self.audienceId);
        output.encodeStringElement(serialDesc, 2, self.workflowId);
    }

    public /* synthetic */ CheckpointRule(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, str2, str3);
    }

    public final String getId() {
        return this.id;
    }

    public final String getAudienceId() {
        return this.audienceId;
    }

    public final String getWorkflowId() {
        return this.workflowId;
    }
}
