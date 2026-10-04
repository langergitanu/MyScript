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
public final class RemoveTagError {
    public static final RemoveTagError OTHER = new RemoveTagError().withTag(Tag.OTHER);
    public static final RemoveTagError TAG_NOT_PRESENT = new RemoveTagError().withTag(Tag.TAG_NOT_PRESENT);
    private Tag _tag;
    private LookupError pathValue;

    public enum Tag {
        PATH,
        OTHER,
        TAG_NOT_PRESENT
    }

    private RemoveTagError() {
    }

    private RemoveTagError withTag(Tag tag) {
        RemoveTagError removeTagError = new RemoveTagError();
        removeTagError._tag = tag;
        return removeTagError;
    }

    private RemoveTagError withTagAndPath(Tag tag, LookupError lookupError) {
        RemoveTagError removeTagError = new RemoveTagError();
        removeTagError._tag = tag;
        removeTagError.pathValue = lookupError;
        return removeTagError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static RemoveTagError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveTagError().withTagAndPath(Tag.PATH, lookupError);
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

    public boolean isTagNotPresent() {
        return this._tag == Tag.TAG_NOT_PRESENT;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof RemoveTagError)) {
            return false;
        }
        RemoveTagError removeTagError = (RemoveTagError) obj;
        if (this._tag != removeTagError._tag) {
            return false;
        }
        int i = C41921.$SwitchMap$com$dropbox$core$v2$files$RemoveTagError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = removeTagError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.RemoveTagError$1 */
    static /* synthetic */ class C41921 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$RemoveTagError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$RemoveTagError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RemoveTagError$Tag[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$RemoveTagError$Tag[Tag.TAG_NOT_PRESENT.ordinal()] = 3;
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

    static class Serializer extends UnionSerializer<RemoveTagError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RemoveTagError removeTagError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41921.$SwitchMap$com$dropbox$core$v2$files$RemoveTagError$Tag[removeTagError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(removeTagError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("other");
            } else {
                if (i == 3) {
                    jsonGenerator.writeString("tag_not_present");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + removeTagError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RemoveTagError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RemoveTagError removeTagErrorPath;
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
                removeTagErrorPath = RemoveTagError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("other".equals(tag)) {
                removeTagErrorPath = RemoveTagError.OTHER;
            } else if ("tag_not_present".equals(tag)) {
                removeTagErrorPath = RemoveTagError.TAG_NOT_PRESENT;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return removeTagErrorPath;
        }
    }
}
