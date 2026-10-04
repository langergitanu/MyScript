package aws.smithy.kotlin.runtime.config;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: EnvironmentSetting.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BG\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0010J\u0012\u0010\u0014\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J`\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001d\u001a\u00020\u001cHÖ\u0081\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u001f\u001a\u00020\u0004HÖ\u0081\u0004¢\u0006\u0004\b\u001f\u0010\u0010R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b$\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b%\u0010\u0010R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b&\u0010\u0010R\u0019\u0010\n\u001a\u0004\u0018\u00018\u00008\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010\u0015R\u001a\u0010*\u001a\u00020)8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020)8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-¨\u00060"}, m1599d2 = {"Laws/smithy/kotlin/runtime/config/CaseInsensitiveEnvironmentSetting;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/Function1;", "", "parse", "sysPropBase", "sysPropSuffix", "envVarBase", "envVarSuffix", "defaultValue", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "component1", "()Lkotlin/jvm/functions/Function1;", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "()Ljava/lang/Object;", "copy", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Laws/smithy/kotlin/runtime/config/CaseInsensitiveEnvironmentSetting;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lkotlin/jvm/functions/Function1;", "getParse", "Ljava/lang/String;", "getSysPropBase", "getSysPropSuffix", "getEnvVarBase", "getEnvVarSuffix", "Ljava/lang/Object;", "getDefaultValue", "Lkotlin/text/Regex;", "sysPropRegex", "Lkotlin/text/Regex;", "getSysPropRegex$runtime_core", "()Lkotlin/text/Regex;", "envVarRegex", "getEnvVarRegex$runtime_core", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class CaseInsensitiveEnvironmentSetting<T> {
    private final T defaultValue;
    private final String envVarBase;
    private final Regex envVarRegex;
    private final String envVarSuffix;
    private final Function1<String, T> parse;
    private final String sysPropBase;
    private final Regex sysPropRegex;
    private final String sysPropSuffix;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CaseInsensitiveEnvironmentSetting copy$default(CaseInsensitiveEnvironmentSetting caseInsensitiveEnvironmentSetting, Function1 function1, String str, String str2, String str3, String str4, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = caseInsensitiveEnvironmentSetting.parse;
        }
        if ((i & 2) != 0) {
            str = caseInsensitiveEnvironmentSetting.sysPropBase;
        }
        if ((i & 4) != 0) {
            str2 = caseInsensitiveEnvironmentSetting.sysPropSuffix;
        }
        if ((i & 8) != 0) {
            str3 = caseInsensitiveEnvironmentSetting.envVarBase;
        }
        if ((i & 16) != 0) {
            str4 = caseInsensitiveEnvironmentSetting.envVarSuffix;
        }
        if ((i & 32) != 0) {
            obj = caseInsensitiveEnvironmentSetting.defaultValue;
        }
        String str5 = str4;
        Object obj3 = obj;
        return caseInsensitiveEnvironmentSetting.copy(function1, str, str2, str3, str5, obj3);
    }

    public final Function1<String, T> component1() {
        return this.parse;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSysPropBase() {
        return this.sysPropBase;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSysPropSuffix() {
        return this.sysPropSuffix;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEnvVarBase() {
        return this.envVarBase;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEnvVarSuffix() {
        return this.envVarSuffix;
    }

    public final T component6() {
        return this.defaultValue;
    }

    public final CaseInsensitiveEnvironmentSetting<T> copy(Function1<? super String, ? extends T> parse, String sysPropBase, String sysPropSuffix, String envVarBase, String envVarSuffix, T defaultValue) {
        Intrinsics.checkNotNullParameter(parse, "parse");
        Intrinsics.checkNotNullParameter(sysPropBase, "sysPropBase");
        Intrinsics.checkNotNullParameter(sysPropSuffix, "sysPropSuffix");
        Intrinsics.checkNotNullParameter(envVarBase, "envVarBase");
        Intrinsics.checkNotNullParameter(envVarSuffix, "envVarSuffix");
        return new CaseInsensitiveEnvironmentSetting<>(parse, sysPropBase, sysPropSuffix, envVarBase, envVarSuffix, defaultValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaseInsensitiveEnvironmentSetting)) {
            return false;
        }
        CaseInsensitiveEnvironmentSetting caseInsensitiveEnvironmentSetting = (CaseInsensitiveEnvironmentSetting) other;
        return Intrinsics.areEqual(this.parse, caseInsensitiveEnvironmentSetting.parse) && Intrinsics.areEqual(this.sysPropBase, caseInsensitiveEnvironmentSetting.sysPropBase) && Intrinsics.areEqual(this.sysPropSuffix, caseInsensitiveEnvironmentSetting.sysPropSuffix) && Intrinsics.areEqual(this.envVarBase, caseInsensitiveEnvironmentSetting.envVarBase) && Intrinsics.areEqual(this.envVarSuffix, caseInsensitiveEnvironmentSetting.envVarSuffix) && Intrinsics.areEqual(this.defaultValue, caseInsensitiveEnvironmentSetting.defaultValue);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.parse.hashCode() * 31) + this.sysPropBase.hashCode()) * 31) + this.sysPropSuffix.hashCode()) * 31) + this.envVarBase.hashCode()) * 31) + this.envVarSuffix.hashCode()) * 31;
        T t = this.defaultValue;
        return iHashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "CaseInsensitiveEnvironmentSetting(parse=" + this.parse + ", sysPropBase=" + this.sysPropBase + ", sysPropSuffix=" + this.sysPropSuffix + ", envVarBase=" + this.envVarBase + ", envVarSuffix=" + this.envVarSuffix + ", defaultValue=" + this.defaultValue + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CaseInsensitiveEnvironmentSetting(Function1<? super String, ? extends T> parse, String sysPropBase, String sysPropSuffix, String envVarBase, String envVarSuffix, T t) {
        Intrinsics.checkNotNullParameter(parse, "parse");
        Intrinsics.checkNotNullParameter(sysPropBase, "sysPropBase");
        Intrinsics.checkNotNullParameter(sysPropSuffix, "sysPropSuffix");
        Intrinsics.checkNotNullParameter(envVarBase, "envVarBase");
        Intrinsics.checkNotNullParameter(envVarSuffix, "envVarSuffix");
        this.parse = parse;
        this.sysPropBase = sysPropBase;
        this.sysPropSuffix = sysPropSuffix;
        this.envVarBase = envVarBase;
        this.envVarSuffix = envVarSuffix;
        this.defaultValue = t;
        this.sysPropRegex = EnvironmentSettingKt.caseInsensitiveRegex(sysPropBase, sysPropSuffix);
        this.envVarRegex = EnvironmentSettingKt.caseInsensitiveRegex(envVarBase, envVarSuffix);
    }

    public /* synthetic */ CaseInsensitiveEnvironmentSetting(Function1 function1, String str, String str2, String str3, String str4, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, str, str2, str3, str4, (i & 32) != 0 ? null : obj);
    }

    public final Function1<String, T> getParse() {
        return this.parse;
    }

    public final String getSysPropBase() {
        return this.sysPropBase;
    }

    public final String getSysPropSuffix() {
        return this.sysPropSuffix;
    }

    public final String getEnvVarBase() {
        return this.envVarBase;
    }

    public final String getEnvVarSuffix() {
        return this.envVarSuffix;
    }

    public final T getDefaultValue() {
        return this.defaultValue;
    }

    /* JADX INFO: renamed from: getSysPropRegex$runtime_core, reason: from getter */
    public final Regex getSysPropRegex() {
        return this.sysPropRegex;
    }

    /* JADX INFO: renamed from: getEnvVarRegex$runtime_core, reason: from getter */
    public final Regex getEnvVarRegex() {
        return this.envVarRegex;
    }
}
