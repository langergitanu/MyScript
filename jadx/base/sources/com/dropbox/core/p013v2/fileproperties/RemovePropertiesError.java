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
public final class RemovePropertiesError {
    private Tag _tag;
    private LookupError pathValue;
    private LookUpPropertiesError propertyGroupLookupValue;
    private String templateNotFoundValue;
    public static final RemovePropertiesError RESTRICTED_CONTENT = new RemovePropertiesError().withTag(Tag.RESTRICTED_CONTENT);
    public static final RemovePropertiesError OTHER = new RemovePropertiesError().withTag(Tag.OTHER);
    public static final RemovePropertiesError UNSUPPORTED_FOLDER = new RemovePropertiesError().withTag(Tag.UNSUPPORTED_FOLDER);

    public enum Tag {
        TEMPLATE_NOT_FOUND,
        RESTRICTED_CONTENT,
        OTHER,
        PATH,
        UNSUPPORTED_FOLDER,
        PROPERTY_GROUP_LOOKUP
    }

    private RemovePropertiesError() {
    }

    private RemovePropertiesError withTag(Tag tag) {
        RemovePropertiesError removePropertiesError = new RemovePropertiesError();
        removePropertiesError._tag = tag;
        return removePropertiesError;
    }

    private RemovePropertiesError withTagAndTemplateNotFound(Tag tag, String str) {
        RemovePropertiesError removePropertiesError = new RemovePropertiesError();
        removePropertiesError._tag = tag;
        removePropertiesError.templateNotFoundValue = str;
        return removePropertiesError;
    }

    private RemovePropertiesError withTagAndPath(Tag tag, LookupError lookupError) {
        RemovePropertiesError removePropertiesError = new RemovePropertiesError();
        removePropertiesError._tag = tag;
        removePropertiesError.pathValue = lookupError;
        return removePropertiesError;
    }

    private RemovePropertiesError withTagAndPropertyGroupLookup(Tag tag, LookUpPropertiesError lookUpPropertiesError) {
        RemovePropertiesError removePropertiesError = new RemovePropertiesError();
        removePropertiesError._tag = tag;
        removePropertiesError.propertyGroupLookupValue = lookUpPropertiesError;
        return removePropertiesError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isTemplateNotFound() {
        return this._tag == Tag.TEMPLATE_NOT_FOUND;
    }

    public static RemovePropertiesError templateNotFound(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        if (!Pattern.matches("(/|ptid:).*", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new RemovePropertiesError().withTagAndTemplateNotFound(Tag.TEMPLATE_NOT_FOUND, str);
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

    public static RemovePropertiesError path(LookupError lookupError) {
        if (lookupError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemovePropertiesError().withTagAndPath(Tag.PATH, lookupError);
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

    public boolean isPropertyGroupLookup() {
        return this._tag == Tag.PROPERTY_GROUP_LOOKUP;
    }

    public static RemovePropertiesError propertyGroupLookup(LookUpPropertiesError lookUpPropertiesError) {
        if (lookUpPropertiesError == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemovePropertiesError().withTagAndPropertyGroupLookup(Tag.PROPERTY_GROUP_LOOKUP, lookUpPropertiesError);
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
        if (obj == null || !(obj instanceof RemovePropertiesError)) {
            return false;
        }
        RemovePropertiesError removePropertiesError = (RemovePropertiesError) obj;
        if (this._tag != removePropertiesError._tag) {
            return false;
        }
        switch (C41261.f675x884a0660[this._tag.ordinal()]) {
            case 1:
                String str = this.templateNotFoundValue;
                String str2 = removePropertiesError.templateNotFoundValue;
                return str == str2 || str.equals(str2);
            case 4:
                LookupError lookupError = this.pathValue;
                LookupError lookupError2 = removePropertiesError.pathValue;
                if (lookupError != lookupError2 && !lookupError.equals(lookupError2)) {
                    return false;
                }
            case 2:
            case 3:
                return true;
            case 6:
                LookUpPropertiesError lookUpPropertiesError = this.propertyGroupLookupValue;
                LookUpPropertiesError lookUpPropertiesError2 = removePropertiesError.propertyGroupLookupValue;
                if (lookUpPropertiesError != lookUpPropertiesError2 && !lookUpPropertiesError.equals(lookUpPropertiesError2)) {
                    return false;
                }
            case 5:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.fileproperties.RemovePropertiesError$1 */
    static /* synthetic */ class C41261 {

        /* JADX INFO: renamed from: $SwitchMap$com$dropbox$core$v2$fileproperties$RemovePropertiesError$Tag */
        static final /* synthetic */ int[] f675x884a0660;

        static {
            int[] iArr = new int[Tag.values().length];
            f675x884a0660 = iArr;
            try {
                iArr[Tag.TEMPLATE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f675x884a0660[Tag.RESTRICTED_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f675x884a0660[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f675x884a0660[Tag.PATH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f675x884a0660[Tag.UNSUPPORTED_FOLDER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f675x884a0660[Tag.PROPERTY_GROUP_LOOKUP.ordinal()] = 6;
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

    public static class Serializer extends UnionSerializer<RemovePropertiesError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(RemovePropertiesError removePropertiesError, JsonGenerator jsonGenerator) throws IOException {
            switch (C41261.f675x884a0660[removePropertiesError.tag().ordinal()]) {
                case 1:
                    jsonGenerator.writeStartObject();
                    writeTag("template_not_found", jsonGenerator);
                    jsonGenerator.writeFieldName("template_not_found");
                    StoneSerializers.string().serialize(removePropertiesError.templateNotFoundValue, jsonGenerator);
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
                    LookupError.Serializer.INSTANCE.serialize(removePropertiesError.pathValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                case 5:
                    jsonGenerator.writeString("unsupported_folder");
                    return;
                case 6:
                    jsonGenerator.writeStartObject();
                    writeTag("property_group_lookup", jsonGenerator);
                    jsonGenerator.writeFieldName("property_group_lookup");
                    LookUpPropertiesError.Serializer.INSTANCE.serialize(removePropertiesError.propertyGroupLookupValue, jsonGenerator);
                    jsonGenerator.writeEndObject();
                    return;
                default:
                    throw new IllegalArgumentException("Unrecognized tag: " + removePropertiesError.tag());
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public RemovePropertiesError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            RemovePropertiesError removePropertiesErrorPropertyGroupLookup;
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
                removePropertiesErrorPropertyGroupLookup = RemovePropertiesError.templateNotFound(StoneSerializers.string().deserialize(jsonParser));
            } else if ("restricted_content".equals(tag)) {
                removePropertiesErrorPropertyGroupLookup = RemovePropertiesError.RESTRICTED_CONTENT;
            } else if ("other".equals(tag)) {
                removePropertiesErrorPropertyGroupLookup = RemovePropertiesError.OTHER;
            } else if (ClientCookie.PATH_ATTR.equals(tag)) {
                expectField(ClientCookie.PATH_ATTR, jsonParser);
                removePropertiesErrorPropertyGroupLookup = RemovePropertiesError.path(LookupError.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("unsupported_folder".equals(tag)) {
                removePropertiesErrorPropertyGroupLookup = RemovePropertiesError.UNSUPPORTED_FOLDER;
            } else if ("property_group_lookup".equals(tag)) {
                expectField("property_group_lookup", jsonParser);
                removePropertiesErrorPropertyGroupLookup = RemovePropertiesError.propertyGroupLookup(LookUpPropertiesError.Serializer.INSTANCE.deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return removePropertiesErrorPropertyGroupLookup;
        }
    }
}
