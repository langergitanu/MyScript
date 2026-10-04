package com.dropbox.core.p013v2.sharing;

import androidx.autofill.HintConstants;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum AlphaResolvedVisibility {
    PUBLIC,
    TEAM_ONLY,
    PASSWORD,
    TEAM_AND_PASSWORD,
    SHARED_FOLDER_ONLY,
    NO_ONE,
    ONLY_YOU,
    OTHER;

    static class Serializer extends UnionSerializer<AlphaResolvedVisibility> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AlphaResolvedVisibility alphaResolvedVisibility, JsonGenerator jsonGenerator) throws IOException {
            switch (C42521.$SwitchMap$com$dropbox$core$v2$sharing$AlphaResolvedVisibility[alphaResolvedVisibility.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("public");
                    return;
                case 2:
                    jsonGenerator.writeString("team_only");
                    return;
                case 3:
                    jsonGenerator.writeString(HintConstants.AUTOFILL_HINT_PASSWORD);
                    return;
                case 4:
                    jsonGenerator.writeString("team_and_password");
                    return;
                case 5:
                    jsonGenerator.writeString("shared_folder_only");
                    return;
                case 6:
                    jsonGenerator.writeString("no_one");
                    return;
                case 7:
                    jsonGenerator.writeString("only_you");
                    return;
                case 8:
                    jsonGenerator.writeString("other");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + alphaResolvedVisibility);
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AlphaResolvedVisibility deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AlphaResolvedVisibility alphaResolvedVisibility;
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
                alphaResolvedVisibility = AlphaResolvedVisibility.PUBLIC;
            } else if ("team_only".equals(tag)) {
                alphaResolvedVisibility = AlphaResolvedVisibility.TEAM_ONLY;
            } else if (HintConstants.AUTOFILL_HINT_PASSWORD.equals(tag)) {
                alphaResolvedVisibility = AlphaResolvedVisibility.PASSWORD;
            } else if ("team_and_password".equals(tag)) {
                alphaResolvedVisibility = AlphaResolvedVisibility.TEAM_AND_PASSWORD;
            } else if ("shared_folder_only".equals(tag)) {
                alphaResolvedVisibility = AlphaResolvedVisibility.SHARED_FOLDER_ONLY;
            } else if ("no_one".equals(tag)) {
                alphaResolvedVisibility = AlphaResolvedVisibility.NO_ONE;
            } else if ("only_you".equals(tag)) {
                alphaResolvedVisibility = AlphaResolvedVisibility.ONLY_YOU;
            } else if ("other".equals(tag)) {
                alphaResolvedVisibility = AlphaResolvedVisibility.OTHER;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return alphaResolvedVisibility;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.AlphaResolvedVisibility$1 */
    static /* synthetic */ class C42521 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$sharing$AlphaResolvedVisibility;

        static {
            int[] iArr = new int[AlphaResolvedVisibility.values().length];
            $SwitchMap$com$dropbox$core$v2$sharing$AlphaResolvedVisibility = iArr;
            try {
                iArr[AlphaResolvedVisibility.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AlphaResolvedVisibility[AlphaResolvedVisibility.TEAM_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AlphaResolvedVisibility[AlphaResolvedVisibility.PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AlphaResolvedVisibility[AlphaResolvedVisibility.TEAM_AND_PASSWORD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AlphaResolvedVisibility[AlphaResolvedVisibility.SHARED_FOLDER_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AlphaResolvedVisibility[AlphaResolvedVisibility.NO_ONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AlphaResolvedVisibility[AlphaResolvedVisibility.ONLY_YOU.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$sharing$AlphaResolvedVisibility[AlphaResolvedVisibility.OTHER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
