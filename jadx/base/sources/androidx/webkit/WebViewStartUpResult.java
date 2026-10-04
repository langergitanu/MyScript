package androidx.webkit;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface WebViewStartUpResult {
    Long getMaxTimePerTaskInUiThreadMillis();

    List<StartUpLocation> getNonUiThreadBlockingStartUpLocations();

    Long getTotalTimeInUiThreadMillis();

    List<StartUpLocation> getUiThreadBlockingStartUpLocations();
}
