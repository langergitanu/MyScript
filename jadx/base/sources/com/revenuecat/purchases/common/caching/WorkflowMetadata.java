package com.revenuecat.purchases.common.caching;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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

/* JADX INFO: compiled from: WorkflowMetadata.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006#"}, m1599d2 = {"Lcom/revenuecat/purchases/common/caching/WorkflowMetadata;", "", "seen1", "", "workflowId", "", "stepId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getStepId$annotations", "()V", "getStepId", "()Ljava/lang/String;", "getWorkflowId$annotations", "getWorkflowId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public final /* data */ class WorkflowMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String stepId;
    private final String workflowId;

    public static /* synthetic */ WorkflowMetadata copy$default(WorkflowMetadata workflowMetadata, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = workflowMetadata.workflowId;
        }
        if ((i & 2) != 0) {
            str2 = workflowMetadata.stepId;
        }
        return workflowMetadata.copy(str, str2);
    }

    @SerialName(Keys.STEP_ID)
    public static /* synthetic */ void getStepId$annotations() {
    }

    @SerialName(Keys.WORKFLOW_ID)
    public static /* synthetic */ void getWorkflowId$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getWorkflowId() {
        return this.workflowId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStepId() {
        return this.stepId;
    }

    public final WorkflowMetadata copy(String workflowId, String stepId) {
        Intrinsics.checkNotNullParameter(workflowId, "workflowId");
        Intrinsics.checkNotNullParameter(stepId, "stepId");
        return new WorkflowMetadata(workflowId, stepId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkflowMetadata)) {
            return false;
        }
        WorkflowMetadata workflowMetadata = (WorkflowMetadata) other;
        return Intrinsics.areEqual(this.workflowId, workflowMetadata.workflowId) && Intrinsics.areEqual(this.stepId, workflowMetadata.stepId);
    }

    public int hashCode() {
        return (this.workflowId.hashCode() * 31) + this.stepId.hashCode();
    }

    public String toString() {
        return "WorkflowMetadata(workflowId=" + this.workflowId + ", stepId=" + this.stepId + ')';
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ WorkflowMetadata(int i, @SerialName(Keys.WORKFLOW_ID) String str, @SerialName(Keys.STEP_ID) String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, WorkflowMetadata$$serializer.INSTANCE.getDescriptor());
        }
        this.workflowId = str;
        this.stepId = str2;
    }

    public WorkflowMetadata(String workflowId, String stepId) {
        Intrinsics.checkNotNullParameter(workflowId, "workflowId");
        Intrinsics.checkNotNullParameter(stepId, "stepId");
        this.workflowId = workflowId;
        this.stepId = stepId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(WorkflowMetadata self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.workflowId);
        output.encodeStringElement(serialDesc, 1, self.stepId);
    }

    public final String getWorkflowId() {
        return this.workflowId;
    }

    public final String getStepId() {
        return this.stepId;
    }

    /* JADX INFO: compiled from: WorkflowMetadata.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tHÆ\u0001¨\u0006\n"}, m1599d2 = {"Lcom/revenuecat/purchases/common/caching/WorkflowMetadata$Companion;", "", "()V", TypedValues.TransitionType.S_FROM, "Lcom/revenuecat/purchases/common/caching/WorkflowMetadata;", "workflowId", "", "stepId", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WorkflowMetadata> serializer() {
            return WorkflowMetadata$$serializer.INSTANCE;
        }

        public final WorkflowMetadata from(String workflowId, String stepId) {
            if (workflowId == null || stepId == null) {
                return null;
            }
            return new WorkflowMetadata(workflowId, stepId);
        }
    }
}
