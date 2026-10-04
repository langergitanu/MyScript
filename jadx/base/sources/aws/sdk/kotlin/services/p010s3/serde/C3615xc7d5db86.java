package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.StorageClassAnalysisDataExport;
import aws.smithy.kotlin.runtime.serde.Serializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.StorageClassAnalysisDocumentSerializerKt$serializeStorageClassAnalysisDocument$1$1$1 */
/* JADX INFO: compiled from: StorageClassAnalysisDocumentSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class C3615xc7d5db86 extends FunctionReferenceImpl implements Function2<Serializer, StorageClassAnalysisDataExport, Unit> {
    public static final C3615xc7d5db86 INSTANCE = new C3615xc7d5db86();

    C3615xc7d5db86() {
        super(2, StorageClassAnalysisDataExportDocumentSerializerKt.class, "serializeStorageClassAnalysisDataExportDocument", "serializeStorageClassAnalysisDataExportDocument(Laws/smithy/kotlin/runtime/serde/Serializer;Laws/sdk/kotlin/services/s3/model/StorageClassAnalysisDataExport;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Serializer serializer, StorageClassAnalysisDataExport storageClassAnalysisDataExport) {
        invoke2(serializer, storageClassAnalysisDataExport);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Serializer p0, StorageClassAnalysisDataExport p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        StorageClassAnalysisDataExportDocumentSerializerKt.serializeStorageClassAnalysisDataExportDocument(p0, p1);
    }
}
