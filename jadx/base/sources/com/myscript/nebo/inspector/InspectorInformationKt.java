package com.myscript.nebo.inspector;

import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InspectorInformation.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m1599d2 = {"toJson", "", "Lcom/myscript/nebo/inspector/InspectorInformation;", "prettyPrint", "", "nebo-inspector_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InspectorInformationKt {
    public static /* synthetic */ String toJson$default(InspectorInformation inspectorInformation, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return toJson(inspectorInformation, z);
    }

    public static final String toJson(InspectorInformation inspectorInformation, boolean z) {
        Intrinsics.checkNotNullParameter(inspectorInformation, "<this>");
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (z) {
            gsonBuilder.setPrettyPrinting();
        }
        String json = gsonBuilder.create().toJson(inspectorInformation);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }
}
