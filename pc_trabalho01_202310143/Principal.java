
/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 22/03/2023
* Ultima alteracao.: 11/04/2023
* Nome.............: Principal
* Funcao...........: Inicia o aplicativo JavFX definindo uma classe que extende Applicatin, necessaria para a criacao de uma interface grafica
****************************************************************/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

// import dos controllers o diretorio do controller 
import controller.Controller;
import controller.ControllerPrincipal;

/* ***************************************************************
* Classe principal que estende Aplication, classe necessaria para a construcao da GUI
*************************************************************** */
public class Principal extends Application {

  /*
   * ***************************************************************
   * Metodo: main
   * Funcao: ponto de entrada do programa
   * Parametros: args - recebe dados linha de comando
   * Retorno: void
   */
  public static void main(String[] args) {
    launch(args); // inicia a aplicacao javafx
  }

  /*
   * ***************************************************************
   * Metodo: start
   * Funcao: ponto de partida das configuracoes de interface grafica
   * Parametros: stage - a janela principal do aplicativo
   * Retorno: void
   */
  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("view/fxmlPrincipal.fxml"));
    Scene scene = new Scene(root); // cria a cena da janela principal
    String css = this.getClass().getResource("view/style.css").toExternalForm();
    scene.getStylesheets().add(css);

    Image icon = new Image("img/icon.png"); // pega uma imagem no endereco dado que sera o icon da aplicacao
    stage.getIcons().add(icon); // adiciona essa imagem ao icon do stage

    stage.setTitle("Trenzinhos (Vertical edition)"); // define o titulo da aplicacao

    // Define que o tamanho da tela nao pode ser redimensionado
    stage.setResizable(false);

    // configura a tela a ser exibida
    stage.setScene(scene); 
    // exibe a tela
    stage.show(); 
  }
}