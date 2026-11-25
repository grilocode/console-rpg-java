package model.personagens;

import enums.ClassePersonagem;
import enums.TipoDano;
import model.enemies.Inimigo;

public class Cavaleiro extends Personagem {

    // Construtor
    public Cavaleiro() {
        super("Cavaleiro", ClassePersonagem.CAVALEIRO, 150, 150, 12, 20, 10);
    }

    // Progressão de nível
    @Override
    public void subirNivel() {
        while (getExperiencia() >= getExperienciaNecessaria()) {
            double experienciaNecessaria = getExperienciaNecessaria();

            setNivel(getNivel() + 1);
            setVidaMaxima(getVidaMaxima() + 25);
            setVida(getVida() + 25);
            setDano(getDano() + 2);

            setExperiencia(getExperiencia() - experienciaNecessaria);
        }
    }

    // Habilidades especiais
    public int valentia(Inimigo inimigo) {
        if (inimigo == null) {
            throw new IllegalArgumentException("O alvo não pode ser nulo.");
        }

        int dano = getDano() * 2;

        return inimigo.receberDano(dano, TipoDano.FISICO);
    }
}