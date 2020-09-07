package Enums;

public enum TamanhoRoupa {
    P(1),
    M(2),
    G(3),
    GG(4);

    private final int valor;

    TamanhoRoupa(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}

