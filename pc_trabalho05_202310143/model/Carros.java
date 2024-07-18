/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 24/06/2023
* Ultima alteracao.: 05/07/2023
* Nome.............: Carros
* Funcao...........: Determina a logica a ser executada pelos carros 
****************************************************************/
package model;

import controller.ControllerPrincipal;
import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class Carros extends Thread {

    //variaveis do objeto que sao especificas de cada thread e passadas pelo construtor
    private int id;
    private ControllerPrincipal controller;
    private ImageView imagem;
    private Slider slider;

    //flag para indicar se a thread esta pausada
    private boolean pausado = false;
    //flag para indicar se a thread foi desativada
    private boolean desativa = false;    

    public Carros(int id, ControllerPrincipal controller, ImageView imagem, Slider slider){
        this.id = id;
        this.controller = controller;
        this.imagem = imagem;
        this.slider = slider;
        set_posicao_inicial();
    }

    /****************************************************************
    * Metodo: pausar_ou_despausar
    * Funcao: Define o estado de pausa da instancia (pausa ou retoma a execucao)
    * Parametros: void
    * Retorno: boolean - retoma o estado atual
     ****************************************************************/
    public boolean pausar_ou_retomar(){
        if(pausado){
          pausado = false;
        } else {
          pausado = true;
        }
        return pausado;
    }

    /****************************************************************
    * Metodo: desativa
    * Funcao: Metodo que vai desativar e encerrar a thread 
    * Parametros: boolan desativa (true desativa)
    * Retorno: void
    ****************************************************************/
    public void desativar(){
        desativa = true;
    }

    /****************************************************************
    * Metodo: getSpeed
    * Funcao: Metodo que vai calcular a velocidade da thread a partir do
    *         valor do slider
    * Parametros: Slider slider - o slider que determina a velocidade da thread.
    * Retorno: int getSpeed - a velocidade calculada da thread
    ****************************************************************/
    public int getSpeed(Slider slider){
        int aux = (int)slider.getValue();
        return (37 - (10 + (aux/4)));
    }


    /****************************************************************
    * Metodo: set_posicao_inicial
    * Funcao: Metodo que vai determinar as posicoes iniciais dos carros
    * Parametros: Slider slider - o slider que determina a velocidade da thread.
    * Retorno: int getSpeed - a velocidade calculada da thread
    ****************************************************************/
    public void set_posicao_inicial(){
        switch(id){

            //posicao do carro vermelho
            case 0: {
                Platform.runLater(() -> imagem.setLayoutX(505));
                Platform.runLater(() -> imagem.setLayoutY(618));
                Platform.runLater(() -> imagem.setRotate(180));
                break;
            }

            //posicao do carro cinza
            case 1: {
                Platform.runLater(() -> imagem.setLayoutX(589));
                Platform.runLater(() -> imagem.setLayoutY(289));
                Platform.runLater(() -> imagem.setRotate(90));
                break;
            }

            //posicao do carro preto
            case 2: {
                Platform.runLater(() -> imagem.setLayoutX(467));
                Platform.runLater(() -> imagem.setLayoutY(167));
                Platform.runLater(() -> imagem.setRotate(90));
                break;
            }

            //posicao do carro ciano
            case 3:{
              Platform.runLater(() -> imagem.setLayoutX(628));
              Platform.runLater(() -> imagem.setLayoutY(131));
              Platform.runLater(() -> imagem.setRotate(0));
              break;
            }

            //posicao do carro verde
            case 4:{
              Platform.runLater(() -> imagem.setLayoutX(434));
              Platform.runLater(() -> imagem.setLayoutY(375));
              Platform.runLater(() -> imagem.setRotate(180));
              break;
            }

            //posicao do carro rosa
            case 5:{
              Platform.runLater(() -> imagem.setLayoutX(468));
              Platform.runLater(() -> imagem.setLayoutY(337));
              Platform.runLater(() -> imagem.setRotate(270));
              break;
            }

            //posicao do carro roxo
            case 6:{
              Platform.runLater(() -> imagem.setLayoutX(262));
              Platform.runLater(() -> imagem.setLayoutY(253));
              Platform.runLater(() -> imagem.setRotate(0));
              break;
            }

            //posicao do carro azul
            case 7:{
              Platform.runLater(() -> imagem.setLayoutX(589));
              Platform.runLater(() -> imagem.setLayoutY(47));
              Platform.runLater(() -> imagem.setRotate(90));
              break;
            }
        }
    }


    /****************************************************************
    * Metodo: move_cima
    * Funcao: Metodo que vai determinar quantos pixels o carro deve se movimentar para cima
    * Parametros: int pixels - numero que pixels
    * Retorno: void
    ****************************************************************/
    public void move_cima(int pixels){
      //rotaciona o carro para direita
        Platform.runLater(() -> imagem.setRotate(270));
        for(int i = 0; i < pixels; i++){


          //essas sao verificacoes para pausar o carro ou sair da execucao do percurso caso a thread seja desativada 
          if(desativa){
            break;
          }
          while(pausado && !desativa){
            try{
              sleep(1);
            } catch(Exception e){
              e.printStackTrace();
            }
          }
          //move o carro ate o for acabar ou seja ate chegar no numero de pixels desejado
          Platform.runLater(() -> imagem.setLayoutY(imagem.getLayoutY() - 1));
          try{
            //o valor do slider determina a velocidade do carro 
            sleep(getSpeed(slider));
          } catch(Exception e){
            e.printStackTrace();
          }
        }
    }


    /****************************************************************
    * Metodo: move_baixo
    * Funcao: Metodo que vai determinar quantos pixels o carro deve se movimentar para baixo
    * Parametros: int pixels - numero que pixels
    * Retorno: void
    ****************************************************************/
    public void move_baixo(int pixels){
        //rotaciona o carro para direita
        Platform.runLater(() -> imagem.setRotate(90));
        for(int i = 0; i < pixels; i++){
          if(desativa){
            break;
          }
          while(pausado && !desativa){
            try{
              sleep(1);
            } catch(Exception e){
              e.printStackTrace();
            }
          }
          Platform.runLater(() -> imagem.setLayoutY(imagem.getLayoutY() + 1));
          try{
            sleep(getSpeed(slider));
          } catch(Exception e){
            e.printStackTrace();
          }
        }
      }
    
      /****************************************************************
      * Metodo: move_direita
      * Funcao: Metodo que vai determinar quantos pixels o carro deve se movimentar para direita
      * Parametros: int pixels - numero que pixels
      * Retorno: void
      ****************************************************************/
      public void move_direita(int pixels){
        //rotaciona o carro para direita
        Platform.runLater(() -> imagem.setRotate(0));
        for(int i = 0; i < pixels; i++){
          if(desativa){
            break;
          }
          while(pausado && !desativa){
            try{
              sleep(1);
            } catch(Exception e){
              e.printStackTrace();
            }
          }
          Platform.runLater(() -> imagem.setLayoutX(imagem.getLayoutX() + 1));
          try{
            sleep(getSpeed(slider));
          } catch(Exception e){
            e.printStackTrace();
          }
        }
      }
    
    /****************************************************************
    * Metodo: move_esquerda
    * Funcao: Metodo que vai determinar quantos pixels o carro deve se movimentar para esquerda
    * Parametros: int pixels - numero que pixels
    * Retorno: void
    ****************************************************************/
      public void move_esquerda(int pixels){
        //rotaciona o carro para esquerda
        Platform.runLater(() -> imagem.setRotate(180));
        for(int i = 0; i < pixels; i++){
          if(desativa){
            break;
          }
          while(pausado && !desativa){
            try{
              sleep(1);
            } catch(Exception e){
              e.printStackTrace();
            }
          }
          Platform.runLater(() -> imagem.setLayoutX(imagem.getLayoutX() - 1));
          try{
            sleep(getSpeed(slider));
          } catch(Exception e){
            e.printStackTrace();
          }
        }
      }


      @Override
      /****************************************************************
      * Metodo: run
      * Funcao: Define o comportamento da thread durante sua execucao
      * Parametros: void
      * Retorno: void
      ****************************************************************/
      public void run() { 
        while (true) { 
          try {
            //chama o metodo de pecorrer o percurso do controller de acordo com a id do carro
            controller.pecorrer_percurso(id);
            //se a thread foi desativada ela sai do loop e encerra a thread
            if(desativa){
                break;
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          //no final do percurso ele seta as posicoes iniciais novamente para garantir que a animacao fique mais fluida
          set_posicao_inicial();
        } 
      } 

}
