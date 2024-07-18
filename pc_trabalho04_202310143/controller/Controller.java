/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 05/06/2023
* Ultima alteracao.: 15/06/2023
* Nome.............: Controller
* Funcao...........: Controlar a logica da interface grafica da aplicacao,
*                    gerenciando as interacoes entre os elementos visuais
*                    e as threads que realizam as operacoes de leitura e escrita.
****************************************************************/

//obs: swifties = fans da taylor swift que nesse caso serao representados pelos celulares = leitores
//     albums   = albums da taylor representados pelas suas capas = escritores


//pasta do arquivo
package controller;


//importacoes necessarias para o programa
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.AlbumEscritor;
import model.SwifitieLeitor;
import javafx.scene.Node;
import javafx.application.Platform;
import javafx.event.ActionEvent;

@SuppressWarnings("unused")
public class Controller implements Initializable {
    // declarando as variaveis que se referem a interface grafica do aplicativo
    private Stage stage;
    private Scene scene;
    private Parent root;

    // declarando as imagens do botao de pause dos albums
    @FXML private ImageView pausar_album0;
    @FXML private ImageView pausar_album1;
    @FXML private ImageView pausar_album2;
    @FXML private ImageView pausar_album3;
    @FXML private ImageView pausar_album4;

    // declarando os botoes de pause dos swifties 
    @FXML private Button pausar_swiftie0;
    @FXML private Button pausar_swiftie1;
    @FXML private Button pausar_swiftie2;
    @FXML private Button pausar_swiftie3;
    @FXML private Button pausar_swiftie4;

    // declarando os sliders de carregamento dos albums  =  obtemDado()
    @FXML private Slider slider_carregamento0;
    @FXML private Slider slider_carregamento1;
    @FXML private Slider slider_carregamento2;
    @FXML private Slider slider_carregamento3;
    @FXML private Slider slider_carregamento4;

    // declarando os sliders de upload dos albums  =   escreveBaseDeDados()
    @FXML private Slider slider_upload0;
    @FXML private Slider slider_upload1;
    @FXML private Slider slider_upload2;
    @FXML private Slider slider_upload3;
    @FXML private Slider slider_upload4;

    // declarando os sliders de download dos swifties  =   leBaseDeDados()
    @FXML private Slider slider_download0;
    @FXML private Slider slider_download1;
    @FXML private Slider slider_download2;
    @FXML private Slider slider_download3;
    @FXML private Slider slider_download4;

    // declarando os sliders de reproducao dos swifties  =   utilizaDadoLido()
    @FXML private Slider slider_reproducao0;
    @FXML private Slider slider_reproducao1;
    @FXML private Slider slider_reproducao2;
    @FXML private Slider slider_reproducao3;
    @FXML private Slider slider_reproducao4;

    // declarando as imagens que representam a reproducao da musica
    @FXML private ImageView music0;
    @FXML private ImageView music1;
    @FXML private ImageView music2;
    @FXML private ImageView music3;
    @FXML private ImageView music4;

    //labels dos albums e dos swifties
    @FXML private Label label_album0;
    @FXML private Label label_album1;
    @FXML private Label label_album2;
    @FXML private Label label_album3;
    @FXML private Label label_album4;
    @FXML private Label label_swiftie0;
    @FXML private Label label_swiftie1;
    @FXML private Label label_swiftie2;
    @FXML private Label label_swiftie3;
    @FXML private Label label_swiftie4;

    //labels da playlist = banco de dados
    @FXML private Label label_0_0;
    @FXML private Label label_0_1;
    @FXML private Label label_0_2;
    @FXML private Label label_0_3;
    @FXML private Label label_0_4;
    @FXML private Label label_0_5;

    @FXML private Label label_1_0;
    @FXML private Label label_1_1;
    @FXML private Label label_1_2;
    @FXML private Label label_1_3;
    @FXML private Label label_1_4;
    @FXML private Label label_1_5;

    @FXML private Label label_2_0;
    @FXML private Label label_2_1;
    @FXML private Label label_2_2;
    @FXML private Label label_2_3;
    @FXML private Label label_2_4;
    @FXML private Label label_2_5;

    @FXML private Label label_3_0;
    @FXML private Label label_3_1;
    @FXML private Label label_3_2;
    @FXML private Label label_3_3;
    @FXML private Label label_3_4;
    @FXML private Label label_3_5;

    @FXML private Label label_4_0;
    @FXML private Label label_4_1;
    @FXML private Label label_4_2;
    @FXML private Label label_4_3;
    @FXML private Label label_4_4;
    @FXML private Label label_4_5;
    

