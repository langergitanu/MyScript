package aws.sdk.kotlin.services.p010s3.internal;

import aws.smithy.kotlin.runtime.config.EnvironmentSetting;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.config.MultipleKeyEnvironmentSetting;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: S3Setting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/internal/S3Setting;", "", "<init>", "()V", "UseArnRegion", "Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "", "getUseArnRegion", "()Laws/smithy/kotlin/runtime/config/EnvironmentSetting;", "DisableMultiRegionAccessPoints", "getDisableMultiRegionAccessPoints", "DisableS3ExpressSessionAuth", "Laws/smithy/kotlin/runtime/config/MultipleKeyEnvironmentSetting;", "getDisableS3ExpressSessionAuth", "()Laws/smithy/kotlin/runtime/config/MultipleKeyEnvironmentSetting;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3Setting {
    public static final S3Setting INSTANCE = new S3Setting();
    private static final EnvironmentSetting<Boolean> UseArnRegion = EnvironmentSettingKt.getBoolEnvSetting().invoke("aws.s3UseArnRegion", "AWS_S3_USE_ARN_REGION");
    private static final EnvironmentSetting<Boolean> DisableMultiRegionAccessPoints = EnvironmentSettingKt.getBoolEnvSetting().invoke("aws.s3DisableMultiRegionAccessPoints", "AWS_S3_DISABLE_MULTIREGION_ACCESS_POINTS");
    private static final MultipleKeyEnvironmentSetting<Boolean> DisableS3ExpressSessionAuth = EnvironmentSettingKt.withAdditionalKeys$default(EnvironmentSettingKt.getBoolEnvSetting().invoke("aws.s3DisableExpressSessionAuth", "AWS_S3_DISABLE_EXPRESS_SESSION_AUTH"), CollectionsKt.listOf("aws.disableS3ExpressAuth"), null, 2, null);

    private S3Setting() {
    }

    public final EnvironmentSetting<Boolean> getUseArnRegion() {
        return UseArnRegion;
    }

    public final EnvironmentSetting<Boolean> getDisableMultiRegionAccessPoints() {
        return DisableMultiRegionAccessPoints;
    }

    public final MultipleKeyEnvironmentSetting<Boolean> getDisableS3ExpressSessionAuth() {
        return DisableS3ExpressSessionAuth;
    }
}
