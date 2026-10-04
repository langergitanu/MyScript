package com.survicate.surveys.entities.survey.audience;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: NetworkAudience.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBQ\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010#JH\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0010HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010 R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010#¨\u0006;"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/NetworkAudience;", "", "id", "", "relation", "Lcom/survicate/surveys/entities/survey/audience/AudienceRelation;", "filters", "", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceFilter;", "visitorType", "Lcom/survicate/surveys/entities/survey/audience/AudienceVisitorType;", "hasBackendFilters", "", "<init>", "(JLcom/survicate/surveys/entities/survey/audience/AudienceRelation;Ljava/util/List;Lcom/survicate/surveys/entities/survey/audience/AudienceVisitorType;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLcom/survicate/surveys/entities/survey/audience/AudienceRelation;Ljava/util/List;Lcom/survicate/surveys/entities/survey/audience/AudienceVisitorType;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "getRelation$annotations", "getRelation", "()Lcom/survicate/surveys/entities/survey/audience/AudienceRelation;", "getFilters$annotations", "getFilters", "()Ljava/util/List;", "getVisitorType$annotations", "getVisitorType", "()Lcom/survicate/surveys/entities/survey/audience/AudienceVisitorType;", "getHasBackendFilters$annotations", "getHasBackendFilters", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(JLcom/survicate/surveys/entities/survey/audience/AudienceRelation;Ljava/util/List;Lcom/survicate/surveys/entities/survey/audience/AudienceVisitorType;Ljava/lang/Boolean;)Lcom/survicate/surveys/entities/survey/audience/NetworkAudience;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class NetworkAudience {
    private final List<NetworkAudienceFilter> filters;
    private final Boolean hasBackendFilters;
    private final long id;
    private final AudienceRelation relation;
    private final AudienceVisitorType visitorType;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.audience.NetworkAudience$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkAudience._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.audience.NetworkAudience$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkAudience._childSerializers$_anonymous_$0();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.audience.NetworkAudience$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkAudience._childSerializers$_anonymous_$1();
        }
    }), null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.audience.AudienceRelation", AudienceRelation.values(), new String[]{"and", "or"}, new Annotation[][]{null, null}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(NetworkAudienceFilter.INSTANCE.serializer());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.audience.AudienceVisitorType", AudienceVisitorType.values(), new String[]{"anonymous", "identified"}, new Annotation[][]{null, null}, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkAudience copy$default(NetworkAudience networkAudience, long j, AudienceRelation audienceRelation, List list, AudienceVisitorType audienceVisitorType, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            j = networkAudience.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            audienceRelation = networkAudience.relation;
        }
        AudienceRelation audienceRelation2 = audienceRelation;
        if ((i & 4) != 0) {
            list = networkAudience.filters;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            audienceVisitorType = networkAudience.visitorType;
        }
        AudienceVisitorType audienceVisitorType2 = audienceVisitorType;
        if ((i & 16) != 0) {
            bool = networkAudience.hasBackendFilters;
        }
        return networkAudience.copy(j2, audienceRelation2, list2, audienceVisitorType2, bool);
    }

    @SerialName("filters")
    public static /* synthetic */ void getFilters$annotations() {
    }

    @SerialName("has_backend_filters")
    public static /* synthetic */ void getHasBackendFilters$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("filters_relation")
    public static /* synthetic */ void getRelation$annotations() {
    }

    @SerialName("visitor_type")
    public static /* synthetic */ void getVisitorType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AudienceRelation getRelation() {
        return this.relation;
    }

    public final List<NetworkAudienceFilter> component3() {
        return this.filters;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final AudienceVisitorType getVisitorType() {
        return this.visitorType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getHasBackendFilters() {
        return this.hasBackendFilters;
    }

    public final NetworkAudience copy(long id, AudienceRelation relation, List<? extends NetworkAudienceFilter> filters, AudienceVisitorType visitorType, Boolean hasBackendFilters) {
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(filters, "filters");
        Intrinsics.checkNotNullParameter(visitorType, "visitorType");
        return new NetworkAudience(id, relation, filters, visitorType, hasBackendFilters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkAudience)) {
            return false;
        }
        NetworkAudience networkAudience = (NetworkAudience) other;
        return this.id == networkAudience.id && this.relation == networkAudience.relation && Intrinsics.areEqual(this.filters, networkAudience.filters) && this.visitorType == networkAudience.visitorType && Intrinsics.areEqual(this.hasBackendFilters, networkAudience.hasBackendFilters);
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.id) * 31) + this.relation.hashCode()) * 31) + this.filters.hashCode()) * 31) + this.visitorType.hashCode()) * 31;
        Boolean bool = this.hasBackendFilters;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "NetworkAudience(id=" + this.id + ", relation=" + this.relation + ", filters=" + this.filters + ", visitorType=" + this.visitorType + ", hasBackendFilters=" + this.hasBackendFilters + ')';
    }

    /* JADX INFO: compiled from: NetworkAudience.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/NetworkAudience$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudience;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NetworkAudience> serializer() {
            return NetworkAudience$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NetworkAudience(int i, long j, AudienceRelation audienceRelation, List list, AudienceVisitorType audienceVisitorType, Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, NetworkAudience$$serializer.INSTANCE.getDescriptor());
        }
        this.id = j;
        this.relation = audienceRelation;
        this.filters = list;
        this.visitorType = audienceVisitorType;
        this.hasBackendFilters = bool;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(NetworkAudience self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.id);
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.relation);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.filters);
        output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.visitorType);
        output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.hasBackendFilters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkAudience(long j, AudienceRelation relation, List<? extends NetworkAudienceFilter> filters, AudienceVisitorType visitorType, Boolean bool) {
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(filters, "filters");
        Intrinsics.checkNotNullParameter(visitorType, "visitorType");
        this.id = j;
        this.relation = relation;
        this.filters = filters;
        this.visitorType = visitorType;
        this.hasBackendFilters = bool;
    }

    public final long getId() {
        return this.id;
    }

    public final AudienceRelation getRelation() {
        return this.relation;
    }

    public final List<NetworkAudienceFilter> getFilters() {
        return this.filters;
    }

    public final AudienceVisitorType getVisitorType() {
        return this.visitorType;
    }

    public final Boolean getHasBackendFilters() {
        return this.hasBackendFilters;
    }
}
