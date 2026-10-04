package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class WriteMode {
    public static final WriteMode ADD = new WriteMode().withTag(Tag.ADD);
    public static final WriteMode OVERWRITE = new WriteMode().withTag(Tag.OVERWRITE);
    private Tag _tag;
    private String updateValue;

    public enum Tag {
        ADD,
        OVERWRITE,
        UPDATE
    }

    private WriteMode() {
    }

    private WriteMode withTag(Tag tag) {
        WriteMode writeMode = new WriteMode();
        writeMode._tag = tag;
        return writeMode;
    }

    private WriteMode withTagAndUpdate(Tag tag, String str) {
        WriteMode writeMode = new WriteMode();
        writeMode._tag = tag;
        writeMode.updateValue = str;
        return writeMode;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAdd() {
        return this._tag == Tag.ADD;
    }

    public boolean isOverwrite() {
        return this._tag == Tag.OVERWRITE;
    }

    public boolean isUpdate() {
        return this._tag == Tag.UPDATE;
    }

    public static WriteMode update(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 9) {
            throw new IllegalArgumentException("String is shorter than 9");
        }
        if (!Pattern.matches("[0-9a-f]+", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new WriteMode().withTagAndUpdate(Tag.UPDATE, str);
    }

    public String getUpdateValue() {
        if (this._tag != Tag.UPDATE) {
            throw new IllegalStateException("Invalid tag: required Tag.UPDATE, but was Tag." + this._tag.name());
        }
        return this.updateValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.updateValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof WriteMode)) {
            return false;
        }
        WriteMode writeMode = (WriteMode) obj;
        if (this._tag != writeMode._tag) {
            return false;
        }
        int i = C42231.$SwitchMap$com$dropbox$core$v2$files$WriteMode$Tag[this._tag.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                return false;
            }
            String str = this.updateValue;
            String str2 = writeMode.updateValue;
            if (str != str2 && !str.equals(str2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.WriteMode$1 */
    static /* synthetic */ class C42231 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$WriteMode$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$WriteMode$Tag = iArr;
            try {
                iArr[Tag.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteMode$Tag[Tag.OVERWRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$WriteMode$Tag[Tag.UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<WriteMode> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(WriteMode writeMode, JsonGenerator jsonGenerator) throws IOException {
            int i = C42231.$SwitchMap$com$dropbox$core$v2$files$WriteMode$Tag[writeMode.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("add");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("overwrite");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("update", jsonGenerator);
                jsonGenerator.writeFieldName("update");
                StoneSerializers.string().serialize(writeMode.updateValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + writeMode.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public WriteMode deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            WriteMode writeModeUpdate;
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
            if ("add".equals(tag)) {
                writeModeUpdate = WriteMode.ADD;
            } else if ("overwrite".equals(tag)) {
                writeModeUpdate = WriteMode.OVERWRITE;
            } else if ("update".equals(tag)) {
                expectField("update", jsonParser);
                writeModeUpdate = WriteMode.update(StoneSerializers.string().deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return writeModeUpdate;
        }
    }
}
