package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.BucketLifecycleConfiguration;
import aws.sdk.kotlin.services.p010s3.model.LifecycleRule;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.Flattened;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerializer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BucketLifecycleConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializeBucketLifecycleConfigurationPayloadWithXmlNameLifecycleConfiguration", "", "input", "Laws/sdk/kotlin/services/s3/model/BucketLifecycleConfiguration;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BucketLifecycleConfigurationPayloadSerializerKt {
    /* JADX INFO: renamed from: serializeBucketLifecycleConfigurationPayloadWithXmlNameLifecycleConfiguration */
    public static final byte[] m475xbd89add0(final BucketLifecycleConfiguration input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("Rule"), Flattened.INSTANCE);
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("LifecycleConfiguration"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        StructSerializer structSerializerBeginStruct = xmlSerializer.beginStruct(builder.build());
        structSerializerBeginStruct.listField(sdkFieldDescriptor, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.BucketLifecycleConfigurationPayloadSerializerKt$serializeBucketLifecycleConfigurationPayloadWithXmlNameLifecycleConfiguration$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                invoke2(listSerializer);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.BucketLifecycleConfigurationPayloadSerializerKt$serializeBucketLifecycleConfigurationPayloadWithXmlNameLifecycleConfiguration$1$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: BucketLifecycleConfigurationPayloadSerializer.kt */
            @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
            static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, LifecycleRule, Unit> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                AnonymousClass1() {
                    super(2, LifecycleRuleDocumentSerializerKt.class, "serializeLifecycleRuleDocument", "serializeLifecycleRuleDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/LifecycleRule;)V", 1);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, LifecycleRule lifecycleRule) {
                    invoke2(serializer, lifecycleRule);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Serializer p0, LifecycleRule p1) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    Intrinsics.checkNotNullParameter(p1, "p1");
                    LifecycleRuleDocumentSerializerKt.serializeLifecycleRuleDocument(p0, p1);
                }
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ListSerializer listField) {
                Intrinsics.checkNotNullParameter(listField, "$this$listField");
                Iterator<LifecycleRule> it = input.getRules().iterator();
                while (it.hasNext()) {
                    listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                }
            }
        });
        structSerializerBeginStruct.endStruct();
        return xmlSerializer.toByteArray();
    }
}
