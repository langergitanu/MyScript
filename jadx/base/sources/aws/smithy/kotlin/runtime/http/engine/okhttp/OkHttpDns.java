package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.net.DefaultHostResolverJVMKt;
import aws.smithy.kotlin.runtime.net.HostAddress;
import aws.smithy.kotlin.runtime.net.HostResolver;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Dns;

/* JADX INFO: compiled from: OkHttpUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/OkHttpDns;", "Lokhttp3/Dns;", "hr", "Laws/smithy/kotlin/runtime/net/HostResolver;", "<init>", "(Laws/smithy/kotlin/runtime/net/HostResolver;)V", "lookup", "", "Ljava/net/InetAddress;", "hostname", "", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OkHttpDns implements Dns {
    private final HostResolver hr;

    public OkHttpDns(HostResolver hr) {
        Intrinsics.checkNotNullParameter(hr, "hr");
        this.hr = hr;
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpDns$lookup$1 */
    /* JADX INFO: compiled from: OkHttpUtils.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Ljava/net/InetAddress;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpDns$lookup$1", m1609f = "OkHttpUtils.kt", m1610i = {}, m1611l = {169}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {170}, m1615s = {}, m1616v = 2)
    static final class C37051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends InetAddress>>, Object> {
        final /* synthetic */ String $hostname;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37051(String str, Continuation<? super C37051> continuation) {
            super(2, continuation);
            this.$hostname = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OkHttpDns.this.new C37051(this.$hostname, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends InetAddress>> continuation) {
            return ((C37051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = OkHttpDns.this.hr.resolve(this.$hostname, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(DefaultHostResolverJVMKt.toInetAddress((HostAddress) it.next()));
            }
            return arrayList;
        }
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return (List) BuildersKt__BuildersKt.runBlocking$default(null, new C37051(hostname, null), 1, null);
    }
}
