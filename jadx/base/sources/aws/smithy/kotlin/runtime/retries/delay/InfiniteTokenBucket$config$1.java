package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InfiniteTokenBucket.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0017¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"aws/smithy/kotlin/runtime/retries/delay/InfiniteTokenBucket$config$1", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config;", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/delay/RetryTokenBucket$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "toBuilderApplicator", "()Lkotlin/jvm/functions/Function1;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InfiniteTokenBucket$config$1 implements RetryTokenBucket.Config {
    @Override // aws.smithy.kotlin.runtime.retries.delay.RetryTokenBucket.Config
    @InternalApi
    public Function1<RetryTokenBucket.Config.Builder, Unit> toBuilderApplicator() {
        return new Function1() { // from class: aws.smithy.kotlin.runtime.retries.delay.InfiniteTokenBucket$config$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InfiniteTokenBucket$config$1.toBuilderApplicator$lambda$0((RetryTokenBucket.Config.Builder) obj);
            }
        };
    }

    InfiniteTokenBucket$config$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toBuilderApplicator$lambda$0(RetryTokenBucket.Config.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return Unit.INSTANCE;
    }
}
