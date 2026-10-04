package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.EventBridgeConfiguration;
import aws.sdk.kotlin.services.p010s3.model.LambdaFunctionConfiguration;
import aws.sdk.kotlin.services.p010s3.model.NotificationConfiguration;
import aws.sdk.kotlin.services.p010s3.model.QueueConfiguration;
import aws.sdk.kotlin.services.p010s3.model.TopicConfiguration;
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

/* JADX INFO: compiled from: NotificationConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"serializeNotificationConfigurationPayloadWithXmlNameNotificationConfiguration", "", "input", "Laws/sdk/kotlin/services/s3/model/NotificationConfiguration;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NotificationConfigurationPayloadSerializerKt {
    /* JADX INFO: renamed from: serializeNotificationConfigurationPayloadWithXmlNameNotificationConfiguration */
    public static final byte[] m489x15c39872(final NotificationConfiguration input) {
        Intrinsics.checkNotNullParameter(input, "input");
        XmlSerializer xmlSerializer = new XmlSerializer(null, 1, null);
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new XmlSerialName("EventBridgeConfiguration"));
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("CloudFunctionConfiguration"), Flattened.INSTANCE);
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("QueueConfiguration"), Flattened.INSTANCE);
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(SerialKind.List.INSTANCE, new XmlSerialName("TopicConfiguration"), Flattened.INSTANCE);
        SdkObjectDescriptor.Companion companion = SdkObjectDescriptor.INSTANCE;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.trait(new XmlSerialName("NotificationConfiguration"));
        builder.trait(new XmlNamespace("http://s3.amazonaws.com/doc/2006-03-01/", null, 2, null));
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        StructSerializer structSerializerBeginStruct = xmlSerializer.beginStruct(builder.build());
        EventBridgeConfiguration eventBridgeConfiguration = input.getEventBridgeConfiguration();
        if (eventBridgeConfiguration != null) {
            SdkSerializableKt.field(structSerializerBeginStruct, sdkFieldDescriptor, eventBridgeConfiguration, C3565x9211e0d3.INSTANCE);
        }
        if (input.getLambdaFunctionConfigurations() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor2, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.NotificationConfigurationPayloadSerializerKt$serializeNotificationConfigurationPayloadWithXmlNameNotificationConfiguration$1$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.NotificationConfigurationPayloadSerializerKt$serializeNotificationConfigurationPayloadWithXmlNameNotificationConfiguration$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: NotificationConfigurationPayloadSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, LambdaFunctionConfiguration, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    AnonymousClass1() {
                        super(2, LambdaFunctionConfigurationDocumentSerializerKt.class, "serializeLambdaFunctionConfigurationDocument", "serializeLambdaFunctionConfigurationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/LambdaFunctionConfiguration;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, LambdaFunctionConfiguration lambdaFunctionConfiguration) {
                        invoke2(serializer, lambdaFunctionConfiguration);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, LambdaFunctionConfiguration p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        LambdaFunctionConfigurationDocumentSerializerKt.serializeLambdaFunctionConfigurationDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<LambdaFunctionConfiguration> it = input.getLambdaFunctionConfigurations().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                    }
                }
            });
        }
        if (input.getQueueConfigurations() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor3, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.NotificationConfigurationPayloadSerializerKt$serializeNotificationConfigurationPayloadWithXmlNameNotificationConfiguration$1$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.NotificationConfigurationPayloadSerializerKt$serializeNotificationConfigurationPayloadWithXmlNameNotificationConfiguration$1$3$1, reason: invalid class name */
                /* JADX INFO: compiled from: NotificationConfigurationPayloadSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, QueueConfiguration, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    AnonymousClass1() {
                        super(2, QueueConfigurationDocumentSerializerKt.class, "serializeQueueConfigurationDocument", "serializeQueueConfigurationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/QueueConfiguration;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, QueueConfiguration queueConfiguration) {
                        invoke2(serializer, queueConfiguration);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, QueueConfiguration p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        QueueConfigurationDocumentSerializerKt.serializeQueueConfigurationDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<QueueConfiguration> it = input.getQueueConfigurations().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                    }
                }
            });
        }
        if (input.getTopicConfigurations() != null) {
            structSerializerBeginStruct.listField(sdkFieldDescriptor4, new Function1<ListSerializer, Unit>() { // from class: aws.sdk.kotlin.services.s3.serde.NotificationConfigurationPayloadSerializerKt$serializeNotificationConfigurationPayloadWithXmlNameNotificationConfiguration$1$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ListSerializer listSerializer) {
                    invoke2(listSerializer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.NotificationConfigurationPayloadSerializerKt$serializeNotificationConfigurationPayloadWithXmlNameNotificationConfiguration$1$4$1, reason: invalid class name */
                /* JADX INFO: compiled from: NotificationConfigurationPayloadSerializer.kt */
                @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
                static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Serializer, TopicConfiguration, Unit> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    AnonymousClass1() {
                        super(2, TopicConfigurationDocumentSerializerKt.class, "serializeTopicConfigurationDocument", "serializeTopicConfigurationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/TopicConfiguration;)V", 1);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, TopicConfiguration topicConfiguration) {
                        invoke2(serializer, topicConfiguration);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Serializer p0, TopicConfiguration p1) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        Intrinsics.checkNotNullParameter(p1, "p1");
                        TopicConfigurationDocumentSerializerKt.serializeTopicConfigurationDocument(p0, p1);
                    }
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ListSerializer listField) {
                    Intrinsics.checkNotNullParameter(listField, "$this$listField");
                    Iterator<TopicConfiguration> it = input.getTopicConfigurations().iterator();
                    while (it.hasNext()) {
                        listField.serializeSdkSerializable(SdkSerializableKt.asSdkSerializable(it.next(), AnonymousClass1.INSTANCE));
                    }
                }
            });
        }
        structSerializerBeginStruct.endStruct();
        return xmlSerializer.toByteArray();
    }
}
