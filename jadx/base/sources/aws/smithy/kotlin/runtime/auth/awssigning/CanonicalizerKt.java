package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.net.url.QueryParameters;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.net.url.UrlPath;
import aws.smithy.kotlin.runtime.text.encoding.Encodable;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Canonicalizer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\f\u0010\t\u001a\u00020\u0002*\u00020\u0006H\u0000\u001a\u001e\u0010\n\u001a\u00020\u0002*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000bH\u0002\u001a\f\u0010\u000f\u001a\u00020\u0002*\u00020\u0002H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"skipHeaders", "", "", "STREAM_CHUNK_BYTES", "", "canonicalPath", "Laws/smithy/kotlin/runtime/net/url/Url$Builder;", "config", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "canonicalQueryParams", "canonicalLine", "Lkotlin/Pair;", "", "multipleSpaces", "Lkotlin/text/Regex;", "trimAll", "includeHeader", "", "name", "aws-signing-default"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CanonicalizerKt {
    private static final int STREAM_CHUNK_BYTES = 16384;
    private static final Set<String> skipHeaders = SetsKt.setOf((Object[]) new String[]{"expect", "sec-websocket-key", "sec-websocket-protocol", "sec-websocket-version", "user-agent", "x-amzn-trace-id", "connection", "keep-alive", "proxy-authenticate", "proxy-authorization", "te", "trailers", "transfer-encoding", "upgrade"});
    private static final Regex multipleSpaces = new Regex(" +");

    /* JADX INFO: Access modifiers changed from: private */
    public static final Encodable canonicalPath$lambda$1(Encodable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    public static final String canonicalPath(Url.Builder builder, AwsSigningConfig config) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        UrlPath.Builder path = builder.getPath();
        List<Encodable> segments = path.getSegments();
        Function1 function1 = config.getUseDoubleUriEncode() ? new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.CanonicalizerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CanonicalizerKt.canonicalPath$lambda$0((Encodable) obj);
            }
        } : new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.CanonicalizerKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CanonicalizerKt.canonicalPath$lambda$1((Encodable) obj);
            }
        };
        UrlPath.Companion companion = UrlPath.INSTANCE;
        UrlPath.Builder builder2 = new UrlPath.Builder();
        Collection segments2 = builder2.getSegments();
        Iterator<T> it = segments.iterator();
        while (it.hasNext()) {
            segments2.add(function1.invoke(it.next()));
        }
        builder2.setTrailingSlash(path.getTrailingSlash());
        if (config.getNormalizeUriPath()) {
            builder2.normalize();
        }
        return builder2.build().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Encodable canonicalPath$lambda$0(Encodable existing) {
        Intrinsics.checkNotNullParameter(existing, "existing");
        return PercentEncoding.INSTANCE.getSigV4().encodableFromDecoded(existing.getEncoded());
    }

    public static final String canonicalQueryParams(Url.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        QueryParameters.Companion companion = QueryParameters.INSTANCE;
        QueryParameters.Builder builder2 = new QueryParameters.Builder();
        Set<Map.Entry<Encodable, List<Encodable>>> setEntrySet = builder.getParameters().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Encodable encodable = (Encodable) entry.getKey();
            List list = (List) entry.getValue();
            Encodable encodableReencode = encodable.reencode(PercentEncoding.INSTANCE.getSigV4());
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(((Encodable) it2.next()).reencode(PercentEncoding.INSTANCE.getSigV4()));
            }
            Pair pairM1606to = TuplesKt.m1606to(encodableReencode, arrayList);
            linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
        }
        QueryParameters.Builder builder3 = builder2;
        for (Map.Entry entry2 : CollectionsKt.sortedWith(linkedHashMap.entrySet(), new Comparator() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.CanonicalizerKt$canonicalQueryParams$lambda$0$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((Encodable) ((Map.Entry) t).getKey()).getEncoded(), ((Encodable) ((Map.Entry) t2).getKey()).getEncoded());
            }
        })) {
            Pair pairM1606to2 = TuplesKt.m1606to((Encodable) entry2.getKey(), CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith((List) entry2.getValue(), new Comparator() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.CanonicalizerKt$canonicalQueryParams$lambda$0$2$$inlined$compareBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((Encodable) t).getEncoded(), ((Encodable) t2).getEncoded());
                }
            })));
            builder3.put(pairM1606to2.getFirst(), pairM1606to2.getSecond());
        }
        return StringsKt.removePrefix(builder2.build().toString(), (CharSequence) "?");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String canonicalLine(Pair<String, ? extends List<String>> pair) {
        return pair.getFirst() + AbstractJsonLexerKt.COLON + CollectionsKt.joinToString$default(pair.getSecond(), ",", null, null, 0, null, new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.CanonicalizerKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CanonicalizerKt.canonicalLine$lambda$0((String) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence canonicalLine$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return trimAll(it);
    }

    private static final String trimAll(String str) {
        return StringsKt.trim((CharSequence) multipleSpaces.replace(str, " ")).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean includeHeader(String str, AwsSigningConfig awsSigningConfig) {
        Set<String> set = skipHeaders;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return !set.contains(lowerCase) && awsSigningConfig.getShouldSignHeader().invoke(str).booleanValue();
    }
}
