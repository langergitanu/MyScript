package com.dropbox.core.p013v2.account;

import com.dropbox.core.p013v2.account.PhotoSourceArg;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class SetProfilePhotoArg {

    @Nonnull
    protected final PhotoSourceArg photo;

    public SetProfilePhotoArg(@Nonnull PhotoSourceArg photoSourceArg) {
        if (photoSourceArg == null) {
            throw new IllegalArgumentException("Required value for 'photo' is null");
        }
        this.photo = photoSourceArg;
    }

    @Nonnull
    public PhotoSourceArg getPhoto() {
        return this.photo;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.photo});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PhotoSourceArg photoSourceArg = this.photo;
        PhotoSourceArg photoSourceArg2 = ((SetProfilePhotoArg) obj).photo;
        return photoSourceArg == photoSourceArg2 || photoSourceArg.equals(photoSourceArg2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SetProfilePhotoArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SetProfilePhotoArg setProfilePhotoArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("photo");
            PhotoSourceArg.Serializer.INSTANCE.serialize(setProfilePhotoArg.photo, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SetProfilePhotoArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PhotoSourceArg photoSourceArgDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("photo".equals(currentName)) {
                        photoSourceArgDeserialize = PhotoSourceArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (photoSourceArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"photo\" missing.");
                }
                SetProfilePhotoArg setProfilePhotoArg = new SetProfilePhotoArg(photoSourceArgDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(setProfilePhotoArg, setProfilePhotoArg.toStringMultiline());
                return setProfilePhotoArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
