package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public enum TeamReportFailureReason {
    TEMPORARY_ERROR,
    MANY_REPORTS_AT_ONCE,
    TOO_MUCH_DATA,
    OTHER;

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.TeamReportFailureReason$1 */
    static /* synthetic */ class C44181 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$TeamReportFailureReason;

        static {
            int[] iArr = new int[TeamReportFailureReason.values().length];
            $SwitchMap$com$dropbox$core$v2$team$TeamReportFailureReason = iArr;
            try {
                iArr[TeamReportFailureReason.TEMPORARY_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamReportFailureReason[TeamReportFailureReason.MANY_REPORTS_AT_ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$TeamReportFailureReason[TeamReportFailureReason.TOO_MUCH_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Serializer extends UnionSerializer<TeamReportFailureReason> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(TeamReportFailureReason teamReportFailureReason, JsonGenerator jsonGenerator) throws IOException {
            int i = C44181.$SwitchMap$com$dropbox$core$v2$team$TeamReportFailureReason[teamReportFailureReason.ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("temporary_error");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("many_reports_at_once");
            } else if (i == 3) {
                jsonGenerator.writeString("too_much_data");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public TeamReportFailureReason deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            TeamReportFailureReason teamReportFailureReason;
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
            if ("temporary_error".equals(tag)) {
                teamReportFailureReason = TeamReportFailureReason.TEMPORARY_ERROR;
            } else if ("many_reports_at_once".equals(tag)) {
                teamReportFailureReason = TeamReportFailureReason.MANY_REPORTS_AT_ONCE;
            } else if ("too_much_data".equals(tag)) {
                teamReportFailureReason = TeamReportFailureReason.TOO_MUCH_DATA;
            } else {
                teamReportFailureReason = TeamReportFailureReason.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return teamReportFailureReason;
        }
    }
}
