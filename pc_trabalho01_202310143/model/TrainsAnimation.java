/* ***************************************************************
* Autor............: Amanda Oliveira da Paz Santos
* Matricula........: 202310143
* Inicio...........: 22/03/2023
* Ultima alteracao.: 11/04/2023
* Nome.............: TrainsAnimation
* Funcao...........: Descreve as animacoes dos trens nos trilhos dentro de cada cenario possivel, 
incluindo a movimentacao e rotacao de acordo com a posicao escolhida
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
        if (tr.getImageTrem().getLayoutY() < 20 && tr.getImageTrem().getLayoutY() >= -29) {
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        } //fim do primeiro if
        else if (tr.getImageTrem().getLayoutY() < 79 && tr.getImageTrem().getLayoutY() >= 20) {
            tr.getImageTrem().setRotate(315);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do segundo if
         else if (tr.getImageTrem().getLayoutY() < 155 && tr.getImageTrem().getLayoutY() >= 79) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
           
        }//fim do terceiro if
         else if (tr.getImageTrem().getLayoutY() < 213 && tr.getImageTrem().getLayoutY() >= 155) {
            tr.getImageTrem().setRotate(45);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do quarto if 
        else if (tr.getImageTrem().getLayoutY() < 275 && tr.getImageTrem().getLayoutY() >= 213) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        } //fim do quinto if
        else if (tr.getImageTrem().getLayoutY() < 333 && tr.getImageTrem().getLayoutY() >= 275) {
            tr.getImageTrem().setRotate(315);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do sexto if
         else if (tr.getImageTrem().getLayoutY() < 413 && tr.getImageTrem().getLayoutY() >= 333) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        }//fim do setimo if
         else if (tr.getImageTrem().getLayoutY() < 469 && tr.getImageTrem().getLayoutY() >= 413) {
            tr.getImageTrem().setRotate(45);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do oitvo if
         else if (tr.getImageTrem().getLayoutY() < 550 && tr.getImageTrem().getLayoutY() >= 469) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        } //fim do nono if
        else {
            tr.getImageTrem().setLayoutX(390);
            tr.getImageTrem().setLayoutY(-29);
            tr.getImageTrem().setRotate(0);
        }//fim do else

        // Trem Blue - descendo
        if (tb.getImageTrem().getLayoutY() < 20 && tb.getImageTrem().getLayoutY() >= -29) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        } //fim do primeiro if
        else if (tb.getImageTrem().getLayoutY() < 79 && tb.getImageTrem().getLayoutY() >= 20) {
            tb.getImageTrem().setRotate(45);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        } //fim do segundo if
        else if (tb.getImageTrem().getLayoutY() < 155 && tb.getImageTrem().getLayoutY() >= 79) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setRotate(0);
        }//fim do terceiro if 
        else if (tb.getImageTrem().getLayoutY() < 213 && tb.getImageTrem().getLayoutY() >= 155) {
            tb.getImageTrem().setRotate(315);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        } //fim do quarto if
        else if (tb.getImageTrem().getLayoutY() < 275 && tb.getImageTrem().getLayoutY() >= 213) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        } //fim do quinto if
        else if (tb.getImageTrem().getLayoutY() < 333 && tb.getImageTrem().getLayoutY() >= 275) {
            tb.getImageTrem().setRotate(45);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        } //fim do sexto if
        else if (tb.getImageTrem().getLayoutY() < 413 && tb.getImageTrem().getLayoutY() >= 333) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        }//fim do setimo if 
        else if (tb.getImageTrem().getLayoutY() < 469 && tb.getImageTrem().getLayoutY() >= 413) {
            tb.getImageTrem().setRotate(315);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do oitvao if
         else if (tb.getImageTrem().getLayoutY() < 550 && tb.getImageTrem().getLayoutY() >= 469) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        }//fim do nono if
        else {
            tb.getImageTrem().setLayoutX(506);
            tb.getImageTrem().setLayoutY(-29);
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
        if (tr.getImageTrem().getLayoutY() < 20 && tr.getImageTrem().getLayoutY() >= -29) {
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        } //fim do primeiro if
        else if (tr.getImageTrem().getLayoutY() < 79 && tr.getImageTrem().getLayoutY() >= 20) {
            tr.getImageTrem().setRotate(315);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do segundo if
         else if (tr.getImageTrem().getLayoutY() < 155 && tr.getImageTrem().getLayoutY() >= 79) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
           
        }//fim do terceiro if
         else if (tr.getImageTrem().getLayoutY() < 213 && tr.getImageTrem().getLayoutY() >= 155) {
            tr.getImageTrem().setRotate(45);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do quarto if 
        else if (tr.getImageTrem().getLayoutY() < 275 && tr.getImageTrem().getLayoutY() >= 213) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        } //fim do quinto if
        else if (tr.getImageTrem().getLayoutY() < 333 && tr.getImageTrem().getLayoutY() >= 275) {
            tr.getImageTrem().setRotate(315);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do sexto if
         else if (tr.getImageTrem().getLayoutY() < 413 && tr.getImageTrem().getLayoutY() >= 333) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        }//fim do setimo if
         else if (tr.getImageTrem().getLayoutY() < 469 && tr.getImageTrem().getLayoutY() >= 413) {
            tr.getImageTrem().setRotate(45);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do oitvo if
         else if (tr.getImageTrem().getLayoutY() < 550 && tr.getImageTrem().getLayoutY() >= 469) {
            tr.getImageTrem().setRotate(0);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() + tr.getSpeedY());
        } //fim do nono if
        else {
            tr.getImageTrem().setLayoutX(390);
            tr.getImageTrem().setLayoutY(-29);
            tr.getImageTrem().setRotate(0);
        }//fim do else

        // Trem Blue - Subindo
        if (tb.getImageTrem().getLayoutY() <= 523 && tb.getImageTrem().getLayoutY() > 470) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        } //fim do primeiro if 
        else if (tb.getImageTrem().getLayoutY() <= 470 && tb.getImageTrem().getLayoutY() > 410) {
            tb.getImageTrem().setRotate(135);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        }//fim do segundo if  
        else if (tb.getImageTrem().getLayoutY() <= 410 && tb.getImageTrem().getLayoutY() > 340) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        }//fim do terceiro if  
        else if (tb.getImageTrem().getLayoutY() <= 340 && tb.getImageTrem().getLayoutY() > 280) {
            tb.getImageTrem().setRotate(225);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do quarto if  
        else if (tb.getImageTrem().getLayoutY() <= 280 && tb.getImageTrem().getLayoutY() > 215) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        }//fim do quinto if 
        else if (tb.getImageTrem().getLayoutY() <= 215 && tb.getImageTrem().getLayoutY() > 156) {
            tb.getImageTrem().setRotate(135);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        }//fim do sexto if 

        else if (tb.getImageTrem().getLayoutY() <= 156 && tb.getImageTrem().getLayoutY() > 80) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());

        }//fim do setimo if 

        else if (tb.getImageTrem().getLayoutY() <= 80 && tb.getImageTrem().getLayoutY() > 25) {
            tb.getImageTrem().setRotate(225);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do oitavo if 

        else if (tb.getImageTrem().getLayoutY() <= 25 && tb.getImageTrem().getLayoutY() > -47) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());

        }//fim do nono if 
        else {
            tb.getImageTrem().setLayoutX(506);
            tb.getImageTrem().setLayoutY(523);
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
        if (tb.getImageTrem().getLayoutY() < 20 && tb.getImageTrem().getLayoutY() >= -29) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        } //fim do primeiro if
        else if (tb.getImageTrem().getLayoutY() < 79 && tb.getImageTrem().getLayoutY() >= 20) {
            tb.getImageTrem().setRotate(45);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        } //fim do segundo if
        else if (tb.getImageTrem().getLayoutY() < 155 && tb.getImageTrem().getLayoutY() >= 79) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setRotate(0);
        }//fim do terceiro if 
        else if (tb.getImageTrem().getLayoutY() < 213 && tb.getImageTrem().getLayoutY() >= 155) {
            tb.getImageTrem().setRotate(315);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        } //fim do quarto if
        else if (tb.getImageTrem().getLayoutY() < 275 && tb.getImageTrem().getLayoutY() >= 213) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        } //fim do quinto if
        else if (tb.getImageTrem().getLayoutY() < 333 && tb.getImageTrem().getLayoutY() >= 275) {
            tb.getImageTrem().setRotate(45);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        } //fim do sexto if
        else if (tb.getImageTrem().getLayoutY() < 413 && tb.getImageTrem().getLayoutY() >= 333) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        }//fim do setimo if 
        else if (tb.getImageTrem().getLayoutY() < 469 && tb.getImageTrem().getLayoutY() >= 413) {
            tb.getImageTrem().setRotate(315);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do oitvao if
         else if (tb.getImageTrem().getLayoutY() < 550 && tb.getImageTrem().getLayoutY() >= 469) {
            tb.getImageTrem().setRotate(0);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() + tb.getSpeedY());
        }//fim do nono if
        else {
            tb.getImageTrem().setLayoutX(506);
            tb.getImageTrem().setLayoutY(-29);
            tb.getImageTrem().setRotate(0);
        }//fim do else 


        // Trem Red - Subindo
        if (tr.getImageTrem().getLayoutY() <= 523 && tr.getImageTrem().getLayoutY() > 470) {
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        } //fim do primeiro if 
        else if (tr.getImageTrem().getLayoutY() <= 470 && tr.getImageTrem().getLayoutY() > 410) {
            tr.getImageTrem().setRotate(225);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        } //fim do segundo if 
        else if (tr.getImageTrem().getLayoutY() <= 410 && tr.getImageTrem().getLayoutY() > 340) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        } //fim do terceiro if 
        else if (tr.getImageTrem().getLayoutY() <= 340 && tr.getImageTrem().getLayoutY() > 280) {
            tr.getImageTrem().setRotate(135);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        } //fim do quarto if 
        else if (tr.getImageTrem().getLayoutY() <= 280 && tr.getImageTrem().getLayoutY() > 215) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        }//fim do quinto if 
        else if (tr.getImageTrem().getLayoutY() <= 215 && tr.getImageTrem().getLayoutY() > 156) {
            tr.getImageTrem().setRotate(225);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do sexto if 
        else if (tr.getImageTrem().getLayoutY() <= 156 && tr.getImageTrem().getLayoutY() > 80) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        }//fim do setimo if 
        else if (tr.getImageTrem().getLayoutY() <= 133 && tr.getImageTrem().getLayoutY() > 22) {
            tr.getImageTrem().setRotate(135);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do oitavo if 
        else if (tr.getImageTrem().getLayoutY() <= 22 && tr.getImageTrem().getLayoutY() > -47) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        }//fim do nono if 
        else {
            tr.getImageTrem().setLayoutX(390);
            tr.getImageTrem().setLayoutY(523);
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
        if (tr.getImageTrem().getLayoutY() <= 523 && tr.getImageTrem().getLayoutY() > 470) {
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        } //fim do primeiro if 
        else if (tr.getImageTrem().getLayoutY() <= 470 && tr.getImageTrem().getLayoutY() > 410) {
            tr.getImageTrem().setRotate(225);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        } //fim do segundo if 
        else if (tr.getImageTrem().getLayoutY() <= 410 && tr.getImageTrem().getLayoutY() > 340) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        } //fim do terceiro if 
        else if (tr.getImageTrem().getLayoutY() <= 340 && tr.getImageTrem().getLayoutY() > 280) {
            tr.getImageTrem().setRotate(135);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        } //fim do quarto if 
        else if (tr.getImageTrem().getLayoutY() <= 280 && tr.getImageTrem().getLayoutY() > 215) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        }//fim do quinto if 
        else if (tr.getImageTrem().getLayoutY() <= 215 && tr.getImageTrem().getLayoutY() > 156) {
            tr.getImageTrem().setRotate(225);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() + tr.getSpeedX());
        }//fim do sexto if 
        else if (tr.getImageTrem().getLayoutY() <= 156 && tr.getImageTrem().getLayoutY() > 80) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        }//fim do setimo if 
        else if (tr.getImageTrem().getLayoutY() <= 133 && tr.getImageTrem().getLayoutY() > 22) {
            tr.getImageTrem().setRotate(135);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
            tr.getImageTrem().setLayoutX(tr.getImageTrem().getLayoutX() - tr.getSpeedX());
        }//fim do oitavo if 
        else if (tr.getImageTrem().getLayoutY() <= 22 && tr.getImageTrem().getLayoutY() > -47) {
            tr.getImageTrem().setRotate(180);
            tr.getImageTrem().setLayoutY(tr.getImageTrem().getLayoutY() - tr.getSpeedY());
        }//fim do nono if 
        else {
            tr.getImageTrem().setLayoutX(390);
            tr.getImageTrem().setLayoutY(523);
            tr.getImageTrem().setRotate(180);
        }//fim do else


        // Trem Blue - Subindo
        if (tb.getImageTrem().getLayoutY() <= 523 && tb.getImageTrem().getLayoutY() > 470) {
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        } //fim do primeiro if 
        else if (tb.getImageTrem().getLayoutY() <= 470 && tb.getImageTrem().getLayoutY() > 410) {
            tb.getImageTrem().setRotate(135);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        }//fim do segundo if  
        else if (tb.getImageTrem().getLayoutY() <= 410 && tb.getImageTrem().getLayoutY() > 340) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        }//fim do terceiro if  
        else if (tb.getImageTrem().getLayoutY() <= 340 && tb.getImageTrem().getLayoutY() > 280) {
            tb.getImageTrem().setRotate(225);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do quarto if  
        else if (tb.getImageTrem().getLayoutY() <= 280 && tb.getImageTrem().getLayoutY() > 215) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
        }//fim do quinto if 
        else if (tb.getImageTrem().getLayoutY() <= 215 && tb.getImageTrem().getLayoutY() > 156) {
            tb.getImageTrem().setRotate(135);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() - tb.getSpeedX());
        }//fim do sexto if 

        else if (tb.getImageTrem().getLayoutY() <= 156 && tb.getImageTrem().getLayoutY() > 80) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());

        }//fim do setimo if 

        else if (tb.getImageTrem().getLayoutY() <= 80 && tb.getImageTrem().getLayoutY() > 25) {
            tb.getImageTrem().setRotate(225);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());
            tb.getImageTrem().setLayoutX(tb.getImageTrem().getLayoutX() + tb.getSpeedX());
        }//fim do oitavo if 

        else if (tb.getImageTrem().getLayoutY() <= 25 && tb.getImageTrem().getLayoutY() > -47) {
            tb.getImageTrem().setRotate(180);
            tb.getImageTrem().setLayoutY(tb.getImageTrem().getLayoutY() - tb.getSpeedY());

        }//fim do nono if 
        else {
            tb.getImageTrem().setLayoutX(506);
            tb.getImageTrem().setLayoutY(523);
            tb.getImageTrem().setRotate(180);
        }//fim do else
    }
    }


