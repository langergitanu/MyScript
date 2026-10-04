package aws.smithy.kotlin.runtime.config;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.Typography;

/* JADX INFO: compiled from: EnvironmentSetting.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0010\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a+\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0016\u001a-\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0019\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001aI\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001cH\u0007¢\u0006\u0004\b \u0010!\u001a+\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001f2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\"\"B\u0010&\u001a$\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00010#j\b\u0012\u0004\u0012\u00020$`%8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b*\u0010+\u001a\u0004\b(\u0010)\"B\u0010-\u001a$\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00010#j\b\u0012\u0004\u0012\u00020,`%8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b-\u0010'\u0012\u0004\b/\u0010+\u001a\u0004\b.\u0010)\"B\u00101\u001a$\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00010#j\b\u0012\u0004\u0012\u000200`%8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b1\u0010'\u0012\u0004\b3\u0010+\u001a\u0004\b2\u0010)\"B\u00104\u001a$\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00010#j\b\u0012\u0004\u0012\u00020\u0007`%8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b4\u0010'\u0012\u0004\b6\u0010+\u001a\u0004\b5\u0010)*F\b\u0007\u00108\u001a\u0004\b\u0000\u0010\u0000\"\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010#2\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010#B\u0002\b7¨\u00069"}, m1599d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;", DeviceDimensionProvider.KEY_PLATFORM, "resolve", "(Laws/smithy/kotlin/runtime/config/EnvironmentSetting;Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;)Ljava/lang/Object;", "", "", "sysProp", "envVar", "enumEnvSetting", "(Ljava/lang/String;Ljava/lang/String;)Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "sysPropSuffix", "envVarSuffix", "Laws/smithy/kotlin/runtime/config/CaseInsensitiveEnvironmentSetting;", "withCaseInsensitiveSuffixes", "(Laws/smithy/kotlin/runtime/config/EnvironmentSetting;Ljava/lang/String;Ljava/lang/String;)Laws/smithy/kotlin/runtime/config/CaseInsensitiveEnvironmentSetting;", TtmlNode.RUBY_BASE, "caseInsensitiveSuffix", "Lkotlin/text/Regex;", "caseInsensitiveRegex", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/text/Regex;", "(Laws/smithy/kotlin/runtime/config/CaseInsensitiveEnvironmentSetting;Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;)Ljava/lang/Object;", "", "sourceValues", "keyRegex", "resolveStringValue", "(Ljava/util/Map;Lkotlin/text/Regex;)Ljava/lang/String;", "", "sysProps", "envVars", "Laws/smithy/kotlin/runtime/config/MultipleKeyEnvironmentSetting;", "withAdditionalKeys", "(Laws/smithy/kotlin/runtime/config/EnvironmentSetting;Ljava/util/List;Ljava/util/List;)Laws/smithy/kotlin/runtime/config/MultipleKeyEnvironmentSetting;", "(Laws/smithy/kotlin/runtime/config/MultipleKeyEnvironmentSetting;Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "Laws/smithy/kotlin/runtime/config/EnvSettingFactory;", "boolEnvSetting", "Lkotlin/jvm/functions/Function2;", "getBoolEnvSetting", "()Lkotlin/jvm/functions/Function2;", "getBoolEnvSetting$annotations", "()V", "", "intEnvSetting", "getIntEnvSetting", "getIntEnvSetting$annotations", "", "longEnvSetting", "getLongEnvSetting", "getLongEnvSetting$annotations", "strEnvSetting", "getStrEnvSetting", "getStrEnvSetting$annotations", "Laws/smithy/kotlin/runtime/InternalApi;", "EnvSettingFactory", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EnvironmentSettingKt {
    private static final Function2<String, String, EnvironmentSetting<Boolean>> boolEnvSetting = EnvironmentSetting.INSTANCE.invoke(EnvironmentSettingKt$boolEnvSetting$1.INSTANCE);
    private static final Function2<String, String, EnvironmentSetting<Integer>> intEnvSetting = EnvironmentSetting.INSTANCE.invoke(EnvironmentSettingKt$intEnvSetting$1.INSTANCE);
    private static final Function2<String, String, EnvironmentSetting<Long>> longEnvSetting = EnvironmentSetting.INSTANCE.invoke(EnvironmentSettingKt$longEnvSetting$1.INSTANCE);
    private static final Function2<String, String, EnvironmentSetting<String>> strEnvSetting = EnvironmentSetting.INSTANCE.invoke(new Function1() { // from class: aws.smithy.kotlin.runtime.config.EnvironmentSettingKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return EnvironmentSettingKt.strEnvSetting$lambda$0((String) obj);
        }
    });

    @InternalApi
    public static /* synthetic */ void EnvSettingFactory$annotations() {
    }

    @InternalApi
    public static /* synthetic */ void getBoolEnvSetting$annotations() {
    }

    @InternalApi
    public static /* synthetic */ void getIntEnvSetting$annotations() {
    }

    @InternalApi
    public static /* synthetic */ void getLongEnvSetting$annotations() {
    }

    @InternalApi
    public static /* synthetic */ void getStrEnvSetting$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String strEnvSetting$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    public static /* synthetic */ Object resolve$default(EnvironmentSetting environmentSetting, PlatformEnvironProvider platformEnvironProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            platformEnvironProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return resolve(environmentSetting, platformEnvironProvider);
    }

    @InternalApi
    public static final <T> T resolve(EnvironmentSetting<T> environmentSetting, PlatformEnvironProvider platform) {
        T tInvoke;
        Intrinsics.checkNotNullParameter(environmentSetting, "<this>");
        Intrinsics.checkNotNullParameter(platform, "platform");
        String property = platform.getProperty(environmentSetting.getSysProp());
        if (property == null) {
            property = platform.getenv(environmentSetting.getEnvVar());
        }
        return (property == null || (tInvoke = environmentSetting.getParse().invoke(property)) == null) ? environmentSetting.getDefaultValue() : tInvoke;
    }

    public static final Function2<String, String, EnvironmentSetting<Boolean>> getBoolEnvSetting() {
        return boolEnvSetting;
    }

    public static final Function2<String, String, EnvironmentSetting<Integer>> getIntEnvSetting() {
        return intEnvSetting;
    }

    public static final Function2<String, String, EnvironmentSetting<Long>> getLongEnvSetting() {
        return longEnvSetting;
    }

    public static final Function2<String, String, EnvironmentSetting<String>> getStrEnvSetting() {
        return strEnvSetting;
    }

    @InternalApi
    public static final /* synthetic */ <T extends Enum<T>> EnvironmentSetting<T> enumEnvSetting(String sysProp, String envVar) {
        Intrinsics.checkNotNullParameter(sysProp, "sysProp");
        Intrinsics.checkNotNullParameter(envVar, "envVar");
        Intrinsics.needClassReification();
        return new EnvironmentSetting<>(EnvironmentSettingKt$enumEnvSetting$parse$1.INSTANCE, sysProp, envVar, null, 8, null);
    }

    @InternalApi
    public static final <T> CaseInsensitiveEnvironmentSetting<T> withCaseInsensitiveSuffixes(EnvironmentSetting<T> environmentSetting, String sysPropSuffix, String envVarSuffix) {
        Intrinsics.checkNotNullParameter(environmentSetting, "<this>");
        Intrinsics.checkNotNullParameter(sysPropSuffix, "sysPropSuffix");
        Intrinsics.checkNotNullParameter(envVarSuffix, "envVarSuffix");
        return new CaseInsensitiveEnvironmentSetting<>(environmentSetting.getParse(), environmentSetting.getSysProp(), sysPropSuffix, environmentSetting.getEnvVar(), envVarSuffix, environmentSetting.getDefaultValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Regex caseInsensitiveRegex(String str, String str2) {
        return new Regex("^" + Regex.INSTANCE.escape(str) + "(?i)" + Regex.INSTANCE.escape(str2) + Typography.dollar);
    }

    public static /* synthetic */ Object resolve$default(CaseInsensitiveEnvironmentSetting caseInsensitiveEnvironmentSetting, PlatformEnvironProvider platformEnvironProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            platformEnvironProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return resolve(caseInsensitiveEnvironmentSetting, platformEnvironProvider);
    }

    @InternalApi
    public static final <T> T resolve(CaseInsensitiveEnvironmentSetting<T> caseInsensitiveEnvironmentSetting, PlatformEnvironProvider platform) {
        T tInvoke;
        Intrinsics.checkNotNullParameter(caseInsensitiveEnvironmentSetting, "<this>");
        Intrinsics.checkNotNullParameter(platform, "platform");
        String strResolveStringValue = resolveStringValue(platform.getAllProperties(), caseInsensitiveEnvironmentSetting.getSysPropRegex$runtime_core());
        if (strResolveStringValue == null) {
            strResolveStringValue = resolveStringValue(platform.getAllEnvVars(), caseInsensitiveEnvironmentSetting.getEnvVarRegex$runtime_core());
        }
        return (strResolveStringValue == null || (tInvoke = caseInsensitiveEnvironmentSetting.getParse().invoke(strResolveStringValue)) == null) ? caseInsensitiveEnvironmentSetting.getDefaultValue() : tInvoke;
    }

    private static final String resolveStringValue(Map<String, String> map, Regex regex) {
        String str;
        Iterator<T> it = map.entrySet().iterator();
        do {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (regex.matches(str2)) {
                str = str3;
            }
        } while (str == null);
        return str;
    }

    public static /* synthetic */ MultipleKeyEnvironmentSetting withAdditionalKeys$default(EnvironmentSetting environmentSetting, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            list2 = null;
        }
        return withAdditionalKeys(environmentSetting, list, list2);
    }

    @InternalApi
    public static final <T> MultipleKeyEnvironmentSetting<T> withAdditionalKeys(EnvironmentSetting<T> environmentSetting, List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(environmentSetting, "<this>");
        if (list == null && list2 == null) {
            throw new IllegalArgumentException("Expected either sysProps or envVars (or both) to be non-null");
        }
        Function1<String, T> parse = environmentSetting.getParse();
        List listListOf = CollectionsKt.listOf(environmentSetting.getSysProp());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List listPlus = CollectionsKt.plus((Collection) listListOf, (Iterable) list);
        List listListOf2 = CollectionsKt.listOf(environmentSetting.getEnvVar());
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        return new MultipleKeyEnvironmentSetting<>(parse, listPlus, CollectionsKt.plus((Collection) listListOf2, (Iterable) list2), environmentSetting.getDefaultValue());
    }

    public static /* synthetic */ Object resolve$default(MultipleKeyEnvironmentSetting multipleKeyEnvironmentSetting, PlatformEnvironProvider platformEnvironProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            platformEnvironProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return resolve(multipleKeyEnvironmentSetting, platformEnvironProvider);
    }

    @InternalApi
    public static final <T> T resolve(MultipleKeyEnvironmentSetting<T> multipleKeyEnvironmentSetting, PlatformEnvironProvider platform) {
        String str;
        String property;
        T tInvoke;
        Intrinsics.checkNotNullParameter(multipleKeyEnvironmentSetting, "<this>");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Iterator<T> it = multipleKeyEnvironmentSetting.getSysProps().iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                property = null;
                break;
            }
            property = platform.getProperty((String) it.next());
            if (property != null) {
                break;
            }
        }
        if (property != null) {
            str = property;
            break;
        }
        Iterator<T> it2 = multipleKeyEnvironmentSetting.getEnvVars().iterator();
        while (it2.hasNext()) {
            property = platform.getenv((String) it2.next());
            if (property != null) {
                str = property;
                break;
            }
        }
        return (str == null || (tInvoke = multipleKeyEnvironmentSetting.getParse().invoke(str)) == null) ? multipleKeyEnvironmentSetting.getDefaultValue() : tInvoke;
    }
}
