package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.p013v2.fileproperties.LookupError;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidPropertyGroupError {
    private Tag _tag;
    private LookupError pathValue;
    private String templateNotFoundValue;
    public static final InvalidPropertyGroupError RESTRICTED_CONTENT = new InvalidPropertyGroupError().withTag(Tag.RESTRICTED_CONTENT);
    public static final InvalidPropertyGroupError OTHER = new InvalidPropertyGroupError().withTag(Tag.OTHER);
    public static final InvalidPropertyGroupError UNSUPPORTED_FOLDER = new InvalidPropertyGroupError().withTag(Tag.UNSUPPORTED_FOLDER);
    public static final InvalidPropertyGroupError PROPERTY_FIELD_TOO_LARGE = new InvalidPropertyGroupError().withTag(Tag.PROPERTY_FIELD_TOO_LARGE);
    public static final InvalidPropertyGroupError DOES_NOT_FIT_TEMPLATE = new InvalidPropertyGroupError().withTag(Tag.DOES_NOT_FIT_TEMPLATE);
    public static final InvalidPropertyGroupError DUPLICATE_PROPERTY_GROUPS = new InvalidPropertyGroupError().withTag(Tag.DUPLICATE_PROPERTY_GROUPS);

    public enum Tag {
        TEMPLATE_NOT_FOUND,
        RESTRICTED_CONTENT,
        OTHER,
        PATH,
        UNSUPPORTED_FOLDER,
        PROPERTY_FIELD_TOO_LARGE,
        DOES_NOT_FIT_TEMPLATE,
        DUPLICATE_PROPERTY_GROUPS
    }

    private InvalidPropertyGroupError() {
    }

    private InvalidPropertyGroupError withTag(Tag tag) {
        InvalidPropertyGroupError invalidPropertyGroupError = new InvalidPropertyGroupError();
        invalidPropertyGroupError._tag = tag;
        return invalidPropertyGroupError;
    }

    private InvalidPropertyGroupError withTagAndTemplateNotFound(Tag tag, String str) {
        InvalidPropertyGroupError invalidPropertyGroupError = new InvalidPropertyGroupError();
        invalidPropertyGroupError._tag = tag;
        invalidPropertyGroupError.templateNotFoundValue = str;
        return invalidPropertyGroupError;
    }

    private InvalidPropertyGroupError withTagAndPath(Tag tag, LookupError lookupError) {
        InvalidPropertyGroupError invalidPropertyGroupError = new InvalidPropertyGroupError();
        invalidPropertyGroupError._tag = tag;
        invalidPropertyGroupError.pathValue = lookupError;
        return invalidPropertyGroupError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isTemplateNotFound() {
        return this._tag == Tag.TEMPLATE_NOT_FOUND;
    }

    public static InvalidPropertyGroupError templateNotFound(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        if (!Pattern.matches("(/|ptid:).*", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new InvalidPropertyGroupError().withTagAndTemplateNotFound(Tag.TEMPLATE_NOT_FOUND, str);
    }

    public String getTemplateNotFoundValue() {
        if (this._tag != Tag.TEMPLATE_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.TEMPLATE_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return this.templateNotFoundValue;
    }

    public boolean isRestrictedContent() {
        return this._tag == Tag.RESTRICTED_CONTENT;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    public static InvalidPropertyGroupError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new InvalidPropertyGroupError().withTagAndPath(Tag.PATH, lookupError);
    }

    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return this.pathValue;
    }

    public boolean isUnsupportedFolder() {
        return this._tag == Tag.UNSUPPORTED_FOLDER;
    }

    public boolean isPropertyFieldTooLarge() {
        return this._tag == Tag.PROPERTY_FIELD_TOO_LARGE;
    }

    public boolean isDoesNotFitTemplate() {
        return this._tag == Tag.DOES_NOT_FIT_TEMPLATE;
    }

    public boolean isDuplicatePropertyGroups() {
        return this._tag == Tag.DUPLICATE_PROPERTY_GROUPS;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.templateNotFoundValue, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof InvalidPropertyGroupError)) {
            return false;
        }
        InvalidPropertyGroupError invalidPropertyGroupError = (InvalidPropertyGroupError) obj;
        if (this._tag != invalidPropertyGroupError._tag) {
            return false;
        }
        switch (C41171.f668x15f51144[this._tag.ordinal()]) {
            case 1:
                String str = this.templateNotFoundValue;
                String str2 = invalidPropertyGroupError.templateNotFoundValue;
                return str == str2 || str.equals(str2);
            case 4:
                LookupError lookupError = this.pathValue;
                LookupError lookupError2 = invalidPropertyGroupError.pathValue;
                if (lookupError != lookupError2 && !lookupError.equals(lookupError2)) {
                    return false;
                }
            case 2:
            case 3:
                return true;
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.InvalidPropertyGroupError$1 */
    static /* synthetic */ class C41171 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$fileproperties$InvalidPropertyGroupError$Tag */
        static final /* synthetic */ int[] f668x15f51144;

        static {
            int[] iArr = new int[Tag.values().length];
            f668x15f51144 = iArr;
            try {
                iArr[Tag.TEMPLATE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f668x15f51144[Tag.RESTRICTED_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f668x15f51144[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f668x15f51144[Tag.PATH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f668x15f51144[Tag.UNSUPPORTED_FOLDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f668x15f51144[Tag.PROPERTY_FIELD_TOO_LARGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f668x15f51144[Tag.DOES_NOT_FIT_TEMPLATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f668x15f51144[Tag.DUPLICATE_PROPERTY_GROUPS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<InvalidPropertyGroupError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(InvalidPropertyGroupError invalidPropertyGroupError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41171.f668x15f51144[invalidPropertyGroupError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("template_not_found", jsonGenerator);
                    jsonGenerator.writeFieldName("template_not_found");
                    StoneSerializers.string().serialize(invalidPropertyGroupError.templateNotFoundValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 2:
                    jsonGenerator.writeString("restricted_content");
                    return;
                case 3:
                    jsonGenerator.writeString("other");
                    return;
                case 4:
                    jsonGenerator.writeStartObject();
                    writeTag(ClientCookie.PATH_ATTR, jsonGenerator);
                    jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
                    LookupError.Serializer.INSTANCE.serialize(invalidPropertyGroupError.pathValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 5:
                    jsonGenerator.writeString("unsupported_folder");
                    return;
                case 6:
                    jsonGenerator.writeString("property_field_too_large");
                    return;
                case 7:
                    jsonGenerator.writeString("does_not_fit_template");
                    return;
                case 8:
                    jsonGenerator.writeString("duplicate_property_groups");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + invalidPropertyGroupError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public InvalidPropertyGroupError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            InvalidPropertyGroupError invalidPropertyGroupErrorPath;
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
            if ("template_not_found".equals(tag)) {
                expectField("template_not_found", jsonParser);
                invalidPropertyGroupErrorPath = InvalidPropertyGroupError.templateNotFound(StoneSerializers.string().deserialize(jsonParser));
            } else if ("restricted_content".equals(tag)) {
                invalidPropertyGroupErrorPath = InvalidPropertyGroupError.RESTRICTED_CONTENT;
            } else if ("other".equals(tag)) {
                invalidPropertyGroupErrorPath = InvalidPropertyGroupError.OTHER;
            } else if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                invalidPropertyGroupErrorPath = InvalidPropertyGroupError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("unsupported_folder".equals(tag)) {
                invalidPropertyGroupErrorPath = InvalidPropertyGroupError.UNSUPPORTED_FOLDER;
            } else if ("property_field_too_large".equals(tag)) {
                invalidPropertyGroupErrorPath = InvalidPropertyGroupError.PROPERTY_FIELD_TOO_LARGE;
            } else if ("does_not_fit_template".equals(tag)) {
                invalidPropertyGroupErrorPath = InvalidPropertyGroupError.DOES_NOT_FIT_TEMPLATE;
            } else if ("duplicate_property_groups".equals(tag)) {
                invalidPropertyGroupErrorPath = InvalidPropertyGroupError.DUPLICATE_PROPERTY_GROUPS;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return invalidPropertyGroupErrorPath;
        }
    }
}