    //declarando as progress bars dos albums e dos swifties
    @FXML private ProgressBar progress_bar_swiftie0;
    @FXML private ProgressBar progress_bar_swiftie1;
    @FXML private ProgressBar progress_bar_swiftie2;
    @FXML private ProgressBar progress_bar_swiftie3;
    @FXML private ProgressBar progress_bar_swiftie4;
    @FXML private ProgressBar progress_bar_album0;
    @FXML private ProgressBar progress_bar_album1;
    @FXML private ProgressBar progress_bar_album2;
    @FXML private ProgressBar progress_bar_album3;
    @FXML private ProgressBar progress_bar_album4;

    

    //Declarando as threads dos Albums
    private AlbumEscritor escritor_album0;
    private AlbumEscritor escritor_album1;
    private AlbumEscritor escritor_album2;
    private AlbumEscritor escritor_album3;
    private AlbumEscritor escritor_album4;

    //declarando as threads dos Swifties
    private SwifitieLeitor leitor_swiftie0;
    private SwifitieLeitor leitor_swiftie1;
    private SwifitieLeitor leitor_swiftie2;
    private SwifitieLeitor leitor_swiftie3;
    private SwifitieLeitor leitor_swiftie4;


    /* ***************************************************************
    *   declarando as variaveis de controle do semaforo
    *************************************************************** */
    // Semaforo para garantir exclusao mutua ao acessar e modificar a contagem de leitores (rc) -> 1 thread acessa por vez
    public static Semaphore mutex = new Semaphore(1); 
    //Semaforo para controlar o acesso ao recurso compartilhado (banco de dados) -> 1 thread acessa por vez
    public static Semaphore db = new Semaphore(1);
    //Contador de leitores ativos, utilizado para gerenciar o acesso ao recurso compartilhado.
    public static int rc = 0;

    /****************************************************************
   * Metodo: escrever_na_playlist
   * Funcao: metodo em que o escritor vai escrever no banco de dados 
   *         que nesse caso eh mudar as musicas da playlist
   * Parametros: int id = identificador da thread escritora
   * Retorno: void
   * Excecao: em caso de erro, uma mensagem de erro eh exibida no console
   ****************************************************************/
    public void escrever_na_playlist (int id){
      try{

        //sorteando qual das 3 labels vai ser modificada pelo escritor (sorteio de 0 a 2)
        Random random = new Random();
        int rand = random.nextInt(3);
        
        //cada escritor vai modificar labels especificas que representam as musicas de cada album
        switch(id){

          //album0 = the tortured poets department
          case 0:{
            switch (rand){
              case 0:{
                if(label_0_0.isVisible()){
                  label_0_0.setVisible(false);
                  label_0_3.setVisible(true);
                }
                else{
                  label_0_0.setVisible(true);
                  label_0_3.setVisible(false);
                }
                break;
              }
              case 1:{
                if(label_0_1.isVisible()){
                  label_0_1.setVisible(false);
                  label_0_4.setVisible(true);
                }
                else{
                  label_0_1.setVisible(true);
                  label_0_4.setVisible(false);
                }
                break;
              }
              case 2:{
                if(label_0_2.isVisible()){
                  label_0_2.setVisible(false);
                  label_0_5.setVisible(true);
                }
                else{
                  label_0_2.setVisible(true);
                  label_0_5.setVisible(false);
                }
                break;
              }
              default:{
                break;
              }
            }
            break;
          } 

          //album1 = midnights
          case 1:{
            switch (rand){
              case 0:{
                if(label_1_0.isVisible()){
                  label_1_0.setVisible(false);
                  label_1_3.setVisible(true);
                }
                else{
                  label_1_0.setVisible(true);
                  label_1_3.setVisible(false);
                }
                break;
              }
              case 1:{
                if(label_1_1.isVisible()){
                  label_1_1.setVisible(false);
                  label_1_4.setVisible(true);
                }
                else{
                  label_1_1.setVisible(true);
                  label_1_4.setVisible(false);
                }
                break;
              }
              case 2:{
                if(label_1_2.isVisible()){
                  label_1_2.setVisible(false);
                  label_1_5.setVisible(true);
                }
                else{
                  label_1_2.setVisible(true);
                  label_1_5.setVisible(false);
                }
                break;
              }
              default:{
                break;
              }
            }
            break;
          }
          
          //album2 = lover
          case 2:{
            switch (rand){
              case 0:{
                if(label_2_0.isVisible()){
                  label_2_0.setVisible(false);
                  label_2_3.setVisible(true);
                }
                else{
                  label_2_0.setVisible(true);
                  label_2_3.setVisible(false);
                }
                break;
              }
              case 1:{
                if(label_2_1.isVisible()){
                  label_2_1.setVisible(false);
                  label_2_4.setVisible(true);
                }
                else{
                  label_2_1.setVisible(true);
                  label_2_4.setVisible(false);
                }
                break;
              }
              case 2:{
                if(label_2_2.isVisible()){
                  label_2_2.setVisible(false);
                  label_2_5.setVisible(true);
                }
                else{
                  label_2_2.setVisible(true);
                  label_2_5.setVisible(false);
                }
                break;
              }
              default:{
                break;
              }
            }
            break;
          }
          
          //album3 = 1989
          case 3:{
            switch (rand){
              case 0:{
                if(label_3_0.isVisible()){
                  label_3_0.setVisible(false);
                  label_3_3.setVisible(true);
                }
                else{
                  label_3_0.setVisible(true);
                  label_3_3.setVisible(false);
                }
                break;
              }
              case 1:{
                if(label_3_1.isVisible()){
                  label_3_1.setVisible(false);
                  label_3_4.setVisible(true);
                }
                else{
                  label_3_1.setVisible(true);
                  label_3_4.setVisible(false);
                }
                break;
              }
              case 2:{
                if(label_3_2.isVisible()){
                  label_3_2.setVisible(false);
                  label_3_5.setVisible(true);
                }
                else{
                  label_3_2.setVisible(true);
                  label_3_5.setVisible(false);
                }
                break;
              }
              default:{
                break;
              }
            }
            break;
          } 

          //album4 = speak now
          case 4:{
            switch (rand){
              case 0:{
                if(label_4_0.isVisible()){
                  label_4_0.setVisible(false);
                  label_4_3.setVisible(true);
                }
                else{
                  label_4_0.setVisible(true);
                  label_4_3.setVisible(false);
                }
                break;
              }
              case 1:{
                if(label_4_1.isVisible()){
                  label_4_1.setVisible(false);
                  label_4_4.setVisible(true);
                }
                else{
                  label_4_1.setVisible(true);
                  label_4_4.setVisible(false);
                }
                break;
              }
              case 2:{
                if(label_4_2.isVisible()){
                  label_4_2.setVisible(false);
                  label_4_5.setVisible(true);
                }
                else{
                  label_4_2.setVisible(true);
                  label_4_5.setVisible(false);
                }
                break;
              }
              default:{
                break;
              }
            }
            break;
          } 
          default:{
            break;
          }
        }//fim do switch do id

      }catch(Exception e){
        System.out.println("Erro ao escrever na playlist");
        System.out.println(e.getMessage());
      }
    }




