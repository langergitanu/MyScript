package com.dropbox.core.p013v2.account;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class SetProfilePhotoResult {

    @Nonnull
    protected final String profilePhotoUrl;

    public SetProfilePhotoResult(@Nonnull String str) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'profilePhotoUrl' is null");
        }
        this.profilePhotoUrl = str;
    }

    @Nonnull
    public String getProfilePhotoUrl() {
        return this.profilePhotoUrl;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.profilePhotoUrl});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        String str = this.profilePhotoUrl;
        String str2 = ((SetProfilePhotoResult) obj).profilePhotoUrl;
        return str == str2 || str.equals(str2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SetProfilePhotoResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SetProfilePhotoResult setProfilePhotoResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("profile_photo_url");
            StoneSerializers.string().serialize(setProfilePhotoResult.profilePhotoUrl, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SetProfilePhotoResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
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
                    if ("profile_photo_url".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"profile_photo_url\" missing.");
                }
                SetProfilePhotoResult setProfilePhotoResult = new SetProfilePhotoResult(strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(setProfilePhotoResult, setProfilePhotoResult.toStringMultiline());
                return setProfilePhotoResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
