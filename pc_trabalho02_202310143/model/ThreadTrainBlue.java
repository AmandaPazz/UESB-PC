/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 22/03/2023
* Ultima alteracao.: 01/05/2023
* Nome.............: ThreadTrainBlue
* Funcao...........: Classe que implementa uma thread para controlar o movimento do trem vermelho
****************************************************************/

package model;

import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class ThreadTrainBlue extends Thread {
    private double speedX;// variavel da velocidade do eixo x
    private double speedY;// variavel da velocidade do eixo y
    private int posicao;// variavel da posicao selecionada para o trem vermelho
    private Slider slider;// variavel do slider para o trem vermelho
    private ImageView imageTrain;// variavel que busca a imagem do trem vermelho

    /****************************************************************
     * Metodo: run
     * Funcao: define o que a thread vai controlar que nesse caso e o movimento continuo do trem azul
     * Parametros:void
     * Retorno: void
     ****************************************************************/
    @Override
    public void run() {
        while (true) {
            //atualiza a velocidade do trem nos eixos X e Y com o valor atual do slider que controla a velocidade do trem.
            setSpeedX(slider.getValue());
            setSpeedY(slider.getValue());

             //executa o codigo fornecido na propria thread da interface grafica do JavaFX.
            Platform.runLater(() -> {
                moveTrain();
            });

            //pausa a execucao da thread atual por 17 milissegundos controlando a animacao do trem
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//fim do while
    }

    //contrutor que define a posicao inicial do trem vermelho, a sua imagem e o seu slider
    public ThreadTrainBlue(ImageView imageTrain, int posicao, Slider slider) {
        this.imageTrain = imageTrain;
        this.posicao = posicao;
        this.slider = slider;

        switch (posicao) {
            case 2: {
                imageTrain.setLayoutX(506);
                imageTrain.setLayoutY(-29);
                imageTrain.setRotate(0);
                break;
            }
            case 4: {
                imageTrain.setLayoutX(506);
                imageTrain.setLayoutY(523);
                imageTrain.setRotate(180);
                break;
            }
            default:
                break;
        }// fim do switch
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
     * Metodo: getImageTrain
     * Funcao: Retorna a imagem do trem
     * Parametros: void
     * Retorno: ImageView - imagem do trem
     ****************************************************************/
    public ImageView getImageTrain() {
        return imageTrain;
    }

    /****************************************************************
     * Metodo: setImageTrain
     * Funcao: Determina a imagem do trem
     * Parametros: ImageView - imagem do trem
     * Retorno: void
     ****************************************************************/
    public void setImageTrain(ImageView imageTrain) {
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
     * Metodo: moveTrain
     * Funcao: responsavel por mover o trem vermelho de acordo com sua posicao escolhida
     * Parametros:void
     * Retorno: void
     ****************************************************************/
    public void moveTrain() {
        switch (posicao) {
            case 2: {
                // Trem Blue - descendo
                if (this.getImageTrain().getLayoutY() < 20 && this.getImageTrain().getLayoutY() >= -29) {
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() + this.getSpeedY());
                } // fim do primeiro if
                else if (this.getImageTrain().getLayoutY() < 79 && this.getImageTrain().getLayoutY() >= 20) {
                    this.getImageTrain().setRotate(45);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() + this.getSpeedY());
                    this.getImageTrain().setLayoutX(this.getImageTrain().getLayoutX() - this.getSpeedX());
                } // fim do segundo if
                else if (this.getImageTrain().getLayoutY() < 155 && this.getImageTrain().getLayoutY() >= 79) {
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() + this.getSpeedY());
                    this.getImageTrain().setRotate(0);
                } // fim do terceiro if
                else if (this.getImageTrain().getLayoutY() < 213 && this.getImageTrain().getLayoutY() >= 155) {
                    this.getImageTrain().setRotate(315);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() + this.getSpeedY());
                    this.getImageTrain().setLayoutX(this.getImageTrain().getLayoutX() + this.getSpeedX());
                } // fim do quarto if
                else if (this.getImageTrain().getLayoutY() < 275 && this.getImageTrain().getLayoutY() >= 213) {
                    this.getImageTrain().setRotate(0);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() + this.getSpeedY());
                } // fim do quinto if
                else if (this.getImageTrain().getLayoutY() < 333 && this.getImageTrain().getLayoutY() >= 275) {
                    this.getImageTrain().setRotate(45);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() + this.getSpeedY());
                    this.getImageTrain().setLayoutX(this.getImageTrain().getLayoutX() - this.getSpeedX());
                } // fim do sexto if
                else if (this.getImageTrain().getLayoutY() < 413 && this.getImageTrain().getLayoutY() >= 333) {
                    this.getImageTrain().setRotate(0);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() + this.getSpeedY());
                } // fim do setimo if
                else if (this.getImageTrain().getLayoutY() < 469 && this.getImageTrain().getLayoutY() >= 413) {
                    this.getImageTrain().setRotate(315);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() + this.getSpeedY());
                    this.getImageTrain().setLayoutX(this.getImageTrain().getLayoutX() + this.getSpeedX());
                } // fim do oitvao if
                else if (this.getImageTrain().getLayoutY() < 550 && this.getImageTrain().getLayoutY() >= 469) {
                    this.getImageTrain().setRotate(0);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() + this.getSpeedY());
                } // fim do nono if
                else {
                    this.getImageTrain().setLayoutX(506);
                    this.getImageTrain().setLayoutY(-29);
                    this.getImageTrain().setRotate(0);
                } // fim do else
                break;
            }
            case 4: {
                // Trem Blue - Subindo
                if (this.getImageTrain().getLayoutY() <= 523 && this.getImageTrain().getLayoutY() > 470) {
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() - this.getSpeedY());
                } // fim do primeiro if
                else if (this.getImageTrain().getLayoutY() <= 470 && this.getImageTrain().getLayoutY() > 410) {
                    this.getImageTrain().setRotate(135);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() - this.getSpeedY());
                    this.getImageTrain().setLayoutX(this.getImageTrain().getLayoutX() - this.getSpeedX());
                } // fim do segundo if
                else if (this.getImageTrain().getLayoutY() <= 410 && this.getImageTrain().getLayoutY() > 340) {
                    this.getImageTrain().setRotate(180);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() - this.getSpeedY());
                } // fim do terceiro if
                else if (this.getImageTrain().getLayoutY() <= 340 && this.getImageTrain().getLayoutY() > 280) {
                    this.getImageTrain().setRotate(225);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() - this.getSpeedY());
                    this.getImageTrain().setLayoutX(this.getImageTrain().getLayoutX() + this.getSpeedX());
                } // fim do quarto if
                else if (this.getImageTrain().getLayoutY() <= 280 && this.getImageTrain().getLayoutY() > 215) {
                    this.getImageTrain().setRotate(180);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() - this.getSpeedY());
                } // fim do quinto if
                else if (this.getImageTrain().getLayoutY() <= 215 && this.getImageTrain().getLayoutY() > 156) {
                    this.getImageTrain().setRotate(135);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() - this.getSpeedY());
                    this.getImageTrain().setLayoutX(this.getImageTrain().getLayoutX() - this.getSpeedX());
                } // fim do sexto if

                else if (this.getImageTrain().getLayoutY() <= 156 && this.getImageTrain().getLayoutY() > 80) {
                    this.getImageTrain().setRotate(180);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() - this.getSpeedY());

                } // fim do setimo if

                else if (this.getImageTrain().getLayoutY() <= 80 && this.getImageTrain().getLayoutY() > 25) {
                    this.getImageTrain().setRotate(225);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() - this.getSpeedY());
                    this.getImageTrain().setLayoutX(this.getImageTrain().getLayoutX() + this.getSpeedX());
                } // fim do oitavo if

                else if (this.getImageTrain().getLayoutY() <= 25 && this.getImageTrain().getLayoutY() > -47) {
                    this.getImageTrain().setRotate(180);
                    this.getImageTrain().setLayoutY(this.getImageTrain().getLayoutY() - this.getSpeedY());

                } // fim do nono if
                else {
                    this.getImageTrain().setLayoutX(506);
                    this.getImageTrain().setLayoutY(523);
                    this.getImageTrain().setRotate(180);
                } // fim do else
                break;
            }
            default:
                break;
        }//fim do switch
    }

}
