package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamFolderInvalidStatusError {
    ACTIVE,
    ARCHIVED,
    ARCHIVE_IN_PROGRESS,
    OTHER;

    static class Serializer extends UnionSerializer<TeamFolderInvalidStatusError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderInvalidStatusError teamFolderInvalidStatusError, JsonGenerator jsonGenerator) throws IOException {
            int i = C44071.$SwitchMap$com$dropbox$core$v2$team$TeamFolderInvalidStatusError[teamFolderInvalidStatusError.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("archived");
            } else if (i == 3) {
                jsonGenerator.writeString("archive_in_progress");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamFolderInvalidStatusError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderInvalidStatusError teamFolderInvalidStatusError;
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
            if (AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equals(tag)) {
                teamFolderInvalidStatusError = TeamFolderInvalidStatusError.ACTIVE;
            } else if ("archived".equals(tag)) {
                teamFolderInvalidStatusError = TeamFolderInvalidStatusError.ARCHIVED;
            } else if ("archive_in_progress".equals(tag)) {
                teamFolderInvalidStatusError = TeamFolderInvalidStatusError.ARCHIVE_IN_PROGRESS;
            } else {
                teamFolderInvalidStatusError = TeamFolderInvalidStatusError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderInvalidStatusError;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderInvalidStatusError$1 */
    static /* synthetic */ class C44071 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamFolderInvalidStatusError;

        static {
            int[] iArr = new int[TeamFolderInvalidStatusError.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamFolderInvalidStatusError = iArr;
            try {
                iArr[TeamFolderInvalidStatusError.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderInvalidStatusError[TeamFolderInvalidStatusError.ARCHIVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderInvalidStatusError[TeamFolderInvalidStatusError.ARCHIVE_IN_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
