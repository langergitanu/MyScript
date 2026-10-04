package aws.smithy.kotlin.runtime.p011io.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: ChannelCapacity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R&\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00028Æ\u0002@Â\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0005R&\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00028Æ\u0002@Â\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0005R&\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00028Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0005R\u0012\u0010\u001c\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000bR\u0012\u0010\u001d\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000b¨\u0006\u001e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/internal/ChannelCapacity;", "", "", "totalCapacity", "<init>", "(I)V", "", "toString", "()Ljava/lang/String;", "", "flush", "()Z", "size", "", "completeWrite", "completeRead", "I", "value", "getAvailableForRead", "()I", "setAvailableForRead", "availableForRead", "getAvailableForWrite", "setAvailableForWrite", "availableForWrite", "getPendingToFlush", "setPendingToFlush", "pendingToFlush", "isEmpty", "isFull", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ChannelCapacity {
    public static final /* synthetic */ AtomicIntegerFieldUpdater _availableForRead$FU$internal = AtomicIntegerFieldUpdater.newUpdater(ChannelCapacity.class, "_availableForRead$internal");
    public static final /* synthetic */ AtomicIntegerFieldUpdater _availableForWrite$FU$internal = AtomicIntegerFieldUpdater.newUpdater(ChannelCapacity.class, "_availableForWrite$internal");
    public static final /* synthetic */ AtomicIntegerFieldUpdater _pendingToFlush$FU$internal = AtomicIntegerFieldUpdater.newUpdater(ChannelCapacity.class, "_pendingToFlush$internal");
    public volatile /* synthetic */ int _availableForWrite$internal;
    private final int totalCapacity;
    public volatile /* synthetic */ int _availableForRead$internal = 0;
    public volatile /* synthetic */ int _pendingToFlush$internal = 0;

    public ChannelCapacity(int i) {
        this.totalCapacity = i;
        this._availableForWrite$internal = i;
    }

    /* JADX INFO: renamed from: getAvailableForRead, reason: from getter */
    public final int get_availableForRead$internal() {
        return this._availableForRead$internal;
    }

    private final void setAvailableForRead(int i) {
        this._availableForRead$internal = i;
    }

    /* JADX INFO: renamed from: getAvailableForWrite, reason: from getter */
    public final int get_availableForWrite$internal() {
        return this._availableForWrite$internal;
    }

    private final void setAvailableForWrite(int i) {
        this._availableForWrite$internal = i;
    }

    /* JADX INFO: renamed from: getPendingToFlush, reason: from getter */
    public final int get_pendingToFlush$internal() {
        return this._pendingToFlush$internal;
    }

    public final void setPendingToFlush(int i) {
        this._pendingToFlush$internal = i;
    }

    public final boolean isEmpty() {
        return this._availableForWrite$internal == this.totalCapacity;
    }

    public final boolean isFull() {
        return this._availableForWrite$internal == 0;
    }

    public String toString() {
        return "BufferCapacity(availableForRead: " + this._availableForRead$internal + ", availableForWrite: " + this._availableForWrite$internal + ", pendingFlush: " + this._pendingToFlush$internal + ", capacity: " + this.totalCapacity + ')';
    }

    public final boolean flush() {
        int andSet = _pendingToFlush$FU$internal.getAndSet(this, 0);
        return andSet == 0 ? this._availableForRead$internal > 0 : _availableForRead$FU$internal.addAndGet(this, andSet) > 0;
    }

    public final void completeWrite(int size) {
        _availableForWrite$FU$internal.getAndAdd(this, -size);
        _pendingToFlush$FU$internal.getAndAdd(this, size);
    }

    public final void completeRead(int size) {
        _availableForRead$FU$internal.getAndAdd(this, -size);
        _availableForWrite$FU$internal.getAndAdd(this, size);
    }
}
