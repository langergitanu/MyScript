package com.survicate.surveys.entities.survey.audience;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: NetworkAudienceFilters.kt */
/* JADX INFO: loaded from: classes8.dex */
@SerialName("screen_orientation")
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceScreenOrientationFilter;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceFilter;", "exclude", "", "values", "", "", "<init>", "(ZLjava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getExclude$annotations", "()V", "getExclude", "()Z", "getValues$annotations", "getValues", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class NetworkAudienceScreenOrientationFilter extends NetworkAudienceFilter {
    private final boolean exclude;
    private final List<String> values;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.audience.NetworkAudienceScreenOrientationFilter$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkAudienceScreenOrientationFilter._childSerializers$_anonymous_();
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkAudienceScreenOrientationFilter copy$default(NetworkAudienceScreenOrientationFilter networkAudienceScreenOrientationFilter, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = networkAudienceScreenOrientationFilter.exclude;
        }
        if ((i & 2) != 0) {
            list = networkAudienceScreenOrientationFilter.values;
        }
        return networkAudienceScreenOrientationFilter.copy(z, list);
    }

    @SerialName("exclude")
    public static /* synthetic */ void getExclude$annotations() {
    }

    @SerialName("values")
    public static /* synthetic */ void getValues$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getExclude() {
        return this.exclude;
    }

    public final List<String> component2() {
        return this.values;
    }

    public final NetworkAudienceScreenOrientationFilter copy(boolean exclude, List<String> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return new NetworkAudienceScreenOrientationFilter(exclude, values);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkAudienceScreenOrientationFilter)) {
            return false;
        }
        NetworkAudienceScreenOrientationFilter networkAudienceScreenOrientationFilter = (NetworkAudienceScreenOrientationFilter) other;
        return this.exclude == networkAudienceScreenOrientationFilter.exclude && Intrinsics.areEqual(this.values, networkAudienceScreenOrientationFilter.values);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.exclude) * 31) + this.values.hashCode();
    }

    public String toString() {
        return "NetworkAudienceScreenOrientationFilter(exclude=" + this.exclude + ", values=" + this.values + ')';
    }

    /* JADX INFO: compiled from: NetworkAudienceFilters.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceScreenOrientationFilter$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceScreenOrientationFilter;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NetworkAudienceScreenOrientationFilter> serializer() {
            return NetworkAudienceScreenOrientationFilter$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkAudienceScreenOrientationFilter(int i, boolean z, List list, SerializationConstructorMarker serializationConstructorMarker) {
        super(i, serializationConstructorMarker);
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, NetworkAudienceScreenOrientationFilter$$serializer.INSTANCE.getDescriptor());
        }
        this.exclude = z;
        this.values = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(NetworkAudienceScreenOrientationFilter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        NetworkAudienceFilter.write$Self(self, output, serialDesc);
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeBooleanElement(serialDesc, 0, self.getExclude());
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.getValues());
    }

    @Override // com.survicate.surveys.entities.survey.audience.NetworkAudienceFilter
    public boolean getExclude() {
        return this.exclude;
    }

    @Override // com.survicate.surveys.entities.survey.audience.NetworkAudienceFilter
    public List<String> getValues() {
        return this.values;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkAudienceScreenOrientationFilter(boolean z, List<String> values) {
        super(null);
        Intrinsics.checkNotNullParameter(values, "values");
        this.exclude = z;
        this.values = values;
    }
}
