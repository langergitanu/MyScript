package aws.smithy.kotlin.runtime.config;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.config.EnvironmentSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnvironmentSetting.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u0000 %*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001%B7\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JL\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u00020\u001aHÖ\u0081\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u0004HÖ\u0081\u0004¢\u0006\u0004\b\u001d\u0010\u0010R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b\"\u0010\u0010R\u0019\u0010\b\u001a\u0004\u0018\u00018\u00008\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010\u0013¨\u0006&"}, m1599d2 = {"Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/Function1;", "", "parse", "sysProp", "envVar", "defaultValue", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "orElse", "(Ljava/lang/Object;)Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "component1", "()Lkotlin/jvm/functions/Function1;", "component2", "()Ljava/lang/String;", "component3", "component4", "()Ljava/lang/Object;", "copy", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lkotlin/jvm/functions/Function1;", "getParse", "Ljava/lang/String;", "getSysProp", "getEnvVar", "Ljava/lang/Object;", "getDefaultValue", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class EnvironmentSetting<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final T defaultValue;
    private final String envVar;
    private final Function1<String, T> parse;
    private final String sysProp;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EnvironmentSetting copy$default(EnvironmentSetting environmentSetting, Function1 function1, String str, String str2, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = environmentSetting.parse;
        }
        if ((i & 2) != 0) {
            str = environmentSetting.sysProp;
        }
        if ((i & 4) != 0) {
            str2 = environmentSetting.envVar;
        }
        if ((i & 8) != 0) {
            obj = environmentSetting.defaultValue;
        }
        return environmentSetting.copy(function1, str, str2, obj);
    }

    public final Function1<String, T> component1() {
        return this.parse;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSysProp() {
        return this.sysProp;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEnvVar() {
        return this.envVar;
    }

    public final T component4() {
        return this.defaultValue;
    }

    public final EnvironmentSetting<T> copy(Function1<? super String, ? extends T> parse, String sysProp, String envVar, T defaultValue) {
        Intrinsics.checkNotNullParameter(parse, "parse");
        Intrinsics.checkNotNullParameter(sysProp, "sysProp");
        Intrinsics.checkNotNullParameter(envVar, "envVar");
        return new EnvironmentSetting<>(parse, sysProp, envVar, defaultValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnvironmentSetting)) {
            return false;
        }
        EnvironmentSetting environmentSetting = (EnvironmentSetting) other;
        return Intrinsics.areEqual(this.parse, environmentSetting.parse) && Intrinsics.areEqual(this.sysProp, environmentSetting.sysProp) && Intrinsics.areEqual(this.envVar, environmentSetting.envVar) && Intrinsics.areEqual(this.defaultValue, environmentSetting.defaultValue);
    }

    public int hashCode() {
        int iHashCode = ((((this.parse.hashCode() * 31) + this.sysProp.hashCode()) * 31) + this.envVar.hashCode()) * 31;
        T t = this.defaultValue;
        return iHashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "EnvironmentSetting(parse=" + this.parse + ", sysProp=" + this.sysProp + ", envVar=" + this.envVar + ", defaultValue=" + this.defaultValue + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnvironmentSetting(Function1<? super String, ? extends T> parse, String sysProp, String envVar, T t) {
        Intrinsics.checkNotNullParameter(parse, "parse");
        Intrinsics.checkNotNullParameter(sysProp, "sysProp");
        Intrinsics.checkNotNullParameter(envVar, "envVar");
        this.parse = parse;
        this.sysProp = sysProp;
        this.envVar = envVar;
        this.defaultValue = t;
    }

    public /* synthetic */ EnvironmentSetting(Function1 function1, String str, String str2, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, str, str2, (i & 8) != 0 ? null : obj);
    }

    public final Function1<String, T> getParse() {
        return this.parse;
    }

    public final String getSysProp() {
        return this.sysProp;
    }

    public final String getEnvVar() {
        return this.envVar;
    }

    public final T getDefaultValue() {
        return this.defaultValue;
    }

    /* JADX INFO: compiled from: EnvironmentSetting.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JL\u0010\u000b\u001a$\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0\bj\b\u0012\u0004\u0012\u00028\u0001`\n\"\u0004\b\u0001\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00010\u0005H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Laws/smithy/kotlin/runtime/config/EnvironmentSetting$Companion;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "", "asTyped", "Lkotlin/Function2;", "Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "Laws/smithy/kotlin/runtime/config/EnvSettingFactory;", "invoke", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function2;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EnvironmentSetting invoke$lambda$0(Function1 function1, String sysProp, String envVar) {
            Intrinsics.checkNotNullParameter(sysProp, "sysProp");
            Intrinsics.checkNotNullParameter(envVar, "envVar");
            return new EnvironmentSetting(function1, sysProp, envVar, null, 8, null);
        }

        public final <T> Function2<String, String, EnvironmentSetting<T>> invoke(final Function1<? super String, ? extends T> asTyped) {
            Intrinsics.checkNotNullParameter(asTyped, "asTyped");
            return new Function2() { // from class: aws.smithy.kotlin.runtime.config.EnvironmentSetting$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EnvironmentSetting.Companion.invoke$lambda$0(asTyped, (String) obj, (String) obj2);
                }
            };
        }
    }

    public final EnvironmentSetting<T> orElse(T defaultValue) {
        return copy$default(this, null, null, null, defaultValue, 7, null);
    }
}
