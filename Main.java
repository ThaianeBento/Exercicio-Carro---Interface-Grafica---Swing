
import Controller.ListaCarros;
import View.viewCarro;
import Model.Carro;

public class Main {
     public static void main(String[] args) {
        ListaCarros controller = new ListaCarros();
        viewCarro  control = new viewCarro(controller);
        control.exibirMenu();
    }
}
