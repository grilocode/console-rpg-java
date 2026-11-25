package model.enemies;

import enums.ClasseInimigo;
import enums.TipoDano;
import model.personagens.Personagem;

public abstract class Inimigo {

    // Atributos de identificação
    private final String nome;
    private final ClasseInimigo classeInimigo;

    // Atributos de combate
    private int vida;
    private int dano;
    private int defesa;
    private int resistencia;

    // Atributos de recompensa
    private int experienciaDrop;
    private int ouroDrop;

    // Construtor
    public Inimigo(
            String nome,
            ClasseInimigo classeInimigo,
            int vida,
            int dano,
            int defesa,
            int resistencia,
            int experienciaDrop,
            int ouroDrop
    ) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        if (classeInimigo == null) {
            throw new IllegalArgumentException("A classe não pode ser nula.");
        }

        if (vida < 0) {
            throw new IllegalArgumentException("A vida não pode ser negativa.");
        }

        if (dano < 0 || defesa < 0 || resistencia < 0) {
            throw new IllegalArgumentException("Dano, defesa e resistência não podem ser negativos.");
        }

        if (experienciaDrop < 0 || ouroDrop < 0) {
            throw new IllegalArgumentException("Experiência e ouro dropados não podem ser negativos.");
        }

        this.nome = nome;
        this.classeInimigo = classeInimigo;
        this.vida = vida;
        this.dano = dano;
        this.defesa = defesa;
        this.resistencia = resistencia;
        this.experienciaDrop = experienciaDrop;
        this.ouroDrop = ouroDrop;
    }

    // Getters e setters de identificação
    public String getNome() {
        return nome;
    }

    public ClasseInimigo getClasseInimigo() {
        return classeInimigo;
    }

    // Getters e setters de combate
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            throw new IllegalArgumentException("A vida não pode ser negativa.");
        }

        this.vida = vida;
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

    // Getters e setters de recompensa
    public int getExperienciaDrop() {
        return experienciaDrop;
    }

    public void setExperienciaDrop(int experienciaDrop) {
        if (experienciaDrop < 0) {
            throw new IllegalArgumentException("A experiência dropada não pode ser negativa.");
        }

        this.experienciaDrop = experienciaDrop;
    }

    public int getOuroDrop() {
        return ouroDrop;
    }

    public void setOuroDrop(int ouroDrop) {
        if (ouroDrop < 0) {
            throw new IllegalArgumentException("O ouro dropado não pode ser negativo.");
        }

        this.ouroDrop = ouroDrop;
    }

    // Métodos de combate
    public int atacar(Personagem personagem) {
        if (personagem == null) {
            throw new IllegalArgumentException("O alvo não pode ser nulo.");
        }

        return personagem.receberDano(getDano(), TipoDano.FISICO);
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
}
