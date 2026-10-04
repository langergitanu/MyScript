package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.MemberPermission;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class ParentFolderAccessInfo {

    @Nonnull
    protected final String folderName;

    @Nonnull
    protected final String path;

    @Nonnull
    protected final List<MemberPermission> permissions;

    @Nonnull
    protected final String sharedFolderId;

    public ParentFolderAccessInfo(@Nonnull String str, @Nonnull String str2, @Nonnull List<MemberPermission> list, @Nonnull String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'folderName' is null");
        }
        this.folderName = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str2)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = str2;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'permissions' is null");
        }
        Iterator<MemberPermission> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'permissions' is null");
            }
        }
        this.permissions = list;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        this.path = str3;
    }

    @Nonnull
    public String getFolderName() {
        return this.folderName;
    }

    @Nonnull
    public String getSharedFolderId() {
        return this.sharedFolderId;
    }

    @Nonnull
    public List<MemberPermission> getPermissions() {
        return this.permissions;
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.folderName, this.sharedFolderId, this.permissions, this.path});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        List<MemberPermission> list;
        List<MemberPermission> list2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ParentFolderAccessInfo parentFolderAccessInfo = (ParentFolderAccessInfo) obj;
        String str5 = this.folderName;
        String str6 = parentFolderAccessInfo.folderName;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.sharedFolderId) == (str2 = parentFolderAccessInfo.sharedFolderId) || str.equals(str2)) && (((list = this.permissions) == (list2 = parentFolderAccessInfo.permissions) || list.equals(list2)) && ((str3 = this.path) == (str4 = parentFolderAccessInfo.path) || str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ParentFolderAccessInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ParentFolderAccessInfo parentFolderAccessInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("folder_name");
            StoneSerializers.string().serialize(parentFolderAccessInfo.folderName, jsonGenerator);
            jsonGenerator.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(parentFolderAccessInfo.sharedFolderId, jsonGenerator);
            jsonGenerator.writeFieldName("permissions");
            StoneSerializers.list(MemberPermission.Serializer.INSTANCE).serialize(parentFolderAccessInfo.permissions, jsonGenerator);
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(parentFolderAccessInfo.path, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ParentFolderAccessInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                List list = null;
                String strDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("folder_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("shared_folder_id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("permissions".equals(currentName)) {
                        list = (List) StoneSerializers.list(MemberPermission.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"folder_name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folder_id\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"permissions\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                ParentFolderAccessInfo parentFolderAccessInfo = new ParentFolderAccessInfo(strDeserialize, strDeserialize2, list, strDeserialize3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(parentFolderAccessInfo, parentFolderAccessInfo.toStringMultiline());
                return parentFolderAccessInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
