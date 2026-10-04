package com.survicate.surveys.infrastructure.serialization;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.network.InstalledRequestBody;
import com.survicate.surveys.infrastructure.network.NetworkWorkspace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: WorkspaceSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/serialization/SurvicateWorkspaceSerializer;", "Lcom/survicate/surveys/infrastructure/serialization/WorkspaceSerializer;", "jsonSerialization", "Lkotlinx/serialization/json/Json;", "<init>", "(Lkotlinx/serialization/json/Json;)V", "deserializeWorkspace", "Lcom/survicate/surveys/infrastructure/network/NetworkWorkspace;", "rawData", "", "serializeInstalledRequestBody", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/InstalledRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateWorkspaceSerializer implements WorkspaceSerializer {
    private final Json jsonSerialization;

    public SurvicateWorkspaceSerializer(Json jsonSerialization) {
        Intrinsics.checkNotNullParameter(jsonSerialization, "jsonSerialization");
        this.jsonSerialization = jsonSerialization;
    }

    @Override // com.survicate.surveys.infrastructure.serialization.WorkspaceSerializer
    public NetworkWorkspace deserializeWorkspace(String rawData) {
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return (NetworkWorkspace) json.decodeFromString(NetworkWorkspace.INSTANCE.serializer(), rawData);
    }

    @Override // com.survicate.surveys.infrastructure.serialization.WorkspaceSerializer
    public String serializeInstalledRequestBody(InstalledRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(InstalledRequestBody.INSTANCE.serializer(), body);
    }
}
