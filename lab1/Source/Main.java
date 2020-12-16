import DecisionTheory.*;

public class Main {
    private static int[][] data = {
            {5, 5, 3},
            {4, 5, 5},
            {5, 4, 3},
            {3, 4, 4},
            {3, 4, 2},
            {4, 2, 1},
            {1, 1, 1},
    };

    public static void main(String[] args) {
        printArrayData();
        HurwiczModel hurModel = new HurwiczModel(data);
        BayesLaplaceModel blModel = new BayesLaplaceModel(data);
        ModalModel modalModel = new ModalModel(data);
        hurModel.setRatio((float) 0.5);
        blModel.setRatios((float) 0.25,(float) 0.5,(float)  0.25);
        modalModel.setRatios((float) 0.25, (float) 0.5, (float) 0.25);
        System.out.println("Умова, коли привабливість більше вартості. За критерієм Вальда оптимальним буде: Х" +
                new WaldsModel(data).solveDecisionProblem(true) + "\n" +
                "Умова, коли вартість більше привабливості. За критерієм Вальда оптимальним буде: Х" +
                new WaldsModel(data).solveDecisionProblem(false) + "\n" +
                "Умова, коли привабливість більше вартості. За критерієм Севіджа оптимальним буде: Х" +
                new SavageModel(data).solveDecisionProblem(true) + "\n" +
                "Умова, коли вартість більше приватливості. За критерієм Севіджа оптимальним буде: Х" +
                new SavageModel(data).solveDecisionProblem(false) + "\n" +
                "За критерієм Гурвіца з коефіцієнтом " + hurModel.getRatio() + " оптимальним буде: Х" +
                hurModel.solveDecisionProblem(true) + " і Х" +
                hurModel.solveDecisionProblem(false) + "\n" +
                "За критерієм Байєса-Лапласа з коефіцієнтами: " + blModel.getRatio1() + ", " + blModel.getRatio2() + ", " + blModel.getRatio3() + " оптимальним буде: Х" + blModel.solveDecisionProblem(true) + " i X" + blModel.solveDecisionProblem(false));
    }

    private static void printArrayData() {
        for (int i = 0; i < data.length; i++) {
            System.out.print("X" + i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }

    }
}
