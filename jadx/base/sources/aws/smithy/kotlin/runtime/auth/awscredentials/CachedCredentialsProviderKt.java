package aws.smithy.kotlin.runtime.auth.awscredentials;

import aws.smithy.kotlin.runtime.time.Clock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: CachedCredentialsProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a/\u0010\t\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "Lkotlin/time/Duration;", "expireCredentialsAfter", "refreshBufferWindow", "Laws/smithy/kotlin/runtime/time/Clock;", "clock", "Laws/smithy/kotlin/runtime/auth/awscredentials/CachedCredentialsProvider;", "cached-vLdBGDU", "(Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;JJLaws/smithy/kotlin/runtime/time/Clock;)Laws/smithy/kotlin/runtime/auth/awscredentials/CachedCredentialsProvider;", "cached", "", "DEFAULT_CREDENTIALS_REFRESH_BUFFER_SECONDS", "I", "DEFAULT_CREDENTIALS_REFRESH_SECONDS", "aws-credentials"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CachedCredentialsProviderKt {
    private static final int DEFAULT_CREDENTIALS_REFRESH_BUFFER_SECONDS = 10;
    public static final int DEFAULT_CREDENTIALS_REFRESH_SECONDS = 900;

    /* JADX INFO: renamed from: cached-vLdBGDU$default, reason: not valid java name */
    public static /* synthetic */ CachedCredentialsProvider m12131cachedvLdBGDU$default(CredentialsProvider credentialsProvider, long j, long j2, Clock clock, int i, Object obj) {
        if ((i & 1) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            j = DurationKt.toDuration(900, DurationUnit.SECONDS);
        }
        long j3 = j;
        if ((i & 2) != 0) {
            Duration.Companion companion2 = Duration.INSTANCE;
            j2 = DurationKt.toDuration(10, DurationUnit.SECONDS);
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            clock = Clock.System.INSTANCE;
        }
        return m12130cachedvLdBGDU(credentialsProvider, j3, j4, clock);
    }

    /* JADX INFO: renamed from: cached-vLdBGDU, reason: not valid java name */
    public static final CachedCredentialsProvider m12130cachedvLdBGDU(CredentialsProvider cached, long j, long j2, Clock clock) {
        Intrinsics.checkNotNullParameter(cached, "$this$cached");
        Intrinsics.checkNotNullParameter(clock, "clock");
        return new CachedCredentialsProvider(cached, j, j2, clock, null);
    }
}
