package UI;

import Domain.EventValidator;
import Repository.InMemoryRepository;
import Service.EventService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EventAddController {
    public Spinner spnId;
    public TextField txtEventName;
    public TextField txtEventDay;
    public TextField txtEventDuration;
    public TextField txtEventStartHour;
    public Button btnAddEvent;
    public Button btnCancel;
    private EventService service;

    public void setService(EventService service) {
        this.service = service;
    }

    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf(spnId.getValue());
            String name = String.valueOf(txtEventName.getText());
            String day = String.valueOf(txtEventDay.getText());
            String duration = String.valueOf(txtEventDuration.getText());
            String starthour = String.valueOf(txtEventStartHour.getText());
            service.insert(id, name, day, duration, starthour);
            btnCancelClick(actionEvent);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
}

    }


    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public static class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/sample.fxml"));
            Parent root = fxmlLoader.load();
            UI.Controller controller =  fxmlLoader.getController();

            EventValidator validator = new EventValidator();
            InMemoryRepository repository = new InMemoryRepository(validator);
            EventService service = new EventService(repository);

            service.insert("1","wedding","monday","50.00", "12.00");
            service.insert("2","ceremony","tuesday","30.00","13.00");
            service.insert("3","engagement","wednesday","60.00", "11.00");
            service.insert("4","concert","thursday","70.00", "22.00");
            service.insert("5","exam","friday","60.00", "15.00");
            service.insert("6","discourse","saturday","90.00", "19.00");

            controller.setServices(service);


            primaryStage.setTitle("Event manager");
            primaryStage.setScene(new Scene(root, 650, 500));
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
    }
}
