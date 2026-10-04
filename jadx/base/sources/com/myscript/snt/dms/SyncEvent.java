package com.myscript.snt.dms;

import com.myscript.snt.dms.ContentInfo;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class SyncEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SyncEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SyncEvent syncEvent) {
        if (syncEvent == null) {
            return 0L;
        }
        return syncEvent.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_SyncEvent(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static class Parent {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public Parent(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        public static long getCPtr(Parent parent) {
            if (parent == null) {
                return 0L;
            }
            return parent.swigCPtr;
        }

        protected void finalize() {
            delete();
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboDMSJNI.delete_SyncEvent_Parent(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public void setRowid(long j) {
            NeboDMSJNI.SyncEvent_Parent_rowid_set(this.swigCPtr, this, j);
        }

        public long getRowid() {
            return NeboDMSJNI.SyncEvent_Parent_rowid_get(this.swigCPtr, this);
        }

        public void setUuid(String str) {
            NeboDMSJNI.SyncEvent_Parent_uuid_set(this.swigCPtr, this, str.getBytes());
        }

        public String getUuid() {
            return new String(NeboDMSJNI.SyncEvent_Parent_uuid_get(this.swigCPtr, this), StandardCharsets.UTF_8);
        }

        public void setChildIndex(double d) {
            NeboDMSJNI.SyncEvent_Parent_childIndex_set(this.swigCPtr, this, d);
        }

        public double getChildIndex() {
            return NeboDMSJNI.SyncEvent_Parent_childIndex_get(this.swigCPtr, this);
        }

        public void setTimestamp(long j) {
            NeboDMSJNI.SyncEvent_Parent_timestamp_set(this.swigCPtr, this, j);
        }

        public long getTimestamp() {
            return NeboDMSJNI.SyncEvent_Parent_timestamp_get(this.swigCPtr, this);
        }

        public void setOrigin(Origin origin) {
            NeboDMSJNI.SyncEvent_Parent_origin_set(this.swigCPtr, this, origin.swigValue());
        }

        public Origin getOrigin() {
            return Origin.swigToEnum(NeboDMSJNI.SyncEvent_Parent_origin_get(this.swigCPtr, this));
        }

        public Parent() {
            this(NeboDMSJNI.new_SyncEvent_Parent__SWIG_0(), true);
        }

        public Parent(long j, String str, double d, long j2, Origin origin) {
            this(NeboDMSJNI.new_SyncEvent_Parent__SWIG_1(j, str.getBytes(), d, j2, origin.swigValue()), true);
        }
    }

    public static class Content extends ContentInfo {
        private transient long swigCPtr;

        public Content(long j, boolean z) {
            super(NeboDMSJNI.SyncEvent_Content_SWIGUpcast(j), z);
            this.swigCPtr = j;
        }

        public static long getCPtr(Content content) {
            if (content == null) {
                return 0L;
            }
            return content.swigCPtr;
        }

        @Override // com.myscript.snt.dms.ContentInfo
        protected void finalize() {
            delete();
        }

        @Override // com.myscript.snt.dms.ContentInfo
        public synchronized void delete() {
            if (this.swigCPtr != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboDMSJNI.delete_SyncEvent_Content(this.swigCPtr);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        }

        public void setOrigin(Origin origin) {
            NeboDMSJNI.SyncEvent_Content_origin_set(this.swigCPtr, this, origin.swigValue());
        }

        public Origin getOrigin() {
            return Origin.swigToEnum(NeboDMSJNI.SyncEvent_Content_origin_get(this.swigCPtr, this));
        }

        public Content() {
            this(NeboDMSJNI.new_SyncEvent_Content__SWIG_0(), true);
        }

        public Content(ContentInfo.Rev rev, ContentInfo.Rev rev2, String str, String str2, Origin origin) {
            this(NeboDMSJNI.new_SyncEvent_Content__SWIG_1(ContentInfo.Rev.getCPtr(rev), rev, ContentInfo.Rev.getCPtr(rev2), rev2, str.getBytes(), str2.getBytes(), origin.swigValue()), true);
        }

        public Content(ContentInfo contentInfo, Origin origin) {
            this(NeboDMSJNI.new_SyncEvent_Content__SWIG_2(ContentInfo.getCPtr(contentInfo), contentInfo, origin.swigValue()), true);
        }
    }

    public static class Attachment {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public Attachment(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        public static long getCPtr(Attachment attachment) {
            if (attachment == null) {
                return 0L;
            }
            return attachment.swigCPtr;
        }

        protected void finalize() {
            delete();
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboDMSJNI.delete_SyncEvent_Attachment(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public void setUuid(String str) {
            NeboDMSJNI.SyncEvent_Attachment_uuid_set(this.swigCPtr, this, str.getBytes());
        }

        public String getUuid() {
            return new String(NeboDMSJNI.SyncEvent_Attachment_uuid_get(this.swigCPtr, this), StandardCharsets.UTF_8);
        }

        public void setUrl(String str) {
            NeboDMSJNI.SyncEvent_Attachment_url_set(this.swigCPtr, this, str.getBytes());
        }

        public String getUrl() {
            return new String(NeboDMSJNI.SyncEvent_Attachment_url_get(this.swigCPtr, this), StandardCharsets.UTF_8);
        }

        public void setReferenceCount(int i) {
            NeboDMSJNI.SyncEvent_Attachment_referenceCount_set(this.swigCPtr, this, i);
        }

        public int getReferenceCount() {
            return NeboDMSJNI.SyncEvent_Attachment_referenceCount_get(this.swigCPtr, this);
        }

        public Attachment() {
            this(NeboDMSJNI.new_SyncEvent_Attachment__SWIG_0(), true);
        }

        public Attachment(String str, String str2, int i) {
            this(NeboDMSJNI.new_SyncEvent_Attachment__SWIG_1(str.getBytes(), str2.getBytes(), i), true);
        }
    }

    public static class Metadata {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public Metadata(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        public static long getCPtr(Metadata metadata) {
            if (metadata == null) {
                return 0L;
            }
            return metadata.swigCPtr;
        }

        protected void finalize() {
            delete();
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboDMSJNI.delete_SyncEvent_Metadata(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public void setKey(String str) {
            NeboDMSJNI.SyncEvent_Metadata_key_set(this.swigCPtr, this, str.getBytes());
        }

        public String getKey() {
            return new String(NeboDMSJNI.SyncEvent_Metadata_key_get(this.swigCPtr, this), StandardCharsets.UTF_8);
        }

        public void setValue(String str) {
            NeboDMSJNI.SyncEvent_Metadata_value_set(this.swigCPtr, this, str.getBytes());
        }

        public String getValue() {
            return new String(NeboDMSJNI.SyncEvent_Metadata_value_get(this.swigCPtr, this), StandardCharsets.UTF_8);
        }

        public void setTimestamp(long j) {
            NeboDMSJNI.SyncEvent_Metadata_timestamp_set(this.swigCPtr, this, j);
        }

        public long getTimestamp() {
            return NeboDMSJNI.SyncEvent_Metadata_timestamp_get(this.swigCPtr, this);
        }

        public void setOrigin(Origin origin) {
            NeboDMSJNI.SyncEvent_Metadata_origin_set(this.swigCPtr, this, origin.swigValue());
        }

        public Origin getOrigin() {
            return Origin.swigToEnum(NeboDMSJNI.SyncEvent_Metadata_origin_get(this.swigCPtr, this));
        }

        public Metadata() {
            this(NeboDMSJNI.new_SyncEvent_Metadata__SWIG_0(), true);
        }

        public Metadata(String str, String str2, long j, Origin origin) {
            this(NeboDMSJNI.new_SyncEvent_Metadata__SWIG_1(str.getBytes(), str2.getBytes(), j, origin.swigValue()), true);
        }
    }

    public static class Trash {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public Trash(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        public static long getCPtr(Trash trash) {
            if (trash == null) {
                return 0L;
            }
            return trash.swigCPtr;
        }

        protected void finalize() {
            delete();
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboDMSJNI.delete_SyncEvent_Trash(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public void setState(TrashState trashState) {
            NeboDMSJNI.SyncEvent_Trash_state_set(this.swigCPtr, this, trashState.swigValue());
        }

        public TrashState getState() {
            return TrashState.swigToEnum(NeboDMSJNI.SyncEvent_Trash_state_get(this.swigCPtr, this));
        }

        public void setTimestamp(long j) {
            NeboDMSJNI.SyncEvent_Trash_timestamp_set(this.swigCPtr, this, j);
        }

        public long getTimestamp() {
            return NeboDMSJNI.SyncEvent_Trash_timestamp_get(this.swigCPtr, this);
        }

        public void setOrigin(Origin origin) {
            NeboDMSJNI.SyncEvent_Trash_origin_set(this.swigCPtr, this, origin.swigValue());
        }

        public Origin getOrigin() {
            return Origin.swigToEnum(NeboDMSJNI.SyncEvent_Trash_origin_get(this.swigCPtr, this));
        }

        public Trash() {
            this(NeboDMSJNI.new_SyncEvent_Trash__SWIG_0(), true);
        }

        public Trash(TrashState trashState, long j, Origin origin) {
            this(NeboDMSJNI.new_SyncEvent_Trash__SWIG_1(trashState.swigValue(), j, origin.swigValue()), true);
        }
    }

    public void setType(Type type) {
        NeboDMSJNI.SyncEvent_type_set(this.swigCPtr, this, type.swigValue());
    }

    public Type getType() {
        return Type.swigToEnum(NeboDMSJNI.SyncEvent_type_get(this.swigCPtr, this));
    }

    public void setObject(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object) {
        NeboDMSJNI.SyncEvent_object_set(this.swigCPtr, this, SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object));
    }

    public SWIGTYPE_p_snt__dms__Object getObject() {
        long jSyncEvent_object_get = NeboDMSJNI.SyncEvent_object_get(this.swigCPtr, this);
        if (jSyncEvent_object_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_snt__dms__Object(jSyncEvent_object_get, false);
    }

    public void setParent(Parent parent) {
        NeboDMSJNI.SyncEvent_parent_set(this.swigCPtr, this, Parent.getCPtr(parent), parent);
    }

    public Parent getParent() {
        long jSyncEvent_parent_get = NeboDMSJNI.SyncEvent_parent_get(this.swigCPtr, this);
        if (jSyncEvent_parent_get == 0) {
            return null;
        }
        return new Parent(jSyncEvent_parent_get, false);
    }

    public void setContent(Content content) {
        NeboDMSJNI.SyncEvent_content_set(this.swigCPtr, this, Content.getCPtr(content), content);
    }

    public Content getContent() {
        long jSyncEvent_content_get = NeboDMSJNI.SyncEvent_content_get(this.swigCPtr, this);
        if (jSyncEvent_content_get == 0) {
            return null;
        }
        return new Content(jSyncEvent_content_get, false);
    }

    public void setAttachments(SWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Attachment_t sWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Attachment_t) {
        NeboDMSJNI.SyncEvent_attachments_set(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Attachment_t.getCPtr(sWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Attachment_t));
    }

    public SWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Attachment_t getAttachments() {
        long jSyncEvent_attachments_get = NeboDMSJNI.SyncEvent_attachments_get(this.swigCPtr, this);
        if (jSyncEvent_attachments_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Attachment_t(jSyncEvent_attachments_get, false);
    }

    public void setMetadata(SWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Metadata_t sWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Metadata_t) {
        NeboDMSJNI.SyncEvent_metadata_set(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Metadata_t.getCPtr(sWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Metadata_t));
    }

    public SWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Metadata_t getMetadata() {
        long jSyncEvent_metadata_get = NeboDMSJNI.SyncEvent_metadata_get(this.swigCPtr, this);
        if (jSyncEvent_metadata_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__vectorT_snt__dms__SyncEvent__Metadata_t(jSyncEvent_metadata_get, false);
    }

    public void setTrash(Trash trash) {
        NeboDMSJNI.SyncEvent_trash_set(this.swigCPtr, this, Trash.getCPtr(trash), trash);
    }

    public Trash getTrash() {
        long jSyncEvent_trash_get = NeboDMSJNI.SyncEvent_trash_get(this.swigCPtr, this);
        if (jSyncEvent_trash_get == 0) {
            return null;
        }
        return new Trash(jSyncEvent_trash_get, false);
    }

    public void setTimestamp(long j) {
        NeboDMSJNI.SyncEvent_timestamp_set(this.swigCPtr, this, j);
    }

    public long getTimestamp() {
        return NeboDMSJNI.SyncEvent_timestamp_get(this.swigCPtr, this);
    }

    public SyncEvent() {
        this(NeboDMSJNI.new_SyncEvent(), true);
    }

    public void setOrigin(Origin origin) {
        NeboDMSJNI.SyncEvent_setOrigin(this.swigCPtr, this, origin.swigValue());
    }

    public boolean valid() {
        return NeboDMSJNI.SyncEvent_valid(this.swigCPtr, this);
    }

    public enum Type {
        CREATE_OBJECT(0),
        MOVE_OBJECT(1),
        UPDATE_CONTENT(2),
        UPDATE_METADATA(3),
        DELETE_OBJECT(4);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static Type swigToEnum(int i) {
            Type[] typeArr = (Type[]) Type.class.getEnumConstants();
            if (i < typeArr.length && i >= 0) {
                Type type = typeArr[i];
                if (type.swigValue == i) {
                    return type;
                }
            }
            for (Type type2 : typeArr) {
                if (type2.swigValue == i) {
                    return type2;
                }
            }
            throw new IllegalArgumentException("No enum " + Type.class + " with value " + i);
        }

        Type() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        Type(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        Type(Type type) {
            int i = type.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }

    public enum Origin {
        BOTH(0),
        LOCAL(1),
        CLOUD(2),
        MERGE(3);

        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public static Origin swigToEnum(int i) {
            Origin[] originArr = (Origin[]) Origin.class.getEnumConstants();
            if (i < originArr.length && i >= 0) {
                Origin origin = originArr[i];
                if (origin.swigValue == i) {
                    return origin;
                }
            }
            for (Origin origin2 : originArr) {
                if (origin2.swigValue == i) {
                    return origin2;
                }
            }
            throw new IllegalArgumentException("No enum " + Origin.class + " with value " + i);
        }

        Origin() {
            int i = SwigNext.next;
            SwigNext.next = i + 1;
            this.swigValue = i;
        }

        Origin(int i) {
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        Origin(Origin origin) {
            int i = origin.swigValue;
            this.swigValue = i;
            SwigNext.next = i + 1;
        }

        private static class SwigNext {
            private static int next;

            private SwigNext() {
            }
        }
    }
}
