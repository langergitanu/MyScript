package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharedLinkSettingsError;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class ModifySharedLinkSettingsError {
    private Tag _tag;
    private SharedLinkSettingsError settingsErrorValue;
    public static final ModifySharedLinkSettingsError SHARED_LINK_NOT_FOUND = new ModifySharedLinkSettingsError().withTag(Tag.SHARED_LINK_NOT_FOUND);
    public static final ModifySharedLinkSettingsError SHARED_LINK_ACCESS_DENIED = new ModifySharedLinkSettingsError().withTag(Tag.SHARED_LINK_ACCESS_DENIED);
    public static final ModifySharedLinkSettingsError UNSUPPORTED_LINK_TYPE = new ModifySharedLinkSettingsError().withTag(Tag.UNSUPPORTED_LINK_TYPE);
    public static final ModifySharedLinkSettingsError OTHER = new ModifySharedLinkSettingsError().withTag(Tag.OTHER);
    public static final ModifySharedLinkSettingsError EMAIL_NOT_VERIFIED = new ModifySharedLinkSettingsError().withTag(Tag.EMAIL_NOT_VERIFIED);

    public enum Tag {
        SHARED_LINK_NOT_FOUND,
        SHARED_LINK_ACCESS_DENIED,
        UNSUPPORTED_LINK_TYPE,
        OTHER,
        SETTINGS_ERROR,
        EMAIL_NOT_VERIFIED
    }

    private ModifySharedLinkSettingsError() {
    }

    private ModifySharedLinkSettingsError withTag(Tag tag) {
        ModifySharedLinkSettingsError modifySharedLinkSettingsError = new ModifySharedLinkSettingsError();
        modifySharedLinkSettingsError._tag = tag;
        return modifySharedLinkSettingsError;
    }

    private ModifySharedLinkSettingsError withTagAndSettingsError(Tag tag, SharedLinkSettingsError sharedLinkSettingsError) {
        ModifySharedLinkSettingsError modifySharedLinkSettingsError = new ModifySharedLinkSettingsError();
        modifySharedLinkSettingsError._tag = tag;
        modifySharedLinkSettingsError.settingsErrorValue = sharedLinkSettingsError;
        return modifySharedLinkSettingsError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isSharedLinkNotFound() {
        return this._tag == Tag.SHARED_LINK_NOT_FOUND;
    }

    public boolean isSharedLinkAccessDenied() {
        return this._tag == Tag.SHARED_LINK_ACCESS_DENIED;
    }

    public boolean isUnsupportedLinkType() {
        return this._tag == Tag.UNSUPPORTED_LINK_TYPE;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public boolean isSettingsError() {
        return this._tag == Tag.SETTINGS_ERROR;
    }

    public static ModifySharedLinkSettingsError settingsError(SharedLinkSettingsError sharedLinkSettingsError) {
        if (sharedLinkSettingsError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ModifySharedLinkSettingsError().withTagAndSettingsError(Tag.SETTINGS_ERROR, sharedLinkSettingsError);
    }

    public SharedLinkSettingsError getSettingsErrorValue() {
        if (this._tag != Tag.SETTINGS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.SETTINGS_ERROR, but was Tag." + this._tag.name());
        }
        return this.settingsErrorValue;
    }

    public boolean isEmailNotVerified() {
        return this._tag == Tag.EMAIL_NOT_VERIFIED;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.settingsErrorValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ModifySharedLinkSettingsError)) {
            return false;
        }
        ModifySharedLinkSettingsError modifySharedLinkSettingsError = (ModifySharedLinkSettingsError) obj;
        if (this._tag != modifySharedLinkSettingsError._tag) {
            return false;
        }
        switch (C42831.f726x9798790c[this._tag.ordinal()]) {
            case 5:
                SharedLinkSettingsError sharedLinkSettingsError = this.settingsErrorValue;
                SharedLinkSettingsError sharedLinkSettingsError2 = modifySharedLinkSettingsError.settingsErrorValue;
                if (sharedLinkSettingsError != sharedLinkSettingsError2 && !sharedLinkSettingsError.equals(sharedLinkSettingsError2)) {
                    return false;
                }
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.sharing.ModifySharedLinkSettingsError$1 */
    static /* synthetic */ class C42831 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$sharing$ModifySharedLinkSettingsError$Tag */
        static final /* synthetic */ int[] f726x9798790c;

        static {
            int[] iArr = new int[Tag.values().length];
            f726x9798790c = iArr;
            try {
                iArr[Tag.SHARED_LINK_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f726x9798790c[Tag.SHARED_LINK_ACCESS_DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f726x9798790c[Tag.UNSUPPORTED_LINK_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f726x9798790c[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f726x9798790c[Tag.SETTINGS_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f726x9798790c[Tag.EMAIL_NOT_VERIFIED.ordinal()] = 6;
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

    static class Serializer extends UnionSerializer<ModifySharedLinkSettingsError> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(ModifySharedLinkSettingsError modifySharedLinkSettingsError, JsonGenerator jsonGenerator) throws IOException {
            switch (C42831.f726x9798790c[modifySharedLinkSettingsError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeString("shared_link_not_found");
                    return;
                case 2:
                    jsonGenerator.writeString("shared_link_access_denied");
                    return;
                case 3:
                    jsonGenerator.writeString("unsupported_link_type");
                    return;
                case 4:
                    jsonGenerator.writeString("other");
                    return;
                case 5:
                    jsonGenerator.writeStartObject();
                    writeTag("settings_error", jsonGenerator);
                    jsonGenerator.writeFieldName("settings_error");
                    SharedLinkSettingsError.Serializer.INSTANCE.serialize(modifySharedLinkSettingsError.settingsErrorValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 6:
                    jsonGenerator.writeString("email_not_verified");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + modifySharedLinkSettingsError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public ModifySharedLinkSettingsError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            ModifySharedLinkSettingsError modifySharedLinkSettingsError;
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
            if ("shared_link_not_found".equals(tag)) {
                modifySharedLinkSettingsError = ModifySharedLinkSettingsError.SHARED_LINK_NOT_FOUND;
            } else if ("shared_link_access_denied".equals(tag)) {
                modifySharedLinkSettingsError = ModifySharedLinkSettingsError.SHARED_LINK_ACCESS_DENIED;
            } else if ("unsupported_link_type".equals(tag)) {
                modifySharedLinkSettingsError = ModifySharedLinkSettingsError.UNSUPPORTED_LINK_TYPE;
            } else if ("other".equals(tag)) {
                modifySharedLinkSettingsError = ModifySharedLinkSettingsError.OTHER;
            } else if ("settings_error".equals(tag)) {
                expectField("settings_error", jsonParser);
                modifySharedLinkSettingsError = ModifySharedLinkSettingsError.settingsError(SharedLinkSettingsError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("email_not_verified".equals(tag)) {
                modifySharedLinkSettingsError = ModifySharedLinkSettingsError.EMAIL_NOT_VERIFIED;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return modifySharedLinkSettingsError;
        }
    }
}
