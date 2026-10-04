package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.CorsRule;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.Flattened;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CorsRuleDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeCorsRuleDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/CorsRule;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CorsRuleDocumentSerializerKt {
    public static final void serializeCorsRuleDocument(Serializer serializer, final CorsRule input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("AllowedHeader"), Flattened.INSTANCE);
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("AllowedMethod"), Flattened.INSTANCE);
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("AllowedOrigin"), Flattened.INSTANCE);
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("ExposeHeader"), Flattened.INSTANCE);
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("ID"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(SerialKind.Integer.INSTANCE, new XmlSerialName("MaxAgeSeconds"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("CorsRule"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        builder.field(sdkFieldDescriptor6);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        if (input.getAllowedHeaders() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.CorsRuleDocumentSerializerKt$serializeCorsRuleDocument$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<String> it = input.getAllowedHeaders().iterator();
                    while (it.hasNext()) {
                        listField.serializeString(it.next());
                    }
                }
            });
        }
        structSerializerBeginStruct.listField(sdkFieldDescriptor2, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.CorsRuleDocumentSerializerKt$serializeCorsRuleDocument$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                invoke2(listSerializer);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ListSerializer listField) {
                Intrinsics.checkNotNullParameter(listField, "$this$listField");
                Iterator<String> it = input.getAllowedMethods().iterator();
                while (it.hasNext()) {
                    listField.serializeString(it.next());
                }
            }
        });
        structSerializerBeginStruct.listField(sdkFieldDescriptor3, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.CorsRuleDocumentSerializerKt$serializeCorsRuleDocument$1$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                invoke2(listSerializer);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ListSerializer listField) {
                Intrinsics.checkNotNullParameter(listField, "$this$listField");
                Iterator<String> it = input.getAllowedOrigins().iterator();
                while (it.hasNext()) {
                    listField.serializeString(it.next());
                }
            }
        });
        if (input.getExposeHeaders() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor4, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.CorsRuleDocumentSerializerKt$serializeCorsRuleDocument$1$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<String> it = input.getExposeHeaders().iterator();
                    while (it.hasNext()) {
                        listField.serializeString(it.next());
                    }
                }
            });
        }
        String id = input.getId();
        if (id != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor5, id);
        }
        Integer maxAgeSeconds = input.getMaxAgeSeconds();
        if (maxAgeSeconds != null) {
            structSerializerBeginStruct.field(sdkFieldDescriptor6, maxAgeSeconds.intValue());
        }
        structSerializerBeginStruct.endStruct();
    }
}
