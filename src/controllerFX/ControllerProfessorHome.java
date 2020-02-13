package controllerFX;

import bean.HomeworkBean;
import bean.ProfessorBean;
import controller.ControllerHomeProfessor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.ScheduleInfo;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerProfessorHome extends ControllerScenes implements Initializable{

    private ControllerHomeProfessor chp = new ControllerHomeProfessor();

    @FXML
    private AnchorPane root;

    @FXML
    private TextArea areaCompiti;

    @FXML
    private ComboBox comboClasse;

    @FXML
    private ComboBox comboSubject;

    @FXML
    private DatePicker dateHomework;

    @FXML
    private TextArea homeworkDescription;

    @FXML
    private TableView<ScheduleInfo> tableSchedule;

    private ProfessorBean professor;

    public ControllerProfessorHome(){ }

    @FXML
    private void inizialize(){
        this.areaCompiti.setText("Ciao");
    }


    public void addHomework(){
        String classe =  this.comboClasse.getValue().toString();
        String materia = this.comboSubject.getValue().toString();
        String data = this.dateHomework.getValue().toString();
        String description = this.homeworkDescription.getText();
        ControllerHomeProfessor chp = new ControllerHomeProfessor();
        HomeworkBean hmwbean = chp.generateHomeworkBean(classe,description,materia,data,this.professor.getMatricola());
        this.chp.save(hmwbean);
        this.areaCompiti.appendText(hmwbean.getClasse() + " " + hmwbean.getData() + " " + hmwbean.getMateria() + "\n");
        this.areaCompiti.appendText(hmwbean.getDescription());
        this.areaCompiti.appendText("\n \n");
    }


    public void goToRegistro() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/profRegistro.fxml"));
        AnchorPane pane = loader.load();
        root.getChildren().setAll(pane);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.professor = this.getCurrentProfessor();


        try {
            this.professor = this.chp.full(this.professor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<HomeworkBean> homeworks = this.professor.getHomework();
        this.areaCompiti.setText("");
        for(HomeworkBean homework : homeworks) {
            this.areaCompiti.appendText(homework.getClasse() + " " + homework.getData() + " " + homework.getMateria() + "\n");
            this.areaCompiti.appendText(homework.getDescription());
            this.areaCompiti.appendText("\n \n");
        }
        for(String materia : this.professor.getMatter()){
            this.comboSubject.getItems().add(materia);
        }
        for(String classi : this.professor.getClassi()){
            this.comboClasse.getItems().add(classi);
        }


        List<ScheduleInfo> schedule = this.professor.getSchedule();

        TableColumn giornoCol = new TableColumn("GIORNO");
        giornoCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        TableColumn oraCol = new TableColumn("ORA");
        oraCol.setCellValueFactory(new PropertyValueFactory<>("hours"));
        TableColumn materiaCol = new TableColumn("MATERIA");
        materiaCol.setCellValueFactory(new PropertyValueFactory<>("materia"));
        TableColumn classeCol = new TableColumn("CLASSE");
        classeCol.setCellValueFactory(new PropertyValueFactory<>("classe"));

        tableSchedule.getColumns().clear();
        tableSchedule.getColumns().addAll(giornoCol , oraCol , materiaCol , classeCol);

        ObservableList<ScheduleInfo> values = FXCollections.observableArrayList();
        for(ScheduleInfo campo : schedule){
            values.add(campo);
        }
        tableSchedule.setItems(values);
    }
}
