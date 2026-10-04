package aws.smithy.kotlin.runtime.client.config;

import aws.smithy.kotlin.runtime.client.LogMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class ClientSettings$LogMode$1 extends FunctionReferenceImpl implements Function1<String, LogMode> {
    ClientSettings$LogMode$1(Object obj) {
        super(1, obj, LogMode.Companion.class, "fromString", "fromString(Ljava/lang/String;)Laws/smithy/kotlin/runtime/client/LogMode;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final LogMode invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((LogMode.Companion) this.receiver).fromString(p0);
    }
}
