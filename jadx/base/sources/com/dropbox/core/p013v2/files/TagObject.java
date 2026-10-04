package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.UserGeneratedTag;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class TagObject {
    public static final TagObject OTHER = new TagObject().withTag(Tag.OTHER);
    private Tag _tag;
    private UserGeneratedTag userGeneratedTagValue;

    public enum Tag {
        USER_GENERATED_TAG,
        OTHER
    }

    private TagObject() {
    }

    private TagObject withTag(Tag tag) {
        TagObject tagObject = new TagObject();
        tagObject._tag = tag;
        return tagObject;
    }

    private TagObject withTagAndUserGeneratedTag(Tag tag, UserGeneratedTag userGeneratedTag) {
        TagObject tagObject = new TagObject();
        tagObject._tag = tag;
        tagObject.userGeneratedTagValue = userGeneratedTag;
        return tagObject;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUserGeneratedTag() {
        return this._tag == Tag.USER_GENERATED_TAG;
    }

    public static TagObject userGeneratedTag(UserGeneratedTag userGeneratedTag) {
        if (userGeneratedTag == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TagObject().withTagAndUserGeneratedTag(Tag.USER_GENERATED_TAG, userGeneratedTag);
    }

    public UserGeneratedTag getUserGeneratedTagValue() {
        if (this._tag != Tag.USER_GENERATED_TAG) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_GENERATED_TAG, but was Tag." + this._tag.name());
        }
        return this.userGeneratedTagValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.userGeneratedTagValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof TagObject)) {
            return false;
        }
        TagObject tagObject = (TagObject) obj;
        if (this._tag != tagObject._tag) {
            return false;
        }
        int i = C42061.$SwitchMap$com$dropbox$core$v2$files$TagObject$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        UserGeneratedTag userGeneratedTag = this.userGeneratedTagValue;
        UserGeneratedTag userGeneratedTag2 = tagObject.userGeneratedTagValue;
        return userGeneratedTag == userGeneratedTag2 || userGeneratedTag.equals(userGeneratedTag2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.TagObject$1 */
    static /* synthetic */ class C42061 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$TagObject$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$TagObject$Tag = iArr;
            try {
                iArr[Tag.USER_GENERATED_TAG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$TagObject$Tag[Tag.OTHER.ordinal()] = 2;
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

    static class Serializer extends UnionSerializer<TagObject> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TagObject tagObject, JsonGenerator jsonGenerator) throws IOException {
            if (C42061.$SwitchMap$com$dropbox$core$v2$files$TagObject$Tag[tagObject.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("user_generated_tag", jsonGenerator);
                UserGeneratedTag.Serializer.INSTANCE.serialize(tagObject.userGeneratedTagValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TagObject deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TagObject tagObjectUserGeneratedTag;
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
            if ("user_generated_tag".equals(tag)) {
                tagObjectUserGeneratedTag = TagObject.userGeneratedTag(UserGeneratedTag.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                tagObjectUserGeneratedTag = TagObject.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return tagObjectUserGeneratedTag;
        }
    }
}
