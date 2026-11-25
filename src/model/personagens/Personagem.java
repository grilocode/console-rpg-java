package model.personagens;

import enums.ClassePersonagem;
import enums.TipoDano;
import model.enemies.Inimigo;

public abstract class Personagem {
    private String nome;
    private int vida;
    private int dano;
    private int nivel = 1;
    private double experiencia;
    private ClassePersonagem classePersonagem;
    private int vidaMaxima;
    private int defesa;
    private int resistencia;


    public Personagem(String nome, int vida, int dano, ClassePersonagem classePersonagem, int vidaMaxima, int defesa, int resistencia) {

        if (vidaMaxima <= 0) {
            throw new IllegalArgumentException("A vida máxima deve ser maior que zero.");
        }

        if (vida < 0 || vida > vidaMaxima) {
            throw new IllegalArgumentException("A vida deve estar entre zero e a vida máxima.");
        }

        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.classePersonagem = classePersonagem;
        this.vidaMaxima = vidaMaxima;
        this.defesa = defesa;
        this.resistencia = resistencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida >= 0 && vida <= vidaMaxima) {
            this.vida = vida;
        }
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        if (dano >= 0) {
            this.dano = dano;
        }
    }

    public ClassePersonagem getClasse() {
        return classePersonagem;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel >= 1) {
            this.nivel = nivel;
        }
    }

    public double getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(double experiencia) {
        if (experiencia >= 0) {
            this.experiencia = experiencia;
        }
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        if (vidaMaxima > 0 && vidaMaxima >= this.vida) {
            this.vidaMaxima = vidaMaxima;
        }
    }

    public ClassePersonagem getClassePersonagem() {
        return classePersonagem;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int atacar(Inimigo inimigo) {
        return inimigo.receberDano(getDano(), TipoDano.FISICO);
    }

    public int receberDano(int dano, TipoDano tipo) {
        int danoRecebido = 0;

        if (tipo == TipoDano.FISICO){
            danoRecebido = Math.max(0, dano - defesa);
        }
        if (tipo == TipoDano.MAGICO){
            danoRecebido = Math.max(0, dano - resistencia);
        }

        int vidaAtual = Math.max(0, vida - danoRecebido);
        setVida(vidaAtual);

        return vidaAtual;
    }

    public abstract void subirNivel();

    public double getExperienciaNecessaria(){
        return Math.pow(1.5, getNivel() - 1) * 100;

    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", vida=" + vida +
                ", dano=" + dano +
                ", nivel=" + nivel +
                ", experiencia=" + experiencia +
                ", classePersonagem=" + classePersonagem +
                ", vidaMaxima=" + vidaMaxima +
                '}';
    }
}
