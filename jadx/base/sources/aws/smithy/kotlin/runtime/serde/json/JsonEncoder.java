package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.collections.StackKt;
import aws.smithy.kotlin.runtime.content.BigDecimal;
import aws.smithy.kotlin.runtime.content.BigInteger;
import com.revenuecat.purchases.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: JsonEncoder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0010\u0004\n\u0002\u0010\u0005\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J)\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001e\"\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u0014H\u0016J\u0018\u0010'\u001a\u00020\u0014*\u00060\u0007j\u0002`\b2\u0006\u0010%\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u001aH\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001aH\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0003H\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010%\u001a\u00020-H\u0002J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u00020-H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u00020.H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u00020/H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u000200H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0012H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u000201H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u000202H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u000203H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/json/JsonEncoder;", "Laws/smithy/kotlin/runtime/serde/json/JsonStreamWriter;", "pretty", "", "<init>", "(Z)V", "buffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "bytes", "", "getBytes", "()[B", "state", "", "Laws/smithy/kotlin/runtime/serde/json/LexerState;", "Laws/smithy/kotlin/runtime/collections/ListStack;", "depth", "", "beginObject", "", "endObject", "beginArray", "endArray", "openStructure", "token", "", "nextState", "closeStructure", "allowedStates", "", "(Ljava/lang/String;[Laws/smithy/kotlin/runtime/serde/json/LexerState;)V", "writeIndent", "writeNewline", "writeComma", "writeColon", "encodeValue", "value", "writeNull", "appendQuoted", "writeName", "name", "writeValue", "bool", "writeNumber", "", "", "", "", "", "", "Laws/smithy/kotlin/runtime/content/BigInteger;", "Laws/smithy/kotlin/runtime/content/BigDecimal;", "writeRawValue", "serde-json"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JsonEncoder implements JsonStreamWriter {
    private final StringBuilder buffer;
    private int depth;
    private final boolean pretty;
    private final List<LexerState> state;

    /* JADX INFO: compiled from: JsonEncoder.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LexerState.values().length];
            try {
                iArr[LexerState.ArrayFirstValueOrEnd.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LexerState.ArrayNextValueOrEnd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LexerState.ObjectFieldValue.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JsonEncoder() {
        this(false, 1, null);
    }

    public JsonEncoder(boolean z) {
        this.pretty = z;
        this.buffer = new StringBuilder();
        this.state = CollectionsKt.mutableListOf(LexerState.Initial);
    }

    public /* synthetic */ JsonEncoder(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public byte[] getBytes() {
        String string = this.buffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.encodeToByteArray(string);
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void beginObject() {
        openStructure("{", LexerState.ObjectFirstKeyOrEnd);
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void endObject() {
        closeStructure("}", LexerState.ObjectFirstKeyOrEnd, LexerState.ObjectNextKeyOrEnd);
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void beginArray() {
        openStructure("[", LexerState.ArrayFirstValueOrEnd);
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void endArray() {
        closeStructure("]", LexerState.ArrayFirstValueOrEnd, LexerState.ArrayNextValueOrEnd);
    }

    private final void openStructure(String token, LexerState nextState) {
        encodeValue(token);
        writeNewline();
        this.depth++;
        StackKt.push(this.state, nextState);
    }

    private final void closeStructure(String token, LexerState... allowedStates) {
        writeNewline();
        this.depth--;
        writeIndent();
        this.buffer.append(token);
        LexerState lexerState = (LexerState) StackKt.pop(this.state);
        if (!ArraysKt.contains(allowedStates, lexerState)) {
            throw new IllegalStateException(("Invalid JSON encoder state " + lexerState + "; expected one of " + ArraysKt.joinToString$default(allowedStates, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
        }
    }

    private final void writeIndent() {
        int i;
        if (!this.pretty || (i = this.depth) <= 0) {
            return;
        }
        this.buffer.append(StringsKt.repeat(" ", i * 4));
    }

    private final void writeNewline() {
        if (this.pretty) {
            this.buffer.append('\n');
        }
    }

    private final void writeComma() {
        this.buffer.append(",");
        writeNewline();
    }

    private final void writeColon() {
        this.buffer.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        if (this.pretty) {
            this.buffer.append(" ");
        }
    }

    private final void encodeValue(String value) {
        int i = WhenMappings.$EnumSwitchMapping$0[((LexerState) StackKt.top(this.state)).ordinal()];
        if (i == 1) {
            StackKt.replaceTop(this.state, LexerState.ArrayNextValueOrEnd);
            writeIndent();
        } else if (i == 2) {
            writeComma();
            writeIndent();
        } else if (i == 3) {
            writeColon();
            StackKt.replaceTop(this.state, LexerState.ObjectNextKeyOrEnd);
        }
        this.buffer.append(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeNull() {
        encodeValue(AbstractJsonLexerKt.NULL);
    }

    private final void appendQuoted(StringBuilder sb, String str) {
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (StackKt.top(this.state) == LexerState.ObjectNextKeyOrEnd) {
            writeComma();
        }
        writeIndent();
        appendQuoted(this.buffer, JsonEncoderKt.escape(name));
        StackKt.replaceTop(this.state, LexerState.ObjectFieldValue);
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeValue("\"" + JsonEncoderKt.escape(value) + '\"');
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeValue(boolean bool) {
        encodeValue(String.valueOf(bool));
    }

    private final void writeNumber(Number value) {
        encodeValue(value.toString());
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeValue(Number value) {
        Intrinsics.checkNotNullParameter(value, "value");
        writeNumber(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeValue(byte value) {
        writeNumber(Byte.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeValue(long value) {
        writeNumber(Long.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeValue(short value) {
        writeNumber(Short.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeValue(int value) {
        writeNumber(Integer.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeValue(float value) {
        writeNumber(Float.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeValue(double value) {
        writeNumber(Double.valueOf(value));
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeValue(BigInteger value) {
        Intrinsics.checkNotNullParameter(value, "value");
        writeNumber(value);
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeValue(BigDecimal value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeValue(value.toPlainString());
    }

    @Override // aws.smithy.kotlin.runtime.serde.json.JsonStreamWriter
    public void writeRawValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeValue(value);
    }
}
