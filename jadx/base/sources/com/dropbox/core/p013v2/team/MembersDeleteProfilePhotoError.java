package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum MembersDeleteProfilePhotoError {
    USER_NOT_FOUND,
    USER_NOT_IN_TEAM,
    SET_PROFILE_DISALLOWED,
    OTHER;

    static class Serializer extends UnionSerializer<MembersDeleteProfilePhotoError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(MembersDeleteProfilePhotoError membersDeleteProfilePhotoError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43711.f760xf6f78d4[membersDeleteProfilePhotoError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("user_not_found");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("user_not_in_team");
            } else if (i == 3) {
                jsonGenerator.writeString("set_profile_disallowed");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public MembersDeleteProfilePhotoError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            MembersDeleteProfilePhotoError membersDeleteProfilePhotoError;
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
                membersDeleteProfilePhotoError = MembersDeleteProfilePhotoError.USER_NOT_FOUND;
            } else if ("user_not_in_team".equals(tag)) {
                membersDeleteProfilePhotoError = MembersDeleteProfilePhotoError.USER_NOT_IN_TEAM;
            } else if ("set_profile_disallowed".equals(tag)) {
                membersDeleteProfilePhotoError = MembersDeleteProfilePhotoError.SET_PROFILE_DISALLOWED;
            } else {
                membersDeleteProfilePhotoError = MembersDeleteProfilePhotoError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return membersDeleteProfilePhotoError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.MembersDeleteProfilePhotoError$1 */
    static /* synthetic */ class C43711 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$MembersDeleteProfilePhotoError */
        static final /* synthetic */ int[] f760xf6f78d4;

        static {
            int[] iArr = new int[MembersDeleteProfilePhotoError.values().length];
            f760xf6f78d4 = iArr;
            try {
                iArr[MembersDeleteProfilePhotoError.USER_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f760xf6f78d4[MembersDeleteProfilePhotoError.USER_NOT_IN_TEAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f760xf6f78d4[MembersDeleteProfilePhotoError.SET_PROFILE_DISALLOWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
