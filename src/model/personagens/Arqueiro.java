package model.personagens;

import enums.ClassePersonagem;
import enums.TipoDano;
import model.enemies.Inimigo;

public class Arqueiro extends Personagem {

    public Arqueiro() {
        super("Arqueiro", 100,  18, ClassePersonagem.ARQUEIRO, 100, 12, 12);
    }

    @Override
    public void subirNivel() {
        while (getExperiencia() >= getExperienciaNecessaria()) {
            double experienciaNecessaria = getExperienciaNecessaria();

            setNivel(getNivel() + 1);
            setVida(getVida() + 15);
            setDano(getDano() + 3);

            setExperiencia(getExperiencia() - experienciaNecessaria);
        }
    }

    public int chuvaDeFlechas(Inimigo inimigo) {
        TipoDano tipoDano = TipoDano.FISICO;
        int dano = (int) (getDano() * 2.5);
        return inimigo.receberDano(dano, tipoDano);
    }
}
