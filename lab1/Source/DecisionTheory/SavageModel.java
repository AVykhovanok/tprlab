package DecisionTheory;

public class SavageModel {
    private int[][] data;

    public SavageModel(int[][] array) {
        this.data = array;
    }

    public int solveDecisionProblem(boolean decisionCondition) {
        return (decisionCondition ? solveDecisionFirstCondition() : solveDecisionSecondCondition());
    }

    private int solveDecisionFirstCondition() {
        int max = 1, min = 5, index = 0;
        int[] minArr = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] < min) {
                    min = data[i][j];
                }
                if (data[i][j] > max) {
                    max = data[i][j];
                }
            }
            minArr[i] = max - min;
            max = 1;
            min = 5;
        }

        min = 5;
        for (int i = 0; i < 4; i++) {
            if (minArr[i] <= min) {
                min = minArr[i];
                index = i;
            }

        }
        return index + 1;
    }

    private int solveDecisionSecondCondition() {
        int max = 1, min = 5;
        int index = 0;
        int[] minArr = new int[7];

        for (int i = 4; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] < min) {
                    min = data[i][j];
                }
                if (data[i][j] > max) {
                    max = data[i][j];
                }
            }
            minArr[i] = max - min;
            max = 1;
            min = 5;
        }

        min = 5;
        for (int i = 4; i < 7; i++) {
            if (minArr[i] <= min) {
                min = minArr[i];
                index = i;
            }
        }
        return index + 1;
    }
}
