package aws.sdk.kotlin.runtime.region;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.ConfigurationException;
import aws.sdk.kotlin.runtime.InternalSdkApi;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;

/* JADX INFO: compiled from: ValidateRegion.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007\u001a\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, m1599d2 = {"charSet", "", "", "chars", "", "range", "Lkotlin/ranges/CharRange;", "isRegionValid", "", TtmlNode.TAG_REGION, "validateRegion", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ValidateRegionKt {
    public static final Set<Character> charSet(String chars) {
        Intrinsics.checkNotNullParameter(chars, "chars");
        char[] charArray = chars.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        return ArraysKt.toSet(charArray);
    }

    public static final Set<Character> charSet(CharRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        return CollectionsKt.toSet(range);
    }

    @InternalSdkApi
    public static final boolean isRegionValid(String region) {
        Intrinsics.checkNotNullParameter(region, "region");
        String str = region;
        if (str.length() > 0) {
            Set<Character> regName = Rfc3986CharSets.INSTANCE.getRegName();
            for (int i = 0; i < str.length(); i++) {
                if (regName.contains(Character.valueOf(str.charAt(i)))) {
                }
            }
            return true;
        }
        return false;
    }

    @InternalSdkApi
    public static final String validateRegion(String region) {
        Intrinsics.checkNotNullParameter(region, "region");
        if (isRegionValid(region)) {
            return region;
        }
        throw new ConfigurationException("Configured region \"" + region + "\" is invalid. A region must be a valid URI host component.");
    }
}
