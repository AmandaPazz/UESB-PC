/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 24/06/2023
* Ultima alteracao.: 05/07/2023
* Nome.............: ControllerPrincipal
* Funcao...........: Controla todos os elementos da scene que contem 
                     a simulacao do transito autonomo
****************************************************************/

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import model.Carros;

public class ControllerPrincipal implements Initializable {

    //declarando as imagens dos carros
    @FXML private ImageView carro_vermelho;
    @FXML private ImageView carro_cinza;
    @FXML private ImageView carro_preto;
    @FXML private ImageView carro_ciano;
    @FXML private ImageView carro_verde;
    @FXML private ImageView carro_rosa;
    @FXML private ImageView carro_roxo;
    @FXML private ImageView carro_azul;

    //declarando a imagem dos caminhos de cada carro
    @FXML private ImageView track_vermelho;
    @FXML private ImageView track_cinza;
    @FXML private ImageView track_preto;
    @FXML private ImageView track_ciano;
    @FXML private ImageView track_verde;
    @FXML private ImageView track_rosa;
    @FXML private ImageView track_roxo;
    @FXML private ImageView track_azul;

    //declarando a imagem dos botoes de pausar
    @FXML private ImageView pausar_vermelho;
    @FXML private ImageView pausar_cinza;
    @FXML private ImageView pausar_preto;
    @FXML private ImageView pausar_ciano;
    @FXML private ImageView pausar_verde;
    @FXML private ImageView pausar_rosa;
    @FXML private ImageView pausar_roxo;
    @FXML private ImageView pausar_azul;

    //declarado a imagem dos botoes de mostrar o caminho
    @FXML private ImageView show_vermelho;
    @FXML private ImageView show_cinza;
    @FXML private ImageView show_preto;
    @FXML private ImageView show_ciano;
    @FXML private ImageView show_verde;
    @FXML private ImageView show_rosa;
    @FXML private ImageView show_roxo;
    @FXML private ImageView show_azul;

    //declarando os sliders de cada carro
    @FXML private Slider slider_vermelho;
    @FXML private Slider slider_cinza;
    @FXML private Slider slider_preto;
    @FXML private Slider slider_ciano;
    @FXML private Slider slider_verde;
    @FXML private Slider slider_rosa;
    @FXML private Slider slider_roxo;
    @FXML private Slider slider_azul;
    
    // declarando as threads
    private Carros carroVermelho;
    private Carros carroCinza;
    private Carros carroPreto;
    private Carros carroCiano;
    private Carros carroVerde;
    private Carros carroRosa;
    private Carros carroRoxo;
    private Carros carroAzul;


