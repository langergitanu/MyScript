package com.dropbox.core.p013v2.users;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class PaperAsFilesValue {
    public static final PaperAsFilesValue OTHER = new PaperAsFilesValue().withTag(Tag.OTHER);
    private Tag _tag;
    private Boolean enabledValue;

    public enum Tag {
        ENABLED,
        OTHER
    }

    private PaperAsFilesValue() {
    }

    private PaperAsFilesValue withTag(Tag tag) {
        PaperAsFilesValue paperAsFilesValue = new PaperAsFilesValue();
        paperAsFilesValue._tag = tag;
        return paperAsFilesValue;
    }

    private PaperAsFilesValue withTagAndEnabled(Tag tag, Boolean bool) {
        PaperAsFilesValue paperAsFilesValue = new PaperAsFilesValue();
        paperAsFilesValue._tag = tag;
        paperAsFilesValue.enabledValue = bool;
        return paperAsFilesValue;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isEnabled() {
        return this._tag == Tag.ENABLED;
    }

    public static PaperAsFilesValue enabled(boolean z) {
        return new PaperAsFilesValue().withTagAndEnabled(Tag.ENABLED, Boolean.valueOf(z));
    }

    public boolean getEnabledValue() {
        if (this._tag != Tag.ENABLED) {
            throw new IllegalStateException("Invalid tag: required Tag.ENABLED, but was Tag." + this._tag.name());
        }
        return this.enabledValue.booleanValue();
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.enabledValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof PaperAsFilesValue)) {
            PaperAsFilesValue paperAsFilesValue = (PaperAsFilesValue) obj;
            if (this._tag != paperAsFilesValue._tag) {
                return false;
            }
            int i = C45641.$SwitchMap$com$dropbox$core$v2$users$PaperAsFilesValue$Tag[this._tag.ordinal()];
            if (i != 1) {
                return i == 2;
            }
            if (this.enabledValue == paperAsFilesValue.enabledValue) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.users.PaperAsFilesValue$1 */
    static /* synthetic */ class C45641 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$users$PaperAsFilesValue$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$users$PaperAsFilesValue$Tag = iArr;
            try {
                iArr[Tag.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$users$PaperAsFilesValue$Tag[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<PaperAsFilesValue> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PaperAsFilesValue paperAsFilesValue, JsonGenerator jsonGenerator) throws IOException {
            if (C45641.$SwitchMap$com$dropbox$core$v2$users$PaperAsFilesValue$Tag[paperAsFilesValue.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("enabled", jsonGenerator);
                jsonGenerator.writeFieldName("enabled");
                StoneSerializers.boolean_().serialize(paperAsFilesValue.enabledValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PaperAsFilesValue deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PaperAsFilesValue paperAsFilesValueEnabled;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("enabled".equals(tag)) {
                expectField("enabled", jsonParser);
                paperAsFilesValueEnabled = PaperAsFilesValue.enabled(StoneSerializers.boolean_().deserialize(jsonParser).booleanValue());
            } else {
                paperAsFilesValueEnabled = PaperAsFilesValue.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return paperAsFilesValueEnabled;
        }
    }
}
