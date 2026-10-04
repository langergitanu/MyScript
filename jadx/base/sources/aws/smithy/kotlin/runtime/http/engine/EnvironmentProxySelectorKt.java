package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.http.engine.ProxyConfig;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.util.EnvironmentProvider;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import aws.smithy.kotlin.runtime.util.PropertyProvider;
import com.survicate.surveys.TextRecallingManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: EnvironmentProxySelector.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/PropertyProvider;", "provider", "Laws/smithy/kotlin/runtime/net/Scheme;", "scheme", "Laws/smithy/kotlin/runtime/http/engine/ProxyConfig;", "resolveProxyByProperty", "(Laws/smithy/kotlin/runtime/util/PropertyProvider;Laws/smithy/kotlin/runtime/net/Scheme;)Laws/smithy/kotlin/runtime/http/engine/ProxyConfig;", "Laws/smithy/kotlin/runtime/util/EnvironmentProvider;", "resolveProxyByEnvironment", "(Laws/smithy/kotlin/runtime/util/EnvironmentProvider;Laws/smithy/kotlin/runtime/net/Scheme;)Laws/smithy/kotlin/runtime/http/engine/ProxyConfig;", "", "raw", "Laws/smithy/kotlin/runtime/http/engine/NonProxyHost;", "parseNonProxyHost", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/http/engine/NonProxyHost;", "Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;", "", "resolveNonProxyHosts", "(Laws/smithy/kotlin/runtime/util/PlatformEnvironProvider;)Ljava/util/Set;", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EnvironmentProxySelectorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ProxyConfig resolveProxyByProperty(PropertyProvider propertyProvider, Scheme scheme) {
        String str = scheme.getProtocolName() + ".proxyHost";
        String str2 = scheme.getProtocolName() + ".proxyPort";
        String property = propertyProvider.getProperty(str);
        String str3 = property;
        ProxyConfig.Http http = null;
        if (str3 == null || StringsKt.isBlank(str3)) {
            property = null;
        }
        String property2 = propertyProvider.getProperty(str2);
        String str4 = property2;
        if (str4 == null || StringsKt.isBlank(str4)) {
            property2 = null;
        }
        if (property != null) {
            Scheme http2 = Scheme.INSTANCE.getHTTP();
            try {
                Url.Companion companion = Url.INSTANCE;
                Url.Builder builder = new Url.Builder();
                builder.setScheme(http2);
                builder.setHost(Host.INSTANCE.parse(property));
                if (property2 != null) {
                    builder.setPort(Integer.valueOf(Integer.parseInt(property2)));
                }
                http = new ProxyConfig.Http(builder.build());
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append(str + "=\"" + property + '\"');
                if (property2 != null) {
                    sb.append(TextRecallingManager.ANSWER_SEPARATOR + str2 + "=\"" + property2 + '\"');
                }
                throw new ClientException("Could not parse " + sb.toString() + " into a valid proxy URL", e);
            }
        }
        return http;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProxyConfig resolveProxyByEnvironment(EnvironmentProvider environmentProvider, Scheme scheme) {
        ProxyConfig.Http http;
        StringBuilder sb = new StringBuilder();
        String lowerCase = scheme.getProtocolName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        StringBuilder sb2 = new StringBuilder();
        String upperCase = scheme.getProtocolName().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{sb.append(lowerCase).append("_proxy").toString(), sb2.append(upperCase).append("_PROXY").toString()}).iterator();
        do {
            http = null;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            String str2 = environmentProvider.getenv(str);
            String str3 = str2;
            if (str3 == null || StringsKt.isBlank(str3)) {
                str2 = null;
            }
            if (str2 != null) {
                try {
                    http = new ProxyConfig.Http(Url.Companion.parse$default(Url.INSTANCE, str2, null, 2, null));
                } catch (Exception e) {
                    throw new ClientException("Could not parse " + (str + "=\"" + str2 + '\"') + " into a valid proxy URL", e);
                }
            }
        } while (http == null);
        return http;
    }

    private static final NonProxyHost parseNonProxyHost(String str) {
        List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{AbstractJsonLexerKt.COLON}, false, 2, 2, (Object) null);
        int size = listSplit$default.size();
        if (size == 1) {
            return new NonProxyHost((String) listSplit$default.get(0), null, 2, null);
        }
        if (size == 2) {
            return new NonProxyHost((String) listSplit$default.get(0), Integer.valueOf(Integer.parseInt((String) listSplit$default.get(1))));
        }
        throw new IllegalStateException(("invalid non proxy host: " + str).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Set<NonProxyHost> resolveNonProxyHosts(PlatformEnvironProvider platformEnvironProvider) {
        Set setEmptySet;
        List listSplit$default;
        String property = platformEnvironProvider.getProperty("http.nonProxyHosts");
        if (property == null) {
            property = platformEnvironProvider.getProperty("http.noProxyHosts");
        }
        if (property == null || (listSplit$default = StringsKt.split$default((CharSequence) property, new char[]{'|'}, false, 0, 6, (Object) null)) == null) {
            setEmptySet = SetsKt.emptySet();
        } else {
            List list = listSplit$default;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(StringsKt.trimStart((String) it2.next(), '.'));
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                arrayList5.add(parseNonProxyHost((String) it3.next()));
            }
            setEmptySet = CollectionsKt.toSet(arrayList5);
            if (setEmptySet == null) {
            }
        }
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"no_proxy", "NO_PROXY"});
        ArrayList arrayList6 = new ArrayList();
        Iterator it4 = listListOf.iterator();
        while (it4.hasNext()) {
            String str = platformEnvironProvider.getenv((String) it4.next());
            if (str != null) {
                arrayList6.add(str);
            }
        }
        ArrayList arrayList7 = new ArrayList();
        Iterator it5 = arrayList6.iterator();
        while (it5.hasNext()) {
            CollectionsKt.addAll(arrayList7, StringsKt.split$default((CharSequence) it5.next(), new char[]{AbstractJsonLexerKt.COMMA, TokenParser.f2383SP}, false, 0, 6, (Object) null));
        }
        ArrayList arrayList8 = arrayList7;
        ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
        Iterator it6 = arrayList8.iterator();
        while (it6.hasNext()) {
            arrayList9.add(StringsKt.trim((CharSequence) it6.next()).toString());
        }
        ArrayList arrayList10 = arrayList9;
        ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList10, 10));
        Iterator it7 = arrayList10.iterator();
        while (it7.hasNext()) {
            arrayList11.add(StringsKt.trimStart((String) it7.next(), '.'));
        }
        ArrayList arrayList12 = arrayList11;
        ArrayList arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList12, 10));
        Iterator it8 = arrayList12.iterator();
        while (it8.hasNext()) {
            arrayList13.add(parseNonProxyHost((String) it8.next()));
        }
        return SetsKt.plus(setEmptySet, (Iterable) CollectionsKt.toSet(arrayList13));
    }
}
