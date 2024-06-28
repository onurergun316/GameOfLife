import controller.GameController;
import model.GameOfLifeModel;
import view.GameOfLifeView;

public class Main {
    public static void main(String[] args) {
        GameOfLifeModel model = new GameOfLifeModel(60, 60);
        GameController[] controller = new GameController[1];
        GameOfLifeView view = new GameOfLifeView(model, e -> controller[0].start(), e -> controller[0].stop(), e -> controller[0].generate());

        controller[0] = new GameController(model, view);
    }
}
