package proyecto.reto_tecnicosofka.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import proyecto.reto_tecnicosofka.facade.Juego;
import proyecto.reto_tecnicosofka.models.Jugador;

import java.net.URL;
import java.util.ResourceBundle;

public class JuegoController implements Initializable {
    @FXML private AnchorPane jugadorAnchorPane;
    @FXML private AnchorPane insercionDatosAnchorPane;
    @FXML private AnchorPane rondaAnchorPane;
    @FXML private AnchorPane resultadosAnchorPane;

    @FXML private TextField nombreTextField;
    @FXML private TextField edadTextField;
    @FXML private TextField acomuladoTextField;
    @FXML private TextField victoriasTextField;
    @FXML private TextField preguntaTextField;
    @FXML private TextField opcionATextField;
    @FXML private TextField opcionBTextField;
    @FXML private TextField opcionCTextField;
    @FXML private TextField opcionDTextField;
    @FXML private TextField eleccionPreguntaTextField;
    @FXML private TextField eleccionRespuestaTextField;

    @FXML private Button agregarButton;
    @FXML private Button agregarDatosButton;
    @FXML private Button iniciarJuegoButton;
    @FXML private Button confirmarEleccionButton;

    @FXML private Text rondaText;
    @FXML private TextArea rankingVictorias;

    @FXML private CheckBox siCheckBox;
    @FXML private CheckBox noCheckBox;

    @FXML private ComboBox<Boolean> correctaAComboBox;
    @FXML private ComboBox<Boolean> correctaBComboBox;
    @FXML private ComboBox<Boolean> correctaCComboBox;
    @FXML private ComboBox<Boolean> correctaDComboBox;
    @FXML private ComboBox<Integer> idRondaComboBox;

    ObservableList<Boolean> comboCorrectaContent =
            FXCollections.observableArrayList(
                    true,
                    false
            );

    ObservableList<Integer> comboIdRondaContent =
            FXCollections.observableArrayList(
                    0,
                    1,
                    2,
                    3,
                    4
            );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        correctaAComboBox.setItems(comboCorrectaContent);
        correctaBComboBox.setItems(comboCorrectaContent);
        correctaCComboBox.setItems(comboCorrectaContent);
        correctaDComboBox.setItems(comboCorrectaContent);
        idRondaComboBox.setItems(comboIdRondaContent);
    }

    public void onIngrezarPreguntasOpcionesClick(MouseEvent event) {
        jugadorAnchorPane.setVisible(false);
        insercionDatosAnchorPane.setVisible(true);
        resultadosAnchorPane.setVisible(false);
        rondaAnchorPane.setVisible(false);
    }

    public void onAgregarDatosClick(MouseEvent event) {
        jugadorAnchorPane.setVisible(false);
        insercionDatosAnchorPane.setVisible(false);
        resultadosAnchorPane.setVisible(false);
        rondaAnchorPane.setVisible(false);
    }

    public void onAgregarDatosClick (ActionEvent event) {
        String opcionRespuesta = opcionATextField.getText();
        Boolean correcta1 = correctaAComboBox.getValue();
        Juego juego= new Juego();
        juego.configurarJuego(nombreTextField.getText(),Integer.parseInt(edadTextField.getText()));
        juego.crearPreguntas(preguntaTextField.getText(),idRondaComboBox.getValue(),
                opcionATextField.getText(), opcionBTextField.getText(), opcionCTextField.getText(),
                opcionDTextField.getText(), correctaAComboBox.getValue(), correctaBComboBox.getValue(),
                correctaCComboBox.getValue(), correctaDComboBox.getValue());
    }
}