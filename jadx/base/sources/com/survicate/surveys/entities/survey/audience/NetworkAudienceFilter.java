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
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: NetworkAudienceFilters.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0005\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceFilter;", "", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "exclude", "", "getExclude", "()Z", "values", "", "getValues", "()Ljava/util/List;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceKnownUserFilter;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceLocaleFilter;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudiencePlatformFilter;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceScreenOrientationFilter;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceUserFilter;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public abstract class NetworkAudienceFilter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.audience.NetworkAudienceFilter$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkAudienceFilter._init_$_anonymous_();
        }
    });

    public /* synthetic */ NetworkAudienceFilter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(NetworkAudienceFilter self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }

    public abstract boolean getExclude();

    public abstract List<?> getValues();

    /* JADX INFO: compiled from: NetworkAudienceFilters.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceFilter$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudienceFilter;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) NetworkAudienceFilter.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<NetworkAudienceFilter> serializer() {
            return get$cachedSerializer();
        }
    }

    private NetworkAudienceFilter() {
    }

    public /* synthetic */ NetworkAudienceFilter(int i, SerializationConstructorMarker serializationConstructorMarker) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("com.survicate.surveys.entities.survey.audience.NetworkAudienceFilter", Reflection.getOrCreateKotlinClass(NetworkAudienceFilter.class), new KClass[]{Reflection.getOrCreateKotlinClass(NetworkAudienceKnownUserFilter.class), Reflection.getOrCreateKotlinClass(NetworkAudienceLocaleFilter.class), Reflection.getOrCreateKotlinClass(NetworkAudiencePlatformFilter.class), Reflection.getOrCreateKotlinClass(NetworkAudienceScreenOrientationFilter.class), Reflection.getOrCreateKotlinClass(NetworkAudienceUserFilter.class)}, new KSerializer[]{NetworkAudienceKnownUserFilter$$serializer.INSTANCE, NetworkAudienceLocaleFilter$$serializer.INSTANCE, NetworkAudiencePlatformFilter$$serializer.INSTANCE, NetworkAudienceScreenOrientationFilter$$serializer.INSTANCE, NetworkAudienceUserFilter$$serializer.INSTANCE}, new Annotation[0]);
    }
}
