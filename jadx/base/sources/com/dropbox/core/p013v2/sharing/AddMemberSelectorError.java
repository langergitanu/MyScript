package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class AddMemberSelectorError {
    public static final AddMemberSelectorError AUTOMATIC_GROUP = new AddMemberSelectorError().withTag(Tag.AUTOMATIC_GROUP);
    public static final AddMemberSelectorError GROUP_DELETED = new AddMemberSelectorError().withTag(Tag.GROUP_DELETED);
    public static final AddMemberSelectorError GROUP_NOT_ON_TEAM = new AddMemberSelectorError().withTag(Tag.GROUP_NOT_ON_TEAM);
    public static final AddMemberSelectorError OTHER = new AddMemberSelectorError().withTag(Tag.OTHER);
    private Tag _tag;
    private String invalidDropboxIdValue;
    private String invalidEmailValue;
    private String unverifiedDropboxIdValue;

    public enum Tag {
        AUTOMATIC_GROUP,
        INVALID_DROPBOX_ID,
        INVALID_EMAIL,
        UNVERIFIED_DROPBOX_ID,
        GROUP_DELETED,
        GROUP_NOT_ON_TEAM,
        OTHER
    }

    private AddMemberSelectorError() {
    }

    private AddMemberSelectorError withTag(Tag tag) {
        AddMemberSelectorError addMemberSelectorError = new AddMemberSelectorError();
        addMemberSelectorError._tag = tag;
        return addMemberSelectorError;
    }

    private AddMemberSelectorError withTagAndInvalidDropboxId(Tag tag, String str) {
        AddMemberSelectorError addMemberSelectorError = new AddMemberSelectorError();
        addMemberSelectorError._tag = tag;
        addMemberSelectorError.invalidDropboxIdValue = str;
        return addMemberSelectorError;
    }

    private AddMemberSelectorError withTagAndInvalidEmail(Tag tag, String str) {
        AddMemberSelectorError addMemberSelectorError = new AddMemberSelectorError();
        addMemberSelectorError._tag = tag;
        addMemberSelectorError.invalidEmailValue = str;
        return addMemberSelectorError;
    }

    private AddMemberSelectorError withTagAndUnverifiedDropboxId(Tag tag, String str) {
        AddMemberSelectorError addMemberSelectorError = new AddMemberSelectorError();
        addMemberSelectorError._tag = tag;
        addMemberSelectorError.unverifiedDropboxIdValue = str;
        return addMemberSelectorError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isAutomaticGroup() {
        return this._tag == Tag.AUTOMATIC_GROUP;
    }

    public boolean isInvalidDropboxId() {
        return this._tag == Tag.INVALID_DROPBOX_ID;
    }

    public static AddMemberSelectorError invalidDropboxId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new AddMemberSelectorError().withTagAndInvalidDropboxId(Tag.INVALID_DROPBOX_ID, str);
    }

    public String getInvalidDropboxIdValue() {
        if (this._tag != Tag.INVALID_DROPBOX_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_DROPBOX_ID, but was Tag." + this._tag.name());
        }
        return this.invalidDropboxIdValue;
    }

    public boolean isInvalidEmail() {
        return this._tag == Tag.INVALID_EMAIL;
    }

    public static AddMemberSelectorError invalidEmail(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddMemberSelectorError().withTagAndInvalidEmail(Tag.INVALID_EMAIL, str);
    }

    public String getInvalidEmailValue() {
        if (this._tag != Tag.INVALID_EMAIL) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_EMAIL, but was Tag." + this._tag.name());
        }
        return this.invalidEmailValue;
    }

    public boolean isUnverifiedDropboxId() {
        return this._tag == Tag.UNVERIFIED_DROPBOX_ID;
    }

    public static AddMemberSelectorError unverifiedDropboxId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new AddMemberSelectorError().withTagAndUnverifiedDropboxId(Tag.UNVERIFIED_DROPBOX_ID, str);
    }

    public String getUnverifiedDropboxIdValue() {
        if (this._tag != Tag.UNVERIFIED_DROPBOX_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.UNVERIFIED_DROPBOX_ID, but was Tag." + this._tag.name());
        }
        return this.unverifiedDropboxIdValue;
    }

    public boolean isGroupDeleted() {
        return this._tag == Tag.GROUP_DELETED;
    }

    public boolean isGroupNotOnTeam() {
        return this._tag == Tag.GROUP_NOT_ON_TEAM;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.invalidDropboxIdValue, this.invalidEmailValue, this.unverifiedDropboxIdValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AddMemberSelectorError)) {
            return false;
        }
        AddMemberSelectorError addMemberSelectorError = (AddMemberSelectorError) obj;
        if (this._tag != addMemberSelectorError._tag) {
            return false;
        }
        switch (C42511.f716xe57eab3a[this._tag.ordinal()]) {
            case 2:
                String str = this.invalidDropboxIdValue;
                String str2 = addMemberSelectorError.invalidDropboxIdValue;
                if (str != str2 && !str.equals(str2)) {
                    return false;
                }
            case 1:
                return true;
            case 3:
                String str3 = this.invalidEmailValue;
                String str4 = addMemberSelectorError.invalidEmailValue;
                return str3 == str4 || str3.equals(str4);
            case 4:
                String str5 = this.unverifiedDropboxIdValue;
                String str6 = addMemberSelectorError.unverifiedDropboxIdValue;
                return str5 == str6 || str5.equals(str6);
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.AddMemberSelectorError$1 */
    static /* synthetic */ class C42511 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$AddMemberSelectorError$Tag */
        static final /* synthetic */ int[] f716xe57eab3a;

        static {
            int[] iArr = new int[Tag.values().length];
            f716xe57eab3a = iArr;
            try {
                iArr[Tag.AUTOMATIC_GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f716xe57eab3a[Tag.INVALID_DROPBOX_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f716xe57eab3a[Tag.INVALID_EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f716xe57eab3a[Tag.UNVERIFIED_DROPBOX_ID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f716xe57eab3a[Tag.GROUP_DELETED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f716xe57eab3a[Tag.GROUP_NOT_ON_TEAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f716xe57eab3a[Tag.OTHER.ordinal()] = 7;
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

    static class Serializer extends UnionSerializer<AddMemberSelectorError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AddMemberSelectorError addMemberSelectorError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42511.f716xe57eab3a[addMemberSelectorError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeString("automatic_group");
                    break;
                case 2:
                    jsonGenerator.writeStartObject();
                    writeTag("invalid_dropbox_id", jsonGenerator);
                    jsonGenerator.writeFieldName("invalid_dropbox_id");
                    StoneSerializers.string().serialize(addMemberSelectorError.invalidDropboxIdValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 3:
                    jsonGenerator.writeStartObject();
                    writeTag("invalid_email", jsonGenerator);
                    jsonGenerator.writeFieldName("invalid_email");
                    StoneSerializers.string().serialize(addMemberSelectorError.invalidEmailValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 4:
                    jsonGenerator.writeStartObject();
                    writeTag("unverified_dropbox_id", jsonGenerator);
                    jsonGenerator.writeFieldName("unverified_dropbox_id");
                    StoneSerializers.string().serialize(addMemberSelectorError.unverifiedDropboxIdValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    break;
                case 5:
                    jsonGenerator.writeString("group_deleted");
                    break;
                case 6:
                    jsonGenerator.writeString("group_not_on_team");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AddMemberSelectorError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AddMemberSelectorError addMemberSelectorErrorUnverifiedDropboxId;
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
            if ("automatic_group".equals(tag)) {
                addMemberSelectorErrorUnverifiedDropboxId = AddMemberSelectorError.AUTOMATIC_GROUP;
            } else if ("invalid_dropbox_id".equals(tag)) {
                expectField("invalid_dropbox_id", jsonParser);
                addMemberSelectorErrorUnverifiedDropboxId = AddMemberSelectorError.invalidDropboxId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("invalid_email".equals(tag)) {
                expectField("invalid_email", jsonParser);
                addMemberSelectorErrorUnverifiedDropboxId = AddMemberSelectorError.invalidEmail(StoneSerializers.string().deserialize(jsonParser));
            } else if ("unverified_dropbox_id".equals(tag)) {
                expectField("unverified_dropbox_id", jsonParser);
                addMemberSelectorErrorUnverifiedDropboxId = AddMemberSelectorError.unverifiedDropboxId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("group_deleted".equals(tag)) {
                addMemberSelectorErrorUnverifiedDropboxId = AddMemberSelectorError.GROUP_DELETED;
            } else if ("group_not_on_team".equals(tag)) {
                addMemberSelectorErrorUnverifiedDropboxId = AddMemberSelectorError.GROUP_NOT_ON_TEAM;
            } else {
                addMemberSelectorErrorUnverifiedDropboxId = AddMemberSelectorError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return addMemberSelectorErrorUnverifiedDropboxId;
        }
    }
}
