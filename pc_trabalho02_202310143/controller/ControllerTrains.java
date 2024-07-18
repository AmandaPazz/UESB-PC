/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 22/03/2023
* Ultima alteracao.: 01/05/2023
* Nome.............: ControllerTrains
* Funcao...........: Funciona como o controlador dos elementos da cena que contem os trens
****************************************************************/

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.ThreadTrainRed;
import model.ThreadTrainBlue;

public class ControllerTrains implements Initializable {

  // declaracao das imagens dos trens de acordo com o id escolhido
  @FXML
  private ImageView TrainRed;
  @FXML
  private ImageView TrainBlue;

  // declaracao dos sliders de velocidade de acordo com o id escolhido
  @FXML
  private Slider sliderRed;
  @FXML
  private Slider sliderBlue;

  // declaraca objetos da classe trem: tr = TrainRed; tb = TrainBlue
  private ThreadTrainRed tr;
  private ThreadTrainBlue tb;
  
   /****************************************************************
     * Metodo: getTrainRed
     * Funcao: Retorna a imagem do trem vermelho
     * Parametros: void
     * Retorno: ImageView - imagem do trem vermelho
     ****************************************************************/
  public ImageView getTrainRed() {
    return TrainRed;
  }

  /****************************************************************
     * Metodo: getTrainBlue
     * Funcao: Retorna a imagem do trem azul
     * Parametros: void
     * Retorno: ImageView - imagem do trem azul
     ****************************************************************/
  public ImageView getTrainBlue() {
    return TrainBlue;
  }
/****************************************************************
     * Metodo: home
     * Funcao:botao que volta ate a tela principal
     * Parametros: event - evento que acionou o metodo
     * Retorno: void
     * Excecoes: IOException - excecao de entrada e saida
     ****************************************************************/
  @FXML
  public void home(ActionEvent event) throws IOException {
    System.out.println("HOME");
    Parent root = FXMLLoader.load(getClass().getResource("../view/fxmlPrincipal.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    stage.setOnCloseRequest(e -> System.exit(0)); //encerra a thread
  }

  /****************************************************************
     * Metodo: reset
     * Funcao:botao que reseta a animacao dos trens a partir do carregamento de uma nova stage
     * Parametros: event - evento que acionou o metodo
     * Retorno: void
     * Excecoes: IOException - excecao de entrada e saida
     ****************************************************************/
  @FXML
  public void reset(ActionEvent event) throws IOException {
    System.out.println("RESET");
    Parent root = FXMLLoader.load(getClass().getResource("../view/fxmlMap.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  
  }

  /****************************************************************
 * Metodo: initialize
 * Funcao: inicializa a interface grafica e configura o estado dos elementos na cena dos trilhos
 * Parametros: location - a localizacao do objeto a ser inicializado
 *             resources - os recursos a serem usados para localizar o objeto
 * Retorno: void
 ****************************************************************/
  @Override
  public void initialize(URL location, ResourceBundle resources) {

    // Configurando os trens a partir de suas posicoes iniciais e do endereco da imagem
    switch (ControllerInicio.getEscolhaPosicao()) {
      case 1: {
        tr = new  ThreadTrainRed(TrainRed, 1, sliderRed);
        tb = new ThreadTrainBlue(TrainBlue, 2, sliderBlue);
        break;
      }
      case 2: {
        tr = new ThreadTrainRed(TrainRed, 1, sliderRed);
        tb = new ThreadTrainBlue(TrainBlue, 4, sliderBlue);
        break;
      }
      case 3: {
        tr = new ThreadTrainRed(TrainRed, 3, sliderRed);
        tb = new ThreadTrainBlue(TrainBlue, 2, sliderBlue);
        break;
      }
      case 4: {
        tr = new ThreadTrainRed(TrainRed, 3, sliderRed);
        tb = new ThreadTrainBlue(TrainBlue, 4, sliderBlue);
        break;
      }
      default:
        break;
    }// fim do switch

     // Inicia as threads dos trens
    tr.start();
    tb.start();
  }
}

