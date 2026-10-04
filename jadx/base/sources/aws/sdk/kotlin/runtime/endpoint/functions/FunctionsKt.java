package aws.sdk.kotlin.runtime.endpoint.functions;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.smithy.kotlin.runtime.net.TextKt;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Functions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007\u001a\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0007\u001a\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007\u001a\f\u0010\u0014\u001a\u00020\u0012*\u00020\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"ARN_COMPONENT_COUNT", "", "ARN_INDEX_PARTITION", "ARN_INDEX_VENDOR", "ARN_INDEX_REGION", "ARN_INDEX_NAMESPACE", "ARN_INDEX_RELATIVE_ID", "partition", "Laws/sdk/kotlin/runtime/endpoint/functions/PartitionConfig;", "partitions", "", "Laws/sdk/kotlin/runtime/endpoint/functions/Partition;", TtmlNode.TAG_REGION, "", "parseArn", "Laws/sdk/kotlin/runtime/endpoint/functions/Arn;", "value", "isVirtualHostableS3Bucket", "", "allowSubdomains", "isVirtualHostableS3Segment", "aws-endpoint"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FunctionsKt {
    private static final int ARN_COMPONENT_COUNT = 6;
    private static final int ARN_INDEX_NAMESPACE = 4;
    private static final int ARN_INDEX_PARTITION = 1;
    private static final int ARN_INDEX_REGION = 3;
    private static final int ARN_INDEX_RELATIVE_ID = 5;
    private static final int ARN_INDEX_VENDOR = 2;

    @InternalSdkApi
    public static final PartitionConfig partition(List<Partition> partitions, String str) {
        Object next;
        Object next2;
        Object next3;
        Intrinsics.checkNotNullParameter(partitions, "partitions");
        if (str != null) {
            List<Partition> list = partitions;
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((Partition) next).getRegions().containsKey(str)) {
                    break;
                }
            }
            Partition partition = (Partition) next;
            if (partition != null) {
                PartitionConfig baseConfig = partition.getBaseConfig();
                PartitionConfig partitionConfig = partition.getRegions().get(str);
                Intrinsics.checkNotNull(partitionConfig);
                return baseConfig.mergeWith(partitionConfig);
            }
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
                if (((Partition) next2).getRegionRegex().matches(str)) {
                    break;
                }
            }
            Partition partition2 = (Partition) next2;
            if (partition2 == null) {
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (Intrinsics.areEqual(((Partition) next3).getId(), "aws")) {
                        break;
                    }
                }
                partition2 = (Partition) next3;
            }
            if (partition2 != null) {
                return partition2.getBaseConfig();
            }
        }
        return null;
    }

    @InternalSdkApi
    public static final Arn parseArn(String str) {
        if (str == null) {
            return null;
        }
        List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{AbstractJsonLexerKt.COLON}, false, 6, 2, (Object) null);
        if (!Intrinsics.areEqual(listSplit$default.get(0), "arn") || listSplit$default.size() != 6 || ((CharSequence) listSplit$default.get(1)).length() == 0 || ((CharSequence) listSplit$default.get(2)).length() == 0 || ((CharSequence) listSplit$default.get(5)).length() == 0) {
            return null;
        }
        return new Arn((String) listSplit$default.get(1), (String) listSplit$default.get(2), (String) listSplit$default.get(3), (String) listSplit$default.get(4), StringsKt.split$default((CharSequence) listSplit$default.get(5), new char[]{AbstractJsonLexerKt.COLON, JsonPointer.SEPARATOR}, false, 0, 6, (Object) null));
    }

    @InternalSdkApi
    public static final boolean isVirtualHostableS3Bucket(String str, boolean z) {
        if (str == null || !aws.smithy.kotlin.runtime.client.endpoints.functions.FunctionsKt.isValidHostLabel(str, z)) {
            return false;
        }
        if (!z) {
            return isVirtualHostableS3Segment(str);
        }
        List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        if ((listSplit$default instanceof Collection) && listSplit$default.isEmpty()) {
            return true;
        }
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            if (!isVirtualHostableS3Segment((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static final boolean isVirtualHostableS3Segment(String str) {
        int length = str.length();
        if (3 <= length && length < 64) {
            String str2 = str;
            int i = 0;
            while (true) {
                if (i >= str2.length()) {
                    if (TextKt.isIpv4(str) || TextKt.isIpv6(str)) {
                        break;
                    }
                    return true;
                }
                char cCharAt = str2.charAt(i);
                if ('A' <= cCharAt && cCharAt < '[') {
                    break;
                }
                i++;
            }
        }
        return false;
    }
}
