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
public final class SharingAllowlistRemoveError {
    private Tag _tag;
    private String entriesDoNotExistValue;
    private String malformedEntryValue;
    public static final SharingAllowlistRemoveError NO_ENTRIES_PROVIDED = new SharingAllowlistRemoveError().withTag(Tag.NO_ENTRIES_PROVIDED);
    public static final SharingAllowlistRemoveError TOO_MANY_ENTRIES_PROVIDED = new SharingAllowlistRemoveError().withTag(Tag.TOO_MANY_ENTRIES_PROVIDED);
    public static final SharingAllowlistRemoveError UNKNOWN_ERROR = new SharingAllowlistRemoveError().withTag(Tag.UNKNOWN_ERROR);
    public static final SharingAllowlistRemoveError OTHER = new SharingAllowlistRemoveError().withTag(Tag.OTHER);

    public enum Tag {
        MALFORMED_ENTRY,
        ENTRIES_DO_NOT_EXIST,
        NO_ENTRIES_PROVIDED,
        TOO_MANY_ENTRIES_PROVIDED,
        UNKNOWN_ERROR,
        OTHER
    }

    private SharingAllowlistRemoveError() {
    }

    private SharingAllowlistRemoveError withTag(Tag tag) {
        SharingAllowlistRemoveError sharingAllowlistRemoveError = new SharingAllowlistRemoveError();
        sharingAllowlistRemoveError._tag = tag;
        return sharingAllowlistRemoveError;
    }

    private SharingAllowlistRemoveError withTagAndMalformedEntry(Tag tag, String str) {
        SharingAllowlistRemoveError sharingAllowlistRemoveError = new SharingAllowlistRemoveError();
        sharingAllowlistRemoveError._tag = tag;
        sharingAllowlistRemoveError.malformedEntryValue = str;
        return sharingAllowlistRemoveError;
    }

    private SharingAllowlistRemoveError withTagAndEntriesDoNotExist(Tag tag, String str) {
        SharingAllowlistRemoveError sharingAllowlistRemoveError = new SharingAllowlistRemoveError();
        sharingAllowlistRemoveError._tag = tag;
        sharingAllowlistRemoveError.entriesDoNotExistValue = str;
        return sharingAllowlistRemoveError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isMalformedEntry() {
        return this._tag == Tag.MALFORMED_ENTRY;
    }

    public static SharingAllowlistRemoveError malformedEntry(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SharingAllowlistRemoveError().withTagAndMalformedEntry(Tag.MALFORMED_ENTRY, str);
    }

    public String getMalformedEntryValue() {
        if (this._tag != Tag.MALFORMED_ENTRY) {
            throw new IllegalStateException("Invalid tag: required Tag.MALFORMED_ENTRY, but was Tag." + this._tag.name());
        }
        return this.malformedEntryValue;
    }

    public boolean isEntriesDoNotExist() {
        return this._tag == Tag.ENTRIES_DO_NOT_EXIST;
    }

    public static SharingAllowlistRemoveError entriesDoNotExist(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SharingAllowlistRemoveError().withTagAndEntriesDoNotExist(Tag.ENTRIES_DO_NOT_EXIST, str);
    }

    public String getEntriesDoNotExistValue() {
        if (this._tag != Tag.ENTRIES_DO_NOT_EXIST) {
            throw new IllegalStateException("Invalid tag: required Tag.ENTRIES_DO_NOT_EXIST, but was Tag." + this._tag.name());
        }
        return this.entriesDoNotExistValue;
    }

    public boolean isNoEntriesProvided() {
        return this._tag == Tag.NO_ENTRIES_PROVIDED;
    }

    public boolean isTooManyEntriesProvided() {
        return this._tag == Tag.TOO_MANY_ENTRIES_PROVIDED;
    }

    public boolean isUnknownError() {
        return this._tag == Tag.UNKNOWN_ERROR;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.malformedEntryValue, this.entriesDoNotExistValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof SharingAllowlistRemoveError)) {
            return false;
        }
        SharingAllowlistRemoveError sharingAllowlistRemoveError = (SharingAllowlistRemoveError) obj;
        if (this._tag != sharingAllowlistRemoveError._tag) {
            return false;
        }
        switch (C43991.f766xa8b41156[this._tag.ordinal()]) {
            case 1:
                String str = this.malformedEntryValue;
                String str2 = sharingAllowlistRemoveError.malformedEntryValue;
                return str == str2 || str.equals(str2);
            case 2:
                String str3 = this.entriesDoNotExistValue;
                String str4 = sharingAllowlistRemoveError.entriesDoNotExistValue;
                return str3 == str4 || str3.equals(str4);
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.SharingAllowlistRemoveError$1 */
    static /* synthetic */ class C43991 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$team$SharingAllowlistRemoveError$Tag */
        static final /* synthetic */ int[] f766xa8b41156;

        static {
            int[] iArr = new int[Tag.values().length];
            f766xa8b41156 = iArr;
            try {
                iArr[Tag.MALFORMED_ENTRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f766xa8b41156[Tag.ENTRIES_DO_NOT_EXIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f766xa8b41156[Tag.NO_ENTRIES_PROVIDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f766xa8b41156[Tag.TOO_MANY_ENTRIES_PROVIDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f766xa8b41156[Tag.UNKNOWN_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f766xa8b41156[Tag.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<SharingAllowlistRemoveError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(SharingAllowlistRemoveError sharingAllowlistRemoveError, JsonGenerator jsonGenerator) throws IOException {
            int i = C43991.f766xa8b41156[sharingAllowlistRemoveError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("malformed_entry", jsonGenerator);
                jsonGenerator.writeFieldName("malformed_entry");
                StoneSerializers.string().serialize(sharingAllowlistRemoveError.malformedEntryValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("entries_do_not_exist", jsonGenerator);
                jsonGenerator.writeFieldName("entries_do_not_exist");
                StoneSerializers.string().serialize(sharingAllowlistRemoveError.entriesDoNotExistValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("no_entries_provided");
                return;
            }
            if (i == 4) {
                jsonGenerator.writeString("too_many_entries_provided");
            } else if (i == 5) {
                jsonGenerator.writeString("unknown_error");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public SharingAllowlistRemoveError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            SharingAllowlistRemoveError sharingAllowlistRemoveErrorEntriesDoNotExist;
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
                sharingAllowlistRemoveErrorEntriesDoNotExist = SharingAllowlistRemoveError.malformedEntry(StoneSerializers.string().deserialize(jsonParser));
            } else if ("entries_do_not_exist".equals(tag)) {
                expectField("entries_do_not_exist", jsonParser);
                sharingAllowlistRemoveErrorEntriesDoNotExist = SharingAllowlistRemoveError.entriesDoNotExist(StoneSerializers.string().deserialize(jsonParser));
            } else if ("no_entries_provided".equals(tag)) {
                sharingAllowlistRemoveErrorEntriesDoNotExist = SharingAllowlistRemoveError.NO_ENTRIES_PROVIDED;
            } else if ("too_many_entries_provided".equals(tag)) {
                sharingAllowlistRemoveErrorEntriesDoNotExist = SharingAllowlistRemoveError.TOO_MANY_ENTRIES_PROVIDED;
            } else if ("unknown_error".equals(tag)) {
                sharingAllowlistRemoveErrorEntriesDoNotExist = SharingAllowlistRemoveError.UNKNOWN_ERROR;
            } else {
                sharingAllowlistRemoveErrorEntriesDoNotExist = SharingAllowlistRemoveError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return sharingAllowlistRemoveErrorEntriesDoNotExist;
        }
    }
}