     /****************************************************************
   * Metodo: ler_na_playlist
   * Funcao: metodo em que o leitor vai ler o banco de dados que nesse 
   *         caso eh fazer o download da musica. ele entao sinaliza 
   *         por meio da variavel booleana que o leitor pode reproduzi-la
   * Parametros: int id = identificador da thread leitora
   * Retorno: void
   * Excecao: em caso de erro, uma mensagem de erro eh exibida no console
   ****************************************************************/
    public void ler_na_playlist(int id){
        try{
          switch(id){
            case 0:{
              leitor_swiftie0.musica_baixada = true;
              break;
            }
            case 1:{
              leitor_swiftie1.musica_baixada = true;
              break;
            }
            case 2:{
              leitor_swiftie2.musica_baixada = true;
              break;
            }
            case 3:{
              leitor_swiftie3.musica_baixada = true;
              break;
            }
            case 4:{
              leitor_swiftie4.musica_baixada = true;
              break;
            }
          }//fim do switch
        } catch(Exception e){
          System.out.println("Erro ao ler playlist");
          System.out.println(e.getMessage());
        }
      }

    /****************************************************************
   * Metodo: reproduzir_musica_da_playlist
   * Funcao: metodo em que o leitor vai reproduzir a musica baixada e 
   *         sinalizar que pode fazer o download novamente 
   * Parametros: int id = identificador da thread leitora
   * Retorno: void
   * Excecao: em caso de erro, uma mensagem de erro eh exibida no console
   ****************************************************************/
    public void reproduzir_musica_da_playlist(int id){
      try{
        switch(id){
          case 0:{
            leitor_swiftie0.pode_fazer_download = true;
            break;
          }
          case 1:{
            leitor_swiftie1.pode_fazer_download = true;
            break;
          }
          case 2:{
            leitor_swiftie2.pode_fazer_download = true;
            break;
          }
          case 3:{
            leitor_swiftie3.pode_fazer_download = true;
            break;
          }
          case 4:{
            leitor_swiftie4.pode_fazer_download = true;
            break;
          }
        
        }//fim do switch
      }catch(Exception e){
          System.out.println("Erro ao reproduzir musica da playlist");
          System.out.println(e.getMessage());
      }
    }




