package aws.smithy.kotlin.runtime.auth.awscredentials;

import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: SigV4aClientConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0007R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/SigV4aClientConfig;", "", "", "", "getSigV4aSigningRegionSet", "()Ljava/util/Set;", "sigV4aSigningRegionSet", "Builder", "aws-credentials"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SigV4aClientConfig {

    /* JADX INFO: compiled from: SigV4aClientConfig.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/SigV4aClientConfig$Builder;", "", "", "", "getSigV4aSigningRegionSet", "()Ljava/util/Set;", "setSigV4aSigningRegionSet", "(Ljava/util/Set;)V", "sigV4aSigningRegionSet", "aws-credentials"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder {
        Set<String> getSigV4aSigningRegionSet();

        void setSigV4aSigningRegionSet(Set<String> set);
    }

    Set<String> getSigV4aSigningRegionSet();
}
