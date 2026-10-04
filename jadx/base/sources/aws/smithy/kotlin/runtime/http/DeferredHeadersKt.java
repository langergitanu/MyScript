package aws.smithy.kotlin.runtime.http;

import androidx.media3.extractor.p007ts.TsExtractor;
import aws.smithy.kotlin.runtime.InternalApi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: DeferredHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087@¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"toHeaders", "Laws/smithy/kotlin/runtime/http/Headers;", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "(Laws/smithy/kotlin/runtime/http/DeferredHeaders;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DeferredHeadersKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.DeferredHeadersKt$toHeaders$1 */
    /* JADX INFO: compiled from: DeferredHeaders.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.DeferredHeadersKt", m1609f = "DeferredHeaders.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {70}, m1612m = "toHeaders", m1613n = {"$this$toHeaders", "$this$toHeaders_u24lambda_u240", "$this$forEach$iv", "element$iv", "headerName", "deferredValues", "$this$forEach$iv", "element$iv", "deferredValue", "$i$a$-apply-DeferredHeadersKt$toHeaders$2", "$i$f$forEach", "$i$a$-forEach-DeferredHeadersKt$toHeaders$2$1", "$i$f$forEach", "$i$a$-forEach-DeferredHeadersKt$toHeaders$2$1$1"}, m1614nl = {TsExtractor.TS_SYNC_BYTE}, m1615s = {"L$0", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "I$0", "I$1", "I$2", "I$3", "I$4"}, m1616v = 2)
    static final class C36911 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C36911(Continuation<? super C36911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeferredHeadersKt.toHeaders(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00be -> B:22:0x00e1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0140 -> B:28:0x0155). Please report as a decompilation issue!!! */
    @InternalApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object toHeaders(DeferredHeaders deferredHeaders, Continuation<? super Headers> continuation) {
        C36911 c36911;
        DeferredHeaders deferredHeaders2;
        HeadersBuilder headersBuilder;
        Iterator it;
        int i;
        int i2;
        Iterable iterable;
        HeadersBuilder headersBuilder2;
        if (continuation instanceof C36911) {
            c36911 = (C36911) continuation;
            if ((c36911.label & Integer.MIN_VALUE) != 0) {
                c36911.label -= Integer.MIN_VALUE;
            } else {
                c36911 = new C36911(continuation);
            }
        }
        Object obj = c36911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c36911.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            deferredHeaders2 = deferredHeaders;
            if (deferredHeaders2 instanceof EmptyDeferredHeaders) {
                return Headers.INSTANCE.getEmpty();
            }
            headersBuilder = new HeadersBuilder();
            Set<Map.Entry<String, List<Deferred<? extends String>>>> setEntries = deferredHeaders2.entries();
            it = setEntries.iterator();
            i = 0;
            i2 = 0;
            iterable = setEntries;
            headersBuilder2 = headersBuilder;
            if (!it.hasNext()) {
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c36911.I$4;
            int i5 = c36911.I$3;
            int i6 = c36911.I$2;
            int i7 = c36911.I$1;
            int i8 = c36911.I$0;
            HeadersBuilder headersBuilder3 = (HeadersBuilder) c36911.L$13;
            String str = (String) c36911.L$12;
            Object obj2 = c36911.L$10;
            Iterator it2 = (Iterator) c36911.L$9;
            Iterable iterable2 = (Iterable) c36911.L$8;
            List list = (List) c36911.L$7;
            String str2 = (String) c36911.L$6;
            Object obj3 = c36911.L$5;
            Iterator it3 = (Iterator) c36911.L$4;
            Iterable iterable3 = (Iterable) c36911.L$3;
            HeadersBuilder headersBuilder4 = (HeadersBuilder) c36911.L$2;
            HeadersBuilder headersBuilder5 = (HeadersBuilder) c36911.L$1;
            DeferredHeaders deferredHeaders3 = (DeferredHeaders) c36911.L$0;
            ResultKt.throwOnFailure(obj);
            C36911 c369112 = c36911;
            DeferredHeaders deferredHeaders4 = deferredHeaders3;
            Object objAwait = obj;
            Iterator it4 = it2;
            int i9 = i8;
            Iterator it5 = it3;
            int i10 = i5;
            C36911 c369113 = c369112;
            List list2 = list;
            Object obj4 = obj3;
            int i11 = i7;
            Iterable iterable4 = iterable2;
            Iterable iterable5 = iterable3;
            String str3 = str;
            HeadersBuilder headersBuilder6 = headersBuilder4;
            HeadersBuilder headersBuilder7 = headersBuilder3;
            int i12 = i6;
            headersBuilder7.append(str3, objAwait);
            deferredHeaders2 = deferredHeaders4;
            c36911 = c369113;
            Iterable iterable6 = iterable5;
            Iterator it6 = it5;
            int i13 = i12;
            int i14 = i9;
            int i15 = i11;
            String str4 = str2;
            List list3 = iterable4;
            Iterator it7 = it4;
            headersBuilder = headersBuilder5;
            List list4 = list2;
            Object obj5 = obj4;
            if (it7.hasNext()) {
                Object next = it7.next();
                DeferredHeaders deferredHeaders5 = deferredHeaders2;
                Deferred deferred = (Deferred) next;
                Iterable iterable7 = iterable6;
                c36911.L$0 = SpillingKt.nullOutSpilledVariable(deferredHeaders5);
                c36911.L$1 = headersBuilder;
                c36911.L$2 = headersBuilder6;
                c36911.L$3 = SpillingKt.nullOutSpilledVariable(iterable7);
                c36911.L$4 = it6;
                c36911.L$5 = SpillingKt.nullOutSpilledVariable(obj5);
                c36911.L$6 = str4;
                c36911.L$7 = SpillingKt.nullOutSpilledVariable(list4);
                c36911.L$8 = SpillingKt.nullOutSpilledVariable(list3);
                c36911.L$9 = it7;
                c36911.L$10 = SpillingKt.nullOutSpilledVariable(next);
                c36911.L$11 = SpillingKt.nullOutSpilledVariable(deferred);
                c36911.L$12 = str4;
                c36911.L$13 = headersBuilder6;
                c36911.I$0 = i14;
                c36911.I$1 = i15;
                c36911.I$2 = i13;
                c36911.I$3 = i10;
                c36911.I$4 = 0;
                c36911.label = 1;
                objAwait = deferred.await(c36911);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it4 = it7;
                list2 = list4;
                obj4 = obj5;
                i11 = i15;
                str2 = str4;
                iterable4 = list3;
                headersBuilder7 = headersBuilder6;
                i9 = i14;
                str3 = str2;
                i12 = i13;
                it5 = it6;
                iterable5 = iterable7;
                headersBuilder5 = headersBuilder;
                c369113 = c36911;
                deferredHeaders4 = deferredHeaders5;
                headersBuilder7.append(str3, objAwait);
                deferredHeaders2 = deferredHeaders4;
                c36911 = c369113;
                Iterable iterable62 = iterable5;
                Iterator it62 = it5;
                int i132 = i12;
                int i142 = i9;
                int i152 = i11;
                String str42 = str2;
                List list32 = iterable4;
                Iterator it72 = it4;
                headersBuilder = headersBuilder5;
                List list42 = list2;
                Object obj52 = obj4;
                if (it72.hasNext()) {
                    Iterable iterable8 = iterable62;
                    headersBuilder2 = headersBuilder6;
                    it = it62;
                    i = i142;
                    i2 = i152;
                    iterable = iterable8;
                    if (!it.hasNext()) {
                        Object next2 = it.next();
                        Map.Entry entry = (Map.Entry) next2;
                        str42 = (String) entry.getKey();
                        List list5 = (List) entry.getValue();
                        list32 = list5;
                        it72 = list32.iterator();
                        obj52 = next2;
                        list42 = list5;
                        i142 = i;
                        i152 = i2;
                        i132 = 0;
                        it62 = it;
                        iterable62 = iterable;
                        headersBuilder6 = headersBuilder2;
                        i10 = 0;
                        if (it72.hasNext()) {
                        }
                    } else {
                        return headersBuilder.build();
                    }
                }
            }
        }
    }
}
