package DecisionTheory;

public class HurwiczModel {
    private int[][] data;
    private float ratio;

    public HurwiczModel(int[][] array) {
        this.data = array;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public int solveDecisionProblem(boolean decisionCondition) {
        return (decisionCondition ? solveDecisionFirstCondition() : solveDecisionSecondCondition());
    }

    private int solveDecisionFirstCondition() {
        float max = 1;
        int min = 5, index = 0;
        float[] resultArray = new float[4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] < min) {
                    min = data[i][j];
                }
                if (data[i][j] > max) {
                    max = data[i][j];
                }
            }
            resultArray[i] = ratio * max + (1 - ratio) * min;
            max = 1;
            min = 5;
        }

        max = 1;
        for (int i = 0; i < 4; i++) {
            if (resultArray[i] >= max) {
                max = resultArray[i];
                index = i;
            }
        }
        return index + 1;
    }

    private int solveDecisionSecondCondition() {
        float max = 1;
        int min = 5, index = 0;
        float[] resultArray = new float[7];

        for (int i = 4; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] < min) {
                    min = data[i][j];
                }
                if (data[i][j] > max) {
                    max = data[i][j];
                }
            }
            resultArray[i] = ratio * max + (1 - ratio) * min;
            max = 1;
            min = 5;
        }

        max = 1;
        for (int i = 4; i < 7; i++) {
            if (resultArray[i] >= max) {
                max = resultArray[i];
                index = i;
            }
        }

        return index + 1;
    }
}
