package com.survicate.surveys.entities.survey.audience;

import com.survicate.surveys.entities.survey.audience.attributes.NetworkAudienceUserFilterAttribute;
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

/* JADX INFO: compiled from: NetworkAudienceFilters.kt */
/* JADX INFO: loaded from: classes8.dex */
@SerialName("user_attributes")
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J-\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceUserFilter;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceFilter;", "exclude", "", "values", "", "Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterAttribute;", "relation", "Lcom/survicate/surveys/entities/survey/audience/AudienceRelation;", "<init>", "(ZLjava/util/List;Lcom/survicate/surveys/entities/survey/audience/AudienceRelation;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/util/List;Lcom/survicate/surveys/entities/survey/audience/AudienceRelation;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getExclude$annotations", "()V", "getExclude", "()Z", "getValues$annotations", "getValues", "()Ljava/util/List;", "getRelation$annotations", "getRelation", "()Lcom/survicate/surveys/entities/survey/audience/AudienceRelation;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class NetworkAudienceUserFilter extends NetworkAudienceFilter {
    private final boolean exclude;
    private final AudienceRelation relation;
    private final List<NetworkAudienceUserFilterAttribute> values;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.audience.NetworkAudienceUserFilter$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkAudienceUserFilter._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.audience.NetworkAudienceUserFilter$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkAudienceUserFilter._childSerializers$_anonymous_$0();
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(NetworkAudienceUserFilterAttribute.INSTANCE.serializer());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.audience.AudienceRelation", AudienceRelation.values(), new String[]{"and", "or"}, new Annotation[][]{null, null}, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkAudienceUserFilter copy$default(NetworkAudienceUserFilter networkAudienceUserFilter, boolean z, List list, AudienceRelation audienceRelation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = networkAudienceUserFilter.exclude;
        }
        if ((i & 2) != 0) {
            list = networkAudienceUserFilter.values;
        }
        if ((i & 4) != 0) {
            audienceRelation = networkAudienceUserFilter.relation;
        }
        return networkAudienceUserFilter.copy(z, list, audienceRelation);
    }

    @SerialName("exclude")
    public static /* synthetic */ void getExclude$annotations() {
    }

    @SerialName("relation")
    public static /* synthetic */ void getRelation$annotations() {
    }

    @SerialName("attributes")
    public static /* synthetic */ void getValues$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getExclude() {
        return this.exclude;
    }

    public final List<NetworkAudienceUserFilterAttribute> component2() {
        return this.values;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AudienceRelation getRelation() {
        return this.relation;
    }

    public final NetworkAudienceUserFilter copy(boolean exclude, List<? extends NetworkAudienceUserFilterAttribute> values, AudienceRelation relation) {
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(relation, "relation");
        return new NetworkAudienceUserFilter(exclude, values, relation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkAudienceUserFilter)) {
            return false;
        }
        NetworkAudienceUserFilter networkAudienceUserFilter = (NetworkAudienceUserFilter) other;
        return this.exclude == networkAudienceUserFilter.exclude && Intrinsics.areEqual(this.values, networkAudienceUserFilter.values) && this.relation == networkAudienceUserFilter.relation;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.exclude) * 31) + this.values.hashCode()) * 31) + this.relation.hashCode();
    }

    public String toString() {
        return "NetworkAudienceUserFilter(exclude=" + this.exclude + ", values=" + this.values + ", relation=" + this.relation + ')';
    }

    /* JADX INFO: compiled from: NetworkAudienceFilters.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceUserFilter$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceUserFilter;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NetworkAudienceUserFilter> serializer() {
            return NetworkAudienceUserFilter$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkAudienceUserFilter(int i, boolean z, List list, AudienceRelation audienceRelation, SerializationConstructorMarker serializationConstructorMarker) {
        super(i, serializationConstructorMarker);
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, NetworkAudienceUserFilter$$serializer.INSTANCE.getDescriptor());
        }
        this.exclude = z;
        this.values = list;
        this.relation = audienceRelation;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(NetworkAudienceUserFilter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        NetworkAudienceFilter.write$Self(self, output, serialDesc);
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeBooleanElement(serialDesc, 0, self.getExclude());
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.getValues());
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.relation);
    }

    @Override // com.survicate.surveys.entities.survey.audience.NetworkAudienceFilter
    public boolean getExclude() {
        return this.exclude;
    }

    @Override // com.survicate.surveys.entities.survey.audience.NetworkAudienceFilter
    public List<NetworkAudienceUserFilterAttribute> getValues() {
        return this.values;
    }

    public final AudienceRelation getRelation() {
        return this.relation;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NetworkAudienceUserFilter(boolean z, List<? extends NetworkAudienceUserFilterAttribute> values, AudienceRelation relation) {
        super(null);
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(relation, "relation");
        this.exclude = z;
        this.values = values;
        this.relation = relation;
    }
}
