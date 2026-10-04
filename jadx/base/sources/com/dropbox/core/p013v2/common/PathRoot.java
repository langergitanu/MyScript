package com.dropbox.core.p013v2.common;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class PathRoot {
    public static final PathRoot HOME = new PathRoot().withTag(Tag.HOME);
    public static final PathRoot OTHER = new PathRoot().withTag(Tag.OTHER);
    private Tag _tag;
    private String namespaceIdValue;
    private String rootValue;

    public enum Tag {
        HOME,
        ROOT,
        NAMESPACE_ID,
        OTHER
    }

    private PathRoot() {
    }

    private PathRoot withTag(Tag tag) {
        PathRoot pathRoot = new PathRoot();
        pathRoot._tag = tag;
        return pathRoot;
    }

    private PathRoot withTagAndRoot(Tag tag, String str) {
        PathRoot pathRoot = new PathRoot();
        pathRoot._tag = tag;
        pathRoot.rootValue = str;
        return pathRoot;
    }

    private PathRoot withTagAndNamespaceId(Tag tag, String str) {
        PathRoot pathRoot = new PathRoot();
        pathRoot._tag = tag;
        pathRoot.namespaceIdValue = str;
        return pathRoot;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isHome() {
        return this._tag == Tag.HOME;
    }

    public boolean isRoot() {
        return this._tag == Tag.ROOT;
    }

    public static PathRoot root(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new PathRoot().withTagAndRoot(Tag.ROOT, str);
    }

    public String getRootValue() {
        if (this._tag != Tag.ROOT) {
            throw new IllegalStateException("Invalid tag: required Tag.ROOT, but was Tag." + this._tag.name());
        }
        return this.rootValue;
    }

    public boolean isNamespaceId() {
        return this._tag == Tag.NAMESPACE_ID;
    }

    public static PathRoot namespaceId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new PathRoot().withTagAndNamespaceId(Tag.NAMESPACE_ID, str);
    }

    public String getNamespaceIdValue() {
        if (this._tag != Tag.NAMESPACE_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.NAMESPACE_ID, but was Tag." + this._tag.name());
        }
        return this.namespaceIdValue;
    }

    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.rootValue, this.namespaceIdValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof PathRoot)) {
            return false;
        }
        PathRoot pathRoot = (PathRoot) obj;
        if (this._tag != pathRoot._tag) {
            return false;
        }
        int i = C41131.$SwitchMap$com$dropbox$core$v2$common$PathRoot$Tag[this._tag.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return i == 4;
                }
                String str = this.namespaceIdValue;
                String str2 = pathRoot.namespaceIdValue;
                return str == str2 || str.equals(str2);
            }
            String str3 = this.rootValue;
            String str4 = pathRoot.rootValue;
            if (str3 != str4 && !str3.equals(str4)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.common.PathRoot$1 */
    static /* synthetic */ class C41131 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$common$PathRoot$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$common$PathRoot$Tag = iArr;
            try {
                iArr[Tag.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$common$PathRoot$Tag[Tag.ROOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$common$PathRoot$Tag[Tag.NAMESPACE_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$common$PathRoot$Tag[Tag.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends UnionSerializer<PathRoot> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(PathRoot pathRoot, JsonGenerator jsonGenerator) throws IOException {
            int i = C41131.$SwitchMap$com$dropbox$core$v2$common$PathRoot$Tag[pathRoot.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeString("home");
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag("root", jsonGenerator);
                jsonGenerator.writeFieldName("root");
                StoneSerializers.string().serialize(pathRoot.rootValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("namespace_id", jsonGenerator);
                jsonGenerator.writeFieldName("namespace_id");
                StoneSerializers.string().serialize(pathRoot.namespaceIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            jsonGenerator.writeString("other");
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public PathRoot deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            PathRoot pathRootNamespaceId;
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
            if ("home".equals(tag)) {
                pathRootNamespaceId = PathRoot.HOME;
            } else if ("root".equals(tag)) {
                expectField("root", jsonParser);
                pathRootNamespaceId = PathRoot.root(StoneSerializers.string().deserialize(jsonParser));
            } else if ("namespace_id".equals(tag)) {
                expectField("namespace_id", jsonParser);
                pathRootNamespaceId = PathRoot.namespaceId(StoneSerializers.string().deserialize(jsonParser));
            } else {
                pathRootNamespaceId = PathRoot.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return pathRootNamespaceId;
        }
    }
}