     /****************************************************************
   * Metodo: mudar_estado_album
   * Funcao: Metodo em que vai determinar o estado atual do album 
   *         (obtendo dados ou escrevendo dados).
   * Parametros: 
   *    int id - Identificador do escritor
   *    boolean estado - Indica se esta carregando dados ou fazendo
   *                     o upload
   *    boolean visible - Define a visibilidade da label do estado 
   *                     do album
   * Retorno: void
   ****************************************************************/
    public void mudar_estado_album (int id, boolean estado, boolean visible){
        switch (id){
            case 0:{
                if(visible){
                  if(estado){
                    label_album0.setText("Carregando Musica");
                    label_album0.setVisible(true);
                  }
                  else{
                    label_album0.setText("Fazendo o upload");
                    label_album0.setVisible(true);
                  }
                }
                else{
                    label_album0.setVisible(false);
                }
                break;   
              }
              case 1:{
                if(visible){
                  if(estado){
                    label_album1.setText("Carregando Musica");
                    label_album1.setVisible(true);
                  }
                  else{
                    label_album1.setText("Fazendo o upload");
                    label_album1.setVisible(true);
                  }
                }
                else{
                    label_album1.setVisible(false);
                }
                break;   
              }
              case 2:{
                if(visible){
                  if(estado){
                    label_album2.setText("Carregando Musica");
                    label_album2.setVisible(true);
                  }
                  else{
                    label_album2.setText("Fazendo o upload");
                    label_album2.setVisible(true);
                  }
                }
                else{
                    label_album2.setVisible(false);
                }
                break;   
              }
              case 3:{
                if(visible){
                  if(estado){
                    label_album3.setText("Carregando Musica");
                    label_album3.setVisible(true);
                  }
                  else{
                    label_album3.setText("Fazendo o upload");
                    label_album3.setVisible(true);
                  }
                }
                else{
                    label_album3.setVisible(false);
                }
                break;   
              }
              case 4:{
                if(visible){
                  if(estado){
                    label_album4.setText("Carregando Musica");
                    label_album4.setVisible(true);
                  }
                  else{
                    label_album4.setText("Fazendo o upload");
                    label_album4.setVisible(true);
                  }
                }
                else{
                    label_album4.setVisible(false);
                }
                break;   
              }
              default:
              break;
        }
    }


      /****************************************************************
     * Metodo: mudar_estado_swifitie
     * Funcao: Metodo em que vai determinar o estado atual do leitor 
     *         (lendo dados ou utilizando dados).
     * Parametros: 
     *    int id - Identificador do leitor
     *    boolean estado - Indica se esta fazendo o download ou reproduzindo
     *                     as musicas
     *    boolean visible - Define a visibilidade da label do estado 
     *                     do swiftie e da imagem de reproducao
     * Retorno: void
     ****************************************************************/
    public void mudar_estado_swifitie (int id, boolean estado, boolean visible){
      switch (id){
          case 0:{
              if(visible){
                if(estado){
                  music0.setVisible(false);
                  label_swiftie0.setText("Downloading");
                  label_swiftie0.setVisible(true);
                }
                else{
                  music0.setVisible(true);
                  label_swiftie0.setText("Reproduzindo");
                  label_swiftie0.setVisible(true);
                }
                
              }
              else{
                music0.setVisible(false);
                label_swiftie0.setVisible(false);
              }
              break;   
            }
            case 1:{
              if(visible){
                if(estado){
                  music1.setVisible(false);
                  label_swiftie1.setText("Downloading");
                  label_swiftie1.setVisible(true);
                }
                else{
                  music1.setVisible(true);
                  label_swiftie1.setText("Reproduzindo");
                  label_swiftie1.setVisible(true);
                }
                
              }
              else{
                music1.setVisible(false);
                label_swiftie1.setVisible(false);
              }
              break;   
            }
            case 2:{
              if(visible){
                if(estado){
                  music2.setVisible(false);
                  label_swiftie2.setText("Downloading");
                  label_swiftie2.setVisible(true);
                }
                else{
                  music2.setVisible(true);
                  label_swiftie2.setText("Reproduzindo");
                  label_swiftie2.setVisible(true);
                }
                
              }
              else{
                music2.setVisible(false);
                label_swiftie2.setVisible(false);
              }
              break;   
            }
            case 3:{
              if(visible){
                if(estado){
                  music3.setVisible(false);
                  label_swiftie3.setText("Downloading");
                  label_swiftie3.setVisible(true);
                }
                else{
                  music3.setVisible(true);
                  label_swiftie3.setText("Reproduzindo");
                  label_swiftie3.setVisible(true);
                }
                
              }
              else{
                music3.setVisible(false);
                label_swiftie3.setVisible(false);
              }
              break;   
            }
            case 4:{
              if(visible){
                if(estado){
                  music4.setVisible(false);
                  label_swiftie4.setText("Downloading");
                  label_swiftie4.setVisible(true);
                }
                else{
                  music4.setVisible(true);
                  label_swiftie4.setText("Reproduzindo");
                  label_swiftie4.setVisible(true);
                }
                
              }
              else{
                music4.setVisible(false);
                label_swiftie4.setVisible(false);
              }
              break;   
            }

            default:
            break;
      }//fim do switch
  }


