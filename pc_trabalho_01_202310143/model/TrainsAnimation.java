/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 22/03/2023
* Ultima alteracao.: 31/03/2023
* Nome.............: TrainsAnimation
* Funcao...........: Descreve as animacoes dos trens nos trilhos dentro de cada cenario possivel, 
incluindo a movimentação e rotação de acordo com a posicao
****************************************************************/


package model;

public class TrainsAnimation {

    /*
   * ***************************************************************
   * Metodo: animacao1
   * Funcao: determina como os trens irao se comportar no cenario 1
   * Parametros: Trains - trens vermelho e azul
   * Retorno: void
   */
    public void animacao1(Trains tr, Trains tb) {

        // Trem Red - descendo
        if (tr.getImageTrem().getLayoutY() < 40 && tr.getImageTrem().getLayoutY() >= -32) {
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        } //fim do primeiro if
        else if (tr.getImageTrem().getLayoutY() < 125 && tr.getImageTrem().getLayoutY() >= 27) {
            tr.getImageTrem().setRotate(315);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do segundo if
         else if (tr.getImageTrem().getLayoutY() < 233 && tr.getImageTrem().getLayoutY() >= 125) {
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setRotate(0);
        }//fim do terceiro if
         else if (tr.getImageTrem().getLayoutY() < 320 && tr.getImageTrem().getLayoutY() >= 233) {
            tr.getImageTrem().setRotate(45);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do quarto if 
        else if (tr.getImageTrem().getLayoutY() < 415 && tr.getImageTrem().getLayoutY() >= 320) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        } //fim do quinto if
        else if (tr.getImageTrem().getLayoutY() < 500 && tr.getImageTrem().getLayoutY() >= 415) {
            tr.getImageTrem().setRotate(315);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do sexto if
         else if (tr.getImageTrem().getLayoutY() < 610 && tr.getImageTrem().getLayoutY() >= 500) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        }//fim do setimo if
         else if (tr.getImageTrem().getLayoutY() < 690 && tr.getImageTrem().getLayoutY() >= 610) {
            tr.getImageTrem().setRotate(45);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do oitvo if
         else if (tr.getImageTrem().getLayoutY() < 780 && tr.getImageTrem().getLayoutY() >= 690) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        } //fim do nono if
        else {
            tr.getImageTrem().setLayoutX(565);
            tr.getImageTrem().setLayoutY(-32);
            tr.getImageTrem().setRotate(0);
        }//fim do else

        // Trem Blue - descendo
        if (tb.getImageTrem().getLayoutY() < 40 && tb.getImageTrem().getLayoutY() >= -32) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        } //fim do primeiro if
        else if (tb.getImageTrem().getLayoutY() < 125 && tb.getImageTrem().getLayoutY() >= 27) {
            tb.getImageTrem().setRotate(45);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        } //fim do segundo if
        else if (tb.getImageTrem().getLayoutY() < 233 && tb.getImageTrem().getLayoutY() >= 125) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setRotate(0);
        }//fim do terceiro if 
        else if (tb.getImageTrem().getLayoutY() < 320 && tb.getImageTrem().getLayoutY() >= 233) {
            tb.getImageTrem().setRotate(315);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        } //fim do quarto if
        else if (tb.getImageTrem().getLayoutY() < 415 && tb.getImageTrem().getLayoutY() >= 320) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        } //fim do quinto if
        else if (tb.getImageTrem().getLayoutY() < 500 && tb.getImageTrem().getLayoutY() >= 415) {
            tb.getImageTrem().setRotate(45);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        } //fim do sexto if
        else if (tb.getImageTrem().getLayoutY() < 610 && tb.getImageTrem().getLayoutY() >= 500) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        }//fim do setimo if 
        else if (tb.getImageTrem().getLayoutY() < 690 && tb.getImageTrem().getLayoutY() >= 610) {
            tb.getImageTrem().setRotate(315);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do oitvao if
         else if (tb.getImageTrem().getLayoutY() < 780 && tb.getImageTrem().getLayoutY() >= 690) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        }//fim do nono if
        else {
            tb.getImageTrem().setLayoutX(733);
            tb.getImageTrem().setLayoutY(-32);
            tb.getImageTrem().setRotate(0);
        }//fim do else 
    }
 /*
   * ***************************************************************
   * Metodo: animacao2
   * Funcao: determina como os trens irao se comportar no cenario 2
   * Parametros: Trains - trens vermelho e azul
   * Retorno: void
   */
    public void animacao2(Trains tr, Trains tb) {

        // Trem Red - descendo
        if (tr.getImageTrem().getLayoutY() < 40 && tr.getImageTrem().getLayoutY() >= -32) {
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        }//fim do primeiro if 
        else if (tr.getImageTrem().getLayoutY() < 125 && tr.getImageTrem().getLayoutY() >= 27) {
            tr.getImageTrem().setRotate(315);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do segundo if
         else if (tr.getImageTrem().getLayoutY() < 233 && tr.getImageTrem().getLayoutY() >= 125) {
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setRotate(0);
        } //fim do terceiro if
        else if (tr.getImageTrem().getLayoutY() < 320 && tr.getImageTrem().getLayoutY() >= 233) {
            tr.getImageTrem().setRotate(45);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do quarto if 
        else if (tr.getImageTrem().getLayoutY() < 415 && tr.getImageTrem().getLayoutY() >= 320) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        }//fim do quinto if
         else if (tr.getImageTrem().getLayoutY() < 500 && tr.getImageTrem().getLayoutY() >= 415) {
            tr.getImageTrem().setRotate(315);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do sexto if 
        else if (tr.getImageTrem().getLayoutY() < 610 && tr.getImageTrem().getLayoutY() >= 500) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        }//fim do setimo if
         else if (tr.getImageTrem().getLayoutY() < 690 && tr.getImageTrem().getLayoutY() >= 610) {
            tr.getImageTrem().setRotate(45);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do oitavo if 
        else if (tr.getImageTrem().getLayoutY() < 780 && tr.getImageTrem().getLayoutY() >= 690) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        }//fim do nono if
         else {
            tr.getImageTrem().setLayoutX(565);
            tr.getImageTrem().setLayoutY(-32);
            tr.getImageTrem().setRotate(0);
        }//fim do else

        // Trem Blue - Subindo
        if (tb.getImageTrem().getLayoutY() <= 775 && tb.getImageTrem().getLayoutY() > 705) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        } //fim do primeiro if
        else if (tb.getImageTrem().getLayoutY() <= 705 && tb.getImageTrem().getLayoutY() > 618) {
            tb.getImageTrem().setRotate(135);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        }//fim do segundo if 
        else if (tb.getImageTrem().getLayoutY() <= 618 && tb.getImageTrem().getLayoutY() > 505) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        }//fim do terceiro if
         else if (tb.getImageTrem().getLayoutY() <= 505 && tb.getImageTrem().getLayoutY() > 419) {
            tb.getImageTrem().setRotate(225);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do quarto if 
        else if (tb.getImageTrem().getLayoutY() <= 419 && tb.getImageTrem().getLayoutY() > 329) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        }//fim do quinto if
        else if (tb.getImageTrem().getLayoutY() <= 329 && tb.getImageTrem().getLayoutY() > 247) {
            tb.getImageTrem().setRotate(135);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        }//fim do sexto if

        else if (tb.getImageTrem().getLayoutY() <= 247 && tb.getImageTrem().getLayoutY() > 133) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());

        }//fim do setimo if

        else if (tb.getImageTrem().getLayoutY() <= 133 && tb.getImageTrem().getLayoutY() > 53) {
            tb.getImageTrem().setRotate(225);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do oitavo if

        else if (tb.getImageTrem().getLayoutY() <= 53 && tb.getImageTrem().getLayoutY() > -35) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());

        }//fim do nono if
        else {
            tb.getImageTrem().setLayoutX(733);
            tb.getImageTrem().setLayoutY(775);
            tb.getImageTrem().setRotate(180);
        }//fim do else

        
    }
