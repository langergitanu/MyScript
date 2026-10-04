package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.EventBridgeConfiguration;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.NotificationConfigurationPayloadSerializerKt$serializeNotificationConfigurationPayloadWithXmlNameNotificationConfiguration$1$1$1 */
/* JADX INFO: compiled from: NotificationConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3565x9211e0d3 extends FunctionReferenceImpl implements Function2<Serializer, EventBridgeConfiguration, Unit> {
    public static final C3565x9211e0d3 INSTANCE = new C3565x9211e0d3();

    C3565x9211e0d3() {
        super(2, EventBridgeConfigurationDocumentSerializerKt.class, "serializeEventBridgeConfigurationDocument", "serializeEventBridgeConfigurationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/EventBridgeConfiguration;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, EventBridgeConfiguration eventBridgeConfiguration) {
        invoke2(serializer, eventBridgeConfiguration);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, EventBridgeConfiguration p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        EventBridgeConfigurationDocumentSerializerKt.serializeEventBridgeConfigurationDocument(p0, p1);
    }
}