    /****************************************************************
    * Metodo: mudar_semaforo_album
    * Funcao: Metodo que vai determinar o estado atual do escritor em 
    *         relacao ao semaforo (bloqueado ou nao).
    * Parametros: 
    *    int id - Identificador do album
    *    boolean visible - Define a visibilidade da label do estado 
    *                      do album
    * Retorno: void
    ****************************************************************/
    public void mudar_semaforo_album(int id, boolean visible) {
      switch (id) {
        case 0: {
            if (visible) {
                label_album0.setText("Bloqueado");
                label_album0.setVisible(true);
            } else {
                label_album0.setVisible(false);
            }
            break;
          }
          case 1: {
            if (visible) {
                label_album1.setText("Bloqueado");
                label_album1.setVisible(true);
            } else {
                label_album1.setVisible(false);
            }
            break;
          }
          case 2: {
            if (visible) {
                label_album2.setText("Bloqueado");
                label_album2.setVisible(true);
            } else {
                label_album2.setVisible(false);
            }
            break;
          }
          case 3: {
            if (visible) {
                label_album3.setText("Bloqueado");
                label_album3.setVisible(true);
            } else {
                label_album3.setVisible(false);
            }
            break;
          }
          case 4: {
            if (visible) {
                label_album4.setText("Bloqueado");
                label_album4.setVisible(true);
            } else {
                label_album4.setVisible(false);
            }
            break;
          }
        default: {
            break;
        }
    }//fim do switch
}

    /****************************************************************
    * Metodo: mudar_semaforo_swifitie
    * Funcao: Metodo que vai determinar o estado atual do leitor em 
    *         relacao ao semaforo (esperando ou nao).
    * Parametros: 
    *    int id - Identificador do album
    *    boolean visible - Define a visibilidade da label do estado 
    *                      do album
    * Retorno: void
    ****************************************************************/
    public void mudar_semaforo_swifitie(int id, boolean visible){
      switch(id){
        case 0:{
          if(visible){
            label_swiftie0.setText("Esperando");
            label_swiftie0.setVisible(true);
          }else{
            label_swiftie0.setVisible(false);
          }
          break;
        }
        case 1:{
          if(visible){
            label_swiftie1.setText("Esperando");
            label_swiftie1.setVisible(true);
          }else{
            label_swiftie1.setVisible(false);
          }
          break;
        }
        case 2:{
          if(visible){
            label_swiftie2.setText("Esperando");
            label_swiftie2.setVisible(true);
          }else{
            label_swiftie2.setVisible(false);
          }
          break;
        }
        case 3:{
          if(visible){
            label_swiftie3.setText("Esperando");
            label_swiftie3.setVisible(true);
          }else{
            label_swiftie3.setVisible(false);
          }
          break;
        }
        case 4:{
          if(visible){
            label_swiftie4.setText("Esperando");
            label_swiftie4.setVisible(true);
          }else{
            label_swiftie4.setVisible(false);
          }
          break;
        }        
        default:
          break;
      }//fim do switch
    }   
    
  @FXML // alterar elementos da interface grafica
  /****************************************************************
    * Metodo: pausar_swiftie0
    * Funcao: Metodo que vai pausar a execucao do swiftie0 mudando o texto do botao
    * Parametros: ActionEvent event - Evento associado ao botao de pausar/retomar
    * Retorno: void
    ****************************************************************/
  public void pausar_swiftie0(ActionEvent event) {
    Platform.runLater(() ->{
      if(!leitor_swiftie0.estah_pausado()){
        pausar_swiftie0.setText("Retomar");
        leitor_swiftie0.pausar(true);
      }
      else{
        pausar_swiftie0.setText("Pausar");
        leitor_swiftie0.pausar(false);
      }
    });
  }

  @FXML // alterar elementos da interface grafica
  /****************************************************************
    * Metodo: pausar_swiftie1
    * Funcao: Metodo que vai pausar a execucao do swiftie1 mudando o texto do botao
    * Parametros: ActionEvent event - Evento associado ao botao de pausar/retomar
    * Retorno: void
    ****************************************************************/
  public void pausar_swiftie1(ActionEvent event) {
    Platform.runLater(() ->{
      if(!leitor_swiftie1.estah_pausado()){
        pausar_swiftie1.setText("Retomar");
        leitor_swiftie1.pausar(true);
      }
      else{
        pausar_swiftie1.setText("Pausar");
        leitor_swiftie1.pausar(false);
      }
    });
  }

  @FXML //alterar elementos da interface grafica
  /****************************************************************
    * Metodo: pausar_swiftie2
    * Funcao: Metodo que vai pausar a execucao do swiftie2 mudando o texto do botao
    * Parametros: ActionEvent event - Evento associado ao botao de pausar/retomar
    * Retorno: void
    ****************************************************************/
  public void pausar_swiftie2(ActionEvent event) {
    Platform.runLater(() ->{
      if(!leitor_swiftie2.estah_pausado()){
        pausar_swiftie2.setText("Retomar");
        leitor_swiftie2.pausar(true);
      }
      else{
        pausar_swiftie2.setText("Pausar");
        leitor_swiftie2.pausar(false);
      }
    });
  }