/*
   * ***************************************************************
   * Metodo: animacao3
   * Funcao: determina como os trens irao se comportar no cenario 3
   * Parametros: Trains - trens vermelho e azul
   * Retorno: void
   */
    public void animacao3(Trains tr, Trains tb) {
        // Trem Blue - descendo
        if (tb.getImageTrem().getLayoutY() < 40 && tb.getImageTrem().getLayoutY() >= -32) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        }//fim do primeiro if 
        else if (tb.getImageTrem().getLayoutY() < 125 && tb.getImageTrem().getLayoutY() >= 27) {
            tb.getImageTrem().setRotate(45);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        }//fim do segundo if 
        else if (tb.getImageTrem().getLayoutY() < 233 && tb.getImageTrem().getLayoutY() >= 125) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setRotate(0);
        }//fim do terceiro if  
        else if (tb.getImageTrem().getLayoutY() < 320 && tb.getImageTrem().getLayoutY() >= 233) {
            tb.getImageTrem().setRotate(315);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do quarto if  
        else if (tb.getImageTrem().getLayoutY() < 415 && tb.getImageTrem().getLayoutY() >= 320) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        }//fim do quinto if  
        else if (tb.getImageTrem().getLayoutY() < 500 && tb.getImageTrem().getLayoutY() >= 415) {
            tb.getImageTrem().setRotate(45);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        }//fim do sexto if  
        else if (tb.getImageTrem().getLayoutY() < 610 && tb.getImageTrem().getLayoutY() >= 500) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        }//fim do setimo if  
        else if (tb.getImageTrem().getLayoutY() < 690 && tb.getImageTrem().getLayoutY() >= 610) {
            tb.getImageTrem().setRotate(315);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do oitavo if  
        else if (tb.getImageTrem().getLayoutY() < 780 && tb.getImageTrem().getLayoutY() >= 690) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        }//fim do nono if  
        else {
            tb.getImageTrem().setLayoutX(733);
            tb.getImageTrem().setLayoutY(-32);
            tb.getImageTrem().setRotate(0);
        }//fim do else


        // Trem Red - Subindo
        if (tr.getImageTrem().getLayoutY() <= 775 && tr.getImageTrem().getLayoutY() > 705) {
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        }//fim do primeiro if  
        else if (tr.getImageTrem().getLayoutY() <= 705 && tr.getImageTrem().getLayoutY() > 618) {
            tr.getImageTrem().setRotate(225);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do segundo if  
        else if (tr.getImageTrem().getLayoutY() <= 618 && tr.getImageTrem().getLayoutY() > 505) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        }//fim do terceiro if 
        else if (tr.getImageTrem().getLayoutY() <= 505 && tr.getImageTrem().getLayoutY() > 419) {
            tr.getImageTrem().setRotate(135);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do quarto if 
         else if (tr.getImageTrem().getLayoutY() <= 419 && tr.getImageTrem().getLayoutY() > 329) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        }//fim do quinto if 
        else if (tr.getImageTrem().getLayoutY() <= 329 && tr.getImageTrem().getLayoutY() > 247) {
            tr.getImageTrem().setRotate(225);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do sexto if 

        else if (tr.getImageTrem().getLayoutY() <= 247 && tr.getImageTrem().getLayoutY() > 133) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());

        }//fim do setimo if 

        else if (tr.getImageTrem().getLayoutY() <= 133 && tr.getImageTrem().getLayoutY() > 53) {
            tr.getImageTrem().setRotate(135);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do oitavo if 

        else if (tr.getImageTrem().getLayoutY() <= 53 && tr.getImageTrem().getLayoutY() > -35) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());

        }//fim do nono if 
        else {
            tr.getImageTrem().setLayoutX(565);
            tr.getImageTrem().setLayoutY(775);
            tr.getImageTrem().setRotate(180);
        }//fim do else

        

    }
    /*
   * ***************************************************************
   * Metodo: animacao4
   * Funcao: determina como os trens irao se comportar no cenario 4
   * Parametros: Trains - trens vermelho e azul
   * Retorno: void
   */
    public void animacao4(Trains tr, Trains tb) {
        // Trem Red - Subindo
        if (tr.getImageTrem().getLayoutY() <= 775 && tr.getImageTrem().getLayoutY() > 705) {
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        } //fim do segundo if 
        else if (tr.getImageTrem().getLayoutY() <= 705 && tr.getImageTrem().getLayoutY() > 618) {
            tr.getImageTrem().setRotate(225);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        } //fim do terceiro if 
        else if (tr.getImageTrem().getLayoutY() <= 618 && tr.getImageTrem().getLayoutY() > 505) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        } //fim do quarto if 
        else if (tr.getImageTrem().getLayoutY() <= 505 && tr.getImageTrem().getLayoutY() > 419) {
            tr.getImageTrem().setRotate(135);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        } //fim do quinto if 
        else if (tr.getImageTrem().getLayoutY() <= 419 && tr.getImageTrem().getLayoutY() > 329) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        }//fim do sexto if 
        else if (tr.getImageTrem().getLayoutY() <= 329 && tr.getImageTrem().getLayoutY() > 247) {
            tr.getImageTrem().setRotate(225);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do setimp if 

        else if (tr.getImageTrem().getLayoutY() <= 247 && tr.getImageTrem().getLayoutY() > 133) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());

        }//fim do oitvo if 

        else if (tr.getImageTrem().getLayoutY() <= 133 && tr.getImageTrem().getLayoutY() > 53) {
            tr.getImageTrem().setRotate(135);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do nono if 

        else if (tr.getImageTrem().getLayoutY() <= 53 && tr.getImageTrem().getLayoutY() > -35) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());

        }//fim do segundo if 
        else {
            tr.getImageTrem().setLayoutX(565);
            tr.getImageTrem().setLayoutY(775);
            tr.getImageTrem().setRotate(180);
        }//fim do else


        // Trem Blue - Subindo
        if (tb.getImageTrem().getLayoutY() <= 775 && tb.getImageTrem().getLayoutY() > 705) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        } //fim do primeiro if 
        else if (tb.getImageTrem().getLayoutY() <= 705 && tb.getImageTrem().getLayoutY() > 618) {
            tb.getImageTrem().setRotate(135);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        }//fim do segundo if  
        else if (tb.getImageTrem().getLayoutY() <= 618 && tb.getImageTrem().getLayoutY() > 505) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        }//fim do terceiro if  
        else if (tb.getImageTrem().getLayoutY() <= 505 && tb.getImageTrem().getLayoutY() > 419) {
            tb.getImageTrem().setRotate(225);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do quarto if  
        else if (tb.getImageTrem().getLayoutY() <= 419 && tb.getImageTrem().getLayoutY() > 329) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        }//fim do quinto if 
        else if (tb.getImageTrem().getLayoutY() <= 329 && tb.getImageTrem().getLayoutY() > 247) {
            tb.getImageTrem().setRotate(135);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        }//fim do sexto if 

        else if (tb.getImageTrem().getLayoutY() <= 247 && tb.getImageTrem().getLayoutY() > 133) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());

        }//fim do setimo if 

        else if (tb.getImageTrem().getLayoutY() <= 133 && tb.getImageTrem().getLayoutY() > 53) {
            tb.getImageTrem().setRotate(225);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do oitavo if 

        else if (tb.getImageTrem().getLayoutY() <= 53 && tb.getImageTrem().getLayoutY() > -35) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());

        }//fim do nono if 
        else {
            tb.getImageTrem().setLayoutX(733);
            tb.getImageTrem().setLayoutY(775);
            tb.getImageTrem().setRotate(180);
        }//fim do else
    }
    }


