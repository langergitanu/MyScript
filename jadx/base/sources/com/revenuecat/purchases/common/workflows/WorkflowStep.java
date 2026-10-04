package com.revenuecat.purchases.common.workflows;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: WorkflowModels.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002?@B\u0099\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0001\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014B\u007f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u0015\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0015\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0087\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001J&\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=HÁ\u0001¢\u0006\u0002\b>R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR(\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0017R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$R(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006A"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowStep;", "", "seen1", "", "id", "", "type", "screenId", "paramValues", "", "Lkotlinx/serialization/json/JsonElement;", "triggers", "", "Lcom/revenuecat/purchases/common/workflows/WorkflowTrigger;", "outputs", "triggerActions", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction;", TtmlNode.TAG_METADATA, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/json/JsonElement;)V", "getId", "()Ljava/lang/String;", "getMetadata", "()Lkotlinx/serialization/json/JsonElement;", "getOutputs", "()Ljava/util/Map;", "getParamValues$annotations", "()V", "getParamValues", "getScreenId$annotations", "getScreenId", "stepScreenType", "getStepScreenType$annotations", "getStepScreenType", "()Ljava/util/List;", "getTriggerActions$annotations", "getTriggerActions", "getTriggers", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsRelease", "$serializer", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Serializable
public final /* data */ class WorkflowStep {
    private final String id;
    private final JsonElement metadata;
    private final Map<String, JsonElement> outputs;
    private final Map<String, JsonElement> paramValues;
    private final String screenId;
    private final Map<String, WorkflowTriggerAction> triggerActions;
    private final List<WorkflowTrigger> triggers;
    private final String type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, JsonElementSerializer.INSTANCE), new ArrayListSerializer(WorkflowTrigger$$serializer.INSTANCE), new LinkedHashMapSerializer(StringSerializer.INSTANCE, JsonElementSerializer.INSTANCE), new LinkedHashMapSerializer(StringSerializer.INSTANCE, WorkflowTriggerActionSerializer.INSTANCE), null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkflowStep copy$default(WorkflowStep workflowStep, String str, String str2, String str3, Map map, List list, Map map2, Map map3, JsonElement jsonElement, int i, Object obj) {
        if ((i & 1) != 0) {
            str = workflowStep.id;
        }
        if ((i & 2) != 0) {
            str2 = workflowStep.type;
        }
        if ((i & 4) != 0) {
            str3 = workflowStep.screenId;
        }
        if ((i & 8) != 0) {
            map = workflowStep.paramValues;
        }
        if ((i & 16) != 0) {
            list = workflowStep.triggers;
        }
        if ((i & 32) != 0) {
            map2 = workflowStep.outputs;
        }
        if ((i & 64) != 0) {
            map3 = workflowStep.triggerActions;
        }
        if ((i & 128) != 0) {
            jsonElement = workflowStep.metadata;
        }
        Map map4 = map3;
        JsonElement jsonElement2 = jsonElement;
        List list2 = list;
        Map map5 = map2;
        return workflowStep.copy(str, str2, str3, map, list2, map5, map4, jsonElement2);
    }

    @SerialName("param_values")
    public static /* synthetic */ void getParamValues$annotations() {
    }

    @SerialName("screen_id")
    public static /* synthetic */ void getScreenId$annotations() {
    }

    public static /* synthetic */ void getStepScreenType$annotations() {
    }

    @SerialName("trigger_actions")
    public static /* synthetic */ void getTriggerActions$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getScreenId() {
        return this.screenId;
    }

    public final Map<String, JsonElement> component4() {
        return this.paramValues;
    }

    public final List<WorkflowTrigger> component5() {
        return this.triggers;
    }

    public final Map<String, JsonElement> component6() {
        return this.outputs;
    }

    public final Map<String, WorkflowTriggerAction> component7() {
        return this.triggerActions;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final JsonElement getMetadata() {
        return this.metadata;
    }

    public final WorkflowStep copy(String id, String type, String screenId, Map<String, ? extends JsonElement> paramValues, List<WorkflowTrigger> triggers, Map<String, ? extends JsonElement> outputs, Map<String, ? extends WorkflowTriggerAction> triggerActions, JsonElement metadata) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(paramValues, "paramValues");
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(triggerActions, "triggerActions");
        return new WorkflowStep(id, type, screenId, paramValues, triggers, outputs, triggerActions, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkflowStep)) {
            return false;
        }
        WorkflowStep workflowStep = (WorkflowStep) other;
        return Intrinsics.areEqual(this.id, workflowStep.id) && Intrinsics.areEqual(this.type, workflowStep.type) && Intrinsics.areEqual(this.screenId, workflowStep.screenId) && Intrinsics.areEqual(this.paramValues, workflowStep.paramValues) && Intrinsics.areEqual(this.triggers, workflowStep.triggers) && Intrinsics.areEqual(this.outputs, workflowStep.outputs) && Intrinsics.areEqual(this.triggerActions, workflowStep.triggerActions) && Intrinsics.areEqual(this.metadata, workflowStep.metadata);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.screenId;
        int iHashCode2 = (((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.paramValues.hashCode()) * 31) + this.triggers.hashCode()) * 31) + this.outputs.hashCode()) * 31) + this.triggerActions.hashCode()) * 31;
        JsonElement jsonElement = this.metadata;
        return iHashCode2 + (jsonElement != null ? jsonElement.hashCode() : 0);
    }

    public String toString() {
        return "WorkflowStep(id=" + this.id + ", type=" + this.type + ", screenId=" + this.screenId + ", paramValues=" + this.paramValues + ", triggers=" + this.triggers + ", outputs=" + this.outputs + ", triggerActions=" + this.triggerActions + ", metadata=" + this.metadata + ')';
    }

    /* JADX INFO: compiled from: WorkflowModels.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowStep$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/WorkflowStep;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WorkflowStep> serializer() {
            return WorkflowStep$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ WorkflowStep(int i, String str, String str2, @SerialName("screen_id") String str3, @SerialName("param_values") Map map, List list, Map map2, @SerialName("trigger_actions") Map map3, JsonElement jsonElement, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, WorkflowStep$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.type = str2;
        if ((i & 4) == 0) {
            this.screenId = null;
        } else {
            this.screenId = str3;
        }
        if ((i & 8) == 0) {
            this.paramValues = MapsKt.emptyMap();
        } else {
            this.paramValues = map;
        }
        if ((i & 16) == 0) {
            this.triggers = CollectionsKt.emptyList();
        } else {
            this.triggers = list;
        }
        if ((i & 32) == 0) {
            this.outputs = MapsKt.emptyMap();
        } else {
            this.outputs = map2;
        }
        if ((i & 64) == 0) {
            this.triggerActions = MapsKt.emptyMap();
        } else {
            this.triggerActions = map3;
        }
        if ((i & 128) == 0) {
            this.metadata = null;
        } else {
            this.metadata = jsonElement;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkflowStep(String id, String type, String str, Map<String, ? extends JsonElement> paramValues, List<WorkflowTrigger> triggers, Map<String, ? extends JsonElement> outputs, Map<String, ? extends WorkflowTriggerAction> triggerActions, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(paramValues, "paramValues");
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        Intrinsics.checkNotNullParameter(outputs, "outputs");
        Intrinsics.checkNotNullParameter(triggerActions, "triggerActions");
        this.id = id;
        this.type = type;
        this.screenId = str;
        this.paramValues = paramValues;
        this.triggers = triggers;
        this.outputs = outputs;
        this.triggerActions = triggerActions;
        this.metadata = jsonElement;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(WorkflowStep self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.type);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.screenId != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.screenId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.paramValues, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.paramValues);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.triggers, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.triggers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.outputs, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.outputs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.triggerActions, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 6, kSerializerArr[6], self.triggerActions);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.metadata == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, JsonElementSerializer.INSTANCE, self.metadata);
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getScreenId() {
        return this.screenId;
    }

    public /* synthetic */ WorkflowStep(String str, String str2, String str3, Map map, List list, Map map2, Map map3, JsonElement jsonElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? MapsKt.emptyMap() : map, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? MapsKt.emptyMap() : map2, (i & 64) != 0 ? MapsKt.emptyMap() : map3, (i & 128) != 0 ? null : jsonElement);
    }

    public final Map<String, JsonElement> getParamValues() {
        return this.paramValues;
    }

    public final List<WorkflowTrigger> getTriggers() {
        return this.triggers;
    }

    public final Map<String, JsonElement> getOutputs() {
        return this.outputs;
    }

    public final Map<String, WorkflowTriggerAction> getTriggerActions() {
        return this.triggerActions;
    }

    public final JsonElement getMetadata() {
        return this.metadata;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<String> getStepScreenType() {
        String content;
        JsonElement jsonElement = this.metadata;
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        if (jsonObject == null) {
            return null;
        }
        Object obj = jsonObject.get((Object) "screen_type");
        JsonArray jsonArray = obj instanceof JsonArray ? (JsonArray) obj : null;
        if (jsonArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (JsonElement jsonElement2 : jsonArray) {
            JsonPrimitive jsonPrimitive = jsonElement2 instanceof JsonPrimitive ? (JsonPrimitive) jsonElement2 : null;
            if (jsonPrimitive == null) {
                content = null;
            } else {
                if (!jsonPrimitive.getIsString()) {
                    jsonPrimitive = null;
                }
                if (jsonPrimitive != null) {
                    content = jsonPrimitive.getContent();
                }
            }
            if (content != null) {
                arrayList.add(content);
            }
        }
        return arrayList;
    }
}
