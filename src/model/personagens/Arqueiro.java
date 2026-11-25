package model.personagens;

import enums.ClassePersonagem;
import enums.TipoDano;
import model.enemies.Inimigo;

public class Arqueiro extends Personagem {

    // Construtor
    public Arqueiro() {
        super("Arqueiro", ClassePersonagem.ARQUEIRO, 100, 100, 18, 12, 12);
    }

    // Progressão de nível
    @Override
    public void subirNivel() {
        while (getExperiencia() >= getExperienciaNecessaria()) {
            double experienciaNecessaria = getExperienciaNecessaria();

            setNivel(getNivel() + 1);
            setVidaMaxima(getVidaMaxima() + 15);
            setVida(getVida() + 15);
            setDano(getDano() + 3);

            setExperiencia(getExperiencia() - experienciaNecessaria);
        }
    }

    // Habilidades especiais
    public int chuvaDeFlechas(Inimigo inimigo) {
        if (inimigo == null) {
            throw new IllegalArgumentException("O alvo não pode ser nulo.");
        }

        int dano = (int) (getDano() * 2.5);

        return inimigo.receberDano(dano, TipoDano.FISICO);
    }
}