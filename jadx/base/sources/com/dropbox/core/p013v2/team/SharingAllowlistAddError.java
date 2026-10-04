package com.dropbox.core.p013v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class SharingAllowlistAddError {
    private Tag _tag;
    private String entriesAlreadyExistValue;
    private String malformedEntryValue;
    public static final SharingAllowlistAddError NO_ENTRIES_PROVIDED = new SharingAllowlistAddError().withTag(Tag.NO_ENTRIES_PROVIDED);
    public static final SharingAllowlistAddError TOO_MANY_ENTRIES_PROVIDED = new SharingAllowlistAddError().withTag(Tag.TOO_MANY_ENTRIES_PROVIDED);
    public static final SharingAllowlistAddError TEAM_LIMIT_REACHED = new SharingAllowlistAddError().withTag(Tag.TEAM_LIMIT_REACHED);
    public static final SharingAllowlistAddError UNKNOWN_ERROR = new SharingAllowlistAddError().withTag(Tag.UNKNOWN_ERROR);
    public static final SharingAllowlistAddError OTHER = new SharingAllowlistAddError().withTag(Tag.OTHER);

    public enum Tag {
        MALFORMED_ENTRY,
        NO_ENTRIES_PROVIDED,
        TOO_MANY_ENTRIES_PROVIDED,
        TEAM_LIMIT_REACHED,
        UNKNOWN_ERROR,
        ENTRIES_ALREADY_EXIST,
        OTHER
    }

    private SharingAllowlistAddError() {
    }

    private SharingAllowlistAddError withTag(Tag tag) {
        SharingAllowlistAddError sharingAllowlistAddError = new SharingAllowlistAddError();
        sharingAllowlistAddError._tag = tag;
        return sharingAllowlistAddError;
    }

    private SharingAllowlistAddError withTagAndMalformedEntry(Tag tag, String str) {
        SharingAllowlistAddError sharingAllowlistAddError = new SharingAllowlistAddError();
        sharingAllowlistAddError._tag = tag;
        sharingAllowlistAddError.malformedEntryValue = str;
        return sharingAllowlistAddError;
    }

    private SharingAllowlistAddError withTagAndEntriesAlreadyExist(Tag tag, String str) {
        SharingAllowlistAddError sharingAllowlistAddError = new SharingAllowlistAddError();
        sharingAllowlistAddError._tag = tag;
        sharingAllowlistAddError.entriesAlreadyExistValue = str;
        return sharingAllowlistAddError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isMalformedEntry() {
        return this._tag == Tag.MALFORMED_ENTRY;
    }

    public static SharingAllowlistAddError malformedEntry(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SharingAllowlistAddError().withTagAndMalformedEntry(Tag.MALFORMED_ENTRY, str);
    }

    public String getMalformedEntryValue() {
        if (this._tag != Tag.MALFORMED_ENTRY) {
            throw new IllegalStateException("Invalid tag: required Tag.MALFORMED_ENTRY, but was Tag." + this._tag.name());
        }
        return this.malformedEntryValue;
    }

    public boolean isNoEntriesProvided() {
        return this._tag == Tag.NO_ENTRIES_PROVIDED;
    }

    public boolean isTooManyEntriesProvided() {
        return this._tag == Tag.TOO_MANY_ENTRIES_PROVIDED;
    }

    public boolean isTeamLimitReached() {
        return this._tag == Tag.TEAM_LIMIT_REACHED;
    }

    public boolean isUnknownError() {
        return this._tag == Tag.UNKNOWN_ERROR;
    }

    public boolean isEntriesAlreadyExist() {
        return this._tag == Tag.ENTRIES_ALREADY_EXIST;
    }

    public static SharingAllowlistAddError entriesAlreadyExist(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SharingAllowlistAddError().withTagAndEntriesAlreadyExist(Tag.ENTRIES_ALREADY_EXIST, str);
    }

    public String getEntriesAlreadyExistValue() {
        if (this._tag != Tag.ENTRIES_ALREADY_EXIST) {
            throw new IllegalStateException("Invalid tag: required Tag.ENTRIES_ALREADY_EXIST, but was Tag." + this._tag.name());
        }
        return this.entriesAlreadyExistValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.malformedEntryValue, this.entriesAlreadyExistValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof SharingAllowlistAddError)) {
            return false;
        }
        SharingAllowlistAddError sharingAllowlistAddError = (SharingAllowlistAddError) obj;
        if (this._tag != sharingAllowlistAddError._tag) {
            return false;
        }
        switch (C43971.$SwitchMap$com$dropbox$core$v2$team$SharingAllowlistAddError$Tag[this._tag.ordinal()]) {
            case 1:
                String str = this.malformedEntryValue;
                String str2 = sharingAllowlistAddError.malformedEntryValue;
                return str == str2 || str.equals(str2);
            case 6:
                String str3 = this.entriesAlreadyExistValue;
                String str4 = sharingAllowlistAddError.entriesAlreadyExistValue;
                if (str3 != str4 && !str3.equals(str4)) {
                    return false;
                }
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            case 7:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.SharingAllowlistAddError$1 */
    static /* synthetic */ class C43971 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$SharingAllowlistAddError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$SharingAllowlistAddError$Tag = iArr;
            try {
                iArr[Tag.MALFORMED_ENTRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$SharingAllowlistAddError$Tag[Tag.NO_ENTRIES_PROVIDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$SharingAllowlistAddError$Tag[Tag.TOO_MANY_ENTRIES_PROVIDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$SharingAllowlistAddError$Tag[Tag.TEAM_LIMIT_REACHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$SharingAllowlistAddError$Tag[Tag.UNKNOWN_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$SharingAllowlistAddError$Tag[Tag.ENTRIES_ALREADY_EXIST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$SharingAllowlistAddError$Tag[Tag.OTHER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<SharingAllowlistAddError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharingAllowlistAddError sharingAllowlistAddError, JsonGenerator jsonGenerator) throws IOException {
            switch (C43971.$SwitchMap$com$dropbox$core$v2$team$SharingAllowlistAddError$Tag[sharingAllowlistAddError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("malformed_entry", jsonGenerator);
                    jsonGenerator.writeFieldName("malformed_entry");
                    StoneSerializers.string().serialize(sharingAllowlistAddError.malformedEntryValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 2:
                    jsonGenerator.writeString("no_entries_provided");
                    break;
                case 3:
                    jsonGenerator.writeString("too_many_entries_provided");
                    break;
                case 4:
                    jsonGenerator.writeString("team_limit_reached");
                    break;
                case 5:
                    jsonGenerator.writeString("unknown_error");
                    break;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("entries_already_exist", jsonGenerator);
                    jsonGenerator.writeFieldName("entries_already_exist");
                    StoneSerializers.string().serialize(sharingAllowlistAddError.entriesAlreadyExistValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharingAllowlistAddError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharingAllowlistAddError sharingAllowlistAddErrorEntriesAlreadyExist;
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
            if ("malformed_entry".equals(tag)) {
                expectField("malformed_entry", jsonParser);
                sharingAllowlistAddErrorEntriesAlreadyExist = SharingAllowlistAddError.malformedEntry(StoneSerializers.string().deserialize(jsonParser));
            } else if ("no_entries_provided".equals(tag)) {
                sharingAllowlistAddErrorEntriesAlreadyExist = SharingAllowlistAddError.NO_ENTRIES_PROVIDED;
            } else if ("too_many_entries_provided".equals(tag)) {
                sharingAllowlistAddErrorEntriesAlreadyExist = SharingAllowlistAddError.TOO_MANY_ENTRIES_PROVIDED;
            } else if ("team_limit_reached".equals(tag)) {
                sharingAllowlistAddErrorEntriesAlreadyExist = SharingAllowlistAddError.TEAM_LIMIT_REACHED;
            } else if ("unknown_error".equals(tag)) {
                sharingAllowlistAddErrorEntriesAlreadyExist = SharingAllowlistAddError.UNKNOWN_ERROR;
            } else if ("entries_already_exist".equals(tag)) {
                expectField("entries_already_exist", jsonParser);
                sharingAllowlistAddErrorEntriesAlreadyExist = SharingAllowlistAddError.entriesAlreadyExist(StoneSerializers.string().deserialize(jsonParser));
            } else {
                sharingAllowlistAddErrorEntriesAlreadyExist = SharingAllowlistAddError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharingAllowlistAddErrorEntriesAlreadyExist;
        }
    }
}
