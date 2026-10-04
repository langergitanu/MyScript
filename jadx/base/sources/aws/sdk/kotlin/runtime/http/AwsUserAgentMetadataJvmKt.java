package aws.sdk.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.util.PlatformProvider;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsUserAgentMetadataJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0002\" \u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"jvmMetadataExtras", "Lkotlin/Lazy;", "", "", "platformLanguageMetadata", "Laws/sdk/kotlin/runtime/http/LanguageMetadata;", "getSystemProperty", "name", "defaultValue", "aws-http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsUserAgentMetadataJvmKt {
    private static final Lazy<Map<String, String>> jvmMetadataExtras = LazyKt.lazy(new Function0() { // from class: aws.sdk.kotlin.runtime.http.AwsUserAgentMetadataJvmKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AwsUserAgentMetadataJvmKt.jvmMetadataExtras$lambda$0();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map jvmMetadataExtras$lambda$0() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.m1606to("javaVersion", getSystemProperty$default("java.version", null, 2, null)), TuplesKt.m1606to("jvmName", getSystemProperty$default("java.vm.name", null, 2, null)), TuplesKt.m1606to("jvmVersion", getSystemProperty$default("java.vm.version", null, 2, null)));
        if (PlatformProvider.INSTANCE.getSystem().isAndroid()) {
            Class<?> cls = Class.forName("android.os.Build$VERSION");
            Field declaredField = cls.getDeclaredField("SDK_INT");
            Field declaredField2 = cls.getDeclaredField("RELEASE");
            mapMutableMapOf.put("androidApiVersion", String.valueOf(declaredField.getInt(null)));
            Object obj = declaredField2.get(null);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            mapMutableMapOf.put("androidRelease", (String) obj);
        }
        return mapMutableMapOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final LanguageMetadata platformLanguageMetadata() {
        return new LanguageMetadata(null, jvmMetadataExtras.getValue(), 1, 0 == true ? 1 : 0);
    }

    private static final String getSystemProperty(String str, String str2) {
        Object objM14499constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(System.getProperty(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        Object obj = str2;
        if (!Result.m14505isFailureimpl(objM14499constructorimpl)) {
            obj = objM14499constructorimpl;
        }
        return (String) obj;
    }

    static /* synthetic */ String getSystemProperty$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "unknown";
        }
        return getSystemProperty(str, str2);
    }
}
