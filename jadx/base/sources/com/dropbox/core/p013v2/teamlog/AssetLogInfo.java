package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FileLogInfo;
import com.dropbox.core.p013v2.teamlog.FolderLogInfo;
import com.dropbox.core.p013v2.teamlog.PaperDocumentLogInfo;
import com.dropbox.core.p013v2.teamlog.PaperFolderLogInfo;
import com.dropbox.core.p013v2.teamlog.ShowcaseDocumentLogInfo;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class AssetLogInfo {
    public static final AssetLogInfo OTHER = new AssetLogInfo().withTag(Tag.OTHER);
    private Tag _tag;
    private FileLogInfo fileValue;
    private FolderLogInfo folderValue;
    private PaperDocumentLogInfo paperDocumentValue;
    private PaperFolderLogInfo paperFolderValue;
    private ShowcaseDocumentLogInfo showcaseDocumentValue;

    public enum Tag {
        FILE,
        FOLDER,
        PAPER_DOCUMENT,
        PAPER_FOLDER,
        SHOWCASE_DOCUMENT,
        OTHER
    }

    private AssetLogInfo() {
    }

    private AssetLogInfo withTag(Tag tag) {
        AssetLogInfo assetLogInfo = new AssetLogInfo();
        assetLogInfo._tag = tag;
        return assetLogInfo;
    }

    private AssetLogInfo withTagAndFile(Tag tag, FileLogInfo fileLogInfo) {
        AssetLogInfo assetLogInfo = new AssetLogInfo();
        assetLogInfo._tag = tag;
        assetLogInfo.fileValue = fileLogInfo;
        return assetLogInfo;
    }

    private AssetLogInfo withTagAndFolder(Tag tag, FolderLogInfo folderLogInfo) {
        AssetLogInfo assetLogInfo = new AssetLogInfo();
        assetLogInfo._tag = tag;
        assetLogInfo.folderValue = folderLogInfo;
        return assetLogInfo;
    }

    private AssetLogInfo withTagAndPaperDocument(Tag tag, PaperDocumentLogInfo paperDocumentLogInfo) {
        AssetLogInfo assetLogInfo = new AssetLogInfo();
        assetLogInfo._tag = tag;
        assetLogInfo.paperDocumentValue = paperDocumentLogInfo;
        return assetLogInfo;
    }

    private AssetLogInfo withTagAndPaperFolder(Tag tag, PaperFolderLogInfo paperFolderLogInfo) {
        AssetLogInfo assetLogInfo = new AssetLogInfo();
        assetLogInfo._tag = tag;
        assetLogInfo.paperFolderValue = paperFolderLogInfo;
        return assetLogInfo;
    }

    private AssetLogInfo withTagAndShowcaseDocument(Tag tag, ShowcaseDocumentLogInfo showcaseDocumentLogInfo) {
        AssetLogInfo assetLogInfo = new AssetLogInfo();
        assetLogInfo._tag = tag;
        assetLogInfo.showcaseDocumentValue = showcaseDocumentLogInfo;
        return assetLogInfo;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isFile() {
        return this._tag == Tag.FILE;
    }

    public static AssetLogInfo file(FileLogInfo fileLogInfo) {
        if (fileLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AssetLogInfo().withTagAndFile(Tag.FILE, fileLogInfo);
    }

    public FileLogInfo getFileValue() {
        if (this._tag != Tag.FILE) {
            throw new IllegalStateException("Invalid tag: required Tag.FILE, but was Tag." + this._tag.name());
        }
        return this.fileValue;
    }

    public boolean isFolder() {
        return this._tag == Tag.FOLDER;
    }

    public static AssetLogInfo folder(FolderLogInfo folderLogInfo) {
        if (folderLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AssetLogInfo().withTagAndFolder(Tag.FOLDER, folderLogInfo);
    }

    public FolderLogInfo getFolderValue() {
        if (this._tag != Tag.FOLDER) {
            throw new IllegalStateException("Invalid tag: required Tag.FOLDER, but was Tag." + this._tag.name());
        }
        return this.folderValue;
    }

    public boolean isPaperDocument() {
        return this._tag == Tag.PAPER_DOCUMENT;
    }

    public static AssetLogInfo paperDocument(PaperDocumentLogInfo paperDocumentLogInfo) {
        if (paperDocumentLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AssetLogInfo().withTagAndPaperDocument(Tag.PAPER_DOCUMENT, paperDocumentLogInfo);
    }

    public PaperDocumentLogInfo getPaperDocumentValue() {
        if (this._tag != Tag.PAPER_DOCUMENT) {
            throw new IllegalStateException("Invalid tag: required Tag.PAPER_DOCUMENT, but was Tag." + this._tag.name());
        }
        return this.paperDocumentValue;
    }

    public boolean isPaperFolder() {
        return this._tag == Tag.PAPER_FOLDER;
    }

    public static AssetLogInfo paperFolder(PaperFolderLogInfo paperFolderLogInfo) {
        if (paperFolderLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AssetLogInfo().withTagAndPaperFolder(Tag.PAPER_FOLDER, paperFolderLogInfo);
    }

    public PaperFolderLogInfo getPaperFolderValue() {
        if (this._tag != Tag.PAPER_FOLDER) {
            throw new IllegalStateException("Invalid tag: required Tag.PAPER_FOLDER, but was Tag." + this._tag.name());
        }
        return this.paperFolderValue;
    }

    public boolean isShowcaseDocument() {
        return this._tag == Tag.SHOWCASE_DOCUMENT;
    }

    public static AssetLogInfo showcaseDocument(ShowcaseDocumentLogInfo showcaseDocumentLogInfo) {
        if (showcaseDocumentLogInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AssetLogInfo().withTagAndShowcaseDocument(Tag.SHOWCASE_DOCUMENT, showcaseDocumentLogInfo);
    }

    public ShowcaseDocumentLogInfo getShowcaseDocumentValue() {
        if (this._tag != Tag.SHOWCASE_DOCUMENT) {
            throw new IllegalStateException("Invalid tag: required Tag.SHOWCASE_DOCUMENT, but was Tag." + this._tag.name());
        }
        return this.showcaseDocumentValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.fileValue, this.folderValue, this.paperDocumentValue, this.paperFolderValue, this.showcaseDocumentValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AssetLogInfo)) {
            return false;
        }
        AssetLogInfo assetLogInfo = (AssetLogInfo) obj;
        if (this._tag != assetLogInfo._tag) {
            return false;
        }
        switch (C44451.$SwitchMap$com$dropbox$core$v2$teamlog$AssetLogInfo$Tag[this._tag.ordinal()]) {
            case 1:
                FileLogInfo fileLogInfo = this.fileValue;
                FileLogInfo fileLogInfo2 = assetLogInfo.fileValue;
                return fileLogInfo == fileLogInfo2 || fileLogInfo.equals(fileLogInfo2);
            case 2:
                FolderLogInfo folderLogInfo = this.folderValue;
                FolderLogInfo folderLogInfo2 = assetLogInfo.folderValue;
                return folderLogInfo == folderLogInfo2 || folderLogInfo.equals(folderLogInfo2);
            case 3:
                PaperDocumentLogInfo paperDocumentLogInfo = this.paperDocumentValue;
                PaperDocumentLogInfo paperDocumentLogInfo2 = assetLogInfo.paperDocumentValue;
                return paperDocumentLogInfo == paperDocumentLogInfo2 || paperDocumentLogInfo.equals(paperDocumentLogInfo2);
            case 4:
                PaperFolderLogInfo paperFolderLogInfo = this.paperFolderValue;
                PaperFolderLogInfo paperFolderLogInfo2 = assetLogInfo.paperFolderValue;
                return paperFolderLogInfo == paperFolderLogInfo2 || paperFolderLogInfo.equals(paperFolderLogInfo2);
            case 5:
                ShowcaseDocumentLogInfo showcaseDocumentLogInfo = this.showcaseDocumentValue;
                ShowcaseDocumentLogInfo showcaseDocumentLogInfo2 = assetLogInfo.showcaseDocumentValue;
                return showcaseDocumentLogInfo == showcaseDocumentLogInfo2 || showcaseDocumentLogInfo.equals(showcaseDocumentLogInfo2);
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.AssetLogInfo$1 */
    static /* synthetic */ class C44451 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$AssetLogInfo$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$AssetLogInfo$Tag = iArr;
            try {
                iArr[Tag.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AssetLogInfo$Tag[Tag.FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AssetLogInfo$Tag[Tag.PAPER_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AssetLogInfo$Tag[Tag.PAPER_FOLDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AssetLogInfo$Tag[Tag.SHOWCASE_DOCUMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$AssetLogInfo$Tag[Tag.OTHER.ordinal()] = 6;
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

    static class Serializer extends UnionSerializer<AssetLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(AssetLogInfo assetLogInfo, JsonGenerator jsonGenerator) throws IOException {
            int i = C44451.$SwitchMap$com$dropbox$core$v2$teamlog$AssetLogInfo$Tag[assetLogInfo.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("file", jsonGenerator);
                FileLogInfo.Serializer.INSTANCE.serialize(assetLogInfo.fileValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("folder", jsonGenerator);
                FolderLogInfo.Serializer.INSTANCE.serialize(assetLogInfo.folderValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("paper_document", jsonGenerator);
                PaperDocumentLogInfo.Serializer.INSTANCE.serialize(assetLogInfo.paperDocumentValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 4) {
                jsonGenerator.writeStartObject();
                writeTag("paper_folder", jsonGenerator);
                PaperFolderLogInfo.Serializer.INSTANCE.serialize(assetLogInfo.paperFolderValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 5) {
                jsonGenerator.writeStartObject();
                writeTag("showcase_document", jsonGenerator);
                ShowcaseDocumentLogInfo.Serializer.INSTANCE.serialize(assetLogInfo.showcaseDocumentValue, jsonGenerator, true);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public AssetLogInfo deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            AssetLogInfo assetLogInfoShowcaseDocument;
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
            if ("file".equals(tag)) {
                assetLogInfoShowcaseDocument = AssetLogInfo.file(FileLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("folder".equals(tag)) {
                assetLogInfoShowcaseDocument = AssetLogInfo.folder(FolderLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("paper_document".equals(tag)) {
                assetLogInfoShowcaseDocument = AssetLogInfo.paperDocument(PaperDocumentLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("paper_folder".equals(tag)) {
                assetLogInfoShowcaseDocument = AssetLogInfo.paperFolder(PaperFolderLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else if ("showcase_document".equals(tag)) {
                assetLogInfoShowcaseDocument = AssetLogInfo.showcaseDocument(ShowcaseDocumentLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true));
            } else {
                assetLogInfoShowcaseDocument = AssetLogInfo.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return assetLogInfoShowcaseDocument;
        }
    }
}
