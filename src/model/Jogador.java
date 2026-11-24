package model;

import model.personagens.Personagem;

public class Jogador {
    private Personagem personagem;
    private int ouro;

    public Jogador(Personagem personagem) {
        if (personagem != null) {
            this.personagem = personagem;
        }
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        if (ouro < 0) {
            ouro = 0;
        }
        this.ouro = ouro;
    }

    public void adicionarOuro(int ouro) {
        if(ouro < 0) {
            ouro = 0;
        }
        this.ouro += ouro;
    }
}
