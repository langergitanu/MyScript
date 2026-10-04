package com.myscript.nebo.sso.util;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSOCustomHeader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\u0005"}, m1599d2 = {"computeCustomHeaders", "", "", RemoteConfigConstants.RequestFieldKey.INSTANCE_ID, "appVersion", "sso_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SSOCustomHeaderKt {
    public static final Map<String, String> computeCustomHeaders(String appInstanceId, String appVersion) {
        Intrinsics.checkNotNullParameter(appInstanceId, "appInstanceId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        return MapsKt.mapOf(TuplesKt.m1606to("Nebo-Instance-Id", appInstanceId), TuplesKt.m1606to("Nebo-Version", "Android " + appVersion));
    }
}
