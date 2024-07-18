/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 22/03/2023
* Ultima alteracao.: 11/04/2023
* Nome.............: ControllerPrincipal
* Funcao...........: Funciona como o controlador dos elementos da pagina principal do aplicativo (cena que contem os trens)
****************************************************************/

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
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

//importando os modelos do train que contruirao a animacao
import model.Trains;
import model.TrainsAnimation;

public class ControllerPrincipal implements Initializable {

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
  private Trains tr, tb;

  // inicializando a classe TrainsAnimation que vai controlar a animacao dos trens
  TrainsAnimation animacao = new TrainsAnimation();

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
    switch (Controller.getEscolhaPosicao()) {
      case 1: {
        tr = new Trains(TrainRed, 1);
        tb = new Trains(TrainBlue, 2);
        break;
      }
      case 2: {
        tr = new Trains(TrainRed, 1);
        tb = new Trains(TrainBlue, 4);
        break;
      }
      case 3: {
        tr = new Trains(TrainRed, 3);
        tb = new Trains(TrainBlue, 2);
        break;
      }
      case 4: {
        tr = new Trains(TrainRed, 3);
        tb = new Trains(TrainBlue, 4);
        break;
      }
      default:
        break;
    }// fim do switch

     // Inicia a animacao dos trens
    iniciar.start();
  }

  //Inicializa o timer da animacao principal
  AnimationTimer iniciar = new AnimationTimer() {

    /****************************************************************
     * Metodo: handle
     * Funcao: Controla o tipo animacao de acordo com a posicao dos trens
     * Parametros: now - tempo atual
     * Retorno: void
     ****************************************************************/
    @Override
    public void handle(long now) {
      switch (Controller.getEscolhaPosicao()) {
        case 1: {
          animacao1.start();
          break;
        }
        case 2: {
          animacao2.start();
          break;
        }
        case 3: {
          animacao3.start();
          break;
        }
        case 4: {
          animacao4.start();
          break;
        }
        default:
          break;
      }//fim do switch
    }
  };

   // inicializa o Timer de animacao do cenario 1 (em cima / em cima)
  AnimationTimer animacao1 = new AnimationTimer() {

    @Override
    public void handle(long now) {
      //determina a velocidade do eixo x a partir do slider de velocidade
      tr.setSpeedX(sliderRed.getValue());
      tr.setSpeedY(sliderRed.getValue());

      //determina a velocidade do eixo y a partir do slider  de velocidade
      tb.setSpeedX(sliderBlue.getValue());
      tb.setSpeedY(sliderBlue.getValue());

      //Executa a animacao especifica do caso 1, passando os objetos dos trens como parâmetros
      animacao.animacao1(tr, tb);
    }
  };

// inicializa o Timer de animacao do cenario 2 (em cima / embaixo)
  AnimationTimer animacao2 = new AnimationTimer() {
    @Override
    public void handle(long now) {
      tr.setSpeedX(sliderRed.getValue());
      tr.setSpeedY(sliderRed.getValue());
      tb.setSpeedX(sliderBlue.getValue());
      tb.setSpeedY(sliderBlue.getValue());
      animacao.animacao2(tr, tb);
    }

  };
// inicializa o Timer de animacao do cenario 3 (embaixo / em cima)
  AnimationTimer animacao3 = new AnimationTimer() {
    @Override
    public void handle(long now) {
      tr.setSpeedX(sliderRed.getValue());
      tr.setSpeedY(sliderRed.getValue());
      tb.setSpeedX(sliderBlue.getValue());
      tb.setSpeedY(sliderBlue.getValue());
      animacao.animacao3(tr, tb);
    }

  };

  // inicializa o Timer de animacao do cenario 4 (embaixo / embaixo)
  AnimationTimer animacao4 = new AnimationTimer() {
    @Override
    public void handle(long now) {
      tr.setSpeedX(sliderRed.getValue());
      tr.setSpeedY(sliderRed.getValue());
      tb.setSpeedX(sliderBlue.getValue());
      tb.setSpeedY(sliderBlue.getValue());
      animacao.animacao4(tr, tb);
    }

  };


}