package aws.sdk.kotlin.runtime.config.endpoints;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric;
import aws.smithy.kotlin.runtime.businessmetrics.SmithyBusinessMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AccountIdEndpointMode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, m1599d2 = {"toBusinessMetric", "Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;", "Laws/sdk/kotlin/runtime/config/endpoints/AccountIdEndpointMode;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AccountIdEndpointModeKt {

    /* JADX INFO: compiled from: AccountIdEndpointMode.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccountIdEndpointMode.values().length];
            try {
                iArr[AccountIdEndpointMode.PREFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AccountIdEndpointMode.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AccountIdEndpointMode.REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @InternalApi
    public static final BusinessMetric toBusinessMetric(AccountIdEndpointMode accountIdEndpointMode) {
        Intrinsics.checkNotNullParameter(accountIdEndpointMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[accountIdEndpointMode.ordinal()];
        if (i == 1) {
            return SmithyBusinessMetric.ACCOUNT_ID_MODE_PREFERRED;
        }
        if (i == 2) {
            return SmithyBusinessMetric.ACCOUNT_ID_MODE_DISABLED;
        }
        if (i == 3) {
            return SmithyBusinessMetric.ACCOUNT_ID_MODE_REQUIRED;
        }
        throw new IllegalStateException("Unexpected AccountIdEndpointMode value: " + Reflection.getOrCreateKotlinClass(accountIdEndpointMode.getClass()).getSimpleName());
    }
}
