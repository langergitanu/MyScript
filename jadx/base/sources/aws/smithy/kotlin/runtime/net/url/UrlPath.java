package aws.smithy.kotlin.runtime.net.url;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import aws.smithy.kotlin.runtime.collections.views.ConvertersKt;
import aws.smithy.kotlin.runtime.net.url.UrlEncoding;
import aws.smithy.kotlin.runtime.text.encoding.Encodable;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.text.StringsKt;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: UrlPath.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B!\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u000fH\u0096\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001e\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014¨\u0006!"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UrlPath;", "", "", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "segments", "", "trailingSlash", "<init>", "(Ljava/util/List;Z)V", "Laws/smithy/kotlin/runtime/net/url/UrlPath$Builder;", "toBuilder", "()Laws/smithy/kotlin/runtime/net/url/UrlPath$Builder;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getSegments", "()Ljava/util/List;", "Z", "getTrailingSlash", "()Z", "getDecoded", "decoded", "getEncoded", "encoded", "Companion", "Builder", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UrlPath {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UrlPath Empty = new Builder().build();
    private final List<Encodable> segments;
    private final boolean trailingSlash;

    public /* synthetic */ UrlPath(List list, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z);
    }

    private UrlPath(List<Encodable> list, boolean z) {
        this.segments = list;
        this.trailingSlash = z;
    }

    /* synthetic */ UrlPath(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? false : z);
    }

    public final List<Encodable> getSegments() {
        return this.segments;
    }

    public final boolean getTrailingSlash() {
        return this.trailingSlash;
    }

    /* JADX INFO: compiled from: UrlPath.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\nø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0012\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J9\u0010\u0016\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UrlPath$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/net/url/UrlPath$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Laws/smithy/kotlin/runtime/net/url/UrlPath;", "invoke", "(Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/net/url/UrlPath;", "", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "segments", "", "trailingSlash", "", "asDecoded", "(Ljava/util/List;Z)Ljava/lang/String;", "asEncoded", "encodableForm", "asString", "(Ljava/util/List;ZLkotlin/jvm/functions/Function1;)Ljava/lang/String;", "decoded", "parseDecoded", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/net/url/UrlPath;", "encoded", "parseEncoded", "Empty", "Laws/smithy/kotlin/runtime/net/url/UrlPath;", "getEmpty", "()Laws/smithy/kotlin/runtime/net/url/UrlPath;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UrlPath getEmpty() {
            return UrlPath.Empty;
        }

        public final UrlPath invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String asDecoded(List<Encodable> segments, boolean trailingSlash) {
            return asString(segments, trailingSlash, new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.UrlPath$Companion$asDecoded$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getDecoded();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String asEncoded(List<Encodable> segments, boolean trailingSlash) {
            return asString(segments, trailingSlash, new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.UrlPath$Companion$asEncoded$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getEncoded();
                }
            });
        }

        private final String asString(List<Encodable> segments, boolean trailingSlash, Function1<? super Encodable, String> encodableForm) {
            List<Encodable> list = segments;
            CharSequence charSequence = DomExceptionUtils.SEPARATOR;
            CharSequence charSequence2 = charSequence;
            CharSequence charSequence3 = segments.isEmpty() ? "" : charSequence;
            if (!trailingSlash) {
                charSequence = "";
            }
            return CollectionsKt.joinToString$default(list, charSequence2, charSequence3, charSequence, 0, null, encodableForm, 24, null);
        }

        public final UrlPath parseDecoded(String decoded) {
            Intrinsics.checkNotNullParameter(decoded, "decoded");
            Companion companion = UrlPath.INSTANCE;
            Builder builder = new Builder();
            builder.parseDecoded$runtime_core(decoded);
            return builder.build();
        }

        public final UrlPath parseEncoded(String encoded) {
            Intrinsics.checkNotNullParameter(encoded, "encoded");
            Companion companion = UrlPath.INSTANCE;
            Builder builder = new Builder();
            builder.parseEncoded$runtime_core(encoded);
            return builder.build();
        }
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        UrlPath urlPath = (UrlPath) other;
        return Intrinsics.areEqual(this.segments, urlPath.segments) && this.trailingSlash == urlPath.trailingSlash;
    }

    public int hashCode() {
        return (this.segments.hashCode() * 31) + Boolean.hashCode(this.trailingSlash);
    }

    public final String getDecoded() {
        return INSTANCE.asDecoded(this.segments, this.trailingSlash);
    }

    public final String getEncoded() {
        return INSTANCE.asEncoded(this.segments, this.trailingSlash);
    }

    public String toString() {
        return getEncoded();
    }

    /* JADX INFO: compiled from: UrlPath.kt */
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J,\u0010\r\u001a\u00020\n2\u001d\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b¢\u0006\u0004\b\r\u0010\u000eJ,\u0010\u000f\u001a\u00020\n2\u001d\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0006J\u001f\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\tH\u0000¢\u0006\u0004\b\u001c\u0010\u0019J+\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\t2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e0\u0007H\u0002¢\u0006\u0004\b\u0016\u0010 J\r\u0010!\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b$\u0010\u0005J\u0015\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0000¢\u0006\u0004\b$\u0010%R$\u0010\u0017\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u0019R$\u0010\u001b\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010(\"\u0004\b+\u0010\u0019R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001e0\b8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b0\u0010/R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010-\u001a\u0004\b1\u0010/R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u00069"}, m1599d2 = {"Laws/smithy/kotlin/runtime/net/url/UrlPath$Builder;", "", "Laws/smithy/kotlin/runtime/net/url/UrlPath;", ClientCookie.PATH_ATTR, "<init>", "(Laws/smithy/kotlin/runtime/net/url/UrlPath;)V", "()V", "Lkotlin/Function1;", "", "", "", "Lkotlin/ExtensionFunctionType;", "block", "decodedSegments", "(Lkotlin/jvm/functions/Function1;)V", "encodedSegments", "normalize", "text", "Laws/smithy/kotlin/runtime/net/url/UrlEncoding;", "encoding", "parse$runtime_core", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/net/url/UrlEncoding;)V", "parse", "decoded", "parseDecoded$runtime_core", "(Ljava/lang/String;)V", "parseDecoded", "encoded", "parseEncoded$runtime_core", "parseEncoded", "Laws/smithy/kotlin/runtime/text/encoding/Encodable;", "toEncodable", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "build", "()Laws/smithy/kotlin/runtime/net/url/UrlPath;", "other", "copyFrom", "(Laws/smithy/kotlin/runtime/net/url/UrlPath$Builder;)V", "value", "getDecoded", "()Ljava/lang/String;", "setDecoded", "getEncoded", "setEncoded", "segments", "Ljava/util/List;", "getSegments", "()Ljava/util/List;", "getDecodedSegments", "getEncodedSegments", "", "trailingSlash", "Z", "getTrailingSlash", "()Z", "setTrailingSlash", "(Z)V", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private final List<String> decodedSegments;
        private final List<String> encodedSegments;
        private final List<Encodable> segments;
        private boolean trailingSlash;

        public Builder(UrlPath urlPath) {
            List<Encodable> segments;
            ArrayList arrayList = (urlPath == null || (segments = urlPath.getSegments()) == null || (arrayList = CollectionsKt.toMutableList((Collection) segments)) == null) ? new ArrayList() : arrayList;
            this.segments = arrayList;
            this.decodedSegments = ConvertersKt.m12154asView((List) arrayList, (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.UrlPath$Builder$decodedSegments$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getDecoded();
                }
            }, (Function1) new UrlPath$Builder$decodedSegments$2(PercentEncoding.INSTANCE.getPath()));
            this.encodedSegments = ConvertersKt.m12154asView((List) arrayList, (Function1) new PropertyReference1Impl() { // from class: aws.smithy.kotlin.runtime.net.url.UrlPath$Builder$encodedSegments$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((Encodable) obj).getEncoded();
                }
            }, (Function1) new UrlPath$Builder$encodedSegments$2(PercentEncoding.INSTANCE.getPath()));
            this.trailingSlash = urlPath != null ? urlPath.getTrailingSlash() : false;
        }

        public Builder() {
            this(null);
        }

        public final String getDecoded() {
            return UrlPath.INSTANCE.asDecoded(this.segments, this.trailingSlash);
        }

        public final void setDecoded(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            parseDecoded$runtime_core(value);
        }

        public final String getEncoded() {
            return UrlPath.INSTANCE.asEncoded(this.segments, this.trailingSlash);
        }

        public final void setEncoded(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            parseEncoded$runtime_core(value);
        }

        public final List<Encodable> getSegments() {
            return this.segments;
        }

        public final List<String> getDecodedSegments() {
            return this.decodedSegments;
        }

        public final void decodedSegments(Function1<? super List<String>, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(this.decodedSegments);
        }

        public final List<String> getEncodedSegments() {
            return this.encodedSegments;
        }

        public final void encodedSegments(Function1<? super List<String>, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(this.encodedSegments);
        }

        public final void normalize() {
            ListIterator<Encodable> listIterator = this.segments.listIterator();
            while (listIterator.hasNext()) {
                String decoded = listIterator.next().getDecoded();
                int iHashCode = decoded.hashCode();
                if (iHashCode != 0) {
                    if (iHashCode != 46) {
                        if (iHashCode == 1472 && decoded.equals("..")) {
                            listIterator.remove();
                            if (!listIterator.hasPrevious()) {
                                throw new IllegalStateException("Cannot normalize because \"..\" has no parent".toString());
                            }
                            listIterator.previous();
                            listIterator.remove();
                        }
                    } else if (decoded.equals(".")) {
                        listIterator.remove();
                    }
                } else if (decoded.equals("")) {
                    listIterator.remove();
                }
            }
            if (this.segments.isEmpty()) {
                this.trailingSlash = true;
            }
        }

        public final boolean getTrailingSlash() {
            return this.trailingSlash;
        }

        public final void setTrailingSlash(boolean z) {
            this.trailingSlash = z;
        }

        public final void parse$runtime_core(String text, UrlEncoding encoding) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(encoding, "encoding");
            if (encoding.contains(UrlEncoding.Path.INSTANCE)) {
                parseEncoded$runtime_core(text);
            } else {
                parseDecoded$runtime_core(text);
            }
        }

        public final void parseDecoded$runtime_core(String decoded) {
            Intrinsics.checkNotNullParameter(decoded, "decoded");
            parse(decoded, new UrlPath$Builder$parseDecoded$1(PercentEncoding.INSTANCE.getPath()));
        }

        public final void parseEncoded$runtime_core(String encoded) {
            Intrinsics.checkNotNullParameter(encoded, "encoded");
            parse(encoded, new UrlPath$Builder$parseEncoded$1(PercentEncoding.INSTANCE.getPath()));
        }

        private final void parse(String text, Function1<? super String, Encodable> toEncodable) {
            this.segments.clear();
            if (Intrinsics.areEqual(text, "")) {
                this.trailingSlash = false;
                return;
            }
            if (Intrinsics.areEqual(text, DomExceptionUtils.SEPARATOR)) {
                this.trailingSlash = true;
                return;
            }
            String strRemovePrefix = StringsKt.removePrefix(text, (CharSequence) DomExceptionUtils.SEPARATOR);
            boolean zEndsWith$default = StringsKt.endsWith$default((CharSequence) strRemovePrefix, JsonPointer.SEPARATOR, false, 2, (Object) null);
            this.trailingSlash = zEndsWith$default;
            if (zEndsWith$default) {
                strRemovePrefix = StringsKt.removeSuffix(strRemovePrefix, (CharSequence) DomExceptionUtils.SEPARATOR);
            }
            List listSplit$default = StringsKt.split$default((CharSequence) strRemovePrefix, new char[]{JsonPointer.SEPARATOR}, false, 0, 6, (Object) null);
            List<Encodable> list = this.segments;
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                list.add(toEncodable.invoke(it.next()));
            }
        }

        public final UrlPath build() {
            return new UrlPath(CollectionsKt.toList(this.segments), this.trailingSlash, null);
        }

        public final void copyFrom(UrlPath other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.segments.clear();
            this.segments.addAll(other.getSegments());
            this.trailingSlash = other.getTrailingSlash();
        }

        public final void copyFrom(Builder other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.segments.clear();
            this.segments.addAll(other.segments);
            this.trailingSlash = other.trailingSlash;
        }
    }
}
