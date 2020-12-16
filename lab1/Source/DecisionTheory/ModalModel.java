package DecisionTheory;

public class ModalModel {
    private int[][] data;
    private float ratio1, ratio2, ratio3;

    public ModalModel(int[][] array) {
        this.data = array;
    }

    public float getRatio1() {
        return ratio1;
    }

    public float getRatio2() {
        return ratio2;
    }

    public float getRatio3() {
        return ratio3;
    }

    public void setRatios(float ratio1, float ratio2, float ratio3) {
        this.ratio1 = ratio1;
        this.ratio2 = ratio2;
        this.ratio3 = ratio3;
    }

    public int solveDecisionProblem(boolean decisionCondition) {
        return (decisionCondition ? solveDecisionFirstCondition() : solveDecisionSecondCondition());
    }

    private int solveDecisionFirstCondition() {
        int index = 0;
        if (ratio1 < ratio2)
            index = 1;
        if (ratio2 < ratio3)
            index = 2;

        int __index = 0;
        float[] resultArray = new float[4];

        for (int i = 0; i < 4; i++) {
            resultArray[i] = data[i][index];
        }

        float max = 1;
        for (int i = 0; i < 4; i++) {
            if (resultArray[i] >= max) {
                max = resultArray[i];
                __index = i;
            }
        }

        return __index;

    }

    private int solveDecisionSecondCondition() {
        int index = 0;
        if (ratio1 < ratio2)
            index = 1;
        if (ratio2 < ratio3)
            index = 2;

        int __index = 0;
        float[] resultArray = new float[7];

        for (int i = 4; i < 7; i++) {
            resultArray[i] = data[i][index];
        }

        float maxX = 1;
        for (int i = 4; i < 7; i++) {
            if (resultArray[i] >= maxX) {
                maxX = resultArray[i];
                __index = i;
            }
        }

        return __index;
    }
}
