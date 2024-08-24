package Controller;

import Model.Carro;
import java.util.ArrayList;
import java.util.List;

public class ListaCarros {
    private ArrayList <Carro> carros;
    
    public ListaCarros() {
        this.carros = new ArrayList<>();  // Inicializa a lista para evitar NullPointerException
    }
    
    
    public void addCarro(Carro newCarro){
        carros.add(newCarro);
    }
    
   public void alterarCarro(String placa, String novaMarca, String novoModelo) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                carro.setMarca(novaMarca);
                carro.setModelo(novoModelo);
                return;
            }
        }
        throw new IllegalArgumentException("Carro com placa " + placa + " não encontrado.");
    }

    public Carro consultarCarro(String placa) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        throw new IllegalArgumentException("Carro com placa " + placa + " não encontrado.");
    }

    public void excluirCarro(String placa) {
        carros.removeIf(carro -> carro.getPlaca().equals(placa));
    }

    public List<Carro> listarCarros() {
        if(carros.size() >0){
        return carros;
    }
        System.out.print("Não há carros na lista");
        return null;
    }
    
}
