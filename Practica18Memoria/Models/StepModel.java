package Practica18Memoria.Models;

public class StepModel {
    public int paso;
    public String pagina;
    public String[] marcos;
    public boolean fallo;

    public StepModel(int paso, String pagina, String[] marcos, boolean fallo) {
        this.paso = paso;
        this.pagina = pagina;
        this.marcos = marcos;
        this.fallo = fallo;
    }

    public int getPaso(){
        return paso;
    }
    void setPaso(int paso){
        paso = this.paso;
    }

    public String getPagina(){
        return pagina;
    }
    void setPagina(String pagina){
        pagina = this.pagina;
    }

    public String[] getMarcos(){
        return marcos;
    }
    void setMarcos(String[] marcos){
        marcos = this.marcos;
    }

    public boolean getFallo(){
        return fallo;
    }
    void setFallo(boolean fallo){
        fallo = this.fallo;
    }
}