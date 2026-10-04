package aws.smithy.kotlin.runtime.util;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PlatformJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"", "isAndroid", "()Z", "", "value", "normalize", "(Ljava/lang/String;)Ljava/lang/String;", "Laws/smithy/kotlin/runtime/util/OperatingSystem;", "getOsInfo", "()Laws/smithy/kotlin/runtime/util/OperatingSystem;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PlatformJVMKt {
    public static final /* synthetic */ boolean access$isAndroid() {
        return isAndroid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isAndroid() {
        try {
            Class.forName("android.os.Build");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static final String normalize(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new Regex("[^a-z0-9+]").replace(lowerCase, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OperatingSystem getOsInfo() {
        OsFamily osFamily;
        Object objM14499constructorimpl;
        String property = System.getProperty("os.name");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        String strNormalize = normalize(property);
        if (isAndroid()) {
            osFamily = OsFamily.Android;
        } else {
            String str = strNormalize;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "windows", false, 2, (Object) null)) {
                osFamily = OsFamily.Windows;
            } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "linux", false, 2, (Object) null)) {
                osFamily = OsFamily.Linux;
            } else {
                osFamily = StringsKt.contains$default((CharSequence) str, (CharSequence) "macosx", false, 2, (Object) null) ? OsFamily.MacOs : OsFamily.Unknown;
            }
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(System.getProperty("os.version"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        return new OperatingSystem(osFamily, (String) (Result.m14505isFailureimpl(objM14499constructorimpl) ? null : objM14499constructorimpl));
    }
}
