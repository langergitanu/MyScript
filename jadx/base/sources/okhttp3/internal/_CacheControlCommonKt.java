package okhttp3.internal;

import androidx.collection.SieveCacheKt;
import com.survicate.surveys.TextRecallingManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: -CacheControlCommon.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0002*\u00020\u0007H\u0000\u001a\f\u0010\t\u001a\u00020\u0002*\u00020\nH\u0000\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\f\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\r\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\u000e\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\u000f\u001a\u00020\n*\u00020\nH\u0000\u001a\u0014\u0010\u0010\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u001e\u0010\u0013\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0002¨\u0006\u0016"}, m1599d2 = {"commonToString", "", "Lokhttp3/CacheControl;", "commonClampToInt", "", "", "commonForceNetwork", "Lokhttp3/CacheControl$Companion;", "commonForceCache", "commonBuild", "Lokhttp3/CacheControl$Builder;", "commonNoCache", "commonNoStore", "commonOnlyIfCached", "commonNoTransform", "commonImmutable", "commonParse", "headers", "Lokhttp3/Headers;", "indexOfElement", "characters", "startIndex", "okhttp"}, m1600k = 2, m1601mv = {2, 2, 0}, m1603xi = 48)
public final class _CacheControlCommonKt {
    public static final int commonClampToInt(long j) {
        if (j > SieveCacheKt.NodeLinkMask) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public static final String commonToString(CacheControl cacheControl) {
        Intrinsics.checkNotNullParameter(cacheControl, "<this>");
        String headerValue = cacheControl.getHeaderValue();
        if (headerValue != null) {
            return headerValue;
        }
        StringBuilder sb = new StringBuilder();
        if (cacheControl.noCache()) {
            sb.append("no-cache, ");
        }
        if (cacheControl.noStore()) {
            sb.append("no-store, ");
        }
        if (cacheControl.maxAgeSeconds() != -1) {
            sb.append("max-age=").append(cacheControl.maxAgeSeconds()).append(TextRecallingManager.ANSWER_SEPARATOR);
        }
        if (cacheControl.sMaxAgeSeconds() != -1) {
            sb.append("s-maxage=").append(cacheControl.sMaxAgeSeconds()).append(TextRecallingManager.ANSWER_SEPARATOR);
        }
        if (cacheControl.getIsPrivate()) {
            sb.append("private, ");
        }
        if (cacheControl.getIsPublic()) {
            sb.append("public, ");
        }
        if (cacheControl.mustRevalidate()) {
            sb.append("must-revalidate, ");
        }
        if (cacheControl.maxStaleSeconds() != -1) {
            sb.append("max-stale=").append(cacheControl.maxStaleSeconds()).append(TextRecallingManager.ANSWER_SEPARATOR);
        }
        if (cacheControl.minFreshSeconds() != -1) {
            sb.append("min-fresh=").append(cacheControl.minFreshSeconds()).append(TextRecallingManager.ANSWER_SEPARATOR);
        }
        if (cacheControl.onlyIfCached()) {
            sb.append("only-if-cached, ");
        }
        if (cacheControl.noTransform()) {
            sb.append("no-transform, ");
        }
        if (cacheControl.immutable()) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(sb.delete(sb.length() - 2, sb.length()), "delete(...)");
        String string = sb.toString();
        cacheControl.setHeaderValue$okhttp(string);
        return string;
    }

    public static final CacheControl commonForceNetwork(CacheControl.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new CacheControl.Builder().noCache().build();
    }

    public static final CacheControl commonForceCache(CacheControl.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        CacheControl.Builder builderOnlyIfCached = new CacheControl.Builder().onlyIfCached();
        Duration.Companion companion2 = Duration.INSTANCE;
        return builderOnlyIfCached.m16257maxStaleLRDsOJo(DurationKt.toDuration(Integer.MAX_VALUE, DurationUnit.SECONDS)).build();
    }

    public static final CacheControl commonBuild(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return new CacheControl(builder.getNoCache(), builder.getNoStore(), builder.getMaxAgeSeconds(), -1, false, false, false, builder.getMaxStaleSeconds(), builder.getMinFreshSeconds(), builder.getOnlyIfCached(), builder.getNoTransform(), builder.getImmutable(), null);
    }

    public static final CacheControl.Builder commonNoCache(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoCache$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoStore(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoStore$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonOnlyIfCached(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setOnlyIfCached$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoTransform(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoTransform$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonImmutable(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setImmutable$okhttp(true);
        return builder;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final CacheControl commonParse(CacheControl.Companion companion, Headers headers) {
        int i;
        int i2;
        int i3;
        String string;
        Headers headers2 = headers;
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        int size = headers2.size();
        boolean z = true;
        boolean z2 = true;
        int i4 = 0;
        String str = null;
        boolean z3 = false;
        boolean z4 = false;
        int nonNegativeInt = -1;
        int nonNegativeInt2 = -1;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int nonNegativeInt3 = -1;
        int nonNegativeInt4 = -1;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (i4 < size) {
            String strName = headers2.name(i4);
            String strValue = headers2.value(i4);
            if (!StringsKt.equals(strName, "Cache-Control", z)) {
                if (!StringsKt.equals(strName, "Pragma", z)) {
                    i4++;
                    headers2 = headers;
                    size = size;
                }
            } else {
                if (str == null) {
                    str = strValue;
                }
                i = 0;
                while (i < strValue.length()) {
                    int iIndexOfElement = indexOfElement(strValue, "=,;", i);
                    String strSubstring = strValue.substring(i, iIndexOfElement);
                    boolean z11 = z;
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    String string2 = StringsKt.trim((CharSequence) strSubstring).toString();
                    if (iIndexOfElement != strValue.length()) {
                        i2 = size;
                        if (strValue.charAt(iIndexOfElement) != ',' && strValue.charAt(iIndexOfElement) != ';') {
                            int iIndexOfNonWhitespace = _UtilCommonKt.indexOfNonWhitespace(strValue, iIndexOfElement + 1);
                            if (iIndexOfNonWhitespace < strValue.length() && strValue.charAt(iIndexOfNonWhitespace) == '\"') {
                                int i5 = iIndexOfNonWhitespace + 1;
                                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) strValue, '\"', i5, false, 4, (Object) null);
                                string = strValue.substring(i5, iIndexOf$default);
                                Intrinsics.checkNotNullExpressionValue(string, "substring(...)");
                                i3 = iIndexOf$default + 1;
                            } else {
                                int iIndexOfElement2 = indexOfElement(strValue, ",;", iIndexOfNonWhitespace);
                                String strSubstring2 = strValue.substring(iIndexOfNonWhitespace, iIndexOfElement2);
                                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                                string = StringsKt.trim((CharSequence) strSubstring2).toString();
                                i3 = iIndexOfElement2;
                            }
                        }
                        z = z11;
                        if (!StringsKt.equals("no-cache", string2, z)) {
                            i = i3;
                            z3 = z;
                        } else if (StringsKt.equals("no-store", string2, z)) {
                            i = i3;
                            z4 = z;
                        } else {
                            if (StringsKt.equals(ClientCookie.MAX_AGE_ATTR, string2, z)) {
                                nonNegativeInt = _UtilCommonKt.toNonNegativeInt(string, -1);
                            } else if (StringsKt.equals("s-maxage", string2, z)) {
                                nonNegativeInt2 = _UtilCommonKt.toNonNegativeInt(string, -1);
                            } else if (StringsKt.equals("private", string2, z)) {
                                i = i3;
                                z5 = z;
                            } else if (StringsKt.equals("public", string2, z)) {
                                i = i3;
                                z6 = z;
                            } else if (StringsKt.equals("must-revalidate", string2, z)) {
                                i = i3;
                                z7 = z;
                            } else if (StringsKt.equals("max-stale", string2, z)) {
                                nonNegativeInt3 = _UtilCommonKt.toNonNegativeInt(string, Integer.MAX_VALUE);
                            } else if (StringsKt.equals("min-fresh", string2, z)) {
                                nonNegativeInt4 = _UtilCommonKt.toNonNegativeInt(string, -1);
                            } else if (StringsKt.equals("only-if-cached", string2, z)) {
                                i = i3;
                                z8 = z;
                            } else if (StringsKt.equals("no-transform", string2, z)) {
                                i = i3;
                                z9 = z;
                            } else {
                                boolean zEquals = StringsKt.equals("immutable", string2, z);
                                i = i3;
                                if (zEquals) {
                                    z10 = z;
                                }
                            }
                            i = i3;
                        }
                        size = i2;
                    } else {
                        i2 = size;
                    }
                    i3 = iIndexOfElement + 1;
                    string = null;
                    z = z11;
                    if (!StringsKt.equals("no-cache", string2, z)) {
                    }
                    size = i2;
                }
                i4++;
                headers2 = headers;
                size = size;
            }
            z2 = false;
            i = 0;
            while (i < strValue.length()) {
            }
            i4++;
            headers2 = headers;
            size = size;
        }
        return new CacheControl(z3, z4, nonNegativeInt, nonNegativeInt2, z5, z6, z7, nonNegativeInt3, nonNegativeInt4, z8, z9, z10, !z2 ? null : str);
    }

    static /* synthetic */ int indexOfElement$default(String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOfElement(str, str2, i);
    }

    private static final int indexOfElement(String str, String str2, int i) {
        int length = str.length();
        while (i < length) {
            if (StringsKt.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