  @FXML // alterar elementos da interface grafica
  /****************************************************************
    * Metodo: pausar_swiftie3
    * Funcao: Metodo que vai pausar a execucao do swiftie3 mudando o texto do botao
    * Parametros: ActionEvent event - Evento associado ao botao de pausar/retomar
    * Retorno: void
    ****************************************************************/
  public void pausar_swiftie3(ActionEvent event) {
    Platform.runLater(() ->{
      if(!leitor_swiftie3.estah_pausado()){
        pausar_swiftie3.setText("Retomar");
        leitor_swiftie3.pausar(true);
      }
      else{
        pausar_swiftie3.setText("Pausar");
        leitor_swiftie3.pausar(false);
      }
    });
  }

  @FXML // alterar elementos da interface grafica
  /****************************************************************
    * Metodo: pausar_swiftie4
    * Funcao: Metodo que vai pausar a execucao do swiftie4 mudando o texto do botao
    * Parametros: ActionEvent event - Evento associado ao botao de pausar/retomar
    * Retorno: void
    ****************************************************************/
  public void pausar_swiftie4(ActionEvent event) {
    Platform.runLater(() ->{
      if(!leitor_swiftie4.estah_pausado()){
        pausar_swiftie4.setText("Retomar");
        leitor_swiftie4.pausar(true);
      }
      else{
        pausar_swiftie4.setText("Pausar");
        leitor_swiftie4.pausar(false);
      }
    });
  }


  @FXML // alterar elementos da interface grafica
  /****************************************************************
    * Metodo: pausar_album0
    * Funcao: Metodo que vai pausar a execucao do album0 mudando a imagem do botao
    * Parametros: MouseEvent event - Evento de clique do mouse
    * Retorno: void
    ****************************************************************/
  public void pausar_album0(MouseEvent event) {
    Platform.runLater(()->{
      if(!escritor_album0.estah_pausado()){
        pausar_album0.setImage(new Image("/img/play.png"));
        escritor_album0.pausar(true);
      }
      else{
        pausar_album0.setImage(new Image("/img/stop.png"));
        escritor_album0.pausar(false);
      }
    });
  }

  @FXML //alterar elementos da interface grafica
  /****************************************************************
    * Metodo: pausar_album1
    * Funcao: Metodo que vai pausar a execucao do album1 mudando a imagem do botao
    * Parametros: MouseEvent event - Evento de clique do mouse
    * Retorno: void
    ****************************************************************/
  public void pausar_album1(MouseEvent event) {
    Platform.runLater(()->{
      if(!escritor_album1.estah_pausado()){
        pausar_album1.setImage(new Image("/img/play.png"));
        escritor_album1.pausar(true);
      }
      else{
        pausar_album1.setImage(new Image("/img/stop.png"));
        escritor_album1.pausar(false);
      }
    });
  }

  @FXML //alterar elementos da interface grafica
  /****************************************************************
    * Metodo: pausar_album2
    * Funcao: Metodo que vai pausar a execucao do album2 mudando a imagem do botao
    * Parametros: MouseEvent event - Evento de clique do mouse
    * Retorno: void
    ****************************************************************/
  public void pausar_album2(MouseEvent event) {
    Platform.runLater(()->{
      if(!escritor_album2.estah_pausado()){
        pausar_album2.setImage(new Image("/img/play.png"));
        escritor_album2.pausar(true);
      }
      else{
        pausar_album2.setImage(new Image("/img/stop.png"));
        escritor_album2.pausar(false);
      }
    });
  }

  @FXML //alterar elementos da interface grafica
  /****************************************************************
    * Metodo: pausar_album3
    * Funcao: Metodo que vai pausar a execucao do album3 mudando a imagem do botao
    * Parametros: MouseEvent event - Evento de clique do mouse
    * Retorno: void
    ****************************************************************/
  public void pausar_album3(MouseEvent event) {
    Platform.runLater(()->{
      if(!escritor_album3.estah_pausado()){
        pausar_album3.setImage(new Image("/img/play.png"));
        escritor_album3.pausar(true);
      }
      else{
        pausar_album3.setImage(new Image("/img/stop.png"));
        escritor_album3.pausar(false);
      }
    });
  }

  @FXML // alterar elementos da interface grafica
  /****************************************************************
    * Metodo: pausar_album4
    * Funcao: Metodo que vai pausar a execucao do album4 mudando a imagem do botao
    * Parametros: MouseEvent event - Evento de clique do mouse
    * Retorno: void
    ****************************************************************/
  public void pausar_album4(MouseEvent event) {
    Platform.runLater(()->{
      if(!escritor_album4.estah_pausado()){
        pausar_album4.setImage(new Image("/img/play.png"));
        escritor_album4.pausar(true);
      }
      else{
        pausar_album4.setImage(new Image("/img/stop.png"));
        escritor_album4.pausar(false);
      }
    });
  }


