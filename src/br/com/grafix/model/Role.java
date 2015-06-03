package br.com.grafix.model;

/**
 * Created by Rogerio Ferracin on 03/06/2015.
 */
public enum Role {

    ADMIN("Administrador"), COMERCIAL("Comercial"),FINANCIAL("Financeiro"),PRODUCTION("Produção");

    private String descricao;

    private Role(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return this.descricao;
    }

    public static String getDescricao(Role role)
    {
        return role.toString();
    }
}
