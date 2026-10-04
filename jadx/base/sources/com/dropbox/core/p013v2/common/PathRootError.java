package com.dropbox.core.p013v2.common;

import com.dropbox.core.p013v2.common.RootInfo;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class PathRootError {
    public static final PathRootError NO_PERMISSION = new PathRootError().withTag(Tag.NO_PERMISSION);
    public static final PathRootError OTHER = new PathRootError().withTag(Tag.OTHER);
    private Tag _tag;
    private RootInfo invalidRootValue;

    public enum Tag {
        INVALID_ROOT,
        NO_PERMISSION,
        OTHER
    }

    private PathRootError() {
    }

    private PathRootError withTag(Tag tag) {
        PathRootError pathRootError = new PathRootError();
        pathRootError._tag = tag;
        return pathRootError;
    }

    private PathRootError withTagAndInvalidRoot(Tag tag, RootInfo rootInfo) {
        PathRootError pathRootError = new PathRootError();
        pathRootError._tag = tag;
        pathRootError.invalidRootValue = rootInfo;
        return pathRootError;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isInvalidRoot() {
        return this._tag == Tag.INVALID_ROOT;
    }

    public static PathRootError invalidRoot(RootInfo rootInfo) {
        if (rootInfo == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PathRootError().withTagAndInvalidRoot(Tag.INVALID_ROOT, rootInfo);
    }

    public RootInfo getInvalidRootValue() {
        if (this._tag != Tag.INVALID_ROOT) {
            throw new IllegalStateException("Invalid tag: required Tag.INVALID_ROOT, but was Tag." + this._tag.name());
        }
        return this.invalidRootValue;
    }

    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.invalidRootValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof PathRootError)) {
            return false;
        }
        PathRootError pathRootError = (PathRootError) obj;
        if (this._tag != pathRootError._tag) {
            return false;
        }
        int i = C41141.$SwitchMap$com$dropbox$core$v2$common$PathRootError$Tag[this._tag.ordinal()];
        if (i != 1) {
            return i == 2 || i == 3;
        }
        RootInfo rootInfo = this.invalidRootValue;
        RootInfo rootInfo2 = pathRootError.invalidRootValue;
        return rootInfo == rootInfo2 || rootInfo.equals(rootInfo2);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.common.PathRootError$1 */
    static /* synthetic */ class C41141 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$common$PathRootError$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$common$PathRootError$Tag = iArr;
            try {
                iArr[Tag.INVALID_ROOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$common$PathRootError$Tag[Tag.NO_PERMISSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$common$PathRootError$Tag[Tag.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<PathRootError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PathRootError pathRootError, JsonGenerator jsonGenerator) throws IOException {
            int i = C41141.$SwitchMap$com$dropbox$core$v2$common$PathRootError$Tag[pathRootError.tag().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    jsonGenerator.writeString("no_permission");
                    return;
                } else {
                    jsonGenerator.writeString("other");
                    return;
                }
            }
            jsonGenerator.writeStartObject();
            writeTag("invalid_root", jsonGenerator);
            jsonGenerator.writeFieldName("invalid_root");
            RootInfo.Serializer.INSTANCE.serialize(pathRootError.invalidRootValue, jsonGenerator);
            jsonGenerator.writeEndObject();
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PathRootError deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PathRootError pathRootErrorInvalidRoot;
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
            if ("invalid_root".equals(tag)) {
                expectField("invalid_root", jsonParser);
                pathRootErrorInvalidRoot = PathRootError.invalidRoot(RootInfo.Serializer.INSTANCE.deserialize(jsonParser));
            } else if ("no_permission".equals(tag)) {
                pathRootErrorInvalidRoot = PathRootError.NO_PERMISSION;
            } else {
                pathRootErrorInvalidRoot = PathRootError.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return pathRootErrorInvalidRoot;
        }
    }
}
