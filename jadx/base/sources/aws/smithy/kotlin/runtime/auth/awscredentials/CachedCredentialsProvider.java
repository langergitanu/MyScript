package aws.smithy.kotlin.runtime.auth.awscredentials;

import aws.smithy.kotlin.runtime.auth.awscredentials.CachedCredentialsProvider;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.p011io.CloseableKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.util.CachedValue;
import aws.smithy.kotlin.runtime.util.ExpiringValue;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: CachedCredentialsProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013H\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/CachedCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CloseableCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", FirebaseAnalytics.Param.SOURCE, "Lkotlin/time/Duration;", "expireCredentialsAfter", "refreshBufferWindow", "Laws/smithy/kotlin/runtime/time/Clock;", "clock", "<init>", "(Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;JJLaws/smithy/kotlin/runtime/time/Clock;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Laws/smithy/kotlin/runtime/collections/Attributes;", "attributes", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "resolve", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "close", "()V", "", "toString", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "J", "Laws/smithy/kotlin/runtime/time/Clock;", "Laws/smithy/kotlin/runtime/util/CachedValue;", "cachedCredentials", "Laws/smithy/kotlin/runtime/util/CachedValue;", "aws-credentials"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CachedCredentialsProvider implements CloseableCredentialsProvider {
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(CachedCredentialsProvider.class, "closed");
    private final CachedValue<Credentials> cachedCredentials;
    private final Clock clock;
    private volatile /* synthetic */ int closed;
    private final long expireCredentialsAfter;
    private final CredentialsProvider source;

    public /* synthetic */ CachedCredentialsProvider(CredentialsProvider credentialsProvider, long j, long j2, Clock clock, DefaultConstructorMarker defaultConstructorMarker) {
        this(credentialsProvider, j, j2, clock);
    }

    private CachedCredentialsProvider(CredentialsProvider source, long j, long j2, Clock clock) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.source = source;
        this.expireCredentialsAfter = j;
        this.clock = clock;
        this.cachedCredentials = new CachedValue<>((ExpiringValue) null, j2, clock, (DefaultConstructorMarker) null);
        this.closed = 0;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CachedCredentialsProvider(CredentialsProvider credentialsProvider, long j, long j2, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            j = DurationKt.toDuration(900, DurationUnit.SECONDS);
        }
        long j3 = j;
        if ((i & 4) != 0) {
            Duration.Companion companion2 = Duration.INSTANCE;
            j2 = DurationKt.toDuration(10, DurationUnit.SECONDS);
        }
        this(credentialsProvider, j3, j2, (i & 8) != 0 ? Clock.System.INSTANCE : clock, null);
    }

    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) {
        if (this.closed != 0) {
            throw new IllegalStateException("Credentials provider is closed".toString());
        }
        return this.cachedCredentials.getOrLoad(new C36383(attributes, null), continuation);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awscredentials.CachedCredentialsProvider$resolve$3 */
    /* JADX INFO: compiled from: CachedCredentialsProvider.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Laws/smithy/kotlin/runtime/util/ExpiringValue;", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awscredentials.CachedCredentialsProvider$resolve$3", m1609f = "CachedCredentialsProvider.kt", m1610i = {}, m1611l = {63}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {64}, m1615s = {}, m1616v = 2)
    static final class C36383 extends SuspendLambda implements Function1<Continuation<? super ExpiringValue<Credentials>>, Object> {
        final /* synthetic */ Attributes $attributes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36383(Attributes attributes, Continuation<? super C36383> continuation) {
            super(1, continuation);
            this.$attributes = attributes;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CachedCredentialsProvider.this.new C36383(this.$attributes, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ExpiringValue<Credentials>> continuation) {
            return ((C36383) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext context = getContext();
                Function0 function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.auth.awscredentials.CachedCredentialsProvider$resolve$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CachedCredentialsProvider.C36383.invokeSuspend$lambda$0();
                    }
                };
                LogLevel logLevel = LogLevel.Trace;
                String qualifiedName = Reflection.getOrCreateKotlinClass(CachedCredentialsProvider.class).getQualifiedName();
                if (qualifiedName == null) {
                    throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                }
                CoroutineContextLogExtKt.log(context, logLevel, qualifiedName, null, function0);
                this.label = 1;
                obj = CachedCredentialsProvider.this.source.resolve(this.$attributes, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Credentials credentials = (Credentials) obj;
            Instant instant = (Instant) CollectionsKt.minOrThrow((Iterable<Double>) CollectionsKt.listOfNotNull((Object[]) new Instant[]{credentials.getExpiration(), CachedCredentialsProvider.this.clock.getNow().m12289plusLRDsOJo(CachedCredentialsProvider.this.expireCredentialsAfter)}));
            Instant expiration = credentials.getExpiration();
            return new ExpiringValue(CredentialsKt.copy$default(credentials, null, null, null, expiration == null ? instant : expiration, null, null, 55, null), instant);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0() {
            return "refreshing credentials cache";
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (closed$FU.compareAndSet(this, 0, 1)) {
            this.cachedCredentials.close();
            CloseableKt.closeIfCloseable(this.source);
        }
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this) + ": " + CredentialsProviderKt.getSimpleClassName(this.source);
    }
}
