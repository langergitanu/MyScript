package org.ejml.equation;

import java.util.ArrayList;
import java.util.List;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixConstructor {
    List<Item> items = new ArrayList();
    VariableMatrix output;

    public MatrixConstructor(ManagerTempVariables managerTempVariables) {
        this.output = managerTempVariables.createMatrix();
    }

    public void addToRow(Variable variable) {
        if (variable.getType() == VariableType.INTEGER_SEQUENCE && ((VariableIntegerSequence) variable).sequence.requiresMaxIndex()) {
            throw new ParseError("Trying to create a matrix with an unbounded integer range. Forgot a value after a colon?");
        }
        this.items.add(new Item(variable));
    }

    public void endRow() {
        this.items.add(new Item());
    }

    public void construct() {
        if (!this.items.get(r0.size() - 1).endRow) {
            endRow();
        }
        for (int i = 0; i < this.items.size(); i++) {
            this.items.get(i).initialize();
        }
        setToRequiredSize(this.output.matrix);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < this.items.size(); i3++) {
            Item item = this.items.get(i3);
            if (item.endRow) {
                int i4 = 0;
                int columns = 0;
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    Item item2 = (Item) arrayList.get(i5);
                    int rows = item2.getRows();
                    if (i5 == 0) {
                        i4 = rows;
                    } else if (item2.getRows() != i4) {
                        throw new RuntimeException("Row miss-matched. " + rows + " " + item2.getRows());
                    }
                    if (item2.matrix) {
                        CommonOps_DDRM.insert(item2.getMatrix(), this.output.matrix, i2, columns);
                    } else if (item2.variable.getType() == VariableType.SCALAR) {
                        this.output.matrix.set(i2, columns, item2.getValue());
                    } else if (item2.variable.getType() == VariableType.INTEGER_SEQUENCE) {
                        IntegerSequence integerSequence = ((VariableIntegerSequence) item2.variable).sequence;
                        int i6 = columns;
                        while (integerSequence.hasNext()) {
                            this.output.matrix.set(i2, i6, integerSequence.next());
                            i6++;
                        }
                    } else {
                        throw new ParseError("Can't insert a variable of type " + item2.variable.getType() + " inside a matrix!");
                    }
                    columns += item2.getColumns();
                }
                i2 += i4;
                arrayList.clear();
            } else {
                arrayList.add(item);
            }
        }
    }

    public VariableMatrix getOutput() {
        return this.output;
    }

    protected void setToRequiredSize(DMatrixRMaj dMatrixRMaj) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.items.size(); i3++) {
            Item item = this.items.get(i3);
            if (item.endRow) {
                Item item2 = (Item) arrayList.get(0);
                int rows = item2.getRows();
                int columns = item2.getColumns();
                for (int i4 = 1; i4 < arrayList.size(); i4++) {
                    Item item3 = (Item) arrayList.get(i4);
                    if (item3.getRows() != rows) {
                        throw new RuntimeException("Row miss-matched. " + rows + " " + item3.getRows());
                    }
                    columns += item3.getColumns();
                }
                i += rows;
                if (i2 == 0) {
                    i2 = columns;
                } else if (i2 != columns) {
                    throw new ParseError("Row " + i + " has an unexpected number of columns; expected = " + i2 + " found = " + columns);
                }
                arrayList.clear();
            } else {
                arrayList.add(item);
            }
        }
        dMatrixRMaj.reshape(i, i2);
    }

    private static class Item {
        boolean endRow;
        boolean matrix;
        Variable variable;

        private Item(Variable variable) {
            this.variable = variable;
            this.matrix = variable instanceof VariableMatrix;
        }

        private Item() {
            this.endRow = true;
        }

        public int getRows() {
            if (this.matrix) {
                return ((VariableMatrix) this.variable).matrix.numRows;
            }
            return 1;
        }

        public int getColumns() {
            if (this.matrix) {
                return ((VariableMatrix) this.variable).matrix.numCols;
            }
            if (this.variable.getType() == VariableType.SCALAR) {
                return 1;
            }
            if (this.variable.getType() == VariableType.INTEGER_SEQUENCE) {
                return ((VariableIntegerSequence) this.variable).sequence.length();
            }
            throw new RuntimeException("BUG! Should have been caught earlier");
        }

        public DMatrixRMaj getMatrix() {
            return ((VariableMatrix) this.variable).matrix;
        }

        public double getValue() {
            return ((VariableScalar) this.variable).getDouble();
        }

        public void initialize() {
            Variable variable = this.variable;
            if (variable == null || this.matrix || variable.getType() != VariableType.INTEGER_SEQUENCE) {
                return;
            }
            ((VariableIntegerSequence) this.variable).sequence.initialize(-1);
        }
    }
}
