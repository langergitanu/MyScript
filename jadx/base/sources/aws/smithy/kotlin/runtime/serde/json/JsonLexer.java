package aws.smithy.kotlin.runtime.serde.json;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.credentials.provider.CredentialEntry;
import aws.smithy.kotlin.runtime.collections.StackKt;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.json.JsonToken;
import com.revenuecat.purchases.common.Constants;
import com.survicate.surveys.TextRecallingManager;
import java.io.IOException;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: JsonLexer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0014\u0010\u001d\u001a\u00020\u000f2\n\u0010\u001e\u001a\u00060\u001fj\u0002` H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0019\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010\r\u001a\u00020)H\u0002¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\"H\u0002J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020(H\u0002J\u000f\u0010-\u001a\u0004\u0018\u00010.H\u0002¢\u0006\u0002\u0010/J\u000f\u00100\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0002\u00101J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020(H\u0002J+\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010(2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"07\"\u00020\"H\u0002¢\u0006\u0002\u00108J&\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020\"2\b\b\u0002\u0010;\u001a\u00020\u000b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0002J)\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020)2\b\b\u0002\u0010;\u001a\u00020\u000b2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH\u0082\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonLexer;", "Laws/smithy/kotlin/runtime/serde/json/JsonStreamReader;", "data", "", "<init>", "([B)V", "peeked", "Laws/smithy/kotlin/runtime/serde/json/JsonToken;", "state", "Laws/smithy/kotlin/runtime/serde/json/StateManager;", "idx", "", "nextToken", "peek", "skipNext", "", "doPeek", "stateObjectFirstKeyOrEnd", "stateObjectNextKeyOrEnd", "stateObjectFieldValue", "stateArrayFirstValueOrEnd", "stateArrayNextValueOrEnd", "startObject", "endObject", "startArray", "endArray", "readName", "readToken", "readNumber", "readDigits", "appendable", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "readQuoted", "", "readKeyword", "readLiteral", "expectedString", "token", "nextNonWhitespace", "", "", "(Z)Ljava/lang/Character;", "consume", "expected", "peekByte", "", "()Ljava/lang/Byte;", "peekChar", "()Ljava/lang/Character;", "peekOrThrow", "nextOrThrow", "unexpectedToken", "", "found", "", "(Ljava/lang/Character;[Ljava/lang/String;)Ljava/lang/Void;", "fail", "message", TypedValues.CycleType.S_WAVE_OFFSET, "cause", "", "lexerCheck", "value", "lazyMessage", "Lkotlin/Function0;", "", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JsonLexer implements JsonStreamReader {
    private final byte[] data;
    private int idx;
    private JsonToken peeked;
    private final StateManager state;

    /* JADX INFO: compiled from: JsonLexer.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LexerState.values().length];
            try {
                iArr[LexerState.Initial.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LexerState.ArrayFirstValueOrEnd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LexerState.ArrayNextValueOrEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LexerState.ObjectFirstKeyOrEnd.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LexerState.ObjectNextKeyOrEnd.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LexerState.ObjectFieldValue.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JsonLexer(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.state = new StateManager(null, null, 3, null);
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamReader
    public JsonToken nextToken() {
        JsonToken jsonTokenPeek = peek();
        this.peeked = null;
        this.state.update();
        return jsonTokenPeek;
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamReader
    public JsonToken peek() {
        JsonToken jsonToken = this.peeked;
        if (jsonToken != null) {
            return jsonToken;
        }
        JsonToken jsonTokenDoPeek = doPeek();
        this.peeked = jsonTokenDoPeek;
        return jsonTokenDoPeek;
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamReader
    public void skipNext() {
        int size = this.state.getSize();
        nextToken();
        while (this.state.getSize() > size) {
            nextToken();
        }
    }

    private final JsonToken doPeek() {
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[this.state.getCurrent().ordinal()]) {
                case 1:
                    return readToken();
                case 2:
                    return stateArrayFirstValueOrEnd();
                case 3:
                    return stateArrayNextValueOrEnd();
                case 4:
                    return stateObjectFirstKeyOrEnd();
                case 5:
                    return stateObjectNextKeyOrEnd();
                case 6:
                    return stateObjectFieldValue();
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } catch (DeserializationException e) {
            throw e;
        } catch (Exception e2) {
            throw new DeserializationException(e2);
        }
    }

    private final JsonToken stateObjectFirstKeyOrEnd() {
        Character chNextNonWhitespace = nextNonWhitespace(true);
        if (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == '}') {
            return endObject();
        }
        if (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == '\"') {
            return readName();
        }
        unexpectedToken(chNextNonWhitespace, "\"", "}");
        throw new KotlinNothingValueException();
    }

    private final JsonToken stateObjectNextKeyOrEnd() {
        Character chNextNonWhitespace = nextNonWhitespace(true);
        if (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == '}') {
            return endObject();
        }
        if (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == ',') {
            consume(AbstractJsonLexerKt.COMMA);
            nextNonWhitespace(true);
            return readName();
        }
        unexpectedToken(chNextNonWhitespace, ",", "}");
        throw new KotlinNothingValueException();
    }

    private final JsonToken stateObjectFieldValue() {
        Character chNextNonWhitespace = nextNonWhitespace(true);
        if (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == ':') {
            consume(AbstractJsonLexerKt.COLON);
            this.state.mutate(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return JsonLexer.stateObjectFieldValue$lambda$0((List) obj);
                }
            });
            return readToken();
        }
        unexpectedToken(chNextNonWhitespace, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stateObjectFieldValue$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StackKt.replaceTop(it, LexerState.ObjectNextKeyOrEnd);
        return Unit.INSTANCE;
    }

    private final JsonToken stateArrayFirstValueOrEnd() {
        Character chNextNonWhitespace = nextNonWhitespace(true);
        if (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == ']') {
            return endArray();
        }
        this.state.mutate(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JsonLexer.stateArrayFirstValueOrEnd$lambda$0((List) obj);
            }
        });
        return readToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stateArrayFirstValueOrEnd$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StackKt.replaceTop(it, LexerState.ArrayNextValueOrEnd);
        return Unit.INSTANCE;
    }

    private final JsonToken stateArrayNextValueOrEnd() {
        Character chNextNonWhitespace = nextNonWhitespace(true);
        if (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == ']') {
            return endArray();
        }
        if (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == ',') {
            consume(AbstractJsonLexerKt.COMMA);
            return readToken();
        }
        unexpectedToken(chNextNonWhitespace, ",", "]");
        throw new KotlinNothingValueException();
    }

    private final JsonToken startObject() {
        consume(AbstractJsonLexerKt.BEGIN_OBJ);
        this.state.mutate(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JsonLexer.startObject$lambda$0((List) obj);
            }
        });
        return JsonToken.BeginObject.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startObject$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StackKt.push(it, LexerState.ObjectFirstKeyOrEnd);
        return Unit.INSTANCE;
    }

    private final JsonToken endObject() {
        consume(AbstractJsonLexerKt.END_OBJ);
        LexerState current = this.state.getCurrent();
        boolean z = current == LexerState.ObjectFirstKeyOrEnd || current == LexerState.ObjectNextKeyOrEnd;
        int i = this.idx - 1;
        if (!z) {
            fail$default(this, "Unexpected close `}` encountered".toString(), i, null, 4, null);
            throw new KotlinNothingValueException();
        }
        this.state.mutate(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JsonLexer.endObject$lambda$1((List) obj);
            }
        });
        return JsonToken.EndObject.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit endObject$lambda$1(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StackKt.pop(it);
        return Unit.INSTANCE;
    }

    private final JsonToken startArray() {
        consume('[');
        this.state.mutate(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JsonLexer.startArray$lambda$0((List) obj);
            }
        });
        return JsonToken.BeginArray.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startArray$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StackKt.push(it, LexerState.ArrayFirstValueOrEnd);
        return Unit.INSTANCE;
    }

    private final JsonToken endArray() {
        consume(']');
        LexerState current = this.state.getCurrent();
        boolean z = current == LexerState.ArrayFirstValueOrEnd || current == LexerState.ArrayNextValueOrEnd;
        int i = this.idx - 1;
        if (!z) {
            fail$default(this, "Unexpected close `]` encountered".toString(), i, null, 4, null);
            throw new KotlinNothingValueException();
        }
        this.state.mutate(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JsonLexer.endArray$lambda$1((List) obj);
            }
        });
        return JsonToken.EndArray.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit endArray$lambda$1(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StackKt.pop(it);
        return Unit.INSTANCE;
    }

    private final JsonToken readName() {
        char cPeekOrThrow = peekOrThrow();
        if (cPeekOrThrow == '\"') {
            String quoted = readQuoted();
            this.state.mutate(new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return JsonLexer.readName$lambda$0((List) obj);
                }
            });
            return new JsonToken.Name(quoted);
        }
        unexpectedToken(Character.valueOf(cPeekOrThrow), "\"");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readName$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StackKt.replaceTop(it, LexerState.ObjectFieldValue);
        return Unit.INSTANCE;
    }

    private final JsonToken readToken() {
        Character chNextNonWhitespace = nextNonWhitespace(true);
        if (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == '{') {
            return startObject();
        }
        if (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == '[') {
            return startArray();
        }
        if (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == '\"') {
            return new JsonToken.String(readQuoted());
        }
        if ((chNextNonWhitespace != null && chNextNonWhitespace.charValue() == 't') || ((chNextNonWhitespace != null && chNextNonWhitespace.charValue() == 'f') || (chNextNonWhitespace != null && chNextNonWhitespace.charValue() == 'n'))) {
            return readKeyword();
        }
        if (chNextNonWhitespace == null || chNextNonWhitespace.charValue() != '-') {
            CharRange charRange = new CharRange('0', '9');
            if (chNextNonWhitespace == null || !charRange.contains(chNextNonWhitespace.charValue())) {
                if (chNextNonWhitespace == null) {
                    return JsonToken.EndDocument.INSTANCE;
                }
                unexpectedToken(chNextNonWhitespace, "{", "[", "\"", AbstractJsonLexerKt.NULL, CredentialEntry.TRUE_STRING, CredentialEntry.FALSE_STRING, "<number>");
                throw new KotlinNothingValueException();
            }
        }
        return readNumber();
    }

    private final JsonToken readNumber() throws IOException {
        StringBuilder sb = new StringBuilder();
        Character chPeekChar = peekChar();
        if (chPeekChar != null && chPeekChar.charValue() == '-') {
            sb.append(nextOrThrow());
        }
        StringBuilder sb2 = sb;
        readDigits(sb2);
        Character chPeekChar2 = peekChar();
        if (chPeekChar2 != null && chPeekChar2.charValue() == '.') {
            sb.append(nextOrThrow());
            readDigits(sb2);
        }
        if (CollectionsKt.contains(JsonLexerKt.EXP, peekChar())) {
            sb.append(nextOrThrow());
            if (CollectionsKt.contains(JsonLexerKt.PLUS_MINUS, peekChar())) {
                sb.append(nextOrThrow());
            }
            readDigits(sb2);
        }
        String string = sb.toString();
        boolean z = string.length() > 0;
        int i = this.idx;
        if (!z) {
            fail$default(this, ("Invalid number, expected `-` || 0..9, found `" + peekChar() + '`').toString(), i, null, 4, null);
            throw new KotlinNothingValueException();
        }
        return new JsonToken.Number(string);
    }

    private final void readDigits(Appendable appendable) throws IOException {
        while (CollectionsKt.contains(JsonLexerKt.DIGITS, peekChar())) {
            appendable.append(nextOrThrow());
        }
    }

    private final String readQuoted() {
        consume('\"');
        int i = this.idx;
        char cPeekOrThrow = peekOrThrow();
        boolean z = false;
        while (cPeekOrThrow != '\"') {
            if (cPeekOrThrow != '\\') {
                if (JsonLexerKt.isControl(cPeekOrThrow)) {
                    fail$default(this, "Unexpected control character: `" + cPeekOrThrow + '`', 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                this.idx++;
            } else {
                nextOrThrow();
                char cNextOrThrow = nextOrThrow();
                if (cNextOrThrow != '\"' && cNextOrThrow != '/' && cNextOrThrow != '\\' && cNextOrThrow != 'b' && cNextOrThrow != 'f' && cNextOrThrow != 'n' && cNextOrThrow != 'r' && cNextOrThrow != 't') {
                    if (cNextOrThrow == 'u') {
                        int i2 = this.idx;
                        if (i2 + 4 >= this.data.length) {
                            fail$default(this, "Unexpected EOF reading escaped unicode string", i2, null, 4, null);
                            throw new KotlinNothingValueException();
                        }
                        this.idx = i2 + 4;
                    } else {
                        fail$default(this, "Invalid escape character: `" + cNextOrThrow + '`', this.idx - 1, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                }
                z = true;
            }
            cPeekOrThrow = peekOrThrow();
        }
        String strDecodeToString$default = StringsKt.decodeToString$default(this.data, i, this.idx, false, 4, null);
        consume('\"');
        if (!z) {
            return strDecodeToString$default;
        }
        try {
            return JsonLexerKt.unescape(strDecodeToString$default);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Invalid escaped string";
            }
            fail$default(this, message, i - 1, null, 4, null);
            throw new KotlinNothingValueException();
        }
    }

    private final JsonToken readKeyword() {
        char cPeekOrThrow = peekOrThrow();
        if (cPeekOrThrow == 'f') {
            return readLiteral(CredentialEntry.FALSE_STRING, new JsonToken.Bool(false));
        }
        if (cPeekOrThrow == 'n') {
            return readLiteral(AbstractJsonLexerKt.NULL, JsonToken.Null.INSTANCE);
        }
        if (cPeekOrThrow == 't') {
            return readLiteral(CredentialEntry.TRUE_STRING, new JsonToken.Bool(true));
        }
        fail$default(this, "Unable to handle keyword starting with '" + cPeekOrThrow + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final JsonToken readLiteral(String expectedString, JsonToken token) {
        consume(expectedString);
        return token;
    }

    static /* synthetic */ Character nextNonWhitespace$default(JsonLexer jsonLexer, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return jsonLexer.nextNonWhitespace(z);
    }

    private final Character nextNonWhitespace(boolean peek) {
        while (true) {
            Character chPeekChar = peekChar();
            if (chPeekChar == null || !CharsKt.isWhitespace(chPeekChar.charValue())) {
                break;
            }
            this.idx++;
        }
        return peek ? peekChar() : Character.valueOf(nextOrThrow());
    }

    private final void consume(String expected) {
        String str = expected;
        for (int i = 0; i < str.length(); i++) {
            consume(str.charAt(i));
        }
    }

    private final void consume(char expected) {
        char c = (char) this.data[this.idx];
        boolean z = c == expected;
        int i = this.idx;
        if (!z) {
            fail$default(this, ("Unexpected char `" + c + "` expected `" + expected + '`').toString(), i, null, 4, null);
            throw new KotlinNothingValueException();
        }
        this.idx++;
    }

    private final Byte peekByte() {
        return ArraysKt.getOrNull(this.data, this.idx);
    }

    private final Character peekChar() {
        Byte bPeekByte = peekByte();
        if (bPeekByte != null) {
            return Character.valueOf((char) bPeekByte.byteValue());
        }
        return null;
    }

    private final char peekOrThrow() {
        Character chPeekChar = peekChar();
        if (chPeekChar != null) {
            return chPeekChar.charValue();
        }
        throw new IllegalStateException("Unexpected EOF");
    }

    private final char nextOrThrow() {
        char cPeekOrThrow = peekOrThrow();
        this.idx++;
        return cPeekOrThrow;
    }

    private final Void unexpectedToken(Character found, String... expected) {
        fail$default(this, "found `" + found + "`, expected" + (expected.length > 1 ? " one of" : "") + TokenParser.f2383SP + ArraysKt.joinToString$default(expected, TextRecallingManager.ANSWER_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: aws.smithy.kotlin.runtime.serde.json.JsonLexer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JsonLexer.unexpectedToken$lambda$0((String) obj);
            }
        }, 30, (Object) null), 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence unexpectedToken$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "`" + it + '`';
    }

    private final Void fail(String message, int offset, Throwable cause) {
        throw new DeserializationException("Unexpected JSON token at offset " + offset + "; " + message, cause);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void fail$default(JsonLexer jsonLexer, String str, int i, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = jsonLexer.idx;
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        return jsonLexer.fail(str, i, th);
    }

    static /* synthetic */ void lexerCheck$default(JsonLexer jsonLexer, boolean z, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = jsonLexer.idx;
        }
        int i3 = i;
        if (z) {
            return;
        }
        fail$default(jsonLexer, function0.invoke().toString(), i3, null, 4, null);
        throw new KotlinNothingValueException();
    }

    private final void lexerCheck(boolean value, int offset, Function0<? extends Object> lazyMessage) {
        if (value) {
            return;
        }
        fail$default(this, lazyMessage.invoke().toString(), offset, null, 4, null);
        throw new KotlinNothingValueException();
    }
}
