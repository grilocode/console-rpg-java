package model.personagens;

import enums.ClassePersonagem;
import enums.TipoDano;
import model.enemies.Inimigo;

public abstract class Personagem {

    // Atributos de identificação
    private final String nome;
    private final ClassePersonagem classePersonagem;

    // Atributos de progressão
    private int nivel = 1;
    private double experiencia;

    // Atributos de combate
    private int vidaMaxima;
    private int vida;
    private int dano;
    private int defesa;
    private int resistencia;

    // Construtor
    public Personagem(
            String nome,
            ClassePersonagem classePersonagem,
            int vidaMaxima,
            int vida,
            int dano,
            int defesa,
            int resistencia
    ) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        if (classePersonagem == null) {
            throw new IllegalArgumentException("A classe não pode ser nula.");
        }

        if (vidaMaxima <= 0) {
            throw new IllegalArgumentException("A vida máxima deve ser maior que zero.");
        }

        if (vida < 0 || vida > vidaMaxima) {
            throw new IllegalArgumentException("A vida deve estar entre zero e a vida máxima.");
        }

        if (dano < 0 || defesa < 0 || resistencia < 0) {
            throw new IllegalArgumentException("Dano, defesa e resistência não podem ser negativos.");
        }

        this.nome = nome;
        this.classePersonagem = classePersonagem;
        this.vidaMaxima = vidaMaxima;
        this.vida = vida;
        this.dano = dano;
        this.defesa = defesa;
        this.resistencia = resistencia;
    }

    // Getters e setters de identificação
    public String getNome() {
        return nome;
    }

    public ClassePersonagem getClassePersonagem() {
        return classePersonagem;
    }

    // Getters e setters de progressão
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel < 1) {
            throw new IllegalArgumentException("O nível deve ser maior ou igual a um.");
        }

        this.nivel = nivel;
    }

    public double getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(double experiencia) {
        if (experiencia < 0) {
            throw new IllegalArgumentException("A experiência não pode ser negativa.");
        }

        this.experiencia = experiencia;
    }

    public double getExperienciaNecessaria() {
        return Math.pow(1.5, getNivel() - 1) * 100;
    }

    // Getters e setters de combate
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida < 0 || vida > vidaMaxima) {
            throw new IllegalArgumentException("A vida deve estar entre zero e a vida máxima.");
        }

        this.vida = vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        if (vidaMaxima <= 0 || vidaMaxima < vida) {
            throw new IllegalArgumentException("A vida máxima deve ser positiva e não pode ser menor que a vida atual.");
        }

        this.vidaMaxima = vidaMaxima;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("O dano não pode ser negativo.");
        }

        this.dano = dano;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        if (defesa < 0) {
            throw new IllegalArgumentException("A defesa não pode ser negativa.");
        }

        this.defesa = defesa;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        if (resistencia < 0) {
            throw new IllegalArgumentException("A resistência não pode ser negativa.");
        }

        this.resistencia = resistencia;
    }

    // Métodos de combate
    public int atacar(Inimigo inimigo) {
        if (inimigo == null) {
            throw new IllegalArgumentException("O alvo não pode ser nulo.");
        }

        return inimigo.receberDano(getDano(), TipoDano.FISICO);
    }

    public int receberDano(int dano, TipoDano tipoDano) {
        if (dano < 0) {
            throw new IllegalArgumentException("O dano recebido não pode ser negativo.");
        }

        if (tipoDano == null) {
            throw new IllegalArgumentException("O tipo de dano não pode ser nulo.");
        }

        if (!estaVivo()) {
            return getVida();
        }

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

    // Verificação de estado
    public boolean estaVivo() {
        return getVida() > 0;
    }

    // Progressão de nível
    public abstract void subirNivel();

    // Representação textual
    @Override
    public String toString() {
        return "\n========== FICHA DO PERSONAGEM ==========\n" +
                "Nome:          " + nome + "\n" +
                "Classe:        " + classePersonagem + "\n" +
                "Nível:         " + nivel + "\n" +
                "Experiência:   " + experiencia + "\n" +
                "\n--------------- ATRIBUTOS ---------------\n" +
                "Vida:          " + vida + " / " + vidaMaxima + "\n" +
                "Dano:          " + dano + "\n" +
                "Defesa:        " + defesa + "\n" +
                "Resistência:   " + resistencia + "\n" +
                "==========================================";
    }
}
