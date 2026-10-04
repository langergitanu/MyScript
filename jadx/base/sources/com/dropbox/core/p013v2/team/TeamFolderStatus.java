package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamFolderStatus {
    ACTIVE,
    ARCHIVED,
    ARCHIVE_IN_PROGRESS,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamFolderStatus$1 */
    static /* synthetic */ class C44111 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamFolderStatus;

        static {
            int[] iArr = new int[TeamFolderStatus.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamFolderStatus = iArr;
            try {
                iArr[TeamFolderStatus.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderStatus[TeamFolderStatus.ARCHIVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamFolderStatus[TeamFolderStatus.ARCHIVE_IN_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<TeamFolderStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamFolderStatus teamFolderStatus, JsonGenerator jsonGenerator) throws IOException {
            int i = C44111.$SwitchMap$com$dropbox$core$v2$team$TeamFolderStatus[teamFolderStatus.ordinal()];
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
        public TeamFolderStatus deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamFolderStatus teamFolderStatus;
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
                teamFolderStatus = TeamFolderStatus.ACTIVE;
            } else if ("archived".equals(tag)) {
                teamFolderStatus = TeamFolderStatus.ARCHIVED;
            } else if ("archive_in_progress".equals(tag)) {
                teamFolderStatus = TeamFolderStatus.ARCHIVE_IN_PROGRESS;
            } else {
                teamFolderStatus = TeamFolderStatus.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamFolderStatus;
        }
    }
}
