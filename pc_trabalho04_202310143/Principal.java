/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 05/06/2023
* Ultima alteracao.: 15/06/2023
* Nome.............: Principal
* Funcao...........: Inicia o aplicativo JavFX definindo uma classe que extende Application, necessaria para a criacao de uma interface grafica
****************************************************************/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.Controller;
import controller.ControllerInfo;

/* ***************************************************************
* Classe principal que estende Aplication, classe necessaria para a construcao da GUI
*************************************************************** */
@SuppressWarnings("unused")
public class Principal extends Application {
  /****************************************************************
   * Metodo: start
   * Funcao: ponto de partida das configuracoes de interface grafica
   * Parametros: stage - a janela principal do aplicativo
   * Retorno: void
   ****************************************************************/
  @Override
  public void start(Stage stage) throws Exception {

    try{
      // Carrega o layout inicial da aplicacao a partir do arquivo FXML
    Parent root = FXMLLoader.load(getClass().getResource("view/fxmlInicio.fxml"));

    // cria a cena da janela principal
    Scene scene = new Scene(root); 

    // Carrega o arquivo CSS para estilizar a aplicacao numa variavel string 
    String css = this.getClass().getResource("view/style.css").toExternalForm();

    // Adiciona o arquivo CSS a cena
    scene.getStylesheets().add(css);

    // Pega uma imagem no endereco dado que sera o icon da aplicacao
    Image icon = new Image("img/icon.png"); 

    // Adiciona essa imagem ao icon do stage
    stage.getIcons().add(icon); 

    // Define o titulo da aplicacao
    stage.setTitle("Swiftify"); 

    // Define que o tamanho da tela nao pode ser redimensionado
    stage.setResizable(false);

    // configura a tela a ser exibida
    stage.setScene(scene);
    
    // exibe a tela
    stage.show();

    //encerra as threads
    stage.setOnCloseRequest(e -> System.exit(0));

    }catch (Exception e) {
      e.printStackTrace();
  }
    
  }

  /****************************************************************
   * Metodo: main
   * Funcao: ponto de entrada do programa
   * Parametros: args - recebe dados linha de comando
   * Retorno: void
   ****************************************************************/
  public static void main(String[] args) {
    launch(args); // inicia a aplicacao javafx
  }
}
