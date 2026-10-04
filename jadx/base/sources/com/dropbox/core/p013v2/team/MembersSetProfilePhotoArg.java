package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.account.PhotoSourceArg;
import com.dropbox.core.p013v2.team.UserSelectorArg;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
class MembersSetProfilePhotoArg {

    @Nonnull
    protected final PhotoSourceArg photo;

    @Nonnull
    protected final UserSelectorArg user;

    public MembersSetProfilePhotoArg(@Nonnull UserSelectorArg userSelectorArg, @Nonnull PhotoSourceArg photoSourceArg) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userSelectorArg;
        if (photoSourceArg == null) {
            throw new IllegalArgumentException("Required value for 'photo' is null");
        }
        this.photo = photoSourceArg;
    }

    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    @Nonnull
    public PhotoSourceArg getPhoto() {
        return this.photo;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.user, this.photo});
    }

    public boolean equals(Object obj) {
        PhotoSourceArg photoSourceArg;
        PhotoSourceArg photoSourceArg2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MembersSetProfilePhotoArg membersSetProfilePhotoArg = (MembersSetProfilePhotoArg) obj;
        UserSelectorArg userSelectorArg = this.user;
        UserSelectorArg userSelectorArg2 = membersSetProfilePhotoArg.user;
        return (userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2)) && ((photoSourceArg = this.photo) == (photoSourceArg2 = membersSetProfilePhotoArg.photo) || photoSourceArg.equals(photoSourceArg2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersSetProfilePhotoArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersSetProfilePhotoArg membersSetProfilePhotoArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(membersSetProfilePhotoArg.user, jsonGenerator);
            jsonGenerator.writeFieldName("photo");
            PhotoSourceArg.Serializer.INSTANCE.serialize(membersSetProfilePhotoArg.photo, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersSetProfilePhotoArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserSelectorArg userSelectorArgDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PhotoSourceArg photoSourceArgDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("photo".equals(currentName)) {
                        photoSourceArgDeserialize = PhotoSourceArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                if (photoSourceArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"photo\" missing.");
                }
                MembersSetProfilePhotoArg membersSetProfilePhotoArg = new MembersSetProfilePhotoArg(userSelectorArgDeserialize, photoSourceArgDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersSetProfilePhotoArg, membersSetProfilePhotoArg.toStringMultiline());
                return membersSetProfilePhotoArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
