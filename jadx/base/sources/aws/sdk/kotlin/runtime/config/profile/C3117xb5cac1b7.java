package aws.sdk.kotlin.runtime.config.profile;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.profile.AwsProfileKt$getEnumOrNull$lambda$0$$inlined$buildString$lambda$1 */
/* JADX INFO: compiled from: AwsProfile.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 176)
public final class C3117xb5cac1b7<T> implements Function1<T, CharSequence> {
    public static final C3117xb5cac1b7 INSTANCE;

    static {
        Intrinsics.needClassReification();
        INSTANCE = new C3117xb5cac1b7();
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/CharSequence; */
    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Enum it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String lowerCase = it.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
