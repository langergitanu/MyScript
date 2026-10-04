package aws.smithy.kotlin.runtime.serde.xml;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.deserialization.LexingXmlStreamReader;
import aws.smithy.kotlin.runtime.serde.xml.deserialization.StringTextStream;
import aws.smithy.kotlin.runtime.serde.xml.deserialization.XmlLexer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: XmlStreamReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\u001a9\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a9\u0010\b\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001e\u0010\t\u001a\u0002H\n\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0080\b¢\u0006\u0002\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\r\"\u0006\b\u0000\u0010\n\u0018\u00012\u0006\u0010\u000e\u001a\u00020\u0002H\u0082\b\u001a\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, m1599d2 = {"seek", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;", "selectionPredicate", "Lkotlin/Function1;", "", "(Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "peekSeek", "takeNextAs", "TExpected", "(Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;)Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "requireToken", "", "token", "xmlStreamReader", "payload", "", "serde-xml"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlStreamReaderKt {
    public static /* synthetic */ XmlToken seek$default(XmlStreamReader xmlStreamReader, Function1 selectionPredicate, int i, Object obj) {
        boolean zBooleanValue;
        if ((i & 1) != 0) {
            Intrinsics.needClassReification();
            selectionPredicate = C37851.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(xmlStreamReader, "<this>");
        Intrinsics.checkNotNullParameter(selectionPredicate, "selectionPredicate");
        XmlToken lastToken = xmlStreamReader.getLastToken();
        do {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            zBooleanValue = lastToken instanceof XmlToken ? ((Boolean) selectionPredicate.invoke(lastToken)).booleanValue() : false;
            if (!zBooleanValue) {
                lastToken = xmlStreamReader.nextToken();
            }
            if (lastToken == null) {
                break;
            }
        } while (!zBooleanValue);
        Intrinsics.reifiedOperationMarker(1, "T?");
        return lastToken;
    }

    @InternalApi
    public static final /* synthetic */ <T extends XmlToken> T seek(XmlStreamReader xmlStreamReader, Function1<? super T, Boolean> selectionPredicate) {
        boolean zBooleanValue;
        Intrinsics.checkNotNullParameter(xmlStreamReader, "<this>");
        Intrinsics.checkNotNullParameter(selectionPredicate, "selectionPredicate");
        XmlToken lastToken = xmlStreamReader.getLastToken();
        do {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            zBooleanValue = lastToken instanceof XmlToken ? selectionPredicate.invoke(lastToken).booleanValue() : false;
            if (!zBooleanValue) {
                lastToken = (T) xmlStreamReader.nextToken();
            }
            if (lastToken == null) {
                break;
            }
        } while (!zBooleanValue);
        Intrinsics.reifiedOperationMarker(1, "T?");
        T t = lastToken;
        return lastToken;
    }

    public static /* synthetic */ XmlToken peekSeek$default(XmlStreamReader xmlStreamReader, Function1 selectionPredicate, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.needClassReification();
            selectionPredicate = C37841.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(xmlStreamReader, "<this>");
        Intrinsics.checkNotNullParameter(selectionPredicate, "selectionPredicate");
        XmlToken lastToken = xmlStreamReader.getLastToken();
        if (lastToken != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (lastToken instanceof XmlToken) {
                if (((Boolean) selectionPredicate.invoke(lastToken)).booleanValue()) {
                    return lastToken;
                }
                return null;
            }
        }
        do {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (lastToken instanceof XmlToken) {
                if (((Boolean) selectionPredicate.invoke(lastToken)).booleanValue()) {
                    XmlToken xmlTokenNextToken = xmlStreamReader.nextToken();
                    Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                    return xmlTokenNextToken;
                }
                return null;
            }
            xmlStreamReader.nextToken();
            lastToken = XmlStreamReader.peek$default(xmlStreamReader, 0, 1, null);
        } while (lastToken != null);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T extends aws.smithy.kotlin.runtime.serde.xml.XmlToken, aws.smithy.kotlin.runtime.serde.xml.XmlToken, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5, types: [aws.smithy.kotlin.runtime.serde.xml.XmlToken] */
    @InternalApi
    public static final /* synthetic */ <T extends XmlToken> T peekSeek(XmlStreamReader xmlStreamReader, Function1<? super T, Boolean> selectionPredicate) {
        Intrinsics.checkNotNullParameter(xmlStreamReader, "<this>");
        Intrinsics.checkNotNullParameter(selectionPredicate, "selectionPredicate");
        XmlToken lastToken = xmlStreamReader.getLastToken();
        if (lastToken != 0) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (lastToken instanceof XmlToken) {
                if (selectionPredicate.invoke(lastToken).booleanValue()) {
                    return lastToken;
                }
                return null;
            }
        }
        do {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (((??[OBJECT, ARRAY]) lastToken) instanceof XmlToken) {
                if (selectionPredicate.invoke((Object) lastToken).booleanValue()) {
                    T t = (T) xmlStreamReader.nextToken();
                    Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                    return t;
                }
                return null;
            }
            xmlStreamReader.nextToken();
            lastToken = XmlStreamReader.peek$default(xmlStreamReader, 0, 1, null);
        } while (lastToken != 0);
        return null;
    }

    public static final /* synthetic */ <TExpected extends XmlToken> TExpected takeNextAs(XmlStreamReader xmlStreamReader) {
        Intrinsics.checkNotNullParameter(xmlStreamReader, "<this>");
        TExpected texpected = (TExpected) xmlStreamReader.nextToken();
        if (texpected == null) {
            StringBuilder sb = new StringBuilder("Expected ");
            Intrinsics.reifiedOperationMarker(4, "TExpected");
            throw new DeserializationException(sb.append(Reflection.getOrCreateKotlinClass(XmlToken.class)).append(" but instead found null").toString());
        }
        Class<?> cls = texpected.getClass();
        Intrinsics.reifiedOperationMarker(4, "TExpected");
        if (cls == Object.class) {
            Intrinsics.reifiedOperationMarker(1, "TExpected");
            return texpected;
        }
        StringBuilder sb2 = new StringBuilder("Expected ");
        Intrinsics.reifiedOperationMarker(4, "TExpected");
        throw new DeserializationException(sb2.append(Reflection.getOrCreateKotlinClass(Object.class)).append("; found ").append(Reflection.getOrCreateKotlinClass(texpected.getClass())).append(" (").append(texpected).append(')').toString());
    }

    private static final /* synthetic */ <TExpected> void requireToken(XmlToken xmlToken) {
        Class<?> cls = xmlToken.getClass();
        Intrinsics.reifiedOperationMarker(4, "TExpected");
        if (cls == Object.class) {
            return;
        }
        StringBuilder sb = new StringBuilder("Expected ");
        Intrinsics.reifiedOperationMarker(4, "TExpected");
        throw new DeserializationException(sb.append(Reflection.getOrCreateKotlinClass(Object.class)).append("; found ").append(Reflection.getOrCreateKotlinClass(xmlToken.getClass())).append(" (").append(xmlToken).append(')').toString());
    }

    @InternalApi
    public static final XmlStreamReader xmlStreamReader(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return new LexingXmlStreamReader(new XmlLexer(new StringTextStream(StringsKt.decodeToString(payload))));
    }
}
