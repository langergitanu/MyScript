package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.fileproperties.TemplateFilterBase;
import com.dropbox.core.p013v2.files.SharedLink;
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
class ListFolderArg {
    protected final boolean includeDeleted;
    protected final boolean includeHasExplicitSharedMembers;
    protected final boolean includeMediaInfo;
    protected final boolean includeMountedFolders;
    protected final boolean includeNonDownloadableFiles;

    @Nullable
    protected final TemplateFilterBase includePropertyGroups;

    @Nullable
    protected final Long limit;

    @Nonnull
    protected final String path;
    protected final boolean recursive;

    @Nullable
    protected final SharedLink sharedLink;

    public ListFolderArg(@Nonnull String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, @Nullable Long l, @Nullable SharedLink sharedLink, @Nullable TemplateFilterBase templateFilterBase, boolean z6) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        this.recursive = z;
        this.includeMediaInfo = z2;
        this.includeDeleted = z3;
        this.includeHasExplicitSharedMembers = z4;
        this.includeMountedFolders = z5;
        if (l != null) {
            if (l.longValue() < 1) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
            }
            if (l.longValue() > 2000) {
                throw new IllegalArgumentException("Number 'limit' is larger than 2000L");
            }
        }
        this.limit = l;
        this.sharedLink = sharedLink;
        this.includePropertyGroups = templateFilterBase;
        this.includeNonDownloadableFiles = z6;
    }

    public ListFolderArg(@Nonnull String str) {
        this(str, false, false, false, false, true, null, null, null, true);
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    public boolean getRecursive() {
        return this.recursive;
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

    public boolean getIncludeMountedFolders() {
        return this.includeMountedFolders;
    }

    @Nullable
    public Long getLimit() {
        return this.limit;
    }

    @Nullable
    public SharedLink getSharedLink() {
        return this.sharedLink;
    }

    @Nullable
    public TemplateFilterBase getIncludePropertyGroups() {
        return this.includePropertyGroups;
    }

    public boolean getIncludeNonDownloadableFiles() {
        return this.includeNonDownloadableFiles;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected boolean includeDeleted;
        protected boolean includeHasExplicitSharedMembers;
        protected boolean includeMediaInfo;
        protected boolean includeMountedFolders;
        protected boolean includeNonDownloadableFiles;
        protected TemplateFilterBase includePropertyGroups;
        protected Long limit;
        protected final String path;
        protected boolean recursive;
        protected SharedLink sharedLink;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", str)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = str;
            this.recursive = false;
            this.includeMediaInfo = false;
            this.includeDeleted = false;
            this.includeHasExplicitSharedMembers = false;
            this.includeMountedFolders = true;
            this.limit = null;
            this.sharedLink = null;
            this.includePropertyGroups = null;
            this.includeNonDownloadableFiles = true;
        }

        public Builder withRecursive(Boolean bool) {
            if (bool != null) {
                this.recursive = bool.booleanValue();
                return this;
            }
            this.recursive = false;
            return this;
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

        public Builder withIncludeMountedFolders(Boolean bool) {
            if (bool != null) {
                this.includeMountedFolders = bool.booleanValue();
                return this;
            }
            this.includeMountedFolders = true;
            return this;
        }

        public Builder withLimit(Long l) {
            if (l != null) {
                if (l.longValue() < 1) {
                    throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
                }
                if (l.longValue() > 2000) {
                    throw new IllegalArgumentException("Number 'limit' is larger than 2000L");
                }
            }
            this.limit = l;
            return this;
        }

        public Builder withSharedLink(SharedLink sharedLink) {
            this.sharedLink = sharedLink;
            return this;
        }

        public Builder withIncludePropertyGroups(TemplateFilterBase templateFilterBase) {
            this.includePropertyGroups = templateFilterBase;
            return this;
        }

        public Builder withIncludeNonDownloadableFiles(Boolean bool) {
            if (bool != null) {
                this.includeNonDownloadableFiles = bool.booleanValue();
                return this;
            }
            this.includeNonDownloadableFiles = true;
            return this;
        }

        public ListFolderArg build() {
            return new ListFolderArg(this.path, this.recursive, this.includeMediaInfo, this.includeDeleted, this.includeHasExplicitSharedMembers, this.includeMountedFolders, this.limit, this.sharedLink, this.includePropertyGroups, this.includeNonDownloadableFiles);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, Boolean.valueOf(this.recursive), Boolean.valueOf(this.includeMediaInfo), Boolean.valueOf(this.includeDeleted), Boolean.valueOf(this.includeHasExplicitSharedMembers), Boolean.valueOf(this.includeMountedFolders), this.limit, this.sharedLink, this.includePropertyGroups, Boolean.valueOf(this.includeNonDownloadableFiles)});
    }

    public boolean equals(Object obj) {
        ListFolderArg listFolderArg;
        String str;
        String str2;
        Long l;
        Long l2;
        SharedLink sharedLink;
        SharedLink sharedLink2;
        TemplateFilterBase templateFilterBase;
        TemplateFilterBase templateFilterBase2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.path) == (str2 = (listFolderArg = (ListFolderArg) obj).path) || str.equals(str2)) && this.recursive == listFolderArg.recursive && this.includeMediaInfo == listFolderArg.includeMediaInfo && this.includeDeleted == listFolderArg.includeDeleted && this.includeHasExplicitSharedMembers == listFolderArg.includeHasExplicitSharedMembers && this.includeMountedFolders == listFolderArg.includeMountedFolders && (((l = this.limit) == (l2 = listFolderArg.limit) || (l != null && l.equals(l2))) && (((sharedLink = this.sharedLink) == (sharedLink2 = listFolderArg.sharedLink) || (sharedLink != null && sharedLink.equals(sharedLink2))) && (((templateFilterBase = this.includePropertyGroups) == (templateFilterBase2 = listFolderArg.includePropertyGroups) || (templateFilterBase != null && templateFilterBase.equals(templateFilterBase2))) && this.includeNonDownloadableFiles == listFolderArg.includeNonDownloadableFiles)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListFolderArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListFolderArg listFolderArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(listFolderArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("recursive");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listFolderArg.recursive), jsonGenerator);
            jsonGenerator.writeFieldName("include_media_info");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listFolderArg.includeMediaInfo), jsonGenerator);
            jsonGenerator.writeFieldName("include_deleted");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listFolderArg.includeDeleted), jsonGenerator);
            jsonGenerator.writeFieldName("include_has_explicit_shared_members");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listFolderArg.includeHasExplicitSharedMembers), jsonGenerator);
            jsonGenerator.writeFieldName("include_mounted_folders");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listFolderArg.includeMountedFolders), jsonGenerator);
            if (listFolderArg.limit != null) {
                jsonGenerator.writeFieldName("limit");
                StoneSerializers.nullable(StoneSerializers.uInt32()).serialize(listFolderArg.limit, jsonGenerator);
            }
            if (listFolderArg.sharedLink != null) {
                jsonGenerator.writeFieldName("shared_link");
                StoneSerializers.nullableStruct(SharedLink.Serializer.INSTANCE).serialize(listFolderArg.sharedLink, jsonGenerator);
            }
            if (listFolderArg.includePropertyGroups != null) {
                jsonGenerator.writeFieldName("include_property_groups");
                StoneSerializers.nullable(TemplateFilterBase.Serializer.INSTANCE).serialize(listFolderArg.includePropertyGroups, jsonGenerator);
            }
            jsonGenerator.writeFieldName("include_non_downloadable_files");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(listFolderArg.includeNonDownloadableFiles), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListFolderArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                Boolean boolDeserialize4 = false;
                Boolean boolDeserialize5 = true;
                Boolean boolDeserialize6 = true;
                String strDeserialize = null;
                Long l = null;
                SharedLink sharedLink = null;
                TemplateFilterBase templateFilterBase = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("recursive".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("include_media_info".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("include_deleted".equals(currentName)) {
                        boolDeserialize3 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("include_has_explicit_shared_members".equals(currentName)) {
                        boolDeserialize4 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("include_mounted_folders".equals(currentName)) {
                        boolDeserialize5 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("limit".equals(currentName)) {
                        l = (Long) StoneSerializers.nullable(StoneSerializers.uInt32()).deserialize(jsonParser);
                    } else if ("shared_link".equals(currentName)) {
                        sharedLink = (SharedLink) StoneSerializers.nullableStruct(SharedLink.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("include_property_groups".equals(currentName)) {
                        templateFilterBase = (TemplateFilterBase) StoneSerializers.nullable(TemplateFilterBase.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("include_non_downloadable_files".equals(currentName)) {
                        boolDeserialize6 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                ListFolderArg listFolderArg = new ListFolderArg(strDeserialize, boolDeserialize.booleanValue(), boolDeserialize2.booleanValue(), boolDeserialize3.booleanValue(), boolDeserialize4.booleanValue(), boolDeserialize5.booleanValue(), l, sharedLink, templateFilterBase, boolDeserialize6.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listFolderArg, listFolderArg.toStringMultiline());
                return listFolderArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
