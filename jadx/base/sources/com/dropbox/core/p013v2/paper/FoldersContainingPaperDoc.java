package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.Folder;
import com.dropbox.core.p013v2.paper.FolderSharingPolicyType;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class FoldersContainingPaperDoc {

    @Nullable
    protected final FolderSharingPolicyType folderSharingPolicyType;

    @Nullable
    protected final List<Folder> folders;

    public FoldersContainingPaperDoc(@Nullable FolderSharingPolicyType folderSharingPolicyType, @Nullable List<Folder> list) {
        this.folderSharingPolicyType = folderSharingPolicyType;
        if (list != null) {
            Iterator<Folder> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'folders' is null");
                }
            }
        }
        this.folders = list;
    }

    public FoldersContainingPaperDoc() {
        this(null, null);
    }

    @Nullable
    public FolderSharingPolicyType getFolderSharingPolicyType() {
        return this.folderSharingPolicyType;
    }

    @Nullable
    public List<Folder> getFolders() {
        return this.folders;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected FolderSharingPolicyType folderSharingPolicyType = null;
        protected List<Folder> folders = null;

        protected Builder() {
        }

        public Builder withFolderSharingPolicyType(FolderSharingPolicyType folderSharingPolicyType) {
            this.folderSharingPolicyType = folderSharingPolicyType;
            return this;
        }

        public Builder withFolders(List<Folder> list) {
            if (list != null) {
                Iterator<Folder> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'folders' is null");
                    }
                }
            }
            this.folders = list;
            return this;
        }

        public FoldersContainingPaperDoc build() {
            return new FoldersContainingPaperDoc(this.folderSharingPolicyType, this.folders);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.folderSharingPolicyType, this.folders});
    }

    public boolean equals(Object obj) {
        List<Folder> list;
        List<Folder> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FoldersContainingPaperDoc foldersContainingPaperDoc = (FoldersContainingPaperDoc) obj;
        FolderSharingPolicyType folderSharingPolicyType = this.folderSharingPolicyType;
        FolderSharingPolicyType folderSharingPolicyType2 = foldersContainingPaperDoc.folderSharingPolicyType;
        return (folderSharingPolicyType == folderSharingPolicyType2 || (folderSharingPolicyType != null && folderSharingPolicyType.equals(folderSharingPolicyType2))) && ((list = this.folders) == (list2 = foldersContainingPaperDoc.folders) || (list != null && list.equals(list2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FoldersContainingPaperDoc> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FoldersContainingPaperDoc foldersContainingPaperDoc, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (foldersContainingPaperDoc.folderSharingPolicyType != null) {
                jsonGenerator.writeFieldName("folder_sharing_policy_type");
                StoneSerializers.nullable(FolderSharingPolicyType.Serializer.INSTANCE).serialize(foldersContainingPaperDoc.folderSharingPolicyType, jsonGenerator);
            }
            if (foldersContainingPaperDoc.folders != null) {
                jsonGenerator.writeFieldName("folders");
                StoneSerializers.nullable(StoneSerializers.list(Folder.Serializer.INSTANCE)).serialize(foldersContainingPaperDoc.folders, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FoldersContainingPaperDoc deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FolderSharingPolicyType folderSharingPolicyType = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("folder_sharing_policy_type".equals(currentName)) {
                        folderSharingPolicyType = (FolderSharingPolicyType) StoneSerializers.nullable(FolderSharingPolicyType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("folders".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(Folder.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                FoldersContainingPaperDoc foldersContainingPaperDoc = new FoldersContainingPaperDoc(folderSharingPolicyType, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(foldersContainingPaperDoc, foldersContainingPaperDoc.toStringMultiline());
                return foldersContainingPaperDoc;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
