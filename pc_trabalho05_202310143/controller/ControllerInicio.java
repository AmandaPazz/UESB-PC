/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 24/06/2023
* Ultima alteracao.: 15/06/2023
* Nome.............: ControllerInicio
* Funcao...........: Controla a funcao do botao play chamando o cena principal do programa
****************************************************************/

package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerInicio{

    //Variaveis necessarias para configurar e manipular a interface grafica da aplicacao
    private Stage stage;
    private Scene scene;
    private Parent root;



    /****************************************************************
     * Metodo: play
     * Funcao: inicia a simulacao do transito autonomo
     * Parametros: event - evento que acionou o metodo
     * Retorno: void
     * Excecoes: IOException - excecao de entrada e saida
     ****************************************************************/
    @FXML
    public void play(ActionEvent event) throws IOException {
        System.out.println("\n\nPLAY\n\n");

        //chama o arquivo fxml da cena princiapl do programa
        root = FXMLLoader.load(getClass().getResource("../view/fxmlPrincipal.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
