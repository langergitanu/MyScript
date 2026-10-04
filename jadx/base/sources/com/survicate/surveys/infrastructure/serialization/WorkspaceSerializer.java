package com.survicate.surveys.infrastructure.serialization;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.network.InstalledRequestBody;
import com.survicate.surveys.infrastructure.network.NetworkWorkspace;
import kotlin.Metadata;

/* JADX INFO: compiled from: WorkspaceSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/serialization/WorkspaceSerializer;", "", "deserializeWorkspace", "Lcom/survicate/surveys/infrastructure/network/NetworkWorkspace;", "rawData", "", "serializeInstalledRequestBody", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/InstalledRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface WorkspaceSerializer {
    NetworkWorkspace deserializeWorkspace(String rawData);

    String serializeInstalledRequestBody(InstalledRequestBody body);
}
