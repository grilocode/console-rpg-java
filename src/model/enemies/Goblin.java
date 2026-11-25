package model.enemies;

import enums.ClasseInimigo;
import model.Jogador;

public class Goblin extends Inimigo {

    // Construtor
    public Goblin() {
        super("Goblin", ClasseInimigo.GOBLIN, 60, 22, 5, 2, 30, 10);
    }

    // Habilidades especiais
    public int roubo(Jogador jogador) {
        if (jogador == null) {
            throw new IllegalArgumentException("O jogador não pode ser nulo.");
        }

        int ouroRoubo = Math.min(jogador.getOuro(), 10);
        int quantidadeOuro = jogador.getOuro() - ouroRoubo;

        jogador.setOuro(quantidadeOuro);

        return ouroRoubo;
    }
}
