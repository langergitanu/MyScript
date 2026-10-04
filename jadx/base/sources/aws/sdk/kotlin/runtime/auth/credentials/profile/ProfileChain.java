package aws.sdk.kotlin.runtime.auth.credentials.profile;

import aws.sdk.kotlin.runtime.auth.credentials.ProviderConfigurationException;
import aws.sdk.kotlin.runtime.auth.credentials.profile.NextProfile;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfileChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/ProfileChain;", "", "leaf", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "roles", "", "Laws/sdk/kotlin/runtime/auth/credentials/profile/RoleArn;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;Ljava/util/List;)V", "getLeaf", "()Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "getRoles", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ProfileChain {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LeafProvider leaf;
    private final List<RoleArn> roles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileChain copy$default(ProfileChain profileChain, LeafProvider leafProvider, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            leafProvider = profileChain.leaf;
        }
        if ((i & 2) != 0) {
            list = profileChain.roles;
        }
        return profileChain.copy(leafProvider, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LeafProvider getLeaf() {
        return this.leaf;
    }

    public final List<RoleArn> component2() {
        return this.roles;
    }

    public final ProfileChain copy(LeafProvider leaf, List<RoleArn> roles) {
        Intrinsics.checkNotNullParameter(leaf, "leaf");
        Intrinsics.checkNotNullParameter(roles, "roles");
        return new ProfileChain(leaf, roles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileChain)) {
            return false;
        }
        ProfileChain profileChain = (ProfileChain) other;
        return Intrinsics.areEqual(this.leaf, profileChain.leaf) && Intrinsics.areEqual(this.roles, profileChain.roles);
    }

    public int hashCode() {
        return (this.leaf.hashCode() * 31) + this.roles.hashCode();
    }

    public String toString() {
        return "ProfileChain(leaf=" + this.leaf + ", roles=" + this.roles + ')';
    }

    public ProfileChain(LeafProvider leaf, List<RoleArn> roles) {
        Intrinsics.checkNotNullParameter(leaf, "leaf");
        Intrinsics.checkNotNullParameter(roles, "roles");
        this.leaf = leaf;
        this.roles = roles;
    }

    public final LeafProvider getLeaf() {
        return this.leaf;
    }

    public final List<RoleArn> getRoles() {
        return this.roles;
    }

    /* JADX INFO: compiled from: ProfileChain.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/ProfileChain$Companion;", "", "<init>", "()V", "resolve", "Laws/sdk/kotlin/runtime/auth/credentials/profile/ProfileChain;", "config", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "resolve$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x009d, code lost:
        
            kotlin.collections.CollectionsKt.reverse(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00a2, code lost:
        
            if (r3 == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a7, code lost:
        
            return new aws.sdk.kotlin.runtime.auth.credentials.profile.ProfileChain(r3, r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b3, code lost:
        
            throw new java.lang.IllegalStateException("Required value was null.".toString());
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ProfileChain resolve$aws_config(AwsSharedConfig config) {
            String str;
            Intrinsics.checkNotNullParameter(config, "config");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            ArrayList arrayList = new ArrayList();
            String name = config.getActiveProfile().getName();
            while (true) {
                ConfigSection configSection = config.getProfiles().get(name);
                if (configSection == null) {
                    if (linkedHashSet.isEmpty()) {
                        str = "could not find source profile " + name;
                    } else {
                        str = "could not find source profile " + name + " referenced from " + ((String) CollectionsKt.last(linkedHashSet));
                    }
                    throw new ProviderConfigurationException(str, null, 2, null);
                }
                if (linkedHashSet.add(name)) {
                    LeafProvider leafProviderStaticCredsOrNull = ProfileChainKt.staticCredsOrNull(configSection);
                    if (leafProviderStaticCredsOrNull == null) {
                        RoleArn roleArnRoleArnOrNull = ProfileChainKt.roleArnOrNull(configSection);
                        if (roleArnRoleArnOrNull == null) {
                            leafProviderStaticCredsOrNull = ProfileChainKt.leafProvider(configSection, config);
                            break;
                        }
                        arrayList.add(roleArnRoleArnOrNull);
                        NextProfile nextProfileChainProvider = ProfileChainKt.chainProvider(configSection);
                        if (nextProfileChainProvider instanceof NextProfile.SelfReference) {
                            leafProviderStaticCredsOrNull = ProfileChainKt.leafProvider(configSection, config);
                            break;
                        }
                        if (!(nextProfileChainProvider instanceof NextProfile.Named)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        name = ((NextProfile.Named) nextProfileChainProvider).getName();
                    } else {
                        break;
                    }
                } else {
                    throw new ProviderConfigurationException("profile formed an infinite loop: " + CollectionsKt.joinToString$default(linkedHashSet, " -> ", null, null, 0, null, null, 62, null) + " -> " + name, null, 2, null);
                }
            }
        }
    }
}
