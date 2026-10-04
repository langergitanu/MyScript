package aws.smithy.kotlin.runtime.client.region;

import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: RegionProviderChain.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005B\u0017\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0004\b\u0004\u0010\u0007J\n\u0010\u000e\u001a\u00020\rH\u0096\u0080\u0004J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010\u0010R\u001e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003X\u0084\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/region/RegionProviderChain;", "Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "providers", "", "<init>", "([Laws/smithy/kotlin/runtime/client/region/RegionProvider;)V", "", "(Ljava/util/List;)V", "getProviders", "()[Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "[Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "resolvedRegion", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "", "toString", "getRegion", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveRegion", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class RegionProviderChain implements RegionProvider {
    private final RegionProvider[] providers;
    private final LazyAsyncValue<String> resolvedRegion;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.client.region.RegionProviderChain$resolveRegion$1 */
    /* JADX INFO: compiled from: RegionProviderChain.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.client.region.RegionProviderChain", m1609f = "RegionProviderChain.kt", m1610i = {0, 0}, m1611l = {38}, m1612m = "resolveRegion", m1613n = {"logger", "provider"}, m1614nl = {39}, m1615s = {"L$0", "L$2"}, m1616v = 2)
    static final class C36681 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C36681(Continuation<? super C36681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RegionProviderChain.this.resolveRegion(this);
        }
    }

    @Override // aws.smithy.kotlin.runtime.client.region.RegionProvider
    public Object getRegion(Continuation<? super String> continuation) {
        return getRegion$suspendImpl(this, continuation);
    }

    public RegionProviderChain(RegionProvider... providers) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        this.providers = providers;
        this.resolvedRegion = LazyAsyncValueKt.asyncLazy(new RegionProviderChain$resolvedRegion$1(this));
        if (providers.length == 0) {
            throw new IllegalArgumentException("at least one provider must be in the chain".toString());
        }
    }

    protected final RegionProvider[] getProviders() {
        return this.providers;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public RegionProviderChain(List<? extends RegionProvider> providers) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        RegionProvider[] regionProviderArr = (RegionProvider[]) providers.toArray(new RegionProvider[0]);
        this((RegionProvider[]) Arrays.copyOf(regionProviderArr, regionProviderArr.length));
    }

    public String toString() {
        List listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(this), (Object[]) this.providers);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus, 10));
        Iterator it = listPlus.iterator();
        while (it.hasNext()) {
            arrayList.add(Reflection.getOrCreateKotlinClass(((RegionProvider) it.next()).getClass()).getSimpleName());
        }
        return CollectionsKt.joinToString$default(arrayList, " -> ", null, null, 0, null, null, 62, null);
    }

    static /* synthetic */ Object getRegion$suspendImpl(RegionProviderChain regionProviderChain, Continuation<? super String> continuation) {
        return regionProviderChain.resolvedRegion.get(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:12:0x0037, B:26:0x007b, B:28:0x007f, B:30:0x0088, B:23:0x0068), top: B:37:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088 A[Catch: Exception -> 0x003b, TRY_LEAVE, TryCatch #0 {Exception -> 0x003b, blocks: (B:12:0x0037, B:26:0x007b, B:28:0x007f, B:30:0x0088, B:23:0x0068), top: B:37:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0078 -> B:26:0x007b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveRegion(Continuation<? super String> continuation) {
        C36681 c36681;
        Logger logger;
        RegionProvider[] regionProviderArr;
        int length;
        int i;
        if (continuation instanceof C36681) {
            c36681 = (C36681) continuation;
            if ((c36681.label & Integer.MIN_VALUE) != 0) {
                c36681.label -= Integer.MIN_VALUE;
            } else {
                c36681 = new C36681(continuation);
            }
        }
        Object region = c36681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c36681.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(region);
            CoroutineContext coroutineContext = c36681.get$context();
            String qualifiedName = Reflection.getOrCreateKotlinClass(RegionProviderChain.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            Logger logger2 = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
            RegionProvider[] regionProviderArr2 = this.providers;
            logger = logger2;
            regionProviderArr = regionProviderArr2;
            length = regionProviderArr2.length;
            i = 0;
            if (i >= length) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = c36681.I$1;
            i = c36681.I$0;
            final RegionProvider regionProvider = (RegionProvider) c36681.L$2;
            regionProviderArr = (RegionProvider[]) c36681.L$1;
            logger = (Logger) c36681.L$0;
            try {
                ResultKt.throwOnFailure(region);
            } catch (Exception e) {
                Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.client.region.RegionProviderChain$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RegionProviderChain.resolveRegion$lambda$2(regionProvider, e);
                    }
                }, 1, null);
                i++;
                if (i >= length) {
                }
            }
            final String str = (String) region;
            if (str == null) {
                Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.client.region.RegionProviderChain$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RegionProviderChain.resolveRegion$lambda$0(str, regionProvider);
                    }
                }, 1, null);
                return str;
            }
            Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.client.region.RegionProviderChain$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RegionProviderChain.resolveRegion$lambda$1(regionProvider);
                }
            }, 1, null);
            i++;
            if (i >= length) {
                return null;
            }
            regionProvider = regionProviderArr[i];
            c36681.L$0 = logger;
            c36681.L$1 = regionProviderArr;
            c36681.L$2 = regionProvider;
            c36681.I$0 = i;
            c36681.I$1 = length;
            c36681.label = 1;
            region = regionProvider.getRegion(c36681);
            if (region == coroutine_suspended) {
                return coroutine_suspended;
            }
            final String str2 = (String) region;
            if (str2 == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolveRegion$lambda$0(String str, RegionProvider regionProvider) {
        return "resolved region (" + str + ") from " + regionProvider + TokenParser.f2383SP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolveRegion$lambda$1(RegionProvider regionProvider) {
        return "failed to resolve region from " + regionProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolveRegion$lambda$2(RegionProvider regionProvider, Exception exc) {
        return "unable to load region from " + regionProvider + ": " + exc.getMessage();
    }
}
