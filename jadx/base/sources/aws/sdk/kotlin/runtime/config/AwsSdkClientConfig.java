package aws.sdk.kotlin.runtime.config;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.client.region.RegionProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: AwsSdkClientConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0012R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0013À\u0006\u0003"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/AwsSdkClientConfig;", "Laws/smithy/kotlin/runtime/client/SdkClientConfig;", TtmlNode.TAG_REGION, "", "getRegion", "()Ljava/lang/String;", "regionProvider", "Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "getRegionProvider", "()Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "useFips", "", "getUseFips", "()Z", "useDualStack", "getUseDualStack", "applicationId", "getApplicationId", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface AwsSdkClientConfig extends SdkClientConfig {

    /* JADX INFO: compiled from: AwsSdkClientConfig.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007¨\u0006\u001aÀ\u0006\u0003"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/AwsSdkClientConfig$Builder;", "", TtmlNode.TAG_REGION, "", "getRegion", "()Ljava/lang/String;", "setRegion", "(Ljava/lang/String;)V", "regionProvider", "Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "getRegionProvider", "()Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "setRegionProvider", "(Laws/smithy/kotlin/runtime/client/region/RegionProvider;)V", "useFips", "", "getUseFips", "()Ljava/lang/Boolean;", "setUseFips", "(Ljava/lang/Boolean;)V", "useDualStack", "getUseDualStack", "setUseDualStack", "applicationId", "getApplicationId", "setApplicationId", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder {
        String getApplicationId();

        String getRegion();

        RegionProvider getRegionProvider();

        Boolean getUseDualStack();

        Boolean getUseFips();

        void setApplicationId(String str);

        void setRegion(String str);

        void setRegionProvider(RegionProvider regionProvider);

        void setUseDualStack(Boolean bool);

        void setUseFips(Boolean bool);
    }

    String getApplicationId();

    String getRegion();

    RegionProvider getRegionProvider();

    boolean getUseDualStack();

    boolean getUseFips();
}
