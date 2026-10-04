package aws.smithy.kotlin.runtime.client.region;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: RegionProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/region/RegionProvider;", "", "getRegion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface RegionProvider {
    Object getRegion(Continuation<? super String> continuation);
}
