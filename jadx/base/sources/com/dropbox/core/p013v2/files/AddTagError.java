package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class AddTagError {
    public static final AddTagError OTHER = new AddTagError().withTag(Tag.OTHER);
    public static final AddTagError TOO_MANY_TAGS = new AddTagError().withTag(Tag.TOO_MANY_TAGS);
    private Tag _tag;
    private LookupError pathValue;

    public enum Tag {
        PATH,
        OTHER,
        TOO_MANY_TAGS
    }

    private AddTagError() {
    }

    private AddTagError withTag(Tag tag) {
        AddTagError addTagError = new AddTagError();
        addTagError._tag = tag;
        return addTagError;
    }

    private AddTagError withTagAndPath(Tag tag, LookupError lookupError) {
        AddTagError addTagError = new AddTagError();
        addTagError._tag = tag;
        addTagError.pathValue = lookupError;
        return addTagError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static AddTagError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AddTagError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public boolean isTooManyTags() {
        return this._tag == Tag.TOO_MANY_TAGS;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AddTagError)) {
            return false;
        }
        AddTagError addTagError = (AddTagError) obj;
        if (this._tag != addTagError._tag) {
            return false;
        }
        int i = C41411.$SwitchMap$com$dropbox$core$v2$files$AddTagError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = addTagError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.AddTagError$1 */
    static /* synthetic */ class C41411 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$AddTagError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$AddTagError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$AddTagError$Tag[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$AddTagError$Tag[Tag.TOO_MANY_TAGS.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<AddTagError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AddTagError addTagError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41411.$SwitchMap$com$dropbox$core$v2$files$AddTagError$Tag[addTagError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(addTagError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("other");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("too_many_tags");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + addTagError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AddTagError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AddTagError addTagErrorPath;
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
            if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                addTagErrorPath = AddTagError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("other".equals(tag)) {
                addTagErrorPath = AddTagError.OTHER;
            } else if ("too_many_tags".equals(tag)) {
                addTagErrorPath = AddTagError.TOO_MANY_TAGS;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return addTagErrorPath;
        }
    }
}
