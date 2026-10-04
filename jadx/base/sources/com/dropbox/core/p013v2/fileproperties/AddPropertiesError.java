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
public final class AddPropertiesError {
    private Tag _tag;
    private LookupError pathValue;
    private String templateNotFoundValue;
    public static final AddPropertiesError RESTRICTED_CONTENT = new AddPropertiesError().withTag(Tag.RESTRICTED_CONTENT);
    public static final AddPropertiesError OTHER = new AddPropertiesError().withTag(Tag.OTHER);
    public static final AddPropertiesError UNSUPPORTED_FOLDER = new AddPropertiesError().withTag(Tag.UNSUPPORTED_FOLDER);
    public static final AddPropertiesError PROPERTY_FIELD_TOO_LARGE = new AddPropertiesError().withTag(Tag.PROPERTY_FIELD_TOO_LARGE);
    public static final AddPropertiesError DOES_NOT_FIT_TEMPLATE = new AddPropertiesError().withTag(Tag.DOES_NOT_FIT_TEMPLATE);
    public static final AddPropertiesError DUPLICATE_PROPERTY_GROUPS = new AddPropertiesError().withTag(Tag.DUPLICATE_PROPERTY_GROUPS);
    public static final AddPropertiesError PROPERTY_GROUP_ALREADY_EXISTS = new AddPropertiesError().withTag(Tag.PROPERTY_GROUP_ALREADY_EXISTS);

    public enum Tag {
        TEMPLATE_NOT_FOUND,
        RESTRICTED_CONTENT,
        OTHER,
        PATH,
        UNSUPPORTED_FOLDER,
        PROPERTY_FIELD_TOO_LARGE,
        DOES_NOT_FIT_TEMPLATE,
        DUPLICATE_PROPERTY_GROUPS,
        PROPERTY_GROUP_ALREADY_EXISTS
    }

    private AddPropertiesError() {
    }

    private AddPropertiesError withTag(Tag tag) {
        AddPropertiesError addPropertiesError = new AddPropertiesError();
        addPropertiesError._tag = tag;
        return addPropertiesError;
    }

    private AddPropertiesError withTagAndTemplateNotFound(Tag tag, String str) {
        AddPropertiesError addPropertiesError = new AddPropertiesError();
        addPropertiesError._tag = tag;
        addPropertiesError.templateNotFoundValue = str;
        return addPropertiesError;
    }

    private AddPropertiesError withTagAndPath(Tag tag, LookupError lookupError) {
        AddPropertiesError addPropertiesError = new AddPropertiesError();
        addPropertiesError._tag = tag;
        addPropertiesError.pathValue = lookupError;
        return addPropertiesError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isTemplateNotFound() {
        return this._tag == Tag.TEMPLATE_NOT_FOUND;
    }

    public static AddPropertiesError templateNotFound(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        if (!Pattern.matches("(/|ptid:).*", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new AddPropertiesError().withTagAndTemplateNotFound(Tag.TEMPLATE_NOT_FOUND, str);
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

    public static AddPropertiesError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AddPropertiesError().withTagAndPath(Tag.PATH, lookupError);
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

    public boolean isPropertyGroupAlreadyExists() {
        return this._tag == Tag.PROPERTY_GROUP_ALREADY_EXISTS;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.templateNotFoundValue, this.pathValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AddPropertiesError)) {
            return false;
        }
        AddPropertiesError addPropertiesError = (AddPropertiesError) obj;
        if (this._tag != addPropertiesError._tag) {
            return false;
        }
        switch (C41161.f667x45088091[this._tag.ordinal()]) {
            case 1:
                String str = this.templateNotFoundValue;
                String str2 = addPropertiesError.templateNotFoundValue;
                return str == str2 || str.equals(str2);
            case 4:
                LookupError lookupError = this.pathValue;
                LookupError lookupError2 = addPropertiesError.pathValue;
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
            case 9:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.AddPropertiesError$1 */
    static /* synthetic */ class C41161 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$fileproperties$AddPropertiesError$Tag */
        static final /* synthetic */ int[] f667x45088091;

        static {
            int[] iArr = new int[Tag.values().length];
            f667x45088091 = iArr;
            try {
                iArr[Tag.TEMPLATE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f667x45088091[Tag.RESTRICTED_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f667x45088091[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f667x45088091[Tag.PATH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f667x45088091[Tag.UNSUPPORTED_FOLDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f667x45088091[Tag.PROPERTY_FIELD_TOO_LARGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f667x45088091[Tag.DOES_NOT_FIT_TEMPLATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f667x45088091[Tag.DUPLICATE_PROPERTY_GROUPS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f667x45088091[Tag.PROPERTY_GROUP_ALREADY_EXISTS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<AddPropertiesError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AddPropertiesError addPropertiesError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41161.f667x45088091[addPropertiesError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("template_not_found", jsonGenerator);
                    jsonGenerator.writeFieldName("template_not_found");
                    StoneSerializers.string().serialize(addPropertiesError.templateNotFoundValue, jsonGenerator);
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
                    LookupError.Serializer.INSTANCE.serialize(addPropertiesError.pathValue, jsonGenerator);
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
                case 9:
                    jsonGenerator.writeString("property_group_already_exists");
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + addPropertiesError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AddPropertiesError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AddPropertiesError addPropertiesErrorPath;
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
                addPropertiesErrorPath = AddPropertiesError.templateNotFound(StoneSerializers.string().deserialize(jsonParser));
            } else if ("restricted_content".equals(tag)) {
                addPropertiesErrorPath = AddPropertiesError.RESTRICTED_CONTENT;
            } else if ("other".equals(tag)) {
                addPropertiesErrorPath = AddPropertiesError.OTHER;
            } else if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                addPropertiesErrorPath = AddPropertiesError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("unsupported_folder".equals(tag)) {
                addPropertiesErrorPath = AddPropertiesError.UNSUPPORTED_FOLDER;
            } else if ("property_field_too_large".equals(tag)) {
                addPropertiesErrorPath = AddPropertiesError.PROPERTY_FIELD_TOO_LARGE;
            } else if ("does_not_fit_template".equals(tag)) {
                addPropertiesErrorPath = AddPropertiesError.DOES_NOT_FIT_TEMPLATE;
            } else if ("duplicate_property_groups".equals(tag)) {
                addPropertiesErrorPath = AddPropertiesError.DUPLICATE_PROPERTY_GROUPS;
            } else if ("property_group_already_exists".equals(tag)) {
                addPropertiesErrorPath = AddPropertiesError.PROPERTY_GROUP_ALREADY_EXISTS;
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return addPropertiesErrorPath;
        }
    }
}
