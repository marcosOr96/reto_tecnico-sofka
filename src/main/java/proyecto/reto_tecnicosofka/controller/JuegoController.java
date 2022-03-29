package proyecto.reto_tecnicosofka.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import proyecto.reto_tecnicosofka.facade.Juego;
import proyecto.reto_tecnicosofka.models.Jugador;
import proyecto.reto_tecnicosofka.models.Opcion;
import proyecto.reto_tecnicosofka.models.Pregunta;
import proyecto.reto_tecnicosofka.models.Ronda;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class JuegoController implements Initializable {
    @FXML
    private AnchorPane jugadorAnchorPane;
    @FXML
    private AnchorPane insercionDatosAnchorPane;
    @FXML
    private AnchorPane rondaAnchorPane;
    @FXML
    private AnchorPane resultadosAnchorPane;

    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField edadTextField;
    @FXML
    private TextField acomuladoTextField;
    @FXML
    private TextField victoriasTextField;
    @FXML
    private TextField preguntaTextField;
    @FXML
    private TextField opcionATextField;
    @FXML
    private TextField opcionBTextField;
    @FXML
    private TextField opcionCTextField;
    @FXML
    private TextField opcionDTextField;
    @FXML
    private TextField eleccionPreguntaTextField;

    @FXML
    private Button agregarButton;
    @FXML
    private Button agregarDatosButton;
    @FXML
    private Button iniciarJuegoButton;
    @FXML
    private Button confirmarEleccionButton;
    @FXML
    private Button salirButton;

    @FXML
    private Text rondaText;
    @FXML
    private TextArea rankingVictoriasTextArea;

    @FXML
    private ComboBox<Boolean> correctaAComboBox;
    @FXML
    private ComboBox<Boolean> correctaBComboBox;
    @FXML
    private ComboBox<Boolean> correctaCComboBox;
    @FXML
    private ComboBox<Boolean> correctaDComboBox;
    @FXML
    private ComboBox<Integer> idRondaComboBox;
    @FXML
    private ComboBox<String> eleccionRespuestaComboBox;

    public Juego juego = new Juego();

    private Jugador jugador;

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
        edadTextField.addEventFilter(KeyEvent.ANY, validarNumeros);
        correctaAComboBox.setItems(comboCorrectaContent);
        correctaBComboBox.setItems(comboCorrectaContent);
        correctaCComboBox.setItems(comboCorrectaContent);
        correctaDComboBox.setItems(comboCorrectaContent);
        idRondaComboBox.setItems(comboIdRondaContent);
        juego.configurarJuego();

    }

    public void onIngresarPreguntasOpcionesClick(MouseEvent event) {
        insercionDatosAnchorPane.setVisible(true);
        jugadorAnchorPane.setVisible(false);
        resultadosAnchorPane.setVisible(false);
        rondaAnchorPane.setVisible(false);
    }

    public void onElegirPreguntaYRespuestaClick(MouseEvent event) {
        rondaAnchorPane.setVisible(true);
        jugadorAnchorPane.setVisible(false);
        insercionDatosAnchorPane.setVisible(false);
        resultadosAnchorPane.setVisible(false);
    }

    public void onVolverInsertarJugadorClick(MouseEvent event) {
        jugadorAnchorPane.setVisible(true);
        rondaAnchorPane.setVisible(false);
        insercionDatosAnchorPane.setVisible(false);
        resultadosAnchorPane.setVisible(false);
    }

    public void onAgregarDatosAction(ActionEvent event) {
        if (opcionATextField.getText() == null || opcionBTextField.getText() == null
                || opcionCTextField.getText() == null || opcionDTextField.getText() == null
                || correctaAComboBox.getValue() == null || correctaBComboBox.getValue() == null
                || correctaCComboBox.getValue() == null || correctaDComboBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("***** Error *****");
            alert.setHeaderText(null);
            alert.setContentText("se encuentran casillas vacias");
            alert.showAndWait();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("***** Excelente *****");
        alert.setHeaderText(null);
        alert.setContentText("se registraron la pregunta y sus opciones de respuesta satisfactoriamente");
        alert.showAndWait();
        juego.crearPreguntas(preguntaTextField.getText(), idRondaComboBox.getValue(),
                opcionATextField.getText(), opcionBTextField.getText(), opcionCTextField.getText(),
                opcionDTextField.getText(), correctaAComboBox.getValue(), correctaBComboBox.getValue(),
                correctaCComboBox.getValue(), correctaDComboBox.getValue());
    }

    public void onIniciarAction(ActionEvent event) {
        String mensaje = juego.validarCantidadDePreguntas();
        rondaText.setText("0");
        if (!mensaje.equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("***** Error *****");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        } else {
            Pregunta pregunta = juego.iniciarJuego();
            eleccionPreguntaTextField.setText(pregunta.getDescripcionPregunta());
            ObservableList<String> comboOpcionesContent =
                    FXCollections.observableArrayList(
                    );
            for (Opcion opcion : pregunta.getOpciones()) {
                comboOpcionesContent.add(opcion.getDescripcionOpcion());
            }
            eleccionRespuestaComboBox.setItems(comboOpcionesContent);

            jugador=juego.crearJugador(nombreTextField.getText(),Integer.parseInt(edadTextField.getText()));
        }
    }

    public void onResponderAction(ActionEvent event) {
        boolean respuesta=juego.responderPregunta(Integer.parseInt(rondaText.getText()),
                eleccionRespuestaComboBox.getValue());
        if (respuesta) {
            if (rondaText.getText().equals("4")) {
                rondaAnchorPane.setVisible(false);
                jugadorAnchorPane.setVisible(false);
                insercionDatosAnchorPane.setVisible(false);
                resultadosAnchorPane.setVisible(true);
            }
            jugador.setPremioAcomulado(jugador.getPremioAcomulado()+jugador.getRonda().
                    getPremio().getCantPuntos());
            juego.aumentarNivelCategoria(jugador);
            rondaText.setText(String.valueOf(jugador.getRonda().getCategoria().getNivel()));

            Pregunta pregunta = juego.continuarJuego(jugador.getRonda().getCategoria().getNivel());
            eleccionPreguntaTextField.setText(pregunta.getDescripcionPregunta());
            ObservableList<String> comboOpcionesContent =
                    FXCollections.observableArrayList(
                    );
            for (Opcion opcion : pregunta.getOpciones()) {
                comboOpcionesContent.add(opcion.getDescripcionOpcion());
            }
            eleccionRespuestaComboBox.setItems(comboOpcionesContent);
        }
        else {
            Platform.exit();
            System.exit(0);
        }
    }

    public void onAumentarRondaAction(ActionEvent event) {
        juego.aumentarNivel(Integer.parseInt(rondaText.getText()),
                eleccionRespuestaComboBox.getValue());
    }

    public void onFinalizarVoluntaramenteAction(ActionEvent event) {
            rondaAnchorPane.setVisible(false);
            jugadorAnchorPane.setVisible(false);
            insercionDatosAnchorPane.setVisible(false);
            resultadosAnchorPane.setVisible(true);
    }

    public void onListarRankinVictoriasClick(MouseEvent event) {
        String jugadores="";
        for (Jugador jugador:juego.getJugadores()) {
            jugadores+="jugador "+jugador.getNombre()+"edad "+jugador.getEdad()+"puntaje  "
                    +jugador.getPremioAcomulado()+"\n";

        }

        rankingVictoriasTextArea.setText(jugadores);
    }

    EventHandler<KeyEvent> validarNumeros = new EventHandler<KeyEvent>() {
        private boolean respuestas = false;
        private int maxLength = 10;

        @Override
        public void handle(KeyEvent event) {
            TextField temp = (TextField) event.getSource();
            if (respuestas) {
                event.consume();
            }
            if (!event.getText().matches("[0-9]") && event.getCode() != KeyCode.BACK_SPACE) {
                if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    respuestas = true;
                } else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                    respuestas = false;
                }
            }
            if (temp.getText().length() > maxLength - 1) {
                if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    respuestas = true;
                } else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
                    respuestas = false;
                }
            }
        }
    };
}