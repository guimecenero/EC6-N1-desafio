public enum CoresRoupa {
    AZUL(1),
    VERMELHO(2),
    AMARELO(3),
    VERDE(4),
    ROXO(5),
    PRETO(6),
    BRANCO(7);

    private final int valor;

    CoresRoupa(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return valor;
    }
}
