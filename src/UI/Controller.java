package UI;

import Domain.Event;
import Service.EventService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {


    public TableView tableViewEvents;
    public TableColumn tableColumnId;
    public TableColumn tableColumnName;
    public TableColumn tableColumnDay;
    public TableColumn tableColumnDuration;
    public TableColumn tableColumnStartHour;
    public TextField txtEventMaximumDay;
    public Label max;

    public EventService service;


    private ObservableList<Event> events = FXCollections.observableArrayList();


    public void setServices(EventService service) {
        this.service = service;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            events.addAll(service.getAll());
            tableViewEvents.setItems(events);
        });
    }


    public void btnEventAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("eventAdd.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Add event");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            EventAddController controller = fxmlLoader.getController();
            controller.setService(service);
            stage.showAndWait();
            events.clear();
            events.addAll(service.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Event update.", e);
        }

    }

    public void btnEventsMaximumDayClick(ActionEvent actionEvent) {
        String a = txtEventMaximumDay.getText();

        try {
            if (a.charAt(2) != '.' || a.charAt(5) != '.') {
                throw new RuntimeException("Duration format should be 00.00\n");
            }
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
        int MaximumOfAll=0;
        int Maximum = 40;
        int Minimum = 0;
        List<Event> all = service.getAll();
        for (Event i : all) {
            for (int b = 1; b <i.getDuration().length(); b++)
            if ((i.getDuration().length() < Maximum) && (i.getDuration().length() > Minimum)) {
                MaximumOfAll = i.getDuration(b);
            }
        }
        max.setText(MaximumOfAll + "");
    }
}