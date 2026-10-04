package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.files.LookupError;
import com.dropbox.core.p013v2.sharing.SharedLinkAlreadyExistsMetadata;
import com.dropbox.core.p013v2.sharing.SharedLinkSettingsError;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class CreateSharedLinkWithSettingsError {
    private Tag _tag;
    private LookupError pathValue;
    private SharedLinkSettingsError settingsErrorValue;
    private SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsValue;
    public static final CreateSharedLinkWithSettingsError EMAIL_NOT_VERIFIED = new CreateSharedLinkWithSettingsError().withTag(Tag.EMAIL_NOT_VERIFIED);
    public static final CreateSharedLinkWithSettingsError ACCESS_DENIED = new CreateSharedLinkWithSettingsError().withTag(Tag.ACCESS_DENIED);

    public enum Tag {
        PATH,
        EMAIL_NOT_VERIFIED,
        SHARED_LINK_ALREADY_EXISTS,
        SETTINGS_ERROR,
        ACCESS_DENIED
    }

    private CreateSharedLinkWithSettingsError() {
    }

    private CreateSharedLinkWithSettingsError withTag(Tag tag) {
        CreateSharedLinkWithSettingsError createSharedLinkWithSettingsError = new CreateSharedLinkWithSettingsError();
        createSharedLinkWithSettingsError._tag = tag;
        return createSharedLinkWithSettingsError;
    }

    private CreateSharedLinkWithSettingsError withTagAndPath(Tag tag, LookupError lookupError) {
        CreateSharedLinkWithSettingsError createSharedLinkWithSettingsError = new CreateSharedLinkWithSettingsError();
        createSharedLinkWithSettingsError._tag = tag;
        createSharedLinkWithSettingsError.pathValue = lookupError;
        return createSharedLinkWithSettingsError;
    }

    private CreateSharedLinkWithSettingsError withTagAndSharedLinkAlreadyExists(Tag tag, SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsMetadata) {
        CreateSharedLinkWithSettingsError createSharedLinkWithSettingsError = new CreateSharedLinkWithSettingsError();
        createSharedLinkWithSettingsError._tag = tag;
        createSharedLinkWithSettingsError.sharedLinkAlreadyExistsValue = sharedLinkAlreadyExistsMetadata;
        return createSharedLinkWithSettingsError;
    }

    private CreateSharedLinkWithSettingsError withTagAndSettingsError(Tag tag, SharedLinkSettingsError sharedLinkSettingsError) {
        CreateSharedLinkWithSettingsError createSharedLinkWithSettingsError = new CreateSharedLinkWithSettingsError();
        createSharedLinkWithSettingsError._tag = tag;
        createSharedLinkWithSettingsError.settingsErrorValue = sharedLinkSettingsError;
        return createSharedLinkWithSettingsError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static CreateSharedLinkWithSettingsError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateSharedLinkWithSettingsError().withTagAndPath(Tag.PATH, lookupError);
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

    public boolean isSharedLinkAlreadyExists() {
        return this._tag == Tag.SHARED_LINK_ALREADY_EXISTS;
    }

    public static CreateSharedLinkWithSettingsError sharedLinkAlreadyExists(SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsMetadata) {
        return new CreateSharedLinkWithSettingsError().withTagAndSharedLinkAlreadyExists(Tag.SHARED_LINK_ALREADY_EXISTS, sharedLinkAlreadyExistsMetadata);
    }

    public static CreateSharedLinkWithSettingsError sharedLinkAlreadyExists() {
        return sharedLinkAlreadyExists(null);
    }

    public SharedLinkAlreadyExistsMetadata getSharedLinkAlreadyExistsValue() {
        if (this._tag != Tag.SHARED_LINK_ALREADY_EXISTS) {
            throw new IllegalStateException("Invalid tag: required Tag.SHARED_LINK_ALREADY_EXISTS, but was Tag." + this._tag.name());
        }
        return this.sharedLinkAlreadyExistsValue;
    }

    public boolean isSettingsError() {
        return this._tag == Tag.SETTINGS_ERROR;
    }

    public static CreateSharedLinkWithSettingsError settingsError(SharedLinkSettingsError sharedLinkSettingsError) {
        if (sharedLinkSettingsError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new CreateSharedLinkWithSettingsError().withTagAndSettingsError(Tag.SETTINGS_ERROR, sharedLinkSettingsError);
    }

    public SharedLinkSettingsError getSettingsErrorValue() {
        if (this._tag != Tag.SETTINGS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.SETTINGS_ERROR, but was Tag." + this._tag.name());
        }
        return this.settingsErrorValue;
    }

    public boolean isAccessDenied() {
        return this._tag == Tag.ACCESS_DENIED;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.pathValue, this.sharedLinkAlreadyExistsValue, this.settingsErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateSharedLinkWithSettingsError)) {
            return false;
        }
        CreateSharedLinkWithSettingsError createSharedLinkWithSettingsError = (CreateSharedLinkWithSettingsError) obj;
        if (this._tag != createSharedLinkWithSettingsError._tag) {
            return false;
        }
        int i = C42541.f717xf1e34be4[this._tag.ordinal()];
        if (i == 1) {
            LookupError lookupError = this.pathValue;
            LookupError lookupError2 = createSharedLinkWithSettingsError.pathValue;
            return lookupError == lookupError2 || lookupError.equals(lookupError2);
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    return i == 5;
                }
                SharedLinkSettingsError sharedLinkSettingsError = this.settingsErrorValue;
                SharedLinkSettingsError sharedLinkSettingsError2 = createSharedLinkWithSettingsError.settingsErrorValue;
                return sharedLinkSettingsError == sharedLinkSettingsError2 || sharedLinkSettingsError.equals(sharedLinkSettingsError2);
            }
            SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsMetadata = this.sharedLinkAlreadyExistsValue;
            SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsMetadata2 = createSharedLinkWithSettingsError.sharedLinkAlreadyExistsValue;
            if (sharedLinkAlreadyExistsMetadata != sharedLinkAlreadyExistsMetadata2 && (sharedLinkAlreadyExistsMetadata == null || !sharedLinkAlreadyExistsMetadata.equals(sharedLinkAlreadyExistsMetadata2))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.CreateSharedLinkWithSettingsError$1 */
    static /* synthetic */ class C42541 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$CreateSharedLinkWithSettingsError$Tag */
        static final /* synthetic */ int[] f717xf1e34be4;

        static {
            int[] iArr = new int[Tag.values().length];
            f717xf1e34be4 = iArr;
            try {
                iArr[Tag.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f717xf1e34be4[Tag.EMAIL_NOT_VERIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f717xf1e34be4[Tag.SHARED_LINK_ALREADY_EXISTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f717xf1e34be4[Tag.SETTINGS_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f717xf1e34be4[Tag.ACCESS_DENIED.ordinal()] = 5;
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

    static class Serializer extends UnionSerializer<CreateSharedLinkWithSettingsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(CreateSharedLinkWithSettingsError createSharedLinkWithSettingsError, JsonGenerator jsonGenerator) throws IOException {
            int i = C42541.f717xf1e34be4[createSharedLinkWithSettingsError.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                LookupError.Serializer.INSTANCE.serialize(createSharedLinkWithSettingsError.pathValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeString("email_not_verified");
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("shared_link_already_exists", jsonGenerator);
                jsonGenerator.writeFieldName("shared_link_already_exists");
                StoneSerializers.nullable(SharedLinkAlreadyExistsMetadata.Serializer.INSTANCE).serialize(createSharedLinkWithSettingsError.sharedLinkAlreadyExistsValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i != 4) {
                if (i == 5) {
                    jsonGenerator.writeString("access_denied");
                    return;
                }
                throw new IllegalArgumentException("Unrecognized tag: " + createSharedLinkWithSettingsError.tag());
            }
            jsonGenerator.writeStartObject();
            writeTag("settings_error", jsonGenerator);
            jsonGenerator.writeFieldName("settings_error");
            SharedLinkSettingsError.Serializer.INSTANCE.serialize(createSharedLinkWithSettingsError.settingsErrorValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public CreateSharedLinkWithSettingsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            CreateSharedLinkWithSettingsError createSharedLinkWithSettingsErrorSharedLinkAlreadyExists;
            SharedLinkAlreadyExistsMetadata sharedLinkAlreadyExistsMetadata;
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
                createSharedLinkWithSettingsErrorSharedLinkAlreadyExists = CreateSharedLinkWithSettingsError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("email_not_verified".equals(tag)) {
                createSharedLinkWithSettingsErrorSharedLinkAlreadyExists = CreateSharedLinkWithSettingsError.EMAIL_NOT_VERIFIED;
            } else if ("shared_link_already_exists".equals(tag)) {
                if (jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                    expectField("shared_link_already_exists", jsonParser);
                    sharedLinkAlreadyExistsMetadata = (SharedLinkAlreadyExistsMetadata) StoneSerializers.nullable(SharedLinkAlreadyExistsMetadata.Serializer.INSTANCE).deserialize(jsonParser);
                } else {
                    sharedLinkAlreadyExistsMetadata = null;
                }
                if (sharedLinkAlreadyExistsMetadata == null) {
                    createSharedLinkWithSettingsErrorSharedLinkAlreadyExists = CreateSharedLinkWithSettingsError.sharedLinkAlreadyExists();
                } else {
                    createSharedLinkWithSettingsErrorSharedLinkAlreadyExists = CreateSharedLinkWithSettingsError.sharedLinkAlreadyExists(sharedLinkAlreadyExistsMetadata);
                }
            } else if ("settings_error".equals(tag)) {
                expectField("settings_error", jsonParser);
                createSharedLinkWithSettingsErrorSharedLinkAlreadyExists = CreateSharedLinkWithSettingsError.settingsError(SharedLinkSettingsError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("access_denied".equals(tag)) {
                createSharedLinkWithSettingsErrorSharedLinkAlreadyExists = CreateSharedLinkWithSettingsError.ACCESS_DENIED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return createSharedLinkWithSettingsErrorSharedLinkAlreadyExists;
        }
    }
}
