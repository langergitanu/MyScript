package com.dropbox.core.p013v2.files;

import androidx.media3.common.MimeTypes;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum FileCategory {
    IMAGE,
    DOCUMENT,
    PDF,
    SPREADSHEET,
    PRESENTATION,
    AUDIO,
    VIDEO,
    FOLDER,
    PAPER,
    OTHERS,
    OTHER;

    static class Serializer extends UnionSerializer<FileCategory> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(FileCategory fileCategory, JsonGenerator jsonGenerator) throws IOException {
            switch (C41581.$SwitchMap$com$dropbox$core$v2$files$FileCategory[fileCategory.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("image");
                    break;
                case 2:
                    jsonGenerator.writeString(AIQuizConstants.DOCUMENT);
                    break;
                case 3:
                    jsonGenerator.writeString(AIQuizConstants.PDF);
                    break;
                case 4:
                    jsonGenerator.writeString("spreadsheet");
                    break;
                case 5:
                    jsonGenerator.writeString("presentation");
                    break;
                case 6:
                    jsonGenerator.writeString(MimeTypes.BASE_TYPE_AUDIO);
                    break;
                case 7:
                    jsonGenerator.writeString(MimeTypes.BASE_TYPE_VIDEO);
                    break;
                case 8:
                    jsonGenerator.writeString("folder");
                    break;
                case 9:
                    jsonGenerator.writeString("paper");
                    break;
                case 10:
                    jsonGenerator.writeString("others");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public FileCategory deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            FileCategory fileCategory;
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
            if ("image".equals(tag)) {
                fileCategory = FileCategory.IMAGE;
            } else if (AIQuizConstants.DOCUMENT.equals(tag)) {
                fileCategory = FileCategory.DOCUMENT;
            } else if (AIQuizConstants.PDF.equals(tag)) {
                fileCategory = FileCategory.PDF;
            } else if ("spreadsheet".equals(tag)) {
                fileCategory = FileCategory.SPREADSHEET;
            } else if ("presentation".equals(tag)) {
                fileCategory = FileCategory.PRESENTATION;
            } else if (MimeTypes.BASE_TYPE_AUDIO.equals(tag)) {
                fileCategory = FileCategory.AUDIO;
            } else if (MimeTypes.BASE_TYPE_VIDEO.equals(tag)) {
                fileCategory = FileCategory.VIDEO;
            } else if ("folder".equals(tag)) {
                fileCategory = FileCategory.FOLDER;
            } else if ("paper".equals(tag)) {
                fileCategory = FileCategory.PAPER;
            } else if ("others".equals(tag)) {
                fileCategory = FileCategory.OTHERS;
            } else {
                fileCategory = FileCategory.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return fileCategory;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.files.FileCategory$1 */
    static /* synthetic */ class C41581 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$files$FileCategory;

        static {
            int[] iArr = new int[FileCategory.values().length];
            $SwitchMap$com$dropbox$core$v2$files$FileCategory = iArr;
            try {
                iArr[FileCategory.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileCategory[FileCategory.DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileCategory[FileCategory.PDF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileCategory[FileCategory.SPREADSHEET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileCategory[FileCategory.PRESENTATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileCategory[FileCategory.AUDIO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileCategory[FileCategory.VIDEO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileCategory[FileCategory.FOLDER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileCategory[FileCategory.PAPER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$files$FileCategory[FileCategory.OTHERS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }
}
