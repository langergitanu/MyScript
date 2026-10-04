package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: JsonStreamReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001e\u0010\u0004\u001a\u0002H\u0005\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\b\u001a\u00020\t\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0087\b¨\u0006\u000b"}, m1599d2 = {"jsonStreamReader", "Laws/smithy/kotlin/runtime/serde/json/JsonStreamReader;", "payload", "", "nextTokenOf", "TExpected", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "(Laws/smithy/kotlin/runtime/serde/json/JsonStreamReader;)Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "requireToken", "", "token", "serde-json"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JsonStreamReaderKt {
    @InternalApi
    public static final JsonStreamReader jsonStreamReader(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return new JsonLexer(payload);
    }

    @InternalApi
    public static final /* synthetic */ <TExpected extends JsonToken> TExpected nextTokenOf(JsonStreamReader jsonStreamReader) {
        Intrinsics.checkNotNullParameter(jsonStreamReader, "<this>");
        TExpected texpected = (TExpected) jsonStreamReader.nextToken();
        Class<?> cls = texpected.getClass();
        Intrinsics.reifiedOperationMarker(4, "TExpected");
        if (cls == Object.class) {
            Intrinsics.reifiedOperationMarker(1, "TExpected");
            return texpected;
        }
        StringBuilder sb = new StringBuilder("expected ");
        Intrinsics.reifiedOperationMarker(4, "TExpected");
        throw new DeserializationException(sb.append(Reflection.getOrCreateKotlinClass(Object.class)).append("; found ").append(Reflection.getOrCreateKotlinClass(texpected.getClass())).toString());
    }

    @InternalApi
    public static final /* synthetic */ <TExpected> void requireToken(JsonToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        Class<?> cls = token.getClass();
        Intrinsics.reifiedOperationMarker(4, "TExpected");
        if (cls == Object.class) {
            return;
        }
        StringBuilder sb = new StringBuilder("expected ");
        Intrinsics.reifiedOperationMarker(4, "TExpected");
        throw new DeserializationException(sb.append(Reflection.getOrCreateKotlinClass(Object.class)).append("; found ").append(Reflection.getOrCreateKotlinClass(token.getClass())).toString());
    }
}
