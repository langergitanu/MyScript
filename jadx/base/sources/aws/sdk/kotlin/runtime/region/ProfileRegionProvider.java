package aws.sdk.kotlin.runtime.region;

import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.sdk.kotlin.runtime.config.profile.AwsProfileKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.client.region.RegionProvider;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfileRegionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0002\u0010\fR\u0018\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Laws/sdk/kotlin/runtime/region/ProfileRegionProvider;", "Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "profile", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "<init>", "(Laws/smithy/kotlin/runtime/util/LazyAsyncValue;)V", "profileName", "", "(Ljava/lang/String;)V", "getRegion", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ProfileRegionProvider implements RegionProvider {
    private final LazyAsyncValue<ConfigSection> profile;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.region.ProfileRegionProvider$getRegion$1 */
    /* JADX INFO: compiled from: ProfileRegionProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.region.ProfileRegionProvider", m1609f = "ProfileRegionProvider.kt", m1610i = {}, m1611l = {27}, m1612m = "getRegion", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C31331 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C31331(Continuation<? super C31331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileRegionProvider.this.getRegion(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileRegionProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.region.ProfileRegionProvider$1 */
    /* JADX INFO: compiled from: ProfileRegionProvider.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.region.ProfileRegionProvider$1", m1609f = "ProfileRegionProvider.kt", m1610i = {}, m1611l = {20}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C31311 extends SuspendLambda implements Function1<Continuation<? super ConfigSection>, Object> {
        int label;

        C31311(Continuation<? super C31311> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C31311(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ConfigSection> continuation) {
            return ((C31311) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AwsConfigLoaderKt.loadAwsSharedConfig$default(PlatformProvider.INSTANCE.getSystem(), null, null, this, 6, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((AwsSharedConfig) obj).getActiveProfile();
        }
    }

    public ProfileRegionProvider(LazyAsyncValue<ConfigSection> profile) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        this.profile = profile;
    }

    public /* synthetic */ ProfileRegionProvider(LazyAsyncValue lazyAsyncValue, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((LazyAsyncValue<ConfigSection>) ((i & 1) != 0 ? LazyAsyncValueKt.asyncLazy(new C31311(null)) : lazyAsyncValue));
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.region.ProfileRegionProvider$2 */
    /* JADX INFO: compiled from: ProfileRegionProvider.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.region.ProfileRegionProvider$2", m1609f = "ProfileRegionProvider.kt", m1610i = {}, m1611l = {26}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C31322 extends SuspendLambda implements Function1<Continuation<? super ConfigSection>, Object> {
        final /* synthetic */ String $profileName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31322(String str, Continuation<? super C31322> continuation) {
            super(1, continuation);
            this.$profileName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C31322(this.$profileName, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ConfigSection> continuation) {
            return ((C31322) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AwsConfigLoaderKt.loadAwsSharedConfig$default(PlatformProvider.INSTANCE.getSystem(), this.$profileName, null, this, 4, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((AwsSharedConfig) obj).getActiveProfile();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProfileRegionProvider(String profileName) {
        this((LazyAsyncValue<ConfigSection>) LazyAsyncValueKt.asyncLazy(new C31322(profileName, null)));
        Intrinsics.checkNotNullParameter(profileName, "profileName");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.client.region.RegionProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getRegion(Continuation<? super String> continuation) {
        C31331 c31331;
        if (continuation instanceof C31331) {
            c31331 = (C31331) continuation;
            if ((c31331.label & Integer.MIN_VALUE) != 0) {
                c31331.label -= Integer.MIN_VALUE;
            } else {
                c31331 = new C31331(continuation);
            }
        }
        Object obj = c31331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31331.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LazyAsyncValue<ConfigSection> lazyAsyncValue = this.profile;
            c31331.label = 1;
            obj = lazyAsyncValue.get(c31331);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return AwsProfileKt.getRegion((ConfigSection) obj);
    }
}
