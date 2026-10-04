package com.survicate.surveys.infrastructure.network;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.serialization.WorkspaceSerializer;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkspaceApi.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/SurvicateWorkspaceApi;", "Lcom/survicate/surveys/infrastructure/network/WorkspaceApi;", "requestFactory", "Lcom/survicate/surveys/infrastructure/network/WorkspaceRequestFactory;", "serializer", "Lcom/survicate/surveys/infrastructure/serialization/WorkspaceSerializer;", "httpClient", "Lcom/survicate/surveys/infrastructure/network/SurvicateHttpClient;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/WorkspaceRequestFactory;Lcom/survicate/surveys/infrastructure/serialization/WorkspaceSerializer;Lcom/survicate/surveys/infrastructure/network/SurvicateHttpClient;)V", "fetchWorkspace", "Lcom/survicate/surveys/infrastructure/network/NetworkWorkspace;", "sendInstalled", "", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/InstalledRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateWorkspaceApi implements WorkspaceApi {
    private final SurvicateHttpClient httpClient;
    private final WorkspaceRequestFactory requestFactory;
    private final WorkspaceSerializer serializer;

    public SurvicateWorkspaceApi(WorkspaceRequestFactory requestFactory, WorkspaceSerializer serializer, SurvicateHttpClient httpClient) {
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.requestFactory = requestFactory;
        this.serializer = serializer;
        this.httpClient = httpClient;
    }

    @Override // com.survicate.surveys.infrastructure.network.WorkspaceApi
    public NetworkWorkspace fetchWorkspace() throws IOException {
        String strLoadUrlResponse = this.httpClient.loadUrlResponse(this.requestFactory.createWorkspaceRequest());
        if (strLoadUrlResponse == null) {
            throw new IOException("Failed to fetch workspace: empty API response");
        }
        return this.serializer.deserializeWorkspace(strLoadUrlResponse);
    }

    @Override // com.survicate.surveys.infrastructure.network.WorkspaceApi
    public void sendInstalled(InstalledRequestBody body) throws IOException {
        Intrinsics.checkNotNullParameter(body, "body");
        this.httpClient.loadUrlResponse(this.requestFactory.createInstalledRequest(body));
    }
}
