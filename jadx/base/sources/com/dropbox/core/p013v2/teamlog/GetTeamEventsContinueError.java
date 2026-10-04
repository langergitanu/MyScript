package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public final class GetTeamEventsContinueError {
    public static final GetTeamEventsContinueError BAD_CURSOR = new GetTeamEventsContinueError().withTag(Tag.BAD_CURSOR);
    public static final GetTeamEventsContinueError OTHER = new GetTeamEventsContinueError().withTag(Tag.OTHER);
    private Tag _tag;
    private Date resetValue;

    public enum Tag {
        BAD_CURSOR,
        RESET,
        OTHER
    }

    private GetTeamEventsContinueError() {
    }

    private GetTeamEventsContinueError withTag(Tag tag) {
        GetTeamEventsContinueError getTeamEventsContinueError = new GetTeamEventsContinueError();
        getTeamEventsContinueError._tag = tag;
        return getTeamEventsContinueError;
    }

    private GetTeamEventsContinueError withTagAndReset(Tag tag, Date date) {
        GetTeamEventsContinueError getTeamEventsContinueError = new GetTeamEventsContinueError();
        getTeamEventsContinueError._tag = tag;
        getTeamEventsContinueError.resetValue = date;
        return getTeamEventsContinueError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isBadCursor() {
        return this._tag == Tag.BAD_CURSOR;
    }

    public boolean isReset() {
        return this._tag == Tag.RESET;
    }

    public static GetTeamEventsContinueError reset(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GetTeamEventsContinueError().withTagAndReset(Tag.RESET, date);
    }

    public Date getResetValue() {
        if (this._tag != Tag.RESET) {
            throw new IllegalStateException("Invalid tag: required Tag.RESET, but was Tag." + this._tag.name());
        }
        return this.resetValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.resetValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof GetTeamEventsContinueError)) {
            return false;
        }
        GetTeamEventsContinueError getTeamEventsContinueError = (GetTeamEventsContinueError) obj;
        if (this._tag != getTeamEventsContinueError._tag) {
            return false;
        }
        int i = C44811.f792xa12df116[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i == 3;
            }
            Date date = this.resetValue;
            Date date2 = getTeamEventsContinueError.resetValue;
            if (date != date2 && !date.equals(date2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.GetTeamEventsContinueError$1 */
    static /* synthetic */ class C44811 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$teamlog$GetTeamEventsContinueError$Tag */
        static final /* synthetic */ int[] f792xa12df116;

        static {
            int[] iArr = new int[Tag.values().length];
            f792xa12df116 = iArr;
            try {
                iArr[Tag.BAD_CURSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f792xa12df116[Tag.RESET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f792xa12df116[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<GetTeamEventsContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetTeamEventsContinueError getTeamEventsContinueError, JsonGenerator jsonGenerator) throws IOException {
            int i = C44811.f792xa12df116[getTeamEventsContinueError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("bad_cursor");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("reset", jsonGenerator);
                jsonGenerator.writeFieldName("reset");
                StoneSerializers.timestamp().serialize(getTeamEventsContinueError.resetValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetTeamEventsContinueError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GetTeamEventsContinueError getTeamEventsContinueErrorReset;
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
            if ("bad_cursor".equals(tag)) {
                getTeamEventsContinueErrorReset = GetTeamEventsContinueError.BAD_CURSOR;
            } else if ("reset".equals(tag)) {
                expectField("reset", jsonParser);
                getTeamEventsContinueErrorReset = GetTeamEventsContinueError.reset(StoneSerializers.timestamp().deserialize(jsonParser));
            } else {
                getTeamEventsContinueErrorReset = GetTeamEventsContinueError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return getTeamEventsContinueErrorReset;
        }
    }
}
