package model.enemies;

import enums.ClasseInimigo;
import enums.TipoDano;
import model.personagens.Personagem;

public abstract class Inimigo {
    private String nome;
    private int vida;
    private int dano;
    private int defesa;
    private int resistencia;
    private int experienciaDrop;
    private int ouroDrop;
    private ClasseInimigo classeInimigo;

    public Inimigo(String nome, int vida, int dano, int defesa, int resistencia, int experiencia, int ouroDrop, ClasseInimigo classeInimigo) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.defesa = defesa;
        this.resistencia = resistencia;
        this.experienciaDrop = experiencia;
        this.ouroDrop = ouroDrop;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
        if (vida <= 0) {
            this.vida = 0;
        }
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
        if (dano <= 0) {
            this.dano = 0;
        }
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
        if (defesa <= 0) {
            this.defesa = 0;
        }
    }

    public int getExperienciaDrop() {
        return experienciaDrop;
    }

    public void setExperienciaDrop(int experiencia) {
        this.experienciaDrop = experiencia;
        if (experienciaDrop <= 0) {
            this.experienciaDrop = 0;
        }
    }

    public int getOuroDrop() {
        return ouroDrop;
    }

    public void setOuroDrop(int ouroDrop) {
        this.ouroDrop = ouroDrop;
        if (ouroDrop <= 0) {
            this.ouroDrop = 0;
        }
    }

    public ClasseInimigo getClasseInimigo() {
        return classeInimigo;
    }

    public void setClasseInimigo(ClasseInimigo classeInimigo) {
        this.classeInimigo = classeInimigo;
    }

    public int atacar(Personagem personagem) {
        return personagem.receberDano(getDano(), TipoDano.FISICO);
    }

    public  int receberDano(int dano, TipoDano tipo) {
        int danoRecebido = 0;

        if (tipo == TipoDano.FISICO) {
            danoRecebido = Math.max(0, dano - defesa);
        }
        if (tipo == TipoDano.MAGICO) {
            danoRecebido = Math.max(0, dano - resistencia);
        }

        int vidaAtual = Math.max(0, vida - danoRecebido);
        setVida(vidaAtual);
        return vidaAtual;
    }

    public boolean estaVivo() {
        return getVida() > 0;
    }
}
