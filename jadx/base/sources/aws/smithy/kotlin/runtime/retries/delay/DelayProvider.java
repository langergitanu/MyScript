package aws.smithy.kotlin.runtime.retries.delay;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.retries.RetryStrategyConfigDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DelayProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/DelayProvider;", "", "", "attempt", "", "backoff", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/retries/delay/DelayProvider$Config;", "getConfig", "()Laws/smithy/kotlin/runtime/retries/delay/DelayProvider$Config;", "config", "Config", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface DelayProvider {

    /* JADX INFO: compiled from: DelayProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ \u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/DelayProvider$Config;", "", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/retries/delay/DelayProvider$Config$Builder;", "", "Lkotlin/ExtensionFunctionType;", "toBuilderApplicator", "()Lkotlin/jvm/functions/Function1;", "Builder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Config {

        /* JADX INFO: compiled from: DelayProvider.kt */
        @RetryStrategyConfigDsl
        @Metadata(m1598d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/retries/delay/DelayProvider$Config$Builder;", "", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
        public interface Builder {
        }

        @InternalApi
        Function1<Builder, Unit> toBuilderApplicator();
    }

    Object backoff(int i, Continuation<? super Unit> continuation);

    Config getConfig();
}
