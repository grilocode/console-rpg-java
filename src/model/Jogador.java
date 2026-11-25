
package model;

import model.personagens.Personagem;

public class Jogador {

    // Atributos
    private final Personagem personagem;
    private int ouro;

    // Construtor
    public Jogador(Personagem personagem) {
        if (personagem == null) {
            throw new IllegalArgumentException("O personagem não pode ser nulo.");
        }

        this.personagem = personagem;
    }

    // Getters
    public Personagem getPersonagem() {
        return personagem;
    }

    public int getOuro() {
        return ouro;
    }

    // Gerenciamento de ouro
    public void setOuro(int ouro) {
        if (ouro < 0) {
            throw new IllegalArgumentException("O ouro não pode ser negativo.");
        }

        this.ouro = ouro;
    }

    public void adicionarOuro(int ouro) {
        if (ouro < 0) {
            throw new IllegalArgumentException("A quantidade de ouro não pode ser negativa.");
        }

        this.ouro += ouro;
    }
}
