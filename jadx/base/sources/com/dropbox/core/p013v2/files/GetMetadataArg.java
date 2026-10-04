package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.fileproperties.TemplateFilterBase;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class GetMetadataArg {
    protected final boolean includeDeleted;
    protected final boolean includeHasExplicitSharedMembers;
    protected final boolean includeMediaInfo;

    @Nullable
    protected final TemplateFilterBase includePropertyGroups;

    @Nonnull
    protected final String path;

    public GetMetadataArg(@Nonnull String str, boolean z, boolean z2, boolean z3, @Nullable TemplateFilterBase templateFilterBase) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        this.includeMediaInfo = z;
        this.includeDeleted = z2;
        this.includeHasExplicitSharedMembers = z3;
        this.includePropertyGroups = templateFilterBase;
    }

    public GetMetadataArg(@Nonnull String str) {
        this(str, false, false, false, null);
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    public boolean getIncludeMediaInfo() {
        return this.includeMediaInfo;
    }

    public boolean getIncludeDeleted() {
        return this.includeDeleted;
    }

    public boolean getIncludeHasExplicitSharedMembers() {
        return this.includeHasExplicitSharedMembers;
    }

    @Nullable
    public TemplateFilterBase getIncludePropertyGroups() {
        return this.includePropertyGroups;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected boolean includeDeleted;
        protected boolean includeHasExplicitSharedMembers;
        protected boolean includeMediaInfo;
        protected TemplateFilterBase includePropertyGroups;
        protected final String path;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", str)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = str;
            this.includeMediaInfo = false;
            this.includeDeleted = false;
            this.includeHasExplicitSharedMembers = false;
            this.includePropertyGroups = null;
        }

        public Builder withIncludeMediaInfo(Boolean bool) {
            if (bool != null) {
                this.includeMediaInfo = bool.booleanValue();
                return this;
            }
            this.includeMediaInfo = false;
            return this;
        }

        public Builder withIncludeDeleted(Boolean bool) {
            if (bool != null) {
                this.includeDeleted = bool.booleanValue();
                return this;
            }
            this.includeDeleted = false;
            return this;
        }

        public Builder withIncludeHasExplicitSharedMembers(Boolean bool) {
            if (bool != null) {
                this.includeHasExplicitSharedMembers = bool.booleanValue();
                return this;
            }
            this.includeHasExplicitSharedMembers = false;
            return this;
        }

        public Builder withIncludePropertyGroups(TemplateFilterBase templateFilterBase) {
            this.includePropertyGroups = templateFilterBase;
            return this;
        }

        public GetMetadataArg build() {
            return new GetMetadataArg(this.path, this.includeMediaInfo, this.includeDeleted, this.includeHasExplicitSharedMembers, this.includePropertyGroups);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, Boolean.valueOf(this.includeMediaInfo), Boolean.valueOf(this.includeDeleted), Boolean.valueOf(this.includeHasExplicitSharedMembers), this.includePropertyGroups});
    }

    public boolean equals(Object obj) {
        GetMetadataArg getMetadataArg;
        String str;
        String str2;
        TemplateFilterBase templateFilterBase;
        TemplateFilterBase templateFilterBase2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.path) == (str2 = (getMetadataArg = (GetMetadataArg) obj).path) || str.equals(str2)) && this.includeMediaInfo == getMetadataArg.includeMediaInfo && this.includeDeleted == getMetadataArg.includeDeleted && this.includeHasExplicitSharedMembers == getMetadataArg.includeHasExplicitSharedMembers && ((templateFilterBase = this.includePropertyGroups) == (templateFilterBase2 = getMetadataArg.includePropertyGroups) || (templateFilterBase != null && templateFilterBase.equals(templateFilterBase2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetMetadataArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetMetadataArg getMetadataArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(getMetadataArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("include_media_info");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(getMetadataArg.includeMediaInfo), jsonGenerator);
            jsonGenerator.writeFieldName("include_deleted");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(getMetadataArg.includeDeleted), jsonGenerator);
            jsonGenerator.writeFieldName("include_has_explicit_shared_members");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(getMetadataArg.includeHasExplicitSharedMembers), jsonGenerator);
            if (getMetadataArg.includePropertyGroups != null) {
                jsonGenerator.writeFieldName("include_property_groups");
                StoneSerializers.nullable(TemplateFilterBase.Serializer.INSTANCE).serialize(getMetadataArg.includePropertyGroups, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetMetadataArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                GetMetadataArg getMetadataArg = new GetMetadataArg(strDeserialize, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue(), boolDeserialize3.booleanValue(), templateFilterBase);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getMetadataArg, getMetadataArg.toStringMultiline());
                return getMetadataArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
