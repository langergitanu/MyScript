package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class GetTemporaryLinkError {
    private Tag _tag;
    private LookupError pathValue;
    public static final GetTemporaryLinkError EMAIL_NOT_VERIFIED = new GetTemporaryLinkError().withTag(Tag.EMAIL_NOT_VERIFIED);
    public static final GetTemporaryLinkError UNSUPPORTED_FILE = new GetTemporaryLinkError().withTag(Tag.UNSUPPORTED_FILE);
    public static final GetTemporaryLinkError NOT_ALLOWED = new GetTemporaryLinkError().withTag(Tag.NOT_ALLOWED);
    public static final GetTemporaryLinkError OTHER = new GetTemporaryLinkError().withTag(Tag.OTHER);

    public enum Tag {
        PATH,
        EMAIL_NOT_VERIFIED,
        UNSUPPORTED_FILE,
        NOT_ALLOWED,
        OTHER
    }

    private GetTemporaryLinkError() {
    }

    private GetTemporaryLinkError withTag(Tag tag) {
        GetTemporaryLinkError getTemporaryLinkError = new GetTemporaryLinkError();
        getTemporaryLinkError._tag = tag;
        return getTemporaryLinkError;
    }

    private GetTemporaryLinkError withTagAndPath(Tag tag, LookupError lookupError) {
        GetTemporaryLinkError getTemporaryLinkError = new GetTemporaryLinkError();
        getTemporaryLinkError._tag = tag;
        getTemporaryLinkError.pathValue = lookupError;
        return getTemporaryLinkError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static GetTemporaryLinkError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GetTemporaryLinkError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isEmailNotVerified() {
        return this._tag == Tag.EMAIL_NOT_VERIFIED;
    }

    public boolean isUnsupportedFile() {
        return this._tag == Tag.UNSUPPORTED_FILE;
    }

    public boolean isNotAllowed() {
        return this._tag == Tag.NOT_ALLOWED;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof GetTemporaryLinkError)) {
            return false;
        }
        GetTemporaryLinkError getTemporaryLinkError = (GetTemporaryLinkError) obj;
        if (this._tag != getTemporaryLinkError._tag) {
            return false;
        }
        int i = C41631.$SwitchMap$com$dropbox$core$v2$files$GetTemporaryLinkError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3 || i == 4 || i == 5;
        }
        LookupError lookupError = this.pathValue;
        LookupError lookupError2 = getTemporaryLinkError.pathValue;
        return lookupError == lookupError2 || lookupError.equals(lookupError2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.GetTemporaryLinkError$1 */
    static /* synthetic */ class C41631 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$GetTemporaryLinkError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$files$GetTemporaryLinkError$Tag = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$GetTemporaryLinkError$Tag[Tag.EMAIL_NOT_VERIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$GetTemporaryLinkError$Tag[Tag.UNSUPPORTED_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$GetTemporaryLinkError$Tag[Tag.NOT_ALLOWED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$GetTemporaryLinkError$Tag[Tag.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<GetTemporaryLinkError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(GetTemporaryLinkError getTemporaryLinkError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41631.$SwitchMap$com$dropbox$core$v2$files$GetTemporaryLinkError$Tag[getTemporaryLinkError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(getTemporaryLinkError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("email_not_verified");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeString("unsupported_file");
            } else if (i == 4) {
                jsonGenerator.writeString("not_allowed");
            } else {
                jsonGenerator.writeString("other");
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public GetTemporaryLinkError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            GetTemporaryLinkError getTemporaryLinkErrorPath;
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
            if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                getTemporaryLinkErrorPath = GetTemporaryLinkError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("email_not_verified".equals(tag)) {
                getTemporaryLinkErrorPath = GetTemporaryLinkError.EMAIL_NOT_VERIFIED;
            } else if ("unsupported_file".equals(tag)) {
                getTemporaryLinkErrorPath = GetTemporaryLinkError.UNSUPPORTED_FILE;
            } else if ("not_allowed".equals(tag)) {
                getTemporaryLinkErrorPath = GetTemporaryLinkError.NOT_ALLOWED;
            } else {
                getTemporaryLinkErrorPath = GetTemporaryLinkError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return getTemporaryLinkErrorPath;
        }
    }
}
