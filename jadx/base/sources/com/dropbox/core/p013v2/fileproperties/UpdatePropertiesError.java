package com.dropbox.core.p013v2.fileproperties;

import com.dropbox.core.p013v2.fileproperties.LookUpPropertiesError;
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
public final class UpdatePropertiesError {
    private Tag _tag;
    private LookupError pathValue;
    private LookUpPropertiesError propertyGroupLookupValue;
    private String templateNotFoundValue;
    public static final UpdatePropertiesError RESTRICTED_CONTENT = new UpdatePropertiesError().withTag(Tag.RESTRICTED_CONTENT);
    public static final UpdatePropertiesError OTHER = new UpdatePropertiesError().withTag(Tag.OTHER);
    public static final UpdatePropertiesError UNSUPPORTED_FOLDER = new UpdatePropertiesError().withTag(Tag.UNSUPPORTED_FOLDER);
    public static final UpdatePropertiesError PROPERTY_FIELD_TOO_LARGE = new UpdatePropertiesError().withTag(Tag.PROPERTY_FIELD_TOO_LARGE);
    public static final UpdatePropertiesError DOES_NOT_FIT_TEMPLATE = new UpdatePropertiesError().withTag(Tag.DOES_NOT_FIT_TEMPLATE);
    public static final UpdatePropertiesError DUPLICATE_PROPERTY_GROUPS = new UpdatePropertiesError().withTag(Tag.DUPLICATE_PROPERTY_GROUPS);

    public enum Tag {
        TEMPLATE_NOT_FOUND,
        RESTRICTED_CONTENT,
        OTHER,
        PATH,
        UNSUPPORTED_FOLDER,
        PROPERTY_FIELD_TOO_LARGE,
        DOES_NOT_FIT_TEMPLATE,
        DUPLICATE_PROPERTY_GROUPS,
        PROPERTY_GROUP_LOOKUP
    }

    private UpdatePropertiesError() {
    }

    private UpdatePropertiesError withTag(Tag tag) {
        UpdatePropertiesError updatePropertiesError = new UpdatePropertiesError();
        updatePropertiesError._tag = tag;
        return updatePropertiesError;
    }

    private UpdatePropertiesError withTagAndTemplateNotFound(Tag tag, String str) {
        UpdatePropertiesError updatePropertiesError = new UpdatePropertiesError();
        updatePropertiesError._tag = tag;
        updatePropertiesError.templateNotFoundValue = str;
        return updatePropertiesError;
    }

    private UpdatePropertiesError withTagAndPath(Tag tag, LookupError lookupError) {
        UpdatePropertiesError updatePropertiesError = new UpdatePropertiesError();
        updatePropertiesError._tag = tag;
        updatePropertiesError.pathValue = lookupError;
        return updatePropertiesError;
    }

