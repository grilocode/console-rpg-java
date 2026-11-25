package model.personagens;

import enums.ClassePersonagem;
import enums.TipoDano;
import model.enemies.Inimigo;

public class Mago extends Personagem {

    // Atributos específicos do Mago
    private int mana = 100;
    private int manaMaxima = 100;

    // Construtor
    public Mago() {
        super("Mago", 70, 25, ClassePersonagem.MAGO, 70, 5, 20);
    }

    // Getters e Setters
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana >= 0 && mana <= manaMaxima) {
            this.mana = mana;
        }
    }

    public int getManaMaxima() {
        return manaMaxima;
    }

    public void setManaMaxima(int manaMaxima) {
        if (manaMaxima <= 0 || mana > manaMaxima) {
            throw new IllegalArgumentException("A mana máxima deve ser positiva e não pode ser menor que a mana atual.");
        }

        this.manaMaxima = manaMaxima;
    }

    // Evolução de nível
    @Override
    public void subirNivel() {
        while (getExperiencia() >= getExperienciaNecessaria()) {
            double experienciaNecessaria = getExperienciaNecessaria();

            setNivel(getNivel() + 1);
            setVidaMaxima(getVidaMaxima() + 10);
            setVida(getVida() + 10);
            setDano(getDano() + 5);
            setManaMaxima(getManaMaxima() + 30);
            setMana(getMana() + 30);

            setExperiencia(getExperiencia() - experienciaNecessaria);
        }
    }

    // Habilidade especial: Bola de Fogo
    public int bolaDeFogo(Inimigo inimigo) {
        if (getMana() < 30) {
            return -1;
        }

        setMana(getMana() - 30);
        int dano = getDano() * 3;

        return inimigo.receberDano(dano, TipoDano.MAGICO);
    }
}