    //declarando os vetores de semaforos (cada vetor eh uma combinacao entre 2 carros)
    private Semaphore[] Semaforo_Vermelho_Cinza = new Semaphore[2]; 
    private Semaphore[] Semaforo_Vermelho_Preto = new Semaphore[1];
    private Semaphore[] Semaforo_Vermelho_Ciano = new Semaphore[2]; 
    private Semaphore[] Semaforo_Vermelho_Verde = new Semaphore[1];
    private Semaphore[] Semaforo_Vermelho_Rosa = new Semaphore[1];
    private Semaphore[] Semaforo_Vermelho_Roxo = new Semaphore[2]; 
    private Semaphore[] Semaforo_Vermelho_Azul = new Semaphore[4]; 
    private Semaphore[] Semaforo_Cinza_Preto = new Semaphore[2]; 
    private Semaphore[] Semaforo_Cinza_Ciano = new Semaphore[3]; 
    private Semaphore[] Semaforo_Cinza_Verde = new Semaphore[2];  
    private Semaphore[] Semaforo_Cinza_Rosa = new Semaphore[3];  
    private Semaphore[] Semaforo_Cinza_Roxo = new Semaphore[4]; 
    private Semaphore[] Semaforo_Cinza_Azul = new Semaphore[6]; 
    private Semaphore[] Semaforo_Preto_Ciano = new Semaphore[3];
    private Semaphore[] Semaforo_Preto_Verde = new Semaphore[3]; 
    private Semaphore[] Semaforo_Preto_Rosa = new Semaphore[1]; 
    private Semaphore[] Semaforo_Preto_Roxo = new Semaphore[2]; 
    private Semaphore[] Semaforo_Preto_Azul = new Semaphore[3]; 
    private Semaphore[] Semaforo_Ciano_Verde = new Semaphore[3]; 
    private Semaphore[] Semaforo_Ciano_Rosa = new Semaphore[2]; 
    private Semaphore[] Semaforo_Ciano_Roxo = new Semaphore[4];
    private Semaphore[] Semaforo_Ciano_Azul = new Semaphore[4]; 
    private Semaphore[] Semaforo_Verde_Rosa = new Semaphore[2]; 
    private Semaphore[] Semaforo_Verde_Roxo = new Semaphore[3]; 
    private Semaphore[] Semaforo_Verde_Azul = new Semaphore[4]; 
    private Semaphore[] Semaforo_Rosa_Roxo = new Semaphore[3]; 
    private Semaphore[] Semaforo_Rosa_Azul = new Semaphore[3]; 
    private Semaphore[] Semaforo_Roxo_Azul = new Semaphore[6];  



    
    /****************************************************************
   * Metodo: iniciar_semaforos
   * Funcao: inicia os semaforos com o numero de permissoes necessarias 
             (0 caso o carro ja esteja numa regiao critica e 1 caso ela esteja livre)
   * Parametros: void
   * Retorno: void
   ****************************************************************/
    public void iniciar_semaforos(){
        for (int i = 0; i < Semaforo_Vermelho_Cinza.length; i++) {
            Semaforo_Vermelho_Cinza[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Vermelho_Preto.length; i++) {
            Semaforo_Vermelho_Preto[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Cinza_Preto.length; i++) {
            Semaforo_Cinza_Preto[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Vermelho_Ciano.length; i++) {
            Semaforo_Vermelho_Ciano[i] = new Semaphore(1);
        }
        for (int i = 0; i <  Semaforo_Cinza_Ciano.length; i++) {
            Semaforo_Cinza_Ciano[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Preto_Ciano.length; i++) {
            Semaforo_Preto_Ciano[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Vermelho_Verde.length; i++) {
            Semaforo_Vermelho_Verde[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Cinza_Verde.length; i++) {
            Semaforo_Cinza_Verde[i] = new Semaphore(1);
            if(i == 0){
                Semaforo_Cinza_Verde[i] = new Semaphore(0);
            }
        }
        for (int i = 0; i < Semaforo_Preto_Verde.length; i++) {
            Semaforo_Preto_Verde[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Ciano_Verde.length; i++) {
            Semaforo_Ciano_Verde[i] = new Semaphore(1);
            if (i==0){
                Semaforo_Ciano_Verde[i] = new Semaphore(0);
            }
        }
        for (int i = 0; i < Semaforo_Vermelho_Rosa.length; i++) {
            Semaforo_Vermelho_Rosa[i] = new Semaphore(0);
        }
        for (int i = 0; i < Semaforo_Cinza_Rosa.length; i++) {
            Semaforo_Cinza_Rosa[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Preto_Rosa.length; i++) {
            Semaforo_Preto_Rosa[i] = new Semaphore(0);
        }
        for (int i = 0; i < Semaforo_Ciano_Rosa.length; i++) {
            Semaforo_Ciano_Rosa[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Verde_Rosa.length; i++) {
            Semaforo_Verde_Rosa[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Vermelho_Roxo.length; i++) {
            Semaforo_Vermelho_Roxo[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Cinza_Roxo.length; i++) {
            Semaforo_Cinza_Roxo[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Preto_Roxo.length; i++) {
            Semaforo_Preto_Roxo[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Ciano_Roxo.length; i++) {
            Semaforo_Ciano_Roxo[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Verde_Roxo.length; i++) {
            Semaforo_Verde_Roxo[i] = new Semaphore(1);
            if(i == 0){
                Semaforo_Verde_Roxo[i] = new Semaphore(0);
            }
        }
        for (int i = 0; i < Semaforo_Rosa_Roxo.length; i++) {
            Semaforo_Rosa_Roxo[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Vermelho_Azul.length; i++) {
            Semaforo_Vermelho_Azul[i] = new Semaphore(1);
            if(i==2){
                Semaforo_Vermelho_Azul[i] = new Semaphore(0);
            }
        }
        for (int i = 0; i < Semaforo_Cinza_Azul.length; i++) {
            Semaforo_Cinza_Azul[i] = new Semaphore(1);
            if(i==0){
                Semaforo_Cinza_Azul[i] = new Semaphore(0);
            }
        }
        for (int i = 0; i < Semaforo_Preto_Azul.length; i++) {
            Semaforo_Preto_Azul[i] = new Semaphore(1);
            if (i == 2){
                Semaforo_Preto_Azul[i] = new Semaphore(0);
            }
        }
        for (int i = 0; i < Semaforo_Ciano_Azul.length; i++) {
            Semaforo_Ciano_Azul[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Verde_Azul.length; i++) {
            Semaforo_Verde_Azul[i] = new Semaphore(1);
            if (i == 0){
                Semaforo_Verde_Azul[i] = new Semaphore(0);
            }
            if (i == 2 ){
                Semaforo_Verde_Azul[i] = new Semaphore(0);
            }
        }
        for (int i = 0; i < Semaforo_Rosa_Azul.length; i++) {
            Semaforo_Rosa_Azul[i] = new Semaphore(1);
        }
        for (int i = 0; i < Semaforo_Roxo_Azul.length; i++) {
            Semaforo_Roxo_Azul[i] = new Semaphore(1);
            if(i == 4){
                Semaforo_Roxo_Azul[i] = new Semaphore(0);
            }
        }
        
    }


    @FXML
    /****************************************************************
    * Metodo: show_track
    * Funcao: mostra o caminho de cada carro
    * Parametros: MouseEvent event - clique do mouse
    * Retorno: void
   ****************************************************************/
    public void show_track(MouseEvent event){
        //string que recebe a id do botao apertado
        String id = event.getPickResult().getIntersectedNode().getId();

        if (id.equals("show_vermelho")){
            if (track_vermelho.isVisible()){
                track_vermelho.setVisible(false);
                show_vermelho.setImage(new Image("/img/track_off.png"));
            }
            else{
                track_vermelho.setVisible(true);
                show_vermelho.setImage(new Image("/img/track_on.png"));
            }
        }

        if (id.equals("show_cinza")){
            if (track_cinza.isVisible()){
                track_cinza.setVisible(false);
                show_cinza.setImage(new Image("/img/track_off.png"));
            }
            else{
                track_cinza.setVisible(true);
                show_cinza.setImage(new Image("/img/track_on.png"));
            }
        }

        if (id.equals("show_preto")){
            if (track_preto.isVisible()){
                track_preto.setVisible(false);
                show_preto.setImage(new Image("/img/track_off.png"));
            }
            else{
                track_preto.setVisible(true);
                show_preto.setImage(new Image("/img/track_on.png"));
            }
        }

        if (id.equals("show_ciano")){
            if (track_ciano.isVisible()){
                track_ciano.setVisible(false);
                show_ciano.setImage(new Image("/img/track_off.png"));
            }
            else{
                track_ciano.setVisible(true);
                show_ciano.setImage(new Image("/img/track_on.png"));
            }
        }

        if (id.equals("show_verde")){
            if (track_verde.isVisible()){
                track_verde.setVisible(false);
                show_verde.setImage(new Image("/img/track_off.png"));
            }
            else{
                track_verde.setVisible(true);
                show_verde.setImage(new Image("/img/track_on.png"));
            }
        }

        if (id.equals("show_rosa")){
            if (track_rosa.isVisible()){
                track_rosa.setVisible(false);
                show_rosa.setImage(new Image("/img/track_off.png"));
            }
            else{
                track_rosa.setVisible(true);
                show_rosa.setImage(new Image("/img/track_on.png"));
            }
        }

        if (id.equals("show_roxo")){
            if (track_roxo.isVisible()){
                track_roxo.setVisible(false);
                show_roxo.setImage(new Image("/img/track_off.png"));
            }
            else{
                track_roxo.setVisible(true);
                show_roxo.setImage(new Image("/img/track_on.png"));
            }
        }

        if (id.equals("show_azul")){
            if (track_azul.isVisible()){
                track_azul.setVisible(false);
                show_azul.setImage(new Image("/img/track_off.png"));
            }
            else{
                track_azul.setVisible(true);
                show_azul.setImage(new Image("/img/track_on.png"));
            }
        }

    }

    @FXML
    /****************************************************************
    * Metodo: pausar_carro
    * Funcao: pausar o carro ou retomar sua execucao
    * Parametros: MouseEvent event - clique do mouse
    * Retorno: void
   ****************************************************************/
    public void pausar_carro(MouseEvent event){
        //string que recebe a id do botao de pausa apertado
        String id = event.getPickResult().getIntersectedNode().getId();

        if (id.equals("pausar_vermelho")){
            if(carroVermelho.pausar_ou_retomar()){
                pausar_vermelho.setImage(new Image("/img/retomar.png"));
              } else {
                pausar_vermelho.setImage(new Image("/img/pausar.png"));
              }
        }

        if (id.equals("pausar_cinza")){
            if(carroCinza.pausar_ou_retomar()){
                pausar_cinza.setImage(new Image("/img/retomar.png"));
              } else {
                pausar_cinza.setImage(new Image("/img/pausar.png"));
              }
        }

        if (id.equals("pausar_preto")){
            if(carroPreto.pausar_ou_retomar()){
                pausar_preto.setImage(new Image("/img/retomar.png"));
              } else {
                pausar_preto.setImage(new Image("/img/pausar.png"));
              }
        }

        if (id.equals("pausar_ciano")){
            if(carroCiano.pausar_ou_retomar()){
                pausar_ciano.setImage(new Image("/img/retomar.png"));
              } else {
                pausar_ciano.setImage(new Image("/img/pausar.png"));
              }
        }

        if (id.equals("pausar_verde")){
            if(carroVerde.pausar_ou_retomar()){
                pausar_verde.setImage(new Image("/img/retomar.png"));
              } else {
                pausar_verde.setImage(new Image("/img/pausar.png"));
              }
        }

        if (id.equals("pausar_rosa")){
            if(carroRosa.pausar_ou_retomar()){
                pausar_rosa.setImage(new Image("/img/retomar.png"));
              } else {
                pausar_rosa.setImage(new Image("/img/pausar.png"));
              }
        }

        if (id.equals("pausar_roxo")){
            if(carroRoxo.pausar_ou_retomar()){
                pausar_roxo.setImage(new Image("/img/retomar.png"));
              } else {
                pausar_roxo.setImage(new Image("/img/pausar.png"));
              }
        }

        if (id.equals("pausar_azul")){
            if(carroAzul.pausar_ou_retomar()){
                pausar_azul.setImage(new Image("/img/retomar.png"));
              } else {
                pausar_azul.setImage(new Image("/img/pausar.png"));
              }
        }
    }

    
    /****************************************************************
    * Metodo: pecorrer_percurso
    * Funcao: determinar o percurso executado pelo carro bem como o 
              funcionamento dos semaforos

              85 pixels - bloco
              38 pixels - rua
              35 pixels - curva

              (fiz alguns ajustes pra melhorar a animacao)

    * Parametros: int id - id do carro para saber qual percurso ele vai fazer
    * Retorno: void
   ****************************************************************/
    public void pecorrer_percurso(int id)  throws InterruptedException{
        switch(id){

            //  carro vermelho
            case 0:{
                carroVermelho.move_direita(47);

                Semaforo_Vermelho_Cinza[0].acquire();
                Semaforo_Vermelho_Roxo[0].acquire();

                carroVermelho.move_direita(38);
                carroVermelho.move_direita(42);

                Semaforo_Vermelho_Azul[2].release();

                carroVermelho.move_direita(43);
                carroVermelho.move_direita(38);
                carroVermelho.move_direita(85);
                carroVermelho.move_direita(35);
                carroVermelho.move_cima(85);
                carroVermelho.move_cima(38);
                carroVermelho.move_cima(42);

                Semaforo_Vermelho_Cinza[0].release();

                carroVermelho.move_cima(43);

                Semaforo_Vermelho_Ciano[0].acquire();
                Semaforo_Vermelho_Azul[1].acquire();

                carroVermelho.move_cima(38);
                carroVermelho.move_cima(42);

                Semaforo_Vermelho_Roxo[0].release();

                carroVermelho.move_cima(43);

                Semaforo_Vermelho_Cinza[1].acquire();

                carroVermelho.move_cima(38);
                carroVermelho.move_cima(42);

                Semaforo_Vermelho_Rosa[0].release();
                Semaforo_Vermelho_Azul[1].release();

                carroVermelho.move_cima(43);
                carroVermelho.move_cima(38);
                carroVermelho.move_cima(42);

                Semaforo_Vermelho_Ciano[0].release();

                carroVermelho.move_cima(43);
                carroVermelho.move_cima(31);
                carroVermelho.move_esquerda(85);
                carroVermelho.move_esquerda(38);
                carroVermelho.move_esquerda(85);

                Semaforo_Vermelho_Verde[0].acquire();
                Semaforo_Vermelho_Azul[0].acquire();

                carroVermelho.move_esquerda(38);
                carroVermelho.move_esquerda(85);

                Semaforo_Vermelho_Preto[0].acquire();
                Semaforo_Vermelho_Roxo[1].acquire();


                carroVermelho.move_esquerda(38);
                carroVermelho.move_esquerda(42);

                Semaforo_Vermelho_Azul[0].release();

                carroVermelho.move_esquerda(43);
                carroVermelho.move_esquerda(38);
                carroVermelho.move_esquerda(85);
                carroVermelho.move_esquerda(31);
                carroVermelho.move_baixo(85);

                Semaforo_Vermelho_Ciano[1].acquire();

                carroVermelho.move_baixo(38);
                carroVermelho.move_baixo(85);

                Semaforo_Vermelho_Azul[3].acquire();

                carroVermelho.move_baixo(38);

                Semaforo_Vermelho_Roxo[1].release();

                carroVermelho.move_baixo(85);
                carroVermelho.move_baixo(38);
                carroVermelho.move_baixo(42);

                Semaforo_Vermelho_Verde[0].release();
                Semaforo_Vermelho_Ciano[1].release();
                Semaforo_Vermelho_Azul[3].release();
               
                carroVermelho.move_baixo(43);
                carroVermelho.move_baixo(38);
                carroVermelho.move_baixo(85);
                carroVermelho.move_baixo(31);
                carroVermelho.move_direita(85);
                carroVermelho.move_direita(38);
                carroVermelho.move_direita(85);

                Semaforo_Vermelho_Rosa[0].acquire();
                Semaforo_Vermelho_Azul[2].acquire();

                carroVermelho.move_direita(38);
                carroVermelho.move_direita(40);

                Semaforo_Vermelho_Cinza[1].release();
                Semaforo_Vermelho_Preto[0].release();
                break;
            }

            // carro cinza
            case 1:{
                carroCinza.move_baixo(47);

                Semaforo_Cinza_Ciano[0].acquire();

                carroCinza.move_baixo(38);
                carroCinza.move_direita(42);
                
                Semaforo_Cinza_Verde[0].release();

                carroCinza.move_direita(43);

                Semaforo_Cinza_Roxo[1].acquire();

                carroCinza.move_direita(38);
                carroCinza.move_baixo(42);

                Semaforo_Cinza_Azul[0].release();
                Semaforo_Cinza_Roxo[1].release();
                Semaforo_Cinza_Ciano[0].release();
                
                carroCinza.move_baixo(43);
                carroCinza.move_baixo(38);
                carroCinza.move_direita(85);

                Semaforo_Vermelho_Cinza[0].acquire();
                Semaforo_Cinza_Rosa[0].acquire();
                Semaforo_Cinza_Roxo[0].acquire();
                
                carroCinza.move_direita(38);
                carroCinza.move_baixo(85);
                carroCinza.move_baixo(38);
                carroCinza.move_esquerda(85);
                carroCinza.move_esquerda(38);
                carroCinza.move_esquerda(85);

                Semaforo_Cinza_Azul[2].acquire();
                
                carroCinza.move_esquerda(38);
                carroCinza.move_cima(38);

                Semaforo_Vermelho_Cinza[0].release();
                Semaforo_Cinza_Rosa[0].release();

                carroCinza.move_cima(85);
                carroCinza.move_esquerda(42);

                carroCinza.move_esquerda(43);

                Semaforo_Vermelho_Cinza[1].acquire();
                Semaforo_Cinza_Preto[0].acquire();
                Semaforo_Cinza_Rosa[1].acquire();

                carroCinza.move_esquerda(38);
                carroCinza.move_baixo(42);

                Semaforo_Cinza_Roxo[0].release();

                carroCinza.move_baixo(43);

                carroCinza.move_baixo(38);
                carroCinza.move_esquerda(42);

                Semaforo_Cinza_Azul[2].release();

                carroCinza.move_esquerda(43);
                carroCinza.move_esquerda(38);
                carroCinza.move_esquerda(85);

                Semaforo_Cinza_Preto[1].acquire();

                carroCinza.move_esquerda(33);
                carroCinza.move_cima(42);

                Semaforo_Cinza_Preto[0].release();

                carroCinza.move_cima(43);
                carroCinza.move_cima(38);
                carroCinza.move_cima(85);

                Semaforo_Cinza_Ciano[1].acquire();
                Semaforo_Cinza_Verde[1].acquire();
                Semaforo_Cinza_Azul[4].acquire();

                carroCinza.move_cima(38);
                carroCinza.move_cima(42);

                carroCinza.move_cima(43);

                Semaforo_Cinza_Roxo[3].acquire();

                carroCinza.move_cima(38);
                carroCinza.move_cima(42);

                Semaforo_Cinza_Azul[4].release();

                carroCinza.move_cima(43);
                carroCinza.move_cima(38);
                carroCinza.move_cima(42);

                Semaforo_Cinza_Ciano[1].release();

                carroCinza.move_cima(43);
                carroCinza.move_cima(33);
                carroCinza.move_direita(85);
                carroCinza.move_direita(38);
                carroCinza.move_direita(85);

                Semaforo_Cinza_Azul[5].acquire();
                
                carroCinza.move_direita(38);

                Semaforo_Cinza_Preto[1].release();

                carroCinza.move_direita(42);

                Semaforo_Cinza_Roxo[3].release();

                carroCinza.move_direita(43);
                carroCinza.move_direita(38);
                carroCinza.move_direita(42);

                Semaforo_Cinza_Verde[1].release();
                Semaforo_Cinza_Azul[5].release();

                carroCinza.move_direita(43);
                carroCinza.move_direita(38);
                carroCinza.move_direita(85);
                carroCinza.move_direita(33);
                carroCinza.move_baixo(85);

                Semaforo_Cinza_Ciano[2].acquire();

                carroCinza.move_baixo(38);
                carroCinza.move_baixo(85);

                Semaforo_Cinza_Roxo[2].acquire();
                Semaforo_Cinza_Azul[0].acquire();
                
                carroCinza.move_baixo(35);
                carroCinza.move_esquerda(42);

                Semaforo_Vermelho_Cinza[1].release();
                Semaforo_Cinza_Ciano[2].release();


                carroCinza.move_esquerda(42);
                
                carroCinza.move_esquerda(38);
                carroCinza.move_esquerda(85);

                Semaforo_Cinza_Verde[0].acquire();

                carroCinza.move_esquerda(38);
                carroCinza.move_baixo(40);

                Semaforo_Cinza_Roxo[2].release();
                Semaforo_Cinza_Rosa[1].release();
                break;
            }

            //carro preto
            case 2:{
                carroPreto.move_baixo(47);

                Semaforo_Preto_Rosa[0].acquire();

                carroPreto.move_baixo(38);
                carroPreto.move_baixo(42);

                Semaforo_Preto_Azul[2].release();

                carroPreto.move_baixo(43);

                Semaforo_Preto_Ciano[0].acquire();
                Semaforo_Preto_Verde[1].acquire();
                Semaforo_Preto_Roxo[0].acquire();
                Semaforo_Preto_Azul[0].acquire();
                
                carroPreto.move_baixo(38);
                carroPreto.move_baixo(42);

                Semaforo_Preto_Ciano[0].release();
                Semaforo_Preto_Verde[1].release();

                carroPreto.move_baixo(43);

                Semaforo_Cinza_Preto[0].acquire();

                carroPreto.move_baixo(38);
                carroPreto.move_baixo(42);

                Semaforo_Preto_Roxo[0].release();

                carroPreto.move_baixo(43);

                Semaforo_Vermelho_Preto[0].acquire();

                carroPreto.move_baixo(35);
                carroPreto.move_esquerda(42);

                Semaforo_Preto_Rosa[0].release();
                Semaforo_Preto_Azul[0].release();

                carroPreto.move_esquerda(43);
                carroPreto.move_esquerda(35);
                carroPreto.move_esquerda(85);

                Semaforo_Cinza_Preto[1].acquire();

                carroPreto.move_esquerda(38);
                carroPreto.move_cima(42);

                Semaforo_Cinza_Preto[0].release();

                carroPreto.move_cima(43);
                carroPreto.move_cima(38);
                carroPreto.move_cima(85);

                Semaforo_Preto_Ciano[1].acquire();
                Semaforo_Preto_Verde[0].acquire();
                Semaforo_Preto_Azul[1].acquire();

                carroPreto.move_cima(38);
                carroPreto.move_cima(42);

                carroPreto.move_cima(43);

                Semaforo_Preto_Roxo[1].acquire();
                
                carroPreto.move_cima(38);
                carroPreto.move_cima(42);

                Semaforo_Preto_Azul[1].release();

                carroPreto.move_cima(43);
                carroPreto.move_cima(38);
                carroPreto.move_cima(42);

                Semaforo_Preto_Ciano[1].release();

                carroPreto.move_cima(43);

                Semaforo_Preto_Verde[2].acquire();

                carroPreto.move_cima(32);
                carroPreto.move_direita(42);

                Semaforo_Preto_Verde[0].release();

                carroPreto.move_direita(43);
                carroPreto.move_direita(38);
                carroPreto.move_direita(85);

                Semaforo_Preto_Azul[2].acquire();

                carroPreto.move_direita(35);
                carroPreto.move_baixo(42);

                Semaforo_Preto_Verde[2].release();
                Semaforo_Vermelho_Preto[0].release();
                Semaforo_Cinza_Preto[1]. release();

                carroPreto.move_baixo(40);

                Semaforo_Preto_Ciano[2].acquire();

                carroPreto.move_baixo(31);
                carroPreto.move_baixo(47);

                Semaforo_Preto_Ciano[2].release();
                Semaforo_Preto_Roxo[1].release();

                break;
            }

            // carro ciano
            case 3:{
                carroCiano.move_direita(47);
                carroCiano.move_direita(38);
                carroCiano.move_direita(85);

                Semaforo_Ciano_Rosa[0].acquire();
                Semaforo_Vermelho_Ciano[0].acquire();
                Semaforo_Cinza_Ciano[2].acquire();
                
                carroCiano.move_direita(35);
                carroCiano.move_baixo(85);

                Semaforo_Ciano_Azul[1].acquire();

                carroCiano.move_baixo(38);
                carroCiano.move_baixo(42);

                Semaforo_Cinza_Ciano[2].release();

                carroCiano.move_baixo(43);

                Semaforo_Ciano_Roxo[1].acquire();

                carroCiano.move_baixo(35);
                carroCiano.move_esquerda(25);

                Semaforo_Vermelho_Ciano[0].release();
                Semaforo_Ciano_Rosa[0].release();

                carroCiano.move_esquerda(50);

                Semaforo_Cinza_Ciano[0].acquire();

                carroCiano.move_esquerda(38);
                carroCiano.move_esquerda(42);

                Semaforo_Ciano_Roxo[1].release();

                carroCiano.move_esquerda(43);

                Semaforo_Ciano_Verde[0].acquire();

                carroCiano.move_esquerda(38);
                carroCiano.move_esquerda(42);

                Semaforo_Cinza_Ciano[0].release();
                Semaforo_Ciano_Azul[1].release();

                carroCiano.move_esquerda(43);

                Semaforo_Preto_Ciano[0].acquire();
                Semaforo_Ciano_Roxo[0].acquire();
                Semaforo_Ciano_Rosa[1].acquire();
                Semaforo_Ciano_Azul[2].acquire();

                carroCiano.move_esquerda(38);
                carroCiano.move_esquerda(42);

                Semaforo_Preto_Ciano[0].release();
                Semaforo_Ciano_Rosa[1].release();

                carroCiano.move_esquerda(43);
                carroCiano.move_esquerda(38);

                Semaforo_Ciano_Roxo[0].release();

                carroCiano.move_esquerda(85);

                Semaforo_Vermelho_Ciano[1].acquire();
                Semaforo_Cinza_Ciano[1].acquire();
                Semaforo_Preto_Ciano[1].acquire();
                Semaforo_Ciano_Verde[1].acquire();
                
                carroCiano.move_esquerda(40);
                carroCiano.move_cima(42);

                Semaforo_Ciano_Verde[0].release();

                carroCiano.move_cima(43);

                Semaforo_Ciano_Roxo[3].acquire();
                
                carroCiano.move_cima(38);
                carroCiano.move_cima(42);

                Semaforo_Ciano_Azul[2].release();

                carroCiano.move_cima(43);
                carroCiano.move_cima(35);
                carroCiano.move_direita(35);

                Semaforo_Cinza_Ciano[1].release();
                Semaforo_Vermelho_Ciano[1].release();
                Semaforo_Preto_Ciano[1].release();
                Semaforo_Ciano_Verde[1].release();
                Semaforo_Ciano_Roxo[3].release();

                carroCiano.move_direita(50);
                carroCiano.move_direita(38);
                carroCiano.move_direita(85);

                Semaforo_Preto_Ciano[2].acquire();
                Semaforo_Ciano_Roxo[2].acquire();
                Semaforo_Ciano_Azul[3].acquire();

                carroCiano.move_direita(38);
                carroCiano.move_direita(42);

                Semaforo_Preto_Ciano[2].release();
                Semaforo_Ciano_Azul[3].release();

                carroCiano.move_direita(43);

                Semaforo_Ciano_Verde[2].acquire();
                Semaforo_Ciano_Azul[0].acquire();

                carroCiano.move_direita(38);
                carroCiano.move_direita(40);

                Semaforo_Ciano_Verde[2].release();
                Semaforo_Ciano_Roxo[2].release();
                Semaforo_Ciano_Azul[0].release();
                break;
            }

            //carro verde
            case 4:{
                carroVerde.move_esquerda(47);
                carroVerde.move_esquerda(38);
                carroVerde.move_esquerda(42);

                Semaforo_Verde_Roxo[0].release();

                carroVerde.move_esquerda(43);

                Semaforo_Vermelho_Verde[0].acquire();
                Semaforo_Cinza_Verde[1].acquire();
                Semaforo_Preto_Verde[0].acquire();
                Semaforo_Ciano_Verde[1].acquire();

                carroVerde.move_esquerda(40);
                carroVerde.move_cima(42);

                Semaforo_Ciano_Verde[0].release();

                carroVerde.move_cima(43);

                Semaforo_Verde_Roxo[2].acquire();

                carroVerde.move_cima(38);

                Semaforo_Verde_Azul[2].release();

                carroVerde.move_cima(85);
                carroVerde.move_cima(38);
                carroVerde.move_cima(42);

                Semaforo_Ciano_Verde[1].release();

                carroVerde.move_cima(43);

                Semaforo_Preto_Verde[2].acquire();

                carroVerde.move_cima(35);

                Semaforo_Preto_Verde[0].release();

                carroVerde.move_direita(85);
                carroVerde.move_direita(38);
                carroVerde.move_direita(85);

                Semaforo_Verde_Azul[0].acquire();

                carroVerde.move_direita(38);
                carroVerde.move_direita(42);

                Semaforo_Preto_Verde[2].release();
                Semaforo_Verde_Roxo[2].release();

                carroVerde.move_direita(43);
                carroVerde.move_direita(35);
                carroVerde.move_baixo(42);

                Semaforo_Vermelho_Verde[0].release();
                Semaforo_Cinza_Verde[1].release();

                carroVerde.move_baixo(43);

                Semaforo_Ciano_Verde[2].acquire();
                Semaforo_Verde_Roxo[1].acquire();
                Semaforo_Verde_Azul[3].acquire();

                carroVerde.move_baixo(38);
                carroVerde.move_baixo(42);

                Semaforo_Ciano_Verde[2].release();
                Semaforo_Verde_Azul[0].release();

                carroVerde.move_baixo(43);

                Semaforo_Verde_Rosa[0].acquire();
                Semaforo_Cinza_Verde[0].acquire();

                carroVerde.move_baixo(38);
                carroVerde.move_baixo(42);

                Semaforo_Verde_Rosa[0].release();
                Semaforo_Verde_Roxo[1].release();
                Semaforo_Verde_Azul[3].release();
            

                carroVerde.move_baixo(43);

                Semaforo_Ciano_Verde[0].acquire();
                Semaforo_Verde_Azul[1].acquire();

                carroVerde.move_baixo(35);
                carroVerde.move_esquerda(42);

                Semaforo_Cinza_Verde[0].release();
                Semaforo_Verde_Azul[1].release();

                carroVerde.move_esquerda(43);

                Semaforo_Verde_Rosa[1].acquire();
                Semaforo_Preto_Verde[1].acquire();
                Semaforo_Verde_Roxo[0].acquire();
                Semaforo_Verde_Azul[2].acquire();
                
                carroVerde.move_esquerda(38);
                carroVerde.move_esquerda(35);

                Semaforo_Verde_Rosa[1].release();
                Semaforo_Preto_Verde[1].release();
                break;
            }

            //carro rosa
            case 5:{

                carroRosa.move_cima(47);

                Semaforo_Rosa_Azul[2].acquire();

                carroRosa.move_cima(35);
                carroRosa.move_direita(42);

                Semaforo_Preto_Rosa[0].release();
                Semaforo_Rosa_Azul[2].release();

                carroRosa.move_direita(43);

                Semaforo_Rosa_Azul[0].acquire();
                Semaforo_Verde_Rosa[0].acquire();
                Semaforo_Rosa_Roxo[2].acquire();
                Semaforo_Preto_Rosa[0].acquire();
                Semaforo_Vermelho_Rosa[0].acquire();
                Semaforo_Cinza_Rosa[1].acquire();
                
                carroRosa.move_direita(38);

                Semaforo_Verde_Rosa[0].release();

                carroRosa.move_direita(85);
                carroRosa.move_direita(38);
                carroRosa.move_direita(42);

                Semaforo_Rosa_Roxo[2].release();

                carroRosa.move_direita(43);

                Semaforo_Ciano_Rosa[0].acquire();

                carroRosa.move_direita(35);
                carroRosa.move_baixo(85);

                Semaforo_Rosa_Roxo[1].acquire();

                carroRosa.move_baixo(38);
                carroRosa.move_baixo(42);

                Semaforo_Ciano_Rosa[0].release();
                Semaforo_Rosa_Azul[0].release();

                carroRosa.move_baixo(43);
                carroRosa.move_baixo(38);
                carroRosa.move_baixo(85);
                carroRosa.move_baixo(35);
                carroRosa.move_esquerda(85);
                carroRosa.move_esquerda(38);
                carroRosa.move_esquerda(85);

                Semaforo_Rosa_Azul[1].acquire();

                carroRosa.move_esquerda(38);
                carroRosa.move_esquerda(42);

                Semaforo_Rosa_Roxo[1].release();
                Semaforo_Cinza_Rosa[1].release();

                carroRosa.move_esquerda(43);

                Semaforo_Cinza_Rosa[0].acquire();

                carroRosa.move_esquerda(35);
                carroRosa.move_cima(42);

                Semaforo_Vermelho_Rosa[0].release();

                carroRosa.move_cima(43);

                Semaforo_Rosa_Roxo[0].acquire();
                
                carroRosa.move_cima(38);
                carroRosa.move_cima(42);

                Semaforo_Cinza_Rosa[0].release();

                carroRosa.move_cima(43);

                Semaforo_Verde_Rosa[1].acquire();
                Semaforo_Ciano_Rosa[1].acquire();
               
                
                carroRosa.move_cima(38);
                carroRosa.move_cima(40);

                Semaforo_Verde_Rosa[1].release();
                Semaforo_Ciano_Rosa[1].release();
                Semaforo_Rosa_Roxo[0].release();
                Semaforo_Rosa_Azul[1].release();
                
                break;
            }

            //carro roxo
            case 6:{
                carroRoxo.move_direita(47);
                carroRoxo.move_direita(38);
                carroRoxo.move_baixo(42);

                Semaforo_Roxo_Azul[4].release();

                carroRoxo.move_baixo(43);

                Semaforo_Ciano_Roxo[0].acquire();
                Semaforo_Verde_Roxo[0].acquire();
                Semaforo_Roxo_Azul[3].acquire();

                carroRoxo.move_baixo(35);
                carroRoxo.move_direita(85);

                Semaforo_Preto_Roxo[0].acquire();
                Semaforo_Cinza_Roxo[0].acquire();
                Semaforo_Rosa_Roxo[0].acquire();
                

                carroRoxo.move_direita(35);
                carroRoxo.move_baixo(42);

                Semaforo_Ciano_Roxo[0].release();
                Semaforo_Verde_Roxo[0].release();

                carroRoxo.move_baixo(43);

                carroRoxo.move_baixo(38);
                carroRoxo.move_direita(42);

                Semaforo_Preto_Roxo[0].release();
                Semaforo_Rosa_Roxo[0].release();
                Semaforo_Roxo_Azul[3].release();

                carroRoxo.move_direita(43);

                Semaforo_Roxo_Azul[2].acquire();

                carroRoxo.move_direita(38);
                carroRoxo.move_baixo(85);
               
                Semaforo_Vermelho_Roxo[0].acquire();
                Semaforo_Rosa_Roxo[1].acquire();
                
                carroRoxo.move_baixo(38);
                carroRoxo.move_direita(42);

                Semaforo_Roxo_Azul[2].release();

                carroRoxo.move_direita(43);
                carroRoxo.move_direita(38);
                carroRoxo.move_direita(85);
                carroRoxo.move_direita(35);
                carroRoxo.move_cima(85);
                carroRoxo.move_cima(38);
                carroRoxo.move_cima(42);

                Semaforo_Cinza_Roxo[0].release();

                carroRoxo.move_cima(43);

                Semaforo_Ciano_Roxo[1].acquire();
                Semaforo_Roxo_Azul[1].acquire();

                carroRoxo.move_cima(35);
                carroRoxo.move_esquerda(42);

                Semaforo_Vermelho_Roxo[0].release();
                Semaforo_Rosa_Roxo[1].release();
            
                carroRoxo.move_esquerda(43);

                Semaforo_Cinza_Roxo[1].acquire();

                carroRoxo.move_esquerda(38);
                carroRoxo.move_cima(42);

                Semaforo_Cinza_Roxo[1].release();
                Semaforo_Ciano_Roxo[1].release();
                Semaforo_Roxo_Azul[1].release();

                carroRoxo.move_cima(43);

                Semaforo_Rosa_Roxo[2].acquire();
                Semaforo_Cinza_Roxo[2].acquire();
                Semaforo_Roxo_Azul[0].acquire();
                
                carroRoxo.move_cima(35);
                carroRoxo.move_esquerda(85);

                Semaforo_Verde_Roxo[1].acquire();

                carroRoxo.move_esquerda(38);
                carroRoxo.move_cima(42);

                Semaforo_Rosa_Roxo[2].release();
                Semaforo_Cinza_Roxo[2].release();

                carroRoxo.move_cima(43);

                Semaforo_Ciano_Roxo[2].acquire();

                carroRoxo.move_cima(38);
                carroRoxo.move_esquerda(42);

                Semaforo_Verde_Roxo[1].release();
                Semaforo_Roxo_Azul[0].release();
                
                carroRoxo.move_esquerda(43);

                Semaforo_Preto_Roxo[1].acquire();
                Semaforo_Roxo_Azul[5].acquire();

                carroRoxo.move_esquerda(35);
                carroRoxo.move_cima(42);

                Semaforo_Ciano_Roxo[2].release();

                carroRoxo.move_cima(43);

                Semaforo_Vermelho_Roxo[1].acquire();
                Semaforo_Cinza_Roxo[3].acquire();
                Semaforo_Verde_Roxo[2].acquire();

                carroRoxo.move_cima(35);
                carroRoxo.move_esquerda(42);

                Semaforo_Roxo_Azul[5].release();

                carroRoxo.move_esquerda(43);
                carroRoxo.move_esquerda(38);
                carroRoxo.move_esquerda(85);
                carroRoxo.move_esquerda(35);
                carroRoxo.move_baixo(85);

                Semaforo_Ciano_Roxo[3].acquire();
                
                carroRoxo.move_baixo(38);
                carroRoxo.move_baixo(85);

                Semaforo_Roxo_Azul[4].acquire();

                carroRoxo.move_baixo(33);
                carroRoxo.move_direita(38);

                Semaforo_Ciano_Roxo[3].release();
                Semaforo_Cinza_Roxo[3].release();
                Semaforo_Vermelho_Roxo[1].release();
                Semaforo_Preto_Roxo[1].release();
                Semaforo_Verde_Roxo[2].release();
                break;
            }

            //carro azul
            case 7:{
                carroAzul.move_baixo(47);

                Semaforo_Ciano_Azul[0].acquire();
                Semaforo_Roxo_Azul[0].acquire();
                Semaforo_Verde_Azul[3].acquire();

                carroAzul.move_baixo(38);
                carroAzul.move_baixo(42);

                Semaforo_Ciano_Azul[0].release();
                Semaforo_Verde_Azul[0].release();

                carroAzul.move_baixo(43);

                Semaforo_Rosa_Azul[0].acquire();
                Semaforo_Cinza_Azul[0].acquire();
                

                carroAzul.move_baixo(35);
                carroAzul.move_direita(42);

                Semaforo_Verde_Azul[3].release();

                carroAzul.move_direita(43);
                carroAzul.move_direita(38);
                carroAzul.move_direita(42);

                Semaforo_Roxo_Azul[0].release();

                carroAzul.move_direita(43);

                Semaforo_Vermelho_Azul[1].acquire();
                Semaforo_Ciano_Azul[1].acquire();

                carroAzul.move_direita(35);

                carroAzul.move_baixo(85);

                Semaforo_Roxo_Azul[1].acquire();

                carroAzul.move_baixo(35);
                carroAzul.move_esquerda(42);

                Semaforo_Vermelho_Azul[1].release();
                Semaforo_Rosa_Azul[0].release();

                carroAzul.move_esquerda(43);

                carroAzul.move_esquerda(38);
                carroAzul.move_esquerda(42);

                Semaforo_Roxo_Azul[1].release();

                carroAzul.move_esquerda(43);

                Semaforo_Verde_Azul[1].acquire();

                carroAzul.move_esquerda(35);
                carroAzul.move_baixo(42);

                Semaforo_Cinza_Azul[0].release();
                Semaforo_Ciano_Azul[1].release();
                Semaforo_Verde_Azul[1].release();

                carroAzul.move_baixo(43);

                Semaforo_Cinza_Azul[2].acquire();
                Semaforo_Roxo_Azul[2].acquire();
                
                carroAzul.move_baixo(38);
                carroAzul.move_baixo(85);

                Semaforo_Preto_Azul[0].acquire();
                Semaforo_Vermelho_Azul[2].acquire();
                Semaforo_Rosa_Azul[1].acquire();

                carroAzul.move_baixo(35);
                carroAzul.move_esquerda(42);

                Semaforo_Roxo_Azul[2].release();

                carroAzul.move_esquerda(43);
                carroAzul.move_esquerda(35);
                carroAzul.move_cima(42);

                Semaforo_Vermelho_Azul[2].release();

                carroAzul.move_cima(43);

                Semaforo_Roxo_Azul[3].acquire();

                carroAzul.move_cima(38);
                carroAzul.move_cima(42);

                Semaforo_Cinza_Azul[2].release();

                carroAzul.move_cima(43);

                Semaforo_Ciano_Azul[2].acquire();
                Semaforo_Verde_Azul[2].acquire();

                carroAzul.move_cima(35);
                carroAzul.move_esquerda(42);

                Semaforo_Preto_Azul[0].release();
                Semaforo_Rosa_Azul[1].release();

                carroAzul.move_esquerda(43);
                carroAzul.move_esquerda(38);
                carroAzul.move_esquerda(42);

                Semaforo_Roxo_Azul[3].release();

                carroAzul.move_esquerda(43);

                Semaforo_Vermelho_Azul[3].acquire();
                Semaforo_Cinza_Azul[4].acquire();
                Semaforo_Preto_Azul[1].acquire();

                carroAzul.move_esquerda(35);
                carroAzul.move_cima(85);

                Semaforo_Roxo_Azul[4].acquire();

                carroAzul.move_cima(35);
                carroAzul.move_direita(42);

                Semaforo_Vermelho_Azul[3].release();
                Semaforo_Cinza_Azul[4].release();
                Semaforo_Preto_Azul[1].release();
                Semaforo_Ciano_Azul[2].release();
                Semaforo_Verde_Azul[2].release();

                carroAzul.move_direita(43);
                carroAzul.move_direita(38);
                carroAzul.move_direita(42);

                Semaforo_Roxo_Azul[4].release();

                carroAzul.move_direita(43);

                Semaforo_Vermelho_Azul[0].acquire();
                Semaforo_Preto_Azul[2].acquire();
                Semaforo_Rosa_Azul[2].acquire();

                carroAzul.move_direita(35);
                carroAzul.move_cima(42);

                Semaforo_Rosa_Azul[2].release();

                carroAzul.move_cima(43);

                Semaforo_Ciano_Azul[3].acquire();
                Semaforo_Roxo_Azul[5].acquire();

                carroAzul.move_cima(38);
                carroAzul.move_cima(42);

                Semaforo_Ciano_Azul[3].release();

                carroAzul.move_cima(43);

                Semaforo_Cinza_Azul[5].acquire();
                Semaforo_Verde_Azul[0].acquire();

                carroAzul.move_cima(35);
                carroAzul.move_direita(42);

                Semaforo_Preto_Azul[2].release();
                Semaforo_Roxo_Azul[5].release();

                carroAzul.move_direita(43);
                carroAzul.move_direita(35);
                carroAzul.move_baixo(40);

                Semaforo_Vermelho_Azul[0].release();
                Semaforo_Cinza_Azul[5].release();
                break;
            }

        }
    }

    /****************************************************************
    * Metodo:iniciar_threads
    * Funcao: instancia e incia as threads
    * Parametros: void
    * Retorno: void
   ****************************************************************/
    public void iniciar_threads(){
        carroVermelho = new Carros(0, this, carro_vermelho, slider_vermelho);
        carroCinza = new Carros(1, this, carro_cinza, slider_cinza);
        carroPreto = new Carros(2, this, carro_preto, slider_preto);
        carroCiano = new Carros(3, this, carro_ciano, slider_ciano);
        carroVerde = new Carros(4, this, carro_verde, slider_verde);
        carroRosa = new Carros(5, this, carro_rosa, slider_rosa);
        carroRoxo = new Carros(6, this, carro_roxo, slider_roxo);
        carroAzul = new Carros(7, this, carro_azul, slider_azul);

        carroVermelho.start();
        carroCinza.start();
        carroPreto.start();
        carroCiano.start();
        carroVerde.start();
        carroRosa.start();
        carroRoxo.start();
        carroAzul.start();
    }

    @FXML
    /****************************************************************
    * Metodo: reset
    * Funcao: reseta a execucao do programa
    * Parametros: MouseEvent event - clique do mouse 
    * Retorno: void
   ****************************************************************/
    public void reset(MouseEvent event) throws IOException{

        //desativa todas as threads
        carroVermelho.desativar();
        carroCinza.desativar();
        carroPreto.desativar();
        carroCiano.desativar();
        carroVerde.desativar();
        carroRosa.desativar();
        carroRoxo.desativar();
        carroAzul.desativar();

        //chama a mesma scene
        Parent root = FXMLLoader.load(getClass().getResource("../view/fxmlPrincipal.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    /****************************************************************
     * Metodo: initialize
     * Funcao: inicializa o controlador carregando as threads e os semaforos
     * Parametros: URL location - localizacao do arquivo FXML
                   ResourceBundle resources - recursos associados ao arquivo FXML
     * Retorno: void
     ****************************************************************/
    public void initialize(URL location, ResourceBundle resources) {
        iniciar_semaforos();
        iniciar_threads();    
    }
}


    
