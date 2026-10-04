package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.PolicyDescriptorType;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.Tag;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: StsAssumeRoleCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u001c\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u001c\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001b¨\u0006)"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/AssumeRoleParameters;", "", "roleArn", "", "roleSessionName", "externalId", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "policyArns", "", "policy", "tags", "", "transitiveTagKeys", "serialNumber", "tokenCode", "sourceIdentity", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRoleArn", "()Ljava/lang/String;", "getRoleSessionName", "getExternalId", "getDuration-UwyO8pc", "()J", "J", "getPolicyArns", "()Ljava/util/List;", "getPolicy", "getTags", "()Ljava/util/Map;", "getTransitiveTagKeys", "getSerialNumber", "getTokenCode", "getSourceIdentity", "convertedPolicyArns", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/PolicyDescriptorType;", "getConvertedPolicyArns$aws_config", "convertedTags", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/Tag;", "getConvertedTags$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AssumeRoleParameters {
    private final List<PolicyDescriptorType> convertedPolicyArns;
    private final List<Tag> convertedTags;
    private final long duration;
    private final String externalId;
    private final String policy;
    private final List<String> policyArns;
    private final String roleArn;
    private final String roleSessionName;
    private final String serialNumber;
    private final String sourceIdentity;
    private final Map<String, String> tags;
    private final String tokenCode;
    private final List<String> transitiveTagKeys;

    public /* synthetic */ AssumeRoleParameters(String str, String str2, String str3, long j, List list, String str4, Map map, List list2, String str5, String str6, String str7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, list, str4, map, list2, str5, str6, str7);
    }

    private AssumeRoleParameters(String roleArn, String str, String str2, long j, List<String> list, String str3, Map<String, String> map, List<String> list2, String str4, String str5, String str6) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(roleArn, "roleArn");
        this.roleArn = roleArn;
        this.roleSessionName = str;
        this.externalId = str2;
        this.duration = j;
        this.policyArns = list;
        this.policy = str3;
        this.tags = map;
        this.transitiveTagKeys = list2;
        this.serialNumber = str4;
        this.tokenCode = str5;
        this.sourceIdentity = str6;
        ArrayList arrayList2 = null;
        if (list != null) {
            List<String> list3 = list;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (final String str7 : list3) {
                arrayList3.add(PolicyDescriptorType.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.AssumeRoleParameters$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AssumeRoleParameters.convertedPolicyArns$lambda$0$0(str7, (PolicyDescriptorType.Builder) obj);
                    }
                }));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        this.convertedPolicyArns = arrayList;
        Map<String, String> map2 = this.tags;
        if (map2 != null) {
            ArrayList arrayList4 = new ArrayList(map2.size());
            for (final Map.Entry<String, String> entry : map2.entrySet()) {
                arrayList4.add(Tag.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.AssumeRoleParameters$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AssumeRoleParameters.convertedTags$lambda$0$0(entry, (Tag.Builder) obj);
                    }
                }));
            }
            arrayList2 = arrayList4;
        }
        this.convertedTags = arrayList2;
    }

    public final String getRoleArn() {
        return this.roleArn;
    }

    public final String getRoleSessionName() {
        return this.roleSessionName;
    }

    public final String getExternalId() {
        return this.externalId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AssumeRoleParameters(String str, String str2, String str3, long j, List list, String str4, Map map, List list2, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        String str8 = (i & 2) != 0 ? null : str2;
        String str9 = (i & 4) != 0 ? null : str3;
        if ((i & 8) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(900, DurationUnit.SECONDS);
        } else {
            duration = j;
        }
        this(str, str8, str9, duration, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : map, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, null);
    }

    /* JADX INFO: renamed from: getDuration-UwyO8pc, reason: not valid java name and from getter */
    public final long getDuration() {
        return this.duration;
    }

    public final List<String> getPolicyArns() {
        return this.policyArns;
    }

    public final String getPolicy() {
        return this.policy;
    }

    public final Map<String, String> getTags() {
        return this.tags;
    }

    public final List<String> getTransitiveTagKeys() {
        return this.transitiveTagKeys;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final String getTokenCode() {
        return this.tokenCode;
    }

    public final String getSourceIdentity() {
        return this.sourceIdentity;
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

    public final List<Tag> getConvertedTags$aws_config() {
        return this.convertedTags;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convertedTags$lambda$0$0(Map.Entry entry, Tag.Builder Tag) {
        Intrinsics.checkNotNullParameter(Tag, "$this$Tag");
        Tag.setKey((String) entry.getKey());
        Tag.setValue((String) entry.getValue());
        return Unit.INSTANCE;
    }
}
