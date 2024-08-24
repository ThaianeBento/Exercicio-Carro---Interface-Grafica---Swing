package Model;

public class Carro {
    private String placa;
    private String marca;
    private String modelo;
    
    public Carro(String placa, String marca, String modelo){
     this.placa = placa;
     this.marca = marca;
     this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean setPlaca(String placa) {
        if(placa.isBlank() && placa.length()!= 7){
        return false;
        }
        this.placa = placa;
        return true;
    }

    public String getMarca() {
        return marca;
    }

    public boolean setMarca(String marca) {
        if(!marca.isBlank()){
            this.marca = marca;
            return true;
        }
        return false;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean setModelo(String modelo) {
        if(!modelo.isBlank()){
            return false;
        }
        this.modelo = modelo;
        return true;
    }

    @Override
    public String toString() {
        return "Carro:" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + '.';
    }
    
    
}
