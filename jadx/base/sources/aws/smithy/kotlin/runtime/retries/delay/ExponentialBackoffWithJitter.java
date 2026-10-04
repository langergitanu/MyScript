package aws.smithy.kotlin.runtime.retries.delay;

import androidx.webkit.Profile;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.retries.delay.DelayProvider;
import aws.smithy.kotlin.runtime.retries.delay.ExponentialBackoffWithJitter;
import aws.smithy.kotlin.runtime.util.DslFactory;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: ExponentialBackoffWithJitter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter;", "Laws/smithy/kotlin/runtime/retries/delay/DelayProvider;", "Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config;", "config", "<init>", "(Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config;)V", "", "attempt", "", "backoff", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config;", "getConfig", "()Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config;", "Lkotlin/random/Random$Default;", "random", "Lkotlin/random/Random$Default;", "Companion", "Config", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ExponentialBackoffWithJitter implements DelayProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Config config;
    private final Random.Companion random;

    /* JADX WARN: Multi-variable type inference failed */
    public ExponentialBackoffWithJitter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: compiled from: ExponentialBackoffWithJitter.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Companion;", "Laws/smithy/kotlin/runtime/util/DslFactory;", "Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion implements DslFactory<Config.Builder, ExponentialBackoffWithJitter> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // aws.smithy.kotlin.runtime.util.DslFactory
        public ExponentialBackoffWithJitter invoke(Function1<? super Config.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return new ExponentialBackoffWithJitter(Config.INSTANCE.invoke(block));
        }
    }

    public ExponentialBackoffWithJitter(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.random = Random.INSTANCE;
    }

    public /* synthetic */ ExponentialBackoffWithJitter(Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Config.INSTANCE.getDefault() : config);
    }

    @Override // aws.smithy.kotlin.runtime.retries.delay.DelayProvider
    public Config getConfig() {
        return this.config;
    }

    @Override // aws.smithy.kotlin.runtime.retries.delay.DelayProvider
    public Object backoff(int i, Continuation<? super Unit> continuation) {
        if (i <= 0) {
            throw new IllegalArgumentException(("attempt was " + i + " but must be greater than 0").toString());
        }
        double dMin = Math.min(Duration.m15867getInWholeMillisecondsimpl(getConfig().getInitialDelay()) * Math.pow(getConfig().getScaleFactor(), i - 1), Duration.m15892toDoubleimpl(getConfig().getMaxBackoff(), DurationUnit.MILLISECONDS));
        double jitter = getConfig().getJitter();
        double dNextDouble = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (jitter > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            dNextDouble = this.random.nextDouble(getConfig().getJitter());
        }
        Object objDelay = DelayKt.delay((long) (dMin * (1.0d - dNextDouble)), continuation);
        return objDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelay : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: ExponentialBackoffWithJitter.kt */
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0017¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001c"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config;", "Laws/smithy/kotlin/runtime/retries/delay/DelayProvider$Config;", "Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config$Builder;", "builder", "<init>", "(Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config$Builder;)V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/delay/DelayProvider$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "toBuilderApplicator", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/time/Duration;", "initialDelay", "J", "getInitialDelay-UwyO8pc", "()J", "", "scaleFactor", "D", "getScaleFactor", "()D", "jitter", "getJitter", "maxBackoff", "getMaxBackoff-UwyO8pc", "Companion", "Builder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Config implements DelayProvider.Config {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Config Default = new Config(new Builder());
        private final long initialDelay;
        private final double jitter;
        private final long maxBackoff;
        private final double scaleFactor;

        /* JADX INFO: compiled from: ExponentialBackoffWithJitter.kt */
        @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config;", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config;", Profile.DEFAULT_PROFILE_NAME, "Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config;", "getDefault", "()Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Config getDefault() {
                return Config.Default;
            }

            public final Config invoke(Function1<? super Builder, Unit> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                Builder builder = new Builder();
                block.invoke(builder);
                return new Config(builder);
            }
        }

        public Config(Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.initialDelay = builder.getInitialDelay();
            this.scaleFactor = builder.getScaleFactor();
            this.jitter = builder.getJitter();
            this.maxBackoff = builder.getMaxBackoff();
        }

        /* JADX INFO: renamed from: getInitialDelay-UwyO8pc, reason: not valid java name and from getter */
        public final long getInitialDelay() {
            return this.initialDelay;
        }

        public final double getScaleFactor() {
            return this.scaleFactor;
        }

        public final double getJitter() {
            return this.jitter;
        }

        /* JADX INFO: renamed from: getMaxBackoff-UwyO8pc, reason: not valid java name and from getter */
        public final long getMaxBackoff() {
            return this.maxBackoff;
        }

        @Override // aws.smithy.kotlin.runtime.retries.delay.DelayProvider.Config
        @InternalApi
        public Function1<DelayProvider.Config.Builder, Unit> toBuilderApplicator() {
            return new Function1() { // from class: aws.smithy.kotlin.runtime.retries.delay.ExponentialBackoffWithJitter$Config$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ExponentialBackoffWithJitter.Config.toBuilderApplicator$lambda$0(this.f$0, (DelayProvider.Config.Builder) obj);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit toBuilderApplicator$lambda$0(Config config, DelayProvider.Config.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<this>");
            if (builder instanceof Builder) {
                Builder builder2 = (Builder) builder;
                builder2.m12244setInitialDelayLRDsOJo(config.initialDelay);
                builder2.setScaleFactor(config.scaleFactor);
                builder2.setJitter(config.jitter);
                builder2.m12245setMaxBackoffLRDsOJo(config.maxBackoff);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: compiled from: ExponentialBackoffWithJitter.kt */
        @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\n¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/ExponentialBackoffWithJitter$Config$Builder;", "Laws/smithy/kotlin/runtime/retries/delay/DelayProvider$Config$Builder;", "<init>", "()V", "Lkotlin/time/Duration;", "initialDelay", "J", "getInitialDelay-UwyO8pc", "()J", "setInitialDelay-LRDsOJo", "(J)V", "", "scaleFactor", "D", "getScaleFactor", "()D", "setScaleFactor", "(D)V", "jitter", "getJitter", "setJitter", "maxBackoff", "getMaxBackoff-UwyO8pc", "setMaxBackoff-LRDsOJo", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public static final class Builder implements DelayProvider.Config.Builder {
            private long initialDelay;
            private double jitter;
            private long maxBackoff;
            private double scaleFactor;

            public Builder() {
                Duration.Companion companion = Duration.INSTANCE;
                this.initialDelay = DurationKt.toDuration(10, DurationUnit.MILLISECONDS);
                this.scaleFactor = 1.5d;
                this.jitter = 1.0d;
                Duration.Companion companion2 = Duration.INSTANCE;
                this.maxBackoff = DurationKt.toDuration(20, DurationUnit.SECONDS);
            }

            /* JADX INFO: renamed from: getInitialDelay-UwyO8pc, reason: not valid java name and from getter */
            public final long getInitialDelay() {
                return this.initialDelay;
            }

            /* JADX INFO: renamed from: setInitialDelay-LRDsOJo, reason: not valid java name */
            public final void m12244setInitialDelayLRDsOJo(long j) {
                this.initialDelay = j;
            }

            public final double getScaleFactor() {
                return this.scaleFactor;
            }

            public final void setScaleFactor(double d) {
                this.scaleFactor = d;
            }

            public final double getJitter() {
                return this.jitter;
            }

            public final void setJitter(double d) {
                this.jitter = d;
            }

            /* JADX INFO: renamed from: getMaxBackoff-UwyO8pc, reason: not valid java name and from getter */
            public final long getMaxBackoff() {
                return this.maxBackoff;
            }

            /* JADX INFO: renamed from: setMaxBackoff-LRDsOJo, reason: not valid java name */
            public final void m12245setMaxBackoffLRDsOJo(long j) {
                this.maxBackoff = j;
            }
        }
    }
}
