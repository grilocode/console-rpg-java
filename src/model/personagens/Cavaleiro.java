package model.personagens;

import enums.ClassePersonagem;
import enums.TipoDano;
import model.enemies.Inimigo;

public class Cavaleiro extends Personagem {

    // Construtor
    public Cavaleiro() {
        super("Cavaleiro", 150, 12, ClassePersonagem.CAVALEIRO, 150, 20, 10);
    }

    // Evolução de nível
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

    // Habilidade especial: Valentia
    public int valentia(Inimigo inimigo) {
        TipoDano tipoDano = TipoDano.FISICO;
        int dano = getDano() * 2;
        return inimigo.receberDano(dano, tipoDano);
    }
}