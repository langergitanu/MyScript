package com.survicate.surveys.entities.survey;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: EventTrigger.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBI\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J7\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001e¨\u00063"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/EventTrigger;", "", "name", "", "relation", "Lcom/survicate/surveys/entities/survey/EventTriggerRelation;", DiagnosticsEntry.PROPERTIES_KEY, "", "Lcom/survicate/surveys/entities/survey/EventTriggerProperty;", "settings", "Lcom/survicate/surveys/entities/survey/EventTriggerSettings;", "<init>", "(Ljava/lang/String;Lcom/survicate/surveys/entities/survey/EventTriggerRelation;Ljava/util/List;Lcom/survicate/surveys/entities/survey/EventTriggerSettings;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/survicate/surveys/entities/survey/EventTriggerRelation;Ljava/util/List;Lcom/survicate/surveys/entities/survey/EventTriggerSettings;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getRelation$annotations", "getRelation", "()Lcom/survicate/surveys/entities/survey/EventTriggerRelation;", "getProperties$annotations", "getProperties", "()Ljava/util/List;", "getSettings$annotations", "getSettings", "()Lcom/survicate/surveys/entities/survey/EventTriggerSettings;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class EventTrigger {
    private final String name;
    private final List<EventTriggerProperty> properties;
    private final EventTriggerRelation relation;
    private final EventTriggerSettings settings;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.EventTrigger$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventTrigger._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.EventTrigger$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventTrigger._childSerializers$_anonymous_$0();
        }
    }), null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.EventTriggerRelation", EventTriggerRelation.values(), new String[]{"and", "or"}, new Annotation[][]{null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(EventTriggerProperty$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTrigger copy$default(EventTrigger eventTrigger, String str, EventTriggerRelation eventTriggerRelation, List list, EventTriggerSettings eventTriggerSettings, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventTrigger.name;
        }
        if ((i & 2) != 0) {
            eventTriggerRelation = eventTrigger.relation;
        }
        if ((i & 4) != 0) {
            list = eventTrigger.properties;
        }
        if ((i & 8) != 0) {
            eventTriggerSettings = eventTrigger.settings;
        }
        return eventTrigger.copy(str, eventTriggerRelation, list, eventTriggerSettings);
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName(DiagnosticsEntry.PROPERTIES_KEY)
    public static /* synthetic */ void getProperties$annotations() {
    }

    @SerialName("relation")
    public static /* synthetic */ void getRelation$annotations() {
    }

    @SerialName("settings")
    public static /* synthetic */ void getSettings$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EventTriggerRelation getRelation() {
        return this.relation;
    }

    public final List<EventTriggerProperty> component3() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final EventTriggerSettings getSettings() {
        return this.settings;
    }

    public final EventTrigger copy(String name, EventTriggerRelation relation, List<EventTriggerProperty> properties, EventTriggerSettings settings) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(settings, "settings");
        return new EventTrigger(name, relation, properties, settings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTrigger)) {
            return false;
        }
        EventTrigger eventTrigger = (EventTrigger) other;
        return Intrinsics.areEqual(this.name, eventTrigger.name) && this.relation == eventTrigger.relation && Intrinsics.areEqual(this.properties, eventTrigger.properties) && Intrinsics.areEqual(this.settings, eventTrigger.settings);
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.relation.hashCode()) * 31) + this.properties.hashCode()) * 31) + this.settings.hashCode();
    }

    public String toString() {
        return "EventTrigger(name=" + this.name + ", relation=" + this.relation + ", properties=" + this.properties + ", settings=" + this.settings + ')';
    }

    /* JADX INFO: compiled from: EventTrigger.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/EventTrigger$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/EventTrigger;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<EventTrigger> serializer() {
            return EventTrigger$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ EventTrigger(int i, String str, EventTriggerRelation eventTriggerRelation, List list, EventTriggerSettings eventTriggerSettings, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, EventTrigger$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.relation = eventTriggerRelation;
        this.properties = list;
        this.settings = eventTriggerSettings;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(EventTrigger self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.relation);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.properties);
        output.encodeSerializableElement(serialDesc, 3, EventTriggerSettings$$serializer.INSTANCE, self.settings);
    }

    public EventTrigger(String name, EventTriggerRelation relation, List<EventTriggerProperty> properties, EventTriggerSettings settings) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.name = name;
        this.relation = relation;
        this.properties = properties;
        this.settings = settings;
    }

    public final String getName() {
        return this.name;
    }

    public final EventTriggerRelation getRelation() {
        return this.relation;
    }

    public final List<EventTriggerProperty> getProperties() {
        return this.properties;
    }

    public final EventTriggerSettings getSettings() {
        return this.settings;
    }
}
