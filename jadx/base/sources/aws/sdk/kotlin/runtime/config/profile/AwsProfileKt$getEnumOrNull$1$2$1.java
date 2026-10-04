package aws.sdk.kotlin.runtime.config.profile;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: AwsProfile.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 176)
public final class AwsProfileKt$getEnumOrNull$1$2$1<T> implements Function1<T, CharSequence> {
    public static final AwsProfileKt$getEnumOrNull$1$2$1 INSTANCE;

    static {
        Intrinsics.needClassReification();
        INSTANCE = new AwsProfileKt$getEnumOrNull$1$2$1();
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
