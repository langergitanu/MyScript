package com.survicate.surveys.entities.survey.audience.attributes;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterAttribute;
import com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterStringAttribute;
import com.survicate.surveys.utils.TimestampProvider;
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
import kotlinx.serialization.internal.StringSerializer;
import org.apache.commons.codec.language.p042bm.Languages;

/* JADX INFO: compiled from: NetworkAudienceUserFilterAttributes.kt */
/* JADX INFO: loaded from: classes8.dex */
@SerialName(TypedValues.Custom.S_STRING)
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 02\u00020\u0001:\u0002/0B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018¨\u00061"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterStringAttribute;", "Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterAttribute;", "name", "", "operator", "Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterStringAttributeOperator;", "values", "", "<init>", "(Ljava/lang/String;Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterStringAttributeOperator;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterStringAttributeOperator;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getOperator$annotations", "getOperator", "()Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterStringAttributeOperator;", "getValues$annotations", "getValues", "()Ljava/util/List;", "toDomainModel", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterAttribute;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class NetworkAudienceUserFilterStringAttribute extends NetworkAudienceUserFilterAttribute {
    private final String name;
    private final AudienceUserFilterStringAttributeOperator operator;
    private final List<String> values;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.audience.attributes.NetworkAudienceUserFilterStringAttribute$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkAudienceUserFilterStringAttribute._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.audience.attributes.NetworkAudienceUserFilterStringAttribute$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkAudienceUserFilterStringAttribute._childSerializers$_anonymous_$0();
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.audience.attributes.AudienceUserFilterStringAttributeOperator", AudienceUserFilterStringAttributeOperator.values(), new String[]{"is_equal", "is_not_equal", "contains", "does_not_contain", "exists", "does_not_exist", Languages.ANY}, new Annotation[][]{null, null, null, null, null, null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkAudienceUserFilterStringAttribute copy$default(NetworkAudienceUserFilterStringAttribute networkAudienceUserFilterStringAttribute, String str, AudienceUserFilterStringAttributeOperator audienceUserFilterStringAttributeOperator, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = networkAudienceUserFilterStringAttribute.name;
        }
        if ((i & 2) != 0) {
            audienceUserFilterStringAttributeOperator = networkAudienceUserFilterStringAttribute.operator;
        }
        if ((i & 4) != 0) {
            list = networkAudienceUserFilterStringAttribute.values;
        }
        return networkAudienceUserFilterStringAttribute.copy(str, audienceUserFilterStringAttributeOperator, list);
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("operator")
    public static /* synthetic */ void getOperator$annotations() {
    }

    @SerialName("values")
    public static /* synthetic */ void getValues$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AudienceUserFilterStringAttributeOperator getOperator() {
        return this.operator;
    }

    public final List<String> component3() {
        return this.values;
    }

    public final NetworkAudienceUserFilterStringAttribute copy(String name, AudienceUserFilterStringAttributeOperator operator, List<String> values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(values, "values");
        return new NetworkAudienceUserFilterStringAttribute(name, operator, values);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkAudienceUserFilterStringAttribute)) {
            return false;
        }
        NetworkAudienceUserFilterStringAttribute networkAudienceUserFilterStringAttribute = (NetworkAudienceUserFilterStringAttribute) other;
        return Intrinsics.areEqual(this.name, networkAudienceUserFilterStringAttribute.name) && this.operator == networkAudienceUserFilterStringAttribute.operator && Intrinsics.areEqual(this.values, networkAudienceUserFilterStringAttribute.values);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.operator.hashCode()) * 31) + this.values.hashCode();
    }

    public String toString() {
        return "NetworkAudienceUserFilterStringAttribute(name=" + this.name + ", operator=" + this.operator + ", values=" + this.values + ')';
    }

    /* JADX INFO: compiled from: NetworkAudienceUserFilterAttributes.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterStringAttribute$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterStringAttribute;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NetworkAudienceUserFilterStringAttribute> serializer() {
            return NetworkAudienceUserFilterStringAttribute$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkAudienceUserFilterStringAttribute(int i, String str, AudienceUserFilterStringAttributeOperator audienceUserFilterStringAttributeOperator, List list, SerializationConstructorMarker serializationConstructorMarker) {
        super(i, serializationConstructorMarker);
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, NetworkAudienceUserFilterStringAttribute$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.operator = audienceUserFilterStringAttributeOperator;
        this.values = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(NetworkAudienceUserFilterStringAttribute self, CompositeEncoder output, SerialDescriptor serialDesc) {
        NetworkAudienceUserFilterAttribute.write$Self(self, output, serialDesc);
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.getName());
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.getOperator());
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.getValues());
    }

    @Override // com.survicate.surveys.entities.survey.audience.attributes.NetworkAudienceUserFilterAttribute
    public String getName() {
        return this.name;
    }

    @Override // com.survicate.surveys.entities.survey.audience.attributes.NetworkAudienceUserFilterAttribute
    public AudienceUserFilterStringAttributeOperator getOperator() {
        return this.operator;
    }

    @Override // com.survicate.surveys.entities.survey.audience.attributes.NetworkAudienceUserFilterAttribute
    public List<String> getValues() {
        return this.values;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkAudienceUserFilterStringAttribute(String name, AudienceUserFilterStringAttributeOperator operator, List<String> values) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(operator, "operator");
        Intrinsics.checkNotNullParameter(values, "values");
        this.name = name;
        this.operator = operator;
        this.values = values;
    }

    @Override // com.survicate.surveys.entities.survey.audience.attributes.NetworkAudienceUserFilterAttribute
    public AudienceUserFilterAttribute toDomainModel(TimestampProvider timestampProvider) {
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        return new AudienceUserFilterStringAttribute(getName(), UserFilterAttributeOperatorsKt.toCoreOperator(getOperator()), getValues());
    }
}
