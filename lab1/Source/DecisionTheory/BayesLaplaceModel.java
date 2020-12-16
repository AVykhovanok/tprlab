package DecisionTheory;

public class BayesLaplaceModel {
    private int[][] data;
    private float ratio1, ratio2, ratio3;

    public BayesLaplaceModel(int[][] array) {
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
            float max;
            int index = 0;
            float[] resultArray = new float[4];

            int j = 0;
            for(int i = 0; i < 4; i++){
                j = getVariantJ(resultArray, j, i);
            }

            max = 1;
            for(int i = 0; i < 4; i++){
                if(resultArray[i] >= max){
                    max = resultArray[i];
                    index = i;
                }
            }
            return index + 1;
    }

    private int solveDecisionSecondCondition() {
        float max;
        int index = 0;
        float[] resultArray = new float[7];

        int j = 0;
        for(int i = 4; i < 7; i++){
            j = getVariantJ(resultArray, j, i);
        }

        max = 1;
        for(int i = 4; i < 7; i++){
            if(resultArray[i] >= max){
                max = resultArray[i];
                index = i;
            }
        }

        return index + 1;
    }

    private int getVariantJ(float[] resultArray, int j, int i) {
        resultArray[i] = ratio1 * data[i][j];
        j++;
        resultArray[i] += ratio2 * data[i][j];
        j++;
        resultArray[i] += ratio3 * data[i][j];
        j = 0;
        return j;
    }

}


