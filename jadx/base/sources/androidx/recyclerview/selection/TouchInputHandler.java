package androidx.recyclerview.selection;

import android.view.MotionEvent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.SelectionTracker;

/* JADX INFO: loaded from: classes3.dex */
final class TouchInputHandler<K> extends MotionInputHandler<K> {
    private static final boolean DEBUG = false;
    private static final String TAG = "TouchInputDelegate";
    private final ItemDetailsLookup<K> mDetailsLookup;
    private final Runnable mGestureStarter;
    private final Runnable mHapticPerformer;
    private final OnDragInitiatedListener mOnDragInitiatedListener;
    private final OnItemActivatedListener<K> mOnItemActivatedListener;
    private final SelectionTracker.SelectionPredicate<K> mSelectionPredicate;

    TouchInputHandler(SelectionTracker<K> selectionTracker, ItemKeyProvider<K> itemKeyProvider, ItemDetailsLookup<K> itemDetailsLookup, SelectionTracker.SelectionPredicate<K> selectionPredicate, Runnable runnable, OnDragInitiatedListener onDragInitiatedListener, OnItemActivatedListener<K> onItemActivatedListener, FocusDelegate<K> focusDelegate, Runnable runnable2) {
        super(selectionTracker, itemKeyProvider, focusDelegate);
        Preconditions.checkArgument(itemDetailsLookup != null);
        Preconditions.checkArgument(selectionPredicate != null);
        Preconditions.checkArgument(runnable != null);
        Preconditions.checkArgument(onItemActivatedListener != null);
        Preconditions.checkArgument(onDragInitiatedListener != null);
        Preconditions.checkArgument(runnable2 != null);
        this.mDetailsLookup = itemDetailsLookup;
        this.mSelectionPredicate = selectionPredicate;
        this.mGestureStarter = runnable;
        this.mOnItemActivatedListener = onItemActivatedListener;
        this.mOnDragInitiatedListener = onDragInitiatedListener;
        this.mHapticPerformer = runnable2;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (!this.mDetailsLookup.overItemWithSelectionKey(motionEvent)) {
            this.mSelectionTracker.clearSelection();
            return false;
        }
        ItemDetailsLookup.ItemDetails<K> itemDetails = this.mDetailsLookup.getItemDetails(motionEvent);
        if (itemDetails == null) {
            return false;
        }
        if (this.mSelectionTracker.hasSelection()) {
            if (isRangeExtension(motionEvent)) {
                extendSelectionRange(itemDetails);
                return true;
            }
            if (this.mSelectionTracker.isSelected(itemDetails.getSelectionKey())) {
                this.mSelectionTracker.deselect(itemDetails.getSelectionKey());
                return true;
            }
            selectItem(itemDetails);
            return true;
        }
        if (itemDetails.inSelectionHotspot(motionEvent)) {
            return selectItem(itemDetails);
        }
        return this.mOnItemActivatedListener.onItemActivated(itemDetails, motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        ItemDetailsLookup.ItemDetails<K> itemDetails;
        if (this.mDetailsLookup.overItemWithSelectionKey(motionEvent) && (itemDetails = this.mDetailsLookup.getItemDetails(motionEvent)) != null) {
            if (isRangeExtension(motionEvent)) {
                extendSelectionRange(itemDetails);
            } else if (!this.mSelectionTracker.isSelected(itemDetails.getSelectionKey()) && this.mSelectionPredicate.canSetStateForKey(itemDetails.getSelectionKey(), true)) {
                if (!selectItem(itemDetails)) {
                    return;
                }
                if (this.mSelectionPredicate.canSelectMultiple()) {
                    this.mGestureStarter.run();
                }
            } else {
                this.mOnDragInitiatedListener.onDragInitiated(motionEvent);
            }
            this.mHapticPerformer.run();
        }
    }
}
