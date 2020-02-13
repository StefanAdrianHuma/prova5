package controllerFX;

import bean.ProfessorBean;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerScenes {
    private Stage primaryStage;
    private String currentURL;
    private static ProfessorBean professor;

    public ControllerScenes(){}

    public ProfessorBean getCurrentProfessor(){
        return this.professor;
    }

    public void setProfessor(ProfessorBean professor){
        this.professor = professor;
    }

}
