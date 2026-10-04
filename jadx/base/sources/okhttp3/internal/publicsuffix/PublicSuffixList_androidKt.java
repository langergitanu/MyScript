package okhttp3.internal.publicsuffix;

import androidx.webkit.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.publicsuffix.PublicSuffixList;

/* JADX INFO: compiled from: PublicSuffixList.android.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {Profile.DEFAULT_PROFILE_NAME, "Lokhttp3/internal/publicsuffix/PublicSuffixList;", "Lokhttp3/internal/publicsuffix/PublicSuffixList$Companion;", "getDefault", "(Lokhttp3/internal/publicsuffix/PublicSuffixList$Companion;)Lokhttp3/internal/publicsuffix/PublicSuffixList;", "okhttp"}, m1600k = 2, m1601mv = {2, 2, 0}, m1603xi = 48)
public final class PublicSuffixList_androidKt {
    public static final PublicSuffixList getDefault(PublicSuffixList.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new AssetPublicSuffixList(null, 1, null);
    }
}
