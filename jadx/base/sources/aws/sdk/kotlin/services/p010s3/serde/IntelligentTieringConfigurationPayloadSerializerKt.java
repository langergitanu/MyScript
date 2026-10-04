package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.IntelligentTieringConfiguration;
import aws.sdk.kotlin.services.p010s3.model.IntelligentTieringFilter;
import aws.sdk.kotlin.services.p010s3.model.Tiering;
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

/* JADX INFO: compiled from: IntelligentTieringConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializeIntelligentTieringConfigurationPayloadWithXmlNameIntelligentTieringConfiguration", "", "input", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class IntelligentTieringConfigurationPayloadSerializerKt {
    /* JADX INFO: renamed from: serializeIntelligentTieringConfigurationPayloadWithXmlNameIntelligentTieringConfiguration */
    public static final byte[] m480x25303772(final IntelligentTieringConfiguration input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("Filter"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("Id"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Enum.INSTANCE, new XmlSerialName("Status"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("Tiering"), Flattened.INSTANCE);
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("IntelligentTieringConfiguration"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        StructSerializer structSerializerBeginStruct = xmlSerializer.beginStruct(builder.build());
        IntelligentTieringFilter filter = input.getFilter();
        if (filter != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, filter, C3520x946de031.INSTANCE);
        }
        structSerializerBeginStruct.field(sdkFieldDescriptor2, input.getId());
        structSerializerBeginStruct.field(sdkFieldDescriptor3, input.getStatus().getValue());
        structSerializerBeginStruct.listField(sdkFieldDescriptor4, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.IntelligentTieringConfigurationPayloadSerializerKt$serializeIntelligentTieringConfigurationPayloadWithXmlNameIntelligentTieringConfiguration$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                invoke2(listSerializer);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.IntelligentTieringConfigurationPayloadSerializerKt$serializeIntelligentTieringConfigurationPayloadWithXmlNameIntelligentTieringConfiguration$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: IntelligentTieringConfigurationPayloadSerializer.kt */
            @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
            static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, Tiering, Unit> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                AnonymousClass1() {
                    super(2, TieringDocumentSerializerKt.class, "serializeTieringDocument", "serializeTieringDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/Tiering;)V", 1);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, Tiering tiering) {
                    invoke2(serializer, tiering);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Serializer p0, Tiering p1) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    Intrinsics.checkNotNullParameter(p1, "p1");
                    TieringDocumentSerializerKt.serializeTieringDocument(p0, p1);
                }
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ListSerializer listField) {
                Intrinsics.checkNotNullParameter(listField, "$this$listField");
                Iterator<Tiering> it = input.getTierings().iterator();
                while (it.hasNext()) {
                    listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                }
            }
        });
        structSerializerBeginStruct.endStruct();
        return xmlSerializer.toByteArray();
    }
}
