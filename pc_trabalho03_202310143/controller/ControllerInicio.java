/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 22/03/2023
* Ultima alteracao.: 26/05/2023
* Nome.............: ControllerInicio
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

public class ControllerInicio implements Initializable {

    // inicializando as choiceBoxes
    @FXML
    private ChoiceBox<String> choiceBoxBlue = new ChoiceBox<>();;
    @FXML
    private ChoiceBox<String> choiceBoxRed = new ChoiceBox<>();;
    @FXML
    private ChoiceBox<String> choiceBoxYellow = new ChoiceBox<>();;

    // declarando a variavel estatica da escolha da posicao dos trens nos trilhos
    public static int escolhaPosicao;
    // declarando a variavel estatica da escolha do tipo de exclusao mutua
    public static int escolhaExclusao;

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
     * Metodo: getExclusao
     * Funcao: obtem a solucao escolhida para a solucao da exclusao mutua
     * Parametros: event - evento que acionou o metodo
     * Retorno: String - tipo de solucao escolhida
     ****************************************************************/
    public String getExclusao(ActionEvent event){
        return choiceBoxYellow.getValue();
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
     * Metodo: setExclusao
     * Funcao: determina e atribui o tipo de solucao da exclusao 
       mutua a partir da escolha da choiceBox da tela inicial
     * Parametros: void
     * Retorno: void
     ****************************************************************/
    public void setExclusao(){
        if(choiceBoxYellow.getValue().equals("Variavel de Travamento")){
            escolhaExclusao = 1;
        }
        else if(choiceBoxYellow.getValue().equals("Estrita Alternancia")){
            escolhaExclusao = 2;
        }
        else{
            escolhaExclusao = 3;
        }
    }

    /****************************************************************
     * Metodo: getEscolhaExclusao
     * Funcao: obtem a solucao escolhida
     * Parametros: void
     * Retorno: a solucao escolhida em forma de um inteiro de 1 a 3
     ****************************************************************/
    public int  getEscolhaExclusao() {
        return escolhaExclusao;
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
        // Chama os metodos para definir a exclusao mutua e a posicao dos trens 
        setExclusao();
        setPosicao();

        //Controle da situacao a partir do print no terminal
        System.out.println("\n\nPLAY *************************");
        System.out.println("POSICAO RED: " + getPosicaoRed(event));
        System.out.println("POSICAO BLUE: " + getPosicaoBlue(event));
        System.out.println("POSICAO FINAL:" + getEscolhaPosicao());
        System.out.println("SOLUCAO: " + getExclusao(event));
        System.out.println("SOLUCAO FINAL: " + escolhaExclusao);
        System.out.println("\n\n");

        //Carrega o novo layout da cena que contem os trens a partir do arquivo FXML
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

        //Adiciona as opcoes para as choiceBoxes
        choiceBoxRed.getItems().addAll("Em cima", "Embaixo");
        choiceBoxBlue.getItems().addAll("Em cima", "Embaixo");
        choiceBoxYellow.getItems().addAll("Variavel de Travamento", "Estrita Alternancia", "Solucao de Peterson");


        //Coloca a primeira opcao como default
        choiceBoxRed.getSelectionModel().selectFirst();
        choiceBoxBlue.getSelectionModel().selectFirst();
        choiceBoxYellow.getSelectionModel().selectFirst();

    }

}
