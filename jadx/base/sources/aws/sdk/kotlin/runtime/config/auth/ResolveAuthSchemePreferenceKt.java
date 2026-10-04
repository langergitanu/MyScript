package aws.sdk.kotlin.runtime.config.auth;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.profile.AwsProfileKt;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ResolveAuthSchemePreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0006H\u0087@¢\u0006\u0002\u0010\t¨\u0006\n"}, m1599d2 = {"resolveAuthSchemePreference", "", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", DeviceDimensionProvider.KEY_PLATFORM, "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "profile", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ResolveAuthSchemePreferenceKt {

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.auth.ResolveAuthSchemePreferenceKt$resolveAuthSchemePreference$1 */
    /* JADX INFO: compiled from: ResolveAuthSchemePreference.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.auth.ResolveAuthSchemePreferenceKt", m1609f = "ResolveAuthSchemePreference.kt", m1610i = {0, 0}, m1611l = {19}, m1612m = "resolveAuthSchemePreference", m1613n = {DeviceDimensionProvider.KEY_PLATFORM, "profile"}, m1614nl = {21}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C30931 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30931(Continuation<? super C30931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolveAuthSchemePreferenceKt.resolveAuthSchemePreference(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0098 A[LOOP:0: B:24:0x0092->B:26:0x0098, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ed A[LOOP:2: B:34:0x00e7->B:36:0x00ed, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0109 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveAuthSchemePreference(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super List<AuthSchemeId>> continuation) {
        C30931 c30931;
        String authSchemePreference;
        List listSplit$default;
        Iterator it;
        Iterator it2;
        List list;
        if (continuation instanceof C30931) {
            c30931 = (C30931) continuation;
            if ((c30931.label & Integer.MIN_VALUE) != 0) {
                c30931.label -= Integer.MIN_VALUE;
            } else {
                c30931 = new C30931(continuation);
            }
        }
        Object obj = c30931.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30931.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            authSchemePreference = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsAuthSchemePreference(), platformProvider);
            if (authSchemePreference == null) {
                c30931.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
                c30931.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
                c30931.label = 1;
                obj = lazyAsyncValue.get(c30931);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (authSchemePreference != null && (listSplit$default = StringsKt.split$default((CharSequence) authSchemePreference, new String[]{","}, false, 0, 6, (Object) null)) != null) {
                List list2 = listSplit$default;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (((String) obj2).length() > 0) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    arrayList4.add(AuthSchemeId.m12116boximpl(AuthSchemeId.m12117constructorimpl((String) it2.next())));
                }
                list = CollectionsKt.toList(arrayList4);
                if (list != null) {
                    return list;
                }
            }
            return CollectionsKt.emptyList();
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        authSchemePreference = AwsProfileKt.getAuthSchemePreference((ConfigSection) obj);
        if (authSchemePreference != null) {
            List list22 = listSplit$default;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list22, 10));
            it = list22.iterator();
            while (it.hasNext()) {
            }
            ArrayList arrayList22 = new ArrayList();
            while (r11.hasNext()) {
            }
            ArrayList arrayList32 = arrayList22;
            ArrayList arrayList42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList32, 10));
            it2 = arrayList32.iterator();
            while (it2.hasNext()) {
            }
            list = CollectionsKt.toList(arrayList42);
            if (list != null) {
            }
        }
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ Object resolveAuthSchemePreference$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return resolveAuthSchemePreference(platformProvider, lazyAsyncValue, continuation);
    }
}
