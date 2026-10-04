package aws.sdk.kotlin.runtime.region;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.sdk.kotlin.runtime.config.profile.AwsProfileKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ResolveRegion.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H\u0087@¢\u0006\u0002\u0010\b\u001a2\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H\u0087@¢\u0006\u0002\u0010\b¨\u0006\f"}, m1599d2 = {"resolveRegion", "", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "profile", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveSigV4aSigningRegionSet", "", DeviceDimensionProvider.KEY_PLATFORM, "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ResolveRegionKt {

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.region.ResolveRegionKt$resolveRegion$1 */
    /* JADX INFO: compiled from: ResolveRegion.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.region.ResolveRegionKt", m1609f = "ResolveRegion.kt", m1610i = {0, 0, 0, 0, 0, 0, 0}, m1611l = {26}, m1612m = "resolveRegion", m1613n = {"platformProvider", "profile", "$this$use$iv", "it", "$i$f$use", "closed$iv", "$i$a$-use-ResolveRegionKt$resolveRegion$3"}, m1614nl = {45}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2"}, m1616v = 2)
    static final class C31341 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C31341(Continuation<? super C31341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolveRegionKt.resolveRegion(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.region.ResolveRegionKt$resolveSigV4aSigningRegionSet$1 */
    /* JADX INFO: compiled from: ResolveRegion.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.region.ResolveRegionKt", m1609f = "ResolveRegion.kt", m1610i = {0, 0}, m1611l = {34}, m1612m = "resolveSigV4aSigningRegionSet", m1613n = {DeviceDimensionProvider.KEY_PLATFORM, "profile"}, m1614nl = {36}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C31361 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C31361(Continuation<? super C31361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolveRegionKt.resolveSigV4aSigningRegionSet(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r10v0, types: [aws.smithy.kotlin.runtime.util.PlatformProvider, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.Closeable] */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveRegion(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super String> continuation) throws IOException {
        C31341 c31341;
        if (continuation instanceof C31341) {
            c31341 = (C31341) continuation;
            if ((c31341.label & Integer.MIN_VALUE) != 0) {
                c31341.label -= Integer.MIN_VALUE;
            } else {
                c31341 = new C31341(continuation);
            }
        }
        Object region = c31341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31341.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(region);
                DefaultRegionProviderChain defaultRegionProviderChain = new DefaultRegionProviderChain(platformProvider, null, lazyAsyncValue, 2, null);
                DefaultRegionProviderChain defaultRegionProviderChain2 = defaultRegionProviderChain;
                c31341.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
                c31341.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
                c31341.L$2 = defaultRegionProviderChain;
                c31341.L$3 = SpillingKt.nullOutSpilledVariable(defaultRegionProviderChain2);
                c31341.I$0 = 0;
                c31341.I$1 = 0;
                c31341.I$2 = 0;
                c31341.label = 1;
                region = defaultRegionProviderChain2.getRegion(c31341);
                platformProvider = defaultRegionProviderChain;
                if (region == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c31341.I$2;
                int i3 = c31341.I$1;
                int i4 = c31341.I$0;
                Closeable closeable = (Closeable) c31341.L$2;
                ResultKt.throwOnFailure(region);
                platformProvider = closeable;
            }
            String str = (String) region;
            platformProvider.close();
            return str;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.region.ResolveRegionKt$resolveRegion$2 */
    /* JADX INFO: compiled from: ResolveRegion.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.region.ResolveRegionKt$resolveRegion$2", m1609f = "ResolveRegion.kt", m1610i = {}, m1611l = {25}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    public static final class C31352 extends SuspendLambda implements Function1<Continuation<? super ConfigSection>, Object> {
        final /* synthetic */ PlatformProvider $platformProvider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31352(PlatformProvider platformProvider, Continuation<? super C31352> continuation) {
            super(1, continuation);
            this.$platformProvider = platformProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C31352(this.$platformProvider, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ConfigSection> continuation) {
            return ((C31352) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AwsConfigLoaderKt.loadAwsSharedConfig$default(this.$platformProvider, null, null, this, 6, null);
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

    public static /* synthetic */ Object resolveRegion$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        if ((i & 2) != 0) {
            lazyAsyncValue = LazyAsyncValueKt.asyncLazy(new C31352(platformProvider, null));
        }
        return resolveRegion(platformProvider, lazyAsyncValue, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveSigV4aSigningRegionSet(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super Set<String>> continuation) {
        C31361 c31361;
        String sigV4aSigningRegionSet;
        List listSplit$default;
        if (continuation instanceof C31361) {
            c31361 = (C31361) continuation;
            if ((c31361.label & Integer.MIN_VALUE) != 0) {
                c31361.label -= Integer.MIN_VALUE;
            } else {
                c31361 = new C31361(continuation);
            }
        }
        Object obj = c31361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31361.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sigV4aSigningRegionSet = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsSigV4aSigningRegionSet(), platformProvider);
            if (sigV4aSigningRegionSet == null) {
                c31361.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
                c31361.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
                c31361.label = 1;
                obj = lazyAsyncValue.get(c31361);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (sigV4aSigningRegionSet == null && (listSplit$default = StringsKt.split$default((CharSequence) sigV4aSigningRegionSet, new String[]{","}, false, 0, 6, (Object) null)) != null) {
                List list = listSplit$default;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (((String) obj2).length() > 0) {
                        arrayList2.add(obj2);
                    }
                }
                return CollectionsKt.toSet(arrayList2);
            }
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        sigV4aSigningRegionSet = AwsProfileKt.getSigV4aSigningRegionSet((ConfigSection) obj);
        return sigV4aSigningRegionSet == null ? null : null;
    }

    public static /* synthetic */ Object resolveSigV4aSigningRegionSet$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return resolveSigV4aSigningRegionSet(platformProvider, lazyAsyncValue, continuation);
    }
}
