/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 05/06/2023
* Ultima alteracao.: 15/06/2023
* Nome.............: AlbumEscritor
* Funcao...........: Determina a logica a ser executada pelo escritor
****************************************************************/

//pasta do arquivo
package model;

//importacoes necessarias para o programa
import controller.Controller;
import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;



public class AlbumEscritor extends Thread {

  //variaveis do objeto que sao especificas de cada thread e passadas pelo construtor
  private Controller controller;
  private int id;
  private Slider carregando_musica_slider;
  private Slider fazendo_upload_slider;
  private ProgressBar progressBar;

  //flag para indicar se a thread esta em espera
  public boolean esperando = false;
  //flag para inficar se a thread esta pausada
  private boolean pausado = false;
  //flag para indicar se a thread foi desativada
  private boolean desativa = false;

  //construtor do escritor
  public AlbumEscritor(Controller controller, int id, Slider carregando_musica_slider, Slider fazendo_upload_slider,ProgressBar progressBar) {
    this.controller = controller;
    this.id = id;
    this.carregando_musica_slider = carregando_musica_slider;
    this.fazendo_upload_slider = fazendo_upload_slider;
    this.progressBar = progressBar;
  }


  /****************************************************************
    * Metodo: desativa
    * Funcao: Metodo que vai desativar e encerrar a thread 
    * Parametros: boolan desativa (true desativa)
    * Retorno: void
    ****************************************************************/
  public void desativa(boolean desativa) {
    this.desativa = desativa;
  }

  /****************************************************************
 * Metodo: estah_pausado
 * Funcao: Retorna o estado de pausa atual.
 * Parametros: void
 * Retorno: boolean - true se está pausado, false caso contrario
 ****************************************************************/
  public boolean estah_pausado() {
    return pausado;
  }


  /****************************************************************
 * Metodo: pausar
 * Funcao: Define o estado de pausa da instancia.
 * Parametros: boolean pausado - true para pausar, false para retomar
 * Retorno: void
 ****************************************************************/
  public void pausar(boolean pausado) {
    this.pausado = pausado;
  }

  /****************************************************************
    * Metodo: getSpeed
    * Funcao: Metodo que vai calcular a velocidade da thread a partir do
    *         valor do slider
    * Parametros: Slider slider - o slider que determina a velocidade da thread.
    * Retorno: int album_speed - a velocidade calculada da thread
    ****************************************************************/
    public int getSpeed(Slider slider) {
      double temp = slider.getValue();
      // Inverter a logica de mapeamento para que um valor maior no slider resulte em uma velocidade menor
      int album_speed = (int) ((slider.getMax() - temp + slider.getMin()) * 50);
      //retorna a velocidade em inteiro pra determinar a animacao da thread
      return album_speed;
  }


  @Override
  /****************************************************************
   * Metodo: run
   * Funcao: Define o comportamento da thread durante sua execucao
   * Parametros: Nenhum
   * Retorno: void
   ****************************************************************/
  public void run() {
    //loop que garante que a thread fique executando continuamnete a menos que a interrupcao seja acionada
    while (true) {
      try {
        if (desativa) {
            break;
          }

        // Loop interno que aguarda indefinidamente enquanto a thread estiver pausada
        while (pausado && !desativa) {
          Thread.sleep(1);
        }
        //Verifica se a thread deve ser desativada
        if (desativa) {
          break;
        }

        // se a thread nao estiver esperando
        if (!esperando) {


          while (pausado && !desativa) {
            Thread.sleep(1);
          }
          if (desativa) {
            break;
          }


          // Atualiza o estado do album na interface grafica (carregando musica)
          Platform.runLater(() -> controller.mudar_estado_album(id, true, true));


          while (pausado && !desativa) {
            Thread.sleep(1);
          }
          if (desativa) {
            break;
          }


          //configruacao dos parametros de incremento do progresso de carregamento da musica
          int time_nano = (int) Math.pow(10, 6);
          double progress_increment = 1.0 / getSpeed(carregando_musica_slider);
          double scale = Math.pow(10, 4);
          progress_increment = Math.round(progress_increment * scale) / scale;
          double progress = 0.0;

          // Mostra a barra de progresso e define o progresso inicial
          Platform.runLater(() -> progressBar.setVisible(true));
          progressBar.setProgress(0.0);


          // Loop para atualizar a progress bar de carregamento ate atingir a totalidade
          while (progressBar.getProgress() <= 1.0) {
            progress += progress_increment;
            progressBar.setProgress(progress);
            double time = progress_increment * (Math.pow(10, 9));

             // Gerencia o tempo de acordo com a precisao necessaria
            if (time < time_nano) {
              Thread.sleep(0, (int) time);
            } else {
              int millis = (int) time / time_nano;
              Thread.sleep(millis, (int) (time - (millis * time_nano)));
            }
            while (pausado && !desativa) {
              Thread.sleep(1);
            }
            if (desativa) {
              break;
            }
          }

          if (desativa) {
            break;
          }

          //Atualiza o estado do album na interface grafica (oculta label e progresss bar)
          Platform.runLater(() -> controller.mudar_estado_album(id, true, false));
          Platform.runLater(() -> progressBar.setVisible(false));

          while (pausado && !desativa) {
            Thread.sleep(1);
          }
          if (desativa) {
            break;
          }



          //Atualiza o semaforo do album na interface grafica (bloqueado)
          Platform.runLater(() -> controller.mudar_semaforo_album(id,true));
          //aguarda a sua vez para acessar o banco de dados
          Controller.db.acquire();
          //oculta label do semaforo
          Platform.runLater(() -> controller.mudar_semaforo_album(id, false));


          while (pausado && !desativa) {
            Thread.sleep(1);
          }
          if (desativa) {
            break;
          }


          // Atualiza o estado do album na interface grafica (fazendo upload)
          Platform.runLater(() -> controller.mudar_estado_album(id, false, true));


          //configruacao da progress bar de upload
          progress_increment = 1.0 / getSpeed(fazendo_upload_slider);
          scale = Math.pow(10, 4);
          progress_increment = Math.round(progress_increment * scale) / scale;
          progress = 0;
          Platform.runLater(()->progressBar.setVisible(true));
          progressBar.setProgress(0.0);

          // Loop para atualizar a progress bar de upload ate atingir a totalidade
          while (progressBar.getProgress() <= 1.0) {
            progress += progress_increment;
            progressBar.setProgress(progress);
            double time = progress_increment * (Math.pow(10, 9));

            if (time < time_nano) {
              Thread.sleep(0, (int) time);
            } else {
              int millis = (int) time / time_nano;
              Thread.sleep(millis, (int) (time - (millis * time_nano)));
            }

            while (pausado && !desativa) {
              Thread.sleep(1);
            }
            if (desativa) {
              break;
            }
          }
          if (desativa) {
            break;
          }

          // Atualiza o estado do album ocultando a label e a barra de progresso.
          Platform.runLater(() -> controller.mudar_estado_album(id, false, false));
          Platform.runLater(() -> progressBar.setVisible(false));

          //altera a playlist escrevendo no banco de dados
          Platform.runLater(() -> controller.escrever_na_playlist(id));
          //Libera o controle sobre o banco de dados
          Controller.db.release();
        }

        while (pausado && !desativa) {
          Thread.sleep(1);
        }
        if (desativa) {
          break;
        }

      } catch (Exception e) {
        System.out.println("Erro na thread de AlbumEscritor");
        e.printStackTrace();
      }
    }
  }
}
