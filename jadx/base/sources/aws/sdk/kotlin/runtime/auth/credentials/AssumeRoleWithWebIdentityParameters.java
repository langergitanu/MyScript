package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.PolicyDescriptorType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: StsWebIdentityCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/AssumeRoleWithWebIdentityParameters;", "", "roleArn", "", "webIdentityTokenFilePath", "roleSessionName", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "providerId", "policyArns", "", "policy", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRoleArn", "()Ljava/lang/String;", "getWebIdentityTokenFilePath", "getRoleSessionName", "getDuration-UwyO8pc", "()J", "J", "getProviderId", "getPolicyArns", "()Ljava/util/List;", "getPolicy", "convertedPolicyArns", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/PolicyDescriptorType;", "getConvertedPolicyArns$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AssumeRoleWithWebIdentityParameters {
    private final List<PolicyDescriptorType> convertedPolicyArns;
    private final long duration;
    private final String policy;
    private final List<String> policyArns;
    private final String providerId;
    private final String roleArn;
    private final String roleSessionName;
    private final String webIdentityTokenFilePath;

    public /* synthetic */ AssumeRoleWithWebIdentityParameters(String str, String str2, String str3, long j, String str4, List list, String str5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, str4, list, str5);
    }

    private AssumeRoleWithWebIdentityParameters(String roleArn, String webIdentityTokenFilePath, String str, long j, String str2, List<String> list, String str3) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(roleArn, "roleArn");
        Intrinsics.checkNotNullParameter(webIdentityTokenFilePath, "webIdentityTokenFilePath");
        this.roleArn = roleArn;
        this.webIdentityTokenFilePath = webIdentityTokenFilePath;
        this.roleSessionName = str;
        this.duration = j;
        this.providerId = str2;
        this.policyArns = list;
        this.policy = str3;
        if (list != null) {
            List<String> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (final String str4 : list2) {
                arrayList2.add(PolicyDescriptorType.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.AssumeRoleWithWebIdentityParameters$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AssumeRoleWithWebIdentityParameters.convertedPolicyArns$lambda$0$0(str4, (PolicyDescriptorType.Builder) obj);
                    }
                }));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        this.convertedPolicyArns = arrayList;
    }

    public final String getRoleArn() {
        return this.roleArn;
    }

    public final String getWebIdentityTokenFilePath() {
        return this.webIdentityTokenFilePath;
    }

    public final String getRoleSessionName() {
        return this.roleSessionName;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AssumeRoleWithWebIdentityParameters(String str, String str2, String str3, long j, String str4, List list, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        String str6 = (i & 4) != 0 ? null : str3;
        if ((i & 8) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(900, DurationUnit.SECONDS);
        } else {
            duration = j;
        }
        this(str, str2, str6, duration, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : str5, null);
    }

    /* JADX INFO: renamed from: getDuration-UwyO8pc, reason: not valid java name and from getter */
    public final long getDuration() {
        return this.duration;
    }

    public final String getProviderId() {
        return this.providerId;
    }

    public final List<String> getPolicyArns() {
        return this.policyArns;
    }

    public final String getPolicy() {
        return this.policy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convertedPolicyArns$lambda$0$0(String str, PolicyDescriptorType.Builder PolicyDescriptorType) {
        Intrinsics.checkNotNullParameter(PolicyDescriptorType, "$this$PolicyDescriptorType");
        PolicyDescriptorType.setArn(str);
        return Unit.INSTANCE;
    }

    public final List<PolicyDescriptorType> getConvertedPolicyArns$aws_config() {
        return this.convertedPolicyArns;
    }
}
