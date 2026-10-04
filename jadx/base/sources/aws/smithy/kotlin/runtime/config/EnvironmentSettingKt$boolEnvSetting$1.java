package aws.smithy.kotlin.runtime.config;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EnvironmentSetting.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class EnvironmentSettingKt$boolEnvSetting$1 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public static final EnvironmentSettingKt$boolEnvSetting$1 INSTANCE = new EnvironmentSettingKt$boolEnvSetting$1();

    EnvironmentSettingKt$boolEnvSetting$1() {
        super(1, StringsKt.class, "toBoolean", "toBoolean(Ljava/lang/String;)Z", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Boolean.valueOf(Boolean.parseBoolean(p0));
    }
}
