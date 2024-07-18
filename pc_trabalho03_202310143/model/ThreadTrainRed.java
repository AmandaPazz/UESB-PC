/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 22/03/2023
* Ultima alteracao.: 26/05/2023
* Nome.............: ThreadTrainRed
* Funcao...........: Classe que implementa uma thread para controlar o movimento do trem vermelho
****************************************************************/

package model;

import controller.ControllerTrains;
import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class ThreadTrainRed extends Thread {
    private double speedX; // variavel da velocidade do eixo x
    private double speedY; // variavel da velocidade do eixo y
    private int posicao; // variavel da posicao selecionada para o trem vermelho
    private Slider slider; // variavel do slider para o trem vermelho
    private ImageView imageTrain;; // variavel que busca a imagem do trem vermelho
    private boolean ativa = true; // indica se a thread do trem vermelho esta ativa (inicializada como ativa)
    private int exclusao; // determina a variavel do tipo de exclusao mutua
    private int processo = 0; //variavel do processo atual (para o trem vermlho = 0, para o trem azul = 1)
    private boolean criticZone1 = false; // indica se o trem vermelho esta na zona critica 1
    private boolean criticZone2 = false; // indica se o trem vermelho esta na zona critica 2

    /****************************************************************
     * Metodo: run
     * Funcao: define o que a thread vai controlar que nesse caso e o movimento
     * continuo do trem vermelho
     * Parametros:void
     * Retorno: void
     ****************************************************************/
    @Override
    public void run() {

        //Loop principal da thread que executa enquanto 'ativa' for verdadeiro  
        while (ativa) {
            // atualiza a velocidade do trem nos eixos X e Y com o valor atual do slider que controla a velocidade do trem.
            setSpeedX(slider.getValue());
            setSpeedY(slider.getValue());

            // executa o codigo fornecido na propria thread da interface grafica do JavaFX.
            Platform.runLater(() -> {moveTrain();} );

            // pausa a execucao da thread atual por 17 milissegundos controlando o tempo da animacao do trem
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // fim do while
    }

    // contrutor que define a posicao inicial do trem vermelho, a sua imagem, o seu slider e o tipo da exclusao mutua
    public ThreadTrainRed(ImageView imageTrain, int posicao, Slider slider, int exclusao) {
        this.imageTrain = imageTrain;
        this.posicao = posicao;
        this.slider = slider;
        this.exclusao = exclusao;

        //determina a posicao inicial assumida pelo trem vermelho
        switch (posicao) {
            case 1: {
                imageTrain.setLayoutX(390);
                imageTrain.setLayoutY(-30);
                imageTrain.setRotate(0);
                break;
            }
            case 3: {
                imageTrain.setLayoutX(390);
                imageTrain.setLayoutY(525);
                imageTrain.setRotate(180);
                break;
            }
            default:
                break;
        }// fim do switch
    }

    /****************************************************************
     * Metodo: desativar
     * Funcao: Desativa o trem, mudando o estado da variavel 'ativa'
       para false (garante que as threads sejam reinicializadas)
     * Parametros: void
     * Retorno: void
     ****************************************************************/
    public void desativar() {
        this.ativa = false;
    }

    /****************************************************************
     * Metodo: getSpeedX
     * Funcao: Retorna a velocidade do trem no eixo x
     * Parametros: void
     * Retorno: double - velocidade do eixo x
     ****************************************************************/
    public double getSpeedX() {
        return speedX;
    }

    /****************************************************************
     * Metodo: setSpeedX
     * Funcao: Determina a velocidade do trem no eixo x
     * Parametros: velocidade do eixo x
     * Retorno: void
     ****************************************************************/
    public void setSpeedX(double d) {
        this.speedX = d;
    }

    /****************************************************************
     * Metodo: getSpeedY
     * Funcao: Retorna a velocidade do trem no eixo y
     * Parametros: void
     * Retorno: double - velocidade y
     ****************************************************************/
    public double getSpeedY() {
        return speedY;
    }

    /****************************************************************
     * Metodo: setSpeedY
     * Funcao: Determina a velocidade do trem no eixo YY
     * Parametros: velocidade do eixo Y
     * Retorno: void
     ****************************************************************/
    public void setSpeedY(double d) {
        this.speedY = d;
    }

    /****************************************************************
     * Metodo: getImageTrem
     * Funcao: Retorna a imagem do trem
     * Parametros: void
     * Retorno: ImageView - imagem do trem
     ****************************************************************/
    public ImageView getImageTrem() {
        return imageTrain;
    }

    /****************************************************************
     * Metodo: setImageTrem
     * Funcao: Determina a imagem do trem
     * Parametros: ImageView - imagem do trem
     * Retorno: void
     ****************************************************************/
    public void setImageTrem(ImageView imageTrain) {
        this.imageTrain = imageTrain;
    }

    /****************************************************************
     * Metodo: getPosicao
     * Funcao:Retorna a posicao do trem nos trilhos
     * Parametros: void
     * Retorno: int - posicao do trem
     ****************************************************************/
    public int getPosicao() {
        return posicao;
    }

    /****************************************************************
     * Metodo: entraRC1
     * Funcao: Verifica se o trem vermelho pode acessar a regiao critica 1
     * Parametros: int - o tipo de exclusao escolhida no construtor da thread
     * Retorno: boolean - retorna true se o trem vermelho puder acessar e false se nao puder acessar
     ****************************************************************/
    private boolean entraRC1(int exclusao) {
        switch (exclusao) {
            //Variavel de travamento
            case 1: {
                if (ControllerTrains.lock1 == 1) {
                    // Retorna falso se a variavel ja estiver ativada
                    return false; 

                } else {
                    // Ativa a variavel
                    ControllerTrains.lock1 = 1;
                    // Marca que o trem esta na zona critica 1
                    criticZone1 = true;
                    // Retorna true indicando que o trem pode acessar a zona critica 1
                    return true;
                }
            }

            //Estrita Alternancia
            case 2: {
                if (ControllerTrains.turn1 == 1) {
                    // Retorna falso se for o turno do outro trem
                    return false; 
                } else {
                    // Marca que o trem vermelho esta na zona critica 1
                    criticZone1 = true;
                    // Retorna true que o trem vermelho pode acessar a zona critica 1
                    return true;
                }
            }

            //Solucao de Peterson
            case 3: {
                // Calcula o indice do processo
                int other = 1 - processo;

                // Indica interesse do processo atual
                ControllerTrains.interesse1[processo] = true;

                // Define o turno para o processo atual
                ControllerTrains.turnPeterson1 = processo;

                // Verifica se o turno esta correto e se o outro processo esta interessado
                if (ControllerTrains.turnPeterson1 == processo && ControllerTrains.interesse1[other] == true) {
                    // Se nao puder entrar na regiao critica, retorna false
                    return false;
                } else {
                    // Marca que o trem vermelho esta na regi�o cr�tica 1
                    criticZone1 = true;
                    // Retorna true que o trem vermelho pode acessar a zona critica 1
                    return true;
                }
            }
            default:
                //Por padrao, o trem vermelho pode acessar a regi�o cr�tica 1
                return true;
        } //fim do switch
    }

    /****************************************************************
     * Metodo: saiRC1
     * Funcao: libera a regiao critica 1
     * Parametros: int - o tipo de exclusao escolhida no construtor da thread
     * Retorno: void
     ****************************************************************/
    private void saiRC1(int exclusao) {
        switch (exclusao) {

            //Variavel de travamento
            case 1: {
                // Libera o travamento para permitir que o trem azul acesse;
                ControllerTrains.lock1 = 0;

                // Indica que a zona critica 1 nao esta mais ocupada
                criticZone1 = false;

                break;
            }

            //Estrita Alternancia
            case 2: {
                 // Define que eh o outro turno de outro trem
                ControllerTrains.turn1 = 1;

                // Indica que a zona critica 1 nao esta mais ocupada
                criticZone1 = false;

                break;
            }

            //Solucao de Peterson
            case 3: {
                // Marca que o trem atual nao tem mais interesse na zona critica 1
                ControllerTrains.interesse1[processo] = false;

                // Indica que a zona critica 1 nao esta mais ocupada
                criticZone1 = false;

                break;
            }
        }
    }

    /****************************************************************
     * Metodo: entraRC2
     * Funcao: Verifica se o trem vermelho pode acessar a reigiao critica 2
     * Parametros: int - o tipo de exclusao escolhida no construtor da thread
     * Retorno: boolean - retorna true se o trem vermelho puder acessar e false se nao puder acessar
     ****************************************************************/
    private boolean entraRC2(int exclusao) {
        switch (exclusao) {
            //Variavel de travamento
            case 1: {
                if (ControllerTrains.lock2 == 1) {
                    // Retorna falso se a variavel ja estiver ativada
                    return false;
                } else {
                    // Ativa a variavel
                    ControllerTrains.lock2 = 1;
                    // Marca que o trem esta na zona critica 2
                    criticZone2 = true;
                    // Retorna true indicando que o trem pode acessar a zona critica 2
                    return true;
                }
            }

             //Estrita Alternancia
            case 2: {
                if (ControllerTrains.turn2 == 1) {
                    // Retorna falso se for o turno do outro trem
                    return false;

                } else {
                    // Marca que o trem vermelho esta na zona critica 2
                    criticZone2 = true;
                    // Retorna true que o trem vermelhopode acessar a zona critica 1
                    return true;
                }
            }

            //Solucao de Peterson
            case 3: {
                 // Calcula o indice do processo
                int other = 1 - processo;

                // Indica interesse do processo atual
                ControllerTrains.interesse2[processo] = true;

                // Define o turno para o processo atual
                ControllerTrains.turnPeterson2 = processo;

                // Verifica se o turno esta correto e se o outro processo esta interessado
                if (ControllerTrains.turnPeterson2 == processo && ControllerTrains.interesse2[other] == true) {
                    // Se nao puder entrar na regiao critica, retorna false
                    return false;

                } else {
                     // Marca que o trem vermelho esta na regi�o cr�tica 2
                    criticZone2 = true;

                     // Retorna true que o trem vermelho pode acessar a zona critica 2
                    return true;
                }
            }
            default:
                return true;
        }
    }

    /****************************************************************
     * Metodo: saiRC2
     * Funcao: libera a regiao critica 2
     * Parametros: int - o tipo de exclusao escolhida no construtor da thread
     * Retorno: void
     ****************************************************************/
    private void saiRC2(int exclusao) {
        switch (exclusao) {
            //Variavel de travamento
            case 1: {
                // Libera o travamento para permitir que o trem azul acesse;
                ControllerTrains.lock2 = 0;

                // Indica que a zona critica 2 nao esta mais ocupada
                criticZone2 = false;
                break;
            }

            //Estrita Alternancia
            case 2: {
                // Define que eh o outro turno de outro trem
                ControllerTrains.turn2 = 1;

                // Indica que a zona critica 2 nao esta mais ocupada
                criticZone2 = false;
                break;
            }

            //Solucao de Peterson
            case 3: {
                // Marca que o trem atual nao tem mais interesse na zona critica 2
                ControllerTrains.interesse2[processo] = false;

                // Indica que a zona critica 2 nao esta mais ocupada
                criticZone2 = false;
                break;
            }
        }
    }

    /****************************************************************
     * Metodo: moveTrain
     * Funcao: responsavel por mover o trem vermelho de acordo com sua posicao
     * escolhida
     * Parametros:void
     * Retorno: void
     ****************************************************************/
    public void moveTrain() {
        switch (posicao) {
            case 1: {
                // Trem Red - descendo
                if (this.getImageTrem().getLayoutY() < 20 && this.getImageTrem().getLayoutY() >= -30) {
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                } 
                else if (this.getImageTrem().getLayoutY() < 50 && this.getImageTrem().getLayoutY() >= 20) {
                    this.getImageTrem().setRotate(315);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
                } 



                /************************************************************************************************* */
                // REGIAO CRITICA 1
                else if (this.getImageTrem().getLayoutY() < 79 && this.getImageTrem().getLayoutY() >= 20) {
                    //se o trem vermelho nao pode entrar na regiao critica e a zona critica 1 nao esta ocupada
                    if (!entraRC1(exclusao) && !criticZone1) {
                        //interrompe o loop
                        break;
                    }
                    this.getImageTrem().setRotate(315);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
                } else if (this.getImageTrem().getLayoutY() < 155 && this.getImageTrem().getLayoutY() >= 79) {
                    this.getImageTrem().setRotate(0);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                }
                else if (this.getImageTrem().getLayoutY() < 190 && this.getImageTrem().getLayoutY() >= 155) {
                    this.getImageTrem().setRotate(45);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
                }
                /************************************************************************************************* */



                else if (this.getImageTrem().getLayoutY() < 213 && this.getImageTrem().getLayoutY() >= 190) {
                    //libera a regiao critica 1
                    saiRC1(exclusao);

                    this.getImageTrem().setRotate(45);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
                } 
                else if (this.getImageTrem().getLayoutY() < 275 && this.getImageTrem().getLayoutY() >= 213) {
                    this.getImageTrem().setRotate(0);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                }
                else if (this.getImageTrem().getLayoutY() < 303 && this.getImageTrem().getLayoutY() >= 275) {
                    this.getImageTrem().setRotate(315);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
                } 



                /************************************************************************************************* */
                // REGIAO CRITICA 2
                else if (this.getImageTrem().getLayoutY() < 333 && this.getImageTrem().getLayoutY() >= 303) {
                    //se o trem vermelho nao pode entrar na regiao critica e a zona critica 2 nao esta ocupada
                    if (!entraRC2(exclusao) && !criticZone2) {
                         //interrompe o loop
                        break;
                    }
                    this.getImageTrem().setRotate(315);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
                } else if (this.getImageTrem().getLayoutY() < 413 && this.getImageTrem().getLayoutY() >= 333) {
                    this.getImageTrem().setRotate(0);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                }
                else if (this.getImageTrem().getLayoutY() < 448 && this.getImageTrem().getLayoutY() >= 413) {
                    
                    this.getImageTrem().setRotate(45);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
                }
                /************************************************************************************************* */



                else if (this.getImageTrem().getLayoutY() < 470 && this.getImageTrem().getLayoutY() >= 448) {
                    //libera a regiao critica 2
                    saiRC2(exclusao);

                    this.getImageTrem().setRotate(45);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
                } 
                else if (this.getImageTrem().getLayoutY() < 550 && this.getImageTrem().getLayoutY() >= 470) {
                    this.getImageTrem().setRotate(0);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
                } 
                else {
                    this.getImageTrem().setLayoutX(390);
                    this.getImageTrem().setLayoutY(-30);
                    this.getImageTrem().setRotate(0);
                } 
                break;
            }
            case 3: {
                // Trem Red - Subindo
                if (this.getImageTrem().getLayoutY() <= 525 && this.getImageTrem().getLayoutY() > 470) {
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                }
                else if (this.getImageTrem().getLayoutY() <= 470 && this.getImageTrem().getLayoutY() > 440) {
                    this.getImageTrem().setRotate(225);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
                } 



                /************************************************************************************************* */
                // REGIAO CRITICA 2
                else if (this.getImageTrem().getLayoutY() <= 440 && this.getImageTrem().getLayoutY() > 410) {
                    //se o trem vermelho nao pode entrar na regiao critica e a zona critica 2 nao esta ocupada
                    if (!entraRC2(exclusao) && !criticZone2) {
                        //interrompe o loop
                        break;
                    }
                    this.getImageTrem().setRotate(225);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
                } else if (this.getImageTrem().getLayoutY() <= 410 && this.getImageTrem().getLayoutY() > 340) {
                    this.getImageTrem().setRotate(180);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                } 
                else if (this.getImageTrem().getLayoutY() <= 340 && this.getImageTrem().getLayoutY() > 295) {
                    this.getImageTrem().setRotate(135);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
                }
                /************************************************************************************************* */



                else if (this.getImageTrem().getLayoutY() <= 295 && this.getImageTrem().getLayoutY() > 280) {
                    //libera a regiao critica 2
                    saiRC2(exclusao);
                    this.getImageTrem().setRotate(135);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
                } 
                else if (this.getImageTrem().getLayoutY() <= 280 && this.getImageTrem().getLayoutY() > 215) {
                    this.getImageTrem().setRotate(180);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                } 
                else if (this.getImageTrem().getLayoutY() <= 215 && this.getImageTrem().getLayoutY() > 185) {
                    this.getImageTrem().setRotate(225);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
                } 



                /************************************************************************************************* */
                // REGIAO CRITICA 1
                else if (this.getImageTrem().getLayoutY() <= 185 && this.getImageTrem().getLayoutY() > 156) {
                    //se o trem vermelho nao pode entrar na regiao critica e a zona critica 1 nao esta ocupada
                    if (!entraRC1(exclusao) && !criticZone1) {
                        //interrompe o loop
                        break;
                    }
                    this.getImageTrem().setRotate(225);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
                } else if (this.getImageTrem().getLayoutY() <= 156 && this.getImageTrem().getLayoutY() > 80) {
                    this.getImageTrem().setRotate(180);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                } 
                else if (this.getImageTrem().getLayoutY() <= 80 && this.getImageTrem().getLayoutY() > 45) {
                    this.getImageTrem().setRotate(135);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
                }
                /************************************************************************************************* */



                else if (this.getImageTrem().getLayoutY() <= 45 && this.getImageTrem().getLayoutY() > 22) {
                    //libera a regiao critica 1
                    saiRC1(exclusao);
                    
                    this.getImageTrem().setRotate(135);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                    this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
                } 
                else if (this.getImageTrem().getLayoutY() <= 22 && this.getImageTrem().getLayoutY() > -47) {
                    this.getImageTrem().setRotate(180);
                    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
                } 
                else {
                    this.getImageTrem().setLayoutX(390);
                    this.getImageTrem().setLayoutY(525);
                    this.getImageTrem().setRotate(180);
                } 
                break;
            }
            default:
                break;
        }// fim do switch
    }

}
