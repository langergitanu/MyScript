package com.dropbox.core.p013v2.contacts;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class DeleteManualContactsError {
    public static final DeleteManualContactsError OTHER = new DeleteManualContactsError().withTag(Tag.OTHER);
    private Tag _tag;
    private List<String> contactsNotFoundValue;

    public enum Tag {
        CONTACTS_NOT_FOUND,
        OTHER
    }

    private DeleteManualContactsError() {
    }

    private DeleteManualContactsError withTag(Tag tag) {
        DeleteManualContactsError deleteManualContactsError = new DeleteManualContactsError();
        deleteManualContactsError._tag = tag;
        return deleteManualContactsError;
    }

    private DeleteManualContactsError withTagAndContactsNotFound(Tag tag, List<String> list) {
        DeleteManualContactsError deleteManualContactsError = new DeleteManualContactsError();
        deleteManualContactsError._tag = tag;
        deleteManualContactsError.contactsNotFoundValue = list;
        return deleteManualContactsError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isContactsNotFound() {
        return this._tag == Tag.CONTACTS_NOT_FOUND;
    }

    public static DeleteManualContactsError contactsNotFound(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String str : list) {
            if (str == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
            if (str.length() > 255) {
                throw new IllegalArgumentException("Stringan item in list is longer than 255");
            }
            if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
                throw new IllegalArgumentException("Stringan item in list does not match pattern");
            }
        }
        return new DeleteManualContactsError().withTagAndContactsNotFound(Tag.CONTACTS_NOT_FOUND, list);
    }

    public List<String> getContactsNotFoundValue() {
        if (this._tag != Tag.CONTACTS_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.CONTACTS_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return this.contactsNotFoundValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.contactsNotFoundValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteManualContactsError)) {
            return false;
        }
        DeleteManualContactsError deleteManualContactsError = (DeleteManualContactsError) obj;
        if (this._tag != deleteManualContactsError._tag) {
            return false;
        }
        int i = C41151.f666xb051e4b7[this._tag.ordinal()];
        if (i != 1) {
            return i == 2;
        }
        List<String> list = this.contactsNotFoundValue;
        List<String> list2 = deleteManualContactsError.contactsNotFoundValue;
        return list == list2 || list.equals(list2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.contacts.DeleteManualContactsError$1 */
    static /* synthetic */ class C41151 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$contacts$DeleteManualContactsError$Tag */
        static final /* synthetic */ int[] f666xb051e4b7;

        static {
            int[] iArr = new int[Tag.values().length];
            f666xb051e4b7 = iArr;
            try {
                iArr[Tag.CONTACTS_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f666xb051e4b7[Tag.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<DeleteManualContactsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(DeleteManualContactsError deleteManualContactsError, JsonGenerator jsonGenerator) throws IOException {
            if (C41151.f666xb051e4b7[deleteManualContactsError.tag().ordinal()] == 1) {
                jsonGenerator.writeStartObject();
                writeTag("contacts_not_found", jsonGenerator);
                jsonGenerator.writeFieldName("contacts_not_found");
                StoneSerializers.list(StoneSerializers.string()).serialize(deleteManualContactsError.contactsNotFoundValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public DeleteManualContactsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            DeleteManualContactsError deleteManualContactsErrorContactsNotFound;
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
            if ("contacts_not_found".equals(tag)) {
                expectField("contacts_not_found", jsonParser);
                deleteManualContactsErrorContactsNotFound = DeleteManualContactsError.contactsNotFound((List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser));
            } else {
                deleteManualContactsErrorContactsNotFound = DeleteManualContactsError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return deleteManualContactsErrorContactsNotFound;
        }
    }
}
