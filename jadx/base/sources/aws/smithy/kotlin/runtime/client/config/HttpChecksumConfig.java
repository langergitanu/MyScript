package aws.smithy.kotlin.runtime.client.config;

import kotlin.Metadata;

/* JADX INFO: compiled from: HttpChecksumConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/config/HttpChecksumConfig;", "", "requestChecksumCalculation", "Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "getRequestChecksumCalculation", "()Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "responseChecksumValidation", "Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "getResponseChecksumValidation", "()Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "Builder", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface HttpChecksumConfig {

    /* JADX INFO: compiled from: HttpChecksumConfig.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/config/HttpChecksumConfig$Builder;", "", "requestChecksumCalculation", "Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "getRequestChecksumCalculation", "()Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", "setRequestChecksumCalculation", "(Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;)V", "responseChecksumValidation", "Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "getResponseChecksumValidation", "()Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "setResponseChecksumValidation", "(Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;)V", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder {
        RequestHttpChecksumConfig getRequestChecksumCalculation();

        ResponseHttpChecksumConfig getResponseChecksumValidation();

        void setRequestChecksumCalculation(RequestHttpChecksumConfig requestHttpChecksumConfig);

        void setResponseChecksumValidation(ResponseHttpChecksumConfig responseHttpChecksumConfig);
    }

    RequestHttpChecksumConfig getRequestChecksumCalculation();

    ResponseHttpChecksumConfig getResponseChecksumValidation();
}
