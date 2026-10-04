package androidx.recyclerview.selection;

import android.util.Log;
import androidx.core.util.Preconditions;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class EventBridge {
    private static final String TAG = "EventsRelays";

    public static <K> void install(RecyclerView.Adapter<?> adapter, SelectionTracker<K> selectionTracker, ItemKeyProvider<K> itemKeyProvider) {
        new TrackerToAdapterBridge(selectionTracker, itemKeyProvider, adapter);
        adapter.registerAdapterDataObserver(selectionTracker.getAdapterDataObserver());
    }

    private static final class TrackerToAdapterBridge<K> extends SelectionTracker.SelectionObserver<K> {
        private final RecyclerView.Adapter<?> mAdapter;
        private final ItemKeyProvider<K> mKeyProvider;

        TrackerToAdapterBridge(SelectionTracker<K> selectionTracker, ItemKeyProvider<K> itemKeyProvider, RecyclerView.Adapter<?> adapter) {
            selectionTracker.addObserver(this);
            Preconditions.checkArgument(itemKeyProvider != null);
            Preconditions.checkArgument(adapter != null);
            this.mKeyProvider = itemKeyProvider;
            this.mAdapter = adapter;
        }

        @Override // androidx.recyclerview.selection.SelectionTracker.SelectionObserver
        public void onItemStateChanged(K k, boolean z) {
            int position = this.mKeyProvider.getPosition(k);
            if (position < 0) {
                Log.w(EventBridge.TAG, "Item change notification received for unknown item: " + k);
            } else {
                this.mAdapter.notifyItemChanged(position, SelectionTracker.SELECTION_CHANGED_MARKER);
            }
        }
    }

    private EventBridge() {
    }
}
