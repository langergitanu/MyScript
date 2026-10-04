package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.NotificationConfigurationFilter;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.QueueConfigurationDocumentSerializerKt$serializeQueueConfigurationDocument$1$2$1 */
/* JADX INFO: compiled from: QueueConfigurationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3581xa87dc75f extends FunctionReferenceImpl implements Function2<Serializer, NotificationConfigurationFilter, Unit> {
    public static final C3581xa87dc75f INSTANCE = new C3581xa87dc75f();

    C3581xa87dc75f() {
        super(2, NotificationConfigurationFilterDocumentSerializerKt.class, "serializeNotificationConfigurationFilterDocument", "serializeNotificationConfigurationFilterDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/NotificationConfigurationFilter;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, NotificationConfigurationFilter notificationConfigurationFilter) {
        invoke2(serializer, notificationConfigurationFilter);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, NotificationConfigurationFilter p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        NotificationConfigurationFilterDocumentSerializerKt.serializeNotificationConfigurationFilterDocument(p0, p1);
    }
}
