package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.fileproperties.TemplateFilterBase;
import com.dropbox.core.p013v2.files.GetMetadataArg;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class AlphaGetMetadataArg extends GetMetadataArg {

    @Nullable
    protected final List<String> includePropertyTemplates;

    public AlphaGetMetadataArg(@Nonnull String str, boolean z, boolean z2, boolean z3, @Nullable TemplateFilterBase templateFilterBase, @Nullable List<String> list) {
        super(str, z, z2, z3, templateFilterBase);
        if (list != null) {
            for (String str2 : list) {
                if (str2 == null) {
                    throw new IllegalArgumentException("An item in list 'includePropertyTemplates' is null");
                }
                if (str2.length() < 1) {
                    throw new IllegalArgumentException("Stringan item in list 'includePropertyTemplates' is shorter than 1");
                }
                if (!Pattern.matches("(/|ptid:).*", str2)) {
                    throw new IllegalArgumentException("Stringan item in list 'includePropertyTemplates' does not match pattern");
                }
            }
        }
        this.includePropertyTemplates = list;
    }

    public AlphaGetMetadataArg(@Nonnull String str) {
        this(str, false, false, false, null, null);
    }

    @Override // com.dropbox.core.p013v2.files.GetMetadataArg
    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Override // com.dropbox.core.p013v2.files.GetMetadataArg
    public boolean getIncludeMediaInfo() {
        return this.includeMediaInfo;
    }

    @Override // com.dropbox.core.p013v2.files.GetMetadataArg
    public boolean getIncludeDeleted() {
        return this.includeDeleted;
    }

    @Override // com.dropbox.core.p013v2.files.GetMetadataArg
    public boolean getIncludeHasExplicitSharedMembers() {
        return this.includeHasExplicitSharedMembers;
    }

    @Override // com.dropbox.core.p013v2.files.GetMetadataArg
    @Nullable
    public TemplateFilterBase getIncludePropertyGroups() {
        return this.includePropertyGroups;
    }

    @Nullable
    public List<String> getIncludePropertyTemplates() {
        return this.includePropertyTemplates;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder extends GetMetadataArg.Builder {
        protected List<String> includePropertyTemplates;

        protected Builder(String str) {
            super(str);
            this.includePropertyTemplates = null;
        }

        public Builder withIncludePropertyTemplates(List<String> list) {
            if (list != null) {
                for (String str : list) {
                    if (str == null) {
                        throw new IllegalArgumentException("An item in list 'includePropertyTemplates' is null");
                    }
                    if (str.length() < 1) {
                        throw new IllegalArgumentException("Stringan item in list 'includePropertyTemplates' is shorter than 1");
                    }
                    if (!Pattern.matches("(/|ptid:).*", str)) {
                        throw new IllegalArgumentException("Stringan item in list 'includePropertyTemplates' does not match pattern");
                    }
                }
            }
            this.includePropertyTemplates = list;
            return this;
        }

        @Override // com.dropbox.core.v2.files.GetMetadataArg.Builder
        public Builder withIncludeMediaInfo(Boolean bool) {
            super.withIncludeMediaInfo(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.files.GetMetadataArg.Builder
        public Builder withIncludeDeleted(Boolean bool) {
            super.withIncludeDeleted(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.files.GetMetadataArg.Builder
        public Builder withIncludeHasExplicitSharedMembers(Boolean bool) {
            super.withIncludeHasExplicitSharedMembers(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.files.GetMetadataArg.Builder
        public Builder withIncludePropertyGroups(TemplateFilterBase templateFilterBase) {
            super.withIncludePropertyGroups(templateFilterBase);
            return this;
        }

        @Override // com.dropbox.core.v2.files.GetMetadataArg.Builder
        public AlphaGetMetadataArg build() {
            return new AlphaGetMetadataArg(this.path, this.includeMediaInfo, this.includeDeleted, this.includeHasExplicitSharedMembers, this.includePropertyGroups, this.includePropertyTemplates);
        }
    }

    @Override // com.dropbox.core.p013v2.files.GetMetadataArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.includePropertyTemplates});
    }

    @Override // com.dropbox.core.p013v2.files.GetMetadataArg
    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            AlphaGetMetadataArg alphaGetMetadataArg = (AlphaGetMetadataArg) obj;
            if ((this.path == alphaGetMetadataArg.path || this.path.equals(alphaGetMetadataArg.path)) && this.includeMediaInfo == alphaGetMetadataArg.includeMediaInfo && this.includeDeleted == alphaGetMetadataArg.includeDeleted && this.includeHasExplicitSharedMembers == alphaGetMetadataArg.includeHasExplicitSharedMembers && ((this.includePropertyGroups == alphaGetMetadataArg.includePropertyGroups || (this.includePropertyGroups != null && this.includePropertyGroups.equals(alphaGetMetadataArg.includePropertyGroups))) && ((list = this.includePropertyTemplates) == (list2 = alphaGetMetadataArg.includePropertyTemplates) || (list != null && list.equals(list2))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.files.GetMetadataArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.files.GetMetadataArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AlphaGetMetadataArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AlphaGetMetadataArg alphaGetMetadataArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(alphaGetMetadataArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("include_media_info");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(alphaGetMetadataArg.includeMediaInfo), jsonGenerator);
            jsonGenerator.writeFieldName("include_deleted");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(alphaGetMetadataArg.includeDeleted), jsonGenerator);
            jsonGenerator.writeFieldName("include_has_explicit_shared_members");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(alphaGetMetadataArg.includeHasExplicitSharedMembers), jsonGenerator);
            if (alphaGetMetadataArg.includePropertyGroups != null) {
                jsonGenerator.writeFieldName("include_property_groups");
                StoneSerializers.nullable(TemplateFilterBase.Serializer.INSTANCE).serialize(alphaGetMetadataArg.includePropertyGroups, jsonGenerator);
            }
            if (alphaGetMetadataArg.includePropertyTemplates != null) {
                jsonGenerator.writeFieldName("include_property_templates");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(alphaGetMetadataArg.includePropertyTemplates, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AlphaGetMetadataArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                Boolean boolDeserialize2 = false;
                Boolean boolDeserialize3 = false;
                String strDeserialize = null;
                TemplateFilterBase templateFilterBase = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("include_media_info".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("include_deleted".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("include_has_explicit_shared_members".equals(currentName)) {
                        boolDeserialize3 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("include_property_groups".equals(currentName)) {
                        templateFilterBase = (TemplateFilterBase) StoneSerializers.nullable(TemplateFilterBase.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("include_property_templates".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                AlphaGetMetadataArg alphaGetMetadataArg = new AlphaGetMetadataArg(strDeserialize, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue(), boolDeserialize3.booleanValue(), templateFilterBase, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(alphaGetMetadataArg, alphaGetMetadataArg.toStringMultiline());
                return alphaGetMetadataArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
