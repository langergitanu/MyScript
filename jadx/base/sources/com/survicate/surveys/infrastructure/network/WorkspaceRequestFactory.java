package com.survicate.surveys.infrastructure.network;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;

/* JADX INFO: compiled from: WorkspaceRequestFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/WorkspaceRequestFactory;", "", "createWorkspaceRequest", "Lcom/survicate/surveys/infrastructure/network/URLRequest;", "createInstalledRequest", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/InstalledRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface WorkspaceRequestFactory {
    URLRequest createInstalledRequest(InstalledRequestBody body);

    URLRequest createWorkspaceRequest();
}
