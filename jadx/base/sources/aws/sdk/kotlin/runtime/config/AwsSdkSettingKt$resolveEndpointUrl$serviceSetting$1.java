package aws.sdk.kotlin.runtime.config;

import aws.smithy.kotlin.runtime.net.url.Url;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsSdkSetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class AwsSdkSettingKt$resolveEndpointUrl$serviceSetting$1 extends AdaptedFunctionReference implements Function1<String, Url> {
    AwsSdkSettingKt$resolveEndpointUrl$serviceSetting$1(Object obj) {
        super(1, obj, Url.Companion.class, "parse", "parse(Ljava/lang/String;Laws/smithy/kotlin/runtime/net/url/UrlEncoding;)Laws/smithy/kotlin/runtime/net/url/Url;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Url invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Url.Companion.parse$default((Url.Companion) this.receiver, p0, null, 2, null);
    }
}
