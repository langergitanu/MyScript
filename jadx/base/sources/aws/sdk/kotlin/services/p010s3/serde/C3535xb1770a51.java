package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.RecordExpiration;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.JournalTableConfigurationDocumentSerializerKt$serializeJournalTableConfigurationDocument$1$2$1 */
/* JADX INFO: compiled from: JournalTableConfigurationDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3535xb1770a51 extends FunctionReferenceImpl implements Function2<Serializer, RecordExpiration, Unit> {
    public static final C3535xb1770a51 INSTANCE = new C3535xb1770a51();

    C3535xb1770a51() {
        super(2, RecordExpirationDocumentSerializerKt.class, "serializeRecordExpirationDocument", "serializeRecordExpirationDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/RecordExpiration;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, RecordExpiration recordExpiration) {
        invoke2(serializer, recordExpiration);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, RecordExpiration p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        RecordExpirationDocumentSerializerKt.serializeRecordExpirationDocument(p0, p1);
    }
}
