package com.dropbox.core.p013v2.sharing;

import androidx.autofill.HintConstants;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum Visibility {
    PUBLIC,
    TEAM_ONLY,
    PASSWORD,
    TEAM_AND_PASSWORD,
    SHARED_FOLDER_ONLY,
    OTHER;

    static class Serializer extends UnionSerializer<Visibility> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(Visibility visibility, JsonGenerator jsonGenerator) throws IOException {
            int i = C43171.$SwitchMap$com$dropbox$core$v2$sharing$Visibility[visibility.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("public");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("team_only");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString(HintConstants.AUTOFILL_HINT_PASSWORD);
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("team_and_password");
            } else if (i == 5) {
                jsonGenerator.writeString("shared_folder_only");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public Visibility deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            Visibility visibility;
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
            if ("public".equals(tag)) {
                visibility = Visibility.PUBLIC;
            } else if ("team_only".equals(tag)) {
                visibility = Visibility.TEAM_ONLY;
            } else if (HintConstants.AUTOFILL_HINT_PASSWORD.equals(tag)) {
                visibility = Visibility.PASSWORD;
            } else if ("team_and_password".equals(tag)) {
                visibility = Visibility.TEAM_AND_PASSWORD;
            } else if ("shared_folder_only".equals(tag)) {
                visibility = Visibility.SHARED_FOLDER_ONLY;
            } else {
                visibility = Visibility.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return visibility;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.Visibility$1 */
    static /* synthetic */ class C43171 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$Visibility;

        static {
            int[] iArr = new int[Visibility.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$Visibility = iArr;
            try {
                iArr[Visibility.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$Visibility[Visibility.TEAM_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$Visibility[Visibility.PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$Visibility[Visibility.TEAM_AND_PASSWORD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$Visibility[Visibility.SHARED_FOLDER_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
