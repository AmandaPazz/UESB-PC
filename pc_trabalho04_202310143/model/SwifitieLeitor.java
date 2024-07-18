/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 05/06/2023
* Ultima alteracao.: 15/06/2023
* Nome.............: SwiftieLeitor
* Funcao...........: Determina a logica a ser executada pelo leitor
****************************************************************/

//pasta do arquivo
package model;

//importacoes necessarias para o programa
import controller.Controller;
import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class SwifitieLeitor extends Thread {
    
    //variaveis do objeto que sao especificas de cada thread e passadas pelo construtor
    private Controller controller;
    private int id;
    private Slider donwload_musica_slider;
    private Slider reproduzindo_musica_slider;
    private ProgressBar progressBar;

    //flag que indica se a musica foi baixada pela thread
    public boolean musica_baixada = false;
    //flag que indica se a thread pode fazer download
    public boolean pode_fazer_download = true;
    //flag para inficar se a thread esta pausada
    private boolean pausado = false;
    //flag para indicar se a thread foi desativada
    private boolean desativa = false;

    //construtor do leitor
    public SwifitieLeitor(Controller controller, int id, Slider donwload_musica_slider, Slider reproduzindo_musica_slider, ProgressBar progressBar) {
        this.controller = controller;
        this.id = id;
        this.donwload_musica_slider = donwload_musica_slider;
        this.reproduzindo_musica_slider = reproduzindo_musica_slider;
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
        // Inverter a lógica de mapeamento para que um valor maior no slider resulte em uma velocidade menor
        int swiftie_speed = (int) ((slider.getMax() - temp + slider.getMin()) * 50);
        return swiftie_speed;
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

                //Atualiza o semaforo do swiftie na interface grafica (esperando)
                Platform.runLater(() -> controller.mudar_semaforo_swifitie(id, true));
                //Adquire o semaforo para garantir acesso exclusivo ao controle de leitores
                Controller.mutex.acquire();
                //incrementa o contados de leitores
                Controller.rc++;


                // Se esta é a primeira thread leitora, adquire o acesso exclusivo ao banco de dados.
                if (Controller.rc == 1) {
                    //Adquire o semaforo para garantir acesso exclusivo ao banco de dados
                    Controller.db.acquire();
                }
                

                // Libera o acesso exclusivo ao controle de leitores
                Controller.mutex.release();
                // oculta label
                Platform.runLater(() -> controller.mudar_semaforo_swifitie(id, false));

                
                while (pausado && !desativa) {
                    Thread.sleep(1);
                }
                if (desativa) {
                    break;
                }

                //se a se eh permitido fazer o download e se a musica ainda nao foi baixada
                if (pode_fazer_download && !musica_baixada) {


                    while (pausado && !desativa) {
                        Thread.sleep(1);
                    }
                    if (desativa) {
                        break;
                    }


                    //atualiza o estado do swiftie na interface grafica (downloading)
                    Platform.runLater(() -> controller.mudar_estado_swifitie(id, true, true));


                    //configruacao dos parametros de incremento do progresso de download da musica
                    int time_nano = (int) Math.pow(10, 6);
                    double progress_increment = 1.0 / getSpeed(donwload_musica_slider);
                    double scale = Math.pow(10, 4);
                    progress_increment = Math.round(progress_increment * scale) / scale;
                    double progress = 0;

                    // Mostra a barra de progresso e define o progresso inicial
                    Platform.runLater(() -> progressBar.setVisible(true));
                    progressBar.setProgress(0.0);

                    // Loop para atualizar a progress bar de donwload ate atingir a totalidade
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

                    
                    //oculta a progress bar e a label
                    Platform.runLater(() -> controller.mudar_estado_swifitie(id, true, false));
                    Platform.runLater(() -> progressBar.setVisible(false));


                    while (pausado && !desativa) {
                        Thread.sleep(1);
                    }
                    if (desativa) {
                        break;
                    }

                    
                    //le musicas da playlist indicando que a musica foi baixada
                    controller.ler_na_playlist(id);
                }

                //Adquire o semaforo para garantir acesso exclusivo ao controle de leitores
                Controller.mutex.acquire();
                //decrementa a variavel o contador de leitores
                Controller.rc--;
                //Se nao houver mais leitores ativos, libera o banco de dados para os escritores
                if (Controller.rc == 0) {
                    Controller.db.release();
                }
                // Libera o acesso exclusivo ao controle de leitores
                Controller.mutex.release();


                while (pausado && !desativa) {
                    Thread.sleep(1);
                }
                if (desativa) {
                    break;
                }

                //se a musica foi baixada o swiftie pode reproduzir
                if (musica_baixada) {


                    while (pausado && !desativa) {
                        Thread.sleep(1);
                    }
                    if (desativa) {
                        break;
                    }


                    //atualiza o estado do swiftie na interface grafica (reproduzindo)
                    Platform.runLater(() -> controller.mudar_estado_swifitie(id, false, true));
                

                    //configruacao da progress bar de reproducao
                    int time_nano = (int) Math.pow(10, 6);
                    double progress_increment = 1.0 / getSpeed(reproduzindo_musica_slider);
                    double scale = Math.pow(10, 4);
                    progress_increment = Math.round(progress_increment * scale) / scale;
                    double progress = 0;
                    Platform.runLater(() -> progressBar.setVisible(true));
                    progressBar.setProgress(0.0);

                    // Loop para atualizar a progress bar de reproducao ate atingir a totalidade
                    while (progressBar.getProgress() <= 1.0) {
                        progress += progress_increment;
                        progressBar.setProgress(progress);
                        double time = progress_increment * (Math.pow(10, 9));

                        if (time < time_nano) {
                            Thread.sleep(0, (int) time);
                        } else {
                            int millis = (int) time / 1000000;
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


                    //oculta a progress bar e a label
                    Platform.runLater(() -> controller.mudar_estado_swifitie(id, false, false));
                    Platform.runLater(() -> progressBar.setVisible(false));


                    while (pausado && !desativa) {
                        Thread.sleep(1);
                    }
                    if (desativa) {
                        break;
                    }

                    //swiftie reproduz a musica sinalizando que pode fazer o download
                    Platform.runLater(() -> controller.reproduzir_musica_da_playlist(id));
                    //se pode fazer o download entao a musica nao foi baixada
                    musica_baixada = false;
                }

            } catch (Exception e) {
                System.out.println("Erro na thread de SwiftieLeitor");
                e.printStackTrace();
            }
        }
    }

}