package model.enemies;

import enums.ClasseInimigo;
import model.Jogador;
import model.personagens.Personagem;

public class Goblin extends Inimigo {
    public Goblin() {
        super("Goblin", 50, 15, 20, 20, 10, ClasseInimigo.GOBLIN);
    }

    public int roubo(Jogador jogador) {
        int ouroRoubo = jogador.getOuro() - 10;
        if (ouroRoubo < 0) {
            ouroRoubo = 0;
        }
        return ouroRoubo;
    }
}
