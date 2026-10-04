package aws.smithy.kotlin.runtime.config;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnvironmentSetting.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BC\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JX\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u00020\u0019HÖ\u0081\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u0004HÖ\u0081\u0004¢\u0006\u0004\b\u001c\u0010\u001dR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\u000fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b\"\u0010\u000fR\u0019\u0010\t\u001a\u0004\u0018\u00018\u00008\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010\u0012¨\u0006%"}, m1599d2 = {"Laws/smithy/kotlin/runtime/config/MultipleKeyEnvironmentSetting;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/Function1;", "", "parse", "", "sysProps", "envVars", "defaultValue", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/util/List;Ljava/util/List;Ljava/lang/Object;)V", "component1", "()Lkotlin/jvm/functions/Function1;", "component2", "()Ljava/util/List;", "component3", "component4", "()Ljava/lang/Object;", "copy", "(Lkotlin/jvm/functions/Function1;Ljava/util/List;Ljava/util/List;Ljava/lang/Object;)Laws/smithy/kotlin/runtime/config/MultipleKeyEnvironmentSetting;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "getParse", "Ljava/util/List;", "getSysProps", "getEnvVars", "Ljava/lang/Object;", "getDefaultValue", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class MultipleKeyEnvironmentSetting<T> {
    private final T defaultValue;
    private final List<String> envVars;
    private final Function1<String, T> parse;
    private final List<String> sysProps;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultipleKeyEnvironmentSetting copy$default(MultipleKeyEnvironmentSetting multipleKeyEnvironmentSetting, Function1 function1, List list, List list2, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = multipleKeyEnvironmentSetting.parse;
        }
        if ((i & 2) != 0) {
            list = multipleKeyEnvironmentSetting.sysProps;
        }
        if ((i & 4) != 0) {
            list2 = multipleKeyEnvironmentSetting.envVars;
        }
        if ((i & 8) != 0) {
            obj = multipleKeyEnvironmentSetting.defaultValue;
        }
        return multipleKeyEnvironmentSetting.copy(function1, list, list2, obj);
    }

    public final Function1<String, T> component1() {
        return this.parse;
    }

    public final List<String> component2() {
        return this.sysProps;
    }

    public final List<String> component3() {
        return this.envVars;
    }

    public final T component4() {
        return this.defaultValue;
    }

    public final MultipleKeyEnvironmentSetting<T> copy(Function1<? super String, ? extends T> parse, List<String> sysProps, List<String> envVars, T defaultValue) {
        Intrinsics.checkNotNullParameter(parse, "parse");
        Intrinsics.checkNotNullParameter(sysProps, "sysProps");
        Intrinsics.checkNotNullParameter(envVars, "envVars");
        return new MultipleKeyEnvironmentSetting<>(parse, sysProps, envVars, defaultValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultipleKeyEnvironmentSetting)) {
            return false;
        }
        MultipleKeyEnvironmentSetting multipleKeyEnvironmentSetting = (MultipleKeyEnvironmentSetting) other;
        return Intrinsics.areEqual(this.parse, multipleKeyEnvironmentSetting.parse) && Intrinsics.areEqual(this.sysProps, multipleKeyEnvironmentSetting.sysProps) && Intrinsics.areEqual(this.envVars, multipleKeyEnvironmentSetting.envVars) && Intrinsics.areEqual(this.defaultValue, multipleKeyEnvironmentSetting.defaultValue);
    }

    public int hashCode() {
        int iHashCode = ((((this.parse.hashCode() * 31) + this.sysProps.hashCode()) * 31) + this.envVars.hashCode()) * 31;
        T t = this.defaultValue;
        return iHashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "MultipleKeyEnvironmentSetting(parse=" + this.parse + ", sysProps=" + this.sysProps + ", envVars=" + this.envVars + ", defaultValue=" + this.defaultValue + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultipleKeyEnvironmentSetting(Function1<? super String, ? extends T> parse, List<String> sysProps, List<String> envVars, T t) {
        Intrinsics.checkNotNullParameter(parse, "parse");
        Intrinsics.checkNotNullParameter(sysProps, "sysProps");
        Intrinsics.checkNotNullParameter(envVars, "envVars");
        this.parse = parse;
        this.sysProps = sysProps;
        this.envVars = envVars;
        this.defaultValue = t;
    }

    public /* synthetic */ MultipleKeyEnvironmentSetting(Function1 function1, List list, List list2, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, list, list2, (i & 8) != 0 ? null : obj);
    }

    public final Function1<String, T> getParse() {
        return this.parse;
    }

    public final List<String> getSysProps() {
        return this.sysProps;
    }

    public final List<String> getEnvVars() {
        return this.envVars;
    }

    public final T getDefaultValue() {
        return this.defaultValue;
    }
}
