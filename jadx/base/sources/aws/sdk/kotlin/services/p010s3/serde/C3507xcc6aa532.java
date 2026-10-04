package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.EncryptionConfiguration;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.DestinationDocumentSerializerKt$serializeDestinationDocument$1$3$1 */
/* JADX INFO: compiled from: DestinationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3507xcc6aa532 extends FunctionReferenceImpl implements Function2<Serializer, EncryptionConfiguration, Unit> {
    public static final C3507xcc6aa532 INSTANCE = new C3507xcc6aa532();

    C3507xcc6aa532() {
        super(2, EncryptionConfigurationDocumentSerializerKt.class, "serializeEncryptionConfigurationDocument", "serializeEncryptionConfigurationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/EncryptionConfiguration;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, EncryptionConfiguration encryptionConfiguration) {
        invoke2(serializer, encryptionConfiguration);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, EncryptionConfiguration p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        EncryptionConfigurationDocumentSerializerKt.serializeEncryptionConfigurationDocument(p0, p1);
    }
}
