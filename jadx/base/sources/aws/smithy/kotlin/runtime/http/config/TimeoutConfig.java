package aws.smithy.kotlin.runtime.http.config;

import kotlin.Metadata;
import kotlin.time.Duration;

/* JADX INFO: compiled from: TimeoutConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/config/TimeoutConfig;", "", "Lkotlin/time/Duration;", "getAttemptTimeout-FghU774", "()Lkotlin/time/Duration;", "attemptTimeout", "getCallTimeout-FghU774", "callTimeout", "Builder", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface TimeoutConfig {

    /* JADX INFO: compiled from: TimeoutConfig.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/config/TimeoutConfig$Builder;", "", "Lkotlin/time/Duration;", "getAttemptTimeout-FghU774", "()Lkotlin/time/Duration;", "setAttemptTimeout-BwNAW2A", "(Lkotlin/time/Duration;)V", "attemptTimeout", "getCallTimeout-FghU774", "setCallTimeout-BwNAW2A", "callTimeout", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder {
        /* JADX INFO: renamed from: getAttemptTimeout-FghU774 */
        Duration mo12047getAttemptTimeoutFghU774();

        /* JADX INFO: renamed from: getCallTimeout-FghU774 */
        Duration mo12048getCallTimeoutFghU774();

        /* JADX INFO: renamed from: setAttemptTimeout-BwNAW2A */
        void mo12049setAttemptTimeoutBwNAW2A(Duration duration);

        /* JADX INFO: renamed from: setCallTimeout-BwNAW2A */
        void mo12050setCallTimeoutBwNAW2A(Duration duration);
    }

    /* JADX INFO: renamed from: getAttemptTimeout-FghU774 */
    Duration mo12045getAttemptTimeoutFghU774();

    /* JADX INFO: renamed from: getCallTimeout-FghU774 */
    Duration mo12046getCallTimeoutFghU774();
}
