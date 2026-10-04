package aws.smithy.kotlin.runtime.identity;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.identity.Identity;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProvider;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContext;
import aws.smithy.kotlin.runtime.telemetry.TelemetryProviderContextKt;
import aws.smithy.kotlin.runtime.telemetry.context.Context;
import aws.smithy.kotlin.runtime.telemetry.context.ContextManager;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElement;
import aws.smithy.kotlin.runtime.telemetry.context.TelemetryContextElementKt;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanKind;
import aws.smithy.kotlin.runtime.telemetry.trace.SpanStatus;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanContext;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanExtKt;
import aws.smithy.kotlin.runtime.telemetry.trace.Tracer;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: compiled from: IdentityProviderChain.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u001b\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\"\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\u0016\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007X\u0084\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/identity/IdentityProviderChain;", "P", "Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "I", "Laws/smithy/kotlin/runtime/identity/Identity;", "Laws/smithy/kotlin/runtime/identity/CloseableIdentityProvider;", "providers", "", "<init>", "([Laws/smithy/kotlin/runtime/identity/IdentityProvider;)V", "getProviders", "()[Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "[Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "toString", "", "resolve", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "identity-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class IdentityProviderChain<P extends IdentityProvider, I extends Identity> implements CloseableIdentityProvider {
    private final P[] providers;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.identity.IdentityProviderChain$resolve$1 */
    /* JADX INFO: compiled from: IdentityProviderChain.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.identity.IdentityProviderChain", m1609f = "IdentityProviderChain.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {87}, m1612m = "resolve$suspendImpl", m1613n = {"$this", "attributes", "name$iv", "initialAttributes$iv", "spanKind$iv", "context$iv", "sourceComponent$iv$iv", "name$iv$iv", "sourceComponent$iv", "initialAttributes$iv$iv", "spanKind$iv$iv", "context$iv$iv", "tracer$iv$iv", "$this$withSpan$iv$iv$iv", "name$iv$iv$iv", "initialAttributes$iv$iv$iv", "spanKind$iv$iv$iv", "context$iv$iv$iv", "parent$iv$iv$iv", "span$iv$iv$iv", "span$iv$iv$iv$iv", "context$iv$iv$iv$iv", "telemetryCtxElement$iv$iv$iv$iv", "updatedCtx$iv$iv$iv$iv", "$i$f$withSpan", "$i$f$withSpan", "$i$f$withSpan", "$i$f$withSpan"}, m1614nl = {88}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "I$0", "I$1", "I$2", "I$3"}, m1616v = 2)
    static final class C37421<P extends IdentityProvider, I extends Identity> extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ IdentityProviderChain<P, I> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37421(IdentityProviderChain<P, I> identityProviderChain, Continuation<? super C37421> continuation) {
            super(continuation);
            this.this$0 = identityProviderChain;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdentityProviderChain.resolve$suspendImpl(this.this$0, null, this);
        }
    }

    @Override // aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super I> continuation) {
        return resolve$suspendImpl(this, attributes, continuation);
    }

    public IdentityProviderChain(P... providers) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        this.providers = providers;
        if (providers.length == 0) {
            throw new IllegalArgumentException("at least one provider must be in the chain".toString());
        }
    }

    protected final P[] getProviders() {
        return this.providers;
    }

    public String toString() {
        List listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(this), (Object[]) this.providers);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus, 10));
        Iterator it = listPlus.iterator();
        while (it.hasNext()) {
            arrayList.add(Reflection.getOrCreateKotlinClass(((IdentityProvider) it.next()).getClass()).getSimpleName());
        }
        return CollectionsKt.joinToString$default(arrayList, " -> ", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01ed A[Catch: all -> 0x0098, TryCatch #2 {all -> 0x0098, blocks: (B:12:0x0093, B:48:0x01e9, B:50:0x01ed, B:52:0x0204, B:51:0x01f8), top: B:57:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f8 A[Catch: all -> 0x0098, TryCatch #2 {all -> 0x0098, blocks: (B:12:0x0093, B:48:0x01e9, B:50:0x01ed, B:52:0x0204, B:51:0x01f8), top: B:57:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ <P extends IdentityProvider, I extends Identity> Object resolve$suspendImpl(IdentityProviderChain<P, I> identityProviderChain, Attributes attributes, Continuation<? super I> continuation) throws Throwable {
        C37421 c37421;
        TraceSpan traceSpan;
        CoroutineContext telemetryContextElement;
        TelemetryProvider provider;
        ContextManager contextManager;
        if (continuation instanceof C37421) {
            c37421 = (C37421) continuation;
            if ((c37421.label & Integer.MIN_VALUE) != 0) {
                c37421.label -= Integer.MIN_VALUE;
            } else {
                c37421 = new C37421(identityProviderChain, continuation);
            }
        }
        Object objWithContext = c37421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37421.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c37421.I$3;
            int i3 = c37421.I$2;
            int i4 = c37421.I$1;
            int i5 = c37421.I$0;
            traceSpan = (TraceSpan) c37421.L$20;
            try {
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    traceSpan.close();
                    return objWithContext;
                } catch (Exception e) {
                    e = e;
                    if (e instanceof CancellationException) {
                        traceSpan.setStatus(SpanStatus.ERROR);
                        TraceSpanExtKt.recordException(traceSpan, e, true);
                    } else {
                        TraceSpanExtKt.setAttribute(traceSpan, "cancelled", Boxing.boxBoolean(true));
                    }
                    throw e;
                }
            } catch (Throwable th) {
                th = th;
                traceSpan.close();
                throw th;
            }
        }
        ResultKt.throwOnFailure(objWithContext);
        Attributes attributesEmptyAttributes = AttributesKt.emptyAttributes();
        SpanKind spanKind = SpanKind.INTERNAL;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        String qualifiedName = Reflection.getOrCreateKotlinClass(IdentityProviderChain.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("withSpan<T> cannot be used on an anonymous object".toString());
        }
        Tracer orCreateTracer = TelemetryProviderContextKt.getTelemetryProvider(c37421.getContext()).getTracerProvider().getOrCreateTracer(qualifiedName);
        Context telemetryContext = TelemetryContextElementKt.getTelemetryContext(c37421.getContext());
        TraceSpan traceSpanCreateSpan = orCreateTracer.createSpan("ResolveIdentityChain", attributesEmptyAttributes, spanKind, telemetryContext);
        try {
            TelemetryProviderContext telemetryProviderContext = (TelemetryProviderContext) c37421.getContext().get(TelemetryProviderContext.INSTANCE);
            Context contextCurrent = (telemetryProviderContext == null || (provider = telemetryProviderContext.getProvider()) == null || (contextManager = provider.getContextManager()) == null) ? null : contextManager.current();
            if (contextCurrent != null) {
                telemetryContextElement = new TelemetryContextElement(contextCurrent);
            } else {
                telemetryContextElement = (TelemetryContextElement) c37421.getContext().get(TelemetryContextElement.INSTANCE);
                if (telemetryContextElement == null) {
                    telemetryContextElement = EmptyCoroutineContext.INSTANCE;
                }
            }
            CoroutineContext coroutineContext = telemetryContextElement;
            CoroutineContext coroutineContextPlus = emptyCoroutineContext.plus(new TraceSpanContext(traceSpanCreateSpan)).plus(coroutineContext).plus(traceSpanCreateSpan.asContextElement());
            C3743x3d16e725 c3743x3d16e725 = new C3743x3d16e725(traceSpanCreateSpan, null, identityProviderChain, attributes);
            c37421.L$0 = SpillingKt.nullOutSpilledVariable(identityProviderChain);
            c37421.L$1 = SpillingKt.nullOutSpilledVariable(attributes);
            c37421.L$2 = SpillingKt.nullOutSpilledVariable("ResolveIdentityChain");
            c37421.L$3 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
            c37421.L$4 = SpillingKt.nullOutSpilledVariable(spanKind);
            c37421.L$5 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
            c37421.L$6 = SpillingKt.nullOutSpilledVariable(qualifiedName);
            c37421.L$7 = SpillingKt.nullOutSpilledVariable("ResolveIdentityChain");
            c37421.L$8 = SpillingKt.nullOutSpilledVariable(qualifiedName);
            c37421.L$9 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
            c37421.L$10 = SpillingKt.nullOutSpilledVariable(spanKind);
            c37421.L$11 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
            c37421.L$12 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
            c37421.L$13 = SpillingKt.nullOutSpilledVariable(orCreateTracer);
            c37421.L$14 = SpillingKt.nullOutSpilledVariable("ResolveIdentityChain");
            c37421.L$15 = SpillingKt.nullOutSpilledVariable(attributesEmptyAttributes);
            c37421.L$16 = SpillingKt.nullOutSpilledVariable(spanKind);
            c37421.L$17 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
            c37421.L$18 = SpillingKt.nullOutSpilledVariable(telemetryContext);
            c37421.L$19 = SpillingKt.nullOutSpilledVariable(traceSpanCreateSpan);
            c37421.L$20 = traceSpanCreateSpan;
            c37421.L$21 = SpillingKt.nullOutSpilledVariable(emptyCoroutineContext);
            c37421.L$22 = SpillingKt.nullOutSpilledVariable(coroutineContext);
            c37421.L$23 = SpillingKt.nullOutSpilledVariable(contextCurrent);
            c37421.I$0 = 0;
            c37421.I$1 = 0;
            c37421.I$2 = 0;
            c37421.I$3 = 0;
            c37421.label = 1;
            objWithContext = BuildersKt.withContext(coroutineContextPlus, c3743x3d16e725, c37421);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            traceSpan = traceSpanCreateSpan;
            traceSpan.close();
            return objWithContext;
        } catch (Exception e2) {
            e = e2;
            traceSpan = traceSpanCreateSpan;
            if (e instanceof CancellationException) {
            }
            throw e;
        } catch (Throwable th2) {
            th = th2;
            traceSpan = traceSpanCreateSpan;
            traceSpan.close();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Exception {
        Exception exc;
        P[] pArr = this.providers;
        ArrayList arrayList = new ArrayList();
        for (P p : pArr) {
            try {
                exc = null;
                Closeable closeable = p instanceof Closeable ? (Closeable) p : null;
                if (closeable != null) {
                    closeable.close();
                }
            } catch (Exception e) {
                exc = e;
            }
            if (exc != null) {
                arrayList.add(exc);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        Exception exc2 = (Exception) CollectionsKt.first((List) arrayList2);
        Iterator it = CollectionsKt.drop(arrayList2, 1).iterator();
        while (it.hasNext()) {
            exc2.addSuppressed((Throwable) it.next());
        }
        throw exc2;
    }
}
