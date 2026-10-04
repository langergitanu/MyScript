package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class LookupError {
    private Tag _tag;
    private String malformedPathValue;
    public static final LookupError NOT_FOUND = new LookupError().withTag(Tag.NOT_FOUND);
    public static final LookupError NOT_FILE = new LookupError().withTag(Tag.NOT_FILE);
    public static final LookupError NOT_FOLDER = new LookupError().withTag(Tag.NOT_FOLDER);
    public static final LookupError RESTRICTED_CONTENT = new LookupError().withTag(Tag.RESTRICTED_CONTENT);
    public static final LookupError OTHER = new LookupError().withTag(Tag.OTHER);

    public enum Tag {
        MALFORMED_PATH,
        NOT_FOUND,
        NOT_FILE,
        NOT_FOLDER,
        RESTRICTED_CONTENT,
        OTHER
    }

    private LookupError() {
    }

    private LookupError withTag(Tag tag) {
        LookupError lookupError = new LookupError();
        lookupError._tag = tag;
        return lookupError;
    }

    private LookupError withTagAndMalformedPath(Tag tag, String str) {
        LookupError lookupError = new LookupError();
        lookupError._tag = tag;
        lookupError.malformedPathValue = str;
        return lookupError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isMalformedPath() {
        return this._tag == Tag.MALFORMED_PATH;
    }

    public static LookupError malformedPath(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LookupError().withTagAndMalformedPath(Tag.MALFORMED_PATH, str);
    }

    public String getMalformedPathValue() {
        if (this._tag != Tag.MALFORMED_PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.MALFORMED_PATH, but was Tag." + this._tag.name());
        }
        return this.malformedPathValue;
    }

    public boolean isNotFound() {
        return this._tag == Tag.NOT_FOUND;
    }

    public boolean isNotFile() {
        return this._tag == Tag.NOT_FILE;
    }

    public boolean isNotFolder() {
        return this._tag == Tag.NOT_FOLDER;
    }

    public boolean isRestrictedContent() {
        return this._tag == Tag.RESTRICTED_CONTENT;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.malformedPathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof LookupError)) {
            return false;
        }
        LookupError lookupError = (LookupError) obj;
        if (this._tag != lookupError._tag) {
            return false;
        }
        switch (C41201.$SwitchMap$com$dropbox$core$v2$fileproperties$LookupError$Tag[this._tag.ordinal()]) {
            case 1:
                String str = this.malformedPathValue;
                String str2 = lookupError.malformedPathValue;
                return str == str2 || str.equals(str2);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.LookupError$1 */
    static /* synthetic */ class C41201 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$fileproperties$LookupError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$fileproperties$LookupError$Tag = iArr;
            try {
                iArr[Tag.MALFORMED_PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$fileproperties$LookupError$Tag[Tag.NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$fileproperties$LookupError$Tag[Tag.NOT_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$fileproperties$LookupError$Tag[Tag.NOT_FOLDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$fileproperties$LookupError$Tag[Tag.RESTRICTED_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$fileproperties$LookupError$Tag[Tag.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<LookupError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(LookupError lookupError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41201.$SwitchMap$com$dropbox$core$v2$fileproperties$LookupError$Tag[lookupError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("malformed_path", jsonGenerator);
                jsonGenerator.writeFieldName("malformed_path");
                StoneSerializers.string().serialize(lookupError.malformedPathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("not_found");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("not_file");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("not_folder");
            } else if (i == 5) {
                jsonGenerator.writeString("restricted_content");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public LookupError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            LookupError lookupErrorMalformedPath;
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
            if ("malformed_path".equals(tag)) {
                expectField("malformed_path", jsonParser);
                lookupErrorMalformedPath = LookupError.malformedPath(StoneSerializers.string().deserialize(jsonParser));
            } else if ("not_found".equals(tag)) {
                lookupErrorMalformedPath = LookupError.NOT_FOUND;
            } else if ("not_file".equals(tag)) {
                lookupErrorMalformedPath = LookupError.NOT_FILE;
            } else if ("not_folder".equals(tag)) {
                lookupErrorMalformedPath = LookupError.NOT_FOLDER;
            } else if ("restricted_content".equals(tag)) {
                lookupErrorMalformedPath = LookupError.RESTRICTED_CONTENT;
            } else {
                lookupErrorMalformedPath = LookupError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return lookupErrorMalformedPath;
        }
    }
}
