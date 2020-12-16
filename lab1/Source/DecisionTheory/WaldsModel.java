package DecisionTheory;

public class WaldsModel {
    private int[][] data;

    public WaldsModel(int[][] array) {
        this.data = array;
    }

    public int solveDecisionProblem(boolean decisionCondition) {
        return (decisionCondition ? solveDecisionFirstCondition() : solveDecisionSecondCondition());
    }

    private int solveDecisionFirstCondition() {
        int max = 0, index = 0;
        int[] min = new int[4];
        for (int i = 0; i < 4; i++) {
            solverDecisionConditions(min, i);
        }

        for (int i = 0; i < 4; i++) {
            if (min[i] >= max) {
                max = min[i];
                index = i;
            }
        }
        return index + 1;
    }

    private int solveDecisionSecondCondition() {
        int max = 0, index = 0;
        int[] min = new int[7];
        for (int i = 4; i < 7; i++) {
            solverDecisionConditions(min, i);
        }

        for (int i = 4; i < 7; i++) {
            if (min[i] >= max) {
                max = min[i];
                index = i;
            }
        }
        return index + 1;
    }

    private void solverDecisionConditions(int[] min, int i) {
        min[i] = 5;
        for (int j = 0; j < 3; j++) {
            if (data[i][j] < min[i]) {
                min[i] = data[i][j];
            }
        }
    }
}
