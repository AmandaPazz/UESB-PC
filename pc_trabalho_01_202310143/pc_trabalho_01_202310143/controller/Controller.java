/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 22/03/2023
* Ultima alteracao.: 11/04/2023
* Nome.............: Controller
* Funcao...........: Funciona como o controlador dos elementos da pagina inicial do aplicativo
****************************************************************/

package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // inicializando as choiceBoxes
    @FXML
    private ChoiceBox<String> choiceBoxBlue = new ChoiceBox<>();;
    @FXML
    private ChoiceBox<String> choiceBoxRed = new ChoiceBox<>();;

    // declarando a variavel estatica da escolha da posicao dos trens nos trilhos
    public static int escolhaPosicao;

    // declarando as variaveis que se referem a interface grafica do aplicativo
    private Stage stage;
    private Scene scene;
    private Parent root;

    /****************************************************************
     * Metodo: getPosicaoRed
     * Funcao: obtem a posicao escolhida para o trem vermelho
     * Parametros: event - evento que acionou o metodo
     * Retorno: String - posicao escolhida para o trem vermelho
     ****************************************************************/
    public String getPosicaoRed(ActionEvent event) {
        return choiceBoxRed.getValue();
    }

    /****************************************************************
     * Metodo: getPosicaoBlue
     * Funcao: obtem a posicao escolhida para o trem azul
     * Parametros: event - evento que acionou o metodo
     * Retorno: String - posicao escolhida para o trem azul
     ****************************************************************/
    public String getPosicaoBlue(ActionEvent event) {
        return choiceBoxBlue.getValue();
    }

    /****************************************************************
     * Metodo: setPosicao
     * Funcao: determina e atribui a posicao dos trens nos trilhos a partir da
     * escolha das choiceBoxes da tela inicial
     * * Parametros: void
     * Retorno: void
     ****************************************************************/
    public void setPosicao() {
        if (choiceBoxRed.getValue().equals("Em cima") && choiceBoxBlue.getValue().equals("Em cima")) {
            escolhaPosicao = 1;
        } else if (choiceBoxRed.getValue().equals("Em cima") && choiceBoxBlue.getValue().equals("Embaixo")) {
            escolhaPosicao = 2;
        } else if (choiceBoxRed.getValue().equals("Embaixo") && choiceBoxBlue.getValue().equals("Em cima")) {
            escolhaPosicao = 3;
        } else if (choiceBoxRed.getValue().equals("Embaixo") && choiceBoxBlue.getValue().equals("Embaixo")) {
            escolhaPosicao = 4;
        }//fim dos ifs
    }

    /****************************************************************
     * Metodo: getEscolhaPosicao
     * Funcao: obtem a posicao escolhida dos trems
     * * Parametros: void
     * Retorno: a posicao escolhida em forma de um inteiro de 1 a 4
     ****************************************************************/
    static public int getEscolhaPosicao() {
        return escolhaPosicao;
    }
/****************************************************************
 * Metodo: play
 * Funcao: descreve as instrucoes para o botao play
 * Parametros: event - evento que acionou o metodo
 * Retorno: void
 * Excecoes: IOException - excecao de entrada e saida
 ****************************************************************/
    @FXML
    public void play(ActionEvent event) throws IOException {
        setPosicao();
        System.out.println("\n\nPLAY *************************");
        System.out.println("POSICAO RED: " + getPosicaoRed(event));
        System.out.println("POSICAO BLUE: " + getPosicaoBlue(event));
        System.out.println(Controller.getEscolhaPosicao());
        System.out.println("\n\n");
        root = FXMLLoader.load(getClass().getResource("../view/fxmlMap.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

/****************************************************************
 * Metodo: initialize
 * Funcao: inicializa a interface grafica e configura o estado inicial dos elementos
 * Parametros: location - a localizacao do objeto a ser inicializado
               resources - os recursos a serem usados para localizar o objeto
 * Retorno: void
 ****************************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceBoxRed.getItems().addAll("Em cima", "Embaixo");
        choiceBoxBlue.getItems().addAll("Em cima", "Embaixo");

        choiceBoxRed.getSelectionModel().selectFirst();
        choiceBoxBlue.getSelectionModel().selectFirst();

    }

}
