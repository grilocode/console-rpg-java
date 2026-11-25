package model.personagens;

import enums.ClassePersonagem;
import enums.TipoDano;
import model.enemies.Inimigo;

public abstract class Personagem {

    // Atributos de identificação
    private String nome;
    private final ClassePersonagem classePersonagem;

    // Atributos de progressão
    private int nivel = 1;
    private double experiencia;

    // Atributos de combate
    private int vida;
    private int vidaMaxima;
    private int dano;
    private int defesa;
    private int resistencia;

    // Construtor
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

    // Getters e setters de identificação
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
        }
    }

    public ClassePersonagem getClasse() {
        return classePersonagem;
    }

    public ClassePersonagem getClassePersonagem() {
        return classePersonagem;
    }

    // Getters e setters de progressão
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

    public double getExperienciaNecessaria() {
        return Math.pow(1.5, getNivel() - 1) * 100;
    }

    // Getters e setters de combate
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida >= 0 && vida <= vidaMaxima) {
            this.vida = vida;
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

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        if (dano >= 0) {
            this.dano = dano;
        }
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

    // Métodos de combate
    public int atacar(Inimigo inimigo) {
        return inimigo.receberDano(getDano(), TipoDano.FISICO);
    }

    public int receberDano(int dano, TipoDano tipoDano) {
        int danoRecebido = 0;

        if (tipoDano == TipoDano.FISICO) {
            danoRecebido = Math.max(0, dano - defesa);
        } else if (tipoDano == TipoDano.MAGICO) {
            danoRecebido = Math.max(0, dano - resistencia);
        }

        int vidaAtual = Math.max(0, vida - danoRecebido);
        setVida(vidaAtual);

        return vidaAtual;
    }

    // Progressão de nível
    public abstract void subirNivel();

    // Representação textual
    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", classePersonagem=" + classePersonagem +
                ", nivel=" + nivel +
                ", experiencia=" + experiencia +
                ", vida=" + vida +
                ", vidaMaxima=" + vidaMaxima +
                ", dano=" + dano +
                ", defesa=" + defesa +
                ", resistencia=" + resistencia +
                '}';
    }
}