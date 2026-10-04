package aws.smithy.kotlin.runtime.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DefaultHostResolverJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/DefaultHostResolver;", "Laws/smithy/kotlin/runtime/net/HostResolver;", "<init>", "()V", "", "hostname", "", "Laws/smithy/kotlin/runtime/net/HostAddress;", "resolve", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addr", "", "reportFailure", "(Laws/smithy/kotlin/runtime/net/HostAddress;)V", "purgeCache", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultHostResolver implements HostResolver {
    public static final DefaultHostResolver INSTANCE = new DefaultHostResolver();

    @Override // aws.smithy.kotlin.runtime.net.HostResolver
    public void purgeCache(HostAddress addr) {
    }

    @Override // aws.smithy.kotlin.runtime.net.HostResolver
    public void reportFailure(HostAddress addr) {
        Intrinsics.checkNotNullParameter(addr, "addr");
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.net.DefaultHostResolver$resolve$2 */
    /* JADX INFO: compiled from: DefaultHostResolverJVM.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Laws/smithy/kotlin/runtime/net/HostAddress;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.net.DefaultHostResolver$resolve$2", m1609f = "DefaultHostResolverJVM.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C37652 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends HostAddress>>, Object> {
        final /* synthetic */ String $hostname;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37652(String str, Continuation<? super C37652> continuation) {
            super(2, continuation);
            this.$hostname = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C37652(this.$hostname, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends HostAddress>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<HostAddress>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<HostAddress>> continuation) {
            return ((C37652) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws UnknownHostException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            InetAddress[] allByName = InetAddress.getAllByName(this.$hostname);
            Intrinsics.checkNotNullExpressionValue(allByName, "getAllByName(...)");
            InetAddress[] inetAddressArr = allByName;
            ArrayList arrayList = new ArrayList(inetAddressArr.length);
            for (InetAddress inetAddress : inetAddressArr) {
                Intrinsics.checkNotNull(inetAddress);
                arrayList.add(DefaultHostResolverJVMKt.toHostAddress(inetAddress));
            }
            return arrayList;
        }
    }

    private DefaultHostResolver() {
    }

    @Override // aws.smithy.kotlin.runtime.net.HostResolver
    public Object resolve(String str, Continuation<? super List<HostAddress>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C37652(str, null), continuation);
    }
}
