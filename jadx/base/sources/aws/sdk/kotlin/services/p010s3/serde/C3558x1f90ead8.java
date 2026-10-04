package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.JournalTableConfiguration;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.MetadataConfigurationPayloadSerializerKt$serializeMetadataConfigurationPayloadWithXmlNameMetadataConfiguration$1$2$1 */
/* JADX INFO: compiled from: MetadataConfigurationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3558x1f90ead8 extends FunctionReferenceImpl implements Function2<Serializer, JournalTableConfiguration, Unit> {
    public static final C3558x1f90ead8 INSTANCE = new C3558x1f90ead8();

    C3558x1f90ead8() {
        super(2, JournalTableConfigurationDocumentSerializerKt.class, "serializeJournalTableConfigurationDocument", "serializeJournalTableConfigurationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/JournalTableConfiguration;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, JournalTableConfiguration journalTableConfiguration) {
        invoke2(serializer, journalTableConfiguration);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, JournalTableConfiguration p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        JournalTableConfigurationDocumentSerializerKt.serializeJournalTableConfigurationDocument(p0, p1);
    }
}
