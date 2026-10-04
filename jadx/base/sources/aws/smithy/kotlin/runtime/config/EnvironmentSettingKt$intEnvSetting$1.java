package aws.smithy.kotlin.runtime.config;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EnvironmentSetting.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class EnvironmentSettingKt$intEnvSetting$1 extends FunctionReferenceImpl implements Function1<String, Integer> {
    public static final EnvironmentSettingKt$intEnvSetting$1 INSTANCE = new EnvironmentSettingKt$intEnvSetting$1();

    EnvironmentSettingKt$intEnvSetting$1() {
        super(1, StringsKt.class, "toInt", "toInt(Ljava/lang/String;)I", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Integer.valueOf(Integer.parseInt(p0));
    }
}
