package com.dropbox.core.p013v2.auth;

import com.dropbox.core.p013v2.auth.InvalidAccountTypeError;
import com.dropbox.core.p013v2.auth.PaperAccessError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class AccessError {
    public static final AccessError OTHER = new AccessError().withTag(Tag.OTHER);
    private Tag _tag;
    private InvalidAccountTypeError invalidAccountTypeValue;
    private PaperAccessError paperAccessDeniedValue;

    public enum Tag {
        INVALID_ACCOUNT_TYPE,
        PAPER_ACCESS_DENIED,
        OTHER
    }

    private AccessError() {
    }

    private AccessError withTag(Tag tag) {
        AccessError accessError = new AccessError();
        accessError._tag = tag;
        return accessError;
    }

    private AccessError withTagAndInvalidAccountType(Tag tag, InvalidAccountTypeError invalidAccountTypeError) {
        AccessError accessError = new AccessError();
        accessError._tag = tag;
        accessError.invalidAccountTypeValue = invalidAccountTypeError;
        return accessError;
    }

    private AccessError withTagAndPaperAccessDenied(Tag tag, PaperAccessError paperAccessError) {
        AccessError accessError = new AccessError();
        accessError._tag = tag;
        accessError.paperAccessDeniedValue = paperAccessError;
        return accessError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInvalidAccountType() {
        return this._tag == Tag.INVALID_ACCOUNT_TYPE;
    }

    public static AccessError invalidAccountType(InvalidAccountTypeError invalidAccountTypeError) {
        if (invalidAccountTypeError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessError().withTagAndInvalidAccountType(Tag.INVALID_ACCOUNT_TYPE, invalidAccountTypeError);
    }

    public InvalidAccountTypeError getInvalidAccountTypeValue() {
        if (this._tag != Tag.INVALID_ACCOUNT_TYPE) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_ACCOUNT_TYPE, but was Tag." + this._tag.name());
        }
        return this.invalidAccountTypeValue;
    }

    public boolean isPaperAccessDenied() {
        return this._tag == Tag.PAPER_ACCESS_DENIED;
    }

    public static AccessError paperAccessDenied(PaperAccessError paperAccessError) {
        if (paperAccessError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessError().withTagAndPaperAccessDenied(Tag.PAPER_ACCESS_DENIED, paperAccessError);
    }

    public PaperAccessError getPaperAccessDeniedValue() {
        if (this._tag != Tag.PAPER_ACCESS_DENIED) {
            throw new IllegalStateException("Invalid tag: required Tag.PAPER_ACCESS_DENIED, but was Tag." + this._tag.name());
        }
        return this.paperAccessDeniedValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.invalidAccountTypeValue, this.paperAccessDeniedValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessError)) {
            return false;
        }
        AccessError accessError = (AccessError) obj;
        if (this._tag != accessError._tag) {
            return false;
        }
        int i = C41071.$SwitchMap$com$dropbox$core$v2$auth$AccessError$Tag[this._tag.ordinal()];
        if (i == 1) {
            InvalidAccountTypeError invalidAccountTypeError = this.invalidAccountTypeValue;
            InvalidAccountTypeError invalidAccountTypeError2 = accessError.invalidAccountTypeValue;
            return invalidAccountTypeError == invalidAccountTypeError2 || invalidAccountTypeError.equals(invalidAccountTypeError2);
        }
        if (i != 2) {
            return i == 3;
        }
        PaperAccessError paperAccessError = this.paperAccessDeniedValue;
        PaperAccessError paperAccessError2 = accessError.paperAccessDeniedValue;
        return paperAccessError == paperAccessError2 || paperAccessError.equals(paperAccessError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.auth.AccessError$1 */
    static /* synthetic */ class C41071 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$auth$AccessError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$auth$AccessError$Tag = iArr;
            try {
                iArr[Tag.INVALID_ACCOUNT_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$AccessError$Tag[Tag.PAPER_ACCESS_DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$auth$AccessError$Tag[Tag.OTHER.ordinal()] = 3;
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

    public static class Serializer extends UnionSerializer<AccessError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AccessError accessError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41071.$SwitchMap$com$dropbox$core$v2$auth$AccessError$Tag[accessError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("invalid_account_type", jsonGenerator);
                jsonGenerator.writeFieldName("invalid_account_type");
                InvalidAccountTypeError.Serializer.INSTANCE.serialize(accessError.invalidAccountTypeValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("paper_access_denied", jsonGenerator);
                jsonGenerator.writeFieldName("paper_access_denied");
                PaperAccessError.Serializer.INSTANCE.serialize(accessError.paperAccessDeniedValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AccessError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AccessError accessErrorPaperAccessDenied;
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
            if ("invalid_account_type".equals(tag)) {
                expectField("invalid_account_type", jsonParser);
                accessErrorPaperAccessDenied = AccessError.invalidAccountType(InvalidAccountTypeError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("paper_access_denied".equals(tag)) {
                expectField("paper_access_denied", jsonParser);
                accessErrorPaperAccessDenied = AccessError.paperAccessDenied(PaperAccessError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                accessErrorPaperAccessDenied = AccessError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return accessErrorPaperAccessDenied;
        }
    }
}
