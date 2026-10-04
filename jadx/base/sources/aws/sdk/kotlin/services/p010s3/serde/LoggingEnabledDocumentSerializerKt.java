package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.LoggingEnabled;
import aws.sdk.kotlin.services.p010s3.model.TargetGrant;
import aws.sdk.kotlin.services.p010s3.model.TargetObjectKeyFormat;
import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableKt;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import aws.smithy.kotlin.runtime.serde.xml.XmlCollectionName;
import aws.smithy.kotlin.runtime.serde.xml.XmlNamespace;
import aws.smithy.kotlin.runtime.serde.xml.XmlSerialName;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoggingEnabledDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"serializeLoggingEnabledDocument", "", "serializer", "Laws/smithy/kotlin/runtime/serde/Serializer;", "input", "Laws/sdk/kotlin/services/s3/model/LoggingEnabled;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoggingEnabledDocumentSerializerKt {
    public static final void serializeLoggingEnabledDocument(Serializer serializer, final LoggingEnabled input) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(input, "input");
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("TargetBucket"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("TargetGrants"), new XmlCollectionName("Grant"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("TargetObjectKeyFormat"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.String.INSTANCE, new XmlSerialName("TargetPrefix"));
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("LoggingEnabled"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        StructSerializer structSerializerBeginStruct = serializer.beginStruct(builder.build());
        structSerializerBeginStruct.field(sdkFieldDescriptor, input.getTargetBucket());
        if (input.getTargetGrants() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor2, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.LoggingEnabledDocumentSerializerKt$serializeLoggingEnabledDocument$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.LoggingEnabledDocumentSerializerKt$serializeLoggingEnabledDocument$1$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: LoggingEnabledDocumentSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, TargetGrant, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    AnonymousClass1() {
                        super(2, TargetGrantDocumentSerializerKt.class, "serializeTargetGrantDocument", "serializeTargetGrantDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/TargetGrant;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, TargetGrant targetGrant) {
                        invoke2(serializer, targetGrant);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, TargetGrant p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        TargetGrantDocumentSerializerKt.serializeTargetGrantDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<TargetGrant> it = input.getTargetGrants().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                    }
                }
            });
        }
        TargetObjectKeyFormat targetObjectKeyFormat = input.getTargetObjectKeyFormat();
        if (targetObjectKeyFormat != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor3, targetObjectKeyFormat, C3556xbea574d9.INSTANCE);
        }
        structSerializerBeginStruct.field(sdkFieldDescriptor4, input.getTargetPrefix());
        structSerializerBeginStruct.endStruct();
    }
}
