package com.survicate.surveys.entities.survey.audience.attributes;

import com.survicate.surveys.core.targeting.audience.attributes.AudienceUserFilterAttribute;
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
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* JADX INFO: compiled from: NetworkAudienceUserFilterAttributes.kt */
/* JADX INFO: loaded from: classes8.dex */
@JsonClassDiscriminator(discriminator = "attribute_type")
@Metadata(m1598d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000  2\u00020\u0001:\u0001 B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0005!\"#$%¨\u0006&"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterAttribute;", "", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "name", "", "getName", "()Ljava/lang/String;", "operator", "Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterAttributeOperator;", "getOperator", "()Lcom/survicate/surveys/entities/survey/audience/attributes/AudienceUserFilterAttributeOperator;", "values", "", "getValues", "()Ljava/util/List;", "toDomainModel", "Lcom/survicate/surveys/core/targeting/audience/attributes/AudienceUserFilterAttribute;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterBooleanAttribute;", "Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterDateTimeAttribute;", "Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterNumberAttribute;", "Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterStringAttribute;", "Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterTimeIntervalAttribute;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public abstract class NetworkAudienceUserFilterAttribute {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.audience.attributes.NetworkAudienceUserFilterAttribute$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NetworkAudienceUserFilterAttribute._init_$_anonymous_();
        }
    });

    public /* synthetic */ NetworkAudienceUserFilterAttribute(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(NetworkAudienceUserFilterAttribute self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }

    public abstract String getName();

    public abstract AudienceUserFilterAttributeOperator getOperator();

    public abstract List<?> getValues();

    public abstract AudienceUserFilterAttribute toDomainModel(TimestampProvider timestampProvider);

    /* JADX INFO: compiled from: NetworkAudienceUserFilterAttributes.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterAttribute$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/audience/attributes/NetworkAudienceUserFilterAttribute;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) NetworkAudienceUserFilterAttribute.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<NetworkAudienceUserFilterAttribute> serializer() {
            return get$cachedSerializer();
        }
    }

    private NetworkAudienceUserFilterAttribute() {
    }

    public /* synthetic */ NetworkAudienceUserFilterAttribute(int i, SerializationConstructorMarker serializationConstructorMarker) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("com.survicate.surveys.entities.survey.audience.attributes.NetworkAudienceUserFilterAttribute", Reflection.getOrCreateKotlinClass(NetworkAudienceUserFilterAttribute.class), new KClass[]{Reflection.getOrCreateKotlinClass(NetworkAudienceUserFilterBooleanAttribute.class), Reflection.getOrCreateKotlinClass(NetworkAudienceUserFilterDateTimeAttribute.class), Reflection.getOrCreateKotlinClass(NetworkAudienceUserFilterNumberAttribute.class), Reflection.getOrCreateKotlinClass(NetworkAudienceUserFilterStringAttribute.class), Reflection.getOrCreateKotlinClass(NetworkAudienceUserFilterTimeIntervalAttribute.class)}, new KSerializer[]{NetworkAudienceUserFilterBooleanAttribute$$serializer.INSTANCE, NetworkAudienceUserFilterDateTimeAttribute$$serializer.INSTANCE, NetworkAudienceUserFilterNumberAttribute$$serializer.INSTANCE, NetworkAudienceUserFilterStringAttribute$$serializer.INSTANCE, NetworkAudienceUserFilterTimeIntervalAttribute$$serializer.INSTANCE}, new Annotation[]{new C8384xecb2c058("attribute_type")});
    }
}
