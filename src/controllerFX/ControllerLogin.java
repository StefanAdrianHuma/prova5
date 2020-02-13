package controllerFX;

import bean.ProfessorBean;
import bean.UserLoginBean;
import database.ProfessorDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Professor;

import java.sql.SQLException;


public class ControllerLogin extends ControllerScenes{

    public ControllerLogin(){} //Costruttore di default

    @FXML
    private AnchorPane root;

    @FXML
    private Label isRightProf;

    @FXML
    private TextField matricolaProf;

    @FXML
    private PasswordField passwordProf;

    private UserLoginBean generateBean(String matricola , String password){
        UserLoginBean u = new UserLoginBean();
        u.setMatricola(matricola);
        u.setPassword(password);
        return u;
    }

    private ProfessorBean validateProfessor(UserLoginBean user){
        Professor prof = null;
        try {
            prof = ProfessorDao.validate(user.getMatricola(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ProfessorBean pb = null;
        if(prof != null){

            pb = new ProfessorBean();
            pb.setMatricola(prof.getMatricola());
            pb.setLastname(prof.getLastname());
            pb.setName(prof.getName());
        }

        return pb;
    }

    @FXML
    public void checkLoginProf(ActionEvent actionEvent) throws Exception {
        String matricola = matricolaProf.getText();
        String password = passwordProf.getText();
        UserLoginBean user = generateBean(matricola , password);
        ProfessorBean pb = validateProfessor(user);
        if(pb != null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/professorHome.fxml"));
            this.setProfessor(pb);
            AnchorPane pane = loader.load();
            root.getChildren().setAll(pane);
        }else{
            isRightProf.setText("Non Trovato");
        }
    }
}
