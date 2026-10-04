package com.revenuecat.purchases.common.workflows.events;

import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.utils.serializers.DateSerializer;
import com.revenuecat.purchases.utils.serializers.UUIDSerializer;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: WorkflowEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001f2\u00020\u0001:\u0005\u001e\u001f !\"B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0007J!\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dHÇ\u0001R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0012\u0010\u0015\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012\u0082\u0001\u0003#$%¨\u0006&"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent;", "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "seen1", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "creationData", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;", "getCreationData", "()Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;", "isPriorityEvent", "", "()Z", "stepId", "", "getStepId", "()Ljava/lang/String;", "traceId", "getTraceId", "workflowId", "getWorkflowId", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", HTTP.CONN_CLOSE, "Companion", "CreationData", "StepCompleted", "StepStarted", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$Close;", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$StepCompleted;", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$StepStarted;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public abstract class WorkflowEvent implements FeatureEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.common.workflows.events.WorkflowEvent.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("com.revenuecat.purchases.common.workflows.events.WorkflowEvent", Reflection.getOrCreateKotlinClass(WorkflowEvent.class), new KClass[]{Reflection.getOrCreateKotlinClass(Close.class), Reflection.getOrCreateKotlinClass(StepCompleted.class), Reflection.getOrCreateKotlinClass(StepStarted.class)}, new KSerializer[]{WorkflowEvent$Close$$serializer.INSTANCE, WorkflowEvent$StepCompleted$$serializer.INSTANCE, WorkflowEvent$StepStarted$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    public /* synthetic */ WorkflowEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(WorkflowEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }

    public abstract CreationData getCreationData();

    public abstract String getStepId();

    public abstract String getTraceId();

    public abstract String getWorkflowId();

    @Override // com.revenuecat.purchases.common.events.FeatureEvent
    public boolean isPriorityEvent() {
        return false;
    }

    /* JADX INFO: compiled from: WorkflowEvent.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) WorkflowEvent.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<WorkflowEvent> serializer() {
            return get$cachedSerializer();
        }
    }

    private WorkflowEvent() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ WorkflowEvent(int i, SerializationConstructorMarker serializationConstructorMarker) {
    }

    /* JADX INFO: compiled from: WorkflowEvent.kt */
    @Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;", "", "seen1", "", "id", "Ljava/util/UUID;", QuestionSurveyAnswerType.DATE, "Ljava/util/Date;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/UUID;Ljava/util/Date;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/UUID;Ljava/util/Date;)V", "getDate$annotations", "()V", "getDate", "()Ljava/util/Date;", "getId$annotations", "getId", "()Ljava/util/UUID;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    public static final /* data */ class CreationData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Date date;
        private final UUID id;

        public static /* synthetic */ CreationData copy$default(CreationData creationData, UUID uuid, Date date, int i, Object obj) {
            if ((i & 1) != 0) {
                uuid = creationData.id;
            }
            if ((i & 2) != 0) {
                date = creationData.date;
            }
            return creationData.copy(uuid, date);
        }

        @Serializable(with = DateSerializer.class)
        public static /* synthetic */ void getDate$annotations() {
        }

        @Serializable(with = UUIDSerializer.class)
        public static /* synthetic */ void getId$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final UUID getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Date getDate() {
            return this.date;
        }

        public final CreationData copy(UUID id, Date date) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(date, "date");
            return new CreationData(id, date);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreationData)) {
                return false;
            }
            CreationData creationData = (CreationData) other;
            return Intrinsics.areEqual(this.id, creationData.id) && Intrinsics.areEqual(this.date, creationData.date);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.date.hashCode();
        }

        public String toString() {
            return "CreationData(id=" + this.id + ", date=" + this.date + ')';
        }

        /* JADX INFO: compiled from: WorkflowEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CreationData> serializer() {
                return WorkflowEvent$CreationData$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CreationData(int i, @Serializable(with = UUIDSerializer.class) UUID uuid, @Serializable(with = DateSerializer.class) Date date, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, WorkflowEvent$CreationData$$serializer.INSTANCE.getDescriptor());
            }
            this.id = uuid;
            this.date = date;
        }

        public CreationData(UUID id, Date date) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(date, "date");
            this.id = id;
            this.date = date;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(CreationData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, UUIDSerializer.INSTANCE, self.id);
            output.encodeSerializableElement(serialDesc, 1, DateSerializer.INSTANCE, self.date);
        }

        public final UUID getId() {
            return this.id;
        }

        public final Date getDate() {
            return this.date;
        }
    }

    /* JADX INFO: compiled from: WorkflowEvent.kt */
    @Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245Bi\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BU\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0012J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0018Jf\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0007HÖ\u0001J&\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202HÁ\u0001¢\u0006\u0002\b3R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\f\u0010\u0018R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u000e\u0010\u0018R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\t\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016¨\u00066"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$StepStarted;", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent;", "seen1", "", "creationData", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;", "workflowId", "", "stepId", "traceId", "fromStepId", "entryReason", "isFirstStep", "", "isLastStep", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCreationData", "()Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;", "getEntryReason", "()Ljava/lang/String;", "getFromStepId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStepId", "getTraceId", "getWorkflowId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$StepStarted;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    @SerialName("workflow_step_started")
    public static final /* data */ class StepStarted extends WorkflowEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CreationData creationData;
        private final String entryReason;
        private final String fromStepId;
        private final Boolean isFirstStep;
        private final Boolean isLastStep;
        private final String stepId;
        private final String traceId;
        private final String workflowId;

        public static /* synthetic */ StepStarted copy$default(StepStarted stepStarted, CreationData creationData, String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                creationData = stepStarted.creationData;
            }
            if ((i & 2) != 0) {
                str = stepStarted.workflowId;
            }
            if ((i & 4) != 0) {
                str2 = stepStarted.stepId;
            }
            if ((i & 8) != 0) {
                str3 = stepStarted.traceId;
            }
            if ((i & 16) != 0) {
                str4 = stepStarted.fromStepId;
            }
            if ((i & 32) != 0) {
                str5 = stepStarted.entryReason;
            }
            if ((i & 64) != 0) {
                bool = stepStarted.isFirstStep;
            }
            if ((i & 128) != 0) {
                bool2 = stepStarted.isLastStep;
            }
            Boolean bool3 = bool;
            Boolean bool4 = bool2;
            String str6 = str4;
            String str7 = str5;
            return stepStarted.copy(creationData, str, str2, str3, str6, str7, bool3, bool4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CreationData getCreationData() {
            return this.creationData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getWorkflowId() {
            return this.workflowId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getStepId() {
            return this.stepId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getFromStepId() {
            return this.fromStepId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getEntryReason() {
            return this.entryReason;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getIsFirstStep() {
            return this.isFirstStep;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getIsLastStep() {
            return this.isLastStep;
        }

        public final StepStarted copy(CreationData creationData, String workflowId, String stepId, String traceId, String fromStepId, String entryReason, Boolean isFirstStep, Boolean isLastStep) {
            Intrinsics.checkNotNullParameter(creationData, "creationData");
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            Intrinsics.checkNotNullParameter(stepId, "stepId");
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            return new StepStarted(creationData, workflowId, stepId, traceId, fromStepId, entryReason, isFirstStep, isLastStep);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StepStarted)) {
                return false;
            }
            StepStarted stepStarted = (StepStarted) other;
            return Intrinsics.areEqual(this.creationData, stepStarted.creationData) && Intrinsics.areEqual(this.workflowId, stepStarted.workflowId) && Intrinsics.areEqual(this.stepId, stepStarted.stepId) && Intrinsics.areEqual(this.traceId, stepStarted.traceId) && Intrinsics.areEqual(this.fromStepId, stepStarted.fromStepId) && Intrinsics.areEqual(this.entryReason, stepStarted.entryReason) && Intrinsics.areEqual(this.isFirstStep, stepStarted.isFirstStep) && Intrinsics.areEqual(this.isLastStep, stepStarted.isLastStep);
        }

        public int hashCode() {
            int iHashCode = ((((((this.creationData.hashCode() * 31) + this.workflowId.hashCode()) * 31) + this.stepId.hashCode()) * 31) + this.traceId.hashCode()) * 31;
            String str = this.fromStepId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.entryReason;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.isFirstStep;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isLastStep;
            return iHashCode4 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "StepStarted(creationData=" + this.creationData + ", workflowId=" + this.workflowId + ", stepId=" + this.stepId + ", traceId=" + this.traceId + ", fromStepId=" + this.fromStepId + ", entryReason=" + this.entryReason + ", isFirstStep=" + this.isFirstStep + ", isLastStep=" + this.isLastStep + ')';
        }

        /* JADX INFO: compiled from: WorkflowEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$StepStarted$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$StepStarted;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<StepStarted> serializer() {
                return WorkflowEvent$StepStarted$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ StepStarted(int i, CreationData creationData, String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, WorkflowEvent$StepStarted$$serializer.INSTANCE.getDescriptor());
            }
            this.creationData = creationData;
            this.workflowId = str;
            this.stepId = str2;
            this.traceId = str3;
            if ((i & 16) == 0) {
                this.fromStepId = null;
            } else {
                this.fromStepId = str4;
            }
            if ((i & 32) == 0) {
                this.entryReason = null;
            } else {
                this.entryReason = str5;
            }
            if ((i & 64) == 0) {
                this.isFirstStep = null;
            } else {
                this.isFirstStep = bool;
            }
            if ((i & 128) == 0) {
                this.isLastStep = null;
            } else {
                this.isLastStep = bool2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(StepStarted self, CompositeEncoder output, SerialDescriptor serialDesc) {
            WorkflowEvent.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, WorkflowEvent$CreationData$$serializer.INSTANCE, self.getCreationData());
            output.encodeStringElement(serialDesc, 1, self.getWorkflowId());
            output.encodeStringElement(serialDesc, 2, self.getStepId());
            output.encodeStringElement(serialDesc, 3, self.getTraceId());
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.fromStepId != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.fromStepId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.entryReason != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.entryReason);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.isFirstStep != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.isFirstStep);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.isLastStep == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.isLastStep);
        }

        public /* synthetic */ StepStarted(CreationData creationData, String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(creationData, str, str2, str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : bool2);
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public CreationData getCreationData() {
            return this.creationData;
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public String getWorkflowId() {
            return this.workflowId;
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public String getStepId() {
            return this.stepId;
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public String getTraceId() {
            return this.traceId;
        }

        public final String getFromStepId() {
            return this.fromStepId;
        }

        public final String getEntryReason() {
            return this.entryReason;
        }

        public final Boolean isFirstStep() {
            return this.isFirstStep;
        }

        public final Boolean isLastStep() {
            return this.isLastStep;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StepStarted(CreationData creationData, String workflowId, String stepId, String traceId, String str, String str2, Boolean bool, Boolean bool2) {
            super(null);
            Intrinsics.checkNotNullParameter(creationData, "creationData");
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            Intrinsics.checkNotNullParameter(stepId, "stepId");
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            this.creationData = creationData;
            this.workflowId = workflowId;
            this.stepId = stepId;
            this.traceId = traceId;
            this.fromStepId = str;
            this.entryReason = str2;
            this.isFirstStep = bool;
            this.isLastStep = bool2;
        }
    }

    /* JADX INFO: compiled from: WorkflowEvent.kt */
    @Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B_\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010BI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0011J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0014JZ\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001J&\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/HÁ\u0001¢\u0006\u0002\b0R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u000b\u0010\u0014R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\r\u0010\u0014R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0014\u0010\t\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017¨\u00063"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$StepCompleted;", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent;", "seen1", "", "creationData", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;", "workflowId", "", "stepId", "traceId", "toStepId", "isFirstStep", "", "isLastStep", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCreationData", "()Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStepId", "()Ljava/lang/String;", "getToStepId", "getTraceId", "getWorkflowId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$StepCompleted;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    @SerialName("workflow_step_completed")
    public static final /* data */ class StepCompleted extends WorkflowEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CreationData creationData;
        private final Boolean isFirstStep;
        private final Boolean isLastStep;
        private final String stepId;
        private final String toStepId;
        private final String traceId;
        private final String workflowId;

        public static /* synthetic */ StepCompleted copy$default(StepCompleted stepCompleted, CreationData creationData, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                creationData = stepCompleted.creationData;
            }
            if ((i & 2) != 0) {
                str = stepCompleted.workflowId;
            }
            if ((i & 4) != 0) {
                str2 = stepCompleted.stepId;
            }
            if ((i & 8) != 0) {
                str3 = stepCompleted.traceId;
            }
            if ((i & 16) != 0) {
                str4 = stepCompleted.toStepId;
            }
            if ((i & 32) != 0) {
                bool = stepCompleted.isFirstStep;
            }
            if ((i & 64) != 0) {
                bool2 = stepCompleted.isLastStep;
            }
            Boolean bool3 = bool;
            Boolean bool4 = bool2;
            String str5 = str4;
            String str6 = str2;
            return stepCompleted.copy(creationData, str, str6, str3, str5, bool3, bool4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CreationData getCreationData() {
            return this.creationData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getWorkflowId() {
            return this.workflowId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getStepId() {
            return this.stepId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getToStepId() {
            return this.toStepId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getIsFirstStep() {
            return this.isFirstStep;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getIsLastStep() {
            return this.isLastStep;
        }

        public final StepCompleted copy(CreationData creationData, String workflowId, String stepId, String traceId, String toStepId, Boolean isFirstStep, Boolean isLastStep) {
            Intrinsics.checkNotNullParameter(creationData, "creationData");
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            Intrinsics.checkNotNullParameter(stepId, "stepId");
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            return new StepCompleted(creationData, workflowId, stepId, traceId, toStepId, isFirstStep, isLastStep);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StepCompleted)) {
                return false;
            }
            StepCompleted stepCompleted = (StepCompleted) other;
            return Intrinsics.areEqual(this.creationData, stepCompleted.creationData) && Intrinsics.areEqual(this.workflowId, stepCompleted.workflowId) && Intrinsics.areEqual(this.stepId, stepCompleted.stepId) && Intrinsics.areEqual(this.traceId, stepCompleted.traceId) && Intrinsics.areEqual(this.toStepId, stepCompleted.toStepId) && Intrinsics.areEqual(this.isFirstStep, stepCompleted.isFirstStep) && Intrinsics.areEqual(this.isLastStep, stepCompleted.isLastStep);
        }

        public int hashCode() {
            int iHashCode = ((((((this.creationData.hashCode() * 31) + this.workflowId.hashCode()) * 31) + this.stepId.hashCode()) * 31) + this.traceId.hashCode()) * 31;
            String str = this.toStepId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.isFirstStep;
            int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isLastStep;
            return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "StepCompleted(creationData=" + this.creationData + ", workflowId=" + this.workflowId + ", stepId=" + this.stepId + ", traceId=" + this.traceId + ", toStepId=" + this.toStepId + ", isFirstStep=" + this.isFirstStep + ", isLastStep=" + this.isLastStep + ')';
        }

        /* JADX INFO: compiled from: WorkflowEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$StepCompleted$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$StepCompleted;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<StepCompleted> serializer() {
                return WorkflowEvent$StepCompleted$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ StepCompleted(int i, CreationData creationData, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, WorkflowEvent$StepCompleted$$serializer.INSTANCE.getDescriptor());
            }
            this.creationData = creationData;
            this.workflowId = str;
            this.stepId = str2;
            this.traceId = str3;
            if ((i & 16) == 0) {
                this.toStepId = null;
            } else {
                this.toStepId = str4;
            }
            if ((i & 32) == 0) {
                this.isFirstStep = null;
            } else {
                this.isFirstStep = bool;
            }
            if ((i & 64) == 0) {
                this.isLastStep = null;
            } else {
                this.isLastStep = bool2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(StepCompleted self, CompositeEncoder output, SerialDescriptor serialDesc) {
            WorkflowEvent.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, WorkflowEvent$CreationData$$serializer.INSTANCE, self.getCreationData());
            output.encodeStringElement(serialDesc, 1, self.getWorkflowId());
            output.encodeStringElement(serialDesc, 2, self.getStepId());
            output.encodeStringElement(serialDesc, 3, self.getTraceId());
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.toStepId != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.toStepId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.isFirstStep != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.isFirstStep);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.isLastStep == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.isLastStep);
        }

        public /* synthetic */ StepCompleted(CreationData creationData, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(creationData, str, str2, str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : bool2);
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public CreationData getCreationData() {
            return this.creationData;
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public String getWorkflowId() {
            return this.workflowId;
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public String getStepId() {
            return this.stepId;
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public String getTraceId() {
            return this.traceId;
        }

        public final String getToStepId() {
            return this.toStepId;
        }

        public final Boolean isFirstStep() {
            return this.isFirstStep;
        }

        public final Boolean isLastStep() {
            return this.isLastStep;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StepCompleted(CreationData creationData, String workflowId, String stepId, String traceId, String str, Boolean bool, Boolean bool2) {
            super(null);
            Intrinsics.checkNotNullParameter(creationData, "creationData");
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            Intrinsics.checkNotNullParameter(stepId, "stepId");
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            this.creationData = creationData;
            this.workflowId = workflowId;
            this.stepId = stepId;
            this.traceId = traceId;
            this.toStepId = str;
            this.isFirstStep = bool;
            this.isLastStep = bool2;
        }
    }

    /* JADX INFO: compiled from: WorkflowEvent.kt */
    @Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0013JN\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001J&\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,HÁ\u0001¢\u0006\u0002\b-R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\n\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\f\u0010\u0013R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\t\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016¨\u00060"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$Close;", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent;", "seen1", "", "creationData", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;", "workflowId", "", "stepId", "traceId", "isFirstStep", "", "isLastStep", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCreationData", "()Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStepId", "()Ljava/lang/String;", "getTraceId", "getWorkflowId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$CreationData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$Close;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @Serializable
    @SerialName("workflow_close")
    public static final /* data */ class Close extends WorkflowEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CreationData creationData;
        private final Boolean isFirstStep;
        private final Boolean isLastStep;
        private final String stepId;
        private final String traceId;
        private final String workflowId;

        public static /* synthetic */ Close copy$default(Close close, CreationData creationData, String str, String str2, String str3, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                creationData = close.creationData;
            }
            if ((i & 2) != 0) {
                str = close.workflowId;
            }
            if ((i & 4) != 0) {
                str2 = close.stepId;
            }
            if ((i & 8) != 0) {
                str3 = close.traceId;
            }
            if ((i & 16) != 0) {
                bool = close.isFirstStep;
            }
            if ((i & 32) != 0) {
                bool2 = close.isLastStep;
            }
            Boolean bool3 = bool;
            Boolean bool4 = bool2;
            return close.copy(creationData, str, str2, str3, bool3, bool4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CreationData getCreationData() {
            return this.creationData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getWorkflowId() {
            return this.workflowId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getStepId() {
            return this.stepId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getIsFirstStep() {
            return this.isFirstStep;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getIsLastStep() {
            return this.isLastStep;
        }

        public final Close copy(CreationData creationData, String workflowId, String stepId, String traceId, Boolean isFirstStep, Boolean isLastStep) {
            Intrinsics.checkNotNullParameter(creationData, "creationData");
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            Intrinsics.checkNotNullParameter(stepId, "stepId");
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            return new Close(creationData, workflowId, stepId, traceId, isFirstStep, isLastStep);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Close)) {
                return false;
            }
            Close close = (Close) other;
            return Intrinsics.areEqual(this.creationData, close.creationData) && Intrinsics.areEqual(this.workflowId, close.workflowId) && Intrinsics.areEqual(this.stepId, close.stepId) && Intrinsics.areEqual(this.traceId, close.traceId) && Intrinsics.areEqual(this.isFirstStep, close.isFirstStep) && Intrinsics.areEqual(this.isLastStep, close.isLastStep);
        }

        public int hashCode() {
            int iHashCode = ((((((this.creationData.hashCode() * 31) + this.workflowId.hashCode()) * 31) + this.stepId.hashCode()) * 31) + this.traceId.hashCode()) * 31;
            Boolean bool = this.isFirstStep;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isLastStep;
            return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "Close(creationData=" + this.creationData + ", workflowId=" + this.workflowId + ", stepId=" + this.stepId + ", traceId=" + this.traceId + ", isFirstStep=" + this.isFirstStep + ", isLastStep=" + this.isLastStep + ')';
        }

        /* JADX INFO: compiled from: WorkflowEvent.kt */
        @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$Close$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/events/WorkflowEvent$Close;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Close> serializer() {
                return WorkflowEvent$Close$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Close(int i, CreationData creationData, String str, String str2, String str3, Boolean bool, Boolean bool2, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, WorkflowEvent$Close$$serializer.INSTANCE.getDescriptor());
            }
            this.creationData = creationData;
            this.workflowId = str;
            this.stepId = str2;
            this.traceId = str3;
            if ((i & 16) == 0) {
                this.isFirstStep = null;
            } else {
                this.isFirstStep = bool;
            }
            if ((i & 32) == 0) {
                this.isLastStep = null;
            } else {
                this.isLastStep = bool2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsRelease(Close self, CompositeEncoder output, SerialDescriptor serialDesc) {
            WorkflowEvent.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, WorkflowEvent$CreationData$$serializer.INSTANCE, self.getCreationData());
            output.encodeStringElement(serialDesc, 1, self.getWorkflowId());
            output.encodeStringElement(serialDesc, 2, self.getStepId());
            output.encodeStringElement(serialDesc, 3, self.getTraceId());
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isFirstStep != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.isFirstStep);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.isLastStep == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.isLastStep);
        }

        public /* synthetic */ Close(CreationData creationData, String str, String str2, String str3, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(creationData, str, str2, str3, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2);
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public CreationData getCreationData() {
            return this.creationData;
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public String getWorkflowId() {
            return this.workflowId;
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public String getStepId() {
            return this.stepId;
        }

        @Override // com.revenuecat.purchases.common.workflows.events.WorkflowEvent
        public String getTraceId() {
            return this.traceId;
        }

        public final Boolean isFirstStep() {
            return this.isFirstStep;
        }

        public final Boolean isLastStep() {
            return this.isLastStep;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Close(CreationData creationData, String workflowId, String stepId, String traceId, Boolean bool, Boolean bool2) {
            super(null);
            Intrinsics.checkNotNullParameter(creationData, "creationData");
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            Intrinsics.checkNotNullParameter(stepId, "stepId");
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            this.creationData = creationData;
            this.workflowId = workflowId;
            this.stepId = stepId;
            this.traceId = traceId;
            this.isFirstStep = bool;
            this.isLastStep = bool2;
        }
    }
}