    @FXML // alterar elementos da interface grafica
    /****************************************************************
     * Metodo: reset
     * Funcao:botao que reseta 
     * Parametros: event - evento que acionou o metodo
     * Retorno: void
     ****************************************************************/
    public void reset(ActionEvent event) {
      System.out.println("\n\nRESET\n\n");

      //resetando o valor de todos os fora da parte grafica para que as thread recomecem com o mesmo tempo de execucao
      slider_carregamento0.setValue(50);
      slider_carregamento1.setValue(50);
      slider_carregamento2.setValue(50);
      slider_carregamento3.setValue(50);
      slider_carregamento4.setValue(50);
      slider_upload0.setValue(50);
      slider_upload1.setValue(50);
      slider_upload2.setValue(50);
      slider_upload3.setValue(50);
      slider_upload4.setValue(50);
      slider_download0.setValue(50);
      slider_download1.setValue(50);
      slider_download2.setValue(50);
      slider_download3.setValue(50);
      slider_download4.setValue(50);
      slider_reproducao0.setValue(50);
      slider_reproducao1.setValue(50);
      slider_reproducao2.setValue(50);
      slider_reproducao3.setValue(50);

      // Desativa os escritores e leitores atuais
      escritor_album0.desativa(true);
      escritor_album1.desativa(true);
      escritor_album2.desativa(true);
      escritor_album3.desativa(true);
      escritor_album4.desativa(true);
      leitor_swiftie0.desativa(true);
      leitor_swiftie1.desativa(true);
      leitor_swiftie2.desativa(true);
      leitor_swiftie3.desativa(true);
      leitor_swiftie4.desativa(true);
  

      // Resetando a interface grafica 
      Platform.runLater(()-> {

        //ocultando as progress bars
        progress_bar_album0.setVisible(false);
        progress_bar_album1.setVisible(false);
        progress_bar_album2.setVisible(false);
        progress_bar_album3.setVisible(false);
        progress_bar_album4.setVisible(false);
        progress_bar_swiftie0.setVisible(false);
        progress_bar_swiftie1.setVisible(false);
        progress_bar_swiftie2.setVisible(false);
        progress_bar_swiftie3.setVisible(false);
        progress_bar_swiftie4.setVisible(false);

        //ocultando as imagens de reproducao
        music0.setVisible(false);
        music1.setVisible(false);
        music2.setVisible(false);
        music3.setVisible(false);
        music4.setVisible(false);

        // define a imagem inicial do botao pausar_album 
        pausar_album0.setImage(new Image("/img/stop.png"));
        pausar_album1.setImage(new Image("/img/stop.png"));
        pausar_album2.setImage(new Image("/img/stop.png"));
        pausar_album3.setImage(new Image("/img/stop.png"));
        pausar_album4.setImage(new Image("/img/stop.png"));

        // define o texto inicial do botao pausar_swiftie 
        pausar_swiftie0.setText("Pausar");
        pausar_swiftie1.setText("Pausar");
        pausar_swiftie2.setText("Pausar");
        pausar_swiftie3.setText("Pausar");
        pausar_swiftie4.setText("Pausar");
    

        //resetando o valor de todos os sliders
        slider_carregamento0.setValue(50);
        slider_carregamento1.setValue(50);
        slider_carregamento2.setValue(50);
        slider_carregamento3.setValue(50);
        slider_carregamento4.setValue(50);
        slider_upload0.setValue(50);
        slider_upload1.setValue(50);
        slider_upload2.setValue(50);
        slider_upload3.setValue(50);
        slider_upload4.setValue(50);
        slider_download0.setValue(50);
        slider_download1.setValue(50);
        slider_download2.setValue(50);
        slider_download3.setValue(50);
        slider_download4.setValue(50);
        slider_reproducao0.setValue(50);
        slider_reproducao1.setValue(50);
        slider_reproducao2.setValue(50);
        slider_reproducao3.setValue(50);
        slider_reproducao4.setValue(50);

        //resetando as labels dos albums
        label_album0.setVisible(false);
        label_album1.setVisible(false);
        label_album2.setVisible(false);
        label_album3.setVisible(false);
        label_album4.setVisible(false);

        //resetando as labels dos swifties
        label_swiftie0.setVisible(false);
        label_swiftie1.setVisible(false);
        label_swiftie2.setVisible(false);
        label_swiftie3.setVisible(false);
        label_swiftie4.setVisible(false);
        

        //resetando as labels do banco de dados
        label_0_0.setVisible(true);
        label_0_1.setVisible(true);
        label_0_2.setVisible(true);
        label_0_3.setVisible(false);
        label_0_4.setVisible(false);
        label_0_5.setVisible(false);
        label_1_0.setVisible(true);
        label_1_1.setVisible(true);
        label_1_2.setVisible(true);
        label_1_3.setVisible(false);
        label_1_4.setVisible(false);
        label_1_5.setVisible(false);
        label_2_0.setVisible(true);
        label_2_1.setVisible(true);
        label_2_2.setVisible(true);
        label_2_3.setVisible(false);
        label_2_4.setVisible(false);
        label_2_5.setVisible(false);
        label_3_0.setVisible(true);
        label_3_1.setVisible(true);
        label_3_2.setVisible(true);
        label_3_3.setVisible(false);
        label_3_4.setVisible(false);
        label_3_5.setVisible(false);
        label_4_0.setVisible(true);
        label_4_1.setVisible(true);
        label_4_2.setVisible(true);
        label_4_3.setVisible(false);
        label_4_4.setVisible(false);
        label_4_5.setVisible(false);
  
    });//fim da parte grafica


    //reiniciando os semaforos 
    mutex = new Semaphore(1);
    db = new Semaphore(1);
    rc = 0;

    //cria novas instancias das threads
    escritor_album0 = new AlbumEscritor(this, 0 , slider_carregamento0, slider_upload0, progress_bar_album0);
    escritor_album1 = new AlbumEscritor(this, 1 , slider_carregamento1, slider_upload1, progress_bar_album1);
    escritor_album2 = new AlbumEscritor(this, 2 , slider_carregamento2, slider_upload2, progress_bar_album2);
    escritor_album3 = new AlbumEscritor(this, 3 , slider_carregamento3, slider_upload3, progress_bar_album3);
    escritor_album4 = new AlbumEscritor(this, 4 , slider_carregamento4, slider_upload4, progress_bar_album4);
    leitor_swiftie0 = new SwifitieLeitor(this, 0 , slider_download0, slider_reproducao0, progress_bar_swiftie0);
    leitor_swiftie1 = new SwifitieLeitor(this, 1 , slider_download1, slider_reproducao1, progress_bar_swiftie1);
    leitor_swiftie2 = new SwifitieLeitor(this, 2 , slider_download2, slider_reproducao2, progress_bar_swiftie2);
    leitor_swiftie3 = new SwifitieLeitor(this, 3 , slider_download3, slider_reproducao3, progress_bar_swiftie3);
    leitor_swiftie4 = new SwifitieLeitor(this, 4 , slider_download4, slider_reproducao4, progress_bar_swiftie4);

    //inicia as threads
    escritor_album0.start();
    escritor_album1.start();
    escritor_album2.start();
    escritor_album3.start();
    escritor_album4.start();
    leitor_swiftie0.start();
    leitor_swiftie1.start();
    leitor_swiftie2.start();
    leitor_swiftie3.start();
    leitor_swiftie4.start();
    }

