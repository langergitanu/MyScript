package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.account.SetProfilePhotoError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class MembersSetProfilePhotoError {
    private Tag _tag;
    private SetProfilePhotoError photoErrorValue;
    public static final MembersSetProfilePhotoError USER_NOT_FOUND = new MembersSetProfilePhotoError().withTag(Tag.USER_NOT_FOUND);
    public static final MembersSetProfilePhotoError USER_NOT_IN_TEAM = new MembersSetProfilePhotoError().withTag(Tag.USER_NOT_IN_TEAM);
    public static final MembersSetProfilePhotoError SET_PROFILE_DISALLOWED = new MembersSetProfilePhotoError().withTag(Tag.SET_PROFILE_DISALLOWED);
    public static final MembersSetProfilePhotoError OTHER = new MembersSetProfilePhotoError().withTag(Tag.OTHER);

    public enum Tag {
        USER_NOT_FOUND,
        USER_NOT_IN_TEAM,
        SET_PROFILE_DISALLOWED,
        PHOTO_ERROR,
        OTHER
    }

    private MembersSetProfilePhotoError() {
    }

    private MembersSetProfilePhotoError withTag(Tag tag) {
        MembersSetProfilePhotoError membersSetProfilePhotoError = new MembersSetProfilePhotoError();
        membersSetProfilePhotoError._tag = tag;
        return membersSetProfilePhotoError;
    }

    private MembersSetProfilePhotoError withTagAndPhotoError(Tag tag, SetProfilePhotoError setProfilePhotoError) {
        MembersSetProfilePhotoError membersSetProfilePhotoError = new MembersSetProfilePhotoError();
        membersSetProfilePhotoError._tag = tag;
        membersSetProfilePhotoError.photoErrorValue = setProfilePhotoError;
        return membersSetProfilePhotoError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isUserNotFound() {
        return this._tag == Tag.USER_NOT_FOUND;
    }

    public boolean isUserNotInTeam() {
        return this._tag == Tag.USER_NOT_IN_TEAM;
    }

    public boolean isSetProfileDisallowed() {
        return this._tag == Tag.SET_PROFILE_DISALLOWED;
    }

    public boolean isPhotoError() {
        return this._tag == Tag.PHOTO_ERROR;
    }

    public static MembersSetProfilePhotoError photoError(SetProfilePhotoError setProfilePhotoError) {
        if (setProfilePhotoError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersSetProfilePhotoError().withTagAndPhotoError(Tag.PHOTO_ERROR, setProfilePhotoError);
    }

    public SetProfilePhotoError getPhotoErrorValue() {
        if (this._tag != Tag.PHOTO_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.PHOTO_ERROR, but was Tag." + this._tag.name());
        }
        return this.photoErrorValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.photoErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof MembersSetProfilePhotoError)) {
            return false;
        }
        MembersSetProfilePhotoError membersSetProfilePhotoError = (MembersSetProfilePhotoError) obj;
        if (this._tag != membersSetProfilePhotoError._tag) {
            return false;
        }
        int i = C43831.f761xfd4129d3[this._tag.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i != 4) {
                return i == 5;
            }
            SetProfilePhotoError setProfilePhotoError = this.photoErrorValue;
            SetProfilePhotoError setProfilePhotoError2 = membersSetProfilePhotoError.photoErrorValue;
            if (setProfilePhotoError != setProfilePhotoError2 && !setProfilePhotoError.equals(setProfilePhotoError2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersSetProfilePhotoError$1 */
    static /* synthetic */ class C43831 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$MembersSetProfilePhotoError$Tag */
        static final /* synthetic */ int[] f761xfd4129d3;

        static {
            int[] iArr = new int[Tag.values().length];
            f761xfd4129d3 = iArr;
            try {
                iArr[Tag.USER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f761xfd4129d3[Tag.USER_NOT_IN_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f761xfd4129d3[Tag.SET_PROFILE_DISALLOWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f761xfd4129d3[Tag.PHOTO_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f761xfd4129d3[Tag.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<MembersSetProfilePhotoError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersSetProfilePhotoError membersSetProfilePhotoError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43831.f761xfd4129d3[membersSetProfilePhotoError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("user_not_found");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("user_not_in_team");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("set_profile_disallowed");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeStartObject();
                writeTag("photo_error", jsonGenerator);
                jsonGenerator.writeFieldName("photo_error");
                SetProfilePhotoError.Serializer.INSTANCE.serialize(membersSetProfilePhotoError.photoErrorValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersSetProfilePhotoError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersSetProfilePhotoError membersSetProfilePhotoErrorPhotoError;
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
            if ("user_not_found".equals(tag)) {
                membersSetProfilePhotoErrorPhotoError = MembersSetProfilePhotoError.USER_NOT_FOUND;
            } else if ("user_not_in_team".equals(tag)) {
                membersSetProfilePhotoErrorPhotoError = MembersSetProfilePhotoError.USER_NOT_IN_TEAM;
            } else if ("set_profile_disallowed".equals(tag)) {
                membersSetProfilePhotoErrorPhotoError = MembersSetProfilePhotoError.SET_PROFILE_DISALLOWED;
            } else if ("photo_error".equals(tag)) {
                expectField("photo_error", jsonParser);
                membersSetProfilePhotoErrorPhotoError = MembersSetProfilePhotoError.photoError(SetProfilePhotoError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                membersSetProfilePhotoErrorPhotoError = MembersSetProfilePhotoError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersSetProfilePhotoErrorPhotoError;
        }
    }
}
