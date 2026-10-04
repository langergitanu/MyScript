package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum Feature {
    UPLOAD_API_RATE_LIMIT,
    HAS_TEAM_SHARED_DROPBOX,
    HAS_TEAM_FILE_EVENTS,
    HAS_TEAM_SELECTIVE_SYNC,
    OTHER;

    static class Serializer extends UnionSerializer<Feature> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(Feature feature, JsonGenerator jsonGenerator) throws IOException {
            int i = C43311.$SwitchMap$com$dropbox$core$v2$team$Feature[feature.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("upload_api_rate_limit");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("has_team_shared_dropbox");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("has_team_file_events");
            } else if (i == 4) {
                jsonGenerator.writeString("has_team_selective_sync");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public Feature deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            Feature feature;
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
            if ("upload_api_rate_limit".equals(tag)) {
                feature = Feature.UPLOAD_API_RATE_LIMIT;
            } else if ("has_team_shared_dropbox".equals(tag)) {
                feature = Feature.HAS_TEAM_SHARED_DROPBOX;
            } else if ("has_team_file_events".equals(tag)) {
                feature = Feature.HAS_TEAM_FILE_EVENTS;
            } else if ("has_team_selective_sync".equals(tag)) {
                feature = Feature.HAS_TEAM_SELECTIVE_SYNC;
            } else {
                feature = Feature.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return feature;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.Feature$1 */
    static /* synthetic */ class C43311 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$Feature;

        static {
            int[] iArr = new int[Feature.values().length];
            $SwitchMap$com$dropbox$core$v2$team$Feature = iArr;
            try {
                iArr[Feature.UPLOAD_API_RATE_LIMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$Feature[Feature.HAS_TEAM_SHARED_DROPBOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$Feature[Feature.HAS_TEAM_FILE_EVENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$Feature[Feature.HAS_TEAM_SELECTIVE_SYNC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
