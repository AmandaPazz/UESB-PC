/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 22/03/2023
* Ultima alteracao.: 31/03/2023
* Nome.............: Trains
* Funcao...........: Transforma o trem num objeto com a sua imagem e posicao
****************************************************************/


package model;

import javafx.scene.image.ImageView;

public class Trains {

  //declarando as variaceis de velocidade nos eixos e da posicao nos trilhos
    private double speedX;
    private double speedY;
    private int posicao;
  
    //declarando a variavel da imagem do trem
    private ImageView imageTrem;
  

    //Construtor da classe Trains
    public Trains(ImageView imageTrem, int posicao) {
      this.imageTrem = imageTrem;
      this.posicao = posicao;

      //swich para associar a posicao escolhida com as coordenadas e a orientacao de onde os trens devem estar
      switch (posicao) {
        case 1: {
          imageTrem.setLayoutX(565);
          imageTrem.setLayoutY(-32);
          imageTrem.setRotate(0);
          break;
        }
        case 2: {
          imageTrem.setLayoutX(733);
          imageTrem.setLayoutY(-32);
          imageTrem.setRotate(0);
          break;
        }
        case 3: {
          imageTrem.setLayoutX(565);
          imageTrem.setLayoutY(775);
          imageTrem.setRotate(180);
          break;
        }
        case 4: {
          imageTrem.setLayoutX(733);
          imageTrem.setLayoutY(775);
          imageTrem.setRotate(180);
          break;
        }
  
        default:
          break;
      }//fim do switch
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
        return imageTrem;
      }

         /****************************************************************
     * Metodo: setImageTrem
     * Funcao: Determina a imagem do trem
     * Parametros: ImageView - imagem do trem
     * Retorno: void
     ****************************************************************/
      public void setImageTrem(ImageView imageTrem) {
        this.imageTrem = imageTrem;
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
    
    }
    