    @Override
    /****************************************************************
     * Metodo: initialize
     * Funcao: inicializa o controlador carregando as threads
     * Parametros: URL location - localização do arquivo FXML
 *                 ResourceBundle resources - recursos associados ao arquivo FXML
     * Retorno: void
     ****************************************************************/
    public void initialize(URL location, ResourceBundle resources) {
      //instanciando as threads
      escritor_album0 = new AlbumEscritor(this, 0 , slider_carregamento0, slider_upload0, progress_bar_album0);
      escritor_album1 = new AlbumEscritor(this, 1 , slider_carregamento1, slider_upload1, progress_bar_album1);
      escritor_album2 = new AlbumEscritor(this, 2 , slider_carregamento2, slider_upload2, progress_bar_album2);
      escritor_album3 = new AlbumEscritor(this, 3 , slider_carregamento3, slider_upload3, progress_bar_album3);
      escritor_album4 = new AlbumEscritor(this, 4 , slider_carregamento4, slider_upload4, progress_bar_album4);
      leitor_swiftie0 = new SwifitieLeitor(this, 0 , slider_download0, slider_reproducao0, progress_bar_swiftie0);
      leitor_swiftie1 = new SwifitieLeitor(this, 1 , slider_download1, slider_reproducao1, progress_bar_swiftie1);
      leitor_swiftie2 = new SwifitieLeitor(this, 2 , slider_download2, slider_reproducao2, progress_bar_swiftie2);
      leitor_swiftie3 = new SwifitieLeitor(this, 3 , slider_download3, slider_reproducao3, progress_bar_swiftie3);
      leitor_swiftie4 = new SwifitieLeitor(this, 4 , slider_download4, slider_reproducao4, progress_bar_swiftie4);

      //inicia as threads
      escritor_album0.start();
      escritor_album1.start();
      escritor_album2.start();
      escritor_album3.start();
      escritor_album4.start();
      leitor_swiftie0.start();
      leitor_swiftie1.start();
      leitor_swiftie2.start();
      leitor_swiftie3.start();
      leitor_swiftie4.start();
    }
}