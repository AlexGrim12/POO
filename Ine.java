public class Voto {
    private int INE = null;
    private boolean puedeVotar = null;

    Voto() {
        this.puedeVotar = existenciaINE();
    }

    private boolean existenciaINE() {
        return (PADRON.contains(INE) ? true : false);
    }
    public boolean getPuedeVotar() {
        return puedeVotar;
    }
}

public class Elecciones{
    public static void main(String[] args) {
        Voto miVoto = new Voto();
        boolean regresar = false;

        do{
            if(miVoto.getPuedeVotar()){
                emitirVoto();
            }else if(verificarCausa()){
                emitirVoto();
            }else{
                regresar = invalidezVoto();
                
            }
        }while(regresar);
    }
}