package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.revenuecat.purchases.common.CustomVariableKeyValidator;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointParams.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointParams;", "", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Ljava/util/Map;)V", "getCustomVariables", "()Ljava/util/Map;", "equals", "", "other", "hashCode", "", "toString", "Builder", "CustomVariablesBuilder", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointParams {
    public static final int $stable = 8;
    private final Map<String, CustomVariableValue> customVariables;

    public /* synthetic */ CheckpointParams(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    private CheckpointParams(Map<String, ? extends CustomVariableValue> map) {
        this.customVariables = CustomVariableKeyValidator.INSTANCE.validateAndFilter(map);
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }

    public boolean equals(Object other) {
        return (other instanceof CheckpointParams) && Intrinsics.areEqual(((CheckpointParams) other).customVariables, this.customVariables);
    }

    public int hashCode() {
        return this.customVariables.hashCode();
    }

    public String toString() {
        return "CheckpointParams(customVariables=" + this.customVariables + ')';
    }

    /* JADX INFO: compiled from: CheckpointParams.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u001f\u0010\u0003\u001a\u00020\u00002\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rJ\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointParams$Builder;", "", "()V", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "build", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointParams;", "block", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointParams$CustomVariablesBuilder;", "", "Lkotlin/ExtensionFunctionType;", "setCustomVariables", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @CheckpointParamsDsl
    public static final class Builder {
        public static final int $stable = 8;
        private Map<String, ? extends CustomVariableValue> customVariables = MapsKt.emptyMap();

        public final Builder setCustomVariables(Map<String, ? extends CustomVariableValue> customVariables) {
            Intrinsics.checkNotNullParameter(customVariables, "customVariables");
            this.customVariables = customVariables;
            return this;
        }

        public final /* synthetic */ Builder customVariables(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            CustomVariablesBuilder customVariablesBuilder = new CustomVariablesBuilder();
            block.invoke(customVariablesBuilder);
            this.customVariables = customVariablesBuilder.build();
            return this;
        }

        public final CheckpointParams build() {
            return new CheckpointParams(this.customVariables, null);
        }
    }

    /* JADX INFO: compiled from: CheckpointParams.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000bJ\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\fJ\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\rJ\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000eJ\u0016\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0010J\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0006H\u0086\u0004J\u0017\u0010\u0011\u001a\u00020\u0012*\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0087\u0004J\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0086\u0004J\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00052\u0006\u0010\t\u001a\u00020\u000bH\u0086\u0004J\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00052\u0006\u0010\t\u001a\u00020\fH\u0086\u0004J\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00052\u0006\u0010\t\u001a\u00020\rH\u0086\u0004J\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00052\u0006\u0010\t\u001a\u00020\u000eH\u0086\u0004J\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0086\u0004R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointParams$CustomVariablesBuilder;", "", "()V", "customVariables", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "add", SubscriberAttributeKt.JSON_NAME_KEY, "value", "", "", "", "", "", "build", "", TypedValues.TransitionType.S_TO, "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    @CheckpointParamsDsl
    public static final class CustomVariablesBuilder {
        public static final int $stable = 8;
        private final Map<String, CustomVariableValue> customVariables = new LinkedHashMap();

        public final CustomVariablesBuilder add(String key, CustomVariableValue value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.customVariables.put(key, value);
            return this;
        }

        public final CustomVariablesBuilder add(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return add(key, new CustomVariableValue.String(value));
        }

        public final CustomVariablesBuilder add(String key, int value) {
            Intrinsics.checkNotNullParameter(key, "key");
            return add(key, new CustomVariableValue.Number(value));
        }

        public final CustomVariablesBuilder add(String key, long value) {
            Intrinsics.checkNotNullParameter(key, "key");
            return add(key, new CustomVariableValue.Number(value));
        }

        public final CustomVariablesBuilder add(String key, double value) {
            Intrinsics.checkNotNullParameter(key, "key");
            return add(key, new CustomVariableValue.Number(value));
        }

        public final CustomVariablesBuilder add(String key, float value) {
            Intrinsics.checkNotNullParameter(key, "key");
            return add(key, new CustomVariableValue.Number(value));
        }

        public final CustomVariablesBuilder add(String key, boolean value) {
            Intrinsics.checkNotNullParameter(key, "key");
            return add(key, new CustomVariableValue.Boolean(value));
        }

        /* JADX INFO: renamed from: to */
        public final /* synthetic */ void m1557to(String str, CustomVariableValue value) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            add(str, value);
        }

        /* JADX INFO: renamed from: to */
        public final /* synthetic */ void m1559to(String str, String value) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            add(str, value);
        }

        /* JADX INFO: renamed from: to */
        public final /* synthetic */ void m1555to(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            add(str, i);
        }

        /* JADX INFO: renamed from: to */
        public final /* synthetic */ void m1556to(String str, long j) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            add(str, j);
        }

        /* JADX INFO: renamed from: to */
        public final /* synthetic */ void m1553to(String str, double d) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            add(str, d);
        }

        /* JADX INFO: renamed from: to */
        public final /* synthetic */ void m1554to(String str, float f) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            add(str, f);
        }

        /* JADX INFO: renamed from: to */
        public final /* synthetic */ void m1560to(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            add(str, z);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Unsupported custom variable type. Supported types: String, Int, Long, Double, Float, Boolean and CustomVariableValue. If you really need a Pair here, use Pair(first, second).")
        /* JADX INFO: renamed from: to */
        public final /* synthetic */ void m1558to(String str, Object obj) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            throw new UnsupportedOperationException("Unsupported custom variable type: " + obj);
        }

        public final Map<String, CustomVariableValue> build() {
            return MapsKt.toMap(this.customVariables);
        }
    }
}
