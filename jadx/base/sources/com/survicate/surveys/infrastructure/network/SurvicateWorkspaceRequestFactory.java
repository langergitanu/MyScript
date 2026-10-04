package com.survicate.surveys.infrastructure.network;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.environment.UrlProvider;
import com.survicate.surveys.infrastructure.serialization.WorkspaceSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkspaceRequestFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/SurvicateWorkspaceRequestFactory;", "Lcom/survicate/surveys/infrastructure/network/WorkspaceRequestFactory;", "urlProvider", "Lcom/survicate/surveys/infrastructure/environment/UrlProvider;", "serializer", "Lcom/survicate/surveys/infrastructure/serialization/WorkspaceSerializer;", "<init>", "(Lcom/survicate/surveys/infrastructure/environment/UrlProvider;Lcom/survicate/surveys/infrastructure/serialization/WorkspaceSerializer;)V", "createWorkspaceRequest", "Lcom/survicate/surveys/infrastructure/network/URLRequest;", "createInstalledRequest", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/InstalledRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateWorkspaceRequestFactory implements WorkspaceRequestFactory {
    private final WorkspaceSerializer serializer;
    private final UrlProvider urlProvider;

    public SurvicateWorkspaceRequestFactory(UrlProvider urlProvider, WorkspaceSerializer serializer) {
        Intrinsics.checkNotNullParameter(urlProvider, "urlProvider");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.urlProvider = urlProvider;
        this.serializer = serializer;
    }

    @Override // com.survicate.surveys.infrastructure.network.WorkspaceRequestFactory
    public URLRequest createWorkspaceRequest() {
        return new URLRequest(this.urlProvider.resolveWorkspaceUrl(), "GET", null);
    }

    @Override // com.survicate.surveys.infrastructure.network.WorkspaceRequestFactory
    public URLRequest createInstalledRequest(InstalledRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new URLRequest(this.urlProvider.resolveInstalledUrl(), "POST", this.serializer.serializeInstalledRequestBody(body));
    }
}