    private UpdatePropertiesError withTagAndPropertyGroupLookup(Tag tag, LookUpPropertiesError lookUpPropertiesError) {
        UpdatePropertiesError updatePropertiesError = new UpdatePropertiesError();
        updatePropertiesError._tag = tag;
        updatePropertiesError.propertyGroupLookupValue = lookUpPropertiesError;
        return updatePropertiesError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isTemplateNotFound() {
        return this._tag == Tag.TEMPLATE_NOT_FOUND;
    }

    public static UpdatePropertiesError templateNotFound(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        if (!Pattern.matches("(/|ptid:).*", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new UpdatePropertiesError().withTagAndTemplateNotFound(Tag.TEMPLATE_NOT_FOUND, str);
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

    public static UpdatePropertiesError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdatePropertiesError().withTagAndPath(Tag.PATH, lookupError);
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

    public boolean isPropertyGroupLookup() {
        return this._tag == Tag.PROPERTY_GROUP_LOOKUP;
    }

    public static UpdatePropertiesError propertyGroupLookup(LookUpPropertiesError lookUpPropertiesError) {
        if (lookUpPropertiesError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdatePropertiesError().withTagAndPropertyGroupLookup(Tag.PROPERTY_GROUP_LOOKUP, lookUpPropertiesError);
    }

    public LookUpPropertiesError getPropertyGroupLookupValue() {
        if (this._tag != Tag.PROPERTY_GROUP_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.PROPERTY_GROUP_LOOKUP, but was Tag." + this._tag.name());
        }
        return this.propertyGroupLookupValue;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this._tag, this.templateNotFoundValue, this.pathValue, this.propertyGroupLookupValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdatePropertiesError)) {
            return false;
        }
        UpdatePropertiesError updatePropertiesError = (UpdatePropertiesError) obj;
        if (this._tag != updatePropertiesError._tag) {
            return false;
        }
        switch (C41301.f677xd8ab8dfb[this._tag.ordinal()]) {
            case 1:
                String str = this.templateNotFoundValue;
                String str2 = updatePropertiesError.templateNotFoundValue;
                return str == str2 || str.equals(str2);
            case 4:
                LookupError lookupError = this.pathValue;
                LookupError lookupError2 = updatePropertiesError.pathValue;
                if (lookupError != lookupError2 && !lookupError.equals(lookupError2)) {
                    return false;
                }
            case 2:
            case 3:
                return true;
            case 9:
                LookUpPropertiesError lookUpPropertiesError = this.propertyGroupLookupValue;
                LookUpPropertiesError lookUpPropertiesError2 = updatePropertiesError.propertyGroupLookupValue;
                if (lookUpPropertiesError != lookUpPropertiesError2 && !lookUpPropertiesError.equals(lookUpPropertiesError2)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.UpdatePropertiesError$1 */
    static /* synthetic */ class C41301 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$fileproperties$UpdatePropertiesError$Tag */
        static final /* synthetic */ int[] f677xd8ab8dfb;

        static {
            int[] iArr = new int[Tag.values().length];
            f677xd8ab8dfb = iArr;
            try {
                iArr[Tag.TEMPLATE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f677xd8ab8dfb[Tag.RESTRICTED_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f677xd8ab8dfb[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f677xd8ab8dfb[Tag.PATH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f677xd8ab8dfb[Tag.UNSUPPORTED_FOLDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f677xd8ab8dfb[Tag.PROPERTY_FIELD_TOO_LARGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f677xd8ab8dfb[Tag.DOES_NOT_FIT_TEMPLATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f677xd8ab8dfb[Tag.DUPLICATE_PROPERTY_GROUPS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f677xd8ab8dfb[Tag.PROPERTY_GROUP_LOOKUP.ordinal()] = 9;
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

    public static class Serializer extends UnionSerializer<UpdatePropertiesError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UpdatePropertiesError updatePropertiesError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41301.f677xd8ab8dfb[updatePropertiesError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("template_not_found", jsonGenerator);
                    jsonGenerator.writeFieldName("template_not_found");
                    StoneSerializers.string().serialize(updatePropertiesError.templateNotFoundValue, jsonGenerator);
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
                    LookupError.Serializer.INSTANCE.serialize(updatePropertiesError.pathValue, jsonGenerator);
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
                    jsonGenerator.writeStartObject();
                    writeTag("property_group_lookup", jsonGenerator);
                    jsonGenerator.writeFieldName("property_group_lookup");
                    LookUpPropertiesError.Serializer.INSTANCE.serialize(updatePropertiesError.propertyGroupLookupValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + updatePropertiesError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UpdatePropertiesError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UpdatePropertiesError updatePropertiesErrorPropertyGroupLookup;
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
                updatePropertiesErrorPropertyGroupLookup = UpdatePropertiesError.templateNotFound(StoneSerializers.string().deserialize(jsonParser));
            } else if ("restricted_content".equals(tag)) {
                updatePropertiesErrorPropertyGroupLookup = UpdatePropertiesError.RESTRICTED_CONTENT;
            } else if ("other".equals(tag)) {
                updatePropertiesErrorPropertyGroupLookup = UpdatePropertiesError.OTHER;
            } else if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                updatePropertiesErrorPropertyGroupLookup = UpdatePropertiesError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("unsupported_folder".equals(tag)) {
                updatePropertiesErrorPropertyGroupLookup = UpdatePropertiesError.UNSUPPORTED_FOLDER;
            } else if ("property_field_too_large".equals(tag)) {
                updatePropertiesErrorPropertyGroupLookup = UpdatePropertiesError.PROPERTY_FIELD_TOO_LARGE;
            } else if ("does_not_fit_template".equals(tag)) {
                updatePropertiesErrorPropertyGroupLookup = UpdatePropertiesError.DOES_NOT_FIT_TEMPLATE;
            } else if ("duplicate_property_groups".equals(tag)) {
                updatePropertiesErrorPropertyGroupLookup = UpdatePropertiesError.DUPLICATE_PROPERTY_GROUPS;
            } else if ("property_group_lookup".equals(tag)) {
                expectField("property_group_lookup", jsonParser);
                updatePropertiesErrorPropertyGroupLookup = UpdatePropertiesError.propertyGroupLookup(LookUpPropertiesError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return updatePropertiesErrorPropertyGroupLookup;
        }
    }
}
