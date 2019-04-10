import Domain.EventValidator;
import Repository.InMemoryRepository;
import Service.EventService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/sample.fxml"));
        Parent root = fxmlLoader.load();
        Controller controller =  fxmlLoader.getController();

        EventValidator validator = new EventValidator();
        InMemoryRepository repository = new InMemoryRepository(validator);
        EventService service = new EventService(repository);

        service.insert("1","wedding","monday","30.00", "12.00");
        service.insert("2","ceremony","tuesday","50.00","13.00");
        service.insert("3","engagement","wednesday","70.00", "11.00");
        service.insert("4","concert","thursday","60.00", "22.00");
        service.insert("5","exam","friday","90.00", "15.00");
        service.insert("6","discourse","saturday","80.00", "19.00");

        controller.setServices(service);


        primaryStage.setTitle("Event manager");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
