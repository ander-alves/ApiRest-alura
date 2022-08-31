package com.alves.financa.config;

public class ErrorInput {
    private  String campo;
    private  String erro;

    public ErrorInput(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
