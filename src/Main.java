import controller.GameController;
import model.GameOfLifeModel;
import view.GameOfLifeView;

public class Main {
    public static void main(String[] args) {
        GameOfLifeModel model = new GameOfLifeModel(50, 50);
        GameOfLifeView view = new GameOfLifeView(model);
        GameController controller = new GameController(model, view);

        controller.start();
    }
}